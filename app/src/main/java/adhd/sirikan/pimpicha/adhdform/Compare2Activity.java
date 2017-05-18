package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

public class Compare2Activity extends AppCompatActivity {
    int risk1Int,risk2Int,risk3Int;
    int cpRisk1, cpRisk2, cpRisk3;
    String idString,loginString[],genderString, ageString,date;
    String tag = "ThassIntent";
    String urlPHPString;
    String[] columnStrings, resultStrings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare2);
        getValueFromIntent();
        createListViewThass();
    }


    private void createListViewThass() {
        try {

            Log.d(tag, "ChilID ==>" + idString);
            Log.d(tag, "userID ==>" + loginString[0]);

            MyConstant myConstant = new MyConstant();
            String urlPHP = myConstant.getUrlGetChildWhereID2();
            urlPHPString = myConstant.getUrlGetTestWhereID2();
            columnStrings = myConstant.getColumnTest2();


            GetTestwhereChildAndUser2 getTestwhereChildAndUser = new GetTestwhereChildAndUser2(Compare2Activity.this);
            getTestwhereChildAndUser.execute(idString, loginString[0], urlPHP);

            String strJSON = getTestwhereChildAndUser.get();


            JSONArray jsonArray = new JSONArray(strJSON);
            String[] showDateStrings = new String[jsonArray.length()];
            final String[] idStrings = new String[jsonArray.length()];
            //final String[] snapCh1 = new String[jsonArray.length()];

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                showDateStrings[i] = jsonObject.getString("CurrentDate");
                idStrings[i] = jsonObject.getString("id");
                //snapCh1[i] = jsonObject.getString("ch1");
                // 09-5,18-5,



            } // for
            // Create ListView
            ListView listView = (ListView) findViewById(R.id.liveCompareThass);
            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(Compare2Activity.this,
                    android.R.layout.simple_list_item_1, showDateStrings);
            listView.setAdapter(stringArrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.d(tag, "id =>" + idStrings[position]);
                    try {


                        getDataWhere objGetDataWhere = new getDataWhere(Compare2Activity.this);
                        objGetDataWhere.execute("id", idStrings[position], urlPHPString);

                        String strjSoN = objGetDataWhere.get();
                        Log.d(tag, "PimJSON ==> " + strjSoN);
                        JSONArray jsonArray = new JSONArray(strjSoN);
                        resultStrings = new String[columnStrings.length];
                        JSONObject jsonObject = jsonArray.getJSONObject(0);
                        for (int i = 0; i < columnStrings.length; i++) {
                            resultStrings[i] = jsonObject.getString(columnStrings[i]);
                            Log.d(tag, "18 Result String(" + i + ") ==>" + resultStrings[i]);
                        }

                        cpRisk1 = Integer.parseInt(resultStrings[33]);
                        cpRisk2 = Integer.parseInt(resultStrings[34]);
                        cpRisk3 = Integer.parseInt(resultStrings[35]);
                        date = resultStrings[34];

                        putIntent();


                    } catch (Exception e) {
                        Log.d(tag, "e query ==>" + e.toString());
                    }

                }
            });


        } catch (Exception e) {
            Log.d(tag, "e table1 ==>" + e.toString());

        }


    }

    private void getValueFromIntent() {
        Bundle extras = getIntent().getExtras();
        risk1Int = extras.getInt("risk1");
        risk2Int = extras.getInt("risk2");
        risk3Int = extras.getInt("risk3");
        idString = getIntent().getStringExtra("idString");
        loginString = getIntent().getStringArrayExtra("loginString");
        genderString = getIntent().getStringExtra("genderString");
        ageString = getIntent().getStringExtra("ageString");
        Log.d(tag, "Put from compare ==>" + risk1Int + " " + risk2Int + " " + risk3Int);
    }

    private void putIntent(){
        Intent intent = new Intent(Compare2Activity.this,GraphCompare2Activity.class);
        intent.putExtra("Login", loginString);
        intent.putExtra("tmpIndex", idString);
        intent.putExtra("gender", genderString);
        intent.putExtra("age", ageString);
        intent.putExtra("risk1Int", risk1Int);
        intent.putExtra("risk2Int", risk2Int);
        intent.putExtra("risk3Int", risk3Int);
        intent.putExtra("cpRisk1", cpRisk1);
        intent.putExtra("cpRisk2", cpRisk2);
        intent.putExtra("cpRisk3",cpRisk3);
        intent.putExtra("date",date);
        startActivity(intent);

    }
}

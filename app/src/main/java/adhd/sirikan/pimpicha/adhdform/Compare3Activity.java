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

public class Compare3Activity extends AppCompatActivity {
    int risk1Int,cpRisk1;
    String tag = "graphSDQ";
    String idString, loginString[],genderString, ageString,date;
    String urlPHPString;
    String[] columnStrings, resultStrings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare3);
        getValueFromIntent();
        createListViewSnap();

    }
    private void createListViewSnap() {
        try {

            Log.d(tag, "ChilID ==>" + idString);
            Log.d(tag, "userID ==>" + loginString[0]);

            MyConstant myConstant = new MyConstant();
            String urlPHP = myConstant.getUrlGetChildWhereID3();
            urlPHPString = myConstant.getUrlGetTestWhereID3();
            columnStrings = myConstant.getColumnTest3();


            GetTestwhereChildAndUser getTestwhereChildAndUser = new GetTestwhereChildAndUser(Compare3Activity.this);
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
            ListView listView = (ListView) findViewById(R.id.liveCompareSdq);
            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(Compare3Activity.this,
                    android.R.layout.simple_list_item_1, showDateStrings);
            listView.setAdapter(stringArrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.d(tag, "id =>" + idStrings[position]);
                    try {


                        getDataWhere objGetDataWhere = new getDataWhere(Compare3Activity.this);
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

                        cpRisk1 = Integer.parseInt(resultStrings[28]);
                        date = resultStrings[31];

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

    private void putIntent(){
        Intent intent = new Intent(Compare3Activity.this,GraphCompare3Activity.class);
        intent.putExtra("Login", loginString);
        intent.putExtra("tmpIndex", idString);
        intent.putExtra("gender", genderString);
        intent.putExtra("age", ageString);
        intent.putExtra("risk1Int", risk1Int);
        intent.putExtra("cpRisk1", cpRisk1);
        intent.putExtra("date",date);
        startActivity(intent);

    }


    private void getValueFromIntent() {
        Bundle extras = getIntent().getExtras();
        risk1Int = extras.getInt("risk1Int");
        idString = getIntent().getStringExtra("idString");
        loginString = getIntent().getStringArrayExtra("loginString");
        genderString = getIntent().getStringExtra("genderString");
        ageString = getIntent().getStringExtra("ageString");
        Log.d(tag, "Put from compare ==>" + risk1Int);
    }
}

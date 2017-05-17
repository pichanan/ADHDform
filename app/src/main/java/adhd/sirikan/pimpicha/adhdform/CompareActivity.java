package adhd.sirikan.pimpicha.adhdform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.jjoe64.graphview.*;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import org.json.JSONArray;
import org.json.JSONObject;

public class CompareActivity extends AppCompatActivity {
    int risk1Int, risk2Int, risk3Int;
    int cpRisk1, cpRisk2, cpRisk3;
    String idString, loginString[], genderString, ageString, risk1, risk2, risk3,date;
    private static String tag = "30MarchV1", tag2 = "16AprilV1";
    String urlPHPString;
    String[] columnStrings, resultStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);
        getValueFromIntent();
        createListViewSnap();

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

    private void createListViewSnap() {
        try {

            Log.d(tag, "ChilID ==>" + idString);
            Log.d(tag, "userID ==>" + loginString[0]);

            MyConstant myConstant = new MyConstant();
            String urlPHP = myConstant.getUrlGetChildWhereID();
            urlPHPString = myConstant.getUrlGetTestWhereID();
            columnStrings = myConstant.getColumnTest();


            GetTestwhereChildAndUser getTestwhereChildAndUser = new GetTestwhereChildAndUser(CompareActivity.this);
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
            ListView listView = (ListView) findViewById(R.id.liveCompareSnap);
            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(CompareActivity.this,
                    android.R.layout.simple_list_item_1, showDateStrings);
            listView.setAdapter(stringArrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.d(tag, "id =>" + idStrings[position]);
                    try {


                        getDataWhere objGetDataWhere = new getDataWhere(CompareActivity.this);
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

                        cpRisk1 = Integer.parseInt(resultStrings[29]);
                        cpRisk2 = Integer.parseInt(resultStrings[30]);
                        cpRisk3 = Integer.parseInt(resultStrings[31]);
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

    private void putIntent(){
        Intent intent = new Intent(CompareActivity.this,GraphCompareActivity.class);
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

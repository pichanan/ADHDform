package adhd.sirikan.pimpicha.adhdform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class ShowChildDetail2 extends AppCompatActivity {
    private MyConstant myConstant;
    private String idString,urlPHPString;
    private String[] columnStrings,resultStrings;
    private String tag = "16AprilV5";
    String ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9, ch10, ch11,
            ch12, ch13, ch14, ch15, ch16, ch17, ch18, ch19, ch20,
            ch21, ch22, ch23, ch24, ch25, ch26,ch27,ch28,ch29,ch30;
    String risk1, risk2, risk3;

    TextView textView,textView2,spn, spn2, spn3, spn4, spn5, spn6, spn7, spn8, spn9, spn10, spn11, spn12, spn13,
            spn14, spn15, spn16, spn17, spn18, spn19, spn20, spn21, spn22, spn23, spn24, spn25, spn26
            , spn27, spn28, spn29, spn30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_child_detail2);
        mySetup();
        queryDataFromJSoN();
        findId();
    }

    private void findId() {
        spn = (TextView) findViewById(R.id.histhass1);
        spn2 = (TextView) findViewById(R.id.histhass2);
        spn3 = (TextView) findViewById(R.id.histhass3);
        spn4 = (TextView) findViewById(R.id.histhass4);
        spn5 = (TextView) findViewById(R.id.histhass5);
        spn6 = (TextView) findViewById(R.id.histhass6);
        spn7= (TextView) findViewById(R.id.histhass7);
        spn8 = (TextView) findViewById(R.id.histhass8);
        spn9 = (TextView) findViewById(R.id.histhass9);
        spn10 = (TextView) findViewById(R.id.histhass10);
        spn11 = (TextView) findViewById(R.id.histhass11);
        spn12 = (TextView) findViewById(R.id.histhass12);
        spn13 = (TextView) findViewById(R.id.histhass13);
        spn14 = (TextView) findViewById(R.id.histhass14);
        spn15 = (TextView) findViewById(R.id.histhass15);
        spn16 = (TextView) findViewById(R.id.histhass16);
        spn17 = (TextView) findViewById(R.id.histhass17);
        spn18 = (TextView) findViewById(R.id.histhass18);
        spn19 = (TextView) findViewById(R.id.histhass19);
        spn20 = (TextView) findViewById(R.id.histhass20);
        spn21 = (TextView) findViewById(R.id.histhass21);
        spn22 = (TextView) findViewById(R.id.histhass22);
        spn23 = (TextView) findViewById(R.id.histhass23);
        spn24 = (TextView) findViewById(R.id.histhass24);
        spn25 = (TextView) findViewById(R.id.histhass25);
        spn26 = (TextView) findViewById(R.id.histhass26);
        spn27 = (TextView) findViewById(R.id.histhass27);
        spn28 = (TextView) findViewById(R.id.histhass28);
        spn29 = (TextView) findViewById(R.id.histhass29);
        spn30 = (TextView) findViewById(R.id.histhass30);

        spn.setText(ch1);
        spn2.setText(ch2);
        spn3.setText(ch3);
        spn4.setText(ch4);
        spn5.setText(ch5);
        spn6.setText(ch6);
        spn7.setText(ch7);
        spn8.setText(ch8);
        spn9.setText(ch9);
        spn10.setText(ch10);
        spn11.setText(ch11);
        spn12.setText(ch12);
        spn13.setText(ch13);
        spn14.setText(ch14);
        spn15.setText(ch15);
        spn16.setText(ch16);
        spn17.setText(ch17);
        spn18.setText(ch18);
        spn19.setText(ch19);
        spn20.setText(ch20);
        spn21.setText(ch21);
        spn22.setText(ch22);
        spn23.setText(ch23);
        spn24.setText(ch24);
        spn25.setText(ch25);
        spn26.setText(ch26);
        spn27.setText(ch27);
        spn28.setText(ch28);
        spn29.setText(ch29);
        spn30.setText(ch30);
    }

    private void queryDataFromJSoN() {
        try {


            getDataWhere objGetDataWhere = new getDataWhere(ShowChildDetail2.this);
            objGetDataWhere.execute("id", idString, urlPHPString);

            String strjSoN = objGetDataWhere.get();
            Log.d(tag, "PimJSON ==> " + strjSoN);
            JSONArray jsonArray = new JSONArray(strjSoN);
            resultStrings = new String[columnStrings.length];
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            for (int i =0 ; i<columnStrings.length;i++) {
                resultStrings[i] = jsonObject.getString(columnStrings[i]);
                Log.d(tag, "Result String(" + i + ") ==>" + resultStrings[i]);
            }
            ch1 = resultStrings[1];
            ch2 = resultStrings[2];
            ch3 = resultStrings[3];
            ch4 = resultStrings[4];
            ch5 = resultStrings[5];
            ch6 = resultStrings[6];
            ch7 = resultStrings[7];
            ch8 = resultStrings[8];
            ch9 = resultStrings[9];
            ch10 = resultStrings[10];
            ch11 = resultStrings[11];
            ch12 = resultStrings[12];
            ch13 = resultStrings[13];
            ch14 = resultStrings[14];
            ch15 = resultStrings[15];
            ch16 = resultStrings[16];
            ch17 = resultStrings[17];
            ch18 = resultStrings[18];
            ch19 = resultStrings[19];
            ch20 = resultStrings[20];
            ch21 = resultStrings[21];
            ch22 = resultStrings[22];
            ch23 = resultStrings[23];
            ch24 = resultStrings[24];
            ch25 = resultStrings[25];
            ch26 = resultStrings[26];
            ch27 = resultStrings[27];
            ch28 = resultStrings[28];
            ch29 = resultStrings[29];
            ch30 = resultStrings[30];
            Log.d(tag, "30 ("  + ") ==>" + resultStrings[30]);


        } catch (Exception e) {
            Log.d(tag, "e query ==>" + e.toString());
        }
    }

    private void mySetup() {
        myConstant = new MyConstant();
        idString = getIntent().getStringExtra("id");
        columnStrings = myConstant.getColumnTest2();
        urlPHPString = myConstant.getUrlGetTestWhereID2();
    }
}

package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class ShowChildDetail3 extends AppCompatActivity {
    private MyConstant myConstant;
    ImageView ImageViewPDF;
    private String idString,urlPHPString;
    private String[] columnStrings,resultStrings;
    private String tag = "16AprilV5";
    String ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9, ch10, ch11,
            ch12, ch13, ch14, ch15, ch16, ch17, ch18, ch19, ch20,
            ch21, ch22, ch23, ch24, ch25, ch26;
    String risk1, risk2, risk3;

    TextView textView,textView2,spn, spn2, spn3, spn4, spn5, spn6, spn7, spn8, spn9, spn10, spn11, spn12, spn13,
            spn14, spn15, spn16, spn17, spn18, spn19, spn20, spn21, spn22, spn23, spn24, spn25, spn26;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_child_detail3);
        ImageViewPDF = (ImageView) findViewById(R.id.showDetailPdfSdq);
        ImageViewPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                putIt();


            }
        });

        mySetup();
        queryDataFromJSoN();
        findId();
    }

    private void putIt() {
        Intent intent = new Intent(ShowChildDetail3.this, PDF3Activity.class);
        intent.putExtra("sspn", ch1);
        intent.putExtra("sspn2", ch2);
        intent.putExtra("sspn3", ch3);
        intent.putExtra("sspn4", ch4);
        intent.putExtra("sspn5", ch5);
        intent.putExtra("sspn6", ch6);
        intent.putExtra("sspn7", ch7);
        intent.putExtra("sspn8", ch8);
        intent.putExtra("sspn9", ch9);
        intent.putExtra("sspn10", ch10);
        intent.putExtra("sspn11", ch11);
        intent.putExtra("sspn12", ch12);
        intent.putExtra("sspn13", ch13);
        intent.putExtra("sspn14", ch14);
        intent.putExtra("sspn15", ch15);
        intent.putExtra("sspn16", ch16);
        intent.putExtra("sspn17", ch17);
        intent.putExtra("sspn18", ch18);
        intent.putExtra("sspn19", ch19);
        intent.putExtra("sspn20", ch20);
        intent.putExtra("sspn21", ch21);
        intent.putExtra("sspn22", ch22);
        intent.putExtra("sspn23", ch23);
        intent.putExtra("sspn24", ch24);
        intent.putExtra("sspn25", ch25);
        /*intent.putExtra("risk1", risk1Int);
        intent.putExtra("risk2", risk2Int);
        intent.putExtra("risk3", risk3Int);
        intent.putExtra("date", date);*/
        startActivity(intent);

    }

    private void findId() {
        spn = (TextView) findViewById(R.id.hissdq1);
        spn2 = (TextView) findViewById(R.id.hissdq2);
        spn3 = (TextView) findViewById(R.id.hissdq3);
        spn4 = (TextView) findViewById(R.id.hissdq4);
        spn5 = (TextView) findViewById(R.id.hissdq5);
        spn6 = (TextView) findViewById(R.id.hissdq6);
        spn7= (TextView) findViewById(R.id.hissdq7);
        spn8 = (TextView) findViewById(R.id.hissdq8);
        spn9 = (TextView) findViewById(R.id.hissdq9);
        spn10 = (TextView) findViewById(R.id.hissdq10);
        spn11 = (TextView) findViewById(R.id.hissdq11);
        spn12 = (TextView) findViewById(R.id.hissdq12);
        spn13 = (TextView) findViewById(R.id.hissdq13);
        spn14 = (TextView) findViewById(R.id.hissdq14);
        spn15 = (TextView) findViewById(R.id.hissdq15);
        spn16 = (TextView) findViewById(R.id.hissdq16);
        spn17 = (TextView) findViewById(R.id.hissdq17);
        spn18 = (TextView) findViewById(R.id.hissdq18);
        spn19 = (TextView) findViewById(R.id.hissdq19);
        spn20 = (TextView) findViewById(R.id.hissdq20);
        spn21 = (TextView) findViewById(R.id.hissdq21);
        spn22 = (TextView) findViewById(R.id.hissdq22);
        spn23 = (TextView) findViewById(R.id.hissdq23);
        spn24 = (TextView) findViewById(R.id.hissdq24);
        spn25 = (TextView) findViewById(R.id.hissdq25);

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

    }

    private void queryDataFromJSoN() {
        try {


            getDataWhere objGetDataWhere = new getDataWhere(ShowChildDetail3.this);
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


        } catch (Exception e) {
            Log.d(tag, "e query ==>" + e.toString());
        }
    }

    private void mySetup() {
        myConstant = new MyConstant();
        idString = getIntent().getStringExtra("id");
        columnStrings = myConstant.getColumnTest3();
        urlPHPString = myConstant.getUrlGetTestWhereID3();
    }
}

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

public class ShowChildDetail extends AppCompatActivity {

    private MyConstant myConstant;
    private String idString,urlPHPString;
    private String[] columnStrings,resultStrings;
    private String tag = "16AprilV5";
    ImageView ImageViewPDF;
    String ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9, ch10, ch11,
            ch12, ch13, ch14, ch15, ch16, ch17, ch18, ch19, ch20,
            ch21, ch22, ch23, ch24, ch25, ch26;
    String risk1, risk2, risk3;

    TextView textView,textView2,spn, spn2, spn3, spn4, spn5, spn6, spn7, spn8, spn9, spn10, spn11, spn12, spn13,
            spn14, spn15, spn16, spn17, spn18, spn19, spn20, spn21, spn22, spn23, spn24, spn25, spn26;

    String sspn, sspn2, sspn3, sspn4, sspn5, sspn6, sspn7, sspn8, sspn9, sspn10, sspn11, sspn12, sspn13,
            sspn14, sspn15, sspn16, sspn17, sspn18, sspn19, sspn20, sspn21, sspn22, sspn23, sspn24, sspn25, sspn26,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_child_detail);
        ImageViewPDF = (ImageView) findViewById(R.id.showDetailPdf);
        ImageViewPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                putIt();


            }
        });

        //My setup
        mySetup();

        //Query data From JSoN
        queryDataFromJSoN();
        findId();


    }//main method

    private void findId() {
        spn = (TextView) findViewById(R.id.hisSnap1);
        spn2 = (TextView) findViewById(R.id.hisSnap2);
        spn3 = (TextView) findViewById(R.id.hisSnap3);
        spn4 = (TextView) findViewById(R.id.hisSnap4);
        spn5 = (TextView) findViewById(R.id.hisSnap5);
        spn6 = (TextView) findViewById(R.id.hisSnap6);
        spn7= (TextView) findViewById(R.id.hisSnap7);
        spn8 = (TextView) findViewById(R.id.hisSnap8);
        spn9 = (TextView) findViewById(R.id.hisSnap9);
        spn10 = (TextView) findViewById(R.id.hisSnap10);
        spn11 = (TextView) findViewById(R.id.hisSnap11);
        spn12 = (TextView) findViewById(R.id.hisSnap12);
        spn13 = (TextView) findViewById(R.id.hisSnap13);
        spn14 = (TextView) findViewById(R.id.hisSnap14);
        spn15 = (TextView) findViewById(R.id.hisSnap15);
        spn16 = (TextView) findViewById(R.id.hisSnap16);
        spn17 = (TextView) findViewById(R.id.hisSnap17);
        spn18 = (TextView) findViewById(R.id.hisSnap18);
        spn19 = (TextView) findViewById(R.id.hisSnap19);
        spn20 = (TextView) findViewById(R.id.hisSnap20);
        spn21 = (TextView) findViewById(R.id.hisSnap21);
        spn22 = (TextView) findViewById(R.id.hisSnap22);
        spn23 = (TextView) findViewById(R.id.hisSnap23);
        spn24 = (TextView) findViewById(R.id.hisSnap24);
        spn25 = (TextView) findViewById(R.id.hisSnap25);
        spn26 = (TextView) findViewById(R.id.hisSnap26);

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
    }


    private void queryDataFromJSoN() {
        try {


            getDataWhere objGetDataWhere = new getDataWhere(ShowChildDetail.this);
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


        } catch (Exception e) {
            Log.d(tag, "e query ==>" + e.toString());
        }
    }

    private void mySetup() {
        myConstant = new MyConstant();
        idString = getIntent().getStringExtra("id");
        columnStrings = myConstant.getColumnTest();
        urlPHPString = myConstant.getUrlGetTestWhereID();
    }

    private void putIt() {
        Intent intent = new Intent(ShowChildDetail.this, PDFActivity.class);
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
        intent.putExtra("sspn26", ch26);
        /*intent.putExtra("risk1", risk1Int);
        intent.putExtra("risk2", risk2Int);
        intent.putExtra("risk3", risk3Int);
        intent.putExtra("date", date);*/
        startActivity(intent);

    }
}//main Class

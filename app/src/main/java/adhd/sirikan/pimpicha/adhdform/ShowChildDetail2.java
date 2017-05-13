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
    ImageView ImageViewPDF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_child_detail2);
        ImageViewPDF = (ImageView) findViewById(R.id.showDetailThassPdf);
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

    private void findId() {


        if(ch1.equals("0")){
            ch1 = "0";
            spn = (TextView) findViewById(R.id.hisThass1Choice1);
        }else if(ch1.equals("1")){
            ch1 = "1";
            spn = (TextView) findViewById(R.id.hisThass1Choice2);
        }else if(ch1.equals("2")){
            ch1 = "2";
            spn = (TextView) findViewById(R.id.hisThass1Choice3);
        }else{
            ch1 = "3";
            spn = (TextView) findViewById(R.id.hisThass1Choice4);
        }


        if(ch2.equals("0")){
            ch2 = "0";
            spn2 = (TextView) findViewById(R.id.hisThass2Choice1);
        }else if(ch2.equals("1")){
            ch2 = "1";
            spn2 = (TextView) findViewById(R.id.hisThass2Choice2);
        }else if(ch2.equals("2")){
            ch2 = "2";
            spn2 = (TextView) findViewById(R.id.hisThass2Choice3);
        }else{
            ch2 = "3";
            spn2 = (TextView) findViewById(R.id.hisThass2Choice4);
        }

        if(ch3.equals("0")){
            ch3 = "0";
            spn3 = (TextView) findViewById(R.id.hisThass3Choice1);
        }else if(ch3.equals("1")){
            ch3 = "1";
            spn3 = (TextView) findViewById(R.id.hisThass3Choice2);
        }else if(ch3.equals("2")){
            ch3 = "2";
            spn3 = (TextView) findViewById(R.id.hisThass3Choice3);
        }else{
            ch3 = "3";
            spn3 = (TextView) findViewById(R.id.hisThass3Choice4);
        }

        if(ch4.equals("0")){
            ch4 = "0";
            spn4 = (TextView) findViewById(R.id.hisThass4Choice1);
        }else if(ch4.equals("1")){
            ch4 = "1";
            spn4 = (TextView) findViewById(R.id.hisThass4Choice2);
        }else if(ch4.equals("2")){
            ch4 = "2";
            spn4 = (TextView) findViewById(R.id.hisThass4Choice3);
        }else{
            ch4 = "3";
            spn4 = (TextView) findViewById(R.id.hisThass4Choice4);
        }

        if(ch5.equals("0")){
            ch5 = "0";
            spn5 = (TextView) findViewById(R.id.hisThass5Choice1);
        }else if(ch5.equals("1")){
            ch5 = "1";
            spn5 = (TextView) findViewById(R.id.hisThass5Choice2);
        }else if(ch5.equals("2")){
            ch5 = "2";
            spn5 = (TextView) findViewById(R.id.hisThass5Choice3);
        }else{
            ch5 = "3";
            spn5 = (TextView) findViewById(R.id.hisThass5Choice4);
        }

        if(ch6.equals("0")){
            ch6 = "0";
            spn6 = (TextView) findViewById(R.id.hisThass6Choice1);
        }else if(ch6.equals("1")){
            ch6 = "1";
            spn6 = (TextView) findViewById(R.id.hisThass6Choice2);
        }else if(ch6.equals("2")){
            ch6 = "2";
            spn6 = (TextView) findViewById(R.id.hisThass6Choice3);
        }else{
            ch6 = "3";
            spn6 = (TextView) findViewById(R.id.hisThass6Choice4);
        }

        if(ch7.equals("0")){
            ch7 = "0";
            spn7 = (TextView) findViewById(R.id.hisThass7Choice1);
        }else if(ch7.equals("1")){
            ch7 = "1";
            spn7 = (TextView) findViewById(R.id.hisThass7Choice2);
        }else if(ch7.equals("2")){
            ch7 = "2";
            spn7 = (TextView) findViewById(R.id.hisThass7Choice3);
        }else{
            ch7 = "3";
            spn7 = (TextView) findViewById(R.id.hisThass7Choice4);
        }

        if(ch8.equals("0")){
            ch8 = "0";
            spn8 = (TextView) findViewById(R.id.hisThass8Choice1);
        }else if(ch8.equals("1")){
            ch8 = "1";
            spn8 = (TextView) findViewById(R.id.hisThass8Choice2);
        }else if(ch8.equals("2")){
            ch8 = "2";
            spn8 = (TextView) findViewById(R.id.hisThass8Choice3);
        }else{
            ch8 = "3";
            spn8 = (TextView) findViewById(R.id.hisThass8Choice4);
        }

        if(ch9.equals("0")){
            ch9 = "0";
            spn9 = (TextView) findViewById(R.id.hisThass9Choice1);
        }else if(ch9.equals("1")){
            ch9 = "1";
            spn9 = (TextView) findViewById(R.id.hisThass9Choice2);
        }else if(ch9.equals("2")){
            ch9 = "2";
            spn9 = (TextView) findViewById(R.id.hisThass9Choice3);
        }else{
            ch9 = "3";
            spn9 = (TextView) findViewById(R.id.hisThass9Choice4);
        }

        if(ch10.equals("0")){
            ch10 = "0";
            spn10 = (TextView) findViewById(R.id.hisThass10Choice1);
        }else if(ch10.equals("1")){
            ch10 = "1";
            spn10 = (TextView) findViewById(R.id.hisThass10Choice2);
        }else if(ch10.equals("2")){
            ch10 = "2";
            spn10 = (TextView) findViewById(R.id.hisThass10Choice3);
        }else{
            ch10 = "3";
            spn10 = (TextView) findViewById(R.id.hisThass10Choice4);
        }

        if(ch11.equals("0")){
            ch11 = "0";
            spn11 = (TextView) findViewById(R.id.hisThass11Choice1);
        }else if(ch11.equals("1")){
            ch11 = "1";
            spn11 = (TextView) findViewById(R.id.hisThass11Choice2);
        }else if(ch11.equals("2")){
            ch11 = "2";
            spn11 = (TextView) findViewById(R.id.hisThass11Choice3);
        }else{
            ch11 = "3";
            spn11 = (TextView) findViewById(R.id.hisThass11Choice4);
        }

        if(ch12.equals("0")){
            ch12 = "0";
            spn12 = (TextView) findViewById(R.id.hisThass12Choice1);
        }else if(ch12.equals("1")){
            ch12 = "1";
            spn12 = (TextView) findViewById(R.id.hisThass12Choice2);
        }else if(ch12.equals("2")){
            ch12 = "2";
            spn12 = (TextView) findViewById(R.id.hisThass12Choice3);
        }else{
            ch12 = "3";
            spn12 = (TextView) findViewById(R.id.hisThass12Choice4);
        }

        if(ch13.equals("0")){
            ch13 = "0";
            spn13 = (TextView) findViewById(R.id.hisThass13Choice1);
        }else if(ch13.equals("1")){
            ch13 = "1";
            spn13 = (TextView) findViewById(R.id.hisThass13Choice2);
        }else if(ch13.equals("2")){
            ch13 = "2";
            spn13 = (TextView) findViewById(R.id.hisThass13Choice3);
        }else{
            ch13 = "3";
            spn13 = (TextView) findViewById(R.id.hisThass13Choice4);
        }

        if(ch14.equals("0")){
            ch14 = "0";
            spn14 = (TextView) findViewById(R.id.hisThass14Choice1);
        }else if(ch14.equals("1")){
            ch14 = "1";
            spn14 = (TextView) findViewById(R.id.hisThass14Choice2);
        }else if(ch14.equals("2")){
            ch14 = "2";
            spn14 = (TextView) findViewById(R.id.hisThass14Choice3);
        }else{
            ch14 = "3";
            spn14 = (TextView) findViewById(R.id.hisThass14Choice4);
        }

        if(ch15.equals("0")){
            ch15 = "0";
            spn15 = (TextView) findViewById(R.id.hisThass15Choice1);
        }else if(ch15.equals("1")){
            ch15 = "1";
            spn15 = (TextView) findViewById(R.id.hisThass15Choice2);
        }else if(ch15.equals("2")){
            ch15 = "2";
            spn15 = (TextView) findViewById(R.id.hisThass15Choice3);
        }else{
            ch15 = "3";
            spn15 = (TextView) findViewById(R.id.hisThass15Choice4);
        }

        if(ch16.equals("0")){
            ch16 = "0";
            spn16 = (TextView) findViewById(R.id.hisThass16Choice1);
        }else if(ch16.equals("1")){
            ch16 = "1";
            spn16 = (TextView) findViewById(R.id.hisThass16Choice2);
        }else if(ch16.equals("2")){
            ch16 = "2";
            spn16 = (TextView) findViewById(R.id.hisThass16Choice3);
        }else{
            ch16 = "3";
            spn16 = (TextView) findViewById(R.id.hisThass16Choice4);
        }

        if(ch17.equals("0")){
            ch17 = "0";
            spn17 = (TextView) findViewById(R.id.hisThass17Choice1);
        }else if(ch17.equals("1")){
            ch17 = "1";
            spn17 = (TextView) findViewById(R.id.hisThass17Choice2);
        }else if(ch17.equals("2")){
            ch17 = "2";
            spn17 = (TextView) findViewById(R.id.hisThass17Choice3);
        }else{
            ch17 = "3";
            spn17 = (TextView) findViewById(R.id.hisThass17Choice4);
        }

        if(ch18.equals("0")){
            ch18 = "0";
            spn18 = (TextView) findViewById(R.id.hisThass18Choice1);
        }else if(ch18.equals("1")){
            ch18 = "1";
            spn18 = (TextView) findViewById(R.id.hisThass18Choice2);
        }else if(ch18.equals("2")){
            ch18 = "2";
            spn18 = (TextView) findViewById(R.id.hisThass18Choice3);
        }else{
            ch18 = "3";
            spn18 = (TextView) findViewById(R.id.hisThass18Choice4);
        }

        if(ch19.equals("0")){
            ch19 = "0";
            spn19 = (TextView) findViewById(R.id.hisThass19Choice1);
        }else if(ch19.equals("1")){
            ch19 = "1";
            spn19 = (TextView) findViewById(R.id.hisThass19Choice2);
        }else if(ch19.equals("2")){
            ch19 = "2";
            spn19 = (TextView) findViewById(R.id.hisThass19Choice3);
        }else{
            ch19 = "3";
            spn19 = (TextView) findViewById(R.id.hisThass19Choice4);
        }

        if(ch20.equals("0")){
            ch20 = "0";
            spn20 = (TextView) findViewById(R.id.hisThass20Choice1);
        }else if(ch20.equals("1")){
            ch20 = "1";
            spn20 = (TextView) findViewById(R.id.hisThass20Choice2);
        }else if(ch20.equals("2")){
            ch20 = "2";
            spn20 = (TextView) findViewById(R.id.hisThass20Choice3);
        }else{
            ch20 = "3";
            spn20 = (TextView) findViewById(R.id.hisThass20Choice4);
        }

        if(ch21.equals("0")){
            ch21 = "0";
            spn21 = (TextView) findViewById(R.id.hisThass21Choice1);
        }else if(ch21.equals("1")){
            ch21 = "1";
            spn21 = (TextView) findViewById(R.id.hisThass21Choice2);
        }else if(ch21.equals("2")){
            ch21 = "2";
            spn21 = (TextView) findViewById(R.id.hisThass21Choice3);
        }else{
            ch21 = "3";
            spn21 = (TextView) findViewById(R.id.hisThass21Choice4);
        }

        if(ch22.equals("0")){
            ch22 = "0";
            spn22 = (TextView) findViewById(R.id.hisThass22Choice1);
        }else if(ch22.equals("1")){
            ch22 = "1";
            spn22 = (TextView) findViewById(R.id.hisThass22Choice2);
        }else if(ch22.equals("2")){
            ch22 = "2";
            spn22 = (TextView) findViewById(R.id.hisThass22Choice3);
        }else{
            ch22 = "3";
            spn22 = (TextView) findViewById(R.id.hisThass22Choice4);
        }

        if(ch23.equals("0")){
            ch23 = "0";
            spn23 = (TextView) findViewById(R.id.hisThass23Choice1);
        }else if(ch23.equals("1")){
            ch23 = "1";
            spn23 = (TextView) findViewById(R.id.hisThass23Choice2);
        }else if(ch23.equals("2")){
            ch23 = "2";
            spn23 = (TextView) findViewById(R.id.hisThass23Choice3);
        }else{
            ch23 = "3";
            spn23 = (TextView) findViewById(R.id.hisThass23Choice4);
        }

        if(ch24.equals("0")){
            ch24 = "0";
            spn24 = (TextView) findViewById(R.id.hisThass24Choice1);
        }else if(ch24.equals("1")){
            ch24 = "1";
            spn24 = (TextView) findViewById(R.id.hisThass24Choice2);
        }else if(ch24.equals("2")){
            ch24 = "2";
            spn24 = (TextView) findViewById(R.id.hisThass24Choice3);
        }else{
            ch24 = "3";
            spn24 = (TextView) findViewById(R.id.hisThass24Choice4);
        }

        if(ch25.equals("0")){
            ch25 = "0";
            spn25 = (TextView) findViewById(R.id.hisThass25Choice1);
        }else if(ch25.equals("1")){
            ch25 = "1";
            spn25 = (TextView) findViewById(R.id.hisThass25Choice2);
        }else if(ch25.equals("2")){
            ch25 = "2";
            spn25 = (TextView) findViewById(R.id.hisThass25Choice3);
        }else{
            ch25 = "3";
            spn25 = (TextView) findViewById(R.id.hisThass25Choice4);
        }

        if(ch26.equals("0")){
            ch26 = "0";
            spn26 = (TextView) findViewById(R.id.hisThass26Choice1);
        }else if(ch26.equals("1")){
            ch26 = "1";
            spn26 = (TextView) findViewById(R.id.hisThass26Choice2);
        }else if(ch26.equals("2")){
            ch26 = "2";
            spn26 = (TextView) findViewById(R.id.hisThass26Choice3);
        }else{
            ch26 = "3";
            spn26 = (TextView) findViewById(R.id.hisThass26Choice4);
        }

        if(ch27.equals("0")){
            ch27 = "0";
            spn27 = (TextView) findViewById(R.id.hisThass27Choice1);
        }else if(ch27.equals("1")){
            ch27 = "1";
            spn27 = (TextView) findViewById(R.id.hisThass27Choice2);
        }else if(ch27.equals("2")){
            ch27 = "2";
            spn27 = (TextView) findViewById(R.id.hisThass27Choice3);
        }else{
            ch27 = "3";
            spn27 = (TextView) findViewById(R.id.hisThass27Choice4);
        }

        if(ch28.equals("0")){
            ch28 = "0";
            spn28 = (TextView) findViewById(R.id.hisThass28Choice1);
        }else if(ch28.equals("1")){
            ch28 = "1";
            spn28 = (TextView) findViewById(R.id.hisThass28Choice2);
        }else if(ch28.equals("2")){
            ch28 = "2";
            spn28 = (TextView) findViewById(R.id.hisThass28Choice3);
        }else{
            ch28 = "3";
            spn28 = (TextView) findViewById(R.id.hisThass28Choice4);
        }

        if(ch29.equals("0")){
            ch29 = "0";
            spn29 = (TextView) findViewById(R.id.hisThass29Choice1);
        }else if(ch29.equals("1")){
            ch29 = "1";
            spn29 = (TextView) findViewById(R.id.hisThass29Choice2);
        }else if(ch29.equals("2")){
            ch29 = "2";
            spn29 = (TextView) findViewById(R.id.hisThass29Choice3);
        }else{
            ch29 = "3";
            spn29 = (TextView) findViewById(R.id.hisThass29Choice4);
        }

        if(ch30.equals("0")){
            ch30 = "0";
            spn30 = (TextView) findViewById(R.id.hisThass30Choice1);
        }else if(ch30.equals("1")){
            ch30 = "1";
            spn30 = (TextView) findViewById(R.id.hisThass30Choice2);
        }else if(ch30.equals("2")){
            ch30 = "2";
            spn30 = (TextView) findViewById(R.id.hisThass30Choice3);
        }else{
            ch30 = "3";
            spn30 = (TextView) findViewById(R.id.hisThass30Choice4);
        }


        spn.setText("/");
        spn2.setText("/");
        spn3.setText("/");
        spn4.setText("/");
        spn5.setText("/");
        spn6.setText("/");
        spn7.setText("/");
        spn8.setText("/");
        spn9.setText("/");
        spn10.setText("/");
        spn11.setText("/");
        spn12.setText("/");
        spn13.setText("/");
        spn14.setText("/");
        spn15.setText("/");
        spn16.setText("/");
        spn17.setText("/");
        spn18.setText("/");
        spn19.setText("/");
        spn20.setText("/");
        spn21.setText("/");
        spn22.setText("/");
        spn23.setText("/");
        spn24.setText("/");
        spn25.setText("/");
        spn26.setText("/");
        spn23.setText("/");
        spn24.setText("/");
        spn25.setText("/");
        spn26.setText("/");
        spn27.setText("/");
        spn28.setText("/");
        spn29.setText("/");
        spn30.setText("/");
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
    private void putIt() {
        Intent intent = new Intent(ShowChildDetail2.this, PDF2Activity.class);
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
        intent.putExtra("sspn27", ch27);
        intent.putExtra("sspn28", ch28);
        intent.putExtra("sspn29", ch29);
        intent.putExtra("sspn30", ch30);
        /*intent.putExtra("risk1", risk1Int);
        intent.putExtra("risk2", risk2Int);
        intent.putExtra("risk3", risk3Int);
        intent.putExtra("date", date);*/
        startActivity(intent);

    }
}

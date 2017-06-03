package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class ShowChildDetail3 extends AppCompatActivity {
    private MyConstant myConstant;
    Button ImageViewPDF,button2;
    private String urlPHPString;
    private String[] columnStrings,resultStrings;
    private String tag = "16AprilV5";
    String ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9, ch10, ch11,
            ch12, ch13, ch14, ch15, ch16, ch17, ch18, ch19, ch20,
            ch21, ch22, ch23, ch24, ch25, ch26;


    TextView textView,textView2,spn, spn2, spn3, spn4, spn5, spn6, spn7, spn8, spn9, spn10, spn11, spn12, spn13,
            spn14, spn15, spn16, spn17, spn18, spn19, spn20, spn21, spn22, spn23, spn24, spn25, spn26;
    String idString, loginString[],genderString,ageString,risk1,risk2,risk3,nameString,date,allRisk="";
    ImageView backView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_child_detail3);
        textView = (TextView) findViewById(R.id.hisSdqShowRisk);
        button2 = (Button) findViewById(R.id.rechisSdq);
        ImageViewPDF = (Button) findViewById(R.id.showDetailPdfSdq);
        backView = (ImageView) findViewById(R.id.backfromShowchild3);

        ImageViewPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                putIt();


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAlert objMyAlert = new myAlert(ShowChildDetail3.this);
                objMyAlert.myDialog("คำแนะนำ(ไม่ใช่การวินิจฉัย ในการตัดสินปัญหาเด็ก)หากต้องการพบแพทย์ ควรบันทึกผลการประเมินเบื้องต้นเป็น PDF เพื่อประกอบการวินิจฉัย :","ผลการประเมินนี้เป็นการประเมินความเสี่ยงเบื้องต้นสมาธิสั้นโดยรวมเท่านั้น หากมีข้อสงสัยควรปรึกษาผู้เชียวชาญ\n" + "หากต้องการพบแพทย์ ควรบันทึกผลการประเมินเบื้องต้นเป็น PDF เพื่อประกอบการวินิจฉัย");
            }
        });
        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });


        mySetup();
        queryDataFromJSoN();
        if(Integer.parseInt(risk1)>=0&&Integer.parseInt(risk1)<=5){//1
            allRisk = "ปกติ";

        }else if(Integer.parseInt(risk1)==6){
            allRisk = "เสี่ยง";

        }else  if(Integer.parseInt(risk1)>=7&&Integer.parseInt(risk1)<=10){
            allRisk = "มีปัญหา";
        }
        if(allRisk.equals("ปกติ")){
            textView.setText(allRisk);
            textView.setTextColor(Color.parseColor("#1bb730"));
        }else{
            textView.setText(allRisk);
        }
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
        intent.putExtra("risk", Integer.parseInt(risk1));
        intent.putExtra("date", date);
        intent.putExtra("gender", genderString);
        intent.putExtra("age", ageString);
        intent.putExtra("name", nameString);
        intent.putExtra("Login", loginString);
        intent.putExtra("allRisk", allRisk);
        startActivity(intent);

    }

    private void findId() {

            if(ch1.equals("0")){
                ch1 = "0";
                spn = (TextView) findViewById(R.id.hisSdq1Choice1);
            }else if(ch1.equals("1")){
                ch1 = "1";
                spn = (TextView) findViewById(R.id.hisSdq1Choice2);
            }else if(ch1.equals("2")){
                ch1 = "2";
                spn = (TextView) findViewById(R.id.hisSdq1Choice3);
            }


            if(ch2.equals("0")){
                ch2 = "0";
                spn2 = (TextView) findViewById(R.id.hisSdq2Choice1);
            }else if(ch2.equals("1")){
                ch2 = "1";
                spn2 = (TextView) findViewById(R.id.hisSdq2Choice2);
            }else if(ch2.equals("2")){
                ch2 = "2";
                spn2 = (TextView) findViewById(R.id.hisSdq2Choice3);
            }

            if(ch3.equals("0")){
                ch3 = "0";
                spn3 = (TextView) findViewById(R.id.hisSdq3Choice1);
            }else if(ch3.equals("1")){
                ch3 = "1";
                spn3 = (TextView) findViewById(R.id.hisSdq3Choice2);
            }else if(ch3.equals("2")){
                ch3 = "2";
                spn3 = (TextView) findViewById(R.id.hisSdq3Choice3);
            }

            if(ch4.equals("0")){
                ch4 = "0";
                spn4 = (TextView) findViewById(R.id.hisSdq4Choice1);
            }else if(ch4.equals("1")){
                ch4 = "1";
                spn4 = (TextView) findViewById(R.id.hisSdq4Choice2);
            }else if(ch4.equals("2")){
                ch4 = "2";
                spn4 = (TextView) findViewById(R.id.hisSdq4Choice3);
            }

            if(ch5.equals("0")){
                ch5 = "0";
                spn5 = (TextView) findViewById(R.id.hisSdq5Choice1);
            }else if(ch5.equals("1")){
                ch5 = "1";
                spn5 = (TextView) findViewById(R.id.hisSdq5Choice2);
            }else if(ch5.equals("2")){
                ch5 = "2";
                spn5 = (TextView) findViewById(R.id.hisSdq5Choice3);
            }

            if(ch6.equals("0")){
                ch6 = "0";
                spn6 = (TextView) findViewById(R.id.hisSdq6Choice1);
            }else if(ch6.equals("1")){
                ch6 = "1";
                spn6 = (TextView) findViewById(R.id.hisSdq6Choice2);
            }else if(ch6.equals("2")){
                ch6 = "2";
                spn6 = (TextView) findViewById(R.id.hisSdq6Choice3);
            }

            if(ch7.equals("0")){
                ch7 = "0";
                spn7 = (TextView) findViewById(R.id.hisSdq7Choice1);
            }else if(ch7.equals("1")){
                ch7 = "1";
                spn7 = (TextView) findViewById(R.id.hisSdq7Choice2);
            }else if(ch7.equals("2")){
                ch7 = "2";
                spn7 = (TextView) findViewById(R.id.hisSdq7Choice3);
            }

            if(ch8.equals("0")){
                ch8 = "0";
                spn8 = (TextView) findViewById(R.id.hisSdq8Choice1);
            }else if(ch8.equals("1")){
                ch8 = "1";
                spn8 = (TextView) findViewById(R.id.hisSdq8Choice2);
            }else if(ch8.equals("2")){
                ch8 = "2";
                spn8 = (TextView) findViewById(R.id.hisSdq8Choice3);
            }

            if(ch9.equals("0")){
                ch9 = "0";
                spn9 = (TextView) findViewById(R.id.hisSdq9Choice1);
            }else if(ch9.equals("1")){
                ch9 = "1";
                spn9 = (TextView) findViewById(R.id.hisSdq9Choice2);
            }else if(ch9.equals("2")){
                ch9 = "2";
                spn9 = (TextView) findViewById(R.id.hisSdq9Choice3);
            }

            if(ch10.equals("0")){
                ch10 = "0";
                spn10 = (TextView) findViewById(R.id.hisSdq10Choice1);
            }else if(ch10.equals("1")){
                ch10 = "1";
                spn10 = (TextView) findViewById(R.id.hisSdq10Choice2);
            }else if(ch10.equals("2")){
                ch10 = "2";
                spn10 = (TextView) findViewById(R.id.hisSdq10Choice3);
            }

            if(ch11.equals("0")){
                ch11 = "0";
                spn11 = (TextView) findViewById(R.id.hisSdq11Choice1);
            }else if(ch11.equals("1")){
                ch11 = "1";
                spn11 = (TextView) findViewById(R.id.hisSdq11Choice2);
            }else if(ch11.equals("2")){
                ch11 = "2";
                spn11 = (TextView) findViewById(R.id.hisSdq11Choice3);
            }

            if(ch12.equals("0")){
                ch12 = "0";
                spn12 = (TextView) findViewById(R.id.hisSdq12Choice1);
            }else if(ch12.equals("1")){
                ch12 = "1";
                spn12 = (TextView) findViewById(R.id.hisSdq12Choice2);
            }else if(ch12.equals("2")){
                ch12 = "2";
                spn12 = (TextView) findViewById(R.id.hisSdq12Choice3);
            }

            if(ch13.equals("0")){
                ch13 = "0";
                spn13 = (TextView) findViewById(R.id.hisSdq13Choice1);
            }else if(ch13.equals("1")){
                ch13 = "1";
                spn13 = (TextView) findViewById(R.id.hisSdq13Choice2);
            }else if(ch13.equals("2")){
                ch13 = "2";
                spn13 = (TextView) findViewById(R.id.hisSdq13Choice3);
            }

            if(ch14.equals("0")){
                ch14 = "0";
                spn14 = (TextView) findViewById(R.id.hisSdq14Choice1);
            }else if(ch14.equals("1")){
                ch14 = "1";
                spn14 = (TextView) findViewById(R.id.hisSdq14Choice2);
            }else if(ch14.equals("2")){
                ch14 = "2";
                spn14 = (TextView) findViewById(R.id.hisSdq14Choice3);
            }

            if(ch15.equals("0")){
                ch15 = "0";
                spn15 = (TextView) findViewById(R.id.hisSdq15Choice1);
            }else if(ch15.equals("1")){
                ch15 = "1";
                spn15 = (TextView) findViewById(R.id.hisSdq15Choice2);
            }else if(ch15.equals("2")){
                ch15 = "2";
                spn15 = (TextView) findViewById(R.id.hisSdq15Choice3);
            }

            if(ch16.equals("0")){
                ch16 = "0";
                spn16 = (TextView) findViewById(R.id.hisSdq16Choice1);
            }else if(ch16.equals("1")){
                ch16 = "1";
                spn16 = (TextView) findViewById(R.id.hisSdq16Choice2);
            }else if(ch16.equals("2")){
                ch16 = "2";
                spn16 = (TextView) findViewById(R.id.hisSdq16Choice3);
            }

            if(ch17.equals("0")){
                ch17 = "0";
                spn17 = (TextView) findViewById(R.id.hisSdq17Choice1);
            }else if(ch17.equals("1")){
                ch17 = "1";
                spn17 = (TextView) findViewById(R.id.hisSdq17Choice2);
            }else if(ch17.equals("2")){
                ch17 = "2";
                spn17 = (TextView) findViewById(R.id.hisSdq17Choice3);
            }

            if(ch18.equals("0")){
                ch18 = "0";
                spn18 = (TextView) findViewById(R.id.hisSdq18Choice1);
            }else if(ch18.equals("1")){
                ch18 = "1";
                spn18 = (TextView) findViewById(R.id.hisSdq18Choice2);
            }else if(ch18.equals("2")){
                ch18 = "2";
                spn18 = (TextView) findViewById(R.id.hisSdq18Choice3);
            }

            if(ch19.equals("0")){
                ch19 = "0";
                spn19 = (TextView) findViewById(R.id.hisSdq19Choice1);
            }else if(ch19.equals("1")){
                ch19 = "1";
                spn19 = (TextView) findViewById(R.id.hisSdq19Choice2);
            }else if(ch19.equals("2")){
                ch19 = "2";
                spn19 = (TextView) findViewById(R.id.hisSdq19Choice3);
            }

            if(ch20.equals("0")){
                ch20 = "0";
                spn20 = (TextView) findViewById(R.id.hisSdq20Choice1);
            }else if(ch20.equals("1")){
                ch20 = "1";
                spn20 = (TextView) findViewById(R.id.hisSdq20Choice2);
            }else if(ch20.equals("2")){
                ch20 = "2";
                spn20 = (TextView) findViewById(R.id.hisSdq20Choice3);
            }

            if(ch21.equals("0")){
                ch21 = "0";
                spn21 = (TextView) findViewById(R.id.hisSdq21Choice1);
            }else if(ch21.equals("1")){
                ch21 = "1";
                spn21 = (TextView) findViewById(R.id.hisSdq21Choice2);
            }else if(ch21.equals("2")){
                ch21 = "2";
                spn21 = (TextView) findViewById(R.id.hisSdq21Choice3);
            }

            if(ch22.equals("0")){
                ch22 = "0";
                spn22 = (TextView) findViewById(R.id.hisSdq22Choice1);
            }else if(ch22.equals("1")){
                ch22 = "1";
                spn22 = (TextView) findViewById(R.id.hisSdq22Choice2);
            }else if(ch22.equals("2")){
                ch22 = "2";
                spn22 = (TextView) findViewById(R.id.hisSdq22Choice3);
            }

            if(ch23.equals("0")){
                ch23 = "0";
                spn23 = (TextView) findViewById(R.id.hisSdq23Choice1);
            }else if(ch23.equals("1")){
                ch23 = "1";
                spn23 = (TextView) findViewById(R.id.hisSdq23Choice2);
            }else if(ch23.equals("2")){
                ch23 = "2";
                spn23 = (TextView) findViewById(R.id.hisSdq23Choice3);
            }

            if(ch24.equals("0")){
                ch24 = "0";
                spn24 = (TextView) findViewById(R.id.hisSdq24Choice1);
            }else if(ch24.equals("1")){
                ch24 = "1";
                spn24 = (TextView) findViewById(R.id.hisSdq24Choice2);
            }else if(ch24.equals("2")){
                ch24 = "2";
                spn24 = (TextView) findViewById(R.id.hisSdq24Choice3);
            }

            if(ch25.equals("0")){
                ch25 = "0";
                spn25 = (TextView) findViewById(R.id.hisSdq25Choice1);
            }else if(ch25.equals("1")){
                ch25 = "1";
                spn25 = (TextView) findViewById(R.id.hisSdq25Choice2);
            }else if(ch25.equals("2")){
                ch25 = "2";
                spn25 = (TextView) findViewById(R.id.hisSdq25Choice3);
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
            risk1 = resultStrings[28];
            date = resultStrings[31];

        } catch (Exception e) {
            Log.d(tag, "e query ==>" + e.toString());
        }
    }

    private void mySetup() {
        myConstant = new MyConstant();
        idString = getIntent().getStringExtra("id");
        loginString = getIntent().getStringArrayExtra("Login");
        genderString = getIntent().getStringExtra("gender");
        ageString = getIntent().getStringExtra("age");
        nameString = getIntent().getStringExtra("name");
        columnStrings = myConstant.getColumnTest3();
        urlPHPString = myConstant.getUrlGetTestWhereID3();
    }
}

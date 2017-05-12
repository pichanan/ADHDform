package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class riskSnapActivity extends AppCompatActivity {
    private static String tag = "30MarchV1",tag2 = "16AprilV1";
    String idString, loginString[],genderString,ageString,risk1,risk2,risk3,answerArray[];
    TextView textView,textView2,spn, spn2, spn3, spn4, spn5, spn6, spn7, spn8, spn9, spn10, spn11, spn12, spn13,
            spn14, spn15, spn16, spn17, spn18, spn19, spn20, spn21, spn22, spn23, spn24, spn25, spn26;
    String sspn, sspn2, sspn3, sspn4, sspn5, sspn6, sspn7, sspn8, sspn9, sspn10, sspn11, sspn12, sspn13,
    sspn14, sspn15, sspn16, sspn17, sspn18, sspn19, sspn20, sspn21, sspn22, sspn23, sspn24, sspn25, sspn26,date;
    int risk1Int,risk2Int,risk3Int ;
    ImageView ImageViewPDF;
    String a = "testerrrrrrr";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_snap);


        getValueFromIntent();
       // analyzeRisk();
        showText();
        ImageViewPDF = (ImageView) findViewById(R.id.showRiskSnapPdf);
        ImageViewPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                putIt();



            }




        });





    }

    private void putIt() {
        Intent intent = new Intent(riskSnapActivity.this, PDFActivity.class);
        intent.putExtra("sspn", sspn);
        intent.putExtra("sspn2", sspn2);
        intent.putExtra("sspn3", sspn3);
        intent.putExtra("sspn4", sspn4);
        intent.putExtra("sspn5", sspn5);
        intent.putExtra("sspn6", sspn6);
        intent.putExtra("sspn7", sspn7);
        intent.putExtra("sspn8", sspn8);
        intent.putExtra("sspn9", sspn9);
        intent.putExtra("sspn10", sspn10);
        intent.putExtra("sspn11", sspn11);
        intent.putExtra("sspn12", sspn12);
        intent.putExtra("sspn13", sspn13);
        intent.putExtra("sspn14", sspn14);
        intent.putExtra("sspn15", sspn15);
        intent.putExtra("sspn16", sspn16);
        intent.putExtra("sspn17", sspn17);
        intent.putExtra("sspn18", sspn18);
        intent.putExtra("sspn19", sspn19);
        intent.putExtra("sspn20", sspn20);
        intent.putExtra("sspn21", sspn21);
        intent.putExtra("sspn22", sspn22);
        intent.putExtra("sspn23", sspn23);
        intent.putExtra("sspn24", sspn24);
        intent.putExtra("sspn25", sspn25);
        intent.putExtra("sspn26", sspn26);
        /*intent.putExtra("risk1", risk1Int);
        intent.putExtra("risk2", risk2Int);
        intent.putExtra("risk3", risk3Int);
        intent.putExtra("date", date);*/
        startActivity(intent);

    }


    private void showText() {
        if(sspn.equals("ไม่เลย")){
            sspn = "0";
            spn = (TextView) findViewById(R.id.snap1Choice1);
        }else if(sspn.equals("เล็กน้อย")){
            sspn = "1";
            spn = (TextView) findViewById(R.id.snap1Choice2);
        }else if(sspn.equals("ค่อนข้างมาก")){
            sspn = "2";
            spn = (TextView) findViewById(R.id.snap1Choice3);
        }else{
            sspn = "3";
            spn = (TextView) findViewById(R.id.snap1Choice4);
        }


        if(sspn2.equals("ไม่เลย")){
            sspn2 = "0";
            spn2 = (TextView) findViewById(R.id.snap2Choice1);
        }else if(sspn2.equals("เล็กน้อย")){
            sspn2 = "1";
            spn2 = (TextView) findViewById(R.id.snap2Choice2);
        }else if(sspn2.equals("ค่อนข้างมาก")){
            sspn2 = "2";
            spn2 = (TextView) findViewById(R.id.snap2Choice3);
        }else{
            sspn2 = "3";
            spn2 = (TextView) findViewById(R.id.snap2Choice4);
        }

        if(sspn3.equals("ไม่เลย")){
            sspn3 = "0";
            spn3 = (TextView) findViewById(R.id.snap3Choice1);
        }else if(sspn3.equals("เล็กน้อย")){
            sspn3 = "1";
            spn3 = (TextView) findViewById(R.id.snap3Choice2);
        }else if(sspn3.equals("ค่อนข้างมาก")){
            sspn3 = "2";
            spn3 = (TextView) findViewById(R.id.snap3Choice3);
        }else{
            sspn3 = "3";
            spn3 = (TextView) findViewById(R.id.snap3Choice4);
        }

        if(sspn4.equals("ไม่เลย")){
            sspn4 = "0";
            spn4 = (TextView) findViewById(R.id.snap4Choice1);
        }else if(sspn4.equals("เล็กน้อย")){
            sspn4 = "1";
            spn4 = (TextView) findViewById(R.id.snap4Choice2);
        }else if(sspn4.equals("ค่อนข้างมาก")){
            sspn4 = "2";
            spn4 = (TextView) findViewById(R.id.snap4Choice3);
        }else{
            sspn4 = "3";
            spn4 = (TextView) findViewById(R.id.snap4Choice4);
        }

        if(sspn5.equals("ไม่เลย")){
            sspn5 = "0";
            spn5 = (TextView) findViewById(R.id.snap5Choice1);
        }else if(sspn5.equals("เล็กน้อย")){
            sspn5 = "1";
            spn5 = (TextView) findViewById(R.id.snap5Choice2);
        }else if(sspn5.equals("ค่อนข้างมาก")){
            sspn5 = "2";
            spn5 = (TextView) findViewById(R.id.snap5Choice3);
        }else{
            sspn5 = "3";
            spn5 = (TextView) findViewById(R.id.snap5Choice4);
        }

        if(sspn6.equals("ไม่เลย")){
            sspn6 = "0";
            spn6 = (TextView) findViewById(R.id.snap6Choice1);
        }else if(sspn6.equals("เล็กน้อย")){
            sspn6 = "1";
            spn6 = (TextView) findViewById(R.id.snap6Choice2);
        }else if(sspn6.equals("ค่อนข้างมาก")){
            sspn6 = "2";
            spn6 = (TextView) findViewById(R.id.snap6Choice3);
        }else{
            sspn6 = "3";
            spn6 = (TextView) findViewById(R.id.snap6Choice4);
        }

        if(sspn7.equals("ไม่เลย")){
            sspn7 = "0";
            spn7 = (TextView) findViewById(R.id.snap7Choice1);
        }else if(sspn7.equals("เล็กน้อย")){
            sspn7 = "1";
            spn7 = (TextView) findViewById(R.id.snap7Choice2);
        }else if(sspn7.equals("ค่อนข้างมาก")){
            sspn7 = "2";
            spn7 = (TextView) findViewById(R.id.snap7Choice3);
        }else{
            sspn7 = "3";
            spn7 = (TextView) findViewById(R.id.snap7Choice4);
        }

        if(sspn8.equals("ไม่เลย")){
            sspn8 = "0";
            spn8 = (TextView) findViewById(R.id.snap8Choice1);
        }else if(sspn8.equals("เล็กน้อย")){
            sspn8 = "1";
            spn8 = (TextView) findViewById(R.id.snap8Choice2);
        }else if(sspn8.equals("ค่อนข้างมาก")){
            sspn8 = "2";
            spn8 = (TextView) findViewById(R.id.snap8Choice3);
        }else{
            sspn8 = "3";
            spn8 = (TextView) findViewById(R.id.snap8Choice4);
        }

        if(sspn9.equals("ไม่เลย")){
            sspn9 = "0";
            spn9 = (TextView) findViewById(R.id.snap9Choice1);
        }else if(sspn9.equals("เล็กน้อย")){
            sspn9 = "1";
            spn9 = (TextView) findViewById(R.id.snap9Choice2);
        }else if(sspn9.equals("ค่อนข้างมาก")){
            sspn9 = "2";
            spn9 = (TextView) findViewById(R.id.snap9Choice3);
        }else{
            sspn9 = "3";
            spn9 = (TextView) findViewById(R.id.snap9Choice4);
        }

        if(sspn10.equals("ไม่เลย")){
            sspn10 = "0";
            spn10 = (TextView) findViewById(R.id.snap10Choice1);
        }else if(sspn10.equals("เล็กน้อย")){
            sspn10 = "1";
            spn10 = (TextView) findViewById(R.id.snap10Choice2);
        }else if(sspn10.equals("ค่อนข้างมาก")){
            sspn10 = "2";
            spn10 = (TextView) findViewById(R.id.snap10Choice3);
        }else{
            sspn10 = "3";
            spn10 = (TextView) findViewById(R.id.snap10Choice4);
        }

        if(sspn11.equals("ไม่เลย")){
            sspn11 = "0";
            spn11 = (TextView) findViewById(R.id.snap11Choice1);
        }else if(sspn11.equals("เล็กน้อย")){
            sspn11 = "1";
            spn11 = (TextView) findViewById(R.id.snap11Choice2);
        }else if(sspn11.equals("ค่อนข้างมาก")){
            sspn11 = "2";
            spn11 = (TextView) findViewById(R.id.snap11Choice3);
        }else{
            sspn11 = "3";
            spn11 = (TextView) findViewById(R.id.snap11Choice4);
        }

        if(sspn12.equals("ไม่เลย")){
            sspn12 = "0";
            spn12 = (TextView) findViewById(R.id.snap12Choice1);
        }else if(sspn12.equals("เล็กน้อย")){
            sspn12 = "1";
            spn12 = (TextView) findViewById(R.id.snap12Choice2);
        }else if(sspn12.equals("ค่อนข้างมาก")){
            sspn12 = "2";
            spn12 = (TextView) findViewById(R.id.snap12Choice3);
        }else{
            sspn12 = "3";
            spn12 = (TextView) findViewById(R.id.snap12Choice4);
        }

        if(sspn13.equals("ไม่เลย")){
            sspn13 = "0";
            spn13 = (TextView) findViewById(R.id.snap13Choice1);
        }else if(sspn13.equals("เล็กน้อย")){
            sspn13 = "1";
            spn13 = (TextView) findViewById(R.id.snap13Choice2);
        }else if(sspn13.equals("ค่อนข้างมาก")){
            sspn13 = "2";
            spn13 = (TextView) findViewById(R.id.snap13Choice3);
        }else{
            sspn13 = "3";
            spn13 = (TextView) findViewById(R.id.snap13Choice4);
        }

        if(sspn14.equals("ไม่เลย")){
            sspn14 = "0";
            spn14 = (TextView) findViewById(R.id.snap14Choice1);
        }else if(sspn14.equals("เล็กน้อย")){
            sspn14 = "1";
            spn14 = (TextView) findViewById(R.id.snap14Choice2);
        }else if(sspn14.equals("ค่อนข้างมาก")){
            sspn14 = "2";
            spn14 = (TextView) findViewById(R.id.snap14Choice3);
        }else{
            sspn14 = "3";
            spn14 = (TextView) findViewById(R.id.snap14Choice4);
        }

        if(sspn15.equals("ไม่เลย")){
            sspn15 = "0";
            spn15 = (TextView) findViewById(R.id.snap15Choice1);
        }else if(sspn15.equals("เล็กน้อย")){
            sspn15 = "1";
            spn15 = (TextView) findViewById(R.id.snap15Choice2);
        }else if(sspn15.equals("ค่อนข้างมาก")){
            sspn15 = "2";
            spn15 = (TextView) findViewById(R.id.snap15Choice3);
        }else{
            sspn15 = "3";
            spn15 = (TextView) findViewById(R.id.snap15Choice4);
        }

        if(sspn16.equals("ไม่เลย")){
            sspn16 = "0";
            spn16 = (TextView) findViewById(R.id.snap16Choice1);
        }else if(sspn16.equals("เล็กน้อย")){
            sspn16 = "1";
            spn16 = (TextView) findViewById(R.id.snap16Choice2);
        }else if(sspn16.equals("ค่อนข้างมาก")){
            sspn16 = "2";
            spn16 = (TextView) findViewById(R.id.snap16Choice3);
        }else{
            sspn16 = "3";
            spn16 = (TextView) findViewById(R.id.snap16Choice4);
        }

        if(sspn17.equals("ไม่เลย")){
            sspn17 = "0";
            spn17 = (TextView) findViewById(R.id.snap17Choice1);
        }else if(sspn17.equals("เล็กน้อย")){
            sspn17 = "1";
            spn17 = (TextView) findViewById(R.id.snap17Choice2);
        }else if(sspn17.equals("ค่อนข้างมาก")){
            sspn17 = "2";
            spn17 = (TextView) findViewById(R.id.snap17Choice3);
        }else{
            sspn17 = "3";
            spn17 = (TextView) findViewById(R.id.snap17Choice4);
        }

        if(sspn18.equals("ไม่เลย")){
            sspn18 = "0";
            spn18 = (TextView) findViewById(R.id.snap18Choice1);
        }else if(sspn18.equals("เล็กน้อย")){
            sspn18 = "1";
            spn18 = (TextView) findViewById(R.id.snap18Choice2);
        }else if(sspn18.equals("ค่อนข้างมาก")){
            sspn18 = "2";
            spn18 = (TextView) findViewById(R.id.snap18Choice3);
        }else{
            sspn18 = "3";
            spn18 = (TextView) findViewById(R.id.snap18Choice4);
        }

        if(sspn19.equals("ไม่เลย")){
            sspn19 = "0";
            spn19 = (TextView) findViewById(R.id.snap19Choice1);
        }else if(sspn19.equals("เล็กน้อย")){
            sspn19 = "1";
            spn19 = (TextView) findViewById(R.id.snap19Choice2);
        }else if(sspn19.equals("ค่อนข้างมาก")){
            sspn19 = "2";
            spn19 = (TextView) findViewById(R.id.snap19Choice3);
        }else{
            sspn19 = "3";
            spn19 = (TextView) findViewById(R.id.snap19Choice4);
        }

        if(sspn20.equals("ไม่เลย")){
            sspn20 = "0";
            spn20 = (TextView) findViewById(R.id.snap20Choice1);
        }else if(sspn20.equals("เล็กน้อย")){
            sspn20 = "1";
            spn20 = (TextView) findViewById(R.id.snap20Choice2);
        }else if(sspn20.equals("ค่อนข้างมาก")){
            sspn20 = "2";
            spn20 = (TextView) findViewById(R.id.snap20Choice3);
        }else{
            sspn20 = "3";
            spn20 = (TextView) findViewById(R.id.snap20Choice4);
        }

        if(sspn21.equals("ไม่เลย")){
            sspn21 = "0";
            spn21 = (TextView) findViewById(R.id.snap21Choice1);
        }else if(sspn21.equals("เล็กน้อย")){
            sspn21 = "1";
            spn21 = (TextView) findViewById(R.id.snap21Choice2);
        }else if(sspn21.equals("ค่อนข้างมาก")){
            sspn21 = "2";
            spn21 = (TextView) findViewById(R.id.snap21Choice3);
        }else{
            sspn21 = "3";
            spn21 = (TextView) findViewById(R.id.snap21Choice4);
        }

        if(sspn22.equals("ไม่เลย")){
            sspn22 = "0";
            spn22 = (TextView) findViewById(R.id.snap22Choice1);
        }else if(sspn22.equals("เล็กน้อย")){
            sspn22 = "1";
            spn22 = (TextView) findViewById(R.id.snap22Choice2);
        }else if(sspn22.equals("ค่อนข้างมาก")){
            sspn22 = "2";
            spn22 = (TextView) findViewById(R.id.snap22Choice3);
        }else{
            sspn22 = "3";
            spn22 = (TextView) findViewById(R.id.snap22Choice4);
        }

        if(sspn23.equals("ไม่เลย")){
            sspn23 = "0";
            spn23 = (TextView) findViewById(R.id.snap23Choice1);
        }else if(sspn23.equals("เล็กน้อย")){
            sspn23 = "1";
            spn23 = (TextView) findViewById(R.id.snap23Choice2);
        }else if(sspn23.equals("ค่อนข้างมาก")){
            sspn23 = "2";
            spn23 = (TextView) findViewById(R.id.snap23Choice3);
        }else{
            sspn23 = "3";
            spn23 = (TextView) findViewById(R.id.snap23Choice4);
        }

        if(sspn24.equals("ไม่เลย")){
            sspn24 = "0";
            spn24 = (TextView) findViewById(R.id.snap24Choice1);
        }else if(sspn24.equals("เล็กน้อย")){
            sspn24 = "1";
            spn24 = (TextView) findViewById(R.id.snap24Choice2);
        }else if(sspn24.equals("ค่อนข้างมาก")){
            sspn24 = "2";
            spn24 = (TextView) findViewById(R.id.snap24Choice3);
        }else{
            sspn24 = "3";
            spn24 = (TextView) findViewById(R.id.snap24Choice4);
        }

        if(sspn25.equals("ไม่เลย")){
            sspn25 = "0";
            spn25 = (TextView) findViewById(R.id.snap25Choice1);
        }else if(sspn25.equals("เล็กน้อย")){
            sspn25 = "1";
            spn25 = (TextView) findViewById(R.id.snap25Choice2);
        }else if(sspn25.equals("ค่อนข้างมาก")){
            sspn25 = "2";
            spn25 = (TextView) findViewById(R.id.snap25Choice3);
        }else{
            sspn25 = "3";
            spn25 = (TextView) findViewById(R.id.snap25Choice4);
        }

        if(sspn26.equals("ไม่เลย")){
            sspn26 = "0";
            spn26 = (TextView) findViewById(R.id.snap26Choice1);
        }else if(sspn26.equals("เล็กน้อย")){
            sspn26 = "1";
            spn26 = (TextView) findViewById(R.id.snap26Choice2);
        }else if(sspn26.equals("ค่อนข้างมาก")){
            sspn26 = "2";
            spn26 = (TextView) findViewById(R.id.snap26Choice3);
        }else{
            sspn26 = "3";
            spn26 = (TextView) findViewById(R.id.snap26Choice4);
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
    }



   /* private void analyzeRisk() {
        if(loginString[3]=="1"){//ผปค
            if(risk1Int>16){//1
                textView.setText("มีความเสี่ยงด้านสมาธิ");


            }else if(risk2Int>13){//2
                textView.setText("มีความเสี่ยงด้านซน อยู่ไม่นิ่ง หุ่นหันพลันแล่น");


            }else if(risk3Int>15){//3
                textView.setText("มีความเสี่ยงด้านดื้อ ต่อต้าน");


            }else if(risk1Int>16&&risk2Int>13){ // 1-2
                textView.setText("มีความเสี่ยงด้านสมาธิ และ ด้านซน อยู่ไม่นิ่ง หุ่นหันพลันแล่น");

            }else if(risk1Int>16&&risk3Int>15){//1-3
                textView.setText("มีความเสี่ยงด้านสมาธิ และด้านดื้อ ต่อต้าน");

            }else if(risk2Int>13&&risk3Int>15){//2-3
                textView.setText("มีความเสี่ยงด้านซน อยู่ไม่นิ่ง หุ่นหันพลันแล่น และ ด้านดื้อ ต่อต้าน");

            }else if(risk1Int>16&&risk2Int>13&&risk3Int>15){//1 -2 -3
                textView.setText("มีความเสี่ยงด้านสมาธิ , ด้านซน อยู่ไม่นิ่ง หุ่นหันพลันแล่น และ ด้านดื้อ ต่อต้าน");


            }else{ // less all
                textView.setText("ไม่มีความเสี่ยง");

            }

            // ครู
        }else{

            if(risk1Int>23){//1
                textView.setText("มีความเสี่ยงด้านสมาธิ");



            }else if(risk2Int>16){//2
                textView.setText("มีความเสี่ยงด้านซน อยู่ไม่นิ่ง หุ่นหันพลันแล่น");



            }else if(risk3Int>11){//3
                textView.setText("มีความเสี่ยงด้านดื้อ ต่อต้าน");



            }else if(risk1Int>23&&risk2Int>16){ // 1-2
                textView.setText("มีความเสี่ยงด้านสมาธิ และ ด้านซน อยู่ไม่นิ่ง หุ่นหันพลันแล่น");


            }else if(risk1Int>23&&risk3Int>11){//1-3
                textView.setText("มีความเสี่ยงด้านสมาธิ และด้านดื้อ ต่อต้าน");


            }else if(risk2Int>16&&risk3Int>11){//2-3
                textView.setText("มีความเสี่ยงด้านซน อยู่ไม่นิ่ง หุ่นหันพลันแล่น และ ด้านดื้อ ต่อต้าน");


            }else if(risk1Int>23&&risk2Int>16&&risk3Int>11){//1 -2 -3
                textView.setText("มีความเสี่ยงด้านสมาธิ , ด้านซน อยู่ไม่นิ่ง หุ่นหันพลันแล่น และ ด้านดื้อ ต่อต้าน");

            }else{ // less all
                textView.setText("ไม่มีความเสี่ยง");
                textView.setTextColor(Color.parseColor("#B71C1C"));

            }

        }

        textView2.setText(date);



    }*/

    private void getValueFromIntent() {
        idString = getIntent().getStringExtra("tmpIndex");
        loginString = getIntent().getStringArrayExtra("Login");
        genderString = getIntent().getStringExtra("gender");
        ageString = getIntent().getStringExtra("age");
        Bundle extras = getIntent().getExtras();
        risk1Int = extras.getInt("risk1");
        risk2Int = extras.getInt("risk2");
        risk3Int = extras.getInt("risk3");
        sspn = getIntent().getStringExtra("ans1");
        sspn2 = getIntent().getStringExtra("ans2");
        sspn3 = getIntent().getStringExtra("ans3");
        sspn4 = getIntent().getStringExtra("ans4");
        sspn5 = getIntent().getStringExtra("ans5");
        sspn6 = getIntent().getStringExtra("ans6");
        sspn7 = getIntent().getStringExtra("ans7");
        sspn8 = getIntent().getStringExtra("ans8");
        sspn9 = getIntent().getStringExtra("ans9");
        sspn10 = getIntent().getStringExtra("ans10");
        sspn11 = getIntent().getStringExtra("ans11");
        sspn12 = getIntent().getStringExtra("ans12");
        sspn13 = getIntent().getStringExtra("ans13");
        sspn14 = getIntent().getStringExtra("ans14");
        sspn15 = getIntent().getStringExtra("ans15");
        sspn16 = getIntent().getStringExtra("ans16");
        sspn17 = getIntent().getStringExtra("ans17");
        sspn18 = getIntent().getStringExtra("ans18");
        sspn19 = getIntent().getStringExtra("ans19");
        sspn20 = getIntent().getStringExtra("ans20");
        sspn21 = getIntent().getStringExtra("ans21");
        sspn22 = getIntent().getStringExtra("ans22");
        sspn23 = getIntent().getStringExtra("ans23");
        sspn24 = getIntent().getStringExtra("ans24");
        sspn25 = getIntent().getStringExtra("ans25");
        sspn26 = getIntent().getStringExtra("ans26");
        date = getIntent().getStringExtra("date");



    }


}

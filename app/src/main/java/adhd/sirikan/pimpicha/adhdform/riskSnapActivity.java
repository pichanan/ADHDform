package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class riskSnapActivity extends AppCompatActivity {
    String idString, loginString[],genderString,ageString,risk1,risk2,risk3,answerArray[];
    TextView textView,textView2,spn, spn2, spn3, spn4, spn5, spn6, spn7, spn8, spn9, spn10, spn11, spn12, spn13,
            spn14, spn15, spn16, spn17, spn18, spn19, spn20, spn21, spn22, spn23, spn24, spn25, spn26;
    String sspn, sspn2, sspn3, sspn4, sspn5, sspn6, sspn7, sspn8, sspn9, sspn10, sspn11, sspn12, sspn13,
    sspn14, sspn15, sspn16, sspn17, sspn18, sspn19, sspn20, sspn21, sspn22, sspn23, sspn24, sspn25, sspn26,date;
    int risk1Int,risk2Int,risk3Int ;
    ImageView ImageViewPDF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_snap);
        textView = (TextView) findViewById(R.id.txtRiskSnapShowRisk);
        textView2 = (TextView) findViewById(R.id.txtRiskSnapDate);
        ImageViewPDF = (ImageView) findViewById(R.id.showRiskSnapPdf);
        ImageViewPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(riskSnapActivity.this, PDFActivity.class);
            }
        });

        getValueFromIntent();
        analyzeRisk();
        showText();






    }

    private void showText() {
        spn = (TextView) findViewById(R.id.answeSnap1);
        spn2 = (TextView) findViewById(R.id.answeSnap2);
        spn3 = (TextView) findViewById(R.id.answeSnap3);
        spn4 = (TextView) findViewById(R.id.answeSnap4);
        spn5 = (TextView) findViewById(R.id.answeSnap5);
        spn6 = (TextView) findViewById(R.id.answeSnap6);
        spn7= (TextView) findViewById(R.id.answeSnap7);
        spn8 = (TextView) findViewById(R.id.answeSnap8);
        spn9 = (TextView) findViewById(R.id.answeSnap9);
        spn10 = (TextView) findViewById(R.id.answeSnap10);
        spn11 = (TextView) findViewById(R.id.answeSnap11);
        spn12 = (TextView) findViewById(R.id.answeSnap12);
        spn13 = (TextView) findViewById(R.id.answeSnap13);
        spn14 = (TextView) findViewById(R.id.answeSnap14);
        spn15 = (TextView) findViewById(R.id.answeSnap15);
        spn16 = (TextView) findViewById(R.id.answeSnap16);
        spn17 = (TextView) findViewById(R.id.answeSnap17);
        spn18 = (TextView) findViewById(R.id.answeSnap18);
        spn19 = (TextView) findViewById(R.id.answeSnap19);
        spn20 = (TextView) findViewById(R.id.answeSnap20);
        spn21 = (TextView) findViewById(R.id.answeSnap21);
        spn22 = (TextView) findViewById(R.id.answeSnap22);
        spn23 = (TextView) findViewById(R.id.answeSnap23);
        spn24 = (TextView) findViewById(R.id.answeSnap24);
        spn25 = (TextView) findViewById(R.id.answeSnap25);
        spn26 = (TextView) findViewById(R.id.answeSnap26);

        spn.setText(sspn);
        spn2.setText(sspn2);
        spn3.setText(sspn3);
        spn4.setText(sspn4);
        spn5.setText(sspn5);
        spn6.setText(sspn6);
        spn7.setText(sspn7);
        spn8.setText(sspn8);
        spn9.setText(sspn9);
        spn10.setText(sspn10);
        spn11.setText(sspn11);
        spn12.setText(sspn12);
        spn13.setText(sspn13);
        spn14.setText(sspn14);
        spn15.setText(sspn15);
        spn16.setText(sspn16);
        spn17.setText(sspn17);
        spn18.setText(sspn18);
        spn19.setText(sspn19);
        spn20.setText(sspn20);
        spn21.setText(sspn21);
        spn22.setText(sspn22);
        spn23.setText(sspn23);
        spn24.setText(sspn24);
        spn25.setText(sspn25);
        spn26.setText(sspn26);
    }



    private void analyzeRisk() {
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



    }

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

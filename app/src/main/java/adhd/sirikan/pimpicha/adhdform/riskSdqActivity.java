package adhd.sirikan.pimpicha.adhdform;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class riskSdqActivity extends AppCompatActivity {
    int riskInt;
    String idString, loginString[],genderString, ageString;
    TextView textView,textView2,spn, spn2, spn3, spn4, spn5, spn6, spn7, spn8, spn9, spn10, spn11, spn12, spn13,
            spn14, spn15, spn16, spn17, spn18, spn19, spn20, spn21, spn22, spn23, spn24, spn25;
    String testText = "jjjjjj",sspn, sspn2, sspn3, sspn4, sspn5, sspn6, sspn7, sspn8, sspn9, sspn10, sspn11, sspn12, sspn13,
            sspn14, sspn15, sspn16, sspn17, sspn18, sspn19, sspn20, sspn21, sspn22, sspn23, sspn24, sspn25, sspn26,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_sdq);
        textView = (TextView) findViewById(R.id.txtRiskSdqShowRisk);
        textView2 = (TextView) findViewById(R.id.txtRiskSdqDate);
        getValueFromIntent();
        analyzeRisk();
        showText();
    }


    private void showText() {
        spn = (TextView) findViewById(R.id.answeSdq1);
        spn2 = (TextView) findViewById(R.id.answeSdq2);
        spn3 = (TextView) findViewById(R.id.answeSdq3);
        spn4 = (TextView) findViewById(R.id.answeSdq4);
        spn5 = (TextView) findViewById(R.id.answeSdq5);
        spn6 = (TextView) findViewById(R.id.answeSdq6);
        spn7= (TextView) findViewById(R.id.answeSdq7);
        spn8 = (TextView) findViewById(R.id.answeSdq8);
        spn9 = (TextView) findViewById(R.id.answeSdq9);
        spn10 = (TextView) findViewById(R.id.answeSdq10);
        spn11 = (TextView) findViewById(R.id.answeSdq11);
        spn12 = (TextView) findViewById(R.id.answeSdq12);
        spn13 = (TextView) findViewById(R.id.answeSdq13);
        spn14 = (TextView) findViewById(R.id.answeSdq14);
        spn15 = (TextView) findViewById(R.id.answeSdq15);
        spn16 = (TextView) findViewById(R.id.answeSdq16);
        spn17 = (TextView) findViewById(R.id.answeSdq17);
        spn18 = (TextView) findViewById(R.id.answeSdq18);
        spn19 = (TextView) findViewById(R.id.answeSdq19);
        spn20 = (TextView) findViewById(R.id.answeSdq20);
        spn21 = (TextView) findViewById(R.id.answeSdq21);
        spn22 = (TextView) findViewById(R.id.answeSdq22);
        spn23 = (TextView) findViewById(R.id.answeSdq23);
        spn24 = (TextView) findViewById(R.id.answeSdq24);
        spn25 = (TextView) findViewById(R.id.answeSdq25);


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

    }


    private void analyzeRisk() {

            if(riskInt>=0&&riskInt<=5){//1
                textView.setText("ปกติ");


            }else if(riskInt==6){
                textView.setText("เสี่ยง");
            }else  if(riskInt>=7&&riskInt<=10){
                textView.setText("มีปัญหา");
            }


        textView2.setText(date);



    }

    private void getValueFromIntent() {
        idString = getIntent().getStringExtra("tmpIndex");
        loginString = getIntent().getStringArrayExtra("Login");
        genderString = getIntent().getStringExtra("gender");
        ageString = getIntent().getStringExtra("age");
        Bundle extras = getIntent().getExtras();
        riskInt = extras.getInt("risk");
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
        date = getIntent().getStringExtra("date");

    }



}

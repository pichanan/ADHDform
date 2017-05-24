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

public class riskSdqActivity extends AppCompatActivity {
    int riskInt;
    String tag = "graphSDQ";
    String idString, loginString[],genderString, ageString,nameString;
    TextView textView,textView2,spn, spn2, spn3, spn4, spn5, spn6, spn7, spn8, spn9, spn10, spn11, spn12, spn13,
            spn14, spn15, spn16, spn17, spn18, spn19, spn20, spn21, spn22, spn23, spn24, spn25;
    String testText = "jjjjjj",sspn, sspn2, sspn3, sspn4, sspn5, sspn6, sspn7, sspn8, sspn9, sspn10, sspn11, sspn12, sspn13,
            sspn14, sspn15, sspn16, sspn17, sspn18, sspn19, sspn20, sspn21, sspn22, sspn23, sspn24, sspn25, sspn26,date;
    Button ImageViewPDF;
    Button button;
    String allRisk = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_sdq);
        textView = (TextView) findViewById(R.id.txtRiskSdqShowRisk);
        //textView2 = (TextView) findViewById(R.id.txtRiskSdqDate);
        getValueFromIntent();
        analyzeRisk();
        //analyzeRisk();
        ImageViewPDF = (Button) findViewById(R.id.pdfSdq);
        ImageViewPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                putIt();



            }




        });
        button = (Button) findViewById(R.id.btnCompareSdq);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(riskSdqActivity.this, Compare3Activity.class);
                intent.putExtra("risk1Int", riskInt);
                intent.putExtra("date", date);
                intent.putExtra("idString", idString);
                intent.putExtra("loginString", loginString);
                intent.putExtra("genderString", genderString);
                intent.putExtra("ageString", ageString);
                Log.d(tag, "Put from Risksnap ==>" + riskInt);


                startActivity(intent);
            }
        });
        showText();
    }

    private void putIt() {
        Intent intent = new Intent(riskSdqActivity.this, PDF3Activity.class);
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
        intent.putExtra("Login", loginString);
        intent.putExtra("tmpIndex", idString);
        intent.putExtra("gender", genderString);
        intent.putExtra("age", ageString);
        intent.putExtra("name", nameString);
        intent.putExtra("risk",riskInt);
        intent.putExtra("date", date);
        intent.putExtra("allRisk", allRisk);
        startActivity(intent);

    }
    private void showText() {
        if(sspn.equals("ไม่จริง")){
            sspn = "0";
            spn = (TextView) findViewById(R.id.sdq1Choice1);
        }else if(sspn.equals("จริงบางครั้ง")){
            sspn = "1";
            spn = (TextView) findViewById(R.id.sdq1Choice2);
        }else if(sspn.equals("จริง")){
            sspn = "2";
            spn = (TextView) findViewById(R.id.sdq1Choice3);
        }


        if(sspn2.equals("ไม่จริง")){
            sspn2 = "0";
            spn2 = (TextView) findViewById(R.id.sdq2Choice1);
        }else if(sspn2.equals("จริงบางครั้ง")){
            sspn2 = "1";
            spn2 = (TextView) findViewById(R.id.sdq2Choice2);
        }else if(sspn2.equals("จริง")){
            sspn2 = "2";
            spn2 = (TextView) findViewById(R.id.sdq2Choice3);
        }

        if(sspn3.equals("ไม่จริง")){
            sspn3 = "0";
            spn3 = (TextView) findViewById(R.id.sdq3Choice1);
        }else if(sspn3.equals("จริงบางครั้ง")){
            sspn3 = "1";
            spn3 = (TextView) findViewById(R.id.sdq3Choice2);
        }else if(sspn3.equals("จริง")){
            sspn3 = "2";
            spn3 = (TextView) findViewById(R.id.sdq3Choice3);
        }

        if(sspn4.equals("ไม่จริง")){
            sspn4 = "0";
            spn4 = (TextView) findViewById(R.id.sdq4Choice1);
        }else if(sspn4.equals("จริงบางครั้ง")){
            sspn4 = "1";
            spn4 = (TextView) findViewById(R.id.sdq4Choice2);
        }else if(sspn4.equals("จริง")){
            sspn4 = "2";
            spn4 = (TextView) findViewById(R.id.sdq4Choice3);
        }

        if(sspn5.equals("ไม่จริง")){
            sspn5 = "0";
            spn5 = (TextView) findViewById(R.id.sdq5Choice1);
        }else if(sspn5.equals("จริงบางครั้ง")){
            sspn5 = "1";
            spn5 = (TextView) findViewById(R.id.sdq5Choice2);
        }else if(sspn5.equals("จริง")){
            sspn5 = "2";
            spn5 = (TextView) findViewById(R.id.sdq5Choice3);
        }

        if(sspn6.equals("ไม่จริง")){
            sspn6 = "0";
            spn6 = (TextView) findViewById(R.id.sdq6Choice1);
        }else if(sspn6.equals("จริงบางครั้ง")){
            sspn6 = "1";
            spn6 = (TextView) findViewById(R.id.sdq6Choice2);
        }else if(sspn6.equals("จริง")){
            sspn6 = "2";
            spn6 = (TextView) findViewById(R.id.sdq6Choice3);
        }

        if(sspn7.equals("ไม่จริง")){
            sspn7 = "0";
            spn7 = (TextView) findViewById(R.id.sdq7Choice1);
        }else if(sspn7.equals("จริงบางครั้ง")){
            sspn7 = "1";
            spn7 = (TextView) findViewById(R.id.sdq7Choice2);
        }else if(sspn7.equals("จริง")){
            sspn7 = "2";
            spn7 = (TextView) findViewById(R.id.sdq7Choice3);
        }

        if(sspn8.equals("ไม่จริง")){
            sspn8 = "0";
            spn8 = (TextView) findViewById(R.id.sdq8Choice1);
        }else if(sspn8.equals("จริงบางครั้ง")){
            sspn8 = "1";
            spn8 = (TextView) findViewById(R.id.sdq8Choice2);
        }else if(sspn8.equals("จริง")){
            sspn8 = "2";
            spn8 = (TextView) findViewById(R.id.sdq8Choice3);
        }

        if(sspn9.equals("ไม่จริง")){
            sspn9 = "0";
            spn9 = (TextView) findViewById(R.id.sdq9Choice1);
        }else if(sspn9.equals("จริงบางครั้ง")){
            sspn9 = "1";
            spn9 = (TextView) findViewById(R.id.sdq9Choice2);
        }else if(sspn9.equals("จริง")){
            sspn9 = "2";
            spn9 = (TextView) findViewById(R.id.sdq9Choice3);
        }

        if(sspn10.equals("ไม่จริง")){
            sspn10 = "0";
            spn10 = (TextView) findViewById(R.id.sdq10Choice1);
        }else if(sspn10.equals("จริงบางครั้ง")){
            sspn10 = "1";
            spn10 = (TextView) findViewById(R.id.sdq10Choice2);
        }else if(sspn10.equals("จริง")){
            sspn10 = "2";
            spn10 = (TextView) findViewById(R.id.sdq10Choice3);
        }

        if(sspn11.equals("ไม่จริง")){
            sspn11 = "0";
            spn11 = (TextView) findViewById(R.id.sdq11Choice1);
        }else if(sspn11.equals("จริงบางครั้ง")){
            sspn11 = "1";
            spn11 = (TextView) findViewById(R.id.sdq11Choice2);
        }else if(sspn11.equals("จริง")){
            sspn11 = "2";
            spn11 = (TextView) findViewById(R.id.sdq11Choice3);
        }

        if(sspn12.equals("ไม่จริง")){
            sspn12 = "0";
            spn12 = (TextView) findViewById(R.id.sdq12Choice1);
        }else if(sspn12.equals("จริงบางครั้ง")){
            sspn12 = "1";
            spn12 = (TextView) findViewById(R.id.sdq12Choice2);
        }else if(sspn12.equals("จริง")){
            sspn12 = "2";
            spn12 = (TextView) findViewById(R.id.sdq12Choice3);
        }

        if(sspn13.equals("ไม่จริง")){
            sspn13 = "0";
            spn13 = (TextView) findViewById(R.id.sdq13Choice1);
        }else if(sspn13.equals("จริงบางครั้ง")){
            sspn13 = "1";
            spn13 = (TextView) findViewById(R.id.sdq13Choice2);
        }else if(sspn13.equals("จริง")){
            sspn13 = "2";
            spn13 = (TextView) findViewById(R.id.sdq13Choice3);
        }

        if(sspn14.equals("ไม่จริง")){
            sspn14 = "0";
            spn14 = (TextView) findViewById(R.id.sdq14Choice1);
        }else if(sspn14.equals("จริงบางครั้ง")){
            sspn14 = "1";
            spn14 = (TextView) findViewById(R.id.sdq14Choice2);
        }else if(sspn14.equals("จริง")){
            sspn14 = "2";
            spn14 = (TextView) findViewById(R.id.sdq14Choice3);
        }

        if(sspn15.equals("ไม่จริง")){
            sspn15 = "0";
            spn15 = (TextView) findViewById(R.id.sdq15Choice1);
        }else if(sspn15.equals("จริงบางครั้ง")){
            sspn15 = "1";
            spn15 = (TextView) findViewById(R.id.sdq15Choice2);
        }else if(sspn15.equals("จริง")){
            sspn15 = "2";
            spn15 = (TextView) findViewById(R.id.sdq15Choice3);
        }

        if(sspn16.equals("ไม่จริง")){
            sspn16 = "0";
            spn16 = (TextView) findViewById(R.id.sdq16Choice1);
        }else if(sspn16.equals("จริงบางครั้ง")){
            sspn16 = "1";
            spn16 = (TextView) findViewById(R.id.sdq16Choice2);
        }else if(sspn16.equals("จริง")){
            sspn16 = "2";
            spn16 = (TextView) findViewById(R.id.sdq16Choice3);
        }

        if(sspn17.equals("ไม่จริง")){
            sspn17 = "0";
            spn17 = (TextView) findViewById(R.id.sdq17Choice1);
        }else if(sspn17.equals("จริงบางครั้ง")){
            sspn17 = "1";
            spn17 = (TextView) findViewById(R.id.sdq17Choice2);
        }else if(sspn17.equals("จริง")){
            sspn17 = "2";
            spn17 = (TextView) findViewById(R.id.sdq17Choice3);
        }

        if(sspn18.equals("ไม่จริง")){
            sspn18 = "0";
            spn18 = (TextView) findViewById(R.id.sdq18Choice1);
        }else if(sspn18.equals("จริงบางครั้ง")){
            sspn18 = "1";
            spn18 = (TextView) findViewById(R.id.sdq18Choice2);
        }else if(sspn18.equals("จริง")){
            sspn18 = "2";
            spn18 = (TextView) findViewById(R.id.sdq18Choice3);
        }

        if(sspn19.equals("ไม่จริง")){
            sspn19 = "0";
            spn19 = (TextView) findViewById(R.id.sdq19Choice1);
        }else if(sspn19.equals("จริงบางครั้ง")){
            sspn19 = "1";
            spn19 = (TextView) findViewById(R.id.sdq19Choice2);
        }else if(sspn19.equals("จริง")){
            sspn19 = "2";
            spn19 = (TextView) findViewById(R.id.sdq19Choice3);
        }

        if(sspn20.equals("ไม่จริง")){
            sspn20 = "0";
            spn20 = (TextView) findViewById(R.id.sdq20Choice1);
        }else if(sspn20.equals("จริงบางครั้ง")){
            sspn20 = "1";
            spn20 = (TextView) findViewById(R.id.sdq20Choice2);
        }else if(sspn20.equals("จริง")){
            sspn20 = "2";
            spn20 = (TextView) findViewById(R.id.sdq20Choice3);
        }

        if(sspn21.equals("ไม่จริง")){
            sspn21 = "0";
            spn21 = (TextView) findViewById(R.id.sdq21Choice1);
        }else if(sspn21.equals("จริงบางครั้ง")){
            sspn21 = "1";
            spn21 = (TextView) findViewById(R.id.sdq21Choice2);
        }else if(sspn21.equals("จริง")){
            sspn21 = "2";
            spn21 = (TextView) findViewById(R.id.sdq21Choice3);
        }

        if(sspn22.equals("ไม่จริง")){
            sspn22 = "0";
            spn22 = (TextView) findViewById(R.id.sdq22Choice1);
        }else if(sspn22.equals("จริงบางครั้ง")){
            sspn22 = "1";
            spn22 = (TextView) findViewById(R.id.sdq22Choice2);
        }else if(sspn22.equals("จริง")){
            sspn22 = "2";
            spn22 = (TextView) findViewById(R.id.sdq22Choice3);
        }

        if(sspn23.equals("ไม่จริง")){
            sspn23 = "0";
            spn23 = (TextView) findViewById(R.id.sdq23Choice1);
        }else if(sspn23.equals("จริงบางครั้ง")){
            sspn23 = "1";
            spn23 = (TextView) findViewById(R.id.sdq23Choice2);
        }else if(sspn23.equals("จริง")){
            sspn23 = "2";
            spn23 = (TextView) findViewById(R.id.sdq23Choice3);
        }

        if(sspn24.equals("ไม่จริง")){
            sspn24 = "0";
            spn24 = (TextView) findViewById(R.id.sdq24Choice1);
        }else if(sspn24.equals("จริงบางครั้ง")){
            sspn24 = "1";
            spn24 = (TextView) findViewById(R.id.sdq24Choice2);
        }else if(sspn24.equals("จริง")){
            sspn24 = "2";
            spn24 = (TextView) findViewById(R.id.sdq24Choice3);
        }

        if(sspn25.equals("ไม่จริง")){
            sspn25 = "0";
            spn25 = (TextView) findViewById(R.id.sdq25Choice1);
        }else if(sspn25.equals("จริงบางครั้ง")){
            sspn25 = "1";
            spn25 = (TextView) findViewById(R.id.sdq25Choice2);
        }else if(sspn25.equals("จริง")){
            sspn25 = "2";
            spn25 = (TextView) findViewById(R.id.sdq25Choice3);
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


    private void analyzeRisk() {

            if(riskInt>=0&&riskInt<=5){//1
                allRisk = "ปกติ";

            }else if(riskInt==6){
                allRisk = "เสี่ยง";

            }else  if(riskInt>=7&&riskInt<=10){
                allRisk = "มีปัญหา";
            }
        textView.setText(allRisk);

    }

    private void getValueFromIntent() {
        idString = getIntent().getStringExtra("tmpIndex");
        loginString = getIntent().getStringArrayExtra("Login");
        genderString = getIntent().getStringExtra("gender");
        ageString = getIntent().getStringExtra("age");
        nameString = getIntent().getStringExtra("name");
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

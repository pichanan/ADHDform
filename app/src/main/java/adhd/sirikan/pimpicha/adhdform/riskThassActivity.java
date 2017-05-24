package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class riskThassActivity extends AppCompatActivity {
    TextView  textView2,spn, spn2, spn3, spn4, spn5, spn6, spn7, spn8, spn9, spn10, spn11, spn12, spn13,
            spn14, spn15, spn16, spn17, spn18, spn19, spn20, spn21, spn22, spn23, spn24, spn25, spn26, spn27, spn28, spn29, spn30;
    String idString, loginString[],genderString, ageString,nameString;
    int risk1Int,risk2Int,risk3Int ;
    String sspn, sspn2, sspn3, sspn4, sspn5, sspn6, sspn7, sspn8, sspn9, sspn10, sspn11, sspn12, sspn13,
            sspn14, sspn15, sspn16, sspn17, sspn18, sspn19, sspn20, sspn21, sspn22, sspn23, sspn24, sspn25, sspn26
            , sspn27, sspn28, sspn29, sspn30,date;
    String strq1, strq2, strq3, strq4, strq5, strq6, strq7, strq8, strq9, strq10, strq11, strq12, strq13,
            strq14, strq15, strq16, strq17, strq18, strq19, strq20, strq21, strq22, strq23, strq24, strq25,
            strq26, strq27, strq28, strq29, strq30;

    Button button,button2,ImageViewPDF;
    String tag = "ThassIntent";
    TextView t, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13,
            t14, t15, t16, t17, t18, t19, t20, t21, t22, t23, t24, t25,
            t26, t27, t28, t29, t30;
    TextView textView;
    String txtRisk1="",txtRisk2="", txtRisk3="",allrisk="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_thass);
        textView = (TextView) findViewById(R.id.thassRisk);
        button = (Button) findViewById(R.id.btnCompareThass);
        getValueFromIntent();
        //analyzeRisk();
        showText();
        analyzeRisk();
        ImageViewPDF = (Button) findViewById(R.id.pdfThass);
        button2 = (Button) findViewById(R.id.recThass);
        ImageViewPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                putIt();



            }




        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(riskThassActivity.this, RecommendActivity.class);
                intent.putExtra("Login", loginString);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(riskThassActivity.this, Compare2Activity.class);
                intent.putExtra("risk1", risk1Int);
                intent.putExtra("risk2", risk2Int);
                intent.putExtra("risk3", risk3Int);
                intent.putExtra("date", date);
                intent.putExtra("idString", idString);
                intent.putExtra("loginString", loginString);
                intent.putExtra("genderString", genderString);
                intent.putExtra("ageString", ageString);
                Log.d(tag, "Put from Risksnap ==>" + risk1Int + " " + risk2Int + " " + risk3Int);


                startActivity(intent);
            }
        });
    }

    private void putIt() {
        Intent intent = new Intent(riskThassActivity.this, PDF2Activity.class);
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
        intent.putExtra("sspn27", sspn27);
        intent.putExtra("sspn28", sspn28);
        intent.putExtra("sspn29", sspn29);
        intent.putExtra("sspn30", sspn30);
        intent.putExtra("strq1",strq1);
        intent.putExtra("strq2",strq2);
        intent.putExtra("strq3",strq3);
        intent.putExtra("strq4",strq4);
        intent.putExtra("strq5",strq5);
        intent.putExtra("strq6",strq6);
        intent.putExtra("strq7",strq7);
        intent.putExtra("strq8",strq8);
        intent.putExtra("strq9",strq9);
        intent.putExtra("strq10",strq10);
        intent.putExtra("strq11",strq11);
        intent.putExtra("strq12",strq12);
        intent.putExtra("strq13",strq13);
        intent.putExtra("strq14",strq14);
        intent.putExtra("strq15",strq15);
        intent.putExtra("strq16",strq16);
        intent.putExtra("strq17",strq17);
        intent.putExtra("strq18",strq18);
        intent.putExtra("strq19",strq19);
        intent.putExtra("strq20",strq20);
        intent.putExtra("strq21",strq21);
        intent.putExtra("strq22",strq22);
        intent.putExtra("strq23",strq23);
        intent.putExtra("strq24",strq24);
        intent.putExtra("strq25",strq25);
        intent.putExtra("strq26",strq26);
        intent.putExtra("strq27",strq27);
        intent.putExtra("strq28",strq28);
        intent.putExtra("strq29",strq29);
        intent.putExtra("strq30",strq30);
        intent.putExtra("risk1", risk1Int);
        intent.putExtra("risk2", risk2Int);
        intent.putExtra("risk3", risk3Int);
        intent.putExtra("date", date);
        intent.putExtra("gender", genderString);
        intent.putExtra("age", ageString);
        intent.putExtra("name", nameString);
        intent.putExtra("Login", loginString);
        intent.putExtra("allrisk", allrisk);
        startActivity(intent);

    }


    private void showText() {
        if(sspn.equals("ไม่เคยทำ")){
            sspn = "0";
            spn = (TextView) findViewById(R.id.thass1Choice1);
        }else if(sspn.equals("นานๆทำที")){
            sspn = "1";
            spn = (TextView) findViewById(R.id.thass1Choice2);
        }else if(sspn.equals("ทำค่อนข้างบ่อย")){
            sspn = "2";
            spn = (TextView) findViewById(R.id.thass1Choice3);
        }else{
            sspn = "3";
            spn = (TextView) findViewById(R.id.thass1Choice4);
        }


        if(sspn2.equals("ไม่เคยทำ")){
            sspn2 = "0";
            spn2 = (TextView) findViewById(R.id.thass2Choice1);
        }else if(sspn2.equals("นานๆทำที")){
            sspn2 = "1";
            spn2 = (TextView) findViewById(R.id.thass2Choice2);
        }else if(sspn2.equals("ทำค่อนข้างบ่อย")){
            sspn2 = "2";
            spn2 = (TextView) findViewById(R.id.thass2Choice3);
        }else{
            sspn2 = "3";
            spn2 = (TextView) findViewById(R.id.thass2Choice4);
        }

        if(sspn3.equals("ไม่เคยทำ")){
            sspn3 = "0";
            spn3 = (TextView) findViewById(R.id.thass3Choice1);
        }else if(sspn3.equals("นานๆทำที")){
            sspn3 = "1";
            spn3 = (TextView) findViewById(R.id.thass3Choice2);
        }else if(sspn3.equals("ทำค่อนข้างบ่อย")){
            sspn3 = "2";
            spn3 = (TextView) findViewById(R.id.thass3Choice3);
        }else{
            sspn3 = "3";
            spn3 = (TextView) findViewById(R.id.thass3Choice4);
        }

        if(sspn4.equals("ไม่เคยทำ")){
            sspn4 = "0";
            spn4 = (TextView) findViewById(R.id.thass4Choice1);
        }else if(sspn4.equals("นานๆทำที")){
            sspn4 = "1";
            spn4 = (TextView) findViewById(R.id.thass4Choice2);
        }else if(sspn4.equals("ทำค่อนข้างบ่อย")){
            sspn4 = "2";
            spn4 = (TextView) findViewById(R.id.thass4Choice3);
        }else{
            sspn4 = "3";
            spn4 = (TextView) findViewById(R.id.thass4Choice4);
        }

        if(sspn5.equals("ไม่เคยทำ")){
            sspn5 = "0";
            spn5 = (TextView) findViewById(R.id.thass5Choice1);
        }else if(sspn5.equals("นานๆทำที")){
            sspn5 = "1";
            spn5 = (TextView) findViewById(R.id.thass5Choice2);
        }else if(sspn5.equals("ทำค่อนข้างบ่อย")){
            sspn5 = "2";
            spn5 = (TextView) findViewById(R.id.thass5Choice3);
        }else{
            sspn5 = "3";
            spn5 = (TextView) findViewById(R.id.thass5Choice4);
        }

        if(sspn6.equals("ไม่เคยทำ")){
            sspn6 = "0";
            spn6 = (TextView) findViewById(R.id.thass6Choice1);
        }else if(sspn6.equals("นานๆทำที")){
            sspn6 = "1";
            spn6 = (TextView) findViewById(R.id.thass6Choice2);
        }else if(sspn6.equals("ทำค่อนข้างบ่อย")){
            sspn6 = "2";
            spn6 = (TextView) findViewById(R.id.thass6Choice3);
        }else{
            sspn6 = "3";
            spn6 = (TextView) findViewById(R.id.thass6Choice4);
        }

        if(sspn7.equals("ไม่เคยทำ")){
            sspn7 = "0";
            spn7 = (TextView) findViewById(R.id.thass7Choice1);
        }else if(sspn7.equals("นานๆทำที")){
            sspn7 = "1";
            spn7 = (TextView) findViewById(R.id.thass7Choice2);
        }else if(sspn7.equals("ทำค่อนข้างบ่อย")){
            sspn7 = "2";
            spn7 = (TextView) findViewById(R.id.thass7Choice3);
        }else{
            sspn7 = "3";
            spn7 = (TextView) findViewById(R.id.thass7Choice4);
        }

        if(sspn8.equals("ไม่เคยทำ")){
            sspn8 = "0";
            spn8 = (TextView) findViewById(R.id.thass8Choice1);
        }else if(sspn8.equals("นานๆทำที")){
            sspn8 = "1";
            spn8 = (TextView) findViewById(R.id.thass8Choice2);
        }else if(sspn8.equals("ทำค่อนข้างบ่อย")){
            sspn8 = "2";
            spn8 = (TextView) findViewById(R.id.thass8Choice3);
        }else{
            sspn8 = "3";
            spn8 = (TextView) findViewById(R.id.thass8Choice4);
        }

        if(sspn9.equals("ไม่เคยทำ")){
            sspn9 = "0";
            spn9 = (TextView) findViewById(R.id.thass9Choice1);
        }else if(sspn9.equals("นานๆทำที")){
            sspn9 = "1";
            spn9 = (TextView) findViewById(R.id.thass9Choice2);
        }else if(sspn9.equals("ทำค่อนข้างบ่อย")){
            sspn9 = "2";
            spn9 = (TextView) findViewById(R.id.thass9Choice3);
        }else{
            sspn9 = "3";
            spn9 = (TextView) findViewById(R.id.thass9Choice4);
        }

        if(sspn10.equals("ไม่เคยทำ")){
            sspn10 = "0";
            spn10 = (TextView) findViewById(R.id.thass10Choice1);
        }else if(sspn10.equals("นานๆทำที")){
            sspn10 = "1";
            spn10 = (TextView) findViewById(R.id.thass10Choice2);
        }else if(sspn10.equals("ทำค่อนข้างบ่อย")){
            sspn10 = "2";
            spn10 = (TextView) findViewById(R.id.thass10Choice3);
        }else{
            sspn10 = "3";
            spn10 = (TextView) findViewById(R.id.thass10Choice4);
        }

        if(sspn11.equals("ไม่เคยทำ")){
            sspn11 = "0";
            spn11 = (TextView) findViewById(R.id.thass11Choice1);
        }else if(sspn11.equals("นานๆทำที")){
            sspn11 = "1";
            spn11 = (TextView) findViewById(R.id.thass11Choice2);
        }else if(sspn11.equals("ทำค่อนข้างบ่อย")){
            sspn11 = "2";
            spn11 = (TextView) findViewById(R.id.thass11Choice3);
        }else{
            sspn11 = "3";
            spn11 = (TextView) findViewById(R.id.thass11Choice4);
        }

        if(sspn12.equals("ไม่เคยทำ")){
            sspn12 = "0";
            spn12 = (TextView) findViewById(R.id.thass12Choice1);
        }else if(sspn12.equals("นานๆทำที")){
            sspn12 = "1";
            spn12 = (TextView) findViewById(R.id.thass12Choice2);
        }else if(sspn12.equals("ทำค่อนข้างบ่อย")){
            sspn12 = "2";
            spn12 = (TextView) findViewById(R.id.thass12Choice3);
        }else{
            sspn12 = "3";
            spn12 = (TextView) findViewById(R.id.thass12Choice4);
        }

        if(sspn13.equals("ไม่เคยทำ")){
            sspn13 = "0";
            spn13 = (TextView) findViewById(R.id.thass13Choice1);
        }else if(sspn13.equals("นานๆทำที")){
            sspn13 = "1";
            spn13 = (TextView) findViewById(R.id.thass13Choice2);
        }else if(sspn13.equals("ทำค่อนข้างบ่อย")){
            sspn13 = "2";
            spn13 = (TextView) findViewById(R.id.thass13Choice3);
        }else{
            sspn13 = "3";
            spn13 = (TextView) findViewById(R.id.thass13Choice4);
        }

        if(sspn14.equals("ไม่เคยทำ")){
            sspn14 = "0";
            spn14 = (TextView) findViewById(R.id.thass14Choice1);
        }else if(sspn14.equals("นานๆทำที")){
            sspn14 = "1";
            spn14 = (TextView) findViewById(R.id.thass14Choice2);
        }else if(sspn14.equals("ทำค่อนข้างบ่อย")){
            sspn14 = "2";
            spn14 = (TextView) findViewById(R.id.thass14Choice3);
        }else{
            sspn14 = "3";
            spn14 = (TextView) findViewById(R.id.thass14Choice4);
        }

        if(sspn15.equals("ไม่เคยทำ")){
            sspn15 = "0";
            spn15 = (TextView) findViewById(R.id.thass15Choice1);
        }else if(sspn15.equals("นานๆทำที")){
            sspn15 = "1";
            spn15 = (TextView) findViewById(R.id.thass15Choice2);
        }else if(sspn15.equals("ทำค่อนข้างบ่อย")){
            sspn15 = "2";
            spn15 = (TextView) findViewById(R.id.thass15Choice3);
        }else{
            sspn15 = "3";
            spn15 = (TextView) findViewById(R.id.thass15Choice4);
        }

        if(sspn16.equals("ไม่เคยทำ")){
            sspn16 = "0";
            spn16 = (TextView) findViewById(R.id.thass16Choice1);
        }else if(sspn16.equals("นานๆทำที")){
            sspn16 = "1";
            spn16 = (TextView) findViewById(R.id.thass16Choice2);
        }else if(sspn16.equals("ทำค่อนข้างบ่อย")){
            sspn16 = "2";
            spn16 = (TextView) findViewById(R.id.thass16Choice3);
        }else{
            sspn16 = "3";
            spn16 = (TextView) findViewById(R.id.thass16Choice4);
        }

        if(sspn17.equals("ไม่เคยทำ")){
            sspn17 = "0";
            spn17 = (TextView) findViewById(R.id.thass17Choice1);
        }else if(sspn17.equals("นานๆทำที")){
            sspn17 = "1";
            spn17 = (TextView) findViewById(R.id.thass17Choice2);
        }else if(sspn17.equals("ทำค่อนข้างบ่อย")){
            sspn17 = "2";
            spn17 = (TextView) findViewById(R.id.thass17Choice3);
        }else{
            sspn17 = "3";
            spn17 = (TextView) findViewById(R.id.thass17Choice4);
        }

        if(sspn18.equals("ไม่เคยทำ")){
            sspn18 = "0";
            spn18 = (TextView) findViewById(R.id.thass18Choice1);
        }else if(sspn18.equals("นานๆทำที")){
            sspn18 = "1";
            spn18 = (TextView) findViewById(R.id.thass18Choice2);
        }else if(sspn18.equals("ทำค่อนข้างบ่อย")){
            sspn18 = "2";
            spn18 = (TextView) findViewById(R.id.thass18Choice3);
        }else{
            sspn18 = "3";
            spn18 = (TextView) findViewById(R.id.thass18Choice4);
        }

        if(sspn19.equals("ไม่เคยทำ")){
            sspn19 = "0";
            spn19 = (TextView) findViewById(R.id.thass19Choice1);
        }else if(sspn19.equals("นานๆทำที")){
            sspn19 = "1";
            spn19 = (TextView) findViewById(R.id.thass19Choice2);
        }else if(sspn19.equals("ทำค่อนข้างบ่อย")){
            sspn19 = "2";
            spn19 = (TextView) findViewById(R.id.thass19Choice3);
        }else{
            sspn19 = "3";
            spn19 = (TextView) findViewById(R.id.thass19Choice4);
        }

        if(sspn20.equals("ไม่เคยทำ")){
            sspn20 = "0";
            spn20 = (TextView) findViewById(R.id.thass20Choice1);
        }else if(sspn20.equals("นานๆทำที")){
            sspn20 = "1";
            spn20 = (TextView) findViewById(R.id.thass20Choice2);
        }else if(sspn20.equals("ทำค่อนข้างบ่อย")){
            sspn20 = "2";
            spn20 = (TextView) findViewById(R.id.thass20Choice3);
        }else{
            sspn20 = "3";
            spn20 = (TextView) findViewById(R.id.thass20Choice4);
        }

        if(sspn21.equals("ไม่เคยทำ")){
            sspn21 = "0";
            spn21 = (TextView) findViewById(R.id.thass21Choice1);
        }else if(sspn21.equals("นานๆทำที")){
            sspn21 = "1";
            spn21 = (TextView) findViewById(R.id.thass21Choice2);
        }else if(sspn21.equals("ทำค่อนข้างบ่อย")){
            sspn21 = "2";
            spn21 = (TextView) findViewById(R.id.thass21Choice3);
        }else{
            sspn21 = "3";
            spn21 = (TextView) findViewById(R.id.thass21Choice4);
        }

        if(sspn22.equals("ไม่เคยทำ")){
            sspn22 = "0";
            spn22 = (TextView) findViewById(R.id.thass22Choice1);
        }else if(sspn22.equals("นานๆทำที")){
            sspn22 = "1";
            spn22 = (TextView) findViewById(R.id.thass22Choice2);
        }else if(sspn22.equals("ทำค่อนข้างบ่อย")){
            sspn22 = "2";
            spn22 = (TextView) findViewById(R.id.thass22Choice3);
        }else{
            sspn22 = "3";
            spn22 = (TextView) findViewById(R.id.thass22Choice4);
        }

        if(sspn23.equals("ไม่เคยทำ")){
            sspn23 = "0";
            spn23 = (TextView) findViewById(R.id.thass23Choice1);
        }else if(sspn23.equals("นานๆทำที")){
            sspn23 = "1";
            spn23 = (TextView) findViewById(R.id.thass23Choice2);
        }else if(sspn23.equals("ทำค่อนข้างบ่อย")){
            sspn23 = "2";
            spn23 = (TextView) findViewById(R.id.thass23Choice3);
        }else{
            sspn23 = "3";
            spn23 = (TextView) findViewById(R.id.thass23Choice4);
        }

        if(sspn24.equals("ไม่เคยทำ")){
            sspn24 = "0";
            spn24 = (TextView) findViewById(R.id.thass24Choice1);
        }else if(sspn24.equals("นานๆทำที")){
            sspn24 = "1";
            spn24 = (TextView) findViewById(R.id.thass24Choice2);
        }else if(sspn24.equals("ทำค่อนข้างบ่อย")){
            sspn24 = "2";
            spn24 = (TextView) findViewById(R.id.thass24Choice3);
        }else{
            sspn24 = "3";
            spn24 = (TextView) findViewById(R.id.thass24Choice4);
        }

        if(sspn25.equals("ไม่เคยทำ")){
            sspn25 = "0";
            spn25 = (TextView) findViewById(R.id.thass25Choice1);
        }else if(sspn25.equals("นานๆทำที")){
            sspn25 = "1";
            spn25 = (TextView) findViewById(R.id.thass25Choice2);
        }else if(sspn25.equals("ทำค่อนข้างบ่อย")){
            sspn25 = "2";
            spn25 = (TextView) findViewById(R.id.thass25Choice3);
        }else{
            sspn25 = "3";
            spn25 = (TextView) findViewById(R.id.thass25Choice4);
        }

        if(sspn26.equals("ไม่เคยทำ")){
            sspn26 = "0";
            spn26 = (TextView) findViewById(R.id.thass26Choice1);
        }else if(sspn26.equals("นานๆทำที")){
            sspn26 = "1";
            spn26 = (TextView) findViewById(R.id.thass26Choice2);
        }else if(sspn26.equals("ทำค่อนข้างบ่อย")){
            sspn26 = "2";
            spn26 = (TextView) findViewById(R.id.thass26Choice3);
        }else{
            sspn26 = "3";
            spn26 = (TextView) findViewById(R.id.thass26Choice4);
        }

        if(sspn27.equals("ไม่เคยทำ")){
            sspn27 = "0";
            spn27 = (TextView) findViewById(R.id.thass27Choice1);
        }else if(sspn27.equals("นานๆทำที")){
            sspn27 = "1";
            spn27 = (TextView) findViewById(R.id.thass27Choice2);
        }else if(sspn27.equals("ทำค่อนข้างบ่อย")){
            sspn27 = "2";
            spn27 = (TextView) findViewById(R.id.thass27Choice3);
        }else{
            sspn27 = "3";
            spn27 = (TextView) findViewById(R.id.thass27Choice4);
        }

        if(sspn28.equals("ไม่เคยทำ")){
            sspn28 = "0";
            spn28 = (TextView) findViewById(R.id.thass28Choice1);
        }else if(sspn28.equals("นานๆทำที")){
            sspn28 = "1";
            spn28 = (TextView) findViewById(R.id.thass28Choice2);
        }else if(sspn28.equals("ทำค่อนข้างบ่อย")){
            sspn28 = "2";
            spn28 = (TextView) findViewById(R.id.thass28Choice3);
        }else{
            sspn28 = "3";
            spn28 = (TextView) findViewById(R.id.thass28Choice4);
        }

        if(sspn29.equals("ไม่เคยทำ")){
            sspn29 = "0";
            spn29 = (TextView) findViewById(R.id.thass29Choice1);
        }else if(sspn29.equals("นานๆทำที")){
            sspn29 = "1";
            spn29 = (TextView) findViewById(R.id.thass29Choice2);
        }else if(sspn29.equals("ทำค่อนข้างบ่อย")){
            sspn29 = "2";
            spn29 = (TextView) findViewById(R.id.thass29Choice3);
        }else{
            sspn29 = "3";
            spn29 = (TextView) findViewById(R.id.thass29Choice4);
        }

        if(sspn30.equals("ไม่เคยทำ")){
            sspn30 = "0";
            spn30 = (TextView) findViewById(R.id.thass30Choice1);
        }else if(sspn30.equals("นานๆทำที")){
            sspn30 = "1";
            spn30 = (TextView) findViewById(R.id.thass30Choice2);
        }else if(sspn30.equals("ทำค่อนข้างบ่อย")){
            sspn30 = "2";
            spn30 = (TextView) findViewById(R.id.thass30Choice3);
        }else{
            sspn30 = "3";
            spn30 = (TextView) findViewById(R.id.thass30Choice4);
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
        t = (TextView) findViewById(R.id.riskq1);
        t2 = (TextView) findViewById(R.id.riskq2);
        t3 = (TextView) findViewById(R.id.riskq3);
        t4 = (TextView) findViewById(R.id.riskq4);
        t5 = (TextView) findViewById(R.id.riskq5);
        t6 = (TextView) findViewById(R.id.riskq6);
        t7 = (TextView) findViewById(R.id.riskq7);
        t8 = (TextView) findViewById(R.id.riskq8);
        t9 = (TextView) findViewById(R.id.riskq9);
        t10 = (TextView) findViewById(R.id.riskq10);
        t11 = (TextView) findViewById(R.id.riskq11);
        t12 = (TextView) findViewById(R.id.riskq12);
        t13 = (TextView) findViewById(R.id.riskq13);
        t14 = (TextView) findViewById(R.id.riskq14);
        t15 = (TextView) findViewById(R.id.riskq15);
        t16 = (TextView) findViewById(R.id.riskq16);
        t17 = (TextView) findViewById(R.id.riskq17);
        t18 = (TextView) findViewById(R.id.riskq18);
        t19 = (TextView) findViewById(R.id.riskq19);
        t20 = (TextView) findViewById(R.id.riskq20);
        t21 = (TextView) findViewById(R.id.riskq21);
        t22 = (TextView) findViewById(R.id.riskq22);
        t23 = (TextView) findViewById(R.id.riskq23);
        t24 = (TextView) findViewById(R.id.riskq24);
        t25 = (TextView) findViewById(R.id.riskq25);
        t26 = (TextView) findViewById(R.id.riskq26);
        t27 = (TextView) findViewById(R.id.riskq27);
        t28 = (TextView) findViewById(R.id.riskq28);
        t29 = (TextView) findViewById(R.id.riskq29);
        t30 = (TextView) findViewById(R.id.riskq30);
        t.setText(strq1);
        t2.setText(strq2);
        t3.setText(strq3);
        t4.setText(strq4);
        t5.setText(strq5);
        t6.setText(strq6);
        t7.setText(strq7);
        t8.setText(strq8);
        t9.setText(strq9);
        t10.setText(strq10);
        t11.setText(strq11);
        t12.setText(strq12);
        t13.setText(strq13);
        t14.setText(strq14);
        t15.setText(strq15);
        t16.setText(strq16);
        t17.setText(strq17);
        t18.setText(strq18);
        t19.setText(strq19);
        t20.setText(strq20);
        t21.setText(strq21);
        t22.setText(strq22);
        t23.setText(strq23);
        t24.setText(strq24);
        t25.setText(strq25);
        t26.setText(strq26);
        t27.setText(strq27);
        t28.setText(strq28);
        t29.setText(strq29);
        t30.setText(strq30);
    }
    private void analyzeRisk() {

        if(risk1Int>=51&&risk1Int<=60){//1 ควรเฝ้าระวัง ติดตาม ทำแบบคัดกรองซ้ำ
            txtRisk1 = "=> อาจมีความเสี่ยงต่อการเป็นโรคสมาธิสั้นเล็กน้อยด้าน อาการซนวู่วาม (ควรเฝ้าระวัง ติดตาม ทำแบบคัดกรองซ้ำ)";

        }else if(risk1Int>=61&&risk1Int<=70){
            txtRisk1 = "=> เริ่มมีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน อาการซนวู่วาม (ควรให้การช่วยเหลือเบื้องต้นและติดตามผล)";
        }else if(risk1Int>=71) {//1 มีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน      ... ควรนำเด็กไปพบแพทย์ทันทีเพื่อเข้าสู่กระบวนการวินิจฉัยและยืนยันผลอย่างถูกต้อง
            txtRisk1 = "=> มีความเสี่ยงต่อการเป็นโรคสมาธิสั้นด้าน อาการซนวู่วาม สูง (ควรนำเด็กไปพบแพทย์ทันทีเพื่อเข้าสู่กระบวนการวินิจฉัยและยืนยันผลอย่างถูกต้อง)";
        }else{
            txtRisk1 = "=> ไม่มีความเสี่ยงต่อการเป็นโรคสมาธิสั้นด้าน อาการซนวู่วาม";
        }

        if(risk2Int>=51&&risk2Int<=60){//1 ควรเฝ้าระวัง ติดตาม ทำแบบคัดกรองซ้ำ
            txtRisk2 = "=> อาจมีความเสี่ยงต่อการเป็นโรคสมาธิสั้นเล็กน้อยด้าน อาการขาดสมาธิ (ควรเฝ้าระวัง ติดตาม ทำแบบคัดกรองซ้ำ)";

        }else if(risk2Int>=61&&risk2Int<=70){
            txtRisk2 = "=> เริ่มมีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน อาการขาดสมาธิ (ควรให้การช่วยเหลือเบื้องต้นและติดตามผล)";
        }else if(risk2Int>=71) {//1 มีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน      ... ควรนำเด็กไปพบแพทย์ทันทีเพื่อเข้าสู่กระบวนการวินิจฉัยและยืนยันผลอย่างถูกต้อง
            txtRisk2 = "=> มีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน อาการขาดสมาธิ สูง (ควรนำเด็กไปพบแพทย์ทันทีเพื่อเข้าสู่กระบวนการวินิจฉัยและยืนยันผลอย่างถูกต้อง)";
        }else{
            txtRisk2 = "=> ไม่มีความเสี่ยงต่อการเป็นโรคสมาธิสั้นด้าน อาการซนวู่วาม";
        }


        if(risk3Int>=51&&risk3Int<=60){//1 ควรเฝ้าระวัง ติดตาม ทำแบบคัดกรองซ้ำ
            txtRisk3 = "=> อาจมีความเสี่ยงต่อการเป็นโรคสมาธิสั้นเล็กน้อยโดยรวม (ควรเฝ้าระวัง ติดตาม ทำแบบคัดกรองซ้ำ)";

        }else if(risk3Int>=61&&risk3Int<=70){
            txtRisk3 = "=> เริ่มมีความเสี่ยงต่องการเป็นโรคสมาธิสั้นโดยรวม (ควรให้การช่วยเหลือเบื้องต้นและติดตามผล)";
        }else if(risk3Int>=71) {//1 มีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน      ... ควรนำเด็กไปพบแพทย์ทันทีเพื่อเข้าสู่กระบวนการวินิจฉัยและยืนยันผลอย่างถูกต้อง
            txtRisk3 = "=> มีความเสี่ยงต่องการเป็นโรคสมาธิสั้นโดยรวม สูง (ควรนำเด็กไปพบแพทย์ทันทีเพื่อเข้าสู่กระบวนการวินิจฉัยและยืนยันผลอย่างถูกต้อง)";
        }

        if (txtRisk3.equals("") && txtRisk2.equals("") && txtRisk3.equals("")) {

            textView.setText("อยู่ในเกณฑ์ปกติ");
        }else{
            allrisk = txtRisk3+"\n"+txtRisk1 +"\n"+ txtRisk2  ;
            textView.setText(allrisk);
        }


    }

    private void getValueFromIntent() {
        idString = getIntent().getStringExtra("tmpIndex");
        loginString = getIntent().getStringArrayExtra("Login");
        genderString = getIntent().getStringExtra("gender");
        ageString = getIntent().getStringExtra("age");
        nameString = getIntent().getStringExtra("name");
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
        sspn27 = getIntent().getStringExtra("ans27");
        sspn28 = getIntent().getStringExtra("ans28");
        sspn29 = getIntent().getStringExtra("ans29");
        sspn30 = getIntent().getStringExtra("ans30");
        strq1 = getIntent().getStringExtra("strq1");
        strq2 = getIntent().getStringExtra("strq2");
        strq3 = getIntent().getStringExtra("strq3");
        strq4 = getIntent().getStringExtra("strq4");
        strq5 = getIntent().getStringExtra("strq5");
        strq6 = getIntent().getStringExtra("strq6");
        strq7 = getIntent().getStringExtra("strq7");
        strq8 = getIntent().getStringExtra("strq8");
        strq9 = getIntent().getStringExtra("strq9");
        strq10 = getIntent().getStringExtra("strq10");
        strq11 = getIntent().getStringExtra("strq11");
        strq12 = getIntent().getStringExtra("strq12");
        strq13 = getIntent().getStringExtra("strq13");
        strq14 = getIntent().getStringExtra("strq14");
        strq15 = getIntent().getStringExtra("strq15");
        strq16 = getIntent().getStringExtra("strq16");
        strq17 = getIntent().getStringExtra("strq17");
        strq18 = getIntent().getStringExtra("strq18");
        strq19 = getIntent().getStringExtra("strq19");
        strq20 = getIntent().getStringExtra("strq20");
        strq21 = getIntent().getStringExtra("strq21");
        strq22 = getIntent().getStringExtra("strq22");
        strq23 = getIntent().getStringExtra("strq23");
        strq24 = getIntent().getStringExtra("strq24");
        strq25 = getIntent().getStringExtra("strq25");
        strq26 = getIntent().getStringExtra("strq26");
        strq27 = getIntent().getStringExtra("strq27");
        strq28 = getIntent().getStringExtra("strq28");
        strq29 = getIntent().getStringExtra("strq29");
        strq30 = getIntent().getStringExtra("strq30");
        date = getIntent().getStringExtra("date");



    }
}

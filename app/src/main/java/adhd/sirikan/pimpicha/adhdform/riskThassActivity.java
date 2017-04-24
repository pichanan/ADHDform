package adhd.sirikan.pimpicha.adhdform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class riskThassActivity extends AppCompatActivity {
    TextView textView, textView2,spn, spn2, spn3, spn4, spn5, spn6, spn7, spn8, spn9, spn10, spn11, spn12, spn13,
            spn14, spn15, spn16, spn17, spn18, spn19, spn20, spn21, spn22, spn23, spn24, spn25, spn26, spn27, spn28, spn29, spn30;
    String idString, loginString[],genderString, ageString;
    int risk1Int,risk2Int,risk3Int ;
    String sspn, sspn2, sspn3, sspn4, sspn5, sspn6, sspn7, sspn8, sspn9, sspn10, sspn11, sspn12, sspn13,
            sspn14, sspn15, sspn16, sspn17, sspn18, sspn19, sspn20, sspn21, sspn22, sspn23, sspn24, sspn25, sspn26
            , sspn27, sspn28, sspn29, sspn30,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_thass);
        textView = (TextView) findViewById(R.id.txtRiskThassShowRisk);
        textView2 = (TextView) findViewById(R.id.txtRiskThassDate);
        getValueFromIntent();
        analyzeRisk();
        showText();
    }


    private void showText() {
        spn = (TextView) findViewById(R.id.answethass1);
        spn2 = (TextView) findViewById(R.id.answethass2);
        spn3 = (TextView) findViewById(R.id.answethass3);
        spn4 = (TextView) findViewById(R.id.answethass4);
        spn5 = (TextView) findViewById(R.id.answethass5);
        spn6 = (TextView) findViewById(R.id.answethass6);
        spn7= (TextView) findViewById(R.id.answethass7);
        spn8 = (TextView) findViewById(R.id.answethass8);
        spn9 = (TextView) findViewById(R.id.answethass9);
        spn10 = (TextView) findViewById(R.id.answethass10);
        spn11 = (TextView) findViewById(R.id.answethass11);
        spn12 = (TextView) findViewById(R.id.answethass12);
        spn13 = (TextView) findViewById(R.id.answethass13);
        spn14 = (TextView) findViewById(R.id.answethass14);
        spn15 = (TextView) findViewById(R.id.answethass15);
        spn16 = (TextView) findViewById(R.id.answethass16);
        spn17 = (TextView) findViewById(R.id.answethass17);
        spn18 = (TextView) findViewById(R.id.answethass18);
        spn19 = (TextView) findViewById(R.id.answethass19);
        spn20 = (TextView) findViewById(R.id.answethass20);
        spn21 = (TextView) findViewById(R.id.answethass21);
        spn22 = (TextView) findViewById(R.id.answethass22);
        spn23 = (TextView) findViewById(R.id.answethass23);
        spn24 = (TextView) findViewById(R.id.answethass24);
        spn25 = (TextView) findViewById(R.id.answethass25);
        spn26 = (TextView) findViewById(R.id.answethass26);
        spn27 = (TextView) findViewById(R.id.answethass27);
        spn28 = (TextView) findViewById(R.id.answethass28);
        spn29 = (TextView) findViewById(R.id.answethass29);
        spn30 = (TextView) findViewById(R.id.answethass30);

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
        spn27.setText(sspn27);
        spn28.setText(sspn28);
        spn29.setText(sspn29);
        spn30.setText(sspn30);
    }
    private void analyzeRisk() {
        if(risk1Int>=51&&risk1Int<=60){//1 ควรเฝ้าระวัง ติดตาม ทำแบบคัดกรองซ้ำ
            textView.setText("อาจมีความเสี่ยงต่อการเป็นโรคสมาธิสั้นเล็กน้อยด้าน อาการซนวู่วาม ควรเฝ้าระวัง ติดตาม ทำแบบคัดกรองซ้ำ");

        }else if(risk2Int>=51&&risk2Int<=60){//2
            textView.setText("อาจมีความเสี่ยงต่อการเป็นโรคสมาธิสั้นเล็กน้อยด้าน อาการขาดสมาธิ ควรเฝ้าระวัง ติดตาม ทำแบบคัดกรองซ้ำ");


        }else if(risk3Int>=51&&risk3Int<=60){//3
            textView.setText("อาจมีความเสี่ยงต่อการเป็นโรคสมาธิสั้นโดยรวมเล็กน้อย ควรเฝ้าระวัง ติดตาม ทำแบบคัดกรองซ้ำ");


        }else if(risk1Int>=51&&risk1Int<=60&&risk2Int>=51&&risk2Int>=60){ // 1-2
            textView.setText("อาจมีความเสี่ยงต่อการเป็นโรคสมาธิสั้นเล็กน้อยด้าน อาการซนวู่วาม และ อาการขาดสมาธิ ควรเฝ้าระวัง ติดตาม ทำแบบคัดกรองซ้ำ");

        }else if(risk1Int>=51&&risk1Int<=60&&risk3Int>=51&&risk3Int>=60){//1-3
            textView.setText("อาจมีความเสี่ยงต่อการเป็นโรคสมาธิสั้นเล็กน้อยด้าน อาการซนวู่วาม และ อาการสมาธิสั้นโดยรวม ควรเฝ้าระวัง ติดตาม ทำแบบคัดกรองซ้ำ");

        }else if(risk2Int>=51&&risk2Int<=60&&risk3Int>=51&&risk3Int>=60){//2-3
            textView.setText("อาจมีความเสี่ยงต่อการเป็นโรคสมาธิสั้นเล็กน้อยด้าน อาการขาดสมาธ และ อาการสมาธิสั้นโดยรวม ควรเฝ้าระวัง ติดตาม ทำแบบคัดกรองซ้ำ");

        }else if(risk1Int>=51&&risk1Int<=60&&risk2Int>=51&&risk2Int<=60&&risk3Int>=51&&risk3Int<=60) {//1 -2 -3
            textView.setText("อาจมีความเสี่ยงต่อการเป็นโรคสมาธิสั้นเล็กน้อยด้าน อาการซนวู่วาม  อาการขาดสมาธิ และ อาการสมาธิสั้นโดยรวม ควรเฝ้าระวัง ติดตาม ทำแบบคัดกรองซ้ำ");


        }else if(risk1Int>=61&&risk1Int<=70){//1 เริ่มมีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน      ... ควรให้การช่วยเหลือเบื้องต้นและติดตามผล
            textView.setText("เริ่มมีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน อาการซนวู่วาม ควรให้การช่วยเหลือเบื้องต้นและติดตามผล");

        }else if(risk2Int>=51&&risk2Int<=60){//2
            textView.setText("เริ่มมีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน อาการขาดสมาธิ ควรให้การช่วยเหลือเบื้องต้นและติดตามผล");


        }else if(risk3Int>=51&&risk3Int<=60){//3
            textView.setText("เริ่มมีความเสี่ยงต่องการเป็นโรคสมาธิสั้นโดยรวม ควรให้การช่วยเหลือเบื้องต้นและติดตามผล");


        }else if(risk1Int>=51&&risk1Int<=60&&risk2Int>=51&&risk2Int>=60){ // 1-2
            textView.setText("เริ่มมีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน อาการซนวู่วาม และ อาการขาดสมาธิ ควรให้การช่วยเหลือเบื้องต้นและติดตามผล");

        }else if(risk1Int>=51&&risk1Int<=60&&risk3Int>=51&&risk3Int>=60){//1-3
            textView.setText("เริ่มมีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน อาการซนวู่วาม และ อาการสมาธิสั้นโดยรวม ควรให้การช่วยเหลือเบื้องต้นและติดตามผล");

        }else if(risk2Int>=51&&risk2Int<=60&&risk3Int>=51&&risk3Int>=60){//2-3
            textView.setText("เริ่มมีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน อาการขาดสมาธ และ อาการสมาธิสั้นโดยรวม ควรให้การช่วยเหลือเบื้องต้นและติดตามผล");

        }else if(risk1Int>=51&&risk1Int<=60&&risk2Int>=51&&risk2Int<=60&&risk3Int>=51&&risk3Int<=60){//1 -2 -3
            textView.setText("เริ่มมีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน อาการซนวู่วาม  อาการขาดสมาธิ และ อาการสมาธิสั้นโดยรวม ควรให้การช่วยเหลือเบื้องต้นและติดตามผล");


        }else if(risk1Int>=61&&risk1Int<=70){//1 มีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน      ... ควรนำเด็กไปพบแพทย์ทันทีเพื่อเข้าสู่กระบวนการวินิจฉัยและยืนยันผลอย่างถูกต้อง
            textView.setText("มีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน อาการซนวู่วาม สูง ควรนำเด็กไปพบแพทย์ทันทีเพื่อเข้าสู่กระบวนการวินิจฉัยและยืนยันผลอย่างถูกต้อง");

        }else if(risk2Int>=51&&risk2Int<=60){//2
            textView.setText("มีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน อาการขาดสมาธิ สูง ควรนำเด็กไปพบแพทย์ทันทีเพื่อเข้าสู่กระบวนการวินิจฉัยและยืนยันผลอย่างถูกต้อง");


        }else if(risk3Int>=51&&risk3Int<=60){//3
            textView.setText("มีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้านโดยรวมเสูง ควรนำเด็กไปพบแพทย์ทันทีเพื่อเข้าสู่กระบวนการวินิจฉัยและยืนยันผลอย่างถูกต้อง");


        }else if(risk1Int>=51&&risk1Int<=60&&risk2Int>=51&&risk2Int>=60){ // 1-2
            textView.setText("มีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน อาการซนวู่วาม และ อาการขาดสมาธิ สูง ควรนำเด็กไปพบแพทย์ทันทีเพื่อเข้าสู่กระบวนการวินิจฉัยและยืนยันผลอย่างถูกต้อง");

        }else if(risk1Int>=51&&risk1Int<=60&&risk3Int>=51&&risk3Int>=60){//1-3
            textView.setText("มีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน อาการซนวู่วาม และ อาการสมาธิสั้นโดยรวม สูง ควรนำเด็กไปพบแพทย์ทันทีเพื่อเข้าสู่กระบวนการวินิจฉัยและยืนยันผลอย่างถูกต้อง");

        }else if(risk2Int>=51&&risk2Int<=60&&risk3Int>=51&&risk3Int>=60){//2-3
            textView.setText("มีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน อาการขาดสมาธิ และ อาการสมาธิสั้นโดยรวม สูง ควรนำเด็กไปพบแพทย์ทันทีเพื่อเข้าสู่กระบวนการวินิจฉัยและยืนยันผลอย่างถูกต้อง");

        }else if(risk1Int>=51&&risk1Int<=60&&risk2Int>=51&&risk2Int<=60&&risk3Int>=51&&risk3Int<=60){//1 -2 -3
            textView.setText("มีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน อาการซนวู่วาม  อาการขาดสมาธิ และ อาการสมาธิสั้นโดยรวม สูง ควรนำเด็กไปพบแพทย์ทันทีเพื่อเข้าสู่กระบวนการวินิจฉัยและยืนยันผลอย่างถูกต้อง");


        } else{ // less all
            textView.setText("อยู่ในเกณฑ์ปกติ");

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
        sspn27 = getIntent().getStringExtra("ans27");
        sspn28 = getIntent().getStringExtra("ans28");
        sspn29 = getIntent().getStringExtra("ans29");
        sspn30 = getIntent().getStringExtra("ans30");
        date = getIntent().getStringExtra("date");



    }
}

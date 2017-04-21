package adhd.sirikan.pimpicha.adhdform;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class riskSnapActivity extends AppCompatActivity {
    String idString, loginString[],genderString,ageString,risk1,risk2,risk3;
    TextView textView;
    String testText = "jjjjjj";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_snap);
        textView = (TextView) findViewById(R.id.txtRiskSnap);

        getValueFromIntent();
        analyzeRisk();
    }
    int risk1Int,risk2Int,risk3Int ;

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

            }

        }





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

    }


}

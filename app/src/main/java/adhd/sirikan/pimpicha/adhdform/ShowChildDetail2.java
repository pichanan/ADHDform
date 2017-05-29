package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class ShowChildDetail2 extends AppCompatActivity {
    private MyConstant myConstant;
    private String urlPHPString;
    String idString, loginString[],genderString, ageString,nameString;
    private String[] columnStrings,resultStrings;
    private String tag = "16AprilV5";
    String ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9, ch10, ch11,
            ch12, ch13, ch14, ch15, ch16, ch17, ch18, ch19, ch20,
            ch21, ch22, ch23, ch24, ch25, ch26,ch27,ch28,ch29,ch30;
    String risk1, risk2, risk3,date;

    TextView textView,textView2,spn, spn2, spn3, spn4, spn5, spn6, spn7, spn8, spn9, spn10, spn11, spn12, spn13,
            spn14, spn15, spn16, spn17, spn18, spn19, spn20, spn21, spn22, spn23, spn24, spn25, spn26
            , spn27, spn28, spn29, spn30;
    Button ImageViewPDF,button2;
    TextView t, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13,
            t14, t15, t16, t17, t18, t19, t20, t21, t22, t23, t24, t25,
            t26, t27, t28, t29, t30;
    String strq1, strq2, strq3, strq4, strq5, strq6, strq7, strq8, strq9, strq10, strq11, strq12, strq13,
            strq14, strq15, strq16, strq17, strq18, strq19, strq20, strq21, strq22, strq23, strq24, strq25,
            strq26, strq27, strq28, strq29, strq30;
    int txtDotype, txtChildAge;
    int risk1Int,risk2Int,risk3Int;
    String txtRisk1="",txtRisk2="", txtRisk3 = "",allrisk="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_child_detail2);
        ImageViewPDF = (Button) findViewById(R.id.showDetailThassPdf);
        button2 = (Button) findViewById(R.id.rechisThass);
        textView = (TextView) findViewById(R.id.thassRiskhis);
        ImageViewPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                putIt();


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAlert objMyAlert = new myAlert(ShowChildDetail2.this);
                objMyAlert.myDialog("คำแนะนำ(ไม่ใช่การวินิจฉัย):",
                        "อาจมีความเสี่ยง คำแนะนำคือ: เฝ้าระวัง ติดตาม หรือทำแบบคัดกรองซ้ำ.\n\n" +
                        "เริ่มมีความเสี่ยง  คำแนะนำคือ: เควรให้การช่วยเหลือเบื้องต้น และติดตามผลฝ้าระวัง ติดตาม หรือทำแบบคัดกรองซ้ำ.\n\n"+"มีความเสี่ยงสูง คำแนะนำคือ: ควรนำเด็กไปพบแพทย์ทันทีเพื่อเข้าสู่กระบวนการวินิจฉัยและยืนยันผลอย่างถูกต้อง");
            }
        });

        mySetup();
        queryDataFromJSoN();
        findId();
        analyzeRisk();

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

        t = (TextView) findViewById(R.id.idqt1);
        t2 = (TextView) findViewById(R.id.idqt2);
        t3 = (TextView) findViewById(R.id.idqt3);
        t4 = (TextView) findViewById(R.id.idqt4);
        t5 = (TextView) findViewById(R.id.idqt5);
        t6 = (TextView) findViewById(R.id.idqt6);
        t7 = (TextView) findViewById(R.id.idqt7);
        t8 = (TextView) findViewById(R.id.idqt8);
        t9 = (TextView) findViewById(R.id.idqt9);
        t10 = (TextView) findViewById(R.id.idqt10);
        t11 = (TextView) findViewById(R.id.idqt11);
        t12 = (TextView) findViewById(R.id.idqt12);
        t13 = (TextView) findViewById(R.id.idqt13);
        t14 = (TextView) findViewById(R.id.idqt14);
        t15 = (TextView) findViewById(R.id.idqt15);
        t16 = (TextView) findViewById(R.id.idqt16);
        t17 = (TextView) findViewById(R.id.idqt17);
        t18 = (TextView) findViewById(R.id.idqt18);
        t19 = (TextView) findViewById(R.id.idqt19);
        t20 = (TextView) findViewById(R.id.idqt20);
        t21 = (TextView) findViewById(R.id.idqt21);
        t22 = (TextView) findViewById(R.id.idqt22);
        t23 = (TextView) findViewById(R.id.idqt23);
        t24 = (TextView) findViewById(R.id.idqt24);
        t25 = (TextView) findViewById(R.id.idqt25);
        t26 = (TextView) findViewById(R.id.idqt26);
        t27 = (TextView) findViewById(R.id.idqt27);
        t28 = (TextView) findViewById(R.id.idqt28);
        t29 = (TextView) findViewById(R.id.idqt29);
        t30 = (TextView) findViewById(R.id.idqt30);
        //ครู เด็ก 6-12 ปี
        if(txtDotype==0&&txtChildAge>=6&&txtChildAge<=12){
            strq1 = "1. เดินไปเดินมาในเวลาเรียนโดยไม่ได้รับอนุญาติ";
            strq2 = "2. พูดโพล่ง ขัดจังหวะในเวลาครูสอน";
            strq3 = "3. แหย่ ล้อเลียน แกล้งเด็กคนอื่น";
            strq4 = "4. อยู่ไม่นิ่ง มักหาอะไรทำหรือเล้นตลอดเวลา";
            strq5 = "5. ใจร้อน วู่วาม";
            strq6 = "6. มักมีเรื่องทะเลาะวิวาทกับเด็กอื่น";
            strq7 = "7. เล่นเสียงดัง";
            strq8 = "8. พูดมากจนน่ารำคาญ";
            strq9 = "9. อารมณ์เสีย หงุดหงิดง่าย";
            strq10 = "10. ทำอะไรโดยไม่คิดถึงผลที่จะตามมา";
            strq11 = "11. เล่นรุนแรง เล่นแผลงๆ หรือเสี่ยงอันตราย";
            strq12 = "12. ซน";
            strq13 = "13. รบกวนเพื่อนหรือครูในห้องเรียน";
            strq14 = "14. ไม่รู้จักการรอคอย";
            strq15 = "15. ส่งเสียงดังในห้องเรียน";
            strq16 = "16. ขาดความรับผิดชอบ";
            strq17 = "17. ไม่ตั้งใจเรียน";
            strq18 = "18. ทำงานช้า ทำงานำม่เสร็จตามเวลาที่กำหนด";
            strq19 = "19. เหม่อ ใจลอย";
            strq20 = "20. ฟังอะไรประเดี๋ยวเดียว ก็หมดความสนใจ";
            strq21 = "21. โอเอ้ ใช้เวลานานกว่าจะเริ่มทำงานได้";
            strq22 = "22. ต้องเรียก หรือกระตุ้นเพื่อให้งานเสร็จ";
            strq23 = "23. วอกแวกง่าย";
            strq24 = "24. นำของที่จำเป้นต่อการเรียนมาไม่ครบ";
            strq25 = "25. ทำหนังสือ อุปกรณ์การเรียน  หรือของใช้ส่วนตัวหาย";
            strq26 = "26. ทำงานไม่เรียบร้อย สะเพร่า ไม่รอบคอบ";
            strq27 = "27. ไม่จดจ่อกับงานที่กำลังทำ (ยกเว้นกำลังทำสิ่งที่ชอบ)";
            strq28 = "28. สมาธิไม่ต่อเนื่อง หรือช่วงความจำสั้น";
            strq29 = "29. หลีกเลี่ยงการทำงานที่ต้องใช้ความคิด";
            strq30 = "30. ลืมส่งการบ้าน";
        }else if(txtDotype==0&&txtChildAge>=13&&txtChildAge<=18){
            strq1 = "1. โตแล้วยังเล่นเหมือนเด็ก";
            strq2 = "2. พูดโพล่ง ขัดจังหวะในเวลาครูสอน";
            strq3 = "3. แหย่ ล้อเลียน ยั่วโมโห แกล้งเพื่อน";
            strq4 = "4. อยู่ไม่นิ่ง มักหาอะไรทำหรือเล้นตลอดเวลา";
            strq5 = "5. ใจร้อน วู่วาม";
            strq6 = "6. มักมีเรื่องทะเลาะวิวาทกับผู้อื่น";
            strq7 = "7. นิสัยและพฤติกรรมเด็กกว่าวัย";
            strq8 = "8. พูดมากจนน่ารำคาญ";
            strq9 = "9. อารมณ์เสีย หงุดหงิดง่าย";
            strq10 = "10. ทำอะไรโดยไม่คิดถึงผลที่จะตามมา";
            strq11 = "11. เล่นรุนแรง เล่นแผลงๆ หรือเสี่ยงอันตราย";
            strq12 = "12. แซว ต่อลักต่อเถียงครู";
            strq13 = "13. ก่อกวนเพื่อนหรือครูในห้องเรียน";
            strq14 = "14. รอคอยอะไรนานๆ ไม่ได้";
            strq15 = "15. ส่งเสียงดังในเวลาเรียน";
            strq16 = "16. ขาดความรับผิดชอบ";
            strq17 = "17. ไม่สนใจเรียน";
            strq18 = "18. ทำงานช้า ทำงานำม่เสร็จตามเวลาที่กำหนด";
            strq19 = "19. เหม่อ ใจลอย";
            strq20 = "20. ทำงานสะเพร่า ไม่รอบคอบ";
            strq21 = "21. ชอบหมกงานจนทำให้มีงานค้าง";
            strq22 = "22. โอเอ้ ใช้เวลานานกว่าจะเริ่มทำงานได้";
            strq23 = "23. วอกแวกง่าย";
            strq24 = "24. ทำงานไม่เรียบร้อย ไม่เป็นระเบียบ";
            strq25 = "25. นำของที่จำเป้นต่อการเรียนมาไม่ครบ";
            strq26 = "26. ลืมส่งงาน หรือส่งไม่ตรงเวลา";
            strq27 = "27. ใช้เวลานานกว่าจะเริ่มทำงานได้";
            strq28 = "28. สมาธิไม่ต่อเนื่อง หรือช่วงความจำสั้น";
            strq29 = "29. ไม่ทบทวนบทเรียน";
            strq30 = "30. หลีกเลี่ยงการทำงานที่ต้องใช้ความคิด";
        }else if(txtDotype==1&&txtChildAge>=6&&txtChildAge<=12){ // ผปก
            strq1 = "1. ซน อยู่ไม่นิ่ง";
            strq2 = "2. พูดแทรก ขัดจังหวะ";
            strq3 = "3. แหย่ ล้อเลียน แกล้งเด็กคนอื่น";
            strq4 = "4. อยู่ไม่สุข ชอบรื้อ ชอบค้น";
            strq5 = "5. ใจร้อน วู่วาม";
            strq6 = "6. มักมีเรื่องทะเลาะวิวาทกับผู้อื่น";
            strq7 = "7. เล่นเสียงดัง";
            strq8 = "8. พูดมากจนน่ารำคาญ";
            strq9 = "9. อารมณ์เสีย หงุดหงิดง่าย";
            strq10 = "10. ทำอะไรโดยไม่คิดถึงผลที่จะตามมา";
            strq11 = "11. เล่นรุนแรง เล่นแผลงๆ หรือเสี่ยงอันตราย";
            strq12 = "12. เจ็บตัวจากการเล่นหรือทำกิจกรรมต่างๆ";
            strq13 = "13. เป็นตัวป่วน หรือรบกวนคนในบ้าน";
            strq14 = "14. รอคอยอะไรนานๆ ไม่ได้";
            strq15 = "15. ชอบเถียง เอะอะ โวยวาย";
            strq16 = "16. ขาดความรับผิดชอบ";
            strq17 = "17. สนใจแต่เรื่องเล่น มากกว่าการเรียน";
            strq18 = "18. อิดออด ต่อรอง ลีลาเยอะเวลาบอกให้ทำอะไร";
            strq19 = "19. เหม๋อ ใจลอย";
            strq20 = "20. ลืมจดการบ้าน หรือจดไม่ครบ";
            strq21 = "21. โอเอ้ ใช้เวลานานกว่าจะเริ่มทำงานได้";
            strq22 = "22. ต้องกระตุ้น  หรือนั่งคุมเวลาทำการบ้าน";
            strq23 = "23. แวอกแวกง่าย";
            strq24 = "24. ชักช้า อืดอาด";
            strq25 = "25. ทำของหาย หรือลืมว่าวางไว้ที่ไหน";
            strq26 = "26. ทำงานไม่เรียบร้อย สะเพร่า ไม่รอบคอบ";
            strq27 = "27. ไม่จดจ่อกับงานที่กำลังทำ (ยกเว้นกำลังทำสิ่งที่ชอบ)";
            strq28 = "28. สมาธิสั้น (ยกเว้นเวลาดูทีวี เล่นเกม หรือทำสิ่งที่ชอบ)";
            strq29 = "29. หลีกเลี่ยงการทำงานที่ต้องใช้ความคิด";
            strq30 = "30. ลืมส่งการบ้าน";
        }else if(txtDotype==1&&txtChildAge>=13&&txtChildAge<=18){
            strq1 = "1. แหย่ รบกวน ยั่วโมโหคนในบ้าน ";
            strq2 = "2. ขัดจังหวะเวลาคนอื่นพูด หรือทำอะไรอยู่";
            strq3 = "3. ชอบเถียง เอะอะ โวยวาย";
            strq4 = "4. อยู่ไม่นิ่ง มักหาอะไรทำหรือเล่นตลอดเวลา";
            strq5 = "5. ใจร้อน วู่วาม โมโหง่าย";
            strq6 = "6. มักมีเรื่องทะเลาะวิวิทกับเพื่อน หรือพี่น้อง";
            strq7 = "7. นิสัยพฤติกรรมเด็กกว่าวัย";
            strq8 = "8. พูดมากจนน่ารำคาญ";
            strq9 = "9. อารมณ์เสีย หงุดหงิดง่าย";
            strq10 = "10. ทำอะไรโดยไม่คิดถึงผลที่จะตามมา";
            strq11 = "11. เล่นรุนแรง เล่นแผลงๆ หรือเสี่ยงอันตราย";
            strq12 = "12. เจ็บตัวจากการเล่นหรือทำกิจกรรมต่างๆ";
            strq13 = "13. สร้างปัญหาให้ตนเองหรือคนในบ้าน";
            strq14 = "14. รอคอยอะไรนานๆ ไม่ได้";
            strq15 = "15. ตอนเด็กๆ ซนมาก";
            strq16 = "16. ขาดความรับผิดชอบ";
            strq17 = "17. ไม่สนใจการเรียน";
            strq18 = "18. อิดออด ต่อรอง ลีลาเยอะเวลาบอกให้ทำอะไร";
            strq19 = "19. เหม๋อ ใจลอย";
            strq20 = "20. ขี้ลืม";
            strq21 = "21. ไม่สนใจทำการบ้าน";
            strq22 = "22. โอเอ้ อืดอาด ไม่สนใจเวลา";
            strq23 = "23. วอกแวกง่าย";
            strq24 = "24. ขาดระเบียบวินัย";
            strq25 = "25. ทำของหาย หรือลืมว่าวางไว้ที่ไหน";
            strq26 = "26. ทำงานอะไรไม่ค่อยเสร็จ มีงานค้างหหลายชิ้น";
            strq27 = "27. เบื่อง่าย (ยกเว้นเวลาดูทีวี เล่นเกม หรือทำสิ่งที่ชอบ)";
            strq28 = "28. สมาธิสั้น (ยกเว้นเวลาดูทีวี เล่นเกม หรือทำสิ่งที่ชอบ)";
            strq29 = "29. ไม่ชอบอ่านหนังสือ หรือทบทวนบทเรียน";
            strq30 = "30. แหย่ ล้อเลียน แกล้งเด็กคนอื่น";


        }
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
            risk1 = resultStrings[33];
            risk2 = resultStrings[34];
            risk3 = resultStrings[35];
            date = resultStrings[38];
            risk1Int = Integer.parseInt(risk1);
            risk2Int = Integer.parseInt(risk2);
            risk3Int = Integer.parseInt(risk3);
            Log.d(tag, "30 ("  + ") ==>" + resultStrings[30]);


        } catch (Exception e) {
            Log.d(tag, "e query ==>" + e.toString());
        }
    }

    private void mySetup() {
        myConstant = new MyConstant();
        idString = getIntent().getStringExtra("id");
        loginString = getIntent().getStringArrayExtra("Login");
        ageString = getIntent().getStringExtra("age");
        genderString = getIntent().getStringExtra("gender");
        columnStrings = myConstant.getColumnTest2();
        urlPHPString = myConstant.getUrlGetTestWhereID2();
        txtDotype = Integer.parseInt(loginString[3]);
        txtChildAge= Integer.parseInt(ageString);
        nameString = getIntent().getStringExtra("name");
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
        intent.putExtra("risk1", Integer.parseInt(risk1));
        intent.putExtra("risk2", Integer.parseInt(risk2));
        intent.putExtra("risk3", Integer.parseInt(risk3));
        intent.putExtra("date", date);
        intent.putExtra("gender", genderString);
        intent.putExtra("age", ageString);
        intent.putExtra("name", nameString);
        intent.putExtra("Login", loginString);
        intent.putExtra("allrisk", allrisk);
        startActivity(intent);

    }

    private void analyzeRisk() {

        if(risk1Int>=51&&risk1Int<=60){//1 ควรเฝ้าระวัง ติดตาม ทำแบบคัดกรองซ้ำ
            txtRisk1 = "=> อาการซน/วู่วาม: อาจมีความเสี่ยง";

        }else if(risk1Int>=61&&risk1Int<=70){
            txtRisk1 = "=> อาการซน/วู่วาม: เริ่มมีความเสี่ยง";
        }else if(risk1Int>=71) {//1 มีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน      ... ควรนำเด็กไปพบแพทย์ทันทีเพื่อเข้าสู่กระบวนการวินิจฉัยและยืนยันผลอย่างถูกต้อง
            txtRisk1 = "=> อาการซน/วู่วาม: เริ่มมีความเสี่ยง";
        }

        if(risk2Int>=51&&risk2Int<=60){//1 ควรเฝ้าระวัง ติดตาม ทำแบบคัดกรองซ้ำ
            txtRisk2 = "=> อาการขาดสมาธิ: อาจมีความเสี่ยง";

        }else if(risk2Int>=61&&risk2Int<=70){
            txtRisk2 = "=> อาการขาดสมาธิ: เริ่มมีความเสี่ยง";
        }else if(risk2Int>=71) {//1 มีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน      ... ควรนำเด็กไปพบแพทย์ทันทีเพื่อเข้าสู่กระบวนการวินิจฉัยและยืนยันผลอย่างถูกต้อง
            txtRisk2 = "=> อาการขาดสมาธิ: มีความเสี่ยงสูง";
        }


        if(risk3Int>=51&&risk3Int<=60){//1 ควรเฝ้าระวัง ติดตาม ทำแบบคัดกรองซ้ำ
            txtRisk3 = "=> อาการโดยรวม: อาจมีความเสี่ยง";

        }else if(risk3Int>=61&&risk3Int<=70){
            txtRisk3 = "=> อาการโดยรวม: เริ่มมีความเสี่ยง";
        }else if(risk3Int>=71) {//1 มีความเสี่ยงต่องการเป็นโรคสมาธิสั้นด้าน      ... ควรนำเด็กไปพบแพทย์ทันทีเพื่อเข้าสู่กระบวนการวินิจฉัยและยืนยันผลอย่างถูกต้อง
            txtRisk3 = "=> อาการโดยรวม: มีความเสี่ยสูง";
        }

        if (txtRisk3.equals("") && txtRisk2.equals("") && txtRisk3.equals("")) {

            textView.setText("อยู่ในเกณฑ์ปกติ");
        }else{
            allrisk = txtRisk3+"\n"+txtRisk1 +"\n"+ txtRisk2  ;
            textView.setText(allrisk);
        }



    }
}

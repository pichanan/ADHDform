package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TassActivity extends AppCompatActivity implements View.OnClickListener {
    String[] spinnerValue = {"-", "ไม่เคยทำ", "นานๆทำที", "ทำค่อนข้างบ่อย","ทำบ่อยมาก"};
    private static String tag = "30MarchV1",tag2 = "16AprilV1";
    Button button;
    private  int risk1,risk2,risk3,trisk1,trisk2,trisk3;
    String spn,spn2,spn3,spn4,spn5,spn6,spn7,spn8,spn9,spn10,spn11,spn12,spn13,spn14,spn15,spn16,spn17,spn18,spn19,spn20,spn21
            ,spn22,spn23,spn24,spn25,spn26,spn27,spn28,spn29,spn30 ;
    Spinner spinThass1,spinThass2,spinThass3,spinThass4,spinThass5,spinThass6,spinThass7,spinThass8
            ,spinThass9,spinThass10,spinThass11,spinThass12,spinThass13,spinThass14,spinThass15,spinThass16
            ,spinThass17,spinThass18,spinThass19,spinThass20,spinThass21,spinThass22,spinThass23,spinThass24
            ,spinThass25,spinThass26,spinThass27,spinThass28,spinThass29,spinThass30;

    String tmpspn, tmpspn2, tmpspn3, tmpspn4, tmpspn5, tmpspn6, tmpspn7, tmpspn8, tmpspn9, tmpspn10, tmpspn11, tmpspn12, tmpspn13,
            tmpspn14, tmpspn15, tmpspn16, tmpspn17, tmpspn18, tmpspn19, tmpspn20, tmpspn21, tmpspn22, tmpspn23, tmpspn24, tmpspn25,
            tmpspn26, tmpspn27, tmpspn28, tmpspn29, tmpspn30;
    String idString,loginString[],genderString,ageString,nameString;
    TextView t, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13,
            t14, t15, t16, t17, t18, t19, t20, t21, t22, t23, t24, t25,
            t26, t27, t28, t29, t30;
    String strq1, strq2, strq3, strq4, strq5, strq6, strq7, strq8, strq9, strq10, strq11, strq12, strq13,
            strq14, strq15, strq16, strq17, strq18, strq19, strq20, strq21, strq22, strq23, strq24, strq25,
            strq26, strq27, strq28, strq29, strq30;
    int txtDotype, txtChildAge;

    private java.util.Calendar calendar;
    private String currentDateString;
    TextView choice1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thass);
        getValueFromIntent();
        setTextView();
        initialSpinner();
        findCurrentDate();
        initialView();
        button.setOnClickListener(TassActivity.this);


    }
    private void setTextView() {
        t = (TextView) findViewById(R.id.qthass1);
        t2 = (TextView) findViewById(R.id.qthass2);
        t3 = (TextView) findViewById(R.id.qthass3);
        t4 = (TextView) findViewById(R.id.qthass4);
        t5 = (TextView) findViewById(R.id.qthass5);
        t6 = (TextView) findViewById(R.id.qthass6);
        t7 = (TextView) findViewById(R.id.qthass7);
        t8 = (TextView) findViewById(R.id.qthass8);
        t9 = (TextView) findViewById(R.id.qthass9);
        t10 = (TextView) findViewById(R.id.qthass10);
        t11 = (TextView) findViewById(R.id.qthass11);
        t12 = (TextView) findViewById(R.id.qthass12);
        t13 = (TextView) findViewById(R.id.qthass13);
        t14 = (TextView) findViewById(R.id.qthass14);
        t15 = (TextView) findViewById(R.id.qthass15);
        t16 = (TextView) findViewById(R.id.qthass16);
        t17 = (TextView) findViewById(R.id.qthass17);
        t18 = (TextView) findViewById(R.id.qthass18);
        t19 = (TextView) findViewById(R.id.qthass19);
        t20 = (TextView) findViewById(R.id.qthass20);
        t21 = (TextView) findViewById(R.id.qthass21);
        t22 = (TextView) findViewById(R.id.qthass22);
        t23 = (TextView) findViewById(R.id.qthass23);
        t24 = (TextView) findViewById(R.id.qthass24);
        t25 = (TextView) findViewById(R.id.qthass25);
        t26 = (TextView) findViewById(R.id.qthass26);
        t27 = (TextView) findViewById(R.id.qthass27);
        t28 = (TextView) findViewById(R.id.qthass28);
        t29 = (TextView) findViewById(R.id.qthass29);
        t30 = (TextView) findViewById(R.id.qthass30);

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

    private void getValueFromIntent() {
        idString = getIntent().getStringExtra("tmpIndex");
        loginString = getIntent().getStringArrayExtra("Login");
        genderString = getIntent().getStringExtra("gender");
        ageString = getIntent().getStringExtra("age");
        nameString = getIntent().getStringExtra("name");
        txtDotype = Integer.parseInt(loginString[3]);
        txtChildAge = Integer.parseInt(ageString);
        Log.d("22_5_60", "txtChildAge " + txtChildAge + "txtDotype"+ txtDotype);
    }

    private void findCurrentDate() {
        calendar = java.util.Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        currentDateString = dateFormat.format(calendar.getTime());
        Log.d("10AprilV1", "currentDate" + currentDateString);
    }

    private void initialSpinner() {
        spinThass1 = (Spinner) findViewById(R.id.spinThass1);
        spinThass2 = (Spinner) findViewById(R.id.spinThass2);
        spinThass3 = (Spinner) findViewById(R.id.spinThass3);
        spinThass4 = (Spinner) findViewById(R.id.spinThass4);
        spinThass5 = (Spinner) findViewById(R.id.spinThass5);
        spinThass6 = (Spinner) findViewById(R.id.spinThass6);
        spinThass7 = (Spinner) findViewById(R.id.spinThass7);
        spinThass8 = (Spinner) findViewById(R.id.spinThass8);
        spinThass9 = (Spinner) findViewById(R.id.spinThass9);
        spinThass10 = (Spinner) findViewById(R.id.spinThass10);
        spinThass11= (Spinner) findViewById(R.id.spinThass11);
        spinThass12 = (Spinner) findViewById(R.id.spinThass12);
        spinThass13 = (Spinner) findViewById(R.id.spinThass13);
        spinThass14 = (Spinner) findViewById(R.id.spinThass14);
        spinThass15 = (Spinner) findViewById(R.id.spinThass15);
        spinThass16 = (Spinner) findViewById(R.id.spinThass16);
        spinThass17 = (Spinner) findViewById(R.id.spinThass17);
        spinThass18 = (Spinner) findViewById(R.id.spinThass18);
        spinThass19 = (Spinner) findViewById(R.id.spinThass19);
        spinThass20 = (Spinner) findViewById(R.id.spinThass20);
        spinThass21 = (Spinner) findViewById(R.id.spinThass21);
        spinThass22 = (Spinner) findViewById(R.id.spinThass22);
        spinThass23 = (Spinner) findViewById(R.id.spinThass23);
        spinThass24 = (Spinner) findViewById(R.id.spinThass24);
        spinThass25 = (Spinner) findViewById(R.id.spinThass25);
        spinThass26 = (Spinner) findViewById(R.id.spinThass26);
        spinThass27 = (Spinner) findViewById(R.id.spinThass27);
        spinThass28 = (Spinner) findViewById(R.id.spinThass28);
        spinThass29 = (Spinner) findViewById(R.id.spinThass29);
        spinThass30 = (Spinner) findViewById(R.id.spinThass30);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(TassActivity.this, android.R.layout.simple_list_item_1, spinnerValue);
        spinThass1.setAdapter(adapter);
        spinThass2.setAdapter(adapter);
        spinThass3.setAdapter(adapter);
        spinThass4.setAdapter(adapter);
        spinThass5.setAdapter(adapter);
        spinThass6.setAdapter(adapter);
        spinThass7.setAdapter(adapter);
        spinThass8.setAdapter(adapter);
        spinThass9.setAdapter(adapter);
        spinThass10.setAdapter(adapter);
        spinThass11.setAdapter(adapter);
        spinThass12.setAdapter(adapter);
        spinThass13.setAdapter(adapter);
        spinThass14.setAdapter(adapter);
        spinThass15.setAdapter(adapter);
        spinThass16.setAdapter(adapter);
        spinThass17.setAdapter(adapter);
        spinThass18.setAdapter(adapter);
        spinThass19.setAdapter(adapter);
        spinThass20.setAdapter(adapter);
        spinThass21.setAdapter(adapter);
        spinThass22.setAdapter(adapter);
        spinThass23.setAdapter(adapter);
        spinThass24.setAdapter(adapter);
        spinThass25.setAdapter(adapter);
        spinThass26.setAdapter(adapter);
        spinThass27.setAdapter(adapter);
        spinThass28.setAdapter(adapter);
        spinThass29.setAdapter(adapter);
        spinThass30.setAdapter(adapter);


    }
    private void initialView() {
        button = (Button) findViewById(R.id.thass3);
    }

    private void checkSpecial(String childID, String doType) {
        try {
            MyConstant myConstant = new MyConstant();
            String urlPhp = myConstant.getUrlEditSpecial2();

            EditSpecial2 editSpecial = new EditSpecial2(TassActivity.this);
            editSpecial.execute(childID, doType, urlPhp);

            Log.d("16AprilV2", "Result ==>" + editSpecial.get());

        } catch (Exception e) {
            Log.d(tag2, "e checkSpecial ==>" + e.toString());
        }
    }

    @Override
    public void onClick(View v) {
        if (v == button) {
            //get value from edidtex


            getValueFromEdidtex();


            if (checkSpinner()) {
                //have space
                myAlert objMyAlert = new myAlert(TassActivity.this);
                objMyAlert.myDialog(getResources().getString(R.string.title_havespace),
                        getResources().getString(R.string.message_havespece));
            } else {
                // check special

                checkSpecial(idString, loginString[3]);
                calRisk(genderString,loginString[3],ageString); // คำนวนความเสี่ยง
                uploadValueToServer();


            }






        }

    }

    private void getValueFromEdidtex() {
        spn = spinThass1.getSelectedItem().toString();
        tmpspn = spn;
        if(spn.equals("-")){
            spn = "-";
        }else if(spn.equals("ไม่เคยทำ")){
            spn = "0";
        }else if(spn.equals("นานๆทำที")){
            spn = "1";
        }else if(spn.equals("ทำค่อนข้างบ่อย")){
            spn = "2";
        }else {
            spn = "3";
        }
        spn2 = spinThass2.getSelectedItem().toString();
        tmpspn2 = spn2;
        if(spn2.equals("-")){
            spn2 = "-";
        }else if(spn2.equals("ไม่เคยทำ")){
            spn2 = "0";
        }else if(spn2.equals("นานๆทำที")){
            spn2 = "1";
        }else if(spn2.equals("ทำค่อนข้างบ่อย")){
            spn2 = "2";
        }else {
            spn2 = "3";
        }
        spn3 = spinThass3.getSelectedItem().toString();
        tmpspn3 = spn3;
        if(spn3.equals("-")){
            spn3 = "-";
        }else if(spn3.equals("ไม่เคยทำ")){
            spn3 = "0";
        }else if(spn3.equals("นานๆทำที")){
            spn3 = "1";
        }else if(spn3.equals("ทำค่อนข้างบ่อย")){
            spn3 = "2";
        }else {
            spn3 = "3";
        }
        spn4 = spinThass4.getSelectedItem().toString();
        tmpspn4 = spn4;
        if(spn4.equals("-")){
            spn4 = "-";
        }else if(spn4.equals("ไม่เคยทำ")){
            spn4 = "0";
        }else if(spn4.equals("นานๆทำที")){
            spn4 = "1";
        }else if(spn4.equals("ทำค่อนข้างบ่อย")){
            spn4 = "2";
        }else {
            spn4 = "3";
        }
        spn5 = spinThass5.getSelectedItem().toString();
        tmpspn5 = spn5;
        if(spn5.equals("-")){
            spn5 = "-";
        }else if(spn5.equals("ไม่เคยทำ")){
            spn5 = "0";
        }else if(spn5.equals("นานๆทำที")){
            spn5 = "1";
        }else if(spn5.equals("ทำค่อนข้างบ่อย")){
            spn5 = "2";
        }else {
            spn5 = "3";
        }
        spn6 = spinThass6.getSelectedItem().toString();
        tmpspn6 = spn6;
        if(spn6.equals("-")){
            spn6 = "-";
        }else if(spn6.equals("ไม่เคยทำ")){
            spn6 = "0";
        }else if(spn6.equals("นานๆทำที")){
            spn6 = "1";
        }else if(spn6.equals("ทำค่อนข้างบ่อย")){
            spn6 = "2";
        }else {
            spn6 = "3";
        }
        spn7 = spinThass7.getSelectedItem().toString();
        tmpspn7 = spn7;
        if(spn7.equals("-")){
            spn7 = "-";
        }else if(spn7.equals("ไม่เคยทำ")){
            spn7 = "0";
        }else if(spn7.equals("นานๆทำที")){
            spn7 = "1";
        }else if(spn7.equals("ทำค่อนข้างบ่อย")){
            spn7 = "2";
        }else {
            spn7 = "3";
        }
        spn8 = spinThass8.getSelectedItem().toString();
        tmpspn8 = spn8;
        if(spn8.equals("-")){
            spn8 = "-";
        }else if(spn8.equals("ไม่เคยทำ")){
            spn8 = "0";
        }else if(spn8.equals("นานๆทำที")){
            spn8 = "1";
        }else if(spn8.equals("ทำค่อนข้างบ่อย")){
            spn8 = "2";
        }else {
            spn8 = "3";
        }
        spn9 = spinThass9.getSelectedItem().toString();
        tmpspn9 = spn9;
        if(spn9.equals("-")){
            spn9 = "-";
        }else if(spn9.equals("ไม่เคยทำ")){
            spn9 = "0";
        }else if(spn9.equals("นานๆทำที")){
            spn9 = "1";
        }else if(spn9.equals("ทำค่อนข้างบ่อย")){
            spn9 = "2";
        }else {
            spn9 = "3";
        }
        spn10 = spinThass10.getSelectedItem().toString();
        tmpspn10 = spn10;
        if(spn10.equals("-")){
            spn10 = "-";
        }else if(spn10.equals("ไม่เคยทำ")){
            spn10 = "0";
        }else if(spn10.equals("นานๆทำที")){
            spn10 = "1";
        }else if(spn10.equals("ทำค่อนข้างบ่อย")){
            spn10 = "2";
        }else {
            spn10 = "3";
        }
        spn11 = spinThass11.getSelectedItem().toString();
        tmpspn11 = spn11;
        if(spn11.equals("-")){
            spn11 = "-";
        }else if(spn11.equals("ไม่เคยทำ")){
            spn11 = "0";
        }else if(spn11.equals("นานๆทำที")){
            spn11 = "1";
        }else if(spn11.equals("ทำค่อนข้างบ่อย")){
            spn11 = "2";
        }else {
            spn11 = "3";
        }
        spn12 = spinThass12.getSelectedItem().toString();
        tmpspn12 = spn12;
        if(spn12.equals("-")){
            spn12 = "-";
        }else if(spn12.equals("ไม่เคยทำ")){
            spn12 = "0";
        }else if(spn12.equals("นานๆทำที")){
            spn12 = "1";
        }else if(spn12.equals("ทำค่อนข้างบ่อย")){
            spn12 = "2";
        }else {
            spn12 = "3";
        }
        spn13 = spinThass13.getSelectedItem().toString();
        tmpspn13 = spn13;
        if(spn13.equals("-")){
            spn13 = "-";
        }else if(spn13.equals("ไม่เคยทำ")){
            spn13 = "0";
        }else if(spn13.equals("นานๆทำที")){
            spn13 = "1";
        }else if(spn13.equals("ทำค่อนข้างบ่อย")){
            spn13 = "2";
        }else {
            spn13 = "3";
        }
        spn14 = spinThass14.getSelectedItem().toString();
        tmpspn14 = spn14;
        if(spn14.equals("-")){
            spn14 = "-";
        }else if(spn14.equals("ไม่เคยทำ")){
            spn14 = "0";
        }else if(spn14.equals("นานๆทำที")){
            spn14 = "1";
        }else if(spn14.equals("ทำค่อนข้างบ่อย")){
            spn14 = "2";
        }else {
            spn14 = "3";
        }
        spn15 = spinThass15.getSelectedItem().toString();
        tmpspn15 = spn15;
        if(spn15.equals("-")){
            spn15 = "-";
        }else if(spn15.equals("ไม่เคยทำ")){
            spn15 = "0";
        }else if(spn15.equals("นานๆทำที")){
            spn15 = "1";
        }else if(spn15.equals("ทำค่อนข้างบ่อย")){
            spn15 = "2";
        }else {
            spn15 = "3";
        }
        spn16 = spinThass16.getSelectedItem().toString();
        tmpspn16 = spn16;
        if(spn16.equals("-")){
            spn16 = "-";
        }else if(spn16.equals("ไม่เคยทำ")){
            spn16 = "0";
        }else if(spn16.equals("นานๆทำที")){
            spn16 = "1";
        }else if(spn16.equals("ทำค่อนข้างบ่อย")){
            spn16 = "2";
        }else {
            spn16 = "3";
        }
        spn17 = spinThass17.getSelectedItem().toString();
        tmpspn17 = spn17;
        if(spn17.equals("-")){
            spn17 = "-";
        }else if(spn17.equals("ไม่เคยทำ")){
            spn17 = "0";
        }else if(spn17.equals("นานๆทำที")){
            spn17 = "1";
        }else if(spn17.equals("ทำค่อนข้างบ่อย")){
            spn17 = "2";
        }else {
            spn17 = "3";
        }
        spn18 = spinThass18.getSelectedItem().toString();
        tmpspn18 = spn18;
        if(spn18.equals("-")){
            spn18 = "-";
        }else if(spn18.equals("ไม่เคยทำ")){
            spn18 = "0";
        }else if(spn18.equals("นานๆทำที")){
            spn18 = "1";
        }else if(spn18.equals("ทำค่อนข้างบ่อย")){
            spn18 = "2";
        }else {
            spn18 = "3";
        }
        spn19 = spinThass19.getSelectedItem().toString();
        tmpspn19 = spn19;
        if(spn19.equals("-")){
            spn19 = "-";
        }else if(spn19.equals("ไม่เคยทำ")){
            spn19 = "0";
        }else if(spn19.equals("นานๆทำที")){
            spn19 = "1";
        }else if(spn19.equals("ทำค่อนข้างบ่อย")){
            spn19 = "2";
        }else {
            spn19 = "3";
        }
        spn20 = spinThass20.getSelectedItem().toString();
        tmpspn20 = spn20;
        if(spn20.equals("-")){
            spn20= "-";
        }else if(spn20.equals("ไม่เคยทำ")){
            spn20 = "0";
        }else if(spn20.equals("นานๆทำที")){
            spn20 = "1";
        }else if(spn20.equals("ทำค่อนข้างบ่อย")){
            spn20 = "2";
        }else {
            spn20 = "3";
        }
        spn21 = spinThass21.getSelectedItem().toString();
        tmpspn21 = spn21;
        if(spn21.equals("-")){
            spn21= "-";
        }else if(spn21.equals("ไม่เคยทำ")){
            spn21 = "0";
        }else if(spn21.equals("นานๆทำที")){
            spn21 = "1";
        }else if(spn21.equals("ทำค่อนข้างบ่อย")){
            spn21 = "2";
        }else {
            spn21 = "3";
        }
        spn22 = spinThass22.getSelectedItem().toString();
        tmpspn22 = spn22;
        if(spn22.equals("-")){
            spn22= "-";
        }else if(spn22.equals("ไม่เคยทำ")){
            spn22 = "0";
        }else if(spn22.equals("นานๆทำที")){
            spn22 = "1";
        }else if(spn22.equals("ทำค่อนข้างบ่อย")){
            spn22 = "2";
        }else {
            spn22 = "3";
        }
        spn23 = spinThass23.getSelectedItem().toString();
        tmpspn23 = spn23;
        if(spn23.equals("-")){
            spn23= "-";
        }else if(spn23.equals("ไม่เคยทำ")){
            spn23 = "0";
        }else if(spn23.equals("นานๆทำที")){
            spn23 = "1";
        }else if(spn23.equals("ทำค่อนข้างบ่อย")){
            spn23 = "2";
        }else {
            spn23 = "3";
        }
        spn24 = spinThass24.getSelectedItem().toString();
        tmpspn24 = spn24;
        if(spn24.equals("-")){
            spn24= "-";
        }else if(spn24.equals("ไม่เคยทำ")){
            spn24 = "0";
        }else if(spn24.equals("นานๆทำที")){
            spn24 = "1";
        }else if(spn24.equals("ทำค่อนข้างบ่อย")){
            spn24 = "2";
        }else {
            spn24 = "3";
        }
        spn25 = spinThass25.getSelectedItem().toString();
        tmpspn25 = spn25;
        if(spn25.equals("-")){
            spn25= "-";
        }else if(spn25.equals("ไม่เคยทำ")){
            spn25 = "0";
        }else if(spn25.equals("นานๆทำที")){
            spn25 = "1";
        }else if(spn25.equals("ทำค่อนข้างบ่อย")){
            spn25 = "2";
        }else {
            spn25 = "3";
        }
        spn26 = spinThass26.getSelectedItem().toString();
        tmpspn26 = spn26;
        if(spn26.equals("-")){
            spn26= "-";
        }else if(spn26.equals("ไม่เคยทำ")){
            spn26 = "0";
        }else if(spn26.equals("นานๆทำที")){
            spn26 = "1";
        }else if(spn26.equals("ทำค่อนข้างบ่อย")){
            spn26 = "2";
        }else {
            spn26 = "3";
        }
        spn27 = spinThass27.getSelectedItem().toString();
        tmpspn27 = spn27;
        if(spn27.equals("-")){
            spn27= "-";
        }else if(spn27.equals("ไม่เคยทำ")){
            spn27 = "0";
        }else if(spn27.equals("นานๆทำที")){
            spn27 = "1";
        }else if(spn27.equals("ทำค่อนข้างบ่อย")){
            spn27 = "2";
        }else {
            spn27 = "3";
        }
        spn28 = spinThass28.getSelectedItem().toString();
        tmpspn28 = spn28;
        if(spn28.equals("-")){
            spn28= "-";
        }else if(spn28.equals("ไม่เคยทำ")){
            spn28 = "0";
        }else if(spn28.equals("นานๆทำที")){
            spn28 = "1";
        }else if(spn28.equals("ทำค่อนข้างบ่อย")){
            spn28 = "2";
        }else {
            spn28 = "3";
        }
        spn29 = spinThass29.getSelectedItem().toString();
        tmpspn29 = spn29;
        if(spn29.equals("-")){
            spn29= "-";
        }else if(spn29.equals("ไม่เคยทำ")){
            spn29 = "0";
        }else if(spn29.equals("นานๆทำที")){
            spn29 = "1";
        }else if(spn29.equals("ทำค่อนข้างบ่อย")){
            spn29 = "2";
        }else {
            spn29 = "3";
        }
        spn30= spinThass30.getSelectedItem().toString();
        tmpspn30 = spn30;
        if(spn30.equals("-")){
            spn30= "-";
        }else if(spn30.equals("ไม่เคยทำ")){
            spn30 = "0";
        }else if(spn30.equals("นานๆทำที")){
            spn30 = "1";
        }else if(spn30.equals("ทำค่อนข้างบ่อย")){
            spn30 = "2";
        }else {
            spn30 = "3";
        }
    }

    private void calRisk(String genderString,String dotype ,String ageString) {
        int age ,type,gender ;
        age = Integer.parseInt(ageString);
        type = Integer.parseInt(dotype);
        gender = Integer.parseInt(genderString);
        risk1 = Integer.parseInt(spn)+Integer.parseInt(spn2)+Integer.parseInt(spn3)+Integer.parseInt(spn4)+Integer.parseInt(spn5)
                +Integer.parseInt(spn6)+Integer.parseInt(spn7)+Integer.parseInt(spn8)+Integer.parseInt(spn9)
                +Integer.parseInt(spn10) +Integer.parseInt(spn11)+Integer.parseInt(spn12)+Integer.parseInt(spn13)
                +Integer.parseInt(spn14)+Integer.parseInt(spn15);
        trisk1 = risk1;

        risk2 = Integer.parseInt(spn16) + Integer.parseInt(spn17) + Integer.parseInt(spn18) + Integer.parseInt(spn19)
                + Integer.parseInt(spn20) + Integer.parseInt(spn21) + Integer.parseInt(spn22) + Integer.parseInt(spn23)
                + Integer.parseInt(spn24) + Integer.parseInt(spn25) + Integer.parseInt(spn26) + Integer.parseInt(spn27)
                + Integer.parseInt(spn28) + Integer.parseInt(spn29) + Integer.parseInt(spn30);
        trisk2 = risk2;
        risk3 = risk1 + risk2;
        trisk3 = risk3;
        if(gender==0){ // ผู้ชาย
            if(type==1){ //ผู้ปกครอง   เด็กู้ชาย    ******************* ตารางหน้า 64
                if(age>=6&&age<9){
                    boyParent6To8();
                }else if(age>=9&&age<=11){
                    boyParent9To11();
                }else if(age>=12&&age<=14){
                    boyParent12To14();
                }else if(age>=15&&age<=18){
                    boyParent15To18();
                }

            }else{//ครู เด็กชาย ******************* ตารางหน้า 68
                if(age>=6&&age<9){
                    boyTeacher6To8();
                }else if(age>=9&&age<=11){
                    boyTeacher9To11();
                }else if(age>=12&&age<=14){
                    boyTeacher12To14();
                }else if(age>=15&&age<=18){
                    boyTeacher15To18();
                }

            }



        }else{//ผู้หญิง gender==1
            if(type==1){ //ผู้ปกครอง เด็กหญิง ******************* ตารางหน้า 66
                if(age>=6&&age<9){
                    girlParent6To8();

                }else if(age>=9&&age<=11){
                    girlParent9To11();
                }else if(age>=12&&age<=14){
                    girlParent12To14();
                }else if(age>=15&&age<=18){
                    girlParent15To18();
                }

            }else{//ครู เด็กหญิง  ******************* ตารางหน้า 70
                if(age>=6&&age<9){
                    girlTeacher6To8();
                }else if(age>=9&&age<=11){
                    girlTeacher9To11();
                }else if(age>=12&&age<=14){
                    girlTeacher12To14();
                }else if(age>=15&&age<=18){
                    girlTeacher15To18();
                }

            }



        }

    }

    private void girlTeacher15To18() {
        switch (trisk1) { // ด้าน 1 หญิง ครู
            case 0:
                trisk1 = 40;
                break;
            case 1:
                trisk1 = 41;
                break;
            case 2:
                trisk1 = 42;
                break;
            case 3:
                trisk1 = 43;
                break;
            case 4:
                trisk1 = 44;
                break;
            case 5:
                trisk1 = 45;
                break;
            case 6:
                trisk1 = 47;
                break;
            case 7:
                trisk1 = 48;
                break;
            case 8:
                trisk1 = 49;
                break;
            case 9:
                trisk1 = 50;
                break;
            case 10:
                trisk1 = 51;
                break;
            case 11:
                trisk1 = 52;
                break;
            case 12:
                trisk1 = 54;
                break;
            case 13:
                trisk1 = 55;
                break;
            case 14:
                trisk1 = 56;
                break;
            case 15:
                trisk1 = 57;
                break;
            case 16:
                trisk1 = 58;
                break;
            case 17:
                trisk1 = 59;
                break;
            case 18:
                trisk1 = 61;
                break;
            case 19:
                trisk1 = 62;
                break;
            case 20:
                trisk1 = 63;
                break;
            case 21:
                trisk1 = 64;
                break;
            case 22:
                trisk1 = 65;
                break;
            case 23:
                trisk1 = 66;
                break;
            case 24:
                trisk1 = 68;
                break;
            case 25:
                trisk1 = 69;
                break;
            case 26:
                trisk1 = 70;
                break;
            case 27:
                trisk1 = 71;
                break;
            case 28:
                trisk1 = 72;
                break;
            case 29:
                trisk1 = 73;
                break;
            case 30:
                trisk1 = 75;
                break;
            case 31:
                trisk1 = 76;
                break;
            case 32:
                trisk1 = 77;
                break;
            case 33:
                trisk1 = 78;
                break;
            case 34:
                trisk1 = 79;
                break;
            case 35:
                trisk1 = 80;
                break;
            case 36:
                trisk1 = 82;
                break;
            case 37:
                trisk1 = 83;
                break;
            case 38:
                trisk1 = 84;
                break;
            case 39:
                trisk1 = 85;
                break;
            case 40:
                trisk1 = 86;
                break;
            case 41:
                trisk1 = 87;
                break;
            case 42:
                trisk1 = 88;
                break;
            case 43:
                trisk1 = 89;
                break;
            case 44:
                trisk1 = 91;
                break;
            case 45:
                trisk1 = 92;
                break;
        }

        /**************************************************/
        switch (trisk2) { // ด้าน 2 หญิง ครู
            case 0:
                trisk2 = 38;
                break;
            case 1:
                trisk2 = 39;

                break;
            case 2:
                trisk2 = 40;
                break;
            case 3:
                trisk2 = 41;

                break;
            case 4:
                trisk2 = 42;

                break;
            case 5:
                trisk2 = 43;

                break;
            case 6:
                trisk2 = 44;

                break;
            case 7:
                trisk2 = 45;

                break;
            case 8:
                trisk2 = 46;
                break;
            case 9:
                trisk2 = 47;

                break;
            case 10:
                trisk2 = 48;

                break;
            case 11:
                trisk2 = 49;

                break;
            case 12:
                trisk2 = 50;

                break;
            case 13:
                trisk2 = 51;

                break;
            case 14:
                trisk2 = 52;

                break;
            case 15:
                trisk2 = 53;

                break;
            case 16:
                trisk2 = 54;
                break;
            case 17:
                trisk2 = 55;

                break;
            case 18:
                trisk2 = 56;

                break;
            case 19:
                trisk2 = 57;

                break;
            case 20:
                trisk2 = 58;

                break;
            case 21:
                trisk2 = 59;

                break;
            case 22:
                trisk2 = 60;

                break;
            case 23:
                trisk2 = 61;

                break;
            case 24:
                trisk2 = 62;
                break;
            case 25:
                trisk2 = 63;

                break;
            case 26:
                trisk2 = 64;

                break;
            case 27:
                trisk2 = 65;

                break;
            case 28:
                trisk2 = 66;

                break;
            case 29:
                trisk2 = 67;

                break;
            case 30:
                trisk2 = 68;

                break;
            case 31:
                trisk2 = 69;

                break;
            case 32:
                trisk2 = 70;
                break;
            case 33:
                trisk2 = 71;

                break;
            case 34:
                trisk2 = 72;

                break;
            case 35:
                trisk2 = 73;

                break;
            case 36:
                trisk2 = 74;

                break;
            case 37:
                trisk2 = 75;

                break;
            case 38:
                trisk2 = 76;

                break;
            case 39:
                trisk2 = 77;

                break;
            case 40:
                trisk2 = 78;
                break;
            case 41:
                trisk2 = 79;

                break;
            case 42:
                trisk2 = 80;

                break;
            case 43:
                trisk2 = 81;

                break;
            case 44:
                trisk2 = 82;

                break;
            case 45:
                trisk2 = 83;
                break;
        }

        /**************************************************/
        switch (trisk3) { // ด้าน 3 หญิง ครู
            case 0:
                trisk3 = 36;
                break;
            case 1:
                trisk3 = 37;

                break;
            case 2:
                trisk3 = 38;
                break;
            case 3:
                trisk3 = 39;

                break;
            case 4:
                trisk3 = 40;

                break;
            case 5:
                trisk3 = 41;

                break;
            case 6:
                trisk3 = 41;

                break;
            case 7:
                trisk3 = 42;

                break;
            case 8:
                trisk3 = 42;
                break;
            case 9:
                trisk3 = 43;

                break;
            case 10:
                trisk3 = 44;

                break;
            case 11:
                trisk3 = 44;

                break;
            case 12:
                trisk3 = 45;

                break;
            case 13:
                trisk3 = 45;

                break;
            case 14:
                trisk3 = 46;

                break;
            case 15:
                trisk3 = 47;

                break;
            case 16:
                trisk3 = 47;
                break;
            case 17:
                trisk3 = 48;

                break;
            case 18:
                trisk3 = 48;

                break;
            case 19:
                trisk3 = 49;

                break;
            case 20:
                trisk3 = 50;

                break;
            case 21:
                trisk3 = 50;

                break;
            case 22:
                trisk3 = 51;

                break;
            case 23:
                trisk3 = 51;

                break;
            case 24:
                trisk3 = 52;
                break;
            case 25:
                trisk3 = 52;

                break;
            case 26:
                trisk3 = 53;

                break;
            case 27:
                trisk3 = 54;

                break;
            case 28:
                trisk3 = 54;

                break;
            case 29:
                trisk3 = 55;

                break;
            case 30:
                trisk3 = 55;

                break;
            case 31:
                trisk3 = 56;

                break;
            case 32:
                trisk3 = 57;
                break;
            case 33:
                trisk3 = 57;

                break;
            case 34:
                trisk3 = 58;

                break;
            case 35:
                trisk3 = 58;

                break;
            case 36:
                trisk3 = 59;

                break;
            case 37:
                trisk3 = 60;

                break;
            case 38:
                trisk3 = 60;

                break;
            case 39:
                trisk3 = 61;

                break;
            case 40:
                trisk3 = 61;
                break;
            case 41:
                trisk3 = 62;

                break;
            case 42:
                trisk3 = 63;

                break;
            case 43:
                trisk3 = 63;

                break;
            case 44:
                trisk3 = 64;

                break;
            case 45:
                trisk3 = 64;
                break;
            case 46:
                trisk3 = 65;
                break;
            case 47:
                trisk3 = 65;
                break;
            case 48:
                trisk3 = 66;
                break;
            case 49:
                trisk3 = 67;
                break;
            case 50:
                trisk3 = 67;
                break;
            case 51:
                trisk3 = 68;
                break;
            case 52:
                trisk3 = 68;
                break;
            case 53:
                trisk3 = 69;
                break;
            case 54:
                trisk3 = 70;
                break;
            case 55:
                trisk3 = 70;
                break;
            case 56:
                trisk3 = 71;
                break;
            case 57:
                trisk3 = 71;
                break;
            case 58:
                trisk3 = 72;
                break;
            case 59:
                trisk3 = 72;
                break;
            case 60:
                trisk3 = 73;
                break;
            case 61:
                trisk3 = 74;
                break;
            case 62:
                trisk3 = 74;
                break;
            case 63:
                trisk3 = 75;
            case 64:
                trisk3 = 75;
                break;
            case 65:
                trisk3 = 76;
                break;
            case 66:
                trisk3 = 77;
                break;
            case 67:
                trisk3 = 77;
                break;
            case 68:
                trisk3 = 78;
                break;
            case 69:
                trisk3 = 79;
                break;
            case 70:
                trisk3 = 79;
                break;
            case 71:
                trisk3 = 80;
                break;
            case 72:
                trisk3 = 80;
                break;
            case 73:
                trisk3 = 81;
                break;
            case 74:
                trisk3 = 81;
                break;
            case 75:
                trisk3 = 82;
                break;
            case 76:
                trisk3 = 82;
                break;
            case 77:
                trisk3 = 83;
                break;
            case 78:
                trisk3 = 84;
                break;
            case 79:
                trisk3 = 84;
                break;
            case 80:
                trisk3 = 85;
                break;
            case 81:
                trisk3 = 85;
                break;
            case 82:
                trisk3 = 86;
                break;
            case 83:
                trisk3 = 86;
                break;
            case 84:
                trisk3 = 87;
                break;
            case 85:
                trisk3 = 88;
                break;
            case 86:
                trisk3 = 88;
                break;
            case 87:
                trisk3 = 89;
                break;
            case 88:
                trisk3 = 89;
                break;
            case 89:
                trisk3 = 90;
                break;
            case 90:
                trisk3 = 91;
                break;


        }
    }

    private void girlTeacher12To14(){
        switch (trisk1) { // ด้าน 1 หญิง ครู
            case 0:
                trisk1 = 40;
                break;
            case 1:
                trisk1 = 41;
                break;
            case 2:
                trisk1 = 42;
                break;
            case 3:
                trisk1 = 44;
                break;
            case 4:
                trisk1 = 45;
                break;
            case 5:
                trisk1 = 46;
                break;
            case 6:
                trisk1 = 47;
                break;
            case 7:
                trisk1 = 48;
                break;
            case 8:
                trisk1 = 49;
                break;
            case 9:
                trisk1 = 50;
                break;
            case 10:
                trisk1 = 51;
                break;
            case 11:
                trisk1 = 53;
                break;
            case 12:
                trisk1 = 54;
                break;
            case 13:
                trisk1 = 55;
                break;
            case 14:
                trisk1 = 56;
                break;
            case 15:
                trisk1 = 57;
                break;
            case 16:
                trisk1 = 58;
                break;
            case 17:
                trisk1 = 59;
                break;
            case 18:
                trisk1 = 61;
                break;
            case 19:
                trisk1 = 62;
                break;
            case 20:
                trisk1 = 63;
                break;
            case 21:
                trisk1 = 64;
                break;
            case 22:
                trisk1 = 65;
                break;
            case 23:
                trisk1 = 66;
                break;
            case 24:
                trisk1 = 67;
                break;
            case 25:
                trisk1 = 68;
                break;
            case 26:
                trisk1 = 70;
                break;
            case 27:
                trisk1 = 71;
                break;
            case 28:
                trisk1 = 72;
                break;
            case 29:
                trisk1 = 73;
                break;
            case 30:
                trisk1 = 74;
                break;
            case 31:
                trisk1 = 75;
                break;
            case 32:
                trisk1 = 76;
                break;
            case 33:
                trisk1 = 77;
                break;
            case 34:
                trisk1 = 79;
                break;
            case 35:
                trisk1 = 80;
                break;
            case 36:
                trisk1 = 81;
                break;
            case 37:
                trisk1 = 82;
                break;
            case 38:
                trisk1 = 83;
                break;
            case 39:
                trisk1 = 84;
                break;
            case 40:
                trisk1 = 85;
                break;
            case 41:
                trisk1 = 86;
                break;
            case 42:
                trisk1 = 87;
                break;
            case 43:
                trisk1 = 88;
                break;
            case 44:
                trisk1 = 89;
                break;
            case 45:
                trisk1 = 90;
                break;
        }

        /**************************************************/
        switch (trisk2) { // ด้าน 2 หญิง ครู
            case 0:
                trisk2 = 39;
                break;
            case 1:
                trisk2 = 40;

                break;
            case 2:
                trisk2 = 41;
                break;
            case 3:
                trisk2 = 42;

                break;
            case 4:
                trisk2 = 43;

                break;
            case 5:
                trisk2 = 44;

                break;
            case 6:
                trisk2 = 45;

                break;
            case 7:
                trisk2 = 46;

                break;
            case 8:
                trisk2 = 46;
                break;
            case 9:
                trisk2 = 47;

                break;
            case 10:
                trisk2 = 48;

                break;
            case 11:
                trisk2 = 49;

                break;
            case 12:
                trisk2 = 50;

                break;
            case 13:
                trisk2 = 51;

                break;
            case 14:
                trisk2 = 52;

                break;
            case 15:
                trisk2 = 53;

                break;
            case 16:
                trisk2 = 54;
                break;
            case 17:
                trisk2 = 55;

                break;
            case 18:
                trisk2 = 56;

                break;
            case 19:
                trisk2 = 57;

                break;
            case 20:
                trisk2 = 58;

                break;
            case 21:
                trisk2 = 58;

                break;
            case 22:
                trisk2 = 59;

                break;
            case 23:
                trisk2 = 60;

                break;
            case 24:
                trisk2 = 61;
                break;
            case 25:
                trisk2 = 62;

                break;
            case 26:
                trisk2 = 63;

                break;
            case 27:
                trisk2 = 64;

                break;
            case 28:
                trisk2 = 65;

                break;
            case 29:
                trisk2 = 66;

                break;
            case 30:
                trisk2 = 67;

                break;
            case 31:
                trisk2 = 68;

                break;
            case 32:
                trisk2 = 69;
                break;
            case 33:
                trisk2 = 70;

                break;
            case 34:
                trisk2 = 71;

                break;
            case 35:
                trisk2 = 71;

                break;
            case 36:
                trisk2 = 72;

                break;
            case 37:
                trisk2 = 73;

                break;
            case 38:
                trisk2 = 74;

                break;
            case 39:
                trisk2 = 75;

                break;
            case 40:
                trisk2 = 76;
                break;
            case 41:
                trisk2 = 77;

                break;
            case 42:
                trisk2 = 78;

                break;
            case 43:
                trisk2 = 79;

                break;
            case 44:
                trisk2 = 80;

                break;
            case 45:
                trisk2 = 81;
                break;
        }

        /**************************************************/
        switch (trisk3) { // ด้าน 3 หญิง ครู
            case 0:
                trisk3 = 37;
                break;
            case 1:
                trisk3 = 38;

                break;
            case 2:
                trisk3 = 39;
                break;
            case 3:
                trisk3 = 40;

                break;
            case 4:
                trisk3 = 41;

                break;
            case 5:
                trisk3 = 41;

                break;
            case 6:
                trisk3 = 42;

                break;
            case 7:
                trisk3 = 43;

                break;
            case 8:
                trisk3 = 43;
                break;
            case 9:
                trisk3 = 44;

                break;
            case 10:
                trisk3 = 44;

                break;
            case 11:
                trisk3 = 45;

                break;
            case 12:
                trisk3 = 45;

                break;
            case 13:
                trisk3 = 46;

                break;
            case 14:
                trisk3 = 46;

                break;
            case 15:
                trisk3 = 47;

                break;
            case 16:
                trisk3 = 48;
                break;
            case 17:
                trisk3 = 48;

                break;
            case 18:
                trisk3 = 49;

                break;
            case 19:
                trisk3 = 49;

                break;
            case 20:
                trisk3 = 50;

                break;
            case 21:
                trisk3 = 50;

                break;
            case 22:
                trisk3 = 51;

                break;
            case 23:
                trisk3 = 51;

                break;
            case 24:
                trisk3 = 52;
                break;
            case 25:
                trisk3 = 52;

                break;
            case 26:
                trisk3 = 53;

                break;
            case 27:
                trisk3 = 54;

                break;
            case 28:
                trisk3 = 54;

                break;
            case 29:
                trisk3 = 55;

                break;
            case 30:
                trisk3 = 55;

                break;
            case 31:
                trisk3 = 56;

                break;
            case 32:
                trisk3 = 56;
                break;
            case 33:
                trisk3 = 57;

                break;
            case 34:
                trisk3 = 57;

                break;
            case 35:
                trisk3 = 58;

                break;
            case 36:
                trisk3 = 59;

                break;
            case 37:
                trisk3 = 59;

                break;
            case 38:
                trisk3 = 60;

                break;
            case 39:
                trisk3 = 60;

                break;
            case 40:
                trisk3 = 61;
                break;
            case 41:
                trisk3 = 61;

                break;
            case 42:
                trisk3 = 62;

                break;
            case 43:
                trisk3 = 62;

                break;
            case 44:
                trisk3 = 63;

                break;
            case 45:
                trisk3 = 64;
                break;
            case 46:
                trisk3 = 64;
                break;
            case 47:
                trisk3 = 65;
                break;
            case 48:
                trisk3 = 65;
                break;
            case 49:
                trisk3 = 66;
                break;
            case 50:
                trisk3 = 66;
                break;
            case 51:
                trisk3 = 67;
                break;
            case 52:
                trisk3 = 67;
                break;
            case 53:
                trisk3 = 68;
                break;
            case 54:
                trisk3 = 69;
                break;
            case 55:
                trisk3 = 69;
                break;
            case 56:
                trisk3 = 70;
                break;
            case 57:
                trisk3 = 70;
                break;
            case 58:
                trisk3 = 71;
                break;
            case 59:
                trisk3 = 71;
                break;
            case 60:
                trisk3 = 72;
                break;
            case 61:
                trisk3 = 72;
                break;
            case 62:
                trisk3 = 73;
                break;
            case 63:
                trisk3 = 73;
                break;
            case 64:
                trisk3 = 74;
                break;
            case 65:
                trisk3 = 75;
                break;
            case 66:
                trisk3 = 75;
                break;
            case 67:
                trisk3 = 76;
                break;
            case 68:
                trisk3 = 76;
                break;
            case 69:
                trisk3 = 77;
                break;
            case 70:
                trisk3 = 77;
                break;
            case 71:
                trisk3 = 78;
                break;
            case 72:
                trisk3 = 78;
                break;
            case 73:
                trisk3 = 79;
                break;
            case 74:
                trisk3 = 79;
                break;
            case 75:
                trisk3 = 80;
                break;
            case 76:
                trisk3 = 80;
                break;
            case 77:
                trisk3 = 81;
                break;
            case 78:
                trisk3 = 82;
                break;
            case 79:
                trisk3 = 82;
                break;
            case 80:
                trisk3 = 83;
                break;
            case 81:
                trisk3 = 83;
                break;
            case 82:
                trisk3 = 84;
                break;
            case 83:
                trisk3 = 84;
                break;
            case 84:
                trisk3 = 85;
                break;
            case 85:
                trisk3 = 85;
                break;
            case 86:
                trisk3 = 86;
                break;
            case 87:
                trisk3 = 86;
                break;
            case 88:
                trisk3 = 87;
                break;
            case 89:
                trisk3 = 88;
                break;
            case 90:
                trisk3 = 89;
                break;


        }
    }

    private void girlTeacher9To11() {
        switch (trisk1) { // ด้าน 1 หญิง ครู
            case 0:
                trisk1 = 40;
                break;
            case 1:
                trisk1 = 41;
                break;
            case 2:
                trisk1 = 43;
                break;
            case 3:
                trisk1 = 44;
                break;
            case 4:
                trisk1 = 45;
                break;
            case 5:
                trisk1 = 46;
                break;
            case 6:
                trisk1 = 7;
                break;
            case 7:
                trisk1 = 48;
                break;
            case 8:
                trisk1 = 49;
                break;
            case 9:
                trisk1 = 50;
                break;
            case 10:
                trisk1 = 51;
                break;
            case 11:
                trisk1 = 52;
                break;
            case 12:
                trisk1 = 53;
                break;
            case 13:
                trisk1 = 54;
                break;
            case 14:
                trisk1 = 55;
                break;
            case 15:
                trisk1 = 56;
                break;
            case 16:
                trisk1 = 57;
                break;
            case 17:
                trisk1 = 58;
                break;
            case 18:
                trisk1 = 59;
                break;
            case 19:
                trisk1 = 60;
                break;
            case 20:
                trisk1 = 61;
                break;
            case 21:
                trisk1 = 62;
                break;
            case 22:
                trisk1 = 63;
                break;
            case 23:
                trisk1 = 65;
                break;
            case 24:
                trisk1 = 66;
                break;
            case 25:
                trisk1 = 67;
                break;
            case 26:
                trisk1 = 68;
                break;
            case 27:
                trisk1 = 69;
                break;
            case 28:
                trisk1 = 70;
                break;
            case 29:
                trisk1 = 71;
                break;
            case 30:
                trisk1 = 72;
                break;
            case 31:
                trisk1 = 73;
                break;
            case 32:
                trisk1 = 74;
                break;
            case 33:
                trisk1 = 75;
                break;
            case 34:
                trisk1 = 76;
                break;
            case 35:
                trisk1 = 77;
                break;
            case 36:
                trisk1 = 78;
                break;
            case 37:
                trisk1 = 79;
                break;
            case 38:
                trisk1 = 80;
                break;
            case 39:
                trisk1 = 81;
                break;
            case 40:
                trisk1 = 82;
                break;
            case 41:
                trisk1 = 83;
                break;
            case 42:
                trisk1 = 84;
                break;
            case 43:
                trisk1 = 85;
                break;
            case 44:
                trisk1 = 85;
                break;
            case 45:
                trisk1 = 87;
                break;
        }

        /**************************************************/
        switch (trisk2) { // ด้าน 2 หญิง ครู
            case 0:
                trisk2 = 39;
                break;
            case 1:
                trisk2 = 40;

                break;
            case 2:
                trisk2 = 41;
                break;
            case 3:
                trisk2 = 42;

                break;
            case 4:
                trisk2 = 43;

                break;
            case 5:
                trisk2 = 44;

                break;
            case 6:
                trisk2 = 44;

                break;
            case 7:
                trisk2 = 45;

                break;
            case 8:
                trisk2 = 46;
                break;
            case 9:
                trisk2 = 47;

                break;
            case 10:
                trisk2 = 48;

                break;
            case 11:
                trisk2 = 49;

                break;
            case 12:
                trisk2 = 49;

                break;
            case 13:
                trisk2 = 50;

                break;
            case 14:
                trisk2 = 51;

                break;
            case 15:
                trisk2 = 52;

                break;
            case 16:
                trisk2 = 53;
                break;
            case 17:
                trisk2 = 54;

                break;
            case 18:
                trisk2 = 54;

                break;
            case 19:
                trisk2 = 55;

                break;
            case 20:
                trisk2 = 56;

                break;
            case 21:
                trisk2 = 57;

                break;
            case 22:
                trisk2 = 58;

                break;
            case 23:
                trisk2 = 59;

                break;
            case 24:
                trisk2 = 59;
                break;
            case 25:
                trisk2 = 60;

                break;
            case 26:
                trisk2 = 61;

                break;
            case 27:
                trisk2 = 62;

                break;
            case 28:
                trisk2 = 63;

                break;
            case 29:
                trisk2 = 64;

                break;
            case 30:
                trisk2 = 64;

                break;
            case 31:
                trisk2 = 65;

                break;
            case 32:
                trisk2 = 66;
                break;
            case 33:
                trisk2 = 67;

                break;
            case 34:
                trisk2 = 68;

                break;
            case 35:
                trisk2 = 69;

                break;
            case 36:
                trisk2 = 69;

                break;
            case 37:
                trisk2 = 70;

                break;
            case 38:
                trisk2 = 71;

                break;
            case 39:
                trisk2 = 72;

                break;
            case 40:
                trisk2 = 73;
                break;
            case 41:
                trisk2 = 74;

                break;
            case 42:
                trisk2 = 74;

                break;
            case 43:
                trisk2 = 75;

                break;
            case 44:
                trisk2 = 76;

                break;
            case 45:
                trisk2 = 77;
                break;
        }

        /**************************************************/
        switch (trisk3) { // ด้าน 3 หญิง ครู
            case 0:
                trisk3 = 36;
                break;
            case 1:
                trisk3 = 37;

                break;
            case 2:
                trisk3 = 38;
                break;
            case 3:
                trisk3 = 39;

                break;
            case 4:
                trisk3 = 40;

                break;
            case 5:
                trisk3 = 41;

                break;
            case 6:
                trisk3 = 42;

                break;
            case 7:
                trisk3 = 43;

                break;
            case 8:
                trisk3 = 43;
                break;
            case 9:
                trisk3 = 44;

                break;
            case 10:
                trisk3 = 44;

                break;
            case 11:
                trisk3 = 45;

                break;
            case 12:
                trisk3 = 45;

                break;
            case 13:
                trisk3 = 46;

                break;
            case 14:
                trisk3 = 46;

                break;
            case 15:
                trisk3 = 47;

                break;
            case 16:
                trisk3 = 47;
                break;
            case 17:
                trisk3 = 48;

                break;
            case 18:
                trisk3 = 48;

                break;
            case 19:
                trisk3 = 49;

                break;
            case 20:
                trisk3 = 49;

                break;
            case 21:
                trisk3 = 50;

                break;
            case 22:
                trisk3 = 50;

                break;
            case 23:
                trisk3 = 51;

                break;
            case 24:
                trisk3 = 51;
                break;
            case 25:
                trisk3 = 52;

                break;
            case 26:
                trisk3 = 52;

                break;
            case 27:
                trisk3 = 53;

                break;
            case 28:
                trisk3 = 53;

                break;
            case 29:
                trisk3 = 54;

                break;
            case 30:
                trisk3 = 54;

                break;
            case 31:
                trisk3 = 55;

                break;
            case 32:
                trisk3 = 55;
                break;
            case 33:
                trisk3 = 56;

                break;
            case 34:
                trisk3 = 56;

                break;
            case 35:
                trisk3 = 57;

                break;
            case 36:
                trisk3 = 57;

                break;
            case 37:
                trisk3 = 58;

                break;
            case 38:
                trisk3 = 58;

                break;
            case 39:
                trisk3 = 59;

                break;
            case 40:
                trisk3 = 59;
                break;
            case 41:
                trisk3 = 60;

                break;
            case 42:
                trisk3 = 60;

                break;
            case 43:
                trisk3 = 61;

                break;
            case 44:
                trisk3 = 61;

                break;
            case 45:
                trisk3 = 62;
                break;
            case 46:
                trisk3 = 62;
                break;
            case 47:
                trisk3 = 63;
                break;
            case 48:
                trisk3 = 63;
                break;
            case 49:
                trisk3 = 64;
                break;
            case 50:
                trisk3 = 64;
                break;
            case 51:
                trisk3 = 65;
                break;
            case 52:
                trisk3 = 65;
                break;
            case 53:
                trisk3 = 66;
                break;
            case 54:
                trisk3 = 66;
                break;
            case 55:
                trisk3 = 67;
                break;
            case 56:
                trisk3 = 67;
                break;
            case 57:
                trisk3 = 68;
                break;
            case 58:
                trisk3 = 68;
                break;
            case 59:
                trisk3 = 69;
                break;
            case 60:
                trisk3 = 69;
                break;
            case 61:
                trisk3 = 70;
                break;
            case 62:
                trisk3 = 70;
                break;
            case 63:
                trisk3 = 71;
                break;
            case 64:
                trisk3 = 71;
                break;
            case 65:
                trisk3 = 72;
                break;
            case 66:
                trisk3 = 72;
                break;
            case 67:
                trisk3 = 73;
                break;
            case 68:
                trisk3 = 73;
                break;
            case 69:
                trisk3 = 74;
                break;
            case 70:
                trisk3 = 74;
                break;
            case 71:
                trisk3 = 75;
                break;
            case 72:
                trisk3 = 75;
                break;
            case 73:
                trisk3 = 76;
                break;
            case 74:
                trisk3 = 76;
                break;
            case 75:
                trisk3 = 76;
                break;
            case 76:
                trisk3 = 77;
                break;
            case 77:
                trisk3 = 77;
                break;
            case 78:
                trisk3 = 78;
                break;
            case 79:
                trisk3 = 78;
                break;
            case 80:
                trisk3 = 79;
                break;
            case 81:
                trisk3 = 79;
                break;
            case 82:
                trisk3 = 80;
                break;
            case 83:
                trisk3 = 80;
                break;
            case 84:
                trisk3 = 81;
                break;
            case 85:
                trisk3 = 81;
                break;
            case 86:
                trisk3 = 82;
                break;
            case 87:
                trisk3 = 82;
                break;
            case 88:
                trisk3 = 83;
                break;
            case 89:
                trisk3 = 84;
                break;
            case 90:
                trisk3 = 85;
                break;


        }
    }

    private void girlTeacher6To8() {
        switch (trisk1) { // ด้าน 1 หญิง ครู
            case 0:
                trisk1 = 39;
                break;
            case 1:
                trisk1 = 40;
                break;
            case 2:
                trisk1 = 41;
                break;
            case 3:
                trisk1 = 42;
                break;
            case 4:
                trisk1 = 43;
                break;
            case 5:
                trisk1 = 44;
                break;
            case 6:
                trisk1 = 45;
                break;
            case 7:
                trisk1 = 46;
                break;
            case 8:
                trisk1 = 47;
                break;
            case 9:
                trisk1 = 48;
                break;
            case 10:
                trisk1 = 49;
                break;
            case 11:
                trisk1 = 50;
                break;
            case 12:
                trisk1 = 51;
                break;
            case 13:
                trisk1 = 52;
                break;
            case 14:
                trisk1 = 53;
                break;
            case 15:
                trisk1 = 54;
                break;
            case 16:
                trisk1 = 55;
                break;
            case 17:
                trisk1 = 56;
                break;
            case 18:
                trisk1 = 57;
                break;
            case 19:
                trisk1 = 58;
                break;
            case 20:
                trisk1 = 59;
                break;
            case 21:
                trisk1 = 60;
                break;
            case 22:
                trisk1 = 61;
                break;
            case 23:
                trisk1 = 62;
                break;
            case 24:
                trisk1 = 63;
                break;
            case 25:
                trisk1 = 64;
                break;
            case 26:
                trisk1 = 65;
                break;
            case 27:
                trisk1 = 66;
                break;
            case 28:
                trisk1 = 67;
                break;
            case 29:
                trisk1 = 68;
                break;
            case 30:
                trisk1 = 69;
                break;
            case 31:
                trisk1 = 70;
                break;
            case 32:
                trisk1 = 71;
                break;
            case 33:
                trisk1 = 72;
                break;
            case 34:
                trisk1 = 73;
                break;
            case 35:
                trisk1 = 74;
                break;
            case 36:
                trisk1 = 75;
                break;
            case 37:
                trisk1 = 76;
                break;
            case 38:
                trisk1 = 77;
                break;
            case 39:
                trisk1 = 78;
                break;
            case 40:
                trisk1 = 79;
                break;
            case 41:
                trisk1 = 80;
                break;
            case 42:
                trisk1 = 81;
                break;
            case 43:
                trisk1 = 82;
                break;
            case 44:
                trisk1 = 83;
                break;
            case 45:
                trisk1 = 84;
                break;
        }

        /**************************************************/
        switch (trisk2) { // ด้าน 2 หญิง ครู
            case 0:
                trisk2 = 37;
                break;
            case 1:
                trisk2 = 38;

                break;
            case 2:
                trisk2 = 39;
                break;
            case 3:
                trisk2 = 40;

                break;
            case 4:
                trisk2 = 41;

                break;
            case 5:
                trisk2 = 42;

                break;
            case 6:
                trisk2 = 43;

                break;
            case 7:
                trisk2 = 43;

                break;
            case 8:
                trisk2 = 44;
                break;
            case 9:
                trisk2 = 45;

                break;
            case 10:
                trisk2 = 46;

                break;
            case 11:
                trisk2 = 47;

                break;
            case 12:
                trisk2 = 47;

                break;
            case 13:
                trisk2 = 48;

                break;
            case 14:
                trisk2 = 49;

                break;
            case 15:
                trisk2 = 50;

                break;
            case 16:
                trisk2 = 51;
                break;
            case 17:
                trisk2 = 51;

                break;
            case 18:
                trisk2 = 52;

                break;
            case 19:
                trisk2 = 53;

                break;
            case 20:
                trisk2 = 54;

                break;
            case 21:
                trisk2 = 55;

                break;
            case 22:
                trisk2 = 55;

                break;
            case 23:
                trisk2 = 56;

                break;
            case 24:
                trisk2 = 57;
                break;
            case 25:
                trisk2 = 58;

                break;
            case 26:
                trisk2 = 59;

                break;
            case 27:
                trisk2 = 59;

                break;
            case 28:
                trisk2 = 60;

                break;
            case 29:
                trisk2 = 61;

                break;
            case 30:
                trisk2 = 62;

                break;
            case 31:
                trisk2 = 63;

                break;
            case 32:
                trisk2 = 63;
                break;
            case 33:
                trisk2 = 64;

                break;
            case 34:
                trisk2 = 65;

                break;
            case 35:
                trisk2 = 66;

                break;
            case 36:
                trisk2 = 66;

                break;
            case 37:
                trisk2 = 67;

                break;
            case 38:
                trisk2 = 68;

                break;
            case 39:
                trisk2 = 69;

                break;
            case 40:
                trisk2 = 70;
                break;
            case 41:
                trisk2 = 70;

                break;
            case 42:
                trisk2 = 71;

                break;
            case 43:
                trisk2 = 72;

                break;
            case 44:
                trisk2 = 73;

                break;
            case 45:
                trisk2 = 74;
                break;
        }

        /**************************************************/
        switch (trisk3) { // ด้าน 3 หญิง ครู
            case 0:
                trisk3 = 35;
                break;
            case 1:
                trisk3 = 36;

                break;
            case 2:
                trisk3 = 37;
                break;
            case 3:
                trisk3 = 38;

                break;
            case 4:
                trisk3 = 39;

                break;
            case 5:
                trisk3 = 40;

                break;
            case 6:
                trisk3 = 40;

                break;
            case 7:
                trisk3 = 41;

                break;
            case 8:
                trisk3 = 41;
                break;
            case 9:
                trisk3 = 42;

                break;
            case 10:
                trisk3 = 42;

                break;
            case 11:
                trisk3 = 43;

                break;
            case 12:
                trisk3 = 43;

                break;
            case 13:
                trisk3 = 43;

                break;
            case 14:
                trisk3 = 44;

                break;
            case 15:
                trisk3 = 44;

                break;
            case 16:
                trisk3 = 45;
                break;
            case 17:
                trisk3 = 45;

                break;
            case 18:
                trisk3 = 46;

                break;
            case 19:
                trisk3 = 46;

                break;
            case 20:
                trisk3 = 47;

                break;
            case 21:
                trisk3 = 47;

                break;
            case 22:
                trisk3 = 48;

                break;
            case 23:
                trisk3 = 48;

                break;
            case 24:
                trisk3 = 49;
                break;
            case 25:
                trisk3 = 49;

                break;
            case 26:
                trisk3 = 50;

                break;
            case 27:
                trisk3 = 50;

                break;
            case 28:
                trisk3 = 51;

                break;
            case 29:
                trisk3 = 51;

                break;
            case 30:
                trisk3 = 52;

                break;
            case 31:
                trisk3 = 52;

                break;
            case 32:
                trisk3 = 53;
                break;
            case 33:
                trisk3 = 53;

                break;
            case 34:
                trisk3 = 54;

                break;
            case 35:
                trisk3 = 54;

                break;
            case 36:
                trisk3 = 55;

                break;
            case 37:
                trisk3 = 55;

                break;
            case 38:
                trisk3 = 56;

                break;
            case 39:
                trisk3 = 56;

                break;
            case 40:
                trisk3 = 57;
                break;
            case 41:
                trisk3 = 57;

                break;
            case 42:
                trisk3 = 58;

                break;
            case 43:
                trisk3 = 58;

                break;
            case 44:
                trisk3 = 59;

                break;
            case 45:
                trisk3 = 59;
                break;
            case 46:
                trisk3 = 60;
                break;
            case 47:
                trisk3 = 60;
                break;
            case 48:
                trisk3 = 61;
                break;
            case 49:
                trisk3 = 61;
                break;
            case 50:
                trisk3 = 61;
                break;
            case 51:
                trisk3 = 62;
                break;
            case 52:
                trisk3 = 62;
                break;
            case 53:
                trisk3 = 63;
                break;
            case 54:
                trisk3 = 63;
                break;
            case 55:
                trisk3 = 64;
                break;
            case 56:
                trisk3 = 64;
                break;
            case 57:
                trisk3 = 65;
                break;
            case 58:
                trisk3 = 65;
                break;
            case 59:
                trisk3 = 66;
                break;
            case 60:
                trisk3 = 66;
                break;
            case 61:
                trisk3 = 67;
                break;
            case 62:
                trisk3 = 67;
                break;
            case 63:
                trisk3 = 68;
                break;
            case 64:
                trisk3 = 68;
                break;
            case 65:
                trisk3 = 69;
                break;
            case 66:
                trisk3 = 69;
                break;
            case 67:
                trisk3 = 70;
                break;
            case 68:
                trisk3 = 70;
                break;
            case 69:
                trisk3 = 71;
                break;
            case 70:
                trisk3 = 71;
                break;
            case 71:
                trisk3 = 72;
                break;
            case 72:
                trisk3 = 72;
                break;
            case 73:
                trisk3 = 73;
                break;
            case 74:
                trisk3 = 73;
                break;
            case 75:
                trisk3 = 74;
                break;
            case 76:
                trisk3 = 74;
                break;
            case 77:
                trisk3 = 75;
                break;
            case 78:
                trisk3 = 75;
                break;
            case 79:
                trisk3 = 76;
                break;
            case 80:
                trisk3 = 76;
                break;
            case 81:
                trisk3 = 77;
                break;
            case 82:
                trisk3 = 77;
                break;
            case 83:
                trisk3 = 78;
                break;
            case 84:
                trisk3 = 78;
                break;
            case 85:
                trisk3 = 78;
                break;
            case 86:
                trisk3 = 79;
                break;
            case 87:
                trisk3 = 79;
                break;
            case 88:
                trisk3 = 80;
                break;
            case 89:
                trisk3 = 81;
                break;
            case 90:
                trisk3 = 82;
                break;


        }
    }

    private void boyTeacher15To18() {
        switch (trisk1) { // ด้าน 1 ชาย ครู
            case 0:
                trisk1 = 37;
                break;
            case 1:
                trisk1 = 38;
                break;
            case 2:
                trisk1 = 39;
                break;
            case 3:
                trisk1 = 40;
                break;
            case 4:
                trisk1 = 41;
                break;
            case 5:
                trisk1 = 42;
                break;
            case 6:
                trisk1 = 43;
                break;
            case 7:
                trisk1 = 44;
                break;
            case 8:
                trisk1 = 45;
                break;
            case 9:
                trisk1 = 46;
                break;
            case 10:
                trisk1 = 47;
                break;
            case 11:
                trisk1 = 48;
                break;
            case 12:
                trisk1 = 49;
                break;
            case 13:
                trisk1 = 50;
                break;
            case 14:
                trisk1 = 51;
                break;
            case 15:
                trisk1 = 52;
                break;
            case 16:
                trisk1 = 53;
                break;
            case 17:
                trisk1 = 54;
                break;
            case 18:
                trisk1 = 55;
                break;
            case 19:
                trisk1 = 56;
                break;
            case 20:
                trisk1 = 57;
                break;
            case 21:
                trisk1 = 58;
                break;
            case 22:
                trisk1 = 59;
                break;
            case 23:
                trisk1 = 60;
                break;
            case 24:
                trisk1 = 61;
                break;
            case 25:
                trisk1 = 62;
                break;
            case 26:
                trisk1 = 63;
                break;
            case 27:
                trisk1 = 64;
                break;
            case 28:
                trisk1 = 65;
                break;
            case 29:
                trisk1 = 66;
                break;
            case 30:
                trisk1 = 67;
                break;
            case 31:
                trisk1 = 68;
                break;
            case 32:
                trisk1 = 69;
                break;
            case 33:
                trisk1 = 70;
                break;
            case 34:
                trisk1 = 71;
                break;
            case 35:
                trisk1 = 72;
                break;
            case 36:
                trisk1 = 73;
                break;
            case 37:
                trisk1 = 74;
                break;
            case 38:
                trisk1 = 75;
                break;
            case 39:
                trisk1 = 76;
                break;
            case 40:
                trisk1 = 77;
                break;
            case 41:
                trisk1 = 78;
                break;
            case 42:
                trisk1 = 79;
                break;
            case 43:
                trisk1 = 80;
                break;
            case 44:
                trisk1 = 81;
                break;
            case 45:
                trisk1 = 82;
                break;
        }

        /**************************************************/
        switch (trisk2) { // ด้าน 2 ชาย ครู
            case 0:
                trisk2 = 34;
                break;
            case 1:
                trisk2 = 35;

                break;
            case 2:
                trisk2 = 36;
                break;
            case 3:
                trisk2 = 37;

                break;
            case 4:
                trisk2 = 38;

                break;
            case 5:
                trisk2 = 39;

                break;
            case 6:
                trisk2 = 40;

                break;
            case 7:
                trisk2 = 41;

                break;
            case 8:
                trisk2 = 42;
                break;
            case 9:
                trisk2 = 43;

                break;
            case 10:
                trisk2 = 43;

                break;
            case 11:
                trisk2 = 44;

                break;
            case 12:
                trisk2 = 45;

                break;
            case 13:
                trisk2 = 46;

                break;
            case 14:
                trisk2 = 47;

                break;
            case 15:
                trisk2 = 48;

                break;
            case 16:
                trisk2 = 48;
                break;
            case 17:
                trisk2 = 49;

                break;
            case 18:
                trisk2 = 50;

                break;
            case 19:
                trisk2 = 51;

                break;
            case 20:
                trisk2 = 52;

                break;
            case 21:
                trisk2 = 53;

                break;
            case 22:
                trisk2 = 53;

                break;
            case 23:
                trisk2 = 54;

                break;
            case 24:
                trisk2 = 55;
                break;
            case 25:
                trisk2 = 56;

                break;
            case 26:
                trisk2 = 57;

                break;
            case 27:
                trisk2 = 58;

                break;
            case 28:
                trisk2 = 58;

                break;
            case 29:
                trisk2 = 59;

                break;
            case 30:
                trisk2 = 60;

                break;
            case 31:
                trisk2 = 61;

                break;
            case 32:
                trisk2 = 62;
                break;
            case 33:
                trisk2 = 63;

                break;
            case 34:
                trisk2 = 63;

                break;
            case 35:
                trisk2 = 64;

                break;
            case 36:
                trisk2 = 65;

                break;
            case 37:
                trisk2 = 66;

                break;
            case 38:
                trisk2 = 67;

                break;
            case 39:
                trisk2 = 68;

                break;
            case 40:
                trisk2 = 69;
                break;
            case 41:
                trisk2 = 69;

                break;
            case 42:
                trisk2 = 70;

                break;
            case 43:
                trisk2 = 71;

                break;
            case 44:
                trisk2 = 72;

                break;
            case 45:
                trisk2 = 73;
                break;
        }

        /**************************************************/
        switch (trisk3) { // ด้าน 3 ชาย ครู
            case 0:
                trisk3 = 32;
                break;
            case 1:
                trisk3 = 33;

                break;
            case 2:
                trisk3 = 34;
                break;
            case 3:
                trisk3 = 35;

                break;
            case 4:
                trisk3 = 36;

                break;
            case 5:
                trisk3 = 37;

                break;
            case 6:
                trisk3 = 38;

                break;
            case 7:
                trisk3 = 38;

                break;
            case 8:
                trisk3 = 39;
                break;
            case 9:
                trisk3 = 39;

                break;
            case 10:
                trisk3 = 40;

                break;
            case 11:
                trisk3 = 40;

                break;
            case 12:
                trisk3 = 41;

                break;
            case 13:
                trisk3 = 41;

                break;
            case 14:
                trisk3 = 42;

                break;
            case 15:
                trisk3 = 42;

                break;
            case 16:
                trisk3 = 43;
                break;
            case 17:
                trisk3 = 43;

                break;
            case 18:
                trisk3 = 44;

                break;
            case 19:
                trisk3 = 44;

                break;
            case 20:
                trisk3 = 45;

                break;
            case 21:
                trisk3 = 45;

                break;
            case 22:
                trisk3 = 46;

                break;
            case 23:
                trisk3 = 46;

                break;
            case 24:
                trisk3 = 47;
                break;
            case 25:
                trisk3 = 47;

                break;
            case 26:
                trisk3 = 48;

                break;
            case 27:
                trisk3 = 48;

                break;
            case 28:
                trisk3 = 49;

                break;
            case 29:
                trisk3 = 49;

                break;
            case 30:
                trisk3 = 50;

                break;
            case 31:
                trisk3 = 50;

                break;
            case 32:
                trisk3 = 51;
                break;
            case 33:
                trisk3 = 51;

                break;
            case 34:
                trisk3 = 52;

                break;
            case 35:
                trisk3 = 52;

                break;
            case 36:
                trisk3 = 53;

                break;
            case 37:
                trisk3 = 53;

                break;
            case 38:
                trisk3 = 53;

                break;
            case 39:
                trisk3 = 54;

                break;
            case 40:
                trisk3 = 54;
                break;
            case 41:
                trisk3 = 55;

                break;
            case 42:
                trisk3 = 55;

                break;
            case 43:
                trisk3 = 56;

                break;
            case 44:
                trisk3 = 56;

                break;
            case 45:
                trisk3 = 57;
                break;
            case 46:
                trisk3 = 57;
                break;
            case 47:
                trisk3 = 58;
                break;
            case 48:
                trisk3 = 58;
                break;
            case 49:
                trisk3 = 59;
                break;
            case 50:
                trisk3 = 59;
                break;
            case 51:
                trisk3 = 60;
                break;
            case 52:
                trisk3 = 60;
                break;
            case 53:
                trisk3 = 61;
                break;
            case 54:
                trisk3 = 61;
                break;
            case 55:
                trisk3 = 62;
                break;
            case 56:
                trisk3 = 62;
                break;
            case 57:
                trisk3 = 63;
                break;
            case 58:
                trisk3 = 63;
                break;
            case 59:
                trisk3 = 64;
                break;
            case 60:
                trisk3 = 64;
                break;
            case 61:
                trisk3 = 65;
                break;
            case 62:
                trisk3 = 65;
                break;
            case 63:
                trisk3 = 66;
                break;
            case 64:
                trisk3 = 66;
                break;
            case 65:
                trisk3 = 67;
                break;
            case 66:
                trisk3 = 67;
                break;
            case 67:
                trisk3 = 68;
                break;
            case 68:
                trisk3 = 68;
                break;
            case 69:
                trisk3 = 69;
                break;
            case 70:
                trisk3 = 69;
                break;
            case 71:
                trisk3 = 70;
                break;
            case 72:
                trisk3 = 70;
                break;
            case 73:
                trisk3 = 71;
                break;
            case 74:
                trisk3 = 71;
                break;
            case 75:
                trisk3 = 72;
                break;
            case 76:
                trisk3 = 72;
                break;
            case 77:
                trisk3 = 73;
                break;
            case 78:
                trisk3 = 73;
                break;
            case 79:
                trisk3 = 73;
                break;
            case 80:
                trisk3 = 74;
                break;
            case 81:
                trisk3 = 74;
                break;
            case 82:
                trisk3 = 74;
                break;
            case 83:
                trisk3 = 75;
                break;
            case 84:
                trisk3 = 76;
                break;
            case 85:
                trisk3 = 76;
                break;
            case 86:
                trisk3 = 77;
                break;
            case 87:
                trisk3 = 77;
                break;
            case 88:
                trisk3 = 78;
                break;
            case 89:
                trisk3 = 79;
                break;
            case 90:
                trisk3 = 80;
                break;


        }
    }

    private void boyTeacher12To14() {
        switch (trisk1) { // ด้าน 1 ชาย ครู
            case 0:
                trisk1 = 36;
                break;
            case 1:
                trisk1 = 37;
                break;
            case 2:
                trisk1 = 38;
                break;
            case 3:
                trisk1 = 39;
                break;
            case 4:
                trisk1 = 40;
                break;
            case 5:
                trisk1 = 41;
                break;
            case 6:
                trisk1 = 42;
                break;
            case 7:
                trisk1 = 43;
                break;
            case 8:
                trisk1 = 44;
                break;
            case 9:
                trisk1 = 44;
                break;
            case 10:
                trisk1 = 45;
                break;
            case 11:
                trisk1 = 46;
                break;
            case 12:
                trisk1 = 47;
                break;
            case 13:
                trisk1 = 48;
                break;
            case 14:
                trisk1 = 49;
                break;
            case 15:
                trisk1 = 50;
                break;
            case 16:
                trisk1 = 51;
                break;
            case 17:
                trisk1 = 52;
                break;
            case 18:
                trisk1 = 53;
                break;
            case 19:
                trisk1 = 54;
                break;
            case 20:
                trisk1 = 55;
                break;
            case 21:
                trisk1 = 55;
                break;
            case 22:
                trisk1 = 56;
                break;
            case 23:
                trisk1 = 57;
                break;
            case 24:
                trisk1 = 58;
                break;
            case 25:
                trisk1 = 59;
                break;
            case 26:
                trisk1 = 60;
                break;
            case 27:
                trisk1 = 61;
                break;
            case 28:
                trisk1 = 62;
                break;
            case 29:
                trisk1 = 63;
                break;
            case 30:
                trisk1 = 64;
                break;
            case 31:
                trisk1 = 65;
                break;
            case 32:
                trisk1 = 66;
                break;
            case 33:
                trisk1 = 66;
                break;
            case 34:
                trisk1 = 67;
                break;
            case 35:
                trisk1 = 68;
                break;
            case 36:
                trisk1 = 69;
                break;
            case 37:
                trisk1 = 70;
                break;
            case 38:
                trisk1 = 71;
                break;
            case 39:
                trisk1 = 72;
                break;
            case 40:
                trisk1 = 73;
                break;
            case 41:
                trisk1 = 74;
                break;
            case 42:
                trisk1 = 75;
                break;
            case 43:
                trisk1 = 76;
                break;
            case 44:
                trisk1 = 76;
                break;
            case 45:
                trisk1 = 77;
                break;
        }

        /**************************************************/
        switch (trisk2) { // ด้าน 2 ชาย ครู
            case 0:
                trisk2 = 34;
                break;
            case 1:
                trisk2 = 35;

                break;
            case 2:
                trisk2 = 36;
                break;
            case 3:
                trisk2 = 37;

                break;
            case 4:
                trisk2 = 38;

                break;
            case 5:
                trisk2 = 38;

                break;
            case 6:
                trisk2 = 39;

                break;
            case 7:
                trisk2 = 40;

                break;
            case 8:
                trisk2 = 41;
                break;
            case 9:
                trisk2 = 42;

                break;
            case 10:
                trisk2 = 42;

                break;
            case 11:
                trisk2 = 43;

                break;
            case 12:
                trisk2 = 44;

                break;
            case 13:
                trisk2 = 45;

                break;
            case 14:
                trisk2 = 46;

                break;
            case 15:
                trisk2 = 46;

                break;
            case 16:
                trisk2 = 47;
                break;
            case 17:
                trisk2 = 48;

                break;
            case 18:
                trisk2 = 49;

                break;
            case 19:
                trisk2 = 49;

                break;
            case 20:
                trisk2 = 50;

                break;
            case 21:
                trisk2 = 51;

                break;
            case 22:
                trisk2 = 52;

                break;
            case 23:
                trisk2 = 53;

                break;
            case 24:
                trisk2 = 53;
                break;
            case 25:
                trisk2 = 54;

                break;
            case 26:
                trisk2 = 55;

                break;
            case 27:
                trisk2 = 56;

                break;
            case 28:
                trisk2 = 57;

                break;
            case 29:
                trisk2 = 57;

                break;
            case 30:
                trisk2 = 58;

                break;
            case 31:
                trisk2 = 59;

                break;
            case 32:
                trisk2 = 60;
                break;
            case 33:
                trisk2 = 60;

                break;
            case 34:
                trisk2 = 61;

                break;
            case 35:
                trisk2 = 62;

                break;
            case 36:
                trisk2 = 63;

                break;
            case 37:
                trisk2 = 64;

                break;
            case 38:
                trisk2 = 64;

                break;
            case 39:
                trisk2 = 65;

                break;
            case 40:
                trisk2 = 66;
                break;
            case 41:
                trisk2 = 67;

                break;
            case 42:
                trisk2 = 68;

                break;
            case 43:
                trisk2 = 69;

                break;
            case 44:
                trisk2 = 70;

                break;
            case 45:
                trisk2 = 71;
                break;
        }

        /**************************************************/
        switch (trisk3) { // ด้าน 3 ชาย ครู
            case 0:
                trisk3 = 32;
                break;
            case 1:
                trisk3 = 33;

                break;
            case 2:
                trisk3 = 34;
                break;
            case 3:
                trisk3 = 35;

                break;
            case 4:
                trisk3 = 36;

                break;
            case 5:
                trisk3 = 37;

                break;
            case 6:
                trisk3 = 37;

                break;
            case 7:
                trisk3 = 37;

                break;
            case 8:
                trisk3 = 38;
                break;
            case 9:
                trisk3 = 38;

                break;
            case 10:
                trisk3 = 39;

                break;
            case 11:
                trisk3 = 39;

                break;
            case 12:
                trisk3 = 40;

                break;
            case 13:
                trisk3 = 40;

                break;
            case 14:
                trisk3 = 41;

                break;
            case 15:
                trisk3 = 41;

                break;
            case 16:
                trisk3 = 42;
                break;
            case 17:
                trisk3 = 42;

                break;
            case 18:
                trisk3 = 42;

                break;
            case 19:
                trisk3 = 43;

                break;
            case 20:
                trisk3 = 43;

                break;
            case 21:
                trisk3 = 44;

                break;
            case 22:
                trisk3 = 44;

                break;
            case 23:
                trisk3 = 45;

                break;
            case 24:
                trisk3 = 45;
                break;
            case 25:
                trisk3 = 46;

                break;
            case 26:
                trisk3 = 46;

                break;
            case 27:
                trisk3 = 47;

                break;
            case 28:
                trisk3 = 47;

                break;
            case 29:
                trisk3 = 47;

                break;
            case 30:
                trisk3 = 48;

                break;
            case 31:
                trisk3 = 48;

                break;
            case 32:
                trisk3 = 49;
                break;
            case 33:
                trisk3 = 49;

                break;
            case 34:
                trisk3 = 50;

                break;
            case 35:
                trisk3 = 50;

                break;
            case 36:
                trisk3 = 51;

                break;
            case 37:
                trisk3 = 51;

                break;
            case 38:
                trisk3 = 51;

                break;
            case 39:
                trisk3 = 52;

                break;
            case 40:
                trisk3 = 52;
                break;
            case 41:
                trisk3 = 53;

                break;
            case 42:
                trisk3 = 53;

                break;
            case 43:
                trisk3 = 54;

                break;
            case 44:
                trisk3 = 54;

                break;
            case 45:
                trisk3 = 55;
                break;
            case 46:
                trisk3 = 55;
                break;
            case 47:
                trisk3 = 56;
                break;
            case 48:
                trisk3 = 56;
                break;
            case 49:
                trisk3 = 56;
                break;
            case 50:
                trisk3 = 57;
                break;
            case 51:
                trisk3 = 57;
                break;
            case 52:
                trisk3 = 58;
                break;
            case 53:
                trisk3 = 58;
                break;
            case 54:
                trisk3 = 59;
                break;
            case 55:
                trisk3 = 59;
                break;
            case 56:
                trisk3 = 60;
                break;
            case 57:
                trisk3 = 60;
                break;
            case 58:
                trisk3 = 61;
                break;
            case 59:
                trisk3 = 61;
                break;
            case 60:
                trisk3 = 61;
                break;
            case 61:
                trisk3 = 62;
                break;
            case 62:
                trisk3 = 62;
                break;
            case 63:
                trisk3 = 63;
                break;
            case 64:
                trisk3 = 63;
                break;
            case 65:
                trisk3 = 64;
                break;
            case 66:
                trisk3 = 64;
                break;
            case 67:
                trisk3 = 65;
                break;
            case 68:
                trisk3 = 65;
                break;
            case 69:
                trisk3 = 66;
                break;
            case 70:
                trisk3 = 66;
                break;
            case 71:
                trisk3 = 66;
                break;
            case 72:
                trisk3 = 67;
                break;
            case 73:
                trisk3 = 67;
                break;
            case 74:
                trisk3 = 68;
                break;
            case 75:
                trisk3 = 68;
                break;
            case 76:
                trisk3 = 69;
                break;
            case 77:
                trisk3 = 69;
                break;
            case 78:
                trisk3 = 70;
                break;
            case 79:
                trisk3 = 70;
                break;
            case 80:
                trisk3 = 71;
                break;
            case 81:
                trisk3 = 71;
                break;
            case 82:
                trisk3 = 71;
                break;
            case 83:
                trisk3 = 72;
                break;
            case 84:
                trisk3 = 72;
                break;
            case 85:
                trisk3 = 73;
                break;
            case 86:
                trisk3 = 73;
                break;
            case 87:
                trisk3 = 74;
                break;
            case 88:
                trisk3 = 75;
                break;
            case 89:
                trisk3 = 76;
                break;
            case 90:
                trisk3 = 77;
                break;


        }
    }

    private void boyTeacher9To11() {
        switch (trisk1) { // ด้าน 1 ชาย ครู
            case 0:
                trisk1 = 35;
                break;
            case 1:
                trisk1 = 36;
                break;
            case 2:
                trisk1 = 37;
                break;
            case 3:
                trisk1 = 38;
                break;
            case 4:
                trisk1 = 39;
                break;
            case 5:
                trisk1 = 40;
                break;
            case 6:
                trisk1 = 41;
                break;
            case 7:
                trisk1 = 42;
                break;
            case 8:
                trisk1 = 43;
                break;
            case 9:
                trisk1 = 44;
                break;
            case 10:
                trisk1 = 45;
                break;
            case 11:
                trisk1 = 45;
                break;
            case 12:
                trisk1 = 46;
                break;
            case 13:
                trisk1 = 47;
                break;
            case 14:
                trisk1 = 48;
                break;
            case 15:
                trisk1 = 49;
                break;
            case 16:
                trisk1 = 50;
                break;
            case 17:
                trisk1 = 51;
                break;
            case 18:
                trisk1 = 51;
                break;
            case 19:
                trisk1 = 52;
                break;
            case 20:
                trisk1 = 53;
                break;
            case 21:
                trisk1 = 54;
                break;
            case 22:
                trisk1 = 55;
                break;
            case 23:
                trisk1 = 56;
                break;
            case 24:
                trisk1 = 57;
                break;
            case 25:
                trisk1 = 57;
                break;
            case 26:
                trisk1 = 58;
                break;
            case 27:
                trisk1 = 59;
                break;
            case 28:
                trisk1 = 60;
                break;
            case 29:
                trisk1 = 61;
                break;
            case 30:
                trisk1 = 62;
                break;
            case 31:
                trisk1 = 63;
                break;
            case 32:
                trisk1 = 63;
                break;
            case 33:
                trisk1 = 64;
                break;
            case 34:
                trisk1 = 65;
                break;
            case 35:
                trisk1 = 66;
                break;
            case 36:
                trisk1 = 67;
                break;
            case 37:
                trisk1 = 68;
                break;
            case 38:
                trisk1 = 69;
                break;
            case 39:
                trisk1 = 70;
                break;
            case 40:
                trisk1 = 70;
                break;
            case 41:
                trisk1 = 71;
                break;
            case 42:
                trisk1 = 72;
                break;
            case 43:
                trisk1 = 73;
                break;
            case 44:
                trisk1 = 74;
                break;
            case 45:
                trisk1 = 75;
                break;
        }

        /**************************************************/
        switch (trisk2) { // ด้าน 2 ชาย ครู
            case 0:
                trisk2 = 33;
                break;
            case 1:
                trisk2 = 34;

                break;
            case 2:
                trisk2 = 35;
                break;
            case 3:
                trisk2 = 36;

                break;
            case 4:
                trisk2 = 37;

                break;
            case 5:
                trisk2 = 38;

                break;
            case 6:
                trisk2 = 38;

                break;
            case 7:
                trisk2 = 39;

                break;
            case 8:
                trisk2 = 40;
                break;
            case 9:
                trisk2 = 41;

                break;
            case 10:
                trisk2 = 42;

                break;
            case 11:
                trisk2 = 42;

                break;
            case 12:
                trisk2 = 43;

                break;
            case 13:
                trisk2 = 44;

                break;
            case 14:
                trisk2 = 45;

                break;
            case 15:
                trisk2 = 45;

                break;
            case 16:
                trisk2 = 46;
                break;
            case 17:
                trisk2 = 47;

                break;
            case 18:
                trisk2 = 48;

                break;
            case 19:
                trisk2 = 48;

                break;
            case 20:
                trisk2 = 49;

                break;
            case 21:
                trisk2 = 50;

                break;
            case 22:
                trisk2 = 51;

                break;
            case 23:
                trisk2 = 51;

                break;
            case 24:
                trisk2 = 52;
                break;
            case 25:
                trisk2 = 53;

                break;
            case 26:
                trisk2 = 54;

                break;
            case 27:
                trisk2 = 55;

                break;
            case 28:
                trisk2 = 55;

                break;
            case 29:
                trisk2 = 56;

                break;
            case 30:
                trisk2 = 57;

                break;
            case 31:
                trisk2 = 58;

                break;
            case 32:
                trisk2 = 58;
                break;
            case 33:
                trisk2 = 59;

                break;
            case 34:
                trisk2 = 60;

                break;
            case 35:
                trisk2 = 61;

                break;
            case 36:
                trisk2 = 61;

                break;
            case 37:
                trisk2 = 62;

                break;
            case 38:
                trisk2 = 63;

                break;
            case 39:
                trisk2 = 64;

                break;
            case 40:
                trisk2 = 65;
                break;
            case 41:
                trisk2 = 65;

                break;
            case 42:
                trisk2 = 66;

                break;
            case 43:
                trisk2 = 67;

                break;
            case 44:
                trisk2 = 68;

                break;
            case 45:
                trisk2 = 69;
                break;
        }

        /**************************************************/
        switch (trisk3) { // ด้าน 3 ชาย ครู
            case 0:
                trisk3 = 31;
                break;
            case 1:
                trisk3 = 32;

                break;
            case 2:
                trisk3 = 33;
                break;
            case 3:
                trisk3 = 34;

                break;
            case 4:
                trisk3 = 35;

                break;
            case 5:
                trisk3 = 35;

                break;
            case 6:
                trisk3 = 36;

                break;
            case 7:
                trisk3 = 36;

                break;
            case 8:
                trisk3 = 37;
                break;
            case 9:
                trisk3 = 37;

                break;
            case 10:
                trisk3 = 38;

                break;
            case 11:
                trisk3 = 38;

                break;
            case 12:
                trisk3 = 39;

                break;
            case 13:
                trisk3 = 39;

                break;
            case 14:
                trisk3 = 40;

                break;
            case 15:
                trisk3 = 40;

                break;
            case 16:
                trisk3 = 40;
                break;
            case 17:
                trisk3 = 41;

                break;
            case 18:
                trisk3 = 41;

                break;
            case 19:
                trisk3 = 42;

                break;
            case 20:
                trisk3 = 42;

                break;
            case 21:
                trisk3 = 43;

                break;
            case 22:
                trisk3 = 43;

                break;
            case 23:
                trisk3 = 44;

                break;
            case 24:
                trisk3 = 44;
                break;
            case 25:
                trisk3 = 44;

                break;
            case 26:
                trisk3 = 45;

                break;
            case 27:
                trisk3 = 45;

                break;
            case 28:
                trisk3 = 46;

                break;
            case 29:
                trisk3 = 46;

                break;
            case 30:
                trisk3 = 47;

                break;
            case 31:
                trisk3 = 47;

                break;
            case 32:
                trisk3 = 48;
                break;
            case 33:
                trisk3 = 48;

                break;
            case 34:
                trisk3 = 48;

                break;
            case 35:
                trisk3 = 49;

                break;
            case 36:
                trisk3 = 49;

                break;
            case 37:
                trisk3 = 50;

                break;
            case 38:
                trisk3 = 50;

                break;
            case 39:
                trisk3 = 51;

                break;
            case 40:
                trisk3 = 51;
                break;
            case 41:
                trisk3 = 52;

                break;
            case 42:
                trisk3 = 52;

                break;
            case 43:
                trisk3 = 52;

                break;
            case 44:
                trisk3 = 53;

                break;
            case 45:
                trisk3 = 53;
                break;
            case 46:
                trisk3 = 54;
                break;
            case 47:
                trisk3 = 54;
                break;
            case 48:
                trisk3 = 55;
                break;
            case 49:
                trisk3 = 55;
                break;
            case 50:
                trisk3 = 56;
                break;
            case 51:
                trisk3 = 56;
                break;
            case 52:
                trisk3 = 56;
                break;
            case 53:
                trisk3 = 57;
                break;
            case 54:
                trisk3 = 57;
                break;
            case 55:
                trisk3 = 58;
                break;
            case 56:
                trisk3 = 58;
                break;
            case 57:
                trisk3 = 59;
                break;
            case 58:
                trisk3 = 59;
                break;
            case 59:
                trisk3 = 60;
                break;
            case 60:
                trisk3 = 60;
                break;
            case 61:
                trisk3 = 60;
                break;
            case 62:
                trisk3 = 61;
                break;
            case 63:
                trisk3 = 61;
                break;
            case 64:
                trisk3 = 62;
                break;
            case 65:
                trisk3 = 62;
                break;
            case 66:
                trisk3 = 63;
                break;
            case 67:
                trisk3 = 63;
                break;
            case 68:
                trisk3 = 64;
                break;
            case 69:
                trisk3 = 64;
                break;
            case 70:
                trisk3 = 64;
                break;
            case 71:
                trisk3 = 65;
                break;
            case 72:
                trisk3 = 65;
                break;
            case 73:
                trisk3 = 66;
                break;
            case 74:
                trisk3 = 66;
                break;
            case 75:
                trisk3 = 67;
                break;
            case 76:
                trisk3 = 67;
                break;
            case 77:
                trisk3 = 68;
                break;
            case 78:
                trisk3 = 68;
                break;
            case 79:
                trisk3 = 68;
                break;
            case 80:
                trisk3 = 69;
                break;
            case 81:
                trisk3 = 69;
                break;
            case 82:
                trisk3 = 70;
                break;
            case 83:
                trisk3 = 70;
                break;
            case 84:
                trisk3 = 71;
                break;
            case 85:
                trisk3 = 71;
                break;
            case 86:
                trisk3 = 72;
                break;
            case 87:
                trisk3 = 72;
                break;
            case 88:
                trisk3 = 73;
                break;
            case 89:
                trisk3 = 74;
                break;
            case 90:
                trisk3 = 75;
                break;


        }
    }

    private void boyTeacher6To8(){
        switch (trisk1) { // ด้าน 1 ชาย ครู
            case 0:
                trisk1 = 35;
                break;
            case 1:
                trisk1 = 36;
                break;
            case 2:
                trisk1 = 37;
                break;
            case 3:
                trisk1 = 38;
                break;
            case 4:
                trisk1 = 39;
                break;
            case 5:
                trisk1 = 40;
                break;
            case 6:
                trisk1 = 41;
                break;
            case 7:
                trisk1 = 41;
                break;
            case 8:
                trisk1 = 42;
                break;
            case 9:
                trisk1 = 43;
                break;
            case 10:
                trisk1 = 44;
                break;
            case 11:
                trisk1 = 45;
                break;
            case 12:
                trisk1 = 46;
                break;
            case 13:
                trisk1 = 47;
                break;
            case 14:
                trisk1 = 48;
                break;
            case 15:
                trisk1 = 49;
                break;
            case 16:
                trisk1 = 50;
                break;
            case 17:
                trisk1 = 50;
                break;
            case 18:
                trisk1 = 51;
                break;
            case 19:
                trisk1 = 52;
                break;
            case 20:
                trisk1 = 53;
                break;
            case 21:
                trisk1 = 54;
                break;
            case 22:
                trisk1 = 55;
                break;
            case 23:
                trisk1 = 56;
                break;
            case 24:
                trisk1 = 57;
                break;
            case 25:
                trisk1 = 58;
                break;
            case 26:
                trisk1 = 59;
                break;
            case 27:
                trisk1 = 59;
                break;
            case 28:
                trisk1 = 60;
                break;
            case 29:
                trisk1 = 61;
                break;
            case 30:
                trisk1 = 62;
                break;
            case 31:
                trisk1 = 63;
                break;
            case 32:
                trisk1 = 64;
                break;
            case 33:
                trisk1 = 65;
                break;
            case 34:
                trisk1 = 66;
                break;
            case 35:
                trisk1 = 67;
                break;
            case 36:
                trisk1 = 68;
                break;
            case 37:
                trisk1 = 69;
                break;
            case 38:
                trisk1 = 69;
                break;
            case 39:
                trisk1 = 70;
                break;
            case 40:
                trisk1 = 71;
                break;
            case 41:
                trisk1 = 72;
                break;
            case 42:
                trisk1 = 73;
                break;
            case 43:
                trisk1 = 74;
                break;
            case 44:
                trisk1 = 75;
                break;
            case 45:
                trisk1 = 76;
                break;
        }

        /**************************************************/
        switch (trisk2) { // ด้าน 2 ชาย ครู
            case 0:
                trisk2 = 33;
                break;
            case 1:
                trisk2 = 34;

                break;
            case 2:
                trisk2 = 35;
                break;
            case 3:
                trisk2 = 36;

                break;
            case 4:
                trisk2 = 37;

                break;
            case 5:
                trisk2 = 38;

                break;
            case 6:
                trisk2 = 39;

                break;
            case 7:
                trisk2 = 39;

                break;
            case 8:
                trisk2 = 40;
                break;
            case 9:
                trisk2 = 41;

                break;
            case 10:
                trisk2 = 42;

                break;
            case 11:
                trisk2 = 43;

                break;
            case 12:
                trisk2 = 43;

                break;
            case 13:
                trisk2 = 44;

                break;
            case 14:
                trisk2 = 45;

                break;
            case 15:
                trisk2 = 46;

                break;
            case 16:
                trisk2 = 46;
                break;
            case 17:
                trisk2 = 47;

                break;
            case 18:
                trisk2 = 48;

                break;
            case 19:
                trisk2 = 49;

                break;
            case 20:
                trisk2 = 50;

                break;
            case 21:
                trisk2 = 50;

                break;
            case 22:
                trisk2 = 51;

                break;
            case 23:
                trisk2 = 52;

                break;
            case 24:
                trisk2 = 53;
                break;
            case 25:
                trisk2 = 54;

                break;
            case 26:
                trisk2 = 54;

                break;
            case 27:
                trisk2 = 55;

                break;
            case 28:
                trisk2 = 56;

                break;
            case 29:
                trisk2 = 57;

                break;
            case 30:
                trisk2 = 57;

                break;
            case 31:
                trisk2 = 58;

                break;
            case 32:
                trisk2 = 59;
                break;
            case 33:
                trisk2 = 60;

                break;
            case 34:
                trisk2 = 61;

                break;
            case 35:
                trisk2 = 61;

                break;
            case 36:
                trisk2 = 62;

                break;
            case 37:
                trisk2 = 63;

                break;
            case 38:
                trisk2 = 64;

                break;
            case 39:
                trisk2 = 65;

                break;
            case 40:
                trisk2 = 65;
                break;
            case 41:
                trisk2 = 66;

                break;
            case 42:
                trisk2 = 67;

                break;
            case 43:
                trisk2 = 68;

                break;
            case 44:
                trisk2 = 69;

                break;
            case 45:
                trisk2 = 70;
                break;
        }

        /**************************************************/
        switch (trisk3) { // ด้าน 3 ชาย ครู
            case 0:
                trisk3 = 31;
                break;
            case 1:
                trisk3 = 32;

                break;
            case 2:
                trisk3 = 33;
                break;
            case 3:
                trisk3 = 34;

                break;
            case 4:
                trisk3 = 35;

                break;
            case 5:
                trisk3 = 35;

                break;
            case 6:
                trisk3 = 36;

                break;
            case 7:
                trisk3 = 36;

                break;
            case 8:
                trisk3 = 37;
                break;
            case 9:
                trisk3 = 37;

                break;
            case 10:
                trisk3 = 38;

                break;
            case 11:
                trisk3 = 38;

                break;
            case 12:
                trisk3 = 38;

                break;
            case 13:
                trisk3 = 39;

                break;
            case 14:
                trisk3 = 39;

                break;
            case 15:
                trisk3 = 40;

                break;
            case 16:
                trisk3 = 40;
                break;
            case 17:
                trisk3 = 41;

                break;
            case 18:
                trisk3 = 41;

                break;
            case 19:
                trisk3 = 42;

                break;
            case 20:
                trisk3 = 42;

                break;
            case 21:
                trisk3 = 43;

                break;
            case 22:
                trisk3 = 43;

                break;
            case 23:
                trisk3 = 44;

                break;
            case 24:
                trisk3 = 44;
                break;
            case 25:
                trisk3 = 44;

                break;
            case 26:
                trisk3 = 45;

                break;
            case 27:
                trisk3 = 45;

                break;
            case 28:
                trisk3 = 46;

                break;
            case 29:
                trisk3 = 46;

                break;
            case 30:
                trisk3 = 47;

                break;
            case 31:
                trisk3 = 47;

                break;
            case 32:
                trisk3 = 48;
                break;
            case 33:
                trisk3 = 48;

                break;
            case 34:
                trisk3 = 49;

                break;
            case 35:
                trisk3 = 49;

                break;
            case 36:
                trisk3 = 50;

                break;
            case 37:
                trisk3 = 50;

                break;
            case 38:
                trisk3 = 50;

                break;
            case 39:
                trisk3 = 51;

                break;
            case 40:
                trisk3 = 51;
                break;
            case 41:
                trisk3 = 52;

                break;
            case 42:
                trisk3 = 52;

                break;
            case 43:
                trisk3 = 53;

                break;
            case 44:
                trisk3 = 53;

                break;
            case 45:
                trisk3 = 54;
                break;
            case 46:
                trisk3 = 54;
                break;
            case 47:
                trisk3 = 55;
                break;
            case 48:
                trisk3 = 55;
                break;
            case 49:
                trisk3 = 56;
                break;
            case 50:
                trisk3 = 56;
                break;
            case 51:
                trisk3 = 56;
                break;
            case 52:
                trisk3 = 57;
                break;
            case 53:
                trisk3 = 57;
                break;
            case 54:
                trisk3 = 58;
                break;
            case 55:
                trisk3 = 58;
                break;
            case 56:
                trisk3 = 59;
                break;
            case 57:
                trisk3 = 59;
                break;
            case 58:
                trisk3 = 60;
                break;
            case 59:
                trisk3 = 60;
                break;
            case 60:
                trisk3 = 61;
                break;
            case 61:
                trisk3 = 61;
                break;
            case 62:
                trisk3 = 62;
                break;
            case 63:
                trisk3 = 62;
                break;
            case 64:
                trisk3 = 62;
                break;
            case 65:
                trisk3 = 63;
                break;
            case 66:
                trisk3 = 63;
                break;
            case 67:
                trisk3 = 64;
                break;
            case 68:
                trisk3 = 64;
                break;
            case 69:
                trisk3 = 65;
                break;
            case 70:
                trisk3 = 65;
                break;
            case 71:
                trisk3 = 66;
                break;
            case 72:
                trisk3 = 66;
                break;
            case 73:
                trisk3 = 67;
                break;
            case 74:
                trisk3 = 67;
                break;
            case 75:
                trisk3 = 68;
                break;
            case 76:
                trisk3 = 68;
                break;
            case 77:
                trisk3 = 68;
                break;
            case 78:
                trisk3 = 69;
                break;
            case 79:
                trisk3 = 69;
                break;
            case 80:
                trisk3 = 70;
                break;
            case 81:
                trisk3 = 70;
                break;
            case 82:
                trisk3 = 71;
                break;
            case 83:
                trisk3 = 71;
                break;
            case 84:
                trisk3 = 72;
                break;
            case 85:
                trisk3 = 72;
                break;
            case 86:
                trisk3 = 73;
                break;
            case 87:
                trisk3 = 73;
                break;
            case 88:
                trisk3 = 74;
                break;
            case 89:
                trisk3 = 75;
                break;
            case 90:
                trisk3 = 76;
                break;


        }
    }


    private void girlParent15To18() {
        switch (trisk1) { // ด้าน 1 หญิง ผู้ปกครอง
            case 0:
                trisk1 = 34;
                break;
            case 1:
                trisk1 = 35;
                break;
            case 2:
                trisk1 = 36;
                break;
            case 3:
                trisk1 = 37;
                break;
            case 4:
                trisk1 = 39;
                break;
            case 5:
                trisk1 = 40;
                break;
            case 6:
                trisk1 = 41;
                break;
            case 7:
                trisk1 = 42;
                break;
            case 8:
                trisk1 = 43;
                break;
            case 9:
                trisk1 = 45;
                break;
            case 10:
                trisk1 = 46;
                break;
            case 11:
                trisk1 = 47;
                break;
            case 12:
                trisk1 = 48;
                break;
            case 13:
                trisk1 = 49;
                break;
            case 14:
                trisk1 = 50;
                break;
            case 15:
                trisk1 = 52;
                break;
            case 16:
                trisk1 = 53;
                break;
            case 17:
                trisk1 = 54;
                break;
            case 18:
                trisk1 = 55;
                break;
            case 19:
                trisk1 = 56;
                break;
            case 20:
                trisk1 = 58;
                break;
            case 21:
                trisk1 = 59;
                break;
            case 22:
                trisk1 = 60;
                break;
            case 23:
                trisk1 = 61;
                break;
            case 24:
                trisk1 = 62;
                break;
            case 25:
                trisk1 = 64;
                break;
            case 26:
                trisk1 = 65;
                break;
            case 27:
                trisk1 = 66;
                break;
            case 28:
                trisk1 = 67;
                break;
            case 29:
                trisk1 = 68;
                break;
            case 30:
                trisk1 = 69;
                break;
            case 31:
                trisk1 = 71;
                break;
            case 32:
                trisk1 = 72;
                break;
            case 33:
                trisk1 = 73;
                break;
            case 34:
                trisk1 = 74;
                break;
            case 35:
                trisk1 = 75;
                break;
            case 36:
                trisk1 = 77;
                break;
            case 37:
                trisk1 = 78;
                break;
            case 38:
                trisk1 = 79;
                break;
            case 39:
                trisk1 = 80;
                break;
            case 40:
                trisk1 = 81;
                break;
            case 41:
                trisk1 = 82;
                break;
            case 42:
                trisk1 = 83;
                break;
            case 43:
                trisk1 = 85;
                break;
            case 44:
                trisk1 = 86;
                break;
            case 45:
                trisk1 = 87;
                break;
        }

        /**************************************************/
        switch (trisk2) { // ด้าน 2 หญิง ผู้ปกครอง
            case 0:
                trisk2 = 34;
                break;
            case 1:
                trisk2 = 36;

                break;
            case 2:
                trisk2 = 37;
                break;
            case 3:
                trisk2 = 38;

                break;
            case 4:
                trisk2 = 39;

                break;
            case 5:
                trisk2 = 40;

                break;
            case 6:
                trisk2 = 41;

                break;
            case 7:
                trisk2 = 42;

                break;
            case 8:
                trisk2 = 43;
                break;
            case 9:
                trisk2 = 44;

                break;
            case 10:
                trisk2 = 46;

                break;
            case 11:
                trisk2 = 47;

                break;
            case 12:
                trisk2 = 48;

                break;
            case 13:
                trisk2 = 49;

                break;
            case 14:
                trisk2 = 50;

                break;
            case 15:
                trisk2 = 51;

                break;
            case 16:
                trisk2 = 52;
                break;
            case 17:
                trisk2 = 53;

                break;
            case 18:
                trisk2 = 54;

                break;
            case 19:
                trisk2 = 56;

                break;
            case 20:
                trisk2 = 57;

                break;
            case 21:
                trisk2 = 58;

                break;
            case 22:
                trisk2 = 59;

                break;
            case 23:
                trisk2 = 60;

                break;
            case 24:
                trisk2 = 61;
                break;
            case 25:
                trisk2 = 62;

                break;
            case 26:
                trisk2 = 63;

                break;
            case 27:
                trisk2 = 64;

                break;
            case 28:
                trisk2 = 66;

                break;
            case 29:
                trisk2 = 67;

                break;
            case 30:
                trisk2 = 68;

                break;
            case 31:
                trisk2 = 69;

                break;
            case 32:
                trisk2 = 70;
                break;
            case 33:
                trisk2 = 71;

                break;
            case 34:
                trisk2 = 72;

                break;
            case 35:
                trisk2 = 73;

                break;
            case 36:
                trisk2 = 74;

                break;
            case 37:
                trisk2 = 76;

                break;
            case 38:
                trisk2 = 77;

                break;
            case 39:
                trisk2 = 78;

                break;
            case 40:
                trisk2 = 79;
                break;
            case 41:
                trisk2 = 80;

                break;
            case 42:
                trisk2 = 81;

                break;
            case 43:
                trisk2 = 82;

                break;
            case 44:
                trisk2 = 83;

                break;
            case 45:
                trisk2 = 84;
                break;
        }

        /**************************************************/
        switch (trisk3) { // ด้าน 3 หญิง ผู้ปกครอง
            case 0:
                trisk3 = 32;
                break;
            case 1:
                trisk3 = 33;

                break;
            case 2:
                trisk3 = 34;
                break;
            case 3:
                trisk3 = 35;

                break;
            case 4:
                trisk3 = 35;

                break;
            case 5:
                trisk3 = 36;

                break;
            case 6:
                trisk3 = 37;

                break;
            case 7:
                trisk3 = 37;

                break;
            case 8:
                trisk3 = 38;
                break;
            case 9:
                trisk3 = 39;

                break;
            case 10:
                trisk3 = 39;

                break;
            case 11:
                trisk3 = 40;

                break;
            case 12:
                trisk3 = 40;

                break;
            case 13:
                trisk3 = 41;

                break;
            case 14:
                trisk3 = 42;

                break;
            case 15:
                trisk3 = 42;

                break;
            case 16:
                trisk3 = 43;
                break;
            case 17:
                trisk3 = 43;

                break;
            case 18:
                trisk3 = 44;

                break;
            case 19:
                trisk3 = 45;

                break;
            case 20:
                trisk3 = 45;

                break;
            case 21:
                trisk3 = 46;

                break;
            case 22:
                trisk3 = 47;

                break;
            case 23:
                trisk3 = 47;

                break;
            case 24:
                trisk3 = 48;
                break;
            case 25:
                trisk3 = 48;

                break;
            case 26:
                trisk3 = 49;

                break;
            case 27:
                trisk3 = 50;

                break;
            case 28:
                trisk3 = 50;

                break;
            case 29:
                trisk3 = 51;

                break;
            case 30:
                trisk3 = 51;

                break;
            case 31:
                trisk3 = 52;

                break;
            case 32:
                trisk3 = 53;
                break;
            case 33:
                trisk3 = 53;

                break;
            case 34:
                trisk3 = 54;

                break;
            case 35:
                trisk3 = 55;

                break;
            case 36:
                trisk3 = 55;

                break;
            case 37:
                trisk3 = 56;

                break;
            case 38:
                trisk3 = 56;

                break;
            case 39:
                trisk3 = 57;

                break;
            case 40:
                trisk3 = 58;
                break;
            case 41:
                trisk3 = 58;

                break;
            case 42:
                trisk3 = 59;

                break;
            case 43:
                trisk3 = 59;

                break;
            case 44:
                trisk3 = 60;

                break;
            case 45:
                trisk3 = 61;
                break;
            case 46:
                trisk3 = 61;
                break;
            case 47:
                trisk3 = 62;
                break;
            case 48:
                trisk3 = 63;
                break;
            case 49:
                trisk3 = 63;
                break;
            case 50:
                trisk3 = 64;
                break;
            case 51:
                trisk3 = 64;
                break;
            case 52:
                trisk3 = 65;
                break;
            case 53:
                trisk3 = 66;
                break;
            case 54:
                trisk3 = 66;
                break;
            case 55:
                trisk3 = 67;
                break;
            case 56:
                trisk3 = 68;
                break;
            case 57:
                trisk3 = 68;
                break;
            case 58:
                trisk3 = 69;
                break;
            case 59:
                trisk3 = 69;
                break;
            case 60:
                trisk3 = 70;
                break;
            case 61:
                trisk3 = 71;
                break;
            case 62:
                trisk3 = 71;
                break;
            case 63:
                trisk3 = 72;
                break;
            case 64:
                trisk3 = 72;
                break;
            case 65:
                trisk3 = 73;
                break;
            case 66:
                trisk3 = 74;
                break;
            case 67:
                trisk3 = 74;
                break;
            case 68:
                trisk3 = 75;
                break;
            case 69:
                trisk3 = 76;
                break;
            case 70:
                trisk3 = 76;
                break;
            case 71:
                trisk3 = 77;
                break;
            case 72:
                trisk3 = 77;
                break;
            case 73:
                trisk3 = 78;
                break;
            case 74:
                trisk3 = 79;
                break;
            case 75:
                trisk3 = 79;
                break;
            case 76:
                trisk3 = 80;
                break;
            case 77:
                trisk3 = 80;
                break;
            case 78:
                trisk3 = 81;
                break;
            case 79:
                trisk3 = 81;
                break;
            case 80:
                trisk3 = 82;
                break;
            case 81:
                trisk3 = 83;
                break;
            case 82:
                trisk3 = 83;
                break;
            case 83:
                trisk3 = 84;
                break;
            case 84:
                trisk3 = 85;
                break;
            case 85:
                trisk3 = 85;
                break;
            case 86:
                trisk3 = 86;
                break;
            case 87:
                trisk3 = 86;
                break;
            case 88:
                trisk3 = 87;
                break;
            case 89:
                trisk3 = 88;
                break;
            case 90:
                trisk3 = 89;
                break;


        }
    }

    private void girlParent12To14() {
        switch (trisk1) { // ด้าน 1 หญิง ผู้ปกครอง
            case 0:
                trisk1 = 34;
                break;
            case 1:
                trisk1 = 35;
                break;
            case 2:
                trisk1 = 36;
                break;
            case 3:
                trisk1 = 37;
                break;
            case 4:
                trisk1 = 38;
                break;
            case 5:
                trisk1 = 39;
                break;
            case 6:
                trisk1 = 41;
                break;
            case 7:
                trisk1 = 42;
                break;
            case 8:
                trisk1 = 43;
                break;
            case 9:
                trisk1 = 44;
                break;
            case 10:
                trisk1 = 45;
                break;
            case 11:
                trisk1 = 47;
                break;
            case 12:
                trisk1 = 48;
                break;
            case 13:
                trisk1 = 49;
                break;
            case 14:
                trisk1 = 50;
                break;
            case 15:
                trisk1 = 51;
                break;
            case 16:
                trisk1 = 52;
                break;
            case 17:
                trisk1 = 54;
                break;
            case 18:
                trisk1 = 55;
                break;
            case 19:
                trisk1 = 56;
                break;
            case 20:
                trisk1 = 57;
                break;
            case 21:
                trisk1 = 58;
                break;
            case 22:
                trisk1 = 60;
                break;
            case 23:
                trisk1 = 61;
                break;
            case 24:
                trisk1 = 62;
                break;
            case 25:
                trisk1 = 63;
                break;
            case 26:
                trisk1 = 64;
                break;
            case 27:
                trisk1 = 65;
                break;
            case 28:
                trisk1 = 67;
                break;
            case 29:
                trisk1 = 68;
                break;
            case 30:
                trisk1 = 69;
                break;
            case 31:
                trisk1 = 70;
                break;
            case 32:
                trisk1 = 71;
                break;
            case 33:
                trisk1 = 73;
                break;
            case 34:
                trisk1 = 74;
                break;
            case 35:
                trisk1 = 75;
                break;
            case 36:
                trisk1 = 76;
                break;
            case 37:
                trisk1 = 77;
                break;
            case 38:
                trisk1 = 78;
                break;
            case 39:
                trisk1 = 79;
                break;
            case 40:
                trisk1 = 81;
                break;
            case 41:
                trisk1 = 82;
                break;
            case 42:
                trisk1 = 83;
                break;
            case 43:
                trisk1 = 84;
                break;
            case 44:
                trisk1 = 85;
                break;
            case 45:
                trisk1 = 86;
                break;
        }

        /**************************************************/
        switch (trisk2) { // ด้าน 2 หญิง ผู้ปกครอง
            case 0:
                trisk2 = 35;
                break;
            case 1:
                trisk2 = 36;

                break;
            case 2:
                trisk2 = 37;
                break;
            case 3:
                trisk2 = 38;

                break;
            case 4:
                trisk2 = 39;

                break;
            case 5:
                trisk2 = 40;

                break;
            case 6:
                trisk2 = 41;

                break;
            case 7:
                trisk2 = 42;

                break;
            case 8:
                trisk2 = 43;
                break;
            case 9:
                trisk2 = 44;

                break;
            case 10:
                trisk2 = 45;

                break;
            case 11:
                trisk2 = 46;

                break;
            case 12:
                trisk2 = 47;

                break;
            case 13:
                trisk2 = 48;

                break;
            case 14:
                trisk2 = 49;

                break;
            case 15:
                trisk2 = 51;

                break;
            case 16:
                trisk2 = 52;
                break;
            case 17:
                trisk2 = 53;

                break;
            case 18:
                trisk2 = 54;

                break;
            case 19:
                trisk2 = 55;

                break;
            case 20:
                trisk2 = 56;

                break;
            case 21:
                trisk2 = 57;

                break;
            case 22:
                trisk2 = 58;

                break;
            case 23:
                trisk2 = 59;

                break;
            case 24:
                trisk2 = 60;
                break;
            case 25:
                trisk2 = 61;

                break;
            case 26:
                trisk2 = 62;

                break;
            case 27:
                trisk2 = 63;

                break;
            case 28:
                trisk2 = 64;

                break;
            case 29:
                trisk2 = 65;

                break;
            case 30:
                trisk2 = 66;

                break;
            case 31:
                trisk2 = 67;

                break;
            case 32:
                trisk2 = 68;
                break;
            case 33:
                trisk2 = 69;

                break;
            case 34:
                trisk2 = 70;

                break;
            case 35:
                trisk2 = 71;

                break;
            case 36:
                trisk2 = 72;

                break;
            case 37:
                trisk2 = 73;

                break;
            case 38:
                trisk2 = 74;

                break;
            case 39:
                trisk2 = 75;

                break;
            case 40:
                trisk2 = 76;
                break;
            case 41:
                trisk2 = 77;

                break;
            case 42:
                trisk2 = 78;

                break;
            case 43:
                trisk2 = 79;

                break;
            case 44:
                trisk2 = 80;

                break;
            case 45:
                trisk2 = 81;
                break;
        }

        /**************************************************/
        switch (trisk3) { // ด้าน 3 หญิง ผู้ปกครอง
            case 0:
                trisk3 = 32;
                break;
            case 1:
                trisk3 = 33;

                break;
            case 2:
                trisk3 = 34;
                break;
            case 3:
                trisk3 = 35;

                break;
            case 4:
                trisk3 = 36;

                break;
            case 5:
                trisk3 = 36;

                break;
            case 6:
                trisk3 = 37;

                break;
            case 7:
                trisk3 = 37;

                break;
            case 8:
                trisk3 = 38;
                break;
            case 9:
                trisk3 = 38;

                break;
            case 10:
                trisk3 = 39;

                break;
            case 11:
                trisk3 = 40;

                break;
            case 12:
                trisk3 = 40;

                break;
            case 13:
                trisk3 = 41;

                break;
            case 14:
                trisk3 = 41;

                break;
            case 15:
                trisk3 = 42;

                break;
            case 16:
                trisk3 = 43;
                break;
            case 17:
                trisk3 = 43;

                break;
            case 18:
                trisk3 = 44;

                break;
            case 19:
                trisk3 = 44;

                break;
            case 20:
                trisk3 = 45;

                break;
            case 21:
                trisk3 = 46;

                break;
            case 22:
                trisk3 = 46;

                break;
            case 23:
                trisk3 = 47;

                break;
            case 24:
                trisk3 = 47;
                break;
            case 25:
                trisk3 = 48;

                break;
            case 26:
                trisk3 = 49;

                break;
            case 27:
                trisk3 = 49;

                break;
            case 28:
                trisk3 = 50;

                break;
            case 29:
                trisk3 = 50;

                break;
            case 30:
                trisk3 = 51;

                break;
            case 31:
                trisk3 = 52;

                break;
            case 32:
                trisk3 = 52;
                break;
            case 33:
                trisk3 = 53;

                break;
            case 34:
                trisk3 = 53;

                break;
            case 35:
                trisk3 = 54;

                break;
            case 36:
                trisk3 = 55;

                break;
            case 37:
                trisk3 = 55;

                break;
            case 38:
                trisk3 = 56;

                break;
            case 39:
                trisk3 = 56;

                break;
            case 40:
                trisk3 = 57;
                break;
            case 41:
                trisk3 = 57;

                break;
            case 42:
                trisk3 = 58;

                break;
            case 43:
                trisk3 = 59;

                break;
            case 44:
                trisk3 = 59;

                break;
            case 45:
                trisk3 = 60;
                break;
            case 46:
                trisk3 = 60;
                break;
            case 47:
                trisk3 = 61;
                break;
            case 48:
                trisk3 = 62;
                break;
            case 49:
                trisk3 = 62;
                break;
            case 50:
                trisk3 = 63;
                break;
            case 51:
                trisk3 = 63;
                break;
            case 52:
                trisk3 = 64;
                break;
            case 53:
                trisk3 = 65;
                break;
            case 54:
                trisk3 = 65;
                break;
            case 55:
                trisk3 = 66;
                break;
            case 56:
                trisk3 = 66;
                break;
            case 57:
                trisk3 = 67;
                break;
            case 58:
                trisk3 = 68;
                break;
            case 59:
                trisk3 = 68;
                break;
            case 60:
                trisk3 = 69;
                break;
            case 61:
                trisk3 = 69;
                break;
            case 62:
                trisk3 = 70;
                break;
            case 63:
                trisk3 = 71;
                break;
            case 64:
                trisk3 = 71;
                break;
            case 65:
                trisk3 = 72;
                break;
            case 66:
                trisk3 = 72;
                break;
            case 67:
                trisk3 = 73;
                break;
            case 68:
                trisk3 = 73;
                break;
            case 69:
                trisk3 = 74;
                break;
            case 70:
                trisk3 = 75;
                break;
            case 71:
                trisk3 = 75;
                break;
            case 72:
                trisk3 = 76;
                break;
            case 73:
                trisk3 = 76;
                break;
            case 74:
                trisk3 = 77;
                break;
            case 75:
                trisk3 = 78;
                break;
            case 76:
                trisk3 = 78;
                break;
            case 77:
                trisk3 = 79;
                break;
            case 78:
                trisk3 = 79;
                break;
            case 79:
                trisk3 = 80;
                break;
            case 80:
                trisk3 = 80;
                break;
            case 81:
                trisk3 = 81;
                break;
            case 82:
                trisk3 = 82;
                break;
            case 83:
                trisk3 = 82;
                break;
            case 84:
                trisk3 = 83;
                break;
            case 85:
                trisk3 = 83;
                break;
            case 86:
                trisk3 = 84;
                break;
            case 87:
                trisk3 = 84;
                break;
            case 88:
                trisk3 = 85;
                break;
            case 89:
                trisk3 = 86;
                break;
            case 90:
                trisk3 = 87;
                break;


        }
    }

    private void girlParent9To11() {
        switch (trisk1) { // ด้าน 1 หญิง ผู้ปกครอง
            case 0:
                trisk1 = 34;
                break;
            case 1:
                trisk1 = 35;
                break;
            case 2:
                trisk1 = 36;
                break;
            case 3:
                trisk1 = 37;
                break;
            case 4:
                trisk1 = 38;
                break;
            case 5:
                trisk1 = 39;
                break;
            case 6:
                trisk1 = 41;
                break;
            case 7:
                trisk1 = 42;
                break;
            case 8:
                trisk1 = 43;
                break;
            case 9:
                trisk1 = 44;
                break;
            case 10:
                trisk1 = 45;
                break;
            case 11:
                trisk1 = 46;
                break;
            case 12:
                trisk1 = 47;
                break;
            case 13:
                trisk1 = 49;
                break;
            case 14:
                trisk1 = 50;
                break;
            case 15:
                trisk1 = 51;
                break;
            case 16:
                trisk1 = 52;
                break;
            case 17:
                trisk1 = 53;
                break;
            case 18:
                trisk1 = 54;
                break;
            case 19:
                trisk1 = 56;
                break;
            case 20:
                trisk1 = 57;
                break;
            case 21:
                trisk1 = 58;
                break;
            case 22:
                trisk1 = 59;
                break;
            case 23:
                trisk1 = 60;
                break;
            case 24:
                trisk1 = 61;
                break;
            case 25:
                trisk1 = 62;
                break;
            case 26:
                trisk1 = 64;
                break;
            case 27:
                trisk1 = 65;
                break;
            case 28:
                trisk1 = 66;
                break;
            case 29:
                trisk1 = 67;
                break;
            case 30:
                trisk1 = 68;
                break;
            case 31:
                trisk1 = 69;
                break;
            case 32:
                trisk1 = 70;
                break;
            case 33:
                trisk1 = 72;
                break;
            case 34:
                trisk1 = 73;
                break;
            case 35:
                trisk1 = 74;
                break;
            case 36:
                trisk1 = 75;
                break;
            case 37:
                trisk1 = 76;
                break;
            case 38:
                trisk1 = 77;
                break;
            case 39:
                trisk1 = 78;
                break;
            case 40:
                trisk1 = 80;
                break;
            case 41:
                trisk1 = 81;
                break;
            case 42:
                trisk1 = 82;
                break;
            case 43:
                trisk1 = 83;
                break;
            case 44:
                trisk1 = 84;
                break;
            case 45:
                trisk1 = 85;
                break;
        }

        /**************************************************/
        switch (trisk2) { // ด้าน 2 หญิง ผู้ปกครอง
            case 0:
                trisk2 = 35;
                break;
            case 1:
                trisk2 = 36;

                break;
            case 2:
                trisk2 = 37;
                break;
            case 3:
                trisk2 = 38;

                break;
            case 4:
                trisk2 = 39;

                break;
            case 5:
                trisk2 = 40;

                break;
            case 6:
                trisk2 = 41;

                break;
            case 7:
                trisk2 = 42;

                break;
            case 8:
                trisk2 = 43;
                break;
            case 9:
                trisk2 = 44;

                break;
            case 10:
                trisk2 = 45;

                break;
            case 11:
                trisk2 = 46;

                break;
            case 12:
                trisk2 = 47;

                break;
            case 13:
                trisk2 = 48;

                break;
            case 14:
                trisk2 = 49;

                break;
            case 15:
                trisk2 = 50;

                break;
            case 16:
                trisk2 = 51;
                break;
            case 17:
                trisk2 = 52;

                break;
            case 18:
                trisk2 = 53;

                break;
            case 19:
                trisk2 = 54;

                break;
            case 20:
                trisk2 = 54;

                break;
            case 21:
                trisk2 = 55;

                break;
            case 22:
                trisk2 = 56;

                break;
            case 23:
                trisk2 = 57;

                break;
            case 24:
                trisk2 = 58;
                break;
            case 25:
                trisk2 = 59;

                break;
            case 26:
                trisk2 = 60;

                break;
            case 27:
                trisk2 = 61;

                break;
            case 28:
                trisk2 = 62;

                break;
            case 29:
                trisk2 = 63;

                break;
            case 30:
                trisk2 = 64;

                break;
            case 31:
                trisk2 = 65;

                break;
            case 32:
                trisk2 = 66;
                break;
            case 33:
                trisk2 = 67;

                break;
            case 34:
                trisk2 = 68;

                break;
            case 35:
                trisk2 = 69;

                break;
            case 36:
                trisk2 = 70;

                break;
            case 37:
                trisk2 = 71;

                break;
            case 38:
                trisk2 = 72;

                break;
            case 39:
                trisk2 = 72;

                break;
            case 40:
                trisk2 = 73;
                break;
            case 41:
                trisk2 = 74;

                break;
            case 42:
                trisk2 = 75;

                break;
            case 43:
                trisk2 = 76;

                break;
            case 44:
                trisk2 = 77;

                break;
            case 45:
                trisk2 = 78;
                break;
        }

        /**************************************************/
        switch (trisk3) { // ด้าน 3 หญิง ผู้ปกครอง
            case 0:
                trisk3 = 33;
                break;
            case 1:
                trisk3 = 34;

                break;
            case 2:
                trisk3 = 35;
                break;
            case 3:
                trisk3 = 35;

                break;
            case 4:
                trisk3 = 36;

                break;
            case 5:
                trisk3 = 36;

                break;
            case 6:
                trisk3 = 37;

                break;
            case 7:
                trisk3 = 37;

                break;
            case 8:
                trisk3 = 38;
                break;
            case 9:
                trisk3 = 38;

                break;
            case 10:
                trisk3 = 39;

                break;
            case 11:
                trisk3 = 40;

                break;
            case 12:
                trisk3 = 40;

                break;
            case 13:
                trisk3 = 41;

                break;
            case 14:
                trisk3 = 41;

                break;
            case 15:
                trisk3 = 42;

                break;
            case 16:
                trisk3 = 42;
                break;
            case 17:
                trisk3 = 43;

                break;
            case 18:
                trisk3 = 44;

                break;
            case 19:
                trisk3 = 44;

                break;
            case 20:
                trisk3 = 45;

                break;
            case 21:
                trisk3 = 45;

                break;
            case 22:
                trisk3 = 46;

                break;
            case 23:
                trisk3 = 46;

                break;
            case 24:
                trisk3 = 47;
                break;
            case 25:
                trisk3 = 47;

                break;
            case 26:
                trisk3 = 48;

                break;
            case 27:
                trisk3 = 49;

                break;
            case 28:
                trisk3 = 49;

                break;
            case 29:
                trisk3 = 50;

                break;
            case 30:
                trisk3 = 50;

                break;
            case 31:
                trisk3 = 51;

                break;
            case 32:
                trisk3 = 51;
                break;
            case 33:
                trisk3 = 52;

                break;
            case 34:
                trisk3 = 53;

                break;
            case 35:
                trisk3 = 53;

                break;
            case 36:
                trisk3 = 54;

                break;
            case 37:
                trisk3 = 54;

                break;
            case 38:
                trisk3 = 55;

                break;
            case 39:
                trisk3 = 55;

                break;
            case 40:
                trisk3 = 56;
                break;
            case 41:
                trisk3 = 56;

                break;
            case 42:
                trisk3 = 57;

                break;
            case 43:
                trisk3 = 58;

                break;
            case 44:
                trisk3 = 58;

                break;
            case 45:
                trisk3 = 59;
                break;
            case 46:
                trisk3 = 59;
                break;
            case 47:
                trisk3 = 60;
                break;
            case 48:
                trisk3 = 60;
                break;
            case 49:
                trisk3 = 61;
                break;
            case 50:
                trisk3 = 62;
                break;
            case 51:
                trisk3 = 62;
                break;
            case 52:
                trisk3 = 63;
                break;
            case 53:
                trisk3 = 63;
                break;
            case 54:
                trisk3 = 64;
                break;
            case 55:
                trisk3 = 64;
                break;
            case 56:
                trisk3 = 65;
                break;
            case 57:
                trisk3 = 65;
                break;
            case 58:
                trisk3 = 66;
                break;
            case 59:
                trisk3 = 67;
                break;
            case 60:
                trisk3 = 67;
                break;
            case 61:
                trisk3 = 68;
                break;
            case 62:
                trisk3 = 68;
                break;
            case 63:
                trisk3 = 69;
                break;
            case 64:
                trisk3 = 69;
                break;
            case 65:
                trisk3 = 70;
                break;
            case 66:
                trisk3 = 71;
                break;
            case 67:
                trisk3 = 71;
                break;
            case 68:
                trisk3 = 72;
                break;
            case 69:
                trisk3 = 72;
                break;
            case 70:
                trisk3 = 73;
                break;
            case 71:
                trisk3 = 73;
                break;
            case 72:
                trisk3 = 74;
                break;
            case 73:
                trisk3 = 74;
                break;
            case 74:
                trisk3 = 75;
                break;
            case 75:
                trisk3 = 76;
                break;
            case 76:
                trisk3 = 76;
                break;
            case 77:
                trisk3 = 77;
                break;
            case 78:
                trisk3 = 77;
                break;
            case 79:
                trisk3 = 78;
                break;
            case 80:
                trisk3 = 78;
                break;
            case 81:
                trisk3 = 79;
                break;
            case 82:
                trisk3 = 79;
                break;
            case 83:
                trisk3 = 80;
                break;
            case 84:
                trisk3 = 80;
                break;
            case 85:
                trisk3 = 81;
                break;
            case 86:
                trisk3 = 81;
                break;
            case 87:
                trisk3 = 82;
                break;
            case 88:
                trisk3 = 83;
                break;
            case 89:
                trisk3 = 84;
                break;
            case 90:
                trisk3 = 85;
                break;


        }
    }

    private void girlParent6To8()  {
        switch (trisk1) { // ด้าน 1 หญิง ผู้ปกครอง
            case 0:
                trisk1 = 32;
                break;
            case 1:
                trisk1 = 34;
                break;
            case 2:
                trisk1 = 35;
                break;
            case 3:
                trisk1 = 36;
                break;
            case 4:
                trisk1 = 37;
                break;
            case 5:
                trisk1 = 38;
                break;
            case 6:
                trisk1 = 39;
                break;
            case 7:
                trisk1 = 40;
                break;
            case 8:
                trisk1 = 41;
                break;
            case 9:
                trisk1 = 43;
                break;
            case 10:
                trisk1 = 44;
                break;
            case 11:
                trisk1 = 45;
                break;
            case 12:
                trisk1 = 46;
                break;
            case 13:
                trisk1 = 47;
                break;
            case 14:
                trisk1 = 48;
                break;
            case 15:
                trisk1 = 49;
                break;
            case 16:
                trisk1 = 51;
                break;
            case 17:
                trisk1 = 52;
                break;
            case 18:
                trisk1 = 53;
                break;
            case 19:
                trisk1 = 54;
                break;
            case 20:
                trisk1 = 55;
                break;
            case 21:
                trisk1 = 56;
                break;
            case 22:
                trisk1 = 57;
                break;
            case 23:
                trisk1 = 58;
                break;
            case 24:
                trisk1 = 60;
                break;
            case 25:
                trisk1 = 61;
                break;
            case 26:
                trisk1 = 62;
                break;
            case 27:
                trisk1 = 63;
                break;
            case 28:
                trisk1 = 64;
                break;
            case 29:
                trisk1 = 65;
                break;
            case 30:
                trisk1 = 66;
                break;
            case 31:
                trisk1 = 67;
                break;
            case 32:
                trisk1 = 69;
                break;
            case 33:
                trisk1 = 70;
                break;
            case 34:
                trisk1 = 71;
                break;
            case 35:
                trisk1 = 72;
                break;
            case 36:
                trisk1 = 73;
                break;
            case 37:
                trisk1 = 74;
                break;
            case 38:
                trisk1 = 75;
                break;
            case 39:
                trisk1 = 77;
                break;
            case 40:
                trisk1 = 78;
                break;
            case 41:
                trisk1 = 79;
                break;
            case 42:
                trisk1 = 80;
                break;
            case 43:
                trisk1 = 81;
                break;
            case 44:
                trisk1 = 82;
                break;
            case 45:
                trisk1 = 83;
                break;
        }

        /**************************************************/
        switch (trisk2) { // ด้าน 2 หญิง ผู้ปกครอง
            case 0:
                trisk2 = 34;
                break;
            case 1:
                trisk2 = 35;

                break;
            case 2:
                trisk2 = 36;
                break;
            case 3:
                trisk2 = 37;

                break;
            case 4:
                trisk2 = 38;

                break;
            case 5:
                trisk2 = 38;

                break;
            case 6:
                trisk2 = 39;

                break;
            case 7:
                trisk2 = 40;

                break;
            case 8:
                trisk2 = 41;
                break;
            case 9:
                trisk2 = 42;

                break;
            case 10:
                trisk2 = 43;

                break;
            case 11:
                trisk2 = 44;

                break;
            case 12:
                trisk2 = 45;

                break;
            case 13:
                trisk2 = 46;

                break;
            case 14:
                trisk2 = 47;

                break;
            case 15:
                trisk2 = 48;

                break;
            case 16:
                trisk2 = 49;
                break;
            case 17:
                trisk2 = 50;

                break;
            case 18:
                trisk2 = 51;

                break;
            case 19:
                trisk2 = 52;

                break;
            case 20:
                trisk2 = 53;

                break;
            case 21:
                trisk2 = 54;

                break;
            case 22:
                trisk2 = 54;

                break;
            case 23:
                trisk2 = 55;

                break;
            case 24:
                trisk2 = 56;
                break;
            case 25:
                trisk2 = 57;

                break;
            case 26:
                trisk2 = 58;

                break;
            case 27:
                trisk2 = 59;

                break;
            case 28:
                trisk2 = 60;

                break;
            case 29:
                trisk2 = 51;

                break;
            case 30:
                trisk2 = 62;

                break;
            case 31:
                trisk2 = 63;

                break;
            case 32:
                trisk2 = 64;
                break;
            case 33:
                trisk2 = 65;

                break;
            case 34:
                trisk2 = 66;

                break;
            case 35:
                trisk2 = 67;

                break;
            case 36:
                trisk2 = 68;

                break;
            case 37:
                trisk2 = 69;

                break;
            case 38:
                trisk2 = 69;

                break;
            case 39:
                trisk2 = 70;

                break;
            case 40:
                trisk2 = 71;
                break;
            case 41:
                trisk2 = 72;

                break;
            case 42:
                trisk2 = 73;

                break;
            case 43:
                trisk2 = 74;

                break;
            case 44:
                trisk2 = 75;

                break;
            case 45:
                trisk2 = 76;
                break;
        }

        /**************************************************/
        switch (trisk3) { // ด้าน 3 หญิง ผู้ปกครอง
            case 0:
                trisk3 = 31;
                break;
            case 1:
                trisk3 = 32;

                break;
            case 2:
                trisk3 = 33;
                break;
            case 3:
                trisk3 = 33;

                break;
            case 4:
                trisk3 = 34;

                break;
            case 5:
                trisk3 = 34;

                break;
            case 6:
                trisk3 = 35;

                break;
            case 7:
                trisk3 = 36;

                break;
            case 8:
                trisk3 = 36;
                break;
            case 9:
                trisk3 = 37;

                break;
            case 10:
                trisk3 = 37;

                break;
            case 11:
                trisk3 = 38;

                break;
            case 12:
                trisk3 = 38;

                break;
            case 13:
                trisk3 = 39;

                break;
            case 14:
                trisk3 = 39;

                break;
            case 15:
                trisk3 = 40;

                break;
            case 16:
                trisk3 = 41;
                break;
            case 17:
                trisk3 = 41;

                break;
            case 18:
                trisk3 = 42;

                break;
            case 19:
                trisk3 = 42;

                break;
            case 20:
                trisk3 = 43;

                break;
            case 21:
                trisk3 = 43;

                break;
            case 22:
                trisk3 = 44;

                break;
            case 23:
                trisk3 = 45;

                break;
            case 24:
                trisk3 = 45;
                break;
            case 25:
                trisk3 = 46;

                break;
            case 26:
                trisk3 = 46;

                break;
            case 27:
                trisk3 = 47;

                break;
            case 28:
                trisk3 = 47;

                break;
            case 29:
                trisk3 = 48;

                break;
            case 30:
                trisk3 = 48;

                break;
            case 31:
                trisk3 = 49;

                break;
            case 32:
                trisk3 = 50;
                break;
            case 33:
                trisk3 = 50;

                break;
            case 34:
                trisk3 = 51;

                break;
            case 35:
                trisk3 = 51;

                break;
            case 36:
                trisk3 = 52;

                break;
            case 37:
                trisk3 = 52;

                break;
            case 38:
                trisk3 = 53;

                break;
            case 39:
                trisk3 = 53;

                break;
            case 40:
                trisk3 = 54;
                break;
            case 41:
                trisk3 = 55;

                break;
            case 42:
                trisk3 = 55;

                break;
            case 43:
                trisk3 = 56;

                break;
            case 44:
                trisk3 = 56;

                break;
            case 45:
                trisk3 = 57;
                break;
            case 46:
                trisk3 = 57;
                break;
            case 47:
                trisk3 = 58;
                break;
            case 48:
                trisk3 = 59;
                break;
            case 49:
                trisk3 = 59;
                break;
            case 50:
                trisk3 = 60;
                break;
            case 51:
                trisk3 = 60;
                break;
            case 52:
                trisk3 = 61;
                break;
            case 53:
                trisk3 = 61;
                break;
            case 54:
                trisk3 = 62;
                break;
            case 55:
                trisk3 = 62;
                break;
            case 56:
                trisk3 = 63;
                break;
            case 57:
                trisk3 = 64;
                break;
            case 58:
                trisk3 = 64;
                break;
            case 59:
                trisk3 = 65;
                break;
            case 60:
                trisk3 = 65;
                break;
            case 61:
                trisk3 = 66;
                break;
            case 62:
                trisk3 = 66;
                break;
            case 63:
                trisk3 = 67;
                break;
            case 64:
                trisk3 = 67;
                break;
            case 65:
                trisk3 = 68;
                break;
            case 66:
                trisk3 = 69;
                break;
            case 67:
                trisk3 = 69;
                break;
            case 68:
                trisk3 = 70;
                break;
            case 69:
                trisk3 = 70;
                break;
            case 70:
                trisk3 = 71;
                break;
            case 71:
                trisk3 = 71;
                break;
            case 72:
                trisk3 = 72;
                break;
            case 73:
                trisk3 = 73;
                break;
            case 74:
                trisk3 = 73;
                break;
            case 75:
                trisk3 = 74;
                break;
            case 76:
                trisk3 = 74;
                break;
            case 77:
                trisk3 = 75;
                break;
            case 78:
                trisk3 = 75;
                break;
            case 79:
                trisk3 = 76;
                break;
            case 80:
                trisk3 = 76;
                break;
            case 81:
                trisk3 = 77;
                break;
            case 82:
                trisk3 = 0;
                break;
            case 83:
                trisk3 = 78;
                break;
            case 84:
                trisk3 = 79;
                break;
            case 85:
                trisk3 = 79;
                break;
            case 86:
                trisk3 = 80;
                break;
            case 87:
                trisk3 = 80;
                break;
            case 88:
                trisk3 = 81;
                break;
            case 89:
                trisk3 = 82;
                break;
            case 90:
                trisk3 = 83;
                break;


        }
    }

    private void boyParent15To18() {
        switch (trisk1) { // ด้าน 1 ชาย ผู้ปกครอง
            case 0:
                trisk1 = 33;
                break;
            case 1:
                trisk1 = 35;
                break;
            case 2:
                trisk1 = 36;
                break;
            case 3:
                trisk1 = 37;
                break;
            case 4:
                trisk1 = 38;
                break;
            case 5:
                trisk1 = 39;
                break;
            case 6:
                trisk1 = 40;
                break;
            case 7:
                trisk1 = 42;
                break;
            case 8:
                trisk1 = 43;
                break;
            case 9:
                trisk1 = 44;
                break;
            case 10:
                trisk1 = 45;
                break;
            case 11:
                trisk1 = 46;
                break;
            case 12:
                trisk1 = 47;
                break;
            case 13:
                trisk1 = 49;
                break;
            case 14:
                trisk1 = 50;
                break;
            case 15:
                trisk1 = 51;
                break;
            case 16:
                trisk1 = 52;
                break;
            case 17:
                trisk1 = 53;
                break;
            case 18:
                trisk1 = 54;
                break;
            case 19:
                trisk1 = 56;
                break;
            case 20:
                trisk1 = 57;
                break;
            case 21:
                trisk1 = 58;
                break;
            case 22:
                trisk1 = 59;
                break;
            case 23:
                trisk1 = 60;
                break;
            case 24:
                trisk1 = 62;
                break;
            case 25:
                trisk1 = 63;
                break;
            case 26:
                trisk1 = 64;
                break;
            case 27:
                trisk1 = 65;
                break;
            case 28:
                trisk1 = 66;
                break;
            case 29:
                trisk1 = 67;
                break;
            case 30:
                trisk1 = 69;
                break;
            case 31:
                trisk1 = 70;
                break;
            case 32:
                trisk1 = 71;
                break;
            case 33:
                trisk1 = 72;
                break;
            case 34:
                trisk1 = 73;
                break;
            case 35:
                trisk1 = 74;
                break;
            case 36:
                trisk1 = 76;
                break;
            case 37:
                trisk1 = 77;
                break;
            case 38:
                trisk1 = 78;
                break;
            case 39:
                trisk1 = 79;
                break;
            case 40:
                trisk1 = 80;
                break;
            case 41:
                trisk1 = 72;
                break;
            case 42:
                trisk1 = 83;
                break;
            case 43:
                trisk1 = 84;
                break;
            case 44:
                trisk1 = 85;
                break;
            case 45:
                trisk1 = 86;
                break;
        }

        /**************************************************/
        switch (trisk2) { // ด้าน 2 ชาย ผู้ปกครอง
            case 0:
                trisk2 = 33;
                break;
            case 1:
                trisk2 = 34;

                break;
            case 2:
                trisk2 = 35;
                break;
            case 3:
                trisk2 = 36;

                break;
            case 4:
                trisk2 = 37;

                break;
            case 5:
                trisk2 = 38;

                break;
            case 6:
                trisk2 = 39;

                break;
            case 7:
                trisk2 = 40;

                break;
            case 8:
                trisk2 = 41;
                break;
            case 9:
                trisk2 = 42;

                break;
            case 10:
                trisk2 = 43;

                break;
            case 11:
                trisk2 = 44;

                break;
            case 12:
                trisk2 = 45;

                break;
            case 13:
                trisk2 = 47;

                break;
            case 14:
                trisk2 = 48;

                break;
            case 15:
                trisk2 = 49;

                break;
            case 16:
                trisk2 = 50;
                break;
            case 17:
                trisk2 = 51;

                break;
            case 18:
                trisk2 = 52;

                break;
            case 19:
                trisk2 = 53;

                break;
            case 20:
                trisk2 = 54;

                break;
            case 21:
                trisk2 = 55;

                break;
            case 22:
                trisk2 = 56;

                break;
            case 23:
                trisk2 = 57;

                break;
            case 24:
                trisk2 = 58;
                break;
            case 25:
                trisk2 = 59;

                break;
            case 26:
                trisk2 = 60;

                break;
            case 27:
                trisk2 = 61;

                break;
            case 28:
                trisk2 = 62;

                break;
            case 29:
                trisk2 = 64;

                break;
            case 30:
                trisk2 = 65;

                break;
            case 31:
                trisk2 = 66;

                break;
            case 32:
                trisk2 = 67;
                break;
            case 33:
                trisk2 = 68;

                break;
            case 34:
                trisk2 = 69;

                break;
            case 35:
                trisk2 = 70;

                break;
            case 36:
                trisk2 = 71;

                break;
            case 37:
                trisk2 = 72;

                break;
            case 38:
                trisk2 = 73;

                break;
            case 39:
                trisk2 = 74;

                break;
            case 40:
                trisk2 = 75;
                break;
            case 41:
                trisk2 = 76;

                break;
            case 42:
                trisk2 = 77;

                break;
            case 43:
                trisk2 = 78;

                break;
            case 44:
                trisk2 = 79;

                break;
            case 45:
                trisk2 = 80;
                break;
        }

        /**************************************************/
        switch (trisk3) { // ด้าน 3 ชาย ผู้ปกครอง
            case 0:
                trisk3 = 30;
                break;
            case 1:
                trisk3 = 31;

                break;
            case 2:
                trisk3 = 32;
                break;
            case 3:
                trisk3 = 33;

                break;
            case 4:
                trisk3 = 34;

                break;
            case 5:
                trisk3 = 35;

                break;
            case 6:
                trisk3 = 35;

                break;
            case 7:
                trisk3 = 36;

                break;
            case 8:
                trisk3 = 37;
                break;
            case 9:
                trisk3 = 37;

                break;
            case 10:
                trisk3 = 38;

                break;
            case 11:
                trisk3 = 38;

                break;
            case 12:
                trisk3 = 39;

                break;
            case 13:
                trisk3 = 40;

                break;
            case 14:
                trisk3 = 40;

                break;
            case 15:
                trisk3 = 41;

                break;
            case 16:
                trisk3 = 41;
                break;
            case 17:
                trisk3 = 42;

                break;
            case 18:
                trisk3 = 43;

                break;
            case 19:
                trisk3 = 43;

                break;
            case 20:
                trisk3 = 44;

                break;
            case 21:
                trisk3 = 44;

                break;
            case 22:
                trisk3 = 45;

                break;
            case 23:
                trisk3 = 46;

                break;
            case 24:
                trisk3 = 46;
                break;
            case 25:
                trisk3 = 47;

                break;
            case 26:
                trisk3 = 47;

                break;
            case 27:
                trisk3 = 48;

                break;
            case 28:
                trisk3 = 49;

                break;
            case 29:
                trisk3 = 49;

                break;
            case 30:
                trisk3 = 50;

                break;
            case 31:
                trisk3 = 50;

                break;
            case 32:
                trisk3 = 51;
                break;
            case 33:
                trisk3 = 52;

                break;
            case 34:
                trisk3 = 52;

                break;
            case 35:
                trisk3 = 53;

                break;
            case 36:
                trisk3 = 53;

                break;
            case 37:
                trisk3 = 54;

                break;
            case 38:
                trisk3 = 55;

                break;
            case 39:
                trisk3 = 55;

                break;
            case 40:
                trisk3 = 56;
                break;
            case 41:
                trisk3 = 56;

                break;
            case 42:
                trisk3 = 57;

                break;
            case 43:
                trisk3 = 57;

                break;
            case 44:
                trisk3 = 58;

                break;
            case 45:
                trisk3 = 59;
                break;
            case 46:
                trisk3 = 59;
                break;
            case 47:
                trisk3 = 60;
                break;
            case 48:
                trisk3 = 60;
                break;
            case 49:
                trisk3 = 61;
                break;
            case 50:
                trisk3 = 62;
                break;
            case 51:
                trisk3 = 62;
                break;
            case 52:
                trisk3 = 63;
                break;
            case 53:
                trisk3 = 63;
                break;
            case 54:
                trisk3 = 64;
                break;
            case 55:
                trisk3 = 65;
                break;
            case 56:
                trisk3 = 65;
                break;
            case 57:
                trisk3 = 66;
                break;
            case 58:
                trisk3 = 66;
                break;
            case 59:
                trisk3 = 67;
                break;
            case 60:
                trisk3 = 68;
                break;
            case 61:
                trisk3 = 68;
                break;
            case 62:
                trisk3 = 69;
                break;
            case 63:
                trisk3 = 69;
                break;
            case 64:
                trisk3 = 70;
                break;
            case 65:
                trisk3 = 71;
                break;
            case 66:
                trisk3 = 71;
                break;
            case 67:
                trisk3 = 72;
                break;
            case 68:
                trisk3 = 72;
                break;
            case 69:
                trisk3 = 73;
                break;
            case 70:
                trisk3 = 74;
                break;
            case 71:
                trisk3 = 74;
                break;
            case 72:
                trisk3 = 75;
                break;
            case 73:
                trisk3 = 75;
                break;
            case 74:
                trisk3 = 76;
                break;
            case 75:
                trisk3 = 77;
                break;
            case 76:
                trisk3 = 77;
                break;
            case 77:
                trisk3 = 78;
                break;
            case 78:
                trisk3 = 78;
                break;
            case 79:
                trisk3 = 79;
                break;
            case 80:
                trisk3 = 79;
                break;
            case 81:
                trisk3 = 80;
                break;
            case 82:
                trisk3 = 81;
                break;
            case 83:
                trisk3 = 81;
                break;
            case 84:
                trisk3 = 82;
                break;
            case 85:
                trisk3 = 82;
                break;
            case 86:
                trisk3 = 83;
                break;
            case 87:
                trisk3 = 83;
                break;
            case 88:
                trisk3 = 84;
                break;
            case 89:
                trisk3 = 85;
                break;
            case 90:
                trisk3 = 86;
                break;


        }
    }

    private void boyParent12To14() {
        switch (trisk1) { // ด้าน 1 ชาย ผู้ปกครอง
            case 0:
                trisk1 = 33;
                break;
            case 1:
                trisk1 = 34;
                break;
            case 2:
                trisk1 = 35;
                break;
            case 3:
                trisk1 = 36;
                break;
            case 4:
                trisk1 = 37;
                break;
            case 5:
                trisk1 = 38;
                break;
            case 6:
                trisk1 = 39;
                break;
            case 7:
                trisk1 = 40;
                break;
            case 8:
                trisk1 = 41;
                break;
            case 9:
                trisk1 = 42;
                break;
            case 10:
                trisk1 = 43;
                break;
            case 11:
                trisk1 = 44;
                break;
            case 12:
                trisk1 = 46;
                break;
            case 13:
                trisk1 = 47;
                break;
            case 14:
                trisk1 = 48;
                break;
            case 15:
                trisk1 = 49;
                break;
            case 16:
                trisk1 = 50;
                break;
            case 17:
                trisk1 = 51;
                break;
            case 18:
                trisk1 = 52;
                break;
            case 19:
                trisk1 = 53;
                break;
            case 20:
                trisk1 = 54;
                break;
            case 21:
                trisk1 = 55;
                break;
            case 22:
                trisk1 = 56;
                break;
            case 23:
                trisk1 = 57;
                break;
            case 24:
                trisk1 = 58;
                break;
            case 25:
                trisk1 = 60;
                break;
            case 26:
                trisk1 = 61;
                break;
            case 27:
                trisk1 = 62;
                break;
            case 28:
                trisk1 = 63;
                break;
            case 29:
                trisk1 = 64;
                break;
            case 30:
                trisk1 = 65;
                break;
            case 31:
                trisk1 = 66;
                break;
            case 32:
                trisk1 = 67;
                break;
            case 33:
                trisk1 = 68;
                break;
            case 34:
                trisk1 = 69;
                break;
            case 35:
                trisk1 = 70;
                break;
            case 36:
                trisk1 = 71;
                break;
            case 37:
                trisk1 = 73;
                break;
            case 38:
                trisk1 = 74;
                break;
            case 39:
                trisk1 = 75;
                break;
            case 40:
                trisk1 = 76;
                break;
            case 41:
                trisk1 = 77;
                break;
            case 42:
                trisk1 = 78;
                break;
            case 43:
                trisk1 = 79;
                break;
            case 44:
                trisk1 = 80;
                break;
            case 45:
                trisk1 = 81;
                break;
        }

        /**************************************************/
        switch (trisk2) { // ด้าน 2 ชาย ผู้ปกครอง
            case 0:
                trisk2 = 32;
                break;
            case 1:
                trisk2 = 33;

                break;
            case 2:
                trisk2 = 34;
                break;
            case 3:
                trisk2 = 35;

                break;
            case 4:
                trisk2 = 36;

                break;
            case 5:
                trisk2 = 37;

                break;
            case 6:
                trisk2 = 38;

                break;
            case 7:
                trisk2 = 39;

                break;
            case 8:
                trisk2 = 40;
                break;
            case 9:
                trisk2 = 41;

                break;
            case 10:
                trisk2 = 42;

                break;
            case 11:
                trisk2 = 43;

                break;
            case 12:
                trisk2 = 44;

                break;
            case 13:
                trisk2 = 45;

                break;
            case 14:
                trisk2 = 46;

                break;
            case 15:
                trisk2 = 47;

                break;
            case 16:
                trisk2 = 48;
                break;
            case 17:
                trisk2 = 49;

                break;
            case 18:
                trisk2 = 50;

                break;
            case 19:
                trisk2 = 51;

                break;
            case 20:
                trisk2 = 52;

                break;
            case 21:
                trisk2 = 53;

                break;
            case 22:
                trisk2 = 53;

                break;
            case 23:
                trisk2 = 54;

                break;
            case 24:
                trisk2 = 55;
                break;
            case 25:
                trisk2 = 56;

                break;
            case 26:
                trisk2 = 57;

                break;
            case 27:
                trisk2 = 58;

                break;
            case 28:
                trisk2 = 59;

                break;
            case 29:
                trisk2 = 60;

                break;
            case 30:
                trisk2 = 61;

                break;
            case 31:
                trisk2 = 62;

                break;
            case 32:
                trisk2 = 63;
                break;
            case 33:
                trisk2 = 64;

                break;
            case 34:
                trisk2 = 65;

                break;
            case 35:
                trisk2 = 66;

                break;
            case 36:
                trisk2 = 66;

                break;
            case 37:
                trisk2 = 67;

                break;
            case 38:
                trisk2 = 68;

                break;
            case 39:
                trisk2 = 69;

                break;
            case 40:
                trisk2 = 70;
                break;
            case 41:
                trisk2 = 71;

                break;
            case 42:
                trisk2 = 72;

                break;
            case 43:
                trisk2 = 73;

                break;
            case 44:
                trisk2 = 74;

                break;
            case 45:
                trisk2 = 75;
                break;
        }

        /**************************************************/
        switch (trisk3) { // ด้าน 3 ชาย ผู้ปกครอง
            case 0:
                trisk3 = 30;
                break;
            case 1:
                trisk3 = 31;

                break;
            case 2:
                trisk3 = 32;
                break;
            case 3:
                trisk3 = 33;

                break;
            case 4:
                trisk3 = 34;

                break;
            case 5:
                trisk3 = 34;

                break;
            case 6:
                trisk3 = 35;

                break;
            case 7:
                trisk3 = 35;

                break;
            case 8:
                trisk3 = 36;
                break;
            case 9:
                trisk3 = 36;

                break;
            case 10:
                trisk3 = 37;

                break;
            case 11:
                trisk3 = 37;

                break;
            case 12:
                trisk3 = 38;

                break;
            case 13:
                trisk3 = 38;

                break;
            case 14:
                trisk3 = 39;

                break;
            case 15:
                trisk3 = 40;

                break;
            case 16:
                trisk3 = 40;
                break;
            case 17:
                trisk3 = 41;

                break;
            case 18:
                trisk3 = 41;

                break;
            case 19:
                trisk3 = 42;

                break;
            case 20:
                trisk3 = 42;

                break;
            case 21:
                trisk3 = 43;

                break;
            case 22:
                trisk3 = 43;

                break;
            case 23:
                trisk3 = 44;

                break;
            case 24:
                trisk3 = 44;
                break;
            case 25:
                trisk3 = 45;

                break;
            case 26:
                trisk3 = 45;

                break;
            case 27:
                trisk3 = 46;

                break;
            case 28:
                trisk3 = 47;

                break;
            case 29:
                trisk3 = 47;

                break;
            case 30:
                trisk3 = 48;

                break;
            case 31:
                trisk3 = 48;

                break;
            case 32:
                trisk3 = 49;
                break;
            case 33:
                trisk3 = 49;

                break;
            case 34:
                trisk3 = 50;

                break;
            case 35:
                trisk3 = 50;

                break;
            case 36:
                trisk3 = 51;

                break;
            case 37:
                trisk3 = 51;

                break;
            case 38:
                trisk3 = 52;

                break;
            case 39:
                trisk3 = 52;

                break;
            case 40:
                trisk3 = 53;
                break;
            case 41:
                trisk3 = 54;

                break;
            case 42:
                trisk3 = 54;

                break;
            case 43:
                trisk3 = 55;

                break;
            case 44:
                trisk3 = 55;

                break;
            case 45:
                trisk3 = 56;
                break;
            case 46:
                trisk3 = 56;
                break;
            case 47:
                trisk3 = 57;
                break;
            case 48:
                trisk3 = 57;
                break;
            case 49:
                trisk3 = 58;
                break;
            case 50:
                trisk3 = 58;
                break;
            case 51:
                trisk3 = 59;
                break;
            case 52:
                trisk3 = 59;
                break;
            case 53:
                trisk3 = 60;
                break;
            case 54:
                trisk3 = 61;
                break;
            case 55:
                trisk3 = 61;
                break;
            case 56:
                trisk3 = 62;
                break;
            case 57:
                trisk3 = 62;
                break;
            case 58:
                trisk3 = 63;
                break;
            case 59:
                trisk3 = 63;
                break;
            case 60:
                trisk3 = 64;
                break;
            case 61:
                trisk3 = 64;
                break;
            case 62:
                trisk3 = 65;
                break;
            case 63:
                trisk3 = 65;
                break;
            case 64:
                trisk3 = 66;
                break;
            case 65:
                trisk3 = 66;
                break;
            case 66:
                trisk3 = 67;
                break;
            case 67:
                trisk3 = 68;
                break;
            case 68:
                trisk3 = 68;
                break;
            case 69:
                trisk3 = 69;
                break;
            case 70:
                trisk3 = 69;
                break;
            case 71:
                trisk3 = 70;
                break;
            case 72:
                trisk3 = 70;
                break;
            case 73:
                trisk3 = 71;
                break;
            case 74:
                trisk3 = 71;
                break;
            case 75:
                trisk3 = 72;
                break;
            case 76:
                trisk3 = 72;
                break;
            case 77:
                trisk3 = 73;
                break;
            case 78:
                trisk3 = 73;
                break;
            case 79:
                trisk3 = 74;
                break;
            case 80:
                trisk3 = 74;
                break;
            case 81:
                trisk3 = 75;
                break;
            case 82:
                trisk3 = 76;
                break;
            case 83:
                trisk3 = 76;
                break;
            case 84:
                trisk3 = 77;
                break;
            case 85:
                trisk3 = 77;
                break;
            case 86:
                trisk3 = 78;
                break;
            case 87:
                trisk3 = 78;
                break;
            case 88:
                trisk3 = 79;
                break;
            case 89:
                trisk3 = 80;
                break;
            case 90:
                trisk3 = 81;
                break;


        }
    }

    private void boyParent9To11(){
        switch (trisk1) { // ด้าน 1 ชาย ผู้ปกครอง
            case 0:
                trisk1 = 31;
                break;
            case 1:
                trisk1 = 32;
                break;
            case 2:
                trisk1 = 33;
                break;
            case 3:
                trisk1 = 34;
                break;
            case 4:
                trisk1 = 35;
                break;
            case 5:
                trisk1 = 36;
                break;
            case 6:
                trisk1 = 37;
                break;
            case 7:
                trisk1 = 38;
                break;
            case 8:
                trisk1 = 39;
                break;
            case 9:
                trisk1 = 40;
                break;
            case 10:
                trisk1 = 41;
                break;
            case 11:
                trisk1 = 43;
                break;
            case 12:
                trisk1 = 44;
                break;
            case 13:
                trisk1 = 45;
                break;
            case 14:
                trisk1 = 46;
                break;
            case 15:
                trisk1 = 47;
                break;
            case 16:
                trisk1 = 48;
                break;
            case 17:
                trisk1 = 49;
                break;
            case 18:
                trisk1 = 50;
                break;
            case 19:
                trisk1 = 51;
                break;
            case 20:
                trisk1 = 52;
                break;
            case 21:
                trisk1 = 53;
                break;
            case 22:
                trisk1 = 54;
                break;
            case 23:
                trisk1 = 55;
                break;
            case 24:
                trisk1 = 57;
                break;
            case 25:
                trisk1 = 58;
                break;
            case 26:
                trisk1 = 59;
                break;
            case 27:
                trisk1 = 60;
                break;
            case 28:
                trisk1 = 61;
                break;
            case 29:
                trisk1 = 62;
                break;
            case 30:
                trisk1 = 63;
                break;
            case 31:
                trisk1 = 64;
                break;
            case 32:
                trisk1 = 65;
                break;
            case 33:
                trisk1 = 66;
                break;
            case 34:
                trisk1 = 67;
                break;
            case 35:
                trisk1 = 68;
                break;
            case 36:
                trisk1 = 70;
                break;
            case 37:
                trisk1 = 71;
                break;
            case 38:
                trisk1 = 72;
                break;
            case 39:
                trisk1 = 73;
                break;
            case 40:
                trisk1 = 74;
                break;
            case 41:
                trisk1 = 75;
                break;
            case 42:
                trisk1 = 76;
                break;
            case 43:
                trisk1 = 77;
                break;
            case 44:
                trisk1 = 78;
                break;
            case 45:
                trisk1 = 79;
                break;
        }

        /**************************************************/
        switch (trisk2) { // ด้าน 2 ชาย ผู้ปกครอง
            case 0:
                trisk2 = 30;
                break;
            case 1:
                trisk2 = 31;

                break;
            case 2:
                trisk2 = 32;
                break;
            case 3:
                trisk2 = 33;

                break;
            case 4:
                trisk2 = 34;

                break;
            case 5:
                trisk2 = 35;

                break;
            case 6:
                trisk2 = 36;

                break;
            case 7:
                trisk2 = 37;

                break;
            case 8:
                trisk2 = 38;
                break;
            case 9:
                trisk2 = 39;

                break;
            case 10:
                trisk2 = 40;

                break;
            case 11:
                trisk2 = 41;

                break;
            case 12:
                trisk2 = 42;

                break;
            case 13:
                trisk2 = 43;

                break;
            case 14:
                trisk2 = 44;

                break;
            case 15:
                trisk2 = 44;

                break;
            case 16:
                trisk2 = 45;
                break;
            case 17:
                trisk2 = 46;

                break;
            case 18:
                trisk2 = 47;

                break;
            case 19:
                trisk2 = 48;

                break;
            case 20:
                trisk2 = 49;

                break;
            case 21:
                trisk2 = 50;

                break;
            case 22:
                trisk2 = 51;

                break;
            case 23:
                trisk2 = 52;

                break;
            case 24:
                trisk2 = 53;
                break;
            case 25:
                trisk2 = 53;

                break;
            case 26:
                trisk2 = 54;

                break;
            case 27:
                trisk2 = 55;

                break;
            case 28:
                trisk2 = 56;

                break;
            case 29:
                trisk2 = 57;

                break;
            case 30:
                trisk2 = 58;

                break;
            case 31:
                trisk2 = 59;

                break;
            case 32:
                trisk2 = 60;
                break;
            case 33:
                trisk2 = 61;

                break;
            case 34:
                trisk2 = 62;

                break;
            case 35:
                trisk2 = 62;

                break;
            case 36:
                trisk2 = 63;

                break;
            case 37:
                trisk2 = 64;

                break;
            case 38:
                trisk2 = 65;

                break;
            case 39:
                trisk2 = 66;

                break;
            case 40:
                trisk2 = 67;
                break;
            case 41:
                trisk2 = 68;

                break;
            case 42:
                trisk2 = 69;

                break;
            case 43:
                trisk2 = 70;

                break;
            case 44:
                trisk2 = 71;

                break;
            case 45:
                trisk2 = 72;
                break;
        }

        /**************************************************/
        switch (trisk3) { // ด้าน 3 ชาย ผู้ปกครอง
            case 0:
                trisk3 = 28;
                break;
            case 1:
                trisk3 = 29;

                break;
            case 2:
                trisk3 = 30;
                break;
            case 3:
                trisk3 = 31;

                break;
            case 4:
                trisk3 = 31;

                break;
            case 5:
                trisk3 = 32;

                break;
            case 6:
                trisk3 = 32;

                break;
            case 7:
                trisk3 = 33;

                break;
            case 8:
                trisk3 = 33;
                break;
            case 9:
                trisk3 = 34;

                break;
            case 10:
                trisk3 = 35;

                break;
            case 11:
                trisk3 = 35;

                break;
            case 12:
                trisk3 = 36;

                break;
            case 13:
                trisk3 = 36;

                break;
            case 14:
                trisk3 = 37;

                break;
            case 15:
                trisk3 = 37;

                break;
            case 16:
                trisk3 = 38;
                break;
            case 17:
                trisk3 = 38;

                break;
            case 18:
                trisk3 = 39;

                break;
            case 19:
                trisk3 = 39;

                break;
            case 20:
                trisk3 = 40;

                break;
            case 21:
                trisk3 = 40;

                break;
            case 22:
                trisk3 = 41;

                break;
            case 23:
                trisk3 = 41;

                break;
            case 24:
                trisk3 = 42;
                break;
            case 25:
                trisk3 = 43;

                break;
            case 26:
                trisk3 = 43;

                break;
            case 27:
                trisk3 = 44;

                break;
            case 28:
                trisk3 = 44;

                break;
            case 29:
                trisk3 = 45;

                break;
            case 30:
                trisk3 = 45;

                break;
            case 31:
                trisk3 = 46;

                break;
            case 32:
                trisk3 = 46;
                break;
            case 33:
                trisk3 = 47;

                break;
            case 34:
                trisk3 = 47;

                break;
            case 35:
                trisk3 = 48;

                break;
            case 36:
                trisk3 = 48;

                break;
            case 37:
                trisk3 = 49;

                break;
            case 38:
                trisk3 = 49;

                break;
            case 39:
                trisk3 = 50;

                break;
            case 40:
                trisk3 = 50;
                break;
            case 41:
                trisk3 = 51;

                break;
            case 42:
                trisk3 = 52;

                break;
            case 43:
                trisk3 = 52;

                break;
            case 44:
                trisk3 = 53;

                break;
            case 45:
                trisk3 = 53;
                break;
            case 46:
                trisk3 = 54;
                break;
            case 47:
                trisk3 = 54;
                break;
            case 48:
                trisk3 = 55;
                break;
            case 49:
                trisk3 = 55;
                break;
            case 50:
                trisk3 = 56;
                break;
            case 51:
                trisk3 = 56;
                break;
            case 52:
                trisk3 = 57;
                break;
            case 53:
                trisk3 = 57;
                break;
            case 54:
                trisk3 = 58;
                break;
            case 55:
                trisk3 = 58;
                break;
            case 56:
                trisk3 = 59;
                break;
            case 57:
                trisk3 = 60;
                break;
            case 58:
                trisk3 = 60;
                break;
            case 59:
                trisk3 = 61;
                break;
            case 60:
                trisk3 = 61;
                break;
            case 61:
                trisk3 = 62;
                break;
            case 62:
                trisk3 = 62;
                break;
            case 63:
                trisk3 = 63;
                break;
            case 64:
                trisk3 = 63;
                break;
            case 65:
                trisk3 = 64;
                break;
            case 66:
                trisk3 = 65;
                break;
            case 67:
                trisk3 = 65;
                break;
            case 68:
                trisk3 = 65;
                break;
            case 69:
                trisk3 = 66;
                break;
            case 70:
                trisk3 = 66;
                break;
            case 71:
                trisk3 = 67;
                break;
            case 72:
                trisk3 = 67;
                break;
            case 73:
                trisk3 = 68;
                break;
            case 74:
                trisk3 = 69;
                break;
            case 75:
                trisk3 = 69;
                break;
            case 76:
                trisk3 = 70;
                break;
            case 77:
                trisk3 = 70;
                break;
            case 78:
                trisk3 = 71;
                break;
            case 79:
                trisk3 = 71;
                break;
            case 80:
                trisk3 = 72;
                break;
            case 81:
                trisk3 = 72;
                break;
            case 82:
                trisk3 = 73;
                break;
            case 83:
                trisk3 = 73;
                break;
            case 84:
                trisk3 = 74;
                break;
            case 85:
                trisk3 = 74;
                break;
            case 86:
                trisk3 = 75;
                break;
            case 87:
                trisk3 = 75;
                break;
            case 88:
                trisk3 = 76;
                break;
            case 89:
                trisk3 = 77;
                break;
            case 90:
                trisk3 = 78;
                break;


        }
    }

    private void boyParent6To8() {
        switch (trisk1) { // ด้าน 1 ชาย ผู้ปกครอง
            case 0:
                trisk1 = 30;
                break;
            case 1:
                trisk1 = 31;
                break;
            case 2:
                trisk1 = 32;
                break;
            case 3:
                trisk1 = 33;
                break;
            case 4:
                trisk1 = 34;
                break;
            case 5:
                trisk1 = 35;
                break;
            case 6:
                trisk1 = 36;
                break;
            case 7:
                trisk1 = 37;
                break;
            case 8:
                trisk1 = 38;
                break;
            case 9:
                trisk1 = 39;
                break;
            case 10:
                trisk1 = 40;
                break;
            case 11:
                trisk1 = 41;
                break;
            case 12:
                trisk1 = 42;
                break;
            case 13:
                trisk1 = 44;
                break;
            case 14:
                trisk1 = 45;
                break;
            case 15:
                trisk1 = 46;
                break;
            case 16:
                trisk1 = 47;
                break;
            case 17:
                trisk1 = 48;
                break;
            case 18:
                trisk1 = 49;
                break;
            case 19:
                trisk1 = 50;
                break;
            case 20:
                trisk1 = 51;
                break;
            case 21:
                trisk1 = 52;
                break;
            case 22:
                trisk1 = 53;
                break;
            case 23:
                trisk1 = 54;
                break;
            case 24:
                trisk1 = 55;
                break;
            case 25:
                trisk1 = 57;
                break;
            case 26:
                trisk1 = 58;
                break;
            case 27:
                trisk1 = 59;
                break;
            case 28:
                trisk1 = 60;
                break;
            case 29:
                trisk1 = 61;
                break;
            case 30:
                trisk1 = 62;
                break;
            case 31:
                trisk1 = 63;
                break;
            case 32:
                trisk1 = 64;
                break;
            case 33:
                trisk1 = 65;
                break;
            case 34:
                trisk1 = 66;
                break;
            case 35:
                trisk1 = 67;
                break;
            case 36:
                trisk1 = 68;
                break;
            case 37:
                trisk1 = 69;
                break;
            case 38:
                trisk1 = 71;
                break;
            case 39:
                trisk1 = 72;
                break;
            case 40:
                trisk1 = 73;
                break;
            case 41:
                trisk1 = 74;
                break;
            case 42:
                trisk1 = 75;
                break;
            case 43:
                trisk1 = 76;
                break;
            case 44:
                trisk1 = 77;
                break;
            case 45:
                trisk1 = 78;
                break;
        }

        /**************************************************/
        switch (trisk2) { // ด้าน 2 ชาย ผู้ปกครอง
            case 0:
                trisk2 = 30;
                break;
            case 1:
                trisk2 = 31;

                break;
            case 2:
                trisk2 = 32;
                break;
            case 3:
                trisk2 = 33;

                break;
            case 4:
                trisk2 = 34;

                break;
            case 5:
                trisk2 = 35;

                break;
            case 6:
                trisk2 = 36;

                break;
            case 7:
                trisk2 = 37;

                break;
            case 8:
                trisk2 = 38;
                break;
            case 9:
                trisk2 = 39;

                break;
            case 10:
                trisk2 = 40;

                break;
            case 11:
                trisk2 = 41;

                break;
            case 12:
                trisk2 = 42;

                break;
            case 13:
                trisk2 = 43;

                break;
            case 14:
                trisk2 = 44;

                break;
            case 15:
                trisk2 = 45;

                break;
            case 16:
                trisk2 = 46;
                break;
            case 17:
                trisk2 = 47;

                break;
            case 18:
                trisk2 = 47;

                break;
            case 19:
                trisk2 = 48;

                break;
            case 20:
                trisk2 = 49;

                break;
            case 21:
                trisk2 = 50;

                break;
            case 22:
                trisk2 = 51;

                break;
            case 23:
                trisk2 = 52;

                break;
            case 24:
                trisk2 = 53;
                break;
            case 25:
                trisk2 = 54;

                break;
            case 26:
                trisk2 = 55;

                break;
            case 27:
                trisk2 = 56;

                break;
            case 28:
                trisk2 = 57;

                break;
            case 29:
                trisk2 = 58;

                break;
            case 30:
                trisk2 = 59;

                break;
            case 31:
                trisk2 = 60;

                break;
            case 32:
                trisk2 = 60;
                break;
            case 33:
                trisk2 = 61;

                break;
            case 34:
                trisk2 = 62;

                break;
            case 35:
                trisk2 = 63;

                break;
            case 36:
                trisk2 = 64;

                break;
            case 37:
                trisk2 = 65;

                break;
            case 38:
                trisk2 = 66;

                break;
            case 39:
                trisk2 = 67;

                break;
            case 40:
                trisk2 = 68;
                break;
            case 41:
                trisk2 = 69;

                break;
            case 42:
                trisk2 = 70;

                break;
            case 43:
                trisk2 = 71;

                break;
            case 44:
                trisk2 = 72;

                break;
            case 45:
                trisk2 = 73;
                break;
        }

        /**************************************************/
        switch (trisk3) { // ด้าน 3 ชาย ผู้ปกครอง
            case 0:
                trisk3 = 27;
                break;
            case 1:
                trisk3 = 28;

                break;
            case 2:
                trisk3 = 29;
                break;
            case 3:
                trisk3 = 30;

                break;
            case 4:
                trisk3 = 30;

                break;
            case 5:
                trisk3 = 31;

                break;
            case 6:
                trisk3 = 31;

                break;
            case 7:
                trisk3 = 32;

                break;
            case 8:
                trisk3 = 33;
                break;
            case 9:
                trisk3 = 33;

                break;
            case 10:
                trisk3 = 34;

                break;
            case 11:
                trisk3 = 34;

                break;
            case 12:
                trisk3 = 35;

                break;
            case 13:
                trisk3 = 35;

                break;
            case 14:
                trisk3 = 36;

                break;
            case 15:
                trisk3 = 36;

                break;
            case 16:
                trisk3 = 37;
                break;
            case 17:
                trisk3 = 37;

                break;
            case 18:
                trisk3 = 38;

                break;
            case 19:
                trisk3 = 39;

                break;
            case 20:
                trisk3 = 39;

                break;
            case 21:
                trisk3 = 40;

                break;
            case 22:
                trisk3 = 40;

                break;
            case 23:
                trisk3 = 41;

                break;
            case 24:
                trisk3 = 41;
                break;
            case 25:
                trisk3 = 42;

                break;
            case 26:
                trisk3 = 42;

                break;
            case 27:
                trisk3 = 43;

                break;
            case 28:
                trisk3 = 44;

                break;
            case 29:
                trisk3 = 44;

                break;
            case 30:
                trisk3 = 45;

                break;
            case 31:
                trisk3 = 45;

                break;
            case 32:
                trisk3 = 46;
                break;
            case 33:
                trisk3 = 46;

                break;
            case 34:
                trisk3 = 47;

                break;
            case 35:
                trisk3 = 47;

                break;
            case 36:
                trisk3 = 48;

                break;
            case 37:
                trisk3 = 49;

                break;
            case 38:
                trisk3 = 49;

                break;
            case 39:
                trisk3 = 50;

                break;
            case 40:
                trisk3 = 50;
                break;
            case 41:
                trisk3 = 51;

                break;
            case 42:
                trisk3 = 51;

                break;
            case 43:
                trisk3 = 52;

                break;
            case 44:
                trisk3 = 52;

                break;
            case 45:
                trisk3 = 53;
                break;
            case 46:
                trisk3 = 53;
                break;
            case 47:
                trisk3 = 54;
                break;
            case 48:
                trisk3 = 55;
                break;
            case 49:
                trisk3 = 55;
                break;
            case 50:
                trisk3 = 56;
                break;
            case 51:
                trisk3 = 56;
                break;
            case 52:
                trisk3 = 57;
                break;
            case 53:
                trisk3 = 57;
                break;
            case 54:
                trisk3 = 58;
                break;
            case 55:
                trisk3 = 58;
                break;
            case 56:
                trisk3 = 59;
                break;
            case 57:
                trisk3 = 60;
                break;
            case 58:
                trisk3 = 60;
                break;
            case 59:
                trisk3 = 61;
                break;
            case 60:
                trisk3 = 61;
                break;
            case 61:
                trisk3 = 62;
                break;
            case 62:
                trisk3 = 62;
                break;
            case 63:
                trisk3 = 63;
                break;
            case 64:
                trisk3 = 63;
                break;
            case 65:
                trisk3 = 64;
                break;
            case 66:
                trisk3 = 65;
                break;
            case 67:
                trisk3 = 65;
                break;
            case 68:
                trisk3 = 66;
                break;
            case 69:
                trisk3 = 66;
                break;
            case 70:
                trisk3 = 67;
                break;
            case 71:
                trisk3 = 67;
                break;
            case 72:
                trisk3 = 68;
                break;
            case 73:
                trisk3 = 68;
                break;
            case 74:
                trisk3 = 69;
                break;
            case 75:
                trisk3 = 69;
                break;
            case 76:
                trisk3 = 70;
                break;
            case 77:
                trisk3 = 71;
                break;
            case 78:
                trisk3 = 71;
                break;
            case 79:
                trisk3 = 72;
                break;
            case 80:
                trisk3 = 72;
                break;
            case 81:
                trisk3 = 73;
                break;
            case 82:
                trisk3 = 73;
                break;
            case 83:
                trisk3 = 74;
                break;
            case 84:
                trisk3 = 74;
                break;
            case 85:
                trisk3 = 75;
                break;
            case 86:
                trisk3 = 75;
                break;
            case 87:
                trisk3 = 76;
                break;
            case 88:
                trisk3 = 76;
                break;
            case 89:
                trisk3 = 77;
                break;
            case 90:
                trisk3 = 78;
                break;


        }
    }

    private void uploadValueToServer() {
        try {

            MyConstant myConstant = new MyConstant();
            String strURL = myConstant.getUrlAddTass();

            PostTass postTass = new PostTass(TassActivity.this);
            postTass.execute(spn,spn2,spn3,spn4,spn5,spn6,spn7,spn8,spn9, spn10,
                    spn11,spn12,spn13,spn14, spn15,spn16,spn17,spn18,
                    spn19,spn20,spn21,spn22, spn23,spn24,spn25,spn26,
                    spn27,spn28,spn29,spn30, loginString[0], idString,
                    Integer.toString(trisk1), Integer.toString(trisk2), Integer.toString(trisk3),
                    loginString[3], currentDateString, strURL);



            if (Boolean.parseBoolean((postTass.get()))) {
                Intent intent = new Intent(TassActivity.this,riskThassActivity.class);
                intent.putExtra("Login", loginString);
                intent.putExtra("tmpIndex", idString);
                intent.putExtra("gender", genderString);
                intent.putExtra("age", ageString);
                intent.putExtra("name", nameString);
                intent.putExtra("risk1", (int)trisk1);
                intent.putExtra("risk2",(int) trisk2);
                intent.putExtra("risk3",(int) trisk3);
                intent.putExtra("ans1",tmpspn);
                intent.putExtra("ans2",tmpspn2);
                intent.putExtra("ans3",tmpspn3);
                intent.putExtra("ans4",tmpspn4);
                intent.putExtra("ans5",tmpspn5);
                intent.putExtra("ans6",tmpspn6);
                intent.putExtra("ans7",tmpspn7);
                intent.putExtra("ans8",tmpspn8);
                intent.putExtra("ans9",tmpspn9);
                intent.putExtra("ans10",tmpspn10);
                intent.putExtra("ans11",tmpspn11);
                intent.putExtra("ans12",tmpspn12);
                intent.putExtra("ans13",tmpspn13);
                intent.putExtra("ans14",tmpspn14);
                intent.putExtra("ans15",tmpspn15);
                intent.putExtra("ans16",tmpspn16);
                intent.putExtra("ans17",tmpspn17);
                intent.putExtra("ans18",tmpspn18);
                intent.putExtra("ans19",tmpspn19);
                intent.putExtra("ans20",tmpspn20);
                intent.putExtra("ans21",tmpspn21);
                intent.putExtra("ans22",tmpspn22);
                intent.putExtra("ans23",tmpspn23);
                intent.putExtra("ans24",tmpspn24);
                intent.putExtra("ans25",tmpspn25);
                intent.putExtra("ans26",tmpspn26);
                intent.putExtra("ans27",tmpspn27);
                intent.putExtra("ans28",tmpspn28);
                intent.putExtra("ans29",tmpspn29);
                intent.putExtra("ans30",tmpspn30);
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
                intent.putExtra("date",currentDateString);
                startActivity(intent);
            }else{
                Toast.makeText(TassActivity.this,"Cannot save user",Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {

        }
    }

    private boolean checkSpinner() {

       if (spn.equals("-") || spn2.equals("-")||spn3.equals("-") ||
                spn4.equals("-")||spn5.equals("-") || spn6.equals("-")||
                spn7.equals("-")||spn8.equals("-") || spn9.equals("-")||
                spn10.equals("-") || spn11.equals("-")||spn12.equals("-") ||
                spn13.equals("-")||spn14.equals("-") || spn15.equals("-")||
                spn16.equals("-") || spn17.equals("-")||spn18.equals("-") ||
                spn19.equals("-")||spn20.equals("-") || spn21.equals("-")||
                spn22.equals("-") || spn23.equals("-")||spn24.equals("-") ||
                spn25.equals("-")|| spn26.equals("-")|| spn27.equals("-")|| spn28.equals("-")
                || spn29.equals("-")|| spn30.equals("-")) {
            return true;



        } else {
            return false;
        }


    }
}

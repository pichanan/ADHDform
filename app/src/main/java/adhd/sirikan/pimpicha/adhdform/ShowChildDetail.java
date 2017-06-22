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

import com.itextpdf.text.Paragraph;

import org.json.JSONArray;
import org.json.JSONObject;

public class ShowChildDetail extends AppCompatActivity {

    private MyConstant myConstant;
    private String urlPHPString;
    private String[] columnStrings,resultStrings;
    private String tag = "16AprilV5";
    Button ImageViewPDF,button2;
    String ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9, ch10, ch11,
            ch12, ch13, ch14, ch15, ch16, ch17, ch18, ch19, ch20,
            ch21, ch22, ch23, ch24, ch25, ch26;

    String idString, loginString[],genderString,ageString,risk1,risk2,risk3,nameString;

    TextView textView,textView2,spn, spn2, spn3, spn4, spn5, spn6, spn7, spn8, spn9, spn10, spn11, spn12, spn13,
            spn14, spn15, spn16, spn17, spn18, spn19, spn20, spn21, spn22, spn23, spn24, spn25, spn26;

    String sspn, sspn2, sspn3, sspn4, sspn5, sspn6, sspn7, sspn8, sspn9, sspn10, sspn11, sspn12, sspn13,
            sspn14, sspn15, sspn16, sspn17, sspn18, sspn19, sspn20, sspn21, sspn22, sspn23, sspn24, sspn25, sspn26,date;
    String r1="",r2="",r3="";
    ImageView backView;
    String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_child_detail);


        //My setup


        //Query data From JSoN
        mySetup();
        queryDataFromJSoN();
        findId();
        textView = (TextView) findViewById(R.id.hisSnapRisk);
        ImageViewPDF = (Button) findViewById(R.id.showDetailPdf);
        button2 = (Button) findViewById(R.id.btnRegcmHisSnap);
        backView = (ImageView) findViewById(R.id.backfromShowchild1);
        ImageViewPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                putIt();


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAlert objMyAlert = new myAlert(ShowChildDetail.this);
                if(loginString[3].equals("1")) {//ผปค
                    objMyAlert.myDialog("คำแนะนำ(ไม่ใช่การวินิจฉัย ในการตัดสินปัญหาเด็ก)หากต้องการพบแพทย์ ควรบันทึกผลการประเมินเบื้องต้นเป็น PDF เพื่อประกอบการวินิจฉัย :",
                            "คะแนนมาตรฐานด้านสมาธิ:16\nด้านซนอยู่ไม่นิ่ง/หุนหันพลันแล่น:13\nด้านดื้อ ต่อต้าน:25"+"\nหากคะแนนที่ได้ด้านใดมากกว่าคะแนนมาตรฐาน ให้สงสัยว่าเด็กมีความเสี่ยงในด้านนั้นๆ");
                }else{
                    objMyAlert.myDialog("คำแนะนำ(ไม่ใช่การวินิจฉัย ในการตัดสินปัญหาเด็ก)หากต้องการพบแพทย์ ควรบันทึกผลการประเมินเบื้องต้นเป็น PDF เพื่อประกอบการวินิจฉัย :",
                            "คะแนนมาตรฐานด้านสมาธิ:23\nด้านซนอยู่ไม่นิ่ง/หุนหันพลันแล่น:16\nด้านดื้อ ต่อต้าน:11"+"\nหากคะแนนที่ได้ด้านใดมากกว่าคะแนนมาตรฐาน ให้สงสัยว่าเด็กมีความเสี่ยงในด้านนั้นๆ");
                }

            }
        });
        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        analyzeRisk();


    }//main method

   private void findId() {
       if(ch1.equals("0")){
           sspn = "ไม่เลย";
           spn = (TextView) findViewById(R.id.hisSnap1Choice1);
       }else if(ch1.equals("1")){
           sspn = "เล็กน้อย";
           spn = (TextView) findViewById(R.id.hisSnap1Choice2);
       }else if(ch1.equals("2")){
           sspn = "ค่อนข้างมาก";
           spn = (TextView) findViewById(R.id.hisSnap1Choice3);
       }else{
           sspn = "มาก";
           spn = (TextView) findViewById(R.id.hisSnap1Choice4);
       }


       if(ch2.equals("0")){
           sspn2 = "ไม่เลย";
           spn2 = (TextView) findViewById(R.id.hisSnap2Choice1);
       }else if(ch2.equals("1")){
           sspn2 = "เล็กน้อย";
           spn2 = (TextView) findViewById(R.id.hisSnap2Choice2);
       }else if(ch2.equals("2")){
           sspn2 = "ค่อนข้างมาก";
           spn2 = (TextView) findViewById(R.id.hisSnap2Choice3);
       }else{
           sspn2 = "มาก";
           spn2 = (TextView) findViewById(R.id.hisSnap2Choice4);
       }

       if(ch3.equals("0")){
           sspn3 = "ไม่เลย";
           spn3 = (TextView) findViewById(R.id.hisSnap3Choice1);
       }else if(ch3.equals("1")){
           sspn3 = "เล็กน้อย";
           spn3 = (TextView) findViewById(R.id.hisSnap3Choice2);
       }else if(ch3.equals("2")){
           sspn3 = "ค่อนข้างมาก";
           spn3 = (TextView) findViewById(R.id.hisSnap3Choice3);
       }else{
           sspn3 = "มาก";
           spn3 = (TextView) findViewById(R.id.hisSnap3Choice4);
       }

       if(ch4.equals("0")){
           sspn4 = "ไม่เลย";
           spn4 = (TextView) findViewById(R.id.hisSnap4Choice1);
       }else if(ch4.equals("1")){
           sspn4 = "เล็กน้อย";
           spn4 = (TextView) findViewById(R.id.hisSnap4Choice2);
       }else if(ch4.equals("2")){
           sspn4 = "ค่อนข้างมาก";
           spn4 = (TextView) findViewById(R.id.hisSnap4Choice3);
       }else{
           sspn4 = "มาก";
           spn4 = (TextView) findViewById(R.id.hisSnap4Choice4);
       }

       if(ch5.equals("0")){
           sspn5 = "ไม่เลย";
           spn5 = (TextView) findViewById(R.id.hisSnap5Choice1);
       }else if(ch5.equals("1")){
           sspn5 = "เล็กน้อย";
           spn5 = (TextView) findViewById(R.id.hisSnap5Choice2);
       }else if(ch5.equals("2")){
           sspn5 = "ค่อนข้างมาก";
           spn5 = (TextView) findViewById(R.id.hisSnap5Choice3);
       }else{
           sspn5 = "มาก";
           spn5 = (TextView) findViewById(R.id.hisSnap5Choice4);
       }

       if(ch6.equals("0")){
           sspn6 = "ไม่เลย";
           spn6 = (TextView) findViewById(R.id.hisSnap6Choice1);
       }else if(ch6.equals("1")){
           sspn6 = "เล็กน้อย";
           spn6 = (TextView) findViewById(R.id.hisSnap6Choice2);
       }else if(ch6.equals("2")){
           sspn6 = "ค่อนข้างมาก";
           spn6 = (TextView) findViewById(R.id.hisSnap6Choice3);
       }else{
           sspn6 = "มาก";
           spn6 = (TextView) findViewById(R.id.hisSnap6Choice4);
       }

       if(ch7.equals("0")){
           sspn7 = "ไม่เลย";
           spn7 = (TextView) findViewById(R.id.hisSnap7Choice1);
       }else if(ch7.equals("1")){
           sspn7 = "เล็กน้อย";
           spn7 = (TextView) findViewById(R.id.hisSnap7Choice2);
       }else if(ch7.equals("2")){
           sspn7 = "ค่อนข้างมาก";
           spn7 = (TextView) findViewById(R.id.hisSnap7Choice3);
       }else{
           sspn7 = "มาก";
           spn7 = (TextView) findViewById(R.id.hisSnap7Choice4);
       }

       if(ch8.equals("0")){
           sspn8 = "ไม่เลย";
           spn8 = (TextView) findViewById(R.id.hisSnap8Choice1);
       }else if(ch8.equals("1")){
           sspn8 = "เล็กน้อย";
           spn8 = (TextView) findViewById(R.id.hisSnap8Choice2);
       }else if(ch8.equals("2")){
           sspn8 = "ค่อนข้างมาก";
           spn8 = (TextView) findViewById(R.id.hisSnap8Choice3);
       }else{
           sspn8 = "มาก";
           spn8 = (TextView) findViewById(R.id.hisSnap8Choice4);
       }

       if(ch9.equals("0")){
           sspn9 = "ไม่เลย";
           spn9 = (TextView) findViewById(R.id.hisSnap9Choice1);
       }else if(ch9.equals("1")){
           sspn9 = "เล็กน้อย";
           spn9 = (TextView) findViewById(R.id.hisSnap9Choice2);
       }else if(ch9.equals("2")){
           sspn9 = "ค่อนข้างมาก";
           spn9 = (TextView) findViewById(R.id.hisSnap9Choice3);
       }else{
           sspn9 = "มาก";
           spn9 = (TextView) findViewById(R.id.hisSnap9Choice4);
       }

       if(ch10.equals("0")){
           sspn10 = "ไม่เลย";
           spn10 = (TextView) findViewById(R.id.hisSnap10Choice1);
       }else if(ch10.equals("1")){
           sspn10 = "เล็กน้อย";
           spn10 = (TextView) findViewById(R.id.hisSnap10Choice2);
       }else if(ch10.equals("2")){
           sspn10 = "ค่อนข้างมาก";
           spn10 = (TextView) findViewById(R.id.hisSnap10Choice3);
       }else{
           sspn10 = "มาก";
           spn10 = (TextView) findViewById(R.id.hisSnap10Choice4);
       }

       if(ch11.equals("0")){
           sspn11 = "ไม่เลย";
           spn11 = (TextView) findViewById(R.id.hisSnap11Choice1);
       }else if(ch11.equals("1")){
           sspn11 = "เล็กน้อย";
           spn11 = (TextView) findViewById(R.id.hisSnap11Choice2);
       }else if(ch11.equals("2")){
           sspn11 = "ค่อนข้างมาก";
           spn11 = (TextView) findViewById(R.id.hisSnap11Choice3);
       }else{
           sspn11 = "มาก";
           spn11 = (TextView) findViewById(R.id.hisSnap11Choice4);
       }

       if(ch12.equals("0")){
           sspn12 = "ไม่เลย";
           spn12 = (TextView) findViewById(R.id.hisSnap12Choice1);
       }else if(ch12.equals("1")){
           sspn12 = "เล็กน้อย";
           spn12 = (TextView) findViewById(R.id.hisSnap12Choice2);
       }else if(ch12.equals("2")){
           sspn12 = "ค่อนข้างมาก";
           spn12 = (TextView) findViewById(R.id.hisSnap12Choice3);
       }else{
           sspn12 = "มาก";
           spn12 = (TextView) findViewById(R.id.hisSnap12Choice4);
       }

       if(ch13.equals("0")){
           sspn13 = "ไม่เลย";
           spn13 = (TextView) findViewById(R.id.hisSnap13Choice1);
       }else if(ch13.equals("1")){
           sspn13 = "เล็กน้อย";
           spn13 = (TextView) findViewById(R.id.hisSnap13Choice2);
       }else if(ch13.equals("2")){
           sspn13 = "ค่อนข้างมาก";
           spn13 = (TextView) findViewById(R.id.hisSnap13Choice3);
       }else{
           sspn13 = "มาก";
           spn13 = (TextView) findViewById(R.id.hisSnap13Choice4);
       }

       if(ch14.equals("0")){
           sspn14 = "ไม่เลย";
           spn14 = (TextView) findViewById(R.id.hisSnap14Choice1);
       }else if(ch14.equals("1")){
           sspn14 = "เล็กน้อย";
           spn14 = (TextView) findViewById(R.id.hisSnap14Choice2);
       }else if(ch14.equals("2")){
           sspn14 = "ค่อนข้างมาก";
           spn14 = (TextView) findViewById(R.id.hisSnap14Choice3);
       }else{
           sspn14 = "มาก";
           spn14 = (TextView) findViewById(R.id.hisSnap14Choice4);
       }

       if(ch15.equals("0")){
           sspn15 = "ไม่เลย";
           spn15 = (TextView) findViewById(R.id.hisSnap15Choice1);
       }else if(ch15.equals("1")){
           sspn15 = "เล็กน้อย";
           spn15 = (TextView) findViewById(R.id.hisSnap15Choice2);
       }else if(ch15.equals("2")){
           sspn15 = "ค่อนข้างมาก";
           spn15 = (TextView) findViewById(R.id.hisSnap15Choice3);
       }else{
           sspn15 = "มาก";
           spn15 = (TextView) findViewById(R.id.hisSnap15Choice4);
       }

       if(ch16.equals("0")){
           sspn16 = "ไม่เลย";
           spn16 = (TextView) findViewById(R.id.hisSnap16Choice1);
       }else if(ch16.equals("1")){
           sspn16 = "เล็กน้อย";
           spn16 = (TextView) findViewById(R.id.hisSnap16Choice2);
       }else if(ch16.equals("2")){
           sspn16 = "ค่อนข้างมาก";
           spn16 = (TextView) findViewById(R.id.hisSnap16Choice3);
       }else{
           sspn16 = "มาก";
           spn16 = (TextView) findViewById(R.id.hisSnap16Choice4);
       }

       if(ch17.equals("0")){
           sspn17 = "ไม่เลย";
           spn17 = (TextView) findViewById(R.id.hisSnap17Choice1);
       }else if(ch17.equals("1")){
           sspn17 = "เล็กน้อย";
           spn17 = (TextView) findViewById(R.id.hisSnap17Choice2);
       }else if(ch17.equals("2")){
           sspn17 = "ค่อนข้างมาก";
           spn17 = (TextView) findViewById(R.id.hisSnap17Choice3);
       }else{
           sspn17 = "มาก";
           spn17 = (TextView) findViewById(R.id.hisSnap17Choice4);
       }

       if(ch18.equals("0")){
           sspn18 = "ไม่เลย";
           spn18 = (TextView) findViewById(R.id.hisSnap18Choice1);
       }else if(ch18.equals("1")){
           sspn18 = "เล็กน้อย";
           spn18 = (TextView) findViewById(R.id.hisSnap18Choice2);
       }else if(ch18.equals("2")){
           sspn18 = "ค่อนข้างมาก";
           spn18 = (TextView) findViewById(R.id.hisSnap18Choice3);
       }else{
           sspn18 = "มาก";
           spn18 = (TextView) findViewById(R.id.hisSnap18Choice4);
       }

       if(ch19.equals("0")){
           sspn19 = "ไม่เลย";
           spn19 = (TextView) findViewById(R.id.hisSnap19Choice1);
       }else if(ch19.equals("1")){
           sspn19 = "เล็กน้อย";
           spn19 = (TextView) findViewById(R.id.hisSnap19Choice2);
       }else if(ch19.equals("2")){
           sspn19 = "ค่อนข้างมาก";
           spn19 = (TextView) findViewById(R.id.hisSnap19Choice3);
       }else{
           sspn19 = "มาก";
           spn19 = (TextView) findViewById(R.id.hisSnap19Choice4);
       }

       if(ch20.equals("0")){
           sspn20 = "ไม่เลย";
           spn20 = (TextView) findViewById(R.id.hisSnap20Choice1);
       }else if(ch20.equals("1")){
           sspn20 = "เล็กน้อย";
           spn20 = (TextView) findViewById(R.id.hisSnap20Choice2);
       }else if(ch20.equals("2")){
           sspn20 = "ค่อนข้างมาก";
           spn20 = (TextView) findViewById(R.id.hisSnap20Choice3);
       }else{
           sspn20 = "มาก";
           spn20 = (TextView) findViewById(R.id.hisSnap20Choice4);
       }

       if(ch21.equals("0")){
           sspn21 = "ไม่เลย";
           spn21 = (TextView) findViewById(R.id.hisSnap21Choice1);
       }else if(ch21.equals("1")){
           sspn21 = "เล็กน้อย";
           spn21 = (TextView) findViewById(R.id.hisSnap21Choice2);
       }else if(ch21.equals("2")){
           sspn21 = "ค่อนข้างมาก";
           spn21 = (TextView) findViewById(R.id.hisSnap21Choice3);
       }else{
           sspn21 = "มาก";
           spn21 = (TextView) findViewById(R.id.hisSnap21Choice4);
       }

       if(ch22.equals("0")){
           sspn22 = "ไม่เลย";
           spn22 = (TextView) findViewById(R.id.hisSnap22Choice1);
       }else if(ch22.equals("1")){
           sspn22 = "เล็กน้อย";
           spn22 = (TextView) findViewById(R.id.hisSnap22Choice2);
       }else if(ch22.equals("2")){
           sspn22 = "ค่อนข้างมาก";
           spn22 = (TextView) findViewById(R.id.hisSnap22Choice3);
       }else{
           sspn22 = "มาก";
           spn22 = (TextView) findViewById(R.id.hisSnap22Choice4);
       }

       if(ch23.equals("0")){
           sspn23 = "ไม่เลย";
           spn23 = (TextView) findViewById(R.id.hisSnap23Choice1);
       }else if(ch23.equals("1")){
           sspn23 = "เล็กน้อย";
           spn23 = (TextView) findViewById(R.id.hisSnap23Choice2);
       }else if(ch23.equals("2")){
           sspn23 = "ค่อนข้างมาก";
           spn23 = (TextView) findViewById(R.id.hisSnap23Choice3);
       }else{
           sspn23 = "มาก";
           spn23 = (TextView) findViewById(R.id.hisSnap23Choice4);
       }

       if(ch24.equals("0")){
           sspn24 = "ไม่เลย";
           spn24 = (TextView) findViewById(R.id.hisSnap24Choice1);
       }else if(ch24.equals("1")){
           sspn24 = "เล็กน้อย";
           spn24 = (TextView) findViewById(R.id.hisSnap24Choice2);
       }else if(ch24.equals("2")){
           sspn24 = "ค่อนข้างมาก";
           spn24 = (TextView) findViewById(R.id.hisSnap24Choice3);
       }else{
           sspn24 = "มาก";
           spn24 = (TextView) findViewById(R.id.hisSnap24Choice4);
       }

       if(ch25.equals("0")){
           sspn25 = "ไม่เลย";
           spn25 = (TextView) findViewById(R.id.hisSnap25Choice1);
       }else if(ch25.equals("1")){
           sspn25 = "เล็กน้อย";
           spn25 = (TextView) findViewById(R.id.hisSnap25Choice2);
       }else if(ch25.equals("2")){
           sspn25 = "ค่อนข้างมาก";
           spn25 = (TextView) findViewById(R.id.hisSnap25Choice3);
       }else{
           sspn25 = "มาก";
           spn25 = (TextView) findViewById(R.id.hisSnap25Choice4);
       }

       if(ch26.equals("0")){
           sspn26 = "ไม่เลย";
           spn26 = (TextView) findViewById(R.id.hisSnap26Choice1);
       }else if(ch26.equals("1")){
           sspn26 = "เล็กน้อย";
           spn26 = (TextView) findViewById(R.id.hisSnap26Choice2);
       }else if(ch26.equals("2")){
           sspn26 = "ค่อนข้างมาก";
           spn26 = (TextView) findViewById(R.id.hisSnap26Choice3);
       }else{
           sspn26 = "มาก";
           spn26 = (TextView) findViewById(R.id.hisSnap26Choice4);
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


    private void queryDataFromJSoN() {
        try {


            getDataWhere objGetDataWhere = new getDataWhere(ShowChildDetail.this);
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
            risk1 = resultStrings[29];
            risk2 = resultStrings[30];
            risk3 = resultStrings[31];
            date = resultStrings[34];








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
        columnStrings = myConstant.getColumnTest();
        urlPHPString = myConstant.getUrlGetTestWhereID();
    }

    private void putIt() {
        Intent intent = new Intent(ShowChildDetail.this, PDFActivity.class);
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
        intent.putExtra("risk1", Integer.parseInt(risk1));
        intent.putExtra("risk2", Integer.parseInt(risk2));
        intent.putExtra("risk3", Integer.parseInt(risk3));
        intent.putExtra("date", date);
        intent.putExtra("gender", genderString);
        intent.putExtra("age", ageString);
        intent.putExtra("name", nameString);
        intent.putExtra("Login", loginString);
        startActivity(intent);

    }
    private void analyzeRisk() {
        if(loginString[3].equals("1")){//ผปค

            if(Integer.parseInt(risk1)>16){
                r1 = "มีความเสี่ยง";
            }
            if (Integer.parseInt(risk2)>13){
                r2="มีความเสี่ยง";
            }
            if(Integer.parseInt(risk3)>15){
                r3 = "มีความเสี่ยง";
            }


            textView.setText("คะแนนด้านสมาธิ:"+risk1+":"+r1+"\n"+"คะแนนด้านซนอยู่ไม่นิ่ง/หุนหันพลันแล่น:"+risk2+":"+r2+"\n"+"คะแนนด้านดื้อ ต่อต้าน:"+risk3+":"+r3+"\n");

            // ครู
        }else{
            if(Integer.parseInt(risk1)>23){
                r1 = "มีความเสี่ยง";
            }
            if (Integer.parseInt(risk2)>16){
                r2="มีความเสี่ยง";
            }
            if(Integer.parseInt(risk3)>11){
                r3 = "มีความเสี่ยง";
            }



                textView.setText("คะแนนด้านสมาธิ:"+risk1+":"+r1+"\n"+"คะแนนด้านซนอยู่ไม่นิ่ง/หุนหันพลันแล่น:"+risk2+":"+r2+"\n"+"คะแนนด้านดื้อ ต่อต้าน:"+risk3+":"+r3+"\n");



        }

    }


}//main Class

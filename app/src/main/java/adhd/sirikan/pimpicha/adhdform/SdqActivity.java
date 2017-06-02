package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SdqActivity extends AppCompatActivity implements View.OnClickListener {
    Spinner spinnerView, spinnerView2, spinnerView3, spinnerView4, spinnerView5, spinnerView6,
            spinnerView7, spinnerView8, spinnerView9, spinnerView10,
            spinnerView11, spinnerView12, spinnerView13, spinnerView14,
            spinnerView15, spinnerView16, spinnerView17, spinnerView18,
            spinnerView19, spinnerView20, spinnerView21, spinnerView22,
            spinnerView23, spinnerView24, spinnerView25, spinnerView26;

    String tmpspn, tmpspn2, tmpspn3, tmpspn4, tmpspn5, tmpspn6, tmpspn7, tmpspn8, tmpspn9, tmpspn10, tmpspn11, tmpspn12, tmpspn13,
            tmpspn14, tmpspn15, tmpspn16, tmpspn17, tmpspn18, tmpspn19, tmpspn20, tmpspn21, tmpspn22, tmpspn23, tmpspn24, tmpspn25,
            tmpspn26;

    String spn, spn2, spn3, spn4, spn5, spn6, spn7, spn8, spn9, spn10, spn11, spn12, spn13, spn14,
            spn15, spn16, spn17, spn18, spn19, spn20, spn21, spn22, spn23, spn24, spn25, spn26;

    String[] spinnerValue = {"-", "ไม่จริง", "จริงบางครั้ง", "จริง"};
    private static String tag = "30MarchV1",tag2 = "16AprilV1";
    private int risk;
    String idString, loginString[],genderString,ageString,nameString;
    TextView textView;
    Button button;

    private java.util.Calendar calendar;
    private String currentDateString;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdq);
        getValueFromIntent();

        //initial view
        initialSpinner();
        initialView();

        //find currentDate
        findCurrentDate();

        button.setOnClickListener(SdqActivity.this);
        imageView.setOnClickListener(SdqActivity.this);
    }

    private void findCurrentDate() {
        calendar = java.util.Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        currentDateString = dateFormat.format(calendar.getTime());
        Log.d("10AprilV1", "currentDate" + currentDateString);
    }

    private void initialView() {
        button = (Button) findViewById(R.id.sdq4);
        imageView = (ImageView) findViewById(R.id.backfromSdq);
    }

    private void initialSpinner() {
        spinnerView = (Spinner) findViewById(R.id.spinSdq1);
        spinnerView2 = (Spinner) findViewById(R.id.spinSdq2);
        spinnerView3 = (Spinner) findViewById(R.id.spinSdq3);
        spinnerView4 = (Spinner) findViewById(R.id.spinSdq4);
        spinnerView5 = (Spinner) findViewById(R.id.spinSdq5);
        spinnerView6 = (Spinner) findViewById(R.id.spinSdq6);
        spinnerView7 = (Spinner) findViewById(R.id.spinSdq7);
        spinnerView8 = (Spinner) findViewById(R.id.spinSdq8);
        spinnerView9 = (Spinner) findViewById(R.id.spinSdq9);
        spinnerView10 = (Spinner) findViewById(R.id.spinSdq10);
        spinnerView11 = (Spinner) findViewById(R.id.spinSdq11);
        spinnerView12 = (Spinner) findViewById(R.id.spinSdq12);
        spinnerView13 = (Spinner) findViewById(R.id.spinSdq13);
        spinnerView14 = (Spinner) findViewById(R.id.spinSdq14);
        spinnerView15 = (Spinner) findViewById(R.id.spinSdq15);
        spinnerView16 = (Spinner) findViewById(R.id.spinSdq16);
        spinnerView17 = (Spinner) findViewById(R.id.spinSdq17);
        spinnerView18 = (Spinner) findViewById(R.id.spinSdq18);
        spinnerView19 = (Spinner) findViewById(R.id.spinSdq19);
        spinnerView20 = (Spinner) findViewById(R.id.spinSdq20);
        spinnerView21 = (Spinner) findViewById(R.id.spinSdq21);
        spinnerView22 = (Spinner) findViewById(R.id.spinSdq22);
        spinnerView23 = (Spinner) findViewById(R.id.spinSdq23);
        spinnerView24 = (Spinner) findViewById(R.id.spinSdq24);
        spinnerView25 = (Spinner) findViewById(R.id.spinSdq25);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(SdqActivity.this, android.R.layout.simple_list_item_1, spinnerValue);
        spinnerView.setAdapter(adapter);
        spinnerView2.setAdapter(adapter);
        spinnerView3.setAdapter(adapter);
        spinnerView4.setAdapter(adapter);
        spinnerView5.setAdapter(adapter);
        spinnerView6.setAdapter(adapter);
        spinnerView7.setAdapter(adapter);
        spinnerView8.setAdapter(adapter);
        spinnerView9.setAdapter(adapter);
        spinnerView10.setAdapter(adapter);
        spinnerView11.setAdapter(adapter);
        spinnerView12.setAdapter(adapter);
        spinnerView13.setAdapter(adapter);
        spinnerView14.setAdapter(adapter);
        spinnerView15.setAdapter(adapter);
        spinnerView16.setAdapter(adapter);
        spinnerView17.setAdapter(adapter);
        spinnerView18.setAdapter(adapter);
        spinnerView19.setAdapter(adapter);
        spinnerView20.setAdapter(adapter);
        spinnerView21.setAdapter(adapter);
        spinnerView22.setAdapter(adapter);
        spinnerView23.setAdapter(adapter);
        spinnerView24.setAdapter(adapter);
        spinnerView25.setAdapter(adapter);
        
    }

    private void getValueFromIntent() {
        idString = getIntent().getStringExtra("tmpIndex");
        loginString = getIntent().getStringArrayExtra("Login");
        genderString = getIntent().getStringExtra("gender");
        ageString = getIntent().getStringExtra("age");
        nameString = getIntent().getStringExtra("name");

        for(int i = 0 ;i<loginString.length;i++) {
            Log.d("22_5_60", "loginString(" + i + ")==>" + loginString[i]);
        }

    }


    public void onClick(View v) {
        if (v == button) {
            //get value from edidtex
            getValueFromEdidtex();



            if (checkSpinner()) {
                //have space
                myAlert objMyAlert = new myAlert(SdqActivity.this);
                objMyAlert.myDialog("คำตอบไม่ครบ",
                        "กรุณาตอบคำถาให้ครบ 25 ข้อ");
            } else {
                // check special
                checkSpecial(idString, loginString[3]);
                risk = Integer.parseInt(spn2) + Integer.parseInt(spn10) + Integer.parseInt(spn15) + Integer.parseInt(spn21)
                        + Integer.parseInt(spn25);

                uploadValueToServer();


            }


        }
        if (v == imageView) {
            onBackPressed();
            finish();
        }
    }

    private void getValueFromEdidtex() {
        spn = spinnerView.getSelectedItem().toString();
        tmpspn = spn;
        if(spn.equals("-")){
            spn = "-";
        }else if(spn.equals("ไม่จริง")){
            spn = "0";
        }else if(spn.equals("จริงบางครั้ง")){
            spn = "1";
        }else {
            spn = "2";
        }

        spn2 = spinnerView2.getSelectedItem().toString();
        tmpspn2 = spn2;
        if(spn2.equals("-")){
            spn2 = "-";
        }else if(spn2.equals("ไม่จริง")){
            spn2 = "0";
        }else if(spn2.equals("จริงบางครั้ง")){
            spn2 = "1";
        }else {
            spn2 = "2";
        }
        spn3 = spinnerView3.getSelectedItem().toString();
        tmpspn3 = spn3;
        if(spn3.equals("-")){
            spn3 = "-";
        }else if(spn3.equals("ไม่จริง")){
            spn3 = "0";
        }else if(spn3.equals("จริงบางครั้ง")){
            spn3 = "1";
        }else {
            spn3 = "2";
        }
        spn4 = spinnerView4.getSelectedItem().toString();
        tmpspn4 = spn4;
        if(spn4.equals("-")){
            spn4 = "-";
        }else if(spn4.equals("ไม่จริง")){
            spn4 = "0";
        }else if(spn4.equals("จริงบางครั้ง")){
            spn4 = "1";
        }else {
            spn4 = "2";
        }
        spn5 = spinnerView5.getSelectedItem().toString();
        tmpspn5 = spn5;
        if(spn5.equals("-")){
            spn5 = "-";
        }else if(spn5.equals("ไม่จริง")){
            spn5 = "0";
        }else if(spn5.equals("จริงบางครั้ง")){
            spn5 = "1";
        }else {
            spn5 = "2";
        }
        spn6 = spinnerView6.getSelectedItem().toString();
        tmpspn6 = spn6;
        if(spn6.equals("-")){
            spn6 = "-";
        }else if(spn6.equals("ไม่จริง")){
            spn6 = "0";
        }else if(spn6.equals("จริงบางครั้ง")){
            spn6 = "1";
        }else {
            spn6 = "2";
        }
        spn7 = spinnerView7.getSelectedItem().toString();
        tmpspn7 = spn7;
        if(spn7.equals("-")){
            spn7 = "-";
        }else if(spn7.equals("ไม่จริง")){
            spn7 = "0";
        }else if(spn7.equals("จริงบางครั้ง")){
            spn7 = "1";
        }else {
            spn7 = "2";
        }
        spn8 = spinnerView8.getSelectedItem().toString();
        tmpspn8 = spn8;
        if(spn8.equals("-")){
            spn8 = "-";
        }else if(spn8.equals("ไม่จริง")){
            spn8 = "0";
        }else if(spn8.equals("จริงบางครั้ง")){
            spn8 = "1";
        }else {
            spn8 = "2";
        }
        spn9 = spinnerView9.getSelectedItem().toString();
        tmpspn9 = spn9;
        if(spn9.equals("-")){
            spn9 = "-";
        }else if(spn9.equals("ไม่จริง")){
            spn9 = "0";
        }else if(spn9.equals("จริงบางครั้ง")){
            spn9 = "1";
        }else {
            spn9 = "2";
        }
        spn10 = spinnerView10.getSelectedItem().toString();
        tmpspn10 = spn10;
        if(spn10.equals("-")){
            spn10 = "-";
        }else if(spn10.equals("ไม่จริง")){
            spn10 = "0";
        }else if(spn10.equals("จริงบางครั้ง")){
            spn10 = "1";
        }else {
            spn10 = "2";
        }
        spn11 = spinnerView11.getSelectedItem().toString();
        tmpspn11 = spn11;
        if(spn11.equals("-")){
            spn11 = "-";
        }else if(spn11.equals("ไม่จริง")){
            spn11 = "0";
        }else if(spn11.equals("จริงบางครั้ง")){
            spn11 = "1";
        }else {
            spn11 = "2";
        }
        spn12 = spinnerView12.getSelectedItem().toString();
        tmpspn12 = spn12;
        if(spn12.equals("-")){
            spn12 = "-";
        }else if(spn12.equals("ไม่จริง")){
            spn12 = "0";
        }else if(spn12.equals("จริงบางครั้ง")){
            spn12 = "1";
        }else {
            spn12 = "2";
        }
        spn13 = spinnerView13.getSelectedItem().toString();
        tmpspn13 = spn13;
        if(spn13.equals("-")){
            spn13 = "-";
        }else if(spn13.equals("ไม่จริง")){
            spn13 = "0";
        }else if(spn13.equals("จริงบางครั้ง")){
            spn13 = "1";
        }else {
            spn13 = "2";
        }
        spn14 = spinnerView14.getSelectedItem().toString();
        tmpspn14 = spn14;
        if(spn14.equals("-")){
            spn14 = "-";
        }else if(spn14.equals("ไม่จริง")){
            spn14 = "0";
        }else if(spn14.equals("จริงบางครั้ง")){
            spn14 = "1";
        }else {
            spn14 = "2";
        }
        spn15 = spinnerView15.getSelectedItem().toString();
        tmpspn15 = spn15;
        if(spn15.equals("-")){
            spn15 = "-";
        }else if(spn15.equals("ไม่จริง")){
            spn15 = "0";
        }else if(spn15.equals("จริงบางครั้ง")){
            spn15 = "1";
        }else {
            spn15 = "2";
        }
        spn16 = spinnerView16.getSelectedItem().toString();
        tmpspn16 = spn16;
        if(spn16.equals("-")){
            spn16 = "-";
        }else if(spn16.equals("ไม่จริง")){
            spn16 = "0";
        }else if(spn16.equals("จริงบางครั้ง")){
            spn16 = "1";
        }else {
            spn16 = "2";
        }
        spn17 = spinnerView17.getSelectedItem().toString();
        tmpspn17 = spn17;
        if(spn17.equals("-")){
            spn17 = "-";
        }else if(spn17.equals("ไม่จริง")){
            spn17 = "0";
        }else if(spn17.equals("จริงบางครั้ง")){
            spn17 = "1";
        }else {
            spn17 = "2";
        }
        spn18 = spinnerView18.getSelectedItem().toString();
        tmpspn18 = spn18;
        if(spn18.equals("-")){
            spn18 = "-";
        }else if(spn18.equals("ไม่จริง")){
            spn18 = "0";
        }else if(spn18.equals("จริงบางครั้ง")){
            spn18 = "1";
        }else {
            spn18 = "2";
        }
        spn19 = spinnerView19.getSelectedItem().toString();
        tmpspn19 = spn19;
        if(spn19.equals("-")){
            spn19 = "-";
        }else if(spn19.equals("ไม่จริง")){
            spn19 = "0";
        }else if(spn19.equals("จริงบางครั้ง")){
            spn19 = "1";
        }else {
            spn19 = "2";
        }
        spn20 = spinnerView20.getSelectedItem().toString();
        tmpspn20 = spn20;
        if(spn20.equals("-")){
            spn20 = "-";
        }else if(spn20.equals("ไม่จริง")){
            spn20 = "0";
        }else if(spn20.equals("จริงบางครั้ง")){
            spn20 = "1";
        }else {
            spn20 = "2";
        }
        spn21 = spinnerView21.getSelectedItem().toString();
        tmpspn21 = spn21;
        if(spn21.equals("-")){
            spn21 = "-";
        }else if(spn21.equals("ไม่จริง")){
            spn21 = "0";
        }else if(spn21.equals("จริงบางครั้ง")){
            spn21 = "1";
        }else {
            spn21 = "2";
        }
        spn22 = spinnerView22.getSelectedItem().toString();
        tmpspn22 = spn22;
        if(spn22.equals("-")){
            spn22 = "-";
        }else if(spn22.equals("ไม่จริง")){
            spn22 = "0";
        }else if(spn22.equals("จริงบางครั้ง")){
            spn22 = "1";
        }else {
            spn22 = "2";
        }
        spn23 = spinnerView23.getSelectedItem().toString();
        tmpspn23 = spn23;
        if(spn23.equals("-")){
            spn23 = "-";
        }else if(spn23.equals("ไม่จริง")){
            spn23 = "0";
        }else if(spn23.equals("จริงบางครั้ง")){
            spn23 = "1";
        }else {
            spn23 = "2";
        }
        spn24 = spinnerView24.getSelectedItem().toString();
        tmpspn24 = spn24;
        if(spn24.equals("-")){
            spn24 = "-";
        }else if(spn24.equals("ไม่จริง")){
            spn24 = "0";
        }else if(spn24.equals("จริงบางครั้ง")){
            spn24 = "1";
        }else {
            spn24 = "2";
        }
        spn25 = spinnerView25.getSelectedItem().toString();
        tmpspn25 = spn25;
        if(spn25.equals("-")){
            spn25 = "-";
        }else if(spn25.equals("ไม่จริง")){
            spn25 = "0";
        }else if(spn25.equals("จริงบางครั้ง")){
            spn25 = "1";
        }else {
            spn25 = "2";
        }

    }

    private void uploadValueToServer() {
        //wait type string
        try {

            MyConstant myConstant = new MyConstant();
            String strURL = myConstant.getUrlAddSdq();

            PostSdq postSdq = new PostSdq(SdqActivity.this);
            postSdq.execute(spn, spn2, spn3, spn4, spn5,
                    spn6, spn7, spn8, spn9, spn10,
                    spn11, spn12, spn13, spn14, spn15,
                    spn16, spn17, spn18, spn19, spn20,
                    spn21, spn22, spn23, spn24, spn25, loginString[0], idString,
                    Integer.toString(risk),
                    loginString[3], currentDateString, strURL);

            Log.d(tag, "Result ==>" + postSdq.get());

            if (Boolean.parseBoolean((postSdq.get()))) {
                Intent intent = new Intent(SdqActivity.this,riskSdqActivity.class);
                intent.putExtra("Login", loginString);
                intent.putExtra("tmpIndex", idString);
                intent.putExtra("gender", genderString);
                intent.putExtra("age", ageString);
                intent.putExtra("name", nameString);
                intent.putExtra("risk",(int) risk);
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
                intent.putExtra("date",currentDateString);
                startActivity(intent);
            } else {
                Toast.makeText(SdqActivity.this, "Cannot save user", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            Log.d(tag, "e upload ==>" + e.toString());
        }
    }

    private void checkSpecial(String childID, String doType) {
        try {
            MyConstant myConstant = new MyConstant();
            String urlPhp = myConstant.getUrlEditSpecial3();

            EditSpecial3 editSpecial3 = new EditSpecial3(SdqActivity.this);
            editSpecial3.execute(childID, doType, urlPhp);

            Log.d("16AprilV2", "Result ==>" + editSpecial3.get());

        } catch (Exception e) {
            Log.d(tag2, "e checkSpecial ==>" + e.toString());
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
                spn25.equals("-") ) {
            return true;



        } else {
            return false;
        }


    }
}

package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SnapActivity extends AppCompatActivity implements View.OnClickListener {
    // explicit


    private Button button;
    Spinner spinnerView, spinnerView2, spinnerView3, spinnerView4, spinnerView5, spinnerView6, spinnerView7, spinnerView8, spinnerView9, spinnerView10,
            spinnerView11, spinnerView12, spinnerView13, spinnerView14, spinnerView15, spinnerView16, spinnerView17, spinnerView18, spinnerView19, spinnerView20, spinnerView21, spinnerView22, spinnerView23, spinnerView24, spinnerView25, spinnerView26;
    String spn, spn2, spn3, spn4, spn5, spn6, spn7, spn8, spn9, spn10, spn11, spn12, spn13,
            spn14, spn15, spn16, spn17, spn18, spn19, spn20, spn21, spn22, spn23, spn24, spn25, spn26;
    String tmpspn, tmpspn2, tmpspn3, tmpspn4, tmpspn5, tmpspn6, tmpspn7, tmpspn8, tmpspn9, tmpspn10, tmpspn11, tmpspn12, tmpspn13,
            tmpspn14, tmpspn15, tmpspn16, tmpspn17, tmpspn18, tmpspn19, tmpspn20, tmpspn21, tmpspn22, tmpspn23, tmpspn24, tmpspn25,
            tmpspn26;
    String[] spinnerValue = {"-", "ไม่เลย", "เล็กน้อย", "ค่อนข้างมาก", "มาก"};
    private static String tag = "30MarchV1",tag2 = "16AprilV1";
    private  int risk1,risk2,risk3;
    String idString, loginString[],genderString,ageString;
    TextView textView;



    private java.util.Calendar calendar;
    private String currentDateString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snap);

        //Get value from Intent
        getValueFromIntent();

        //initial view
        initialSpinner();
        initialView();

        //find currentDate
        findCurrentDate();

        textView = (TextView) findViewById(R.id.qsnap1);


        //btn controller
        button.setOnClickListener(SnapActivity.this);


    }//main method

    private void getValueFromIntent() {
        idString = getIntent().getStringExtra("tmpIndex");
        loginString = getIntent().getStringArrayExtra("Login");
        genderString = getIntent().getStringExtra("gender");
        ageString = getIntent().getStringExtra("age");

        for(int i = 0 ;i<loginString.length;i++) {
            Log.d("tag2", "loginString(" + i + ")==>" + loginString[i]);
        }
    }

    private void findCurrentDate() {
        calendar = java.util.Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        currentDateString = dateFormat.format(calendar.getTime());
        Log.d("10AprilV1", "currentDate" + currentDateString);
    }

    private void initialSpinner() {


        spinnerView = (Spinner) findViewById(R.id.spinner1);
        spinnerView2 = (Spinner) findViewById(R.id.spinner2);
        spinnerView3 = (Spinner) findViewById(R.id.spinner3);
        spinnerView4 = (Spinner) findViewById(R.id.spinner4);
        spinnerView5 = (Spinner) findViewById(R.id.spinner5);
        spinnerView6 = (Spinner) findViewById(R.id.spinner6);
        spinnerView7 = (Spinner) findViewById(R.id.spinner7);
        spinnerView8 = (Spinner) findViewById(R.id.spinner8);
        spinnerView9 = (Spinner) findViewById(R.id.spinner9);
        spinnerView10 = (Spinner) findViewById(R.id.spinner10);
        spinnerView11 = (Spinner) findViewById(R.id.spinner11);
        spinnerView12 = (Spinner) findViewById(R.id.spinner12);
        spinnerView13 = (Spinner) findViewById(R.id.spinner13);
        spinnerView14 = (Spinner) findViewById(R.id.spinner14);
        spinnerView15 = (Spinner) findViewById(R.id.spinner15);
        spinnerView16 = (Spinner) findViewById(R.id.spinner16);
        spinnerView17 = (Spinner) findViewById(R.id.spinner17);
        spinnerView18 = (Spinner) findViewById(R.id.spinner18);
        spinnerView19 = (Spinner) findViewById(R.id.spinner19);
        spinnerView20 = (Spinner) findViewById(R.id.spinner20);
        spinnerView21 = (Spinner) findViewById(R.id.spinner21);
        spinnerView22 = (Spinner) findViewById(R.id.spinner22);
        spinnerView23 = (Spinner) findViewById(R.id.spinner23);
        spinnerView24 = (Spinner) findViewById(R.id.spinner24);
        spinnerView25 = (Spinner) findViewById(R.id.spinner25);
        spinnerView26 = (Spinner) findViewById(R.id.spinner26);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(SnapActivity.this, android.R.layout.simple_list_item_1, spinnerValue);
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
        spinnerView26.setAdapter(adapter);


    }


    private void initialView() {

        button = (Button) findViewById(R.id.snap4);


    }

    @Override
    public void onClick(View v) {
        if (v == button) {
            //get value from edidtex


            getValueFromEdidtex();




            if (checkSpinner()) {
                //have space
                myAlert objMyAlert = new myAlert(SnapActivity.this);
                objMyAlert.myDialog(getResources().getString(R.string.title_havespace),
                        getResources().getString(R.string.message_havespece));
            } else {
                // check special
                checkSpecial(idString, loginString[3]);
                risk1 = Integer.parseInt(spn)+Integer.parseInt(spn2)+Integer.parseInt(spn3)+Integer.parseInt(spn4)+Integer.parseInt(spn5)
                        +Integer.parseInt(spn6)+Integer.parseInt(spn7)+Integer.parseInt(spn8)+Integer.parseInt(spn9);
                risk2 = Integer.parseInt(spn10) + Integer.parseInt(spn11) + Integer.parseInt(spn12) + Integer.parseInt(spn13)
                        + Integer.parseInt(spn14) + Integer.parseInt(spn15) + Integer.parseInt(spn16) + Integer.parseInt(spn17)
                        + Integer.parseInt(spn18);
                risk3 = Integer.parseInt(spn19) + Integer.parseInt(spn20) + Integer.parseInt(spn21) + Integer.parseInt(spn22) + Integer.parseInt(spn23)
                        + Integer.parseInt(spn24) + Integer.parseInt(spn25) + Integer.parseInt(spn26);

                uploadValueToServer();
                Log.d("23_5_60", "RISK ==>" + risk1+" "+risk2+" "+risk3);

            }


        }
    }

    private void getValueFromEdidtex() {
        spn = spinnerView.getSelectedItem().toString();
        tmpspn = spn;
        if(spn.equals("-")){
            spn = "-";
        }else if(spn.equals("ไม่เลย")){
            spn = "0";
        }else if(spn.equals("เล็กน้อย")){
            spn = "1";
        }else if(spn.equals("ค่อนข้างมาก")){
            spn = "2";
        }else {
            spn = "3";
        }

        spn2 = spinnerView2.getSelectedItem().toString();
        tmpspn2 = spn2;
        if(spn2.equals("-")){
            spn2 = "-";
        }else if(spn2.equals("ไม่เลย")){
            spn2 = "0";
        }else if(spn2.equals("เล็กน้อย")){
            spn2 = "1";
        }else if(spn2.equals("ค่อนข้างมาก")){
            spn2 = "2";
        }else {
            spn2 = "3";
        }
        spn3 = spinnerView3.getSelectedItem().toString();
        tmpspn3 = spn3;
        if(spn3.equals("-")){
            spn3 = "-";
        }else if(spn3.equals("ไม่เลย")){
            spn3 = "0";
        }else if(spn3.equals("เล็กน้อย")){
            spn3 = "1";
        }else if(spn3.equals("ค่อนข้างมาก")){
            spn3 = "2";
        }else {
            spn3 = "3";
        }
        spn4 = spinnerView4.getSelectedItem().toString();
        tmpspn4 = spn4;
        if(spn4.equals("-")){
            spn4 = "-";
        }else if(spn4.equals("ไม่เลย")){
            spn4 = "0";
        }else if(spn4.equals("เล็กน้อย")){
            spn4 = "1";
        }else if(spn4.equals("ค่อนข้างมาก")){
            spn4 = "2";
        }else {
            spn4 = "3";
        }
        spn5 = spinnerView5.getSelectedItem().toString();
        tmpspn5 = spn5;
        if(spn5.equals("-")){
            spn5 = "-";
        }else if(spn5.equals("ไม่เลย")){
            spn5 = "0";
        }else if(spn5.equals("เล็กน้อย")){
            spn5 = "1";
        }else if(spn5.equals("ค่อนข้างมาก")){
            spn5 = "2";
        }else {
            spn5 = "3";
        }
        spn6 = spinnerView6.getSelectedItem().toString();
        tmpspn6 = spn6;
        if(spn6.equals("-")){
            spn6 = "-";
        }else if(spn6.equals("ไม่เลย")){
            spn6 = "0";
        }else if(spn6.equals("เล็กน้อย")){
            spn6 = "1";
        }else if(spn6.equals("ค่อนข้างมาก")){
            spn6 = "2";
        }else {
            spn6 = "3";
        }
        spn7 = spinnerView7.getSelectedItem().toString();
        tmpspn7 = spn7;
        if(spn7.equals("-")){
            spn7 = "-";
        }else if(spn7.equals("ไม่เลย")){
            spn7 = "0";
        }else if(spn7.equals("เล็กน้อย")){
            spn7 = "1";
        }else if(spn7.equals("ค่อนข้างมาก")){
            spn7 = "2";
        }else {
            spn7 = "3";
        }
        spn8 = spinnerView8.getSelectedItem().toString();
        tmpspn8 = spn8;
        if(spn8.equals("-")){
            spn8 = "-";
        }else if(spn8.equals("ไม่เลย")){
            spn8 = "0";
        }else if(spn8.equals("เล็กน้อย")){
            spn8 = "1";
        }else if(spn8.equals("ค่อนข้างมาก")){
            spn8 = "2";
        }else {
            spn8 = "3";
        }
        spn9 = spinnerView9.getSelectedItem().toString();
        tmpspn9 = spn9;
        if(spn9.equals("-")){
            spn9 = "-";
        }else if(spn9.equals("ไม่เลย")){
            spn9 = "0";
        }else if(spn9.equals("เล็กน้อย")){
            spn9 = "1";
        }else if(spn9.equals("ค่อนข้างมาก")){
            spn9 = "2";
        }else {
            spn9 = "3";
        }
        spn10 = spinnerView10.getSelectedItem().toString();
        tmpspn10 = spn10;
        if(spn10.equals("-")){
            spn10 = "-";
        }else if(spn10.equals("ไม่เลย")){
            spn10 = "0";
        }else if(spn10.equals("เล็กน้อย")){
            spn10 = "1";
        }else if(spn10.equals("ค่อนข้างมาก")){
            spn10 = "2";
        }else {
            spn10 = "3";
        }
        spn11 = spinnerView11.getSelectedItem().toString();
        tmpspn11 = spn11;
        if(spn11.equals("-")){
            spn11 = "-";
        }else if(spn11.equals("ไม่เลย")){
            spn11 = "0";
        }else if(spn11.equals("เล็กน้อย")){
            spn11 = "1";
        }else if(spn11.equals("ค่อนข้างมาก")){
            spn11 = "2";
        }else {
            spn11 = "3";
        }
        spn12 = spinnerView12.getSelectedItem().toString();
        tmpspn12 = spn12;
        if(spn12.equals("-")){
            spn12 = "-";
        }else if(spn12.equals("ไม่เลย")){
            spn12 = "0";
        }else if(spn12.equals("เล็กน้อย")){
            spn12 = "1";
        }else if(spn12.equals("ค่อนข้างมาก")){
            spn12 = "2";
        }else {
            spn12 = "3";
        }
        spn13 = spinnerView13.getSelectedItem().toString();
        tmpspn13 = spn13;
        if(spn13.equals("-")){
            spn13 = "-";
        }else if(spn13.equals("ไม่เลย")){
            spn13 = "0";
        }else if(spn13.equals("เล็กน้อย")){
            spn13 = "1";
        }else if(spn13.equals("ค่อนข้างมาก")){
            spn13 = "2";
        }else {
            spn13 = "3";
        }
        spn14 = spinnerView14.getSelectedItem().toString();
        tmpspn14 = spn14;
        if(spn14.equals("-")){
            spn14 = "-";
        }else if(spn14.equals("ไม่เลย")){
            spn14 = "0";
        }else if(spn14.equals("เล็กน้อย")){
            spn14 = "1";
        }else if(spn14.equals("ค่อนข้างมาก")){
            spn14 = "2";
        }else {
            spn14 = "3";
        }
        spn15 = spinnerView15.getSelectedItem().toString();
        tmpspn15 = spn15;
        if(spn15.equals("-")){
            spn15 = "-";
        }else if(spn15.equals("ไม่เลย")){
            spn15 = "0";
        }else if(spn15.equals("เล็กน้อย")){
            spn15 = "1";
        }else if(spn15.equals("ค่อนข้างมาก")){
            spn15 = "2";
        }else {
            spn15 = "3";
        }
        spn16 = spinnerView16.getSelectedItem().toString();
        tmpspn16 = spn16;
        if(spn16.equals("-")){
            spn16 = "-";
        }else if(spn16.equals("ไม่เลย")){
            spn16 = "0";
        }else if(spn16.equals("เล็กน้อย")){
            spn16 = "1";
        }else if(spn16.equals("ค่อนข้างมาก")){
            spn16 = "2";
        }else {
            spn16 = "3";
        }
        spn17 = spinnerView17.getSelectedItem().toString();
        tmpspn17 = spn17;
        if(spn17.equals("-")){
            spn17 = "-";
        }else if(spn17.equals("ไม่เลย")){
            spn17 = "0";
        }else if(spn17.equals("เล็กน้อย")){
            spn17 = "1";
        }else if(spn17.equals("ค่อนข้างมาก")){
            spn17 = "2";
        }else {
            spn17 = "3";
        }
        spn18 = spinnerView18.getSelectedItem().toString();
        tmpspn18 = spn18;
        if(spn18.equals("-")){
            spn18 = "-";
        }else if(spn18.equals("ไม่เลย")){
            spn18 = "0";
        }else if(spn18.equals("เล็กน้อย")){
            spn18 = "1";
        }else if(spn18.equals("ค่อนข้างมาก")){
            spn18 = "2";
        }else {
            spn18 = "3";
        }
        spn19 = spinnerView19.getSelectedItem().toString();
        tmpspn19 = spn19;
        if(spn19.equals("-")){
            spn19 = "-";
        }else if(spn19.equals("ไม่เลย")){
            spn19 = "0";
        }else if(spn19.equals("เล็กน้อย")){
            spn19 = "1";
        }else if(spn19.equals("ค่อนข้างมาก")){
            spn19 = "2";
        }else {
            spn19 = "3";
        }
        spn20 = spinnerView20.getSelectedItem().toString();
        tmpspn20 = spn20;
        if(spn20.equals("-")){
            spn20= "-";
        }else if(spn20.equals("ไม่เลย")){
            spn20 = "0";
        }else if(spn20.equals("เล็กน้อย")){
            spn20 = "1";
        }else if(spn20.equals("ค่อนข้างมาก")){
            spn20 = "2";
        }else {
            spn20 = "3";
        }
        spn21 = spinnerView21.getSelectedItem().toString();
        tmpspn21 = spn21;
        if(spn21.equals("-")){
            spn21= "-";
        }else if(spn21.equals("ไม่เลย")){
            spn21 = "0";
        }else if(spn21.equals("เล็กน้อย")){
            spn21 = "1";
        }else if(spn21.equals("ค่อนข้างมาก")){
            spn21 = "2";
        }else {
            spn21 = "3";
        }
        spn22 = spinnerView22.getSelectedItem().toString();
        tmpspn22 = spn22;
        if(spn22.equals("-")){
            spn22= "-";
        }else if(spn22.equals("ไม่เลย")){
            spn22 = "0";
        }else if(spn22.equals("เล็กน้อย")){
            spn22 = "1";
        }else if(spn22.equals("ค่อนข้างมาก")){
            spn22 = "2";
        }else {
            spn22 = "3";
        }
        spn23 = spinnerView23.getSelectedItem().toString();
        tmpspn23 = spn23;
        if(spn23.equals("-")){
            spn23= "-";
        }else if(spn23.equals("ไม่เลย")){
            spn23 = "0";
        }else if(spn23.equals("เล็กน้อย")){
            spn23 = "1";
        }else if(spn23.equals("ค่อนข้างมาก")){
            spn23 = "2";
        }else {
            spn23 = "3";
        }
        spn24 = spinnerView24.getSelectedItem().toString();
        tmpspn24 = spn24;
        if(spn24.equals("-")){
            spn24= "-";
        }else if(spn24.equals("ไม่เลย")){
            spn24 = "0";
        }else if(spn24.equals("เล็กน้อย")){
            spn24 = "1";
        }else if(spn24.equals("ค่อนข้างมาก")){
            spn24 = "2";
        }else {
            spn24 = "3";
        }
        spn25 = spinnerView25.getSelectedItem().toString();
        tmpspn25 = spn25;
        if(spn25.equals("-")){
            spn25= "-";
        }else if(spn25.equals("ไม่เลย")){
            spn25 = "0";
        }else if(spn25.equals("เล็กน้อย")){
            spn25 = "1";
        }else if(spn25.equals("ค่อนข้างมาก")){
            spn25 = "2";
        }else {
            spn25 = "3";
        }
        spn26 = spinnerView26.getSelectedItem().toString();
        tmpspn26 = spn26;
        if(spn26.equals("-")){
            spn26= "-";
        }else if(spn26.equals("ไม่เลย")){
            spn26 = "0";
        }else if(spn26.equals("เล็กน้อย")){
            spn26 = "1";
        }else if(spn26.equals("ค่อนข้างมาก")){
            spn26 = "2";
        }else {
            spn26 = "3";
        }
    }

    private void checkSpecial(String childID, String doType) {
        try {
            MyConstant myConstant = new MyConstant();
            String urlPhp = myConstant.getUrlEditSpecial();

            EditSpecial editSpecial = new EditSpecial(SnapActivity.this);
            editSpecial.execute(childID, doType, urlPhp);

            Log.d("16AprilV2", "Result ==>" + editSpecial.get());

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
                spn25.equals("-")|| spn26.equals("-") ) {
            return true;



        } else {
            return false;
        }


    }

    private void uploadValueToServer() {
        //wait type string
        try {

            MyConstant myConstant = new MyConstant();
            String strURL = myConstant.getUrlAddTest();

            PostTest postTest = new PostTest(SnapActivity.this);
            postTest.execute(spn, spn2, spn3, spn4, spn5,
                    spn6, spn7, spn8, spn9, spn10,
                    spn11, spn12, spn13, spn14, spn15,
                    spn16, spn17, spn18, spn19, spn20,
                    spn21, spn22, spn23, spn24, spn25,
                    spn26, loginString[0], idString,
                    Integer.toString(risk1), Integer.toString(risk2), Integer.toString(risk3),
                    loginString[3], currentDateString, strURL);

            Log.d(tag, "Result ==>" + postTest.get());


            if (Boolean.parseBoolean((postTest.get()))) {
                Intent intent = new Intent(SnapActivity.this,riskSnapActivity.class);
                intent.putExtra("Login", loginString);
                intent.putExtra("tmpIndex", idString);
                intent.putExtra("gender", genderString);
                intent.putExtra("age", ageString);
                intent.putExtra("risk1", risk1);
                intent.putExtra("risk2",risk2);
                intent.putExtra("risk3",risk3);
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
                intent.putExtra("date",currentDateString);
                Log.d(tag, "Put from snap ==>" + risk1 + " " + risk2 + " " + risk3);
                startActivity(intent);

            } else {
                Toast.makeText(SnapActivity.this, "Cannot save user", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            Log.d(tag, "e upload ==>" + e.toString());
        }
    }
}//main class
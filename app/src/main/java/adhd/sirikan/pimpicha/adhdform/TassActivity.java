package adhd.sirikan.pimpicha.adhdform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TassActivity extends AppCompatActivity implements View.OnClickListener {
    String[] spinnerValue = {"-", "0", "1", "2","3"};
    private static String tag = "30MarchV1",tag2 = "16AprilV1";
    Button button;
    private  int risk1,risk2,risk3,trisk1,trisk2,trisk3;
    String spn,spn2,spn3,spn4,spn5,spn6,spn7,spn8,spn9,spn10,spn11,spn12,spn13,spn14,spn15,spn16,spn17,spn18,spn19,spn20,spn21
            ,spn22,spn23,spn24,spn25,spn26,spn27,spn28,spn29,spn30 ;
    Spinner spinThass1,spinThass2,spinThass3,spinThass4,spinThass5,spinThass6,spinThass7,spinThass8
            ,spinThass9,spinThass10,spinThass11,spinThass12,spinThass13,spinThass14,spinThass15,spinThass16
            ,spinThass17,spinThass18,spinThass19,spinThass20,spinThass21,spinThass22,spinThass23,spinThass24
            ,spinThass25,spinThass26,spinThass27,spinThass28,spinThass29,spinThass30;
    String idString,loginString[],genderString,ageString;

    private java.util.Calendar calendar;
    private String currentDateString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_thass);
            idString = getIntent().getStringExtra("tmpIndex");
            loginString = getIntent().getStringArrayExtra("Login");
            genderString = getIntent().getStringExtra("gender");
            ageString = getIntent().getStringExtra("age");
        Log.d(tag2, " t:" + idString + " L:" +loginString[3]+" g"+genderString+" a"+ageString);
            findCurrentDate();
            initialSpinner();
            initialView();
            button.setOnClickListener(TassActivity.this);
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


           spn = spinThass1.getSelectedItem().toString();
           spn2 = spinThass2.getSelectedItem().toString();
            spn3 = spinThass3.getSelectedItem().toString();
            spn4 = spinThass4.getSelectedItem().toString();
            spn5 = spinThass5.getSelectedItem().toString();
            spn6 = spinThass6.getSelectedItem().toString();
            spn7 = spinThass7.getSelectedItem().toString();
            spn8 = spinThass8.getSelectedItem().toString();
            spn9 = spinThass9.getSelectedItem().toString();
            spn10 = spinThass10.getSelectedItem().toString();
            spn11 = spinThass11.getSelectedItem().toString();
            spn12 = spinThass12.getSelectedItem().toString();
            spn13 = spinThass13.getSelectedItem().toString();
            spn14 = spinThass14.getSelectedItem().toString();
            spn15 = spinThass15.getSelectedItem().toString();
            spn16 = spinThass16.getSelectedItem().toString();
            spn17 = spinThass17.getSelectedItem().toString();
            spn18 = spinThass18.getSelectedItem().toString();
            spn19 = spinThass19.getSelectedItem().toString();
            spn20 = spinThass20.getSelectedItem().toString();
            spn21 = spinThass21.getSelectedItem().toString();
            spn22 = spinThass22.getSelectedItem().toString();
            spn23 = spinThass23.getSelectedItem().toString();
            spn24 = spinThass24.getSelectedItem().toString();
            spn25 = spinThass25.getSelectedItem().toString();
            spn26 = spinThass26.getSelectedItem().toString();
            spn27 = spinThass27.getSelectedItem().toString();
            spn28 = spinThass28.getSelectedItem().toString();
            spn29 = spinThass29.getSelectedItem().toString();
            spn30= spinThass30.getSelectedItem().toString();


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

                 }else if(age>=9&&age<=11){

                 }else if(age>=12&&age<=14){

                 }else if(age>=15&&age<=18){

                 }

             }



        }else{//ผู้หญิง gender==1
            if(type==1){ //ผู้ปกครอง เด็กหญิง ******************* ตารางหน้า 66
                if(age>=6&&age<9){

                }else if(age>=9&&age<=11){

                }else if(age>=12&&age<=14){

                }else if(age>=15&&age<=18){

                }

            }else{//ครู เด็กหญิง  ******************* ตารางหน้า 70
                if(age>=6&&age<9){

                }else if(age>=9&&age<=11){

                }else if(age>=12&&age<=14){

                }else if(age>=15&&age<=18){

                }

            }



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
            Log.d(tag2, "e checkSpecial ==>" + currentDateString + " " +Integer.toString(risk1));


            if (Boolean.parseBoolean((postTass.get()))) {
                finish();
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


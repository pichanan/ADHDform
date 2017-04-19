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
    private  int risk1,risk2,risk3;
    String spn,spn2,spn3,spn4,spn5,spn6,spn7,spn8,spn9,spn10,spn11,spn12,spn13,spn14,spn15,spn16,spn17,spn18,spn19,spn20,spn21
            ,spn22,spn23,spn24,spn25,spn26,spn27,spn28,spn29,spn30 ;
    Spinner spinThass1,spinThass2,spinThass3,spinThass4,spinThass5,spinThass6,spinThass7,spinThass8
            ,spinThass9,spinThass10,spinThass11,spinThass12,spinThass13,spinThass14,spinThass15,spinThass16
            ,spinThass17,spinThass18,spinThass19,spinThass20,spinThass21,spinThass22,spinThass23,spinThass24
            ,spinThass25,spinThass26,spinThass27,spinThass28,spinThass29,spinThass30;
    String idString,loginString[];

    private java.util.Calendar calendar;
    private String currentDateString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_thass);
            idString = getIntent().getStringExtra("tmpIndex");
            loginString = getIntent().getStringArrayExtra("Login");
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
                risk1 = Integer.parseInt(spn)+Integer.parseInt(spn2)+Integer.parseInt(spn3)+Integer.parseInt(spn4)+Integer.parseInt(spn5)
                        +Integer.parseInt(spn6)+Integer.parseInt(spn7)+Integer.parseInt(spn8)+Integer.parseInt(spn9)+
                        Integer.parseInt(spn10) + Integer.parseInt(spn11) + Integer.parseInt(spn12) + Integer.parseInt(spn13)
                        + Integer.parseInt(spn14) + Integer.parseInt(spn15);
                risk2 =  + Integer.parseInt(spn16) + Integer.parseInt(spn17)
                        + Integer.parseInt(spn18)+Integer.parseInt(spn19) + Integer.parseInt(spn20)
                        + Integer.parseInt(spn21) + Integer.parseInt(spn22) + Integer.parseInt(spn23)
                        + Integer.parseInt(spn24) + Integer.parseInt(spn25) + Integer.parseInt(spn26)
                        + Integer.parseInt(spn27)+ Integer.parseInt(spn28)+ Integer.parseInt(spn29)
                        + Integer.parseInt(spn30);
                risk3 = risk1+risk2;
                uploadValueToServer();

            }






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
                    Integer.toString(risk1), Integer.toString(risk2), Integer.toString(risk3),
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


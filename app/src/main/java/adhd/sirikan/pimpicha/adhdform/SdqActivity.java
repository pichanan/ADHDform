package adhd.sirikan.pimpicha.adhdform;

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

public class SdqActivity extends AppCompatActivity implements View.OnClickListener {
    Spinner spinnerView, spinnerView2, spinnerView3, spinnerView4, spinnerView5, spinnerView6,
            spinnerView7, spinnerView8, spinnerView9, spinnerView10,
            spinnerView11, spinnerView12, spinnerView13, spinnerView14,
            spinnerView15, spinnerView16, spinnerView17, spinnerView18,
            spinnerView19, spinnerView20, spinnerView21, spinnerView22,
            spinnerView23, spinnerView24, spinnerView25, spinnerView26;

    String spn, spn2, spn3, spn4, spn5, spn6, spn7, spn8, spn9, spn10, spn11, spn12, spn13, spn14,
            spn15, spn16, spn17, spn18, spn19, spn20, spn21, spn22, spn23, spn24, spn25, spn26;

    String[] spinnerValue = {"-", "0", "1", "2", "3"};
    private static String tag = "30MarchV1",tag2 = "16AprilV1";
    private  int risk1,risk2,risk3;
    String idString, loginString[],genderString;
    TextView textView;
    Button button;

    private java.util.Calendar calendar;
    private String currentDateString;

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
    }

    private void findCurrentDate() {
        calendar = java.util.Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        currentDateString = dateFormat.format(calendar.getTime());
        Log.d("10AprilV1", "currentDate" + currentDateString);
    }

    private void initialView() {
        button = (Button) findViewById(R.id.sdq4);
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

        for(int i = 0 ;i<loginString.length;i++) {
            Log.d("tag2", "loginString(" + i + ")==>" + loginString[i]);
        }
    }


    public void onClick(View v) {
        if (v == button) {
            //get value from edidtex


            spn = spinnerView.getSelectedItem().toString();
            spn2 = spinnerView2.getSelectedItem().toString();
            spn3 = spinnerView3.getSelectedItem().toString();
            spn4 = spinnerView4.getSelectedItem().toString();
            spn5 = spinnerView5.getSelectedItem().toString();
            spn6 = spinnerView6.getSelectedItem().toString();
            spn7 = spinnerView7.getSelectedItem().toString();
            spn8 = spinnerView8.getSelectedItem().toString();
            spn9 = spinnerView9.getSelectedItem().toString();
            spn10 = spinnerView10.getSelectedItem().toString();
            spn11 = spinnerView11.getSelectedItem().toString();
            spn12 = spinnerView12.getSelectedItem().toString();
            spn13 = spinnerView13.getSelectedItem().toString();
            spn14 = spinnerView14.getSelectedItem().toString();
            spn15 = spinnerView15.getSelectedItem().toString();
            spn16 = spinnerView16.getSelectedItem().toString();
            spn17 = spinnerView17.getSelectedItem().toString();
            spn18 = spinnerView18.getSelectedItem().toString();
            spn19 = spinnerView19.getSelectedItem().toString();
            spn20 = spinnerView20.getSelectedItem().toString();
            spn21 = spinnerView21.getSelectedItem().toString();
            spn22 = spinnerView22.getSelectedItem().toString();
            spn23 = spinnerView23.getSelectedItem().toString();
            spn24 = spinnerView24.getSelectedItem().toString();
            spn25 = spinnerView25.getSelectedItem().toString();



            if (checkSpinner()) {
                //have space
                myAlert objMyAlert = new myAlert(SdqActivity.this);
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
                        + Integer.parseInt(spn24) + Integer.parseInt(spn25) ;
                uploadValueToServer();

            }


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
                    Integer.toString(risk1),
                    loginString[3], currentDateString, strURL);

            Log.d(tag, "Result ==>" + postSdq.get());

            if (Boolean.parseBoolean((postSdq.get()))) {
                finish();
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

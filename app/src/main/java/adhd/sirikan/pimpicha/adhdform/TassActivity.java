package adhd.sirikan.pimpicha.adhdform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class TassActivity extends AppCompatActivity implements View.OnClickListener {
    String[] spinnerValue = {"-", "0", "1", "2","3"};
    Button button;
    String spn,spn2,spn3,spn4,spn5,spn6,spn7,spn8,spn9,spn10,spn11,spn12,spn13,spn14,spn15,spn16,spn17,spn18,spn19,spn20,spn21
            ,spn22,spn23,spn24,spn25,spn26,spn27,spn28,spn29,spn30 ;
    Spinner spinThass1,spinThass2,spinThass3,spinThass4,spinThass5,spinThass6,spinThass7,spinThass8
            ,spinThass9,spinThass10,spinThass11,spinThass12,spinThass13,spinThass14,spinThass15,spinThass16
            ,spinThass17,spinThass18,spinThass19,spinThass20,spinThass21,spinThass22,spinThass23,spinThass24
            ,spinThass25,spinThass26,spinThass27,spinThass28,spinThass29,spinThass30;
    String idString,loginString[];
    String a="c",b="d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_thass);
            idString = getIntent().getStringExtra("tmpIndex");
            loginString = getIntent().getStringArrayExtra("Login");
            initialSpinner();
            initialView();
            button.setOnClickListener(TassActivity.this);
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




                uploadValueToServer();




        }

    }

    private void uploadValueToServer() {
        try {

            MyConstant myConstant = new MyConstant();
            String strURL = myConstant.getUrlAddTass();

            PostTass postTass = new PostTass(TassActivity.this);
            postTass.execute(spn,spn2,spn3,spn4,spn5,spn6,spn7,spn8,spn9, spn10,spn11,spn12,spn13,spn14, spn15,spn16,spn17,spn18,
                    spn19,spn20,spn21,spn22, spn23,spn24,spn25,spn26,spn27,spn28,spn29,spn30,loginString[0],idString,strURL);



            if (Boolean.parseBoolean((postTass.get()))) {
                finish();
            }else{
                Toast.makeText(TassActivity.this,"Cannot save user",Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {

        }
    }
}


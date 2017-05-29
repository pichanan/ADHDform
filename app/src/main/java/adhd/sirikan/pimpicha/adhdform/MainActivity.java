package adhd.sirikan.pimpicha.adhdform;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //explicit
    private EditText userEditText, passwordEditText;
    private TextView textView,textAppname;
    private Button button,btnCompare;
    private String userString,passString;
    private String[] loginStrings;
    private boolean aBoolean = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initial widget
        initialWidget();



        //controller
        controller();


//


    }// main method



    private void controller() {
        textView.setOnClickListener(MainActivity.this);
        button.setOnClickListener(MainActivity.this);




    }

    private void initialWidget() {
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtpassword);
        textView = (TextView) findViewById(R.id.txtNewRegister);
        textAppname = (TextView) findViewById(R.id.textAppname);
        button = (Button) findViewById(R.id.btnLogin);

    }

    @Override
    public void onClick(View v) {
        //for textView
        if (v == textView) {
            startActivity(new Intent(MainActivity.this, RegisterActivity.class));

        }
        //for Button
        if (v == button) {
            // get value from Edit text
            userString = userEditText.getText().toString().trim();
            passString = passwordEditText.getText().toString().trim();
            // check spece
            if (userString.equals("") || passString.equals("")) {
                //have space
                myAlert myAlert = new myAlert(MainActivity.this);
                String s = "พบช่องว่าง";
                String s1 = "กรุณากรอกข้อมูลให้ครบ";
                myAlert.myDialog(s, s1);
            } else {
                //no space
                checkAuthen();
            }
        }






    }//onclick

    private void checkAuthen() {
        try {

            MyConstant myConstant = new MyConstant();
            String strURL = myConstant.getUrlGetUser();
            String[] columnStrings = myConstant.getColumnUser();
            myAlert objMyAlert = new myAlert(MainActivity.this);

            GetAllData getAllData = new GetAllData(MainActivity.this);
            getAllData.execute(strURL);
            String strJSON = getAllData.get();
            Log.d("30MarchV2", "JSoN ==> " + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);
            for (int i=0;i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (userString.equals(jsonObject.getString(columnStrings[1]))) { // แนวนอน
                    loginStrings = new String[columnStrings.length];
                    for (int i1=0;i1<loginStrings.length;i1++) {
                        loginStrings[i1] = jsonObject.getString(columnStrings[i1]);
                        Log.d("30MarchV2", "loginStrings(" + i1 + ") ==> " + loginStrings[i1]);
                    }   //for
                    aBoolean = false;
                }   // if
            }   //for

            if (aBoolean) {
                //User False
                objMyAlert.myDialog("ไม่พบผู้ใช้",
                        "ไม่มีผู้ใช้ชื่อนี้อยู่ในระบบ");
            }else if(!(passString.equals(loginStrings[2]))){ //if pw false
                objMyAlert.myDialog("รหัสผ่านไม่ถูกต้อง",
                        "รหัสผ่านนี้ไม่ถูกต้อง กรุณาใส่รหัสผ่านใหม่อีกครั้ง");

            }else{
                //pass fail
                Intent intent = new Intent(MainActivity.this,AfterLoginActivity.class);
                intent.putExtra("Login", loginStrings);
                startActivity(intent);
                finish(); // protect back login
            }

        } catch (Exception e) {
            Log.d("30MarchV2", "e checkAuthen ==> " + e.toString());
        }
    }





}//main class
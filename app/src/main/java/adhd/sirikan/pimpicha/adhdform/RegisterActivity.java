package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    // explicit
    private EditText userEditText, passEditText;
    private RadioGroup radioGroup;
    private RadioButton teacherRadioButton, parentRadioButton;
    private Button button;
    private String userString, passwordString, typeString;
    private static String tag = "30MarchV1";
    boolean aBoolean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //initial view
        initialView();

        //btn controller
        button.setOnClickListener(RegisterActivity.this);
        //Radio controller
        radioController();
    }//main method

    private void radioController() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                switch (checkedId) {
                    case R.id.radTeacher:
                        typeString = "0";
                        break
                                ;
                    case R.id.radParent:
                        typeString = "1";
                        break;

                }
            }
        });
    }

    private void initialView() {
        userEditText = (EditText) findViewById(R.id.edtUser);
        passEditText = (EditText) findViewById(R.id.edtPassword);
        radioGroup = (RadioGroup) findViewById(R.id.ragType);
        teacherRadioButton = (RadioButton) findViewById(R.id.radTeacher);
        parentRadioButton = (RadioButton) findViewById(R.id.radParent);
        button = (Button) findViewById(R.id.btnSave);


    }

    @Override
    public void onClick(View v) {
        if (v == button) {
            //get value from edidtex
            userString = userEditText.getText().toString().trim();
            passwordString = passEditText.getText().toString().trim();
            if (userString.equals("") || passwordString.equals("")) {
                //have space
                myAlert objMyAlert = new myAlert(RegisterActivity.this);
                objMyAlert.myDialog(getResources().getString(R.string.title_havespace),
                        getResources().getString(R.string.message_havespece));
            } else if (!(teacherRadioButton.isChecked() || parentRadioButton.isChecked())) {
                //non check
                myAlert objMyAlert = new myAlert(RegisterActivity.this);
                objMyAlert.myDialog(getResources().getString(R.string.title_nonset),
                        getResources().getString(R.string.message_noncheck));

            } else {// checked
                checkAuthen();




            }


        }
    }

    private void uploadValueToServer() {
        //wait type string
        try {
            Log.d(tag, "User ==>" + userString);
            Log.d(tag, "Password ==>" + passwordString);
            Log.d(tag, "Type ==>" + typeString);

            MyConstant myConstant = new MyConstant();
            String strURL = myConstant.getUrlAddUser();

            PostUser postUser = new PostUser(RegisterActivity.this);
            postUser.execute(userString, passwordString,typeString,strURL);

            Log.d(tag, "Result ==>" + postUser.get());

            if (Boolean.parseBoolean((postUser.get()))) {
                finish();
            }else{
                Toast.makeText(RegisterActivity.this,"Cannot save user",Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            Log.d(tag, "e upload ==>" + e.toString());
        }
    }

    private void checkAuthen() {
        try {

            MyConstant myConstant = new MyConstant();
            String strURL = myConstant.getUrlGetUser();
            String[] columnStrings = myConstant.getColumnUser();
            myAlert objMyAlert = new myAlert(RegisterActivity.this);

            GetAllData getAllData = new GetAllData(RegisterActivity.this);
            getAllData.execute(strURL);
            String strJSON = getAllData.get();
            Log.d("30MarchV2", "JSoN ==> " + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);
            for (int i=0;i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (userString.equals(jsonObject.getString(columnStrings[1]))) { // แนวนอน

                    aBoolean = false;
                }   // if
            }   //for

            if (aBoolean==false) {
                //User False
                objMyAlert.myDialog("ไม่สามารถใช้ชื่อนี้",
                        "คุณไม่สามารถใช้ชื่อนี้ เนื่องจากมีผู้ใช้ชื่อนี้แล้ว");
            }else{
                uploadValueToServer();
            }

        } catch (Exception e) {
            Log.d("30MarchV2", "e checkAuthen ==> " + e.toString());
        }
    }
}//main class

package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import org.json.JSONArray;
import org.json.JSONObject;

public class DeleteDoneActivity extends AppCompatActivity {
    private  String []  loginString;
    private  String genderString;
    private  String ageString;
    private String idString,urlPHPString;
    MyConstant myConstant;
    private String tag = "14MayV1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_delete_done);
        getValueFromIntent();
        mySetup();
        deleteChild();
        Intent intent = new Intent(DeleteDoneActivity.this,ServiceActivity.class);
        intent.putExtra("Login", loginString);
        startActivity(intent);

    }

    private void mySetup() {
        myConstant = new MyConstant();
        urlPHPString = myConstant.getUrlGetDeleteChild();
    }

    private void deleteChild() {
        try {
            getDataWhere objGetDataWhere = new getDataWhere(DeleteDoneActivity.this);
            objGetDataWhere.execute("id", idString, urlPHPString);

            String strjSoN = objGetDataWhere.get();
            Log.d(tag, "14 may ==> " + strjSoN);




        } catch (Exception e) {
            Log.d(tag, "14 may ==> " + " !!!!!");
        }
    }

    private void getValueFromIntent() {
        idString = getIntent().getStringExtra("tmpIndex"); // childID
        loginString = getIntent().getStringArrayExtra("Login"); // loginString[0]
        genderString = getIntent().getStringExtra("gender"); // loginString[5]
        ageString = getIntent().getStringExtra("age"); // loginString[3]

    }
}

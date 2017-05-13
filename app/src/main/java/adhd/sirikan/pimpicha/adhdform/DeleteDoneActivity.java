package adhd.sirikan.pimpicha.adhdform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DeleteDoneActivity extends AppCompatActivity {
    private  String []  loginString;
    private  String idString;
    private  String genderString;
    private  String ageString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_done);
        getValueFromIntent();
        deleteChild();
    }

    private void deleteChild() {
    }

    private void getValueFromIntent() {
        idString = getIntent().getStringExtra("tmpIndex"); // childID
        loginString = getIntent().getStringArrayExtra("Login"); // loginString[0]
        genderString = getIntent().getStringExtra("gender"); // loginString[5]
        ageString = getIntent().getStringExtra("age"); // loginString[3]

    }
}

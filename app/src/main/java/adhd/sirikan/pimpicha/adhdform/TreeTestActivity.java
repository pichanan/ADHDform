package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TreeTestActivity extends AppCompatActivity {
    private  String []  loginString;
    private  String idString,genderString,ageString,nameString;
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_test);
        idString = getIntent().getStringExtra("tmpIndex");
        loginString = getIntent().getStringArrayExtra("Login");
        genderString = getIntent().getStringExtra("gender");
        ageString = getIntent().getStringExtra("age");
        nameString = getIntent().getStringExtra("name");
        age = Integer.parseInt(ageString);
        Button btnSnap = (Button) findViewById(R.id.buttonSnap);
        Button btnThass = (Button) findViewById(R.id.buttonThass);
        Button btnSdq = (Button) findViewById(R.id.buttonSdq);
       btnSnap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TreeTestActivity.this, SnapActivity.class);
                intent.putExtra("Login", loginString);
                intent.putExtra("tmpIndex", idString);
                intent.putExtra("gender", genderString);
                intent.putExtra("age", ageString);
                intent.putExtra("name", nameString);
                startActivity(intent);
            }
        });
        btnThass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TreeTestActivity.this, TassActivity.class);
                intent.putExtra("Login", loginString);
                intent.putExtra("tmpIndex", idString);
                intent.putExtra("gender", genderString);
                intent.putExtra("age", ageString);
                intent.putExtra("name", nameString);
                startActivity(intent);
            }
        });
        btnSdq.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (age > 16) {
                    myAlert objMyAlert = new myAlert(TreeTestActivity.this);
                    objMyAlert.myDialog("อายุเกิน:","แบบประเมินนี้ใช้ประเมินเด็กอายุไม่เกิน 16 ปีค่ะ");
                }else{
                    Intent intent = new Intent(TreeTestActivity.this, SdqActivity.class);
                    intent.putExtra("Login", loginString);
                    intent.putExtra("tmpIndex", idString);
                    intent.putExtra("gender", genderString);
                    intent.putExtra("age", ageString);
                    intent.putExtra("name", nameString);
                    startActivity(intent);
                }

            }
        });


    }
}

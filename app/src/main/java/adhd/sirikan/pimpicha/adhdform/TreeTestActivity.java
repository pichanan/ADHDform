package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TreeTestActivity extends AppCompatActivity {
    private  String []  loginString;
    private  String idString,genderString,ageString;
    TextView userTextView,childNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_test);
        idString = getIntent().getStringExtra("tmpIndex");
        loginString = getIntent().getStringArrayExtra("Login");
        genderString = getIntent().getStringExtra("gender");
        ageString = getIntent().getStringExtra("age");
        childNameTextView = (TextView) findViewById(R.id.treeShowChild);
        childNameTextView.setText(idString);
        userTextView = (TextView) findViewById(R.id.treeUserName);
        userTextView.setText(loginString[1]);

        ImageView btnSnap = (ImageView) findViewById(R.id.buttonSnap);
        ImageView btnThass = (ImageView) findViewById(R.id.buttonThass);
        ImageView btnSdq = (ImageView) findViewById(R.id.buttonSdq);
       btnSnap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TreeTestActivity.this, SnapActivity.class);
                intent.putExtra("Login", loginString);
                intent.putExtra("tmpIndex", idString);
                intent.putExtra("gender", genderString);
                intent.putExtra("age", ageString);
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
                startActivity(intent);
            }
        });
        btnSdq.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TreeTestActivity.this, SdqActivity.class);
                intent.putExtra("Login", loginString);
                intent.putExtra("tmpIndex", idString);
                intent.putExtra("gender", genderString);
                intent.putExtra("age", ageString);
                startActivity(intent);
            }
        });


    }
}

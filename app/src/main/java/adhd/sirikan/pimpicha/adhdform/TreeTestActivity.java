package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TreeTestActivity extends AppCompatActivity {
    private  String []  loginString;
    private  String idString;
    TextView userTextView,childNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_test);
        idString = getIntent().getStringExtra("tmpIndex");
        loginString = getIntent().getStringArrayExtra("Login");
        childNameTextView = (TextView) findViewById(R.id.treeShowChild);
        childNameTextView.setText(idString);
        userTextView = (TextView) findViewById(R.id.treeUserName);
        userTextView.setText(loginString[1]);

        Button btnSnap = (Button) findViewById(R.id.buttonSnap);
        Button btnThass = (Button) findViewById(R.id.buttonThass);
        Button btnSdq = (Button) findViewById(R.id.buttonSdq);
       btnSnap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TreeTestActivity.this, SnapActivity.class);
                intent.putExtra("Login", loginString);
                intent.putExtra("tmpIndex", idString);
                startActivity(intent);
            }
        });
        btnThass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TreeTestActivity.this, TassActivity.class);
                intent.putExtra("Login", loginString);
                intent.putExtra("tmpIndex", idString);
                startActivity(intent);
            }
        });
        btnSdq.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TreeTestActivity.this, TassActivity.class);
                intent.putExtra("Login", loginString);
                intent.putExtra("tmpIndex", idString);
                startActivity(intent);
            }
        });


    }
}

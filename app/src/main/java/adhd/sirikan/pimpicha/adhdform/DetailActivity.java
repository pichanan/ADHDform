package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {
    private  String []  loginString;
    private  String idString;
    TextView userTextView,childNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        idString = getIntent().getStringExtra("tmpIndex");
        loginString = getIntent().getStringArrayExtra("Login");
        childNameTextView = (TextView) findViewById(R.id.detailShowChild);
        childNameTextView.setText(idString);
        userTextView = (TextView) findViewById(R.id.detailUserName);
        userTextView.setText(loginString[1]);


        Button btnTreetest = (Button) findViewById(R.id.btnDetail1);

        btnTreetest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, TreeTestActivity.class);
                intent.putExtra("Login", loginString);
                intent.putExtra("tmpIndex", idString);
                startActivity(intent);
            }
        });



    }





}

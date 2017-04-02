package adhd.sirikan.pimpicha.adhdform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        childNameTextView = (TextView) findViewById(R.id.txtChild);
        childNameTextView.setText(idString);


    }




}

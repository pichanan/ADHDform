package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView userTextView,typeTextView;
    private ImageView imageView;
    private ListView listView;
    private String[] loginString;
    private String[] showTypeStrings = new String[]{"Teacher","Children"};

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        InitialView();
        //get value
        loginString = getIntent().getStringArrayExtra("Login");

        //show view
        showView();
        //Image controller
        imageView.setOnClickListener(ServiceActivity.this);

    }//main method

    private void showView() {
        userTextView.setText(loginString[1]);
        typeTextView.setText(showTypeStrings[Integer.parseInt(loginString[3])]); // chang 0 1 from  to int
    }

    private void InitialView() {
        userTextView = (TextView) findViewById(R.id.txtUser);
        typeTextView = (TextView) findViewById(R.id.txtType);
        imageView = (ImageView) findViewById(R.id.imvChild);

        listView = (ListView) findViewById(R.id.livChild);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ServiceActivity.this,AddChildActivity.class);
        intent.putExtra("Login",loginString);
        startActivity(intent);

    }
}//main class

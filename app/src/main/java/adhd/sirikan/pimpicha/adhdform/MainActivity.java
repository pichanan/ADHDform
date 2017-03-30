package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //explicit
    private EditText userEditText, passwordEditText;
    private TextView textView;
    private Button button;
    private String userString,passString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initial widget
        initialWidget();
        //controller
        controller();


    }// main method

    private void controller() {
        textView.setOnClickListener(MainActivity.this);
        button.setOnClickListener(MainActivity.this);
    }

    private void initialWidget() {
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtpassword);
        textView = (TextView) findViewById(R.id.txtNewRegister);
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
            userString= userEditText.getText().toString().trim();
            passString = passwordEditText.getText().toString().trim();
            // check spece
            if (userString.equals("")|| passString.equals("")) {
                //have space
                myAlert myAlert = new myAlert(MainActivity.this);
                String s = getResources().getString(R.string.title_havespace);
                String s1 = getResources().getString(R.string.message_havespece);
                myAlert.myDialog(s,s1);
            } else {
                //no space
            }
        }



    }//onclick
}//main class

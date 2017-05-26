package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

public class AfterLoginActivity extends AppCompatActivity {
    Button button,button2,button3;
    private String[] loginString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        getValue();
        createTabHost();
        button = (Button) findViewById(R.id.tesDetail);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AfterLoginActivity.this,ServiceActivity.class);
                intent.putExtra("Login", loginString);
                startActivity(intent);
            }
        });
        button2 = (Button) findViewById(R.id.graphDetail);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AfterLoginActivity.this,GraphActivity.class);
                intent.putExtra("Login", loginString);
                startActivity(intent);
            }
        });
        button3 = (Button) findViewById(R.id.graphDetail2);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AfterLoginActivity.this,Graph2Activity.class);
                intent.putExtra("Login", loginString);
                startActivity(intent);
            }
        });

    }

    private void getValue() {
        loginString = getIntent().getStringArrayExtra("Login");
    }


    private void createTabHost() {
        TabHost host = (TabHost)findViewById(R.id.tabHostAfter);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("สมาธิสั้นคืออะไร?");
        spec.setContent(R.id.tabAfter1);
        spec.setIndicator("สมาธิสั้นคืออะไร?");
        host.addTab(spec);


        //Tab 2
        spec = host.newTabSpec("แบบทดสอบสมาธิสั้นในเด็ก");
        spec.setContent(R.id.tabAfter2);
        spec.setIndicator("แบบทดสอบสมาธิสั้นในเด็ก");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("สถิติผลการทำแบบทดสอบ");
        spec.setContent(R.id.tabAfter3);
        spec.setIndicator("สถิติผลการทำแบบทดสอบ");

        host.addTab(spec);

    }


}

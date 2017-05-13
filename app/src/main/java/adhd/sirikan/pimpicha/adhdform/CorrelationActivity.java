package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CorrelationActivity extends AppCompatActivity {
    private Button btTeacher, btParent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correlation);
        initialView();
        btTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CorrelationActivity.this, GraphActivity.class));
            }
        });
        btParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CorrelationActivity.this, Graph2Activity.class));
            }
        });
    }

    private void initialView() {
        btTeacher = (Button) findViewById(R.id.correTeacher);
        btParent = (Button) findViewById(R.id.correParent);
    }
}
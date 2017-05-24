package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecommendActivity extends AppCompatActivity {
    Button button;
    String loginString[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);
        button = (Button) findViewById(R.id.backService);
        loginString = getIntent().getStringArrayExtra("Login");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecommendActivity.this, ServiceActivity.class);
                intent.putExtra("Login", loginString);
                startActivity(intent);
            }
        });
    }
}

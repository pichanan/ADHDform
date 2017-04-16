package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;


public class DetailActivity extends AppCompatActivity {
    private  String []  loginString;
    private  String idString;
    TextView userTextView,childNameTextView;
    private String tag = "16AprilV4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //get value from Intent
        getValueFromIntent();

        //Initial View and show
        initialViewAndShow();

        // Button Controller
        buttonController();
        createTabHost();

        // Create ListView Table1
        createListViewTable1();



    }// main method

    private void createListViewTable1() {
        try {

            Log.d(tag, "ChilID ==>" + idString);
            Log.d(tag, "userID ==>" + loginString[0]);

            MyConstant myConstant = new MyConstant();
            String urlPHP = myConstant.getUrlGetChildWhereID();


            GetTestwhereChildAndUser getTestwhereChildAndUser = new GetTestwhereChildAndUser(DetailActivity.this);
            getTestwhereChildAndUser.execute(idString,loginString[0], urlPHP);

            String strJSON = getTestwhereChildAndUser.get();


            JSONArray jsonArray = new JSONArray(strJSON);
            String[] showDateStrings = new String[jsonArray.length()];
            for (int i=0;i<jsonArray.length();i++){

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                showDateStrings[i] = jsonObject.getString("CurrentDate");


            } // for
            // Create ListView
            ListView listView = (ListView) findViewById(R.id.liveTable1);
            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(DetailActivity.this,
                    android.R.layout.simple_list_item_1, showDateStrings);
            listView.setAdapter(stringArrayAdapter);



        } catch (Exception e) {
            Log.d(tag, "e table1 ==>" +e.toString());

        }
    }

    private void createTabHost() {
        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Tab One");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Tab Two");

        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Tab Three");
        host.addTab(spec);
    }


    private void buttonController() {
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

    private void initialViewAndShow() {
        childNameTextView = (TextView) findViewById(R.id.detailShowChild);
        childNameTextView.setText(idString);
        userTextView = (TextView) findViewById(R.id.detailUserName);
        userTextView.setText(loginString[1]);
    }

    private void getValueFromIntent() {
        idString = getIntent().getStringExtra("tmpIndex"); // childID
        loginString = getIntent().getStringArrayExtra("Login"); // loginString[0]
    }


}

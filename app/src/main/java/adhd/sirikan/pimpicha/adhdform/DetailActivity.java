package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
        createListViewTable2();
        createListViewTable3();



    }// main method

    private void createListViewTable3() {
        try {

            Log.d(tag, "ChilID ==>" + idString);
            Log.d(tag, "userID ==>" + loginString[0]);

            MyConstant myConstant = new MyConstant();
            String urlPHP = myConstant.getUrlGetChildWhereID3();


            GetTestwhereChildAndUser3 getTestwhereChildAndUser3 = new GetTestwhereChildAndUser3(DetailActivity.this);
            getTestwhereChildAndUser3.execute(idString,loginString[0], urlPHP);

            String strJSON = getTestwhereChildAndUser3.get();


            JSONArray jsonArray = new JSONArray(strJSON);
            String[] showDateStrings = new String[jsonArray.length()];
            final String[] idStrings = new String[jsonArray.length()];


            for (int i=0;i<jsonArray.length();i++){

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                showDateStrings[i] = jsonObject.getString("CurrentDate");
                idStrings[i] = jsonObject.getString("id");



            } // for
            // Create ListView
            ListView listView = (ListView) findViewById(R.id.liveTable3);
            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(DetailActivity.this,
                    android.R.layout.simple_list_item_1, showDateStrings);
            listView.setAdapter(stringArrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.d(tag, "id =>" + idStrings[position]);

                    Intent intent = new Intent(DetailActivity.this, ShowChildDetail.class);
                    intent.putExtra("id", idStrings[position]);
                    startActivity(intent);

                }
            });



        } catch (Exception e) {
            Log.d(tag, "e table1 ==>" +e.toString());

        }
    }

    private void createListViewTable2() {
        try {

            Log.d(tag, "ChilID ==>" + idString);
            Log.d(tag, "userID ==>" + loginString[0]);

            MyConstant myConstant = new MyConstant();
            String urlPHP = myConstant.getUrlGetChildWhereID2(); // ต้องสร้าง php


            GetTestwhereChildAndUser2 getTestwhereChildAndUser2 = new GetTestwhereChildAndUser2(DetailActivity.this);
            getTestwhereChildAndUser2.execute(idString,loginString[0], urlPHP); //ไม่ต้อง

            String strJSON = getTestwhereChildAndUser2.get();


            JSONArray jsonArray = new JSONArray(strJSON);
            String[] showDateStrings = new String[jsonArray.length()];
            final String[] idStrings = new String[jsonArray.length()];


            for (int i=0;i<jsonArray.length();i++){

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                showDateStrings[i] = jsonObject.getString("CurrentDate");
                idStrings[i] = jsonObject.getString("id");



            } // for
            // Create ListView
            ListView listView = (ListView) findViewById(R.id.liveTable2);
            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(DetailActivity.this,
                    android.R.layout.simple_list_item_1, showDateStrings);
            listView.setAdapter(stringArrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.d(tag, "id =>" + idStrings[position]);

                    Intent intent = new Intent(DetailActivity.this, ShowChildDetail.class);
                    intent.putExtra("id", idStrings[position]);
                    startActivity(intent);

                }
            });



        } catch (Exception e) {
            Log.d(tag, "e table1 ==>" +e.toString());

        }
    }

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
            final String[] idStrings = new String[jsonArray.length()];


            for (int i=0;i<jsonArray.length();i++){

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                showDateStrings[i] = jsonObject.getString("CurrentDate");
                idStrings[i] = jsonObject.getString("id");



            } // for
            // Create ListView
            ListView listView = (ListView) findViewById(R.id.liveTable1);
            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(DetailActivity.this,
                    android.R.layout.simple_list_item_1, showDateStrings);
            listView.setAdapter(stringArrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.d(tag, "id =>" + idStrings[position]);

                    Intent intent = new Intent(DetailActivity.this, ShowChildDetail.class);
                    intent.putExtra("id", idStrings[position]);
                    startActivity(intent);

                }
            });



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

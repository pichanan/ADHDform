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
    private  String genderString;
    private  String ageString;
    private  String nameString;
    private  boolean check1=true,check2=true, check3=true;
    private int cnt1=0,cnt2=0, cnt3=0;
    TextView userTextView,childNameTextView;
    private String tag = "16AprilV4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //get value from Intent
        getValueFromIntent();


        // Button Controller
        buttonController();


        // Create ListView Table1
        createListViewTable1();
        createListViewTable2();
        createListViewTable3();


       /* if (check1 == 0 && check2 == 0 && check3 == 0) {
            myAlert objMyAlert = new myAlert(DetailActivity.this);
            objMyAlert.myDialog("ไม่พบประวัติการทำแบบประเมิน",
                    "คุณยังไม่เคยทำแบบประเมินใดในเด็กคนนี้ กรุณากดปุ่มเริ่มทำแบบประเมินค่ะ");
            check1 = 1;
            check2 = 1;
            check3 = 1;
        }*/
        Log.d("23_5_60", "CHECK BOOL ==>" + check1+" " );



    }// main method

    @Override
    protected void onPostResume() {//**************************************
        super.onPostResume();
        createListViewTable1();
        createListViewTable2();
        createListViewTable3();
        if (check1 == true&&check2==true&&check3==true) {
            myAlert objMyAlert = new myAlert(DetailActivity.this);
            objMyAlert.myDialog("ไม่พบประวัติการทำแบบประเมิน",
                    "คุณยังไม่เคยทำแบบประเมินใดในเด็กคนนี้ กรุณากดปุ่มเริ่มทำแบบประเมินค่ะ");
        }
        createTabHost();


    }
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
            cnt3 = jsonArray.length();



            for (int i=0;i<jsonArray.length();i++){

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                showDateStrings[i] = jsonObject.getString("CurrentDate");
                idStrings[i] = jsonObject.getString("id");
                check3 = false;



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

                    Intent intent = new Intent(DetailActivity.this, ShowChildDetail3.class);
                    intent.putExtra("id", idStrings[position]);
                    intent.putExtra("Login", loginString);
                    intent.putExtra("tmpIndex", idString);
                    intent.putExtra("gender", genderString);
                    intent.putExtra("age", ageString);
                    intent.putExtra("name", nameString);


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

            cnt2 = jsonArray.length();
            for (int i=0;i<jsonArray.length();i++){

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                showDateStrings[i] = jsonObject.getString("CurrentDate");
                idStrings[i] = jsonObject.getString("id");
                check2 = false;


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

                    Intent intent = new Intent(DetailActivity.this, ShowChildDetail2.class);
                    intent.putExtra("id", idStrings[position]);
                    intent.putExtra("Login", loginString);
                    intent.putExtra("tmpIndex", idString);
                    intent.putExtra("gender", genderString);
                    intent.putExtra("age", ageString);
                    intent.putExtra("name", nameString);
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
            //final String[] snapCh1 = new String[jsonArray.length()];
            Log.d("23_5_60", "CHECK JS ==>" + jsonArray.length());
            cnt1 = jsonArray.length();
            for (int i=0;i<jsonArray.length();i++){

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                showDateStrings[i] = jsonObject.getString("CurrentDate");
                idStrings[i] = jsonObject.getString("id");
                //snapCh1[i] = jsonObject.getString("ch1");
                check1 = false;





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
                    intent.putExtra("Login", loginString);
                    intent.putExtra("tmpIndex", idString);
                    intent.putExtra("gender", genderString);
                    intent.putExtra("age", ageString);
                    intent.putExtra("name", nameString);

                    //intent.putExtra("ch1", snapCh1[position]);
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
        TabHost.TabSpec spec = host.newTabSpec("SNAP-IV"+"("+cnt1+")");
        spec.setContent(R.id.tab1);
        spec.setIndicator("SNAP-IV"+"("+cnt1+")");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("THASS"+"("+cnt2+")");
        spec.setContent(R.id.tab2);
        spec.setIndicator("THASS"+"("+cnt2+")");

        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("SDQ"+"("+cnt3+")");
        spec.setContent(R.id.tab3);
        spec.setIndicator("SDQ"+"("+cnt3+")");
        host.addTab(spec);
    }


    private void buttonController() {
       Button btnTreetest = (Button) findViewById(R.id.imvDetailTreeTest);
        ImageView btBack = (ImageView) findViewById(R.id.backfromDetail);
        btBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        btnTreetest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, TreeTestActivity.class);
                intent.putExtra("Login", loginString);
                intent.putExtra("tmpIndex", idString);
                intent.putExtra("gender", genderString);
                intent.putExtra("age", ageString);
                intent.putExtra("name", nameString);
                startActivity(intent);
            }
        });
    }



    private void getValueFromIntent() {
        idString = getIntent().getStringExtra("tmpIndex");
        loginString = getIntent().getStringArrayExtra("Login");
        genderString = getIntent().getStringExtra("gender");
        ageString = getIntent().getStringExtra("age");
        nameString = getIntent().getStringExtra("name");

    }


}

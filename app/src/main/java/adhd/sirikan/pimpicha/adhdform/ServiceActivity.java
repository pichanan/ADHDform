package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView userTextView,typeTextView;

    private ListView listView;
    private String[] loginString;
    private  ImageView imageView , graphImageView;

    private String[] showTypeStrings = new String[]{"Teacher","Parent"};
    private String tag = "31MarchV2";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        InitialView();
        //get value
        getValue();

        //show view
        showView();
        //Image controller
        imageController();



    }//main method

    private void imageController() {
        imageView.setOnClickListener(ServiceActivity.this);
        graphImageView.setOnClickListener(ServiceActivity.this);
    }

    private void getValue() {
        loginString = getIntent().getStringArrayExtra("Login");
    }

   @Override
    protected void onPostResume() {//**************************************
        super.onPostResume();
        createListView();
    }

    private void createListView() {


        try {
            GetAllData getAllData = new GetAllData(ServiceActivity.this);
            MyConstant myConstant = new MyConstant();
            getAllData.execute(myConstant.getUrlGetChild());

            String strJSON = getAllData.get();
            Log.d(tag, "JSoN ==>" + strJSON);

            String[] columnChileStrings = myConstant.getColumnChild();
            JSONArray jsonArray = new JSONArray(strJSON);
            final String[] idStrings = new String[jsonArray.length()];
            final String[] nameChildStrings = new String[jsonArray.length()];
            final String[] userString = new String[jsonArray.length()];
            final String[] genderStrings = new String[jsonArray.length()];
            final String[] ageStrings = new String[jsonArray.length()];
            String[] imageStrings = new String[jsonArray.length()];
            int j =0;
            for (int i = 0 ;i<jsonArray.length();i++) {


                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if(jsonObject.getString(columnChileStrings[1]).equals(loginString[0])){
                    userString[j] = jsonObject.getString(columnChileStrings[1]);
                    idStrings[j] = jsonObject.getString(columnChileStrings[0]);
                    nameChildStrings[j] = jsonObject.getString(columnChileStrings[2]);
                    imageStrings[j] = jsonObject.getString(columnChileStrings[4]);
                    genderStrings[j] = jsonObject.getString(columnChileStrings[5]);
                    ageStrings[j] = jsonObject.getString(columnChileStrings[3]);
                    j++;
                }


            }

            final String[] countChildString = new String[j];
            //Build ListView
            ChildAdapter childAdapter = new ChildAdapter(ServiceActivity.this, imageStrings,
                    nameChildStrings,countChildString);
            listView.setAdapter(childAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(ServiceActivity.this, DetailActivity.class);
                    intent.putExtra("Login", loginString);
                    intent.putExtra("tmpIndex", idStrings[position]);
                    intent.putExtra("gender", genderStrings[position]);
                    intent.putExtra("age", ageStrings[position]);
                    Log.d("16AprilV1", "GEN  ==> " +genderStrings[position] );
                    startActivity(intent);
                    // ไม่ต้อง หยุด เพราะจะให้ย้อนกลับได้
                }
            });


        } catch (Exception e) {
            Log.d(tag, "e createListView ==>" + e.toString());
        }

    }

    private void showView() {
        userTextView.setText(loginString[1]);
        typeTextView.setText(showTypeStrings[Integer.parseInt(loginString[3])]); // chang 0 1 from  to int
    }

    private void InitialView() {
        userTextView = (TextView) findViewById(R.id.txtUser);
        typeTextView = (TextView) findViewById(R.id.txtType);
        imageView = (ImageView) findViewById(R.id.imvChild);
        graphImageView = (ImageView) findViewById(R.id.imvGraph);
        listView = (ListView) findViewById(R.id.livChild);
    }

    @Override
    public void onClick(View v) {

        // for imageView
        if (v==imageView) {
            Intent intent = new Intent(ServiceActivity.this,AddChildActivity.class);
            intent.putExtra("Login",loginString);

            startActivity(intent);
        }

        //for graph
        if (v==graphImageView) {
            Intent intent = new Intent(ServiceActivity.this,CorrelationActivity.class);
            intent.putExtra("Login",loginString);
            startActivity(intent);
        }

    }
}//main class
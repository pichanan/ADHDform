package adhd.sirikan.pimpicha.adhdform;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GraphCompare3Activity extends AppCompatActivity {
    int risk1Int,cpRisk1;
    String tag = "graphSDQ";
    String idString, loginString[], genderString, ageString,date,nameString,dateToday;
    Button button;
    TextView t1, t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_compare3);
        getValueFromIntent();
        Log.d(tag, "select ==>" + date +" " +  cpRisk1 +risk1Int);
        button = (Button) findViewById(R.id.takeScreen3);
        t1 = (TextView) findViewById(R.id.txtDateToday3);
        t1.setText("ชื่อ :"+nameString+" , "+"เพศ :"+genderString+" , อายุ:"+ageString+"ปี\n"+"วันที่ปัจจุบัน :"+dateToday+"\n"+"วันที่ในอดีต :"+date);

        GraphView graph = (GraphView) findViewById(R.id.compareGraphSdq);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAlert objMyAlert = new myAlert(GraphCompare3Activity.this);
                objMyAlert.myDialog("พื้นที่จัดเก็บ","ในการบันทึกครั้งนี้ไฟล์จะถูกเก็บเป็นรูปภาพ ใน Device storage/Pictures");
                Bitmap bitmap = takeScreenshot();
                saveBitmap(bitmap);
            }
        });
        BarGraphSeries<DataPoint> barGraphSeries;

        barGraphSeries = new BarGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, 0),
                new DataPoint(1, risk1Int),
                new DataPoint(2, 0),


        });

        barGraphSeries.setColor(Color.BLUE);
        graph.addSeries(barGraphSeries);
        barGraphSeries = new BarGraphSeries<DataPoint>(new DataPoint[]{

                new DataPoint(3, cpRisk1),


        });

        barGraphSeries.setColor(Color.RED);
        graph.addSeries(barGraphSeries);


    }

    private void getValueFromIntent() {
        Bundle extras = getIntent().getExtras();
        idString = getIntent().getStringExtra("idString");
        loginString = getIntent().getStringArrayExtra("loginString");
        genderString = getIntent().getStringExtra("gender");
        ageString = getIntent().getStringExtra("age");
        nameString = getIntent().getStringExtra("name");
        risk1Int = extras.getInt("risk1Int");
        cpRisk1 = extras.getInt("cpRisk1");
        date = getIntent().getStringExtra("date");
        dateToday = getIntent().getStringExtra("dateToday");
        Log.d(tag, "Put from snap ==>" + risk1Int + " "+ cpRisk1 );

    }
    public Bitmap takeScreenshot() {
        View rootView = findViewById(android.R.id.content).getRootView();
        rootView.setDrawingCacheEnabled(true);
        return rootView.getDrawingCache();
    }

    public void saveBitmap(Bitmap bitmap) {
        File imagePath = new File(Environment.getExternalStorageDirectory() + "/Pictures"+"/SDQ_+"+dateToday+".jpg");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }
    }
}

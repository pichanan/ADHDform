package adhd.sirikan.pimpicha.adhdform;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class GraphCompare3Activity extends AppCompatActivity {
    int risk1Int,cpRisk1;
    String tag = "graphSDQ";
    String idString, loginString[], genderString, ageString,date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_compare3);
        getValueFromIntent();
        Log.d(tag, "select ==>" + date +" " +  cpRisk1 +risk1Int);
        GraphView graph = (GraphView) findViewById(R.id.compareGraphSdq);
        BarGraphSeries<DataPoint> barGraphSeries;

        barGraphSeries = new BarGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, 0),
                new DataPoint(1, risk1Int),
                new DataPoint(2, 0),


        });

        barGraphSeries.setColor(Color.RED);
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
        genderString = getIntent().getStringExtra("genderString");
        ageString = getIntent().getStringExtra("ageString");
        risk1Int = extras.getInt("risk1Int");
        cpRisk1 = extras.getInt("cpRisk1");
        date = getIntent().getStringExtra("date");
        Log.d(tag, "Put from snap ==>" + risk1Int + " "+ cpRisk1 );

    }
}

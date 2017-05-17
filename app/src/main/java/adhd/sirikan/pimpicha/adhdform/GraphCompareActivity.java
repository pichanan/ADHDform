package adhd.sirikan.pimpicha.adhdform;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class GraphCompareActivity extends AppCompatActivity {
    int risk1Int,risk2Int,risk3Int,cpRisk1,cpRisk2, cpRisk3;
    String idString, loginString[], genderString, ageString,date;
    String tag = "18_5";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_compare);
        getValueFromIntent();
        Log.d(tag, "select ==>" + date +" " +  cpRisk1 +" " + cpRisk2 +" " + cpRisk3+" " + risk1Int+
                " " + risk2Int+" " + risk3Int);
        GraphView graph = (GraphView) findViewById(R.id.compareGraph);
        BarGraphSeries<DataPoint> barGraphSeries;

        barGraphSeries = new BarGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, 0),
                new DataPoint(1, risk1Int),
                new DataPoint(2, cpRisk1),


        });

        barGraphSeries.setColor(Color.RED);
        graph.addSeries(barGraphSeries);

        barGraphSeries = new BarGraphSeries<DataPoint>(new DataPoint[]{

                new DataPoint(3, risk2Int),
                new DataPoint(4, cpRisk2),
                new DataPoint(5, risk3Int),
                new DataPoint(6, cpRisk3)

        });
        barGraphSeries.setColor(Color.GREEN);
        graph.addSeries(barGraphSeries);

        barGraphSeries = new BarGraphSeries<DataPoint>(new DataPoint[]{

                new DataPoint(5, risk3Int),
                new DataPoint(6, cpRisk3)

        });
        barGraphSeries.setColor(Color.BLUE);
        graph.addSeries(barGraphSeries);
    }

    private void getValueFromIntent() {
        Bundle extras = getIntent().getExtras();
        idString = getIntent().getStringExtra("idString");
        loginString = getIntent().getStringArrayExtra("loginString");
        genderString = getIntent().getStringExtra("genderString");
        ageString = getIntent().getStringExtra("ageString");
        risk1Int = extras.getInt("risk1Int");
        risk2Int = extras.getInt("risk2Int");
        risk3Int = extras.getInt("risk3Int");
        cpRisk1 = extras.getInt("cpRisk1");
        cpRisk2 = extras.getInt("cpRisk2");
        cpRisk3 = extras.getInt("cpRisk3");
        date = getIntent().getStringExtra("date");
        Log.d(tag, "Put from snap ==>" + risk1Int + " " + risk2Int + " " + risk3Int);

    }
}

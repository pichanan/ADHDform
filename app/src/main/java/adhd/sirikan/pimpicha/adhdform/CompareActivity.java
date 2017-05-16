package adhd.sirikan.pimpicha.adhdform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.jjoe64.graphview.*;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class CompareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        GraphView graph = (GraphView) findViewById(R.id.compareGraph);
        BarGraphSeries<DataPoint> barGraphSeries = new BarGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(1, 4),
                new DataPoint(2, 3),
                new DataPoint(3, 0),
                new DataPoint(4, 2),
                new DataPoint(5, 6)
        });

        graph.addSeries(barGraphSeries);
    }

}

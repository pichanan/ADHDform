package adhd.sirikan.pimpicha.adhdform;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONArray;
import org.json.JSONObject;

public class GraphActivity extends AppCompatActivity {

    private GraphView line_graph;
    private int[] colorLineInts = new int[]{Color.RED, Color.BLUE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);


        initialView();
        createLineGraph("0","risk1",colorLineInts[0]);
        createLineGraph("1","risk1",colorLineInts[1]);

    }//main method

    private void createLineGraph(String strDoType,
                                 String strColumn,
                                 int colorLineInt) {
        try{

            String tag = "15AprilV1";
            MyConstant myConstant = new MyConstant();
            String urlPHP = myConstant.getUrlGetUrlThestWhere();

            getDataWhere objGetDataWhere = new getDataWhere(GraphActivity.this);
            objGetDataWhere.execute("doType", strDoType, urlPHP);
            String strJSON = objGetDataWhere.get();
            Log.d(tag, "JSON ==>" + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);
            int intMaxX = jsonArray.length();
            Log.d(tag, "MaxX ==> "+ intMaxX);



            DataPoint[] dataPoints = new DataPoint[intMaxX];

            for (int i=0;i<intMaxX;i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                dataPoints[i] = new DataPoint(i ,Integer.parseInt(jsonObject.getString(strColumn)));





            }

            LineGraphSeries<DataPoint> line_series = new LineGraphSeries<DataPoint>(dataPoints);

            line_series.setColor(colorLineInt);
            line_graph.addSeries(line_series);

            // set manual X bounds
            line_graph.getViewport().setXAxisBoundsManual(true);
            line_graph.getViewport().setMinX(0.0);
            line_graph.getViewport().setMaxX(intMaxX);

            // set manual Y bounds
            line_graph.getViewport().setYAxisBoundsManual(true);
            line_graph.getViewport().setMinY(0.0);
            line_graph.getViewport().setMaxY(100);

            line_graph.getViewport().setScrollable(true);

        }catch (Exception e){
            Log.d("15AprilV1", "e createLine ==>" + e.toString());
        }
    }//create line

    private void initialView() {
        line_graph = (GraphView) findViewById(R.id.graph);
    }
}//main class

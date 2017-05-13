package adhd.sirikan.pimpicha.adhdform;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONArray;
import org.json.JSONObject;

public class Graph2Activity extends AppCompatActivity {
    double[] x,y,xr2,yr2;
    String tag = "15AprilV1",loginString[];
    int intMaxX1,intMaxX;
    TextView txtCorre,txtCorre2;
    private GraphView line_graph,line_graph2;
    private int[] colorLineInts = new int[]{Color.RED, Color.BLUE};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph2);
        loginString = getIntent().getStringArrayExtra("Login");
        initialView();
        //risk1**************************************/
        createLineGraphRed1("1","risk1",colorLineInts[0]);// snap risk1 Parent
        createLineGraphBlue1("1","risk1",colorLineInts[1]);//thass risk1 Parent

        //*risk2**************************************/
        createLineGraphRed2("1","risk2",colorLineInts[0]);// snap risk2 Parent
        createLineGraphBlue2("1","risk2",colorLineInts[1]);//thass risk2 Parent
        calCorre1();
        calCorre2();
    }

    private void calCorre2() {
        double r,nr=0,dr_1=0,dr_2=0,dr_3=0,dr=0;
        double xx[],xy[],yy[];
        xx =new double[intMaxX1];
        xy =new double[intMaxX1];
        yy =new double[intMaxX1];
        double sum_y=0,sum_yy=0,sum_xy=0,sum_x=0,sum_xx=0;
        int i,n=intMaxX1;
        for(i=0;i<n;i++)
        {
            xx[i]=xr2[i]*xr2[i];
            yy[i]=yr2[i]*yr2[i];
        }
        for(i=0;i<n;i++)
        {
            sum_x+=xr2[i];
            sum_y+=yr2[i];
            sum_xx+= xx[i];
            sum_yy+=yy[i];
            sum_xy+= xr2[i]*yr2[i];
        }
        nr=(n*sum_xy)-(sum_x*sum_y);
        double sum_x2=sum_x*sum_x;
        double sum_y2=sum_y*sum_y;
        dr_1=(n*sum_xx)-sum_x2;
        dr_2=(n*sum_yy)-sum_y2;
        dr_3=dr_1*dr_2;
        dr=Math.sqrt(dr_3);
        r=(nr/dr);
        String s = String.format("%.2f",r);
        r = Double.parseDouble(s);

        txtCorre2.setText(s);
    }

    private void calCorre1() {
        double r,nr=0,dr_1=0,dr_2=0,dr_3=0,dr=0;
        double xx[],xy[],yy[];
        xx =new double[intMaxX1];
        xy =new double[intMaxX1];
        yy =new double[intMaxX1];
        double sum_y=0,sum_yy=0,sum_xy=0,sum_x=0,sum_xx=0;
        int i,n=intMaxX1;
        for(i=0;i<n;i++)
        {
            xx[i]=x[i]*x[i];
            yy[i]=y[i]*y[i];
        }
        for(i=0;i<n;i++)
        {
            sum_x+=x[i];
            sum_y+=y[i];
            sum_xx+= xx[i];
            sum_yy+=yy[i];
            sum_xy+= x[i]*y[i];
        }
        nr=(n*sum_xy)-(sum_x*sum_y);
        double sum_x2=sum_x*sum_x;
        double sum_y2=sum_y*sum_y;
        dr_1=(n*sum_xx)-sum_x2;
        dr_2=(n*sum_yy)-sum_y2;
        dr_3=dr_1*dr_2;
        dr=Math.sqrt(dr_3);
        r=(nr/dr);
        String s = String.format("%.2f",r);
        r = Double.parseDouble(s);

        txtCorre.setText(s);


    }
    private void createLineGraphBlue2(String strDoType, String strColumn, int colorLineInt) {
        try{

            String tag = "15AprilV1";
            MyConstant myConstant = new MyConstant();
            String urlPHP2 = myConstant.getUrlGetUrlThestWhere2();

            getDataWhere objGetDataWhere = new getDataWhere(Graph2Activity.this);
            objGetDataWhere.execute("doType", strDoType, urlPHP2);
            String strJSON = objGetDataWhere.get();
            Log.d(tag, "JSON2 ==>" + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);
            intMaxX1 = jsonArray.length();
            Log.d(tag, "MaxX2 ==> "+ intMaxX1);

            DataPoint[] dataPoints = new DataPoint[intMaxX1];
            yr2 = new double[intMaxX1];

            for (int i=0;i<intMaxX1;i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                dataPoints[i] = new DataPoint(i ,Integer.parseInt(jsonObject.getString(strColumn)));
                yr2[i] = Integer.parseInt(jsonObject.getString(strColumn));
                Log.d(tag, "yi ==> "+ yr2[i]);

            }

            LineGraphSeries<DataPoint> line_series = new LineGraphSeries<DataPoint>(dataPoints);

            line_series.setColor(colorLineInt);
            line_graph2.addSeries(line_series);

            // set manual X bounds
            line_graph2.getViewport().setXAxisBoundsManual(true);
            line_graph2.getViewport().setMinX(0.0);
            line_graph2.getViewport().setMaxX(intMaxX1);

            // set manual Y bounds
            line_graph2.getViewport().setYAxisBoundsManual(true);
            line_graph2.getViewport().setMinY(0.0);
            line_graph2.getViewport().setMaxY(100);

            line_graph2.getViewport().setScrollable(true);

        }catch (Exception e){
            Log.d("15AprilV1", "e createLine ==>" + e.toString());
        }
    }

    private void createLineGraphRed2(String strDoType, String strColumn, int colorLineInt) {

        try{

            String tag = "15AprilV1";
            MyConstant myConstant = new MyConstant();
            String urlPHP = myConstant.getUrlGetUrlThestWhere();

            getDataWhere objGetDataWhere = new getDataWhere(Graph2Activity.this);
            objGetDataWhere.execute("doType", strDoType, urlPHP);
            String strJSON = objGetDataWhere.get();
            Log.d(tag, "JSON ==>" + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);
            intMaxX1 = jsonArray.length();
            Log.d(tag, "MaxX ==> "+ intMaxX1);

            DataPoint[] dataPoints = new DataPoint[intMaxX1];
            xr2 = new double[intMaxX1];

            for (int i=0;i<intMaxX1;i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                dataPoints[i] = new DataPoint(i ,Integer.parseInt(jsonObject.getString(strColumn)));
                xr2[i] = Integer.parseInt(jsonObject.getString(strColumn));
                Log.d(tag, "xi ==> "+ xr2[i]);

            }

            LineGraphSeries<DataPoint> line_series = new LineGraphSeries<DataPoint>(dataPoints);

            line_series.setColor(colorLineInt);
            line_graph2.addSeries(line_series);

            // set manual X bounds
            line_graph2.getViewport().setXAxisBoundsManual(true);
            line_graph2.getViewport().setMinX(0.0);
            line_graph2.getViewport().setMaxX(intMaxX1);

            // set manual Y bounds
            line_graph2.getViewport().setYAxisBoundsManual(true);
            line_graph2.getViewport().setMinY(0.0);
            line_graph2.getViewport().setMaxY(100);

            line_graph2.getViewport().setScrollable(true);

        }catch (Exception e){
            Log.d("15AprilV1", "e createLine ==>" + e.toString());
        }

    }//createLineGraphRed2
    private void createLineGraphBlue1(String strDoType, String strColumn, int colorLineInt) {

        try{

            String tag = "15AprilV1";
            MyConstant myConstant = new MyConstant();
            String urlPHP2 = myConstant.getUrlGetUrlThestWhere2();

            getDataWhere objGetDataWhere = new getDataWhere(Graph2Activity.this);
            objGetDataWhere.execute("doType", strDoType, urlPHP2);
            String strJSON = objGetDataWhere.get();
            Log.d(tag, "JSON2 ==>" + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);
            intMaxX1 = jsonArray.length();
            Log.d(tag, "MaxX2 ==> "+ intMaxX1);

            DataPoint[] dataPoints = new DataPoint[intMaxX1];
            y = new double[intMaxX1];

            for (int i=0;i<intMaxX1;i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                dataPoints[i] = new DataPoint(i ,Integer.parseInt(jsonObject.getString(strColumn)));
                y[i] = Integer.parseInt(jsonObject.getString(strColumn));
                Log.d(tag, "yi ==> "+ y[i]);

            }

            LineGraphSeries<DataPoint> line_series = new LineGraphSeries<DataPoint>(dataPoints);

            line_series.setColor(colorLineInt);
            line_graph.addSeries(line_series);

            // set manual X bounds
            line_graph.getViewport().setXAxisBoundsManual(true);
            line_graph.getViewport().setMinX(0.0);
            line_graph.getViewport().setMaxX(intMaxX1);

            // set manual Y bounds
            line_graph.getViewport().setYAxisBoundsManual(true);
            line_graph.getViewport().setMinY(0.0);
            line_graph.getViewport().setMaxY(100);

            line_graph.getViewport().setScrollable(true);

        }catch (Exception e){
            Log.d("15AprilV1", "e createLine ==>" + e.toString());
        }
    }// createLineGraphBlue1


    private void createLineGraphRed1(String strDoType,
                                     String strColumn,
                                     int colorLineInt) {
        try{

            String tag = "15AprilV1";
            MyConstant myConstant = new MyConstant();
            String urlPHP = myConstant.getUrlGetUrlThestWhere();

            getDataWhere objGetDataWhere = new getDataWhere(Graph2Activity.this);
            objGetDataWhere.execute("doType", strDoType, urlPHP);
            String strJSON = objGetDataWhere.get();
            Log.d(tag, "JSON ==>" + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);
            intMaxX1 = jsonArray.length();
            Log.d(tag, "MaxX ==> "+ intMaxX1);

            DataPoint[] dataPoints = new DataPoint[intMaxX1];
            x = new double[intMaxX1];

            for (int i=0;i<intMaxX1;i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                dataPoints[i] = new DataPoint(i ,Integer.parseInt(jsonObject.getString(strColumn)));
                x[i] = Integer.parseInt(jsonObject.getString(strColumn));
                Log.d(tag, "xi ==> "+ x[i]);

            }

            LineGraphSeries<DataPoint> line_series = new LineGraphSeries<DataPoint>(dataPoints);

            line_series.setColor(colorLineInt);
            line_graph.addSeries(line_series);

            // set manual X bounds
            line_graph.getViewport().setXAxisBoundsManual(true);
            line_graph.getViewport().setMinX(0.0);
            line_graph.getViewport().setMaxX(intMaxX1);

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
        line_graph = (GraphView) findViewById(R.id.graphParent);
        line_graph2 = (GraphView) findViewById(R.id.graphParent2);
        txtCorre = (TextView) findViewById(R.id.txtCorreParent);
        txtCorre2 = (TextView) findViewById(R.id.txtCorreParent2);
    }
}
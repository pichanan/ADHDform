package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONArray;
import org.json.JSONObject;

public class GraphActivity extends AppCompatActivity { // SNAP
    double[] x,y,xr2,yr2;
    String tag = "15AprilV1",loginString[];
    int intMaxX1,intMaxX;
    TextView txtCorre,txtCorre2;
    private GraphView line_graph,line_graph2;
    private int[] colorLineInts = new int[]{Color.GREEN, Color.BLUE};
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        loginString = getIntent().getStringArrayExtra("Login");
        initialView();
        button = (Button) findViewById(R.id.graphBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GraphActivity.this,AfterLoginActivity.class);
                intent.putExtra("Login", loginString);
                startActivity(intent);
            }
        });

        //risk1
        createLineGraphRed1("0","risk1",colorLineInts[0]);// snap risk1 teacher
        createLineGraphBlue1("0","risk2",colorLineInts[1]);//thass risk1 teacher
       //*risk2
        createLineGraphRed2("0","risk2",colorLineInts[0]);// snap risk2 teacher
        createLineGraphBlue2("0","risk1",colorLineInts[1]);//thass risk2 teacher

        calCorre1();
        calCorre2();

        // createLineGraph("1","risk1",colorLineInts[1]);


    }//main method

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

        if(r>=0.9&&r<=1.0){
            txtCorre2.setText("ด้านอาการซนวู่วาม ค่าที่หาได้คือ:"+s+" หมายความว่า มีความสัมพันธ์กันในระดับตสูงมาก");
        }else if(r>=0.7&&r<=0.9){
            txtCorre2.setText("ด้านอาการซนวู่วาม ค่าที่หาได้คือ:"+s+" หมายความว่า มีความสัมพันธ์กันในระดับสูง");
        }else if(r>=0.5&&r<=0.7){
            txtCorre2.setText("ด้านอาการซนวู่วาม ค่าที่หาได้คือ:"+s+" หมายความว่า มีความสัมพันธ์กันในระดับปานกลาง");
        }else if(r>=0.3&&r<=0.5){
            txtCorre2.setText("ด้านอาการซนวู่วาม ค่าที่หาได้คือ:"+s+" หมายความว่า มีความสัมพันธ์กันในระดับต่ำ");
        }else if(r>=0.0&&r<=0.3){
            txtCorre2.setText("ด้านอาการซนวู่วาม ค่าที่หาได้คือ:"+s+" หมายความว่า มีความสัมพันธ์กันในระดับต่ำมาก");
        }else{
            txtCorre2.setText("ด้านอาการซนวู่วาม ค่าที่หาได้คือ:"+s+" หมายความว่า มีความสัมพันธ์กันแบบตรงข้ามกัน");

        }
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


        if(r>=0.9&&r<=1.0){
            txtCorre.setText("ด้านอาการขาดสมาธิ ค่าที่หาได้คือ:"+s+" หมายความว่า มีความสัมพันธ์กันในระดับตสูงมาก");
        }else if(r>=0.7&&r<=0.9){
            txtCorre.setText("ด้านอาการขาดสมาธิ ค่าที่หาได้คือ:"+s+" หมายความว่า มีความสัมพันธ์กันในระดับสูง");
        }else if(r>=0.5&&r<=0.7){
            txtCorre.setText("ด้านอาการขาดสมาธิ ค่าที่หาได้คือ:"+s+" หมายความว่า มีความสัมพันธ์กันในระดับปานกลาง");
        }else if(r>=0.3&&r<=0.5){
            txtCorre.setText("ด้านอาการขาดสมาธิ ค่าที่หาได้คือ:"+s+" หมายความว่า มีความสัมพันธ์กันในระดับต่ำ");
        }else if(r>=0.0&&r<=0.3){
            txtCorre.setText("ด้านอาการขาดสมาธิ ค่าที่หาได้คือ:"+s+" หมายความว่า มีความสัมพันธ์กันในระดับต่ำมาก");
        }else{
            txtCorre.setText("ด้านอาการขาดสมาธิ ค่าที่หาได้คือ:"+s+" หมายความว่า มีความสัมพันธ์กันแบบตรงข้ามกัน");

        }

    }

    private void createLineGraphBlue2(String strDoType, String strColumn, int colorLineInt) {
        try{

            String tag = "15AprilV1";
            MyConstant myConstant = new MyConstant();
            String urlPHP2 = myConstant.getUrlGetUrlThestWhere2();

            getDataWhere objGetDataWhere = new getDataWhere(GraphActivity.this);
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

            getDataWhere objGetDataWhere = new getDataWhere(GraphActivity.this);
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

            getDataWhere objGetDataWhere = new getDataWhere(GraphActivity.this);
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

            getDataWhere objGetDataWhere = new getDataWhere(GraphActivity.this);
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
        line_graph = (GraphView) findViewById(R.id.graph);
        line_graph2 = (GraphView) findViewById(R.id.graph2);
        txtCorre = (TextView) findViewById(R.id.txtCorre);
        txtCorre2 = (TextView) findViewById(R.id.txtCorre2);
    }

    // correlation FROM TESTTABLE AND TEST2TABLE


}//main class
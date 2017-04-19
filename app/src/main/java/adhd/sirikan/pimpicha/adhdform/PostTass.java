package adhd.sirikan.pimpicha.adhdform;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by TheUser on 13/4/2560.
 */

public class PostTass extends AsyncTask<String, Void,String> {
    private Context context;
    private String tag = "30MarchV1";
    public PostTass(Context context) {
        this.context = context;
    }
    @Override
    protected String doInBackground(String... params) {

        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("t1", params[0])
                    .add("t2", params[1])
                    .add("t3" , params[2])
                    .add("t4" , params[3])
                    .add("t5" , params[4])
                    .add("t6", params[5])
                    .add("t7", params[6])
                    .add("t8" , params[7])
                    .add("t9" , params[8])
                    .add("t10" , params[9])
                    .add("t11", params[10])
                    .add("t12", params[11])
                    .add("t13" , params[12])
                    .add("t14", params[13])
                    .add("t15", params[14])
                    .add("t16" , params[15])
                    .add("t17" , params[16])
                    .add("t18" , params[17])
                    .add("t19", params[18])
                    .add("t20", params[19])
                    .add("t21" , params[20])
                    .add("t22" , params[21])
                    .add("t23" , params[22])
                    .add("t24", params[23])
                    .add("t25", params[24])
                    .add("t26" , params[25])
                    .add("t27" , params[26])
                    .add("t28", params[27])
                    .add("t29", params[28])
                    .add("t30" , params[29])
                    .add("tuserID", params[30])
                    .add("tchildID" , params[31])
                    .add("risk1", params[32])
                    .add("risk2", params[33])
                    .add("risk3", params[34])
                    .add("doType", params[35])
                    .add("CurrentDate", params[36])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[37]).post(requestBody).build();
            Response response = okHttpClient.newCall((request)).execute();
            return  response.body().string();
        }catch (Exception e){
            Log.d(tag, "e doIn ==>" +e.toString());
            return null;
        }

    }

}

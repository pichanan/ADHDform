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
 * Created by TheUser on 7/4/2560.
 */

public class PostTest extends AsyncTask<String, Void,String> {

    private Context context;
    private String tag = "30MarchV1";

    public PostTest(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {

        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("ch1", params[0])
                    .add("ch2", params[1])
                    .add("ch3" , params[2])
                    .add("ch4" , params[3])
                    .add("ch5" , params[4])
                    .add("ch6", params[5])
                    .add("ch7", params[6])
                    .add("ch8" , params[7])
                    .add("ch9" , params[8])
                    .add("ch10" , params[9])
                    .add("ch11", params[10])
                    .add("ch12", params[11])
                    .add("ch13" , params[12])
                    .add("ch14", params[13])
                    .add("ch15", params[14])
                    .add("ch16" , params[15])
                    .add("ch17" , params[16])
                    .add("ch18" , params[17])
                    .add("ch19", params[18])
                    .add("ch20", params[19])
                    .add("ch21" , params[20])
                    .add("ch22" , params[21])
                    .add("ch23" , params[22])
                    .add("ch24", params[23])
                    .add("ch25", params[24])
                    .add("ch26" , params[25])
                    .add("userID", params[26])
                    .add("childID" , params[27])
                    .add("risk1", params[29])
                    .add("risk2", params[30])
                    .add("risk3", params[31])
                    .add("doType", params[32])
                    .add("CurrentDate", params[33])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[28]).post(requestBody).build();
            Response response = okHttpClient.newCall((request)).execute();
            return  response.body().string();
        }catch (Exception e){
            Log.d(tag, "e doIn ==>" +e.toString());
            return null;
        }

    }
}//main class

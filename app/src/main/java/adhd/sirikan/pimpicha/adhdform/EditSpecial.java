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
 * Created by TheUser on 16/4/2560.
 */

public class EditSpecial extends AsyncTask<String, Void , String>{
    private Context context;

    public EditSpecial(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) { // implement from asyntask
        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("childID", params[0])
                    .add("doType", params[1])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[2]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            Log.d("16AprilV2", "e doIn ==>" + e.toString());
            return null;
        }

    }
}//main class

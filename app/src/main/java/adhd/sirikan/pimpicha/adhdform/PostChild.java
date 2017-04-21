package adhd.sirikan.pimpicha.adhdform;

import android.content.Context;
import android.media.Image;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by TheUser on 31/3/2560.
 */

public class PostChild extends AsyncTask<String ,Void,String>{
    private Context context;

    public PostChild(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        try{
            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd","true")
                    .add("id_Login",params[0])
                    .add("Name",params[1])
                    .add("Age",params[2])
                    .add("Image",params[3])
                    .add("gender",params[4])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[5]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();


        }catch (Exception e){
            Log.d("31MarchV1", "e doIn ==>" + e.toString());
            return null;
        }


    }
}// Main class

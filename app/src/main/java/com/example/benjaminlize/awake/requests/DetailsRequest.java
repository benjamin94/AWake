package com.example.benjaminlize.awake.requests;

import android.os.AsyncTask;
import android.util.Log;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by benjamin.lize on 21/05/2016.
 */
public class DetailsRequest extends AsyncTask {
    private static final String TAG = DetailsRequest.class.getSimpleName();

    @Override
    protected Object doInBackground(Object[] params) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://partner-api.wakelet.com/usernames/wakelet")
                .get()
                .addHeader("x-api-key", "tD8KRTeehj40H8TypwfnhawgPrgDMojkaBgWqTvf")
                .build();

        String theResponse;

        try {
            Response response = client.newCall(request).execute();
            theResponse = response.body().string();

            ObjectMapper m = new ObjectMapper();
            JsonNode rootNode = m.readTree(theResponse);
            Log.i(TAG, "doInBackground: " + theResponse);
            JSONObject jsonObject = new JSONObject(theResponse);

            int hi = 1;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}

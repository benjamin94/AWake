package com.example.benjaminlize.awake.main;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by benjamin.lize on 21/05/2016.
 */
public class WakeRequest extends AsyncTask<Context,Void,ArrayList> {
    private static final String TAG = WakeRequest.class.getSimpleName();

    RecyclerView mRecyclerView;
    Context mContext;

    public WakeRequest(Context context, RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
        mContext = context;
    }

    @Override
    protected ArrayList doInBackground(Context... params) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://partner-api.wakelet.com/profiles/908b32ca-5645-4d34-8c4a-9f00a1b3f454/collections")
                .get()
                .addHeader("x-api-key", "tD8KRTeehj40H8TypwfnhawgPrgDMojkaBgWqTvf")
                .build();

        ArrayList list = null;

        try {
            Response response = client.newCall(request).execute();
            String theResponse = response.body().string();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(theResponse);
            JsonNode items = rootNode.get("_embedded").get("items");
            list = new ArrayList();

            for (int i = 0; i < items.size(); i++) {
                JsonNode child = items.get(i);
                WakeItem wake = new WakeItem(
                        child.get("title").textValue(),
                        child.get("summary").get("cardCount").asInt(),
                        child.get("_embedded").get("image").get("smallImageUrl").textValue(),
                        child.get("_links").get("cards").get("href").textValue());
                list.add(wake);
            }
            Log.i(TAG, "doInBackground: " + theResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    protected void onPostExecute(ArrayList arrayList) {
        super.onPostExecute(arrayList);

        mRecyclerView.setAdapter(new WakeAdapter(arrayList,mContext));
    }
}

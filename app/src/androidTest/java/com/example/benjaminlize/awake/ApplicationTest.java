package com.example.benjaminlize.awake;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    private static final String LOG_TAG = ApplicationTest.class.getSimpleName();

    public ApplicationTest() {
        super(Application.class);
    }

    public void testAPICall(){
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
            //*JsonNode rootNode = m.readTree(theResponse);

            JSONObject jsonObject = new JSONObject(theResponse);
            char[] sup = theResponse.toCharArray();

            int hi = 1;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

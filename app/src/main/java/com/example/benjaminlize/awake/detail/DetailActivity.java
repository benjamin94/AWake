package com.example.benjaminlize.awake.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.benjaminlize.awake.R;

public class DetailActivity extends AppCompatActivity {

    public final static String URL_APPEND = "url_detail_append";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Bundle b = getIntent().getExtras();
        String urlToAppend = b.getString(URL_APPEND);
        WakeRequestDetail userWakeRequest = new WakeRequestDetail(getApplicationContext(),recyclerView,
                urlToAppend);
        userWakeRequest.execute();

    }
}

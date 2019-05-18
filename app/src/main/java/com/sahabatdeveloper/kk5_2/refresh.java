package com.sahabatdeveloper.kk5_2;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class refresh extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    TextView textView;

    int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
        textView = findViewById(R.id.text);

        textView.setText("total number = 0");

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                number++;
//                textView.setText("total number = 0" + number);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);

                    }
                },1000);

            }
        });
    }
}
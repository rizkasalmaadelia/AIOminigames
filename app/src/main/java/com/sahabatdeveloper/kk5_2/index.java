package com.sahabatdeveloper.kk5_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        ImageButton btn = (ImageButton)findViewById(R.id.playbutton);
        ImageButton btn2 = (ImageButton)findViewById(R.id.playbutton2);
        ImageButton btn3 = (ImageButton)findViewById(R.id.playbutton3);
        ImageButton btn4 = (ImageButton)findViewById(R.id.playbutton4);
        ImageButton btn5 = (ImageButton)findViewById(R.id.playbutton5);
        ImageButton btn6 = (ImageButton)findViewById(R.id.playbutton6);
        ImageButton btnback = (ImageButton)findViewById(R.id.indexback);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(index.this, MainActivity.class));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(index.this, kuis.class));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(index.this, tictac.class));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(index.this, spin.class));
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(index.this, animal.class));
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(index.this, pahlawan.class));
            }
        });

    }
}

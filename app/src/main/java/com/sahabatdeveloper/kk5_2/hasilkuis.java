package com.sahabatdeveloper.kk5_2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class hasilkuis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasilkuis);

        ImageButton x2 = (ImageButton)findViewById(R.id.x2);

        TextView hasil = (TextView)findViewById(R.id.hasil);
        TextView hasil2 = (TextView)findViewById(R.id.hasil2);

        TextView husal = (TextView)findViewById(R.id.husal);
        hasil.setText(""+kuis.benar);
        hasil2.setText(""+kuis.salah);
        husal.setText("isi"+kuis.hasil);

        x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void ulangi(View view){
        finish();
        Intent i = new Intent(getApplicationContext(),kuis.class);
        startActivity(i);
    }
}

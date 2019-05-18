package com.sahabatdeveloper.kk5_2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class menu extends AppCompatActivity {
    Boolean pulsado=false;
    MediaPlayer lose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        lose=MediaPlayer.create(getBaseContext(),R.raw.backs);
        lose.start();
        lose.setLooping(true);

        Button btn = (Button)findViewById(R.id.togame);
        Button btn3 = (Button)findViewById(R.id.tocredit);
        Button btn2 = (Button)findViewById(R.id.torule);
        ImageButton x = (ImageButton)findViewById(R.id.x);
        final ImageButton boton1 =(ImageButton)findViewById(R.id.on);

        btn.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View v) {
                startActivity(new Intent(menu.this, index.class));

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menu.this, IntroActivity.class));

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menu.this, credit.class));

            }
        });
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pulsado == false) {
                    lose.stop();
                    lose.reset();
                    pulsado = true;
                    boton1.setImageResource(R.drawable.off);
                } else {
                    lose = MediaPlayer.create(getBaseContext(), R.raw.backs);
                    lose.setLooping(true);
                    lose.start();
                    pulsado = false;
                    boton1.setImageResource(R.drawable.on);
                }

            }
        });
    }
}

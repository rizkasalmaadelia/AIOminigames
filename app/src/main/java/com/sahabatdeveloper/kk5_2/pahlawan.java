package com.sahabatdeveloper.kk5_2;

import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.Random;

public class pahlawan extends AppCompatActivity {

    ImageView img_question, img_answer;
    Button btn_answer;

    int array_images[] = new int[]{
            R.drawable.pah1,
            R.drawable.pah2,
            R.drawable.pah3,
            R.drawable.pah4,
            R.drawable.pah5,
            R.drawable.pah6,
            R.drawable.pah7,
            R.drawable.pah8,
            R.drawable.pah9,
            R.drawable.pah10
    };
    int correct_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pahlawan);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Your Memory");
        setSupportActionBar(toolbar);

        img_question = findViewById(R.id.img_question);


        btn_answer = findViewById(R.id.btn_answer);
        btn_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pahlawan.this, ChooseAnswer.class);
                startActivityForResult(intent, 1999);
            }
        });
        randomImage();
    }
        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 1999) {
                int answer_resource_id = data.getIntExtra("Answer", 0);
                img_answer = (ImageView) findViewById(R.id.img_answer);
                img_answer.setImageResource(answer_resource_id);

                if (answer_resource_id == correct_answer) {
                    MediaPlayer win = MediaPlayer.create(pahlawan.this, R.raw.win);
                    win.start();
                    Toast.makeText(this, "GOOD! YOUR BRAIN IS NOT BUCIN", Toast.LENGTH_SHORT).show();
                } else {
                    MediaPlayer lose = MediaPlayer.create(pahlawan.this, R.raw.lose);
                    lose.start();
                    Toast.makeText(this, "BAD! YOUR BRAIN IS SO BUCIN", Toast.LENGTH_SHORT).show();
                }
            }
        }
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }
        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            int i = item.getItemId();
            if (i == R.id.menu_re_new) {
                ;
                randomImage();
                img_answer = (ImageView) findViewById(R.id.img_answer);
                img_answer.setImageResource(R.drawable.ask);

            }
            return true;
        }

        private void randomImage () {
            int img_resorce = array_images[new Random().nextInt(9)];
            img_question.setImageResource(img_resorce);

            correct_answer = img_resorce;
        }


    }

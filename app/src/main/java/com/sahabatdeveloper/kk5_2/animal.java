package com.sahabatdeveloper.kk5_2;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;


import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class animal extends AppCompatActivity {

    ImageView image1,image2,image3,image4,imageMain;
    TextView tv_status;
    Button b_next;
    //gambar asli
    Integer[] images = {
            R.drawable.he1,
            R.drawable.he3,
            R.drawable.he5,
            R.drawable.he2,
            R.drawable.he4,
            R.drawable.he6,
            R.drawable.he7,
            R.drawable.he8,
            R.drawable.he9,
            R.drawable.he10,
            R.drawable.he11,
            R.drawable.he12,
            R.drawable.he13,

    };
    //gambar siluet
    Integer[] images_bw = {
            R.drawable.he_bw1,
            R.drawable.he_bw2,
            R.drawable.he_bw3,
            R.drawable.he_bw4,
            R.drawable.he_bw5,
            R.drawable.he_bw6,
            R.drawable.he_bw7,
            R.drawable.he_bw8,
            R.drawable.he_bw9,
            R.drawable.he_bw10,
            R.drawable.he_bw11,
            R.drawable.he_bw12,
            R.drawable.he_bw13,
    };
    Integer[] images_numbers = {1,2,3,4,5,6,7,8,9,10};
    int turn  = 1;
    int correctAnswer = 0;
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        imageMain = (ImageView) findViewById(R.id.imagemain);

        tv_status = (TextView) findViewById(R.id.tv_status);
        b_next = (Button) findViewById(R.id.b_next);

        Collections.shuffle(Arrays.asList(images_numbers));
        setImages();

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswer == 1){
                    score++;
                    tv_status.setText("Correct");
                    b_next.setVisibility(View.VISIBLE);
                }else
                {
                    tv_status.setText("Wrong!");
                    b_next.setVisibility(View.VISIBLE);
                }

                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);

            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswer == 2){
                    score++;
                    tv_status.setText("Correct");
                    b_next.setVisibility(View.VISIBLE);
                }else
                {
                    tv_status.setText("Wrong!");
                    b_next.setVisibility(View.VISIBLE);
                }

                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswer == 3){
                    score++;
                    tv_status.setText("Correct");
                    b_next.setVisibility(View.VISIBLE);
                    MediaPlayer win = MediaPlayer.create(animal.this, R.raw.win);
                    win.start();
                }else
                {
                    tv_status.setText("Wrong!");
                    b_next.setVisibility(View.VISIBLE);
                    MediaPlayer lose = MediaPlayer.create(animal.this, R.raw.lose);
                    lose.start();
                }

                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswer == 4){
                    score++;
                    tv_status.setText("Correct");
                    b_next.setVisibility(View.VISIBLE);
                }else
                {
                    tv_status.setText("Wrong!");
                    b_next.setVisibility(View.VISIBLE);
                }

                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);
            }
        });
        b_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn++;
                if (turn == 11){
                    checkEnd();
                }else{
                    setImages();
                }
            }
        });
        ImageButton x2 = (ImageButton)findViewById(R.id.x2);

        x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void setImages() {
        Random r = new Random();
        correctAnswer = r.nextInt(4) +1;

        int wrongAnswer1, wrongAnswer2, wrongAnswer3;

        do {
            wrongAnswer1 = r.nextInt(13);
        }while (wrongAnswer1 == images_numbers[turn]);

        do {
            wrongAnswer2 = r.nextInt(13);
        }while (wrongAnswer2 == images_numbers[turn] || wrongAnswer2 == wrongAnswer1);

        do {
            wrongAnswer3 = r.nextInt(13);
        }while (wrongAnswer3 == images_numbers[turn] || wrongAnswer3 == wrongAnswer2 || wrongAnswer3 == wrongAnswer1);


        switch (correctAnswer){
            case 1:
                image1.setImageResource(images[images_numbers[turn]]);
                image2.setImageResource(images[wrongAnswer1]);
                image3.setImageResource(images[wrongAnswer2]);
                image4.setImageResource(images[wrongAnswer3]);
                break;
            case 2:
                image1.setImageResource(images[wrongAnswer1]);
                image2.setImageResource(images[images_numbers[turn]]);
                image3.setImageResource(images[wrongAnswer2]);
                image4.setImageResource(images[wrongAnswer3]);
                break;
            case 3:
                image1.setImageResource(images[wrongAnswer1]);
                image2.setImageResource(images[wrongAnswer2]);
                image3.setImageResource(images[images_numbers[turn]]);
                image4.setImageResource(images[wrongAnswer3]);
                break;
            case 4:
                image1.setImageResource(images[wrongAnswer1]);
                image2.setImageResource(images[wrongAnswer2]);
                image3.setImageResource(images[wrongAnswer3]);
                image4.setImageResource(images[images_numbers[turn]]);
                break;
        }

        imageMain.setImageResource(images_bw[images_numbers[turn]]);


        tv_status.setText(" ");
        b_next.setVisibility(View.INVISIBLE);

        image1.setEnabled(true);
        image2.setEnabled(true);
        image3.setEnabled(true);
        image4.setEnabled(true);

    }
    private void checkEnd(){
        AlertDialog.Builder al = new AlertDialog.Builder(this);
        al.setCancelable(false);
        al.setMessage("Game over! Score" +score);
        al.setPositiveButton("QUIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = al.create();
        alertDialog.show();
    }
}

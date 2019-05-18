package com.sahabatdeveloper.kk5_2;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    MediaPlayer ring;
    Button b_rock,b_scissor,b_paper;
    ImageView iv_cpu,iv_me;
    String myChoice,cpuChoice,result;
    Random r;
    ImageButton x2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MediaPlayer ring= MediaPlayer.create(MainActivity.this,R.raw.bwg);


        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_me = (ImageView) findViewById(R.id.iv_me);

        b_rock = (Button) findViewById(R.id.b_rock);
        b_scissor = (Button) findViewById(R.id.b_scissor);
        b_paper = (Button) findViewById(R.id.b_paper);
        x2 = (ImageButton) findViewById(R.id.x2);
        r = new Random();

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "rock";
                iv_me.setImageResource(R.drawable.rock);
                calculate();
            }
        });
        x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        b_scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "scissor";
                iv_me.setImageResource(R.drawable.scissor);
                calculate();
            }
        });
        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "paper";
                iv_me.setImageResource(R.drawable.paper);
                calculate();
            }
        });
    }
    public void calculate(){
        int cpu = r.nextInt(3);
        if(cpu==0){
            cpuChoice = "rock";
            iv_cpu.setImageResource(R.drawable.rock);
        } else if(cpu==1){
            cpuChoice = "scissor";
            iv_cpu.setImageResource(R.drawable.scissor);
        } else if(cpu==2){
            cpuChoice = "paper";
            iv_cpu.setImageResource(R.drawable.paper);
        }

        if(myChoice.equals("rock") &&  cpuChoice.equals("paper")){
            result="You lose";
            MediaPlayer lose = MediaPlayer.create(MainActivity.this,R.raw.lose);
            lose.start();

        }else
        if(myChoice.equals("rock") &&  cpuChoice.equals("scissor")){
            result="You win";
            MediaPlayer win = MediaPlayer.create(MainActivity.this,R.raw.win);
            win.start();
        }else
        if(myChoice.equals("paper") &&  cpuChoice.equals("scissor")){
            result="You lose";
            MediaPlayer lose = MediaPlayer.create(MainActivity.this,R.raw.lose);
            lose.start();
        }else
        if(myChoice.equals("paper") &&  cpuChoice.equals("rock")){
            result="You win";
            MediaPlayer win = MediaPlayer.create(MainActivity.this,R.raw.win);
            win.start();
        }else
        if(myChoice.equals("scissor") &&  cpuChoice.equals("paper")){
            result="You win";
            MediaPlayer win = MediaPlayer.create(MainActivity.this,R.raw.win);
            win.start();
        }else
        if(myChoice.equals("scissor") &&  cpuChoice.equals("rock")){
            result="You lose";

            MediaPlayer lose = MediaPlayer.create(MainActivity.this,R.raw.lose);
            lose.start();
        }else
        if(myChoice.equals("scissor") &&  cpuChoice.equals("scissor")){
            result="Draw";
            MediaPlayer draw = MediaPlayer.create(MainActivity.this,R.raw.draw);
            draw.start();
        }else
        if(myChoice.equals("paper") &&  cpuChoice.equals("paper")){
            result="Draw";
            MediaPlayer draw = MediaPlayer.create(MainActivity.this,R.raw.draw);
            draw.start();
        }else
        if(myChoice.equals("rock") &&  cpuChoice.equals("rock")){
            result="Draw";
            MediaPlayer draw = MediaPlayer.create(MainActivity.this,R.raw.draw);
            draw.start();
        }

        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
        ImageButton x3 = (ImageButton)findViewById(R.id.x3);

    }
}

package com.sahabatdeveloper.kk5_2;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPager introViewPager;
    TabLayout tabIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        tabIndicator = findViewById(R.id.tab_indicator);


        List<ScreenItem> mList = new ArrayList<>();

        mList.add(new ScreenItem( "Quiz", "untuk melatih konsentrasi sekaligus mengevaluasi dan menambah pengetahuan anda, anda  bisa menggunakan fiitur quiz dengan menjawab soal yang ada\n",R.drawable.idea));
        mList.add(new ScreenItem( "XOXO", "fiture XOXO dapat dimainkan oleh dua orang, dengan fitur ini akan melatih strategi dan juga kritisisasi pemikiran untuk anda.\n",R.drawable.idea));
        mList.add(new ScreenItem( "SPIN BOTTLE", "Mungkin terkadang anda kesulitan dalam bermain Truth Or Dare karena ketiadaan botol, dengan ini anda bisa menggunakannya sebagai digital botol maupun sebagai alat penunjuk acak\n",R.drawable.idea));
        mList.add(new ScreenItem( "ANIMAL", "Mungkin mata anda terkadang kurang teliti melihat sesuatu, baik karena kurang konsentrasi maupun karena lelah? Latih kembali keakuratan penglihatan anda dengan menebak animal di fitur ini dengan cepat.\n",R.drawable.idea));
        mList.add(new ScreenItem( "MEMORY", "Pernah lupa sesuatu yang baru saja diingat ? atau anda suka wajah pahlawan yang telah berjasa ? Yuk langsung saja coba fitur memory sekarang juga.",R.drawable.idea));


        screenPager = findViewById(R.id.screen_viewpager);
        introViewPager = new IntroViewPager(this,mList);
        screenPager.setAdapter(introViewPager);

        tabIndicator.setupWithViewPager(screenPager);


    }
}

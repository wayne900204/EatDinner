package com.example.eatingyou.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.cuberto.liquid_swipe.LiquidPager;
import com.example.eatingyou.Login.LoginActivity;
import com.example.eatingyou.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class IntroductionActivity extends AppCompatActivity {
    ImageView logo, appName, splashImg;
    LottieAnimationView lottieAnimationView;
    LiquidPager pager;
    private ViewPager viewPager;
    private Animation animation;
    SharedPreferences mSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        logo = findViewById(R.id.logo);
        appName = findViewById(R.id.app_name);
        splashImg = findViewById(R.id.img);
        lottieAnimationView = findViewById(R.id.lottie);

        splashImg.animate().translationY(-2500).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
        appName.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1600).setDuration(1000).setStartDelay(4000);

        pager = findViewById(R.id.pager);
        viewPager = new ViewPager(getSupportFragmentManager(), 1);
        pager.setAdapter(viewPager);

        animation = AnimationUtils.loadAnimation(this, R.anim.o_b_anim);
        pager.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSharedPref = getSharedPreferences("SharePerf", MODE_PRIVATE);
                boolean isFirstTime = mSharedPref.getBoolean("firstTime", true);
                if (isFirstTime) {
                    SharedPreferences.Editor editor = mSharedPref.edit();
                    editor.putBoolean("firstTime", false).commit();
                } else {
                    Intent intent = new Intent();
                    intent.setClass(IntroductionActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 5000);
    }
}
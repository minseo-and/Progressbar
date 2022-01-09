package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private int CurrentProgress = 0;
    private ProgressBar progressBar;
    private View second_hand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.circle_progressbar);
        second_hand = findViewById(R.id.second_hand);
        Animation anim = AnimationUtils.loadAnimation(
                getApplicationContext(), // 현재 화면의 제어권자
                R.anim.rotate_anim);    // 설정한 에니메이션 파일
        second_hand.startAnimation(anim);


        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                CurrentProgress = CurrentProgress + 1;
                progressBar.setProgress(CurrentProgress);
                progressBar.setMax(3600);
                if (CurrentProgress >= 3600){
                    CurrentProgress = 0;
                }
            }
        };
        timer.schedule(timerTask,0,10);





    }


}
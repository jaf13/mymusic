package com.example.mymusic;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3;
    MediaPlayer mpAlessia, mpSugar, mpFortMinor;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        button1 = (Button) findViewById(R.id.btnAlessia);
        button2 = (Button) findViewById(R.id.btnSugar);
        button3 = (Button) findViewById(R.id.btnFortMinor);

        button1.setOnClickListener(bAlessia);
        button2.setOnClickListener(bSugar);
        button3.setOnClickListener(bFortMinor);

        mpAlessia = new MediaPlayer();
        mpAlessia = MediaPlayer.create(this, R.raw.alessia);
        mpSugar = new MediaPlayer();
        mpSugar = MediaPlayer.create(this, R.raw.sugar);
        mpFortMinor = new MediaPlayer();
        mpFortMinor = MediaPlayer.create(this, R.raw.fortminor);
        playing = 0;
    }
    Button.OnClickListener bAlessia = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch(playing) {
                case 0:
                    mpAlessia.start();
                    playing = 1;
                    button1.setText("Pause Song");
                    button2.setVisibility(View.INVISIBLE);
                    button3.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpAlessia.pause();
                    playing = 0;
                    button1.setText("Play Song");
                    button2.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.VISIBLE);
                    break;
            }
        }

    };
    Button.OnClickListener bSugar = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch(playing) {
                case 0:
                    mpSugar.start();
                    playing = 1;
                    button2.setText("Pause Song");
                    button1.setVisibility(View.INVISIBLE);
                    button3.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpSugar.pause();
                    playing = 0;
                    button2.setText("Play Song");
                    button1.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
    Button.OnClickListener bFortMinor = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch(playing) {
                case 0:
                    mpFortMinor.start();
                    playing = 1;
                    button3.setText("Pause Song");
                    button2.setVisibility(View.INVISIBLE);
                    button1.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpFortMinor.pause();
                    playing = 0;
                    button3.setText("Play Song");
                    button2.setVisibility(View.VISIBLE);
                    button1.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}

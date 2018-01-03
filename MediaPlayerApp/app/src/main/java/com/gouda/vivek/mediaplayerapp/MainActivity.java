package com.gouda.vivek.mediaplayerapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button playButton;
    private SeekBar seekBarObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = (Button) findViewById(R.id.playButtonID);
        seekBarObj = (SeekBar) findViewById(R.id.seekBarID);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.faded);
        seekBarObj.setMax(mediaPlayer.getDuration());

        seekBarObj.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                int duration = mediaPlayer.getDuration();
                String musicDuration = String.valueOf(duration/1000);
                Toast.makeText(getApplicationContext(), "Music Duration "+ musicDuration, Toast.LENGTH_SHORT).show();
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mediaPlayer.isPlaying()) {

                    pauseMusic();

                }else {

                    startMusic();

                }
            }
        });

    }

    public void pauseMusic() {

        if (mediaPlayer != null) {
            mediaPlayer.pause();
            playButton.setText("Play");
        }

    }

    public void startMusic() {

        if (mediaPlayer != null) {
            mediaPlayer.start();
            playButton.setText("Pause");
        }

    }

    @Override
    protected void onDestroy() {

        if (mediaPlayer!=null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}

package africa.lejournal.audiolistproject;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;
import java.net.URISyntaxException;

public class AudioModelPlayer extends AppCompatActivity {
 private MediaPlayer mediaPlayer;
 private FloatingActionButton play,pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_model_player);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        play=(FloatingActionButton)findViewById(R.id.play);
        pause=(FloatingActionButton)findViewById(R.id.pause);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer!=null)
                {
                    mediaPlayer.start();
                }
                pause.setVisibility(View.VISIBLE);
                play.setVisibility(View.GONE);
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer!=null)
                {
                    mediaPlayer.pause();
                }
                play.setVisibility(View.VISIBLE);
                pause.setVisibility(View.GONE);
            }
        });

        mediaPlayer=new MediaPlayer();

        Intent intent=getIntent();

        if (intent!=null)
        {
            if (intent.hasExtra("actionBarTitle"))
            {
                setTitle(intent.getStringExtra("actionBarTitle"));


                   mediaPlayer=MediaPlayer.create(getApplicationContext(),getResources().getIdentifier(intent.getStringExtra("actionBarTitle"),"raw",getPackageName()));

            }
        }else
        {
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            if (mediaPlayer!=null)
            {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }else
                {
                    mediaPlayer.release();
                }
            }
        }
        finish();
        return super.onOptionsItemSelected(item);
    }
}

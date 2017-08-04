package com.exmample.android.musicplayerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout infoLinearLayout = (LinearLayout)findViewById(R.id.info);
        infoLinearLayout.setOnClickListener(infoLinearLayoutOnClickListener);
        LinearLayout playListLinearLayout = (LinearLayout)findViewById(R.id.play_list);
        playListLinearLayout.setOnClickListener(playListLinearLayoutOnClickListener);
        LinearLayout albumsLinearLayout = (LinearLayout)findViewById(R.id.albums);
        albumsLinearLayout.setOnClickListener(albumsLinearLayoutOnClickListener);
        LinearLayout settingsLinearLayout = (LinearLayout)findViewById(R.id.settings);
        settingsLinearLayout.setOnClickListener(settingsLinearLayoutOnClickListener);
    }

    final View.OnClickListener infoLinearLayoutOnClickListener = new View.OnClickListener(){
        public void onClick(final View v){
            openInfoActivity();
        }
    };

    final View.OnClickListener playListLinearLayoutOnClickListener = new View.OnClickListener(){
        public void onClick(final View v){
            openPlayListActivity();
        }
    };

    final View.OnClickListener albumsLinearLayoutOnClickListener = new View.OnClickListener(){
        public void onClick(final View v){
            openAlbumsActivity();
        }
    };

    final View.OnClickListener settingsLinearLayoutOnClickListener = new View.OnClickListener(){
        public void onClick(final View v){
            openSettingsActivity();
        }
    };

    private void openInfoActivity(){
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    private void openPlayListActivity(){
        Intent intent = new Intent(this, PlayListActivity.class);
        startActivity(intent);
    }

    private void openAlbumsActivity(){
        Intent intent = new Intent(this, AlbumActivity.class);
        startActivity(intent);
    }

    private void openSettingsActivity(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}

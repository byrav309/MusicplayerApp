package com.exmample.android.musicplayerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AlbumActivity extends AppCompatActivity implements View.OnClickListener {

    private Button moveToHome;
    private Button moveToSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        moveToHome = (Button) findViewById(R.id.move_to_home);
        moveToHome.setOnClickListener(this);
        moveToSetting = (Button) findViewById(R.id.move_to_setting);
        moveToSetting.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.move_to_home:
                moveToHome();
                break;
            case R.id.move_to_setting:
                moveToSetting();
                break;
        }
    }

    private void moveToSetting(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
        finish();
    }

    private void moveToHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

package com.exmample.android.musicplayerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button moveToHome;
    private Button moveToInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        moveToHome = (Button) findViewById(R.id.move_to_home);
        moveToHome.setOnClickListener(this);
        moveToInfo = (Button) findViewById(R.id.move_to_Info);
        moveToInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.move_to_home:
                moveToHome();
                break;
            case R.id.move_to_Info :
                moveToInfoScreen();
                break;
        }
    }

    private void moveToInfoScreen(){
        Intent intent = new Intent(this,  InfoActivity.class);
        startActivity(intent);
        finish();
    }

    private void moveToHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

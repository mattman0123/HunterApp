package com.example.vinck.trackthat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    public void Open_Map(View view){
        Intent i = new Intent(getApplicationContext(),MapsActivity.class);
        startActivity(i);
    }

    public void Open_Weather(View view){
        Intent i = new Intent(getApplicationContext(),Weather.class);
        startActivity(i);
    }

    public void Open_RandR(View view){
        Intent i = new Intent(getApplicationContext(),RulesandReg.class);
        startActivity(i);
    }
}

package com.example.a202128.kalkukator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

    }

    public void closeApp(View v){
        finishAndRemoveTask();
    }

    public void goToAbout(View v){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void runStandardCalculator(View v){
        Intent intent = new Intent(this, SimpleCalculatorActivity.class);
        intent.putExtra("mode",1);
        startActivity(intent);
    }

    public void runAdvamcedCalculator(View v){
        Intent intent = new Intent(this, SimpleCalculatorActivity.class);
        intent.putExtra("mode",2);
        startActivity(intent);
    }

}
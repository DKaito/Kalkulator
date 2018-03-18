package com.example.a202128.kalkukator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AdvancedCalculatorActivity extends AppCompatActivity {

    private int orientationFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orientationFlag = getResources().getConfiguration().orientation;

        if(orientationFlag==1)
            setContentView(R.layout.activity_advanced_calculator_portrait);
        else
            setContentView(R.layout.activity_advanced_calculator_landscape);
    }
}

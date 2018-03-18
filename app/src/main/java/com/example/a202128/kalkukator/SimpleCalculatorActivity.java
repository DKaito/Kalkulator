package com.example.a202128.kalkukator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SimpleCalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private static SimpleMath simpleMath = new SimpleMath();

    private int orientationFlag;
    private TextView formulaView, resultView;
    private String register = "";
    private String formulaFlag = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orientationFlag = getResources().getConfiguration().orientation;

        if(orientationFlag==1)
            setContentView(R.layout.activity_simple_calculator_portrait);
        else
            setContentView(R.layout.activity_simple_calculator_landscape);

        resultView = findViewById(R.id.resultView);
        formulaView = findViewById(R.id.formulaView);

        if(register.isEmpty())
            formulaView.setText("0");
        else
            formulaView.setText(register);



        Button simpleMath0 = findViewById(R.id.simpleMath0);
        simpleMath0.setOnClickListener(this);
        Button simpleMath1 = findViewById(R.id.simpleMath1);
        simpleMath1.setOnClickListener(this);
        Button simpleMath2 = findViewById(R.id.simpleMath2);
        simpleMath2.setOnClickListener(this);
        Button simpleMath3 = findViewById(R.id.simpleMath3);
        simpleMath3.setOnClickListener(this);
        Button simpleMath4 = findViewById(R.id.simpleMath4);
        simpleMath4.setOnClickListener(this);
        Button simpleMath5 = findViewById(R.id.simpleMath5);
        simpleMath5.setOnClickListener(this);
        Button simpleMath6 = findViewById(R.id.simpleMath6);
        simpleMath6.setOnClickListener(this);
        Button simpleMath7 = findViewById(R.id.simpleMath7);
        simpleMath7.setOnClickListener(this);
        Button simpleMath8 = findViewById(R.id.simpleMath8);
        simpleMath8.setOnClickListener(this);
        Button simpleMath9 = findViewById(R.id.simpleMath9);
        simpleMath9.setOnClickListener(this);
        Button simpleMathPlus = findViewById(R.id.simpleMathPlus);
        simpleMathPlus.setOnClickListener(this);
        Button simpleMathEquals = findViewById(R.id.simpleMathEquals);
        simpleMathEquals.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.simpleMath0:
                    register+="0";
                    formulaView.setText(register);
                break;

            case R.id.simpleMath1:
                    register+="1";
                    formulaView.setText(register);
                break;

            case R.id.simpleMath2:
                    register+="2";
                    formulaView.setText(register);
                break;

            case R.id.simpleMath3:
                    register+="3";
                    formulaView.setText(register);
                break;

            case R.id.simpleMath4:
                    register+="4";
                    formulaView.setText(register);
                break;

            case R.id.simpleMath5:
                    register+="5";
                    formulaView.setText(register);
                break;

            case R.id.simpleMath6:
                    register+="6";
                    formulaView.setText(register);
                break;

            case R.id.simpleMath7:
                    register+="7";
                    formulaView.setText(register);
                break;

            case R.id.simpleMath8:
                    register+="8";
                    formulaView.setText(register);
                break;

            case R.id.simpleMath9:
                    register+="9";
                    formulaView.setText(register);
                break;

            case R.id.simpleMathPlus:
                    if(!register.isEmpty()) {

                        if (!"+".equals(""+register.charAt(register.length() - 1))) {
                            register += "+";
                            formulaView.setText(register);
                       // }else{
                       //     resultView.setText(resultView.getText()+"+");
                        }
                    }
                break;

            case R.id.simpleMathMinus:
                    register+="-";
                    formulaView.setText(register);
                break;

            case R.id.simpleMathEquals:
                    resultView.setText("A");
                    float result = simpleMath.executeMathOperation(register);

                break;

        }
    }
}

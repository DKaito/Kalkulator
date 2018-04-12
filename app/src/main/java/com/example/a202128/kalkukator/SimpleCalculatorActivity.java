package com.example.a202128.kalkukator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleCalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private static SimpleMath simpleMath = new SimpleMath();
    private TextView formulaView, resultView;
    private String register = "", poweringRegister = "", swapRegister = "";
    private boolean powYUsed = false, powYFirstUse = false;
    private int calculatorMode=0;
    private Toast errorToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calculatorMode = getIntent().getIntExtra("mode",0);

        if(calculatorMode==1) {
            setContentView(R.layout.activity_simple_calculator);
        }else {
            setContentView(R.layout.activity_advanced_calculator);
        }
        resultView = findViewById(R.id.resultView);
        formulaView = findViewById(R.id.formulaView);
        initializeViewElements();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("register", register);
        outState.putString("lastAction", resultView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.register = savedInstanceState.getString("register");
        resultView.setText(savedInstanceState.getString("lastAction"));
        formulaView.setText(register);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.simpleMath0:
                if((!register.contains(" ") && register.length()<=40) || (register.contains(" ") && register.length()<=80)) {
                    register+="0";
                    formulaView.setText(register);
                }
                break;
            case R.id.simpleMath1:
                if((!register.contains(" ") && register.length()<=40) || (register.contains(" ") && register.length()<=80)){
                    register+="1";
                    formulaView.setText(register);
                }
                break;
            case R.id.simpleMath2:
                if((!register.contains(" ") && register.length()<=40) || (register.contains(" ") && register.length()<=80)){
                    register+="2";
                    formulaView.setText(register);
                }
                break;
            case R.id.simpleMath3:
                if((!register.contains(" ") && register.length()<=40) || (register.contains(" ") && register.length()<=80)){
                    register+="3";
                    formulaView.setText(register);
                }
                break;
            case R.id.simpleMath4:
                if((!register.contains(" ") && register.length()<=40) || (register.contains(" ") && register.length()<=80)) {
                    register += "4";
                    formulaView.setText(register);
                }
                break;
            case R.id.simpleMath5:
                if((!register.contains(" ") && register.length()<=40) || (register.contains(" ") && register.length()<=80)){
                    register+="5";
                    formulaView.setText(register);
                }
                break;
            case R.id.simpleMath6:
                if((!register.contains(" ") && register.length()<=40) || (register.contains(" ") && register.length()<=80)){
                    register+="6";
                    formulaView.setText(register);
                }
                break;
            case R.id.simpleMath7:
                if((!register.contains(" ") && register.length()<=40) || (register.contains(" ") && register.length()<=80)){
                    register+="7";
                    formulaView.setText(register);
                }
                break;
            case R.id.simpleMath8:
                if((!register.contains(" ") && register.length()<=40) || (register.contains(" ") && register.length()<=80)){
                    register+="8";
                    formulaView.setText(register);
                }
                break;
            case R.id.simpleMath9:
                if((!register.contains(" ") && register.length()<=40) || (register.contains(" ") && register.length()<=80)){
                    register+="9";
                    formulaView.setText(register);
                }
                break;
            case R.id.simpleMathPlus:
                    if(!register.isEmpty()) {
                        if(!(register.contains(" * ") || register.contains(" / ") || register.contains(" + ") || register.contains(" - "))) {
                            register += " + ";
                            formulaView.setText(register);
                        }
                    }
                break;
            case R.id.simpleMathMinus:
                    if(!register.isEmpty()){
                        if (!(register.contains(" * ") || register.contains(" / ") || register.contains(" + ") || register.contains(" - "))) {
                            register += " - ";
                            formulaView.setText(register);
                        }
                    }
                break;
            case R.id.simpleMathMltp:
                    if(!register.isEmpty()){
                        if (!(register.contains(" * ") || register.contains(" / ") || register.contains(" + ") || register.contains(" - "))) {
                            register += " * ";
                            formulaView.setText(register);
                        }
                    }
                break;
            case R.id.simpleMathDiv:
                    if(!register.isEmpty()){
                        if (!(register.contains(" * ") || register.contains(" / ") || register.contains(" + ") || register.contains(" - "))) {
                            register += " / ";
                            formulaView.setText(register);
                        }
                    }
                break;
            case R.id.simpleMathDot:
                    if(!register.isEmpty()){
                        if(!register.contains(" ")){
                            if(!register.contains("."))
                                register += ".";
                        }else{
                            if(!register.substring(register.lastIndexOf(" ")).contains(".") && register.length()>register.lastIndexOf(" ")+1)
                                register += ".";
                        }
                        formulaView.setText(register);
                    }
                break;
            case R.id.simpleMathC:
                    register="";
                    simpleMath.clearRegisters();
                    formulaView.setText("");
                    resultView.setText("");
                    simpleMath.clearRegisters();
                    powYUsed = false;
                break;
            case R.id.simpleMathBkspc:
                    if(!register.isEmpty()) {
                        if(register.contains(" ") && (register.length()-1)==register.lastIndexOf(" ")){
                            register = register.substring(0, register.indexOf(" "));
                        }else {
                            if(register.contains("i") && register.length()==8)
                                register = "";
                            else
                                register = register.substring(0, register.length() - 1);
                        }
                        formulaView.setText(register);
                    }else
                        formulaView.setText("");
                break;
            case R.id.simpleMathPlsMin:
                    if(!register.isEmpty()){
                        if(!register.contains(" ")){
                            if("-".equals(""+register.charAt(0))) {
                                register = register.substring(1);
                            }else{
                                register = "-" + register;
                            }
                        }else {
                            if (register.length() > register.lastIndexOf(" ")+1) {
                                if ("-".equals("" + register.charAt(register.lastIndexOf(" ") + 1))) {
                                    register = register.substring(0, register.lastIndexOf(" ")+1) + register.substring(register.lastIndexOf(" ") + 2);
                                } else {
                                    register = register.substring(0, register.lastIndexOf(" ")+1)+"-" + register.substring(register.lastIndexOf(" ") + 1);
                                }
                            }
                        }
                        formulaView.setText(register);
                    }
                break;
            case R.id.simpleMathEquals:
                if(!register.isEmpty()){
                    if(!powYUsed) {
                        Double result = simpleMath.executeMathOperation(register);
                        updateViews(result);
                    }else{
                        if(powYFirstUse) {
                            poweringRegister = register;
                            register = swapRegister;
                            powYFirstUse = false;
                            Double result = simpleMath.calculatePow(register, poweringRegister);
                            updateViews(result);
                        }else {
                            if (register.contains(" * ") || register.contains(" / ") || register.contains(" + ") || register.contains(" - ")) {
                                Double result = simpleMath.executeMathOperation(register);
                                updateViews(result);
                                powYUsed = false;
                            }else {
                                Double result = simpleMath.calculatePow(register, poweringRegister);
                                updateViews(result);
                            }
                        }
                    }
                }else
                    resultView.setText("ERR");
                break;
            case R.id.advancedMathSin:
                    if(!register.isEmpty()){
                        Double result = simpleMath.calculateSin(register);
                        updateViews(result);
                    }else
                        resultView.setText("ERR");
                    powYUsed = false;
                break;
            case R.id.advancedMathCos:
                    if(!register.isEmpty()){
                        Double result = simpleMath.calculateCos(register);
                        updateViews(result);
                    }else
                        resultView.setText("ERR");
                    powYUsed = false;
                break;
            case R.id.advancedMathTan:
                    if(!register.isEmpty()){
                        Double result = simpleMath.calculateTan(register);
                        updateViews(result);
                    }else
                        resultView.setText("ERR");
                    powYUsed = false;
                break;
            case R.id.advancedMathLog:
                    if(!register.isEmpty()){
                        Double result = simpleMath.calculateLog(register);
                        updateViews(result);
                    }else
                        resultView.setText("ERR");
                    powYUsed = false;
                break;
            case R.id.advancedMathLn:
                    if(!register.isEmpty()){
                        Double result = simpleMath.calculateLn(register);
                        updateViews(result);
                    }else
                        resultView.setText("ERR");
                    powYUsed = false;
                break;
            case R.id.advancedMathSqPow:
                    if(!register.isEmpty()){
                        Double result = simpleMath.calculatePow(register,"2");
                        updateViews(result);
                    }else
                        resultView.setText("ERR");
                    powYUsed = false;
                break;
            case R.id.advancedMathYPow:
                    if(!register.isEmpty()){
                        swapRegister=register;
                        register="";
                        formulaView.setText("");
                        powYUsed = true;
                        powYFirstUse = true;
                    }
                break;
            case R.id.advancedMathSqrt:
                    if(!register.isEmpty()){
                        Double result = simpleMath.calculateSqrt(register);
                        updateViews(result);
                    }else
                        resultView.setText("ERR");
                break;
        }
    }

    private void updateViews(Double result){
            if(!Double.isNaN(result)) {
                formulaView.setText(Double.toString(result));
                register = Double.toString(result);
                resultView.setText(simpleMath.getLastAction());
            }else
                errorToast.show();
    }

    private void initializeViewElements(){
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
        Button simpleMathC = findViewById(R.id.simpleMathC);
        simpleMathC.setOnClickListener(this);
        Button simpleMathBkspc = findViewById(R.id.simpleMathBkspc);
        simpleMathBkspc.setOnClickListener(this);
        Button simpleMathPlus = findViewById(R.id.simpleMathPlus);
        simpleMathPlus.setOnClickListener(this);
        Button simpleMathMinus = findViewById(R.id.simpleMathMinus);
        simpleMathMinus.setOnClickListener(this);
        Button simpleMathMltp = findViewById(R.id.simpleMathMltp);
        simpleMathMltp.setOnClickListener(this);
        Button simpleMathDiv = findViewById(R.id.simpleMathDiv);
        simpleMathDiv.setOnClickListener(this);
        Button simpleMathDot = findViewById(R.id.simpleMathDot);
        simpleMathDot.setOnClickListener(this);
        Button simpleMathPlsMin = findViewById(R.id.simpleMathPlsMin);
        simpleMathPlsMin.setOnClickListener(this);
        Button simpleMathEquals = findViewById(R.id.simpleMathEquals);
        simpleMathEquals.setOnClickListener(this);

        if(calculatorMode==2){
            Button advancedMathSin = findViewById(R.id.advancedMathSin);
            advancedMathSin.setOnClickListener(this);
            Button advancedMathCos = findViewById(R.id.advancedMathCos);
            advancedMathCos.setOnClickListener(this);
            Button advancedMathTan = findViewById(R.id.advancedMathTan);
            advancedMathTan.setOnClickListener(this);
            Button advancedMathLog = findViewById(R.id.advancedMathLog);
            advancedMathLog.setOnClickListener(this);
            Button advancedMathLn = findViewById(R.id.advancedMathLn);
            advancedMathLn.setOnClickListener(this);
            Button advancedMathSqPow = findViewById(R.id.advancedMathSqPow);
            advancedMathSqPow.setOnClickListener(this);
            Button advancedMathYPow = findViewById(R.id.advancedMathYPow);
            advancedMathYPow.setOnClickListener(this);
            Button advancedMathSqrt = findViewById(R.id.advancedMathSqrt);
            advancedMathSqrt.setOnClickListener(this);
        }

        if(register.isEmpty())
            formulaView.setText("");
        else
            formulaView.setText(register);

        errorToast = Toast.makeText(getApplicationContext(), "Niewłaściwe Wyrażenie!", Toast.LENGTH_SHORT);
        errorToast.setGravity(Gravity.CENTER, 0, 0);
    }
}

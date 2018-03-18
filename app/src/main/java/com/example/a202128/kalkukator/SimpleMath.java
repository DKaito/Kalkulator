package com.example.a202128.kalkukator;

import android.util.Log;
import android.webkit.ConsoleMessage;

public class SimpleMath {

    float register, numberA, numberB;
    String[] splitted;
    String symbol="";

    public SimpleMath(){
        this.register = 0;
    }

    public float executeMathOperation(String equation){
        splitted = equation.split("[\\+\\-\\/\\*]");
        numberA = Float.parseFloat(splitted[0]);
        numberB = Float.parseFloat(splitted[2]);
        Log.d("Numbers",""+Float.toString(numberA)+" "+Float.toString(numberB));
        switch (symbol){
            case "+":
                add(numberA,numberB);
                break;
        }



        return  register;
    }

    public void set(float val){
        register = val;
    }

    public void add(float numberA, float numberB){
        register = register + numberB + numberB;
    }
}

package com.example.a202128.kalkukator;

import static java.lang.Double.NaN;

public class SimpleMath {

    private Double register, numberA, numberB;
    private String[] splitted;
    private String symbol, lastAction;

    SimpleMath(){
        this.register = 0.0;
        this.symbol = "";
        this.lastAction ="";
    }

    public Double executeMathOperation(String equation){
        try {
            splitted = equation.split(" ");
            if (splitted.length == 1) {
                numberA = Double.parseDouble(splitted[0]);
            } else if (splitted.length == 3) {
                numberA = Double.parseDouble(splitted[0]);
                numberB = Double.parseDouble(splitted[2]);
                symbol = splitted[1];
            } else {
                register = NaN;
                return register;
            }

            if (splitted.length == 1 && symbol.isEmpty()) {
                return numberA;
            } else if (symbol.equals("/") && numberB == 0) {
                register = NaN;
            } else {
                switch (symbol) {
                    case "+":
                        add(numberA, numberB);
                        break;
                    case "-":
                        sub(numberA, numberB);
                        break;
                    case "*":
                        multiply(numberA, numberB);
                        break;
                    case "/":
                        divide(numberA, numberB);
                        break;
                }
            }
            lastAction = symbol + " " + Double.toString(numberB);
            return register;
        }catch (Exception e){
            register = NaN;
            return register;
        }
    }

    public void add(Double numberA, Double numberB){
        register = numberA + numberB;
    }

    public void sub(Double numberA, Double numberB){
        register = numberA - numberB;
    }

    public void multiply(Double numberA, Double numberB){
        register = numberA * numberB;
    }

    public void divide(Double numberA, Double numberB){
        register = numberA / numberB;
    }
    
    public Double calculateSin(String equation){
        register=Math.sin(executeMathOperation(equation));
        lastAction = "Sin("+equation+")";
        return register;
    }

    public Double calculateCos(String equation){
        register=Math.cos(executeMathOperation(equation));
        lastAction = "Cos("+equation+")";
        return register;
    }

    public Double calculateTan(String equation){
        register=Math.tan(executeMathOperation(equation));
        lastAction = "Tan("+equation+")";
        return register;
    }

    public Double calculatePow(String equation, String pow){
        clearRegisters();
        double equationValue = executeMathOperation(equation);
        clearRegisters();
        double power = executeMathOperation(pow);
        register = Math.pow(equationValue,power);
        lastAction = "("+equation+")^("+pow+")";
        return register;
    }

    public Double calculateSqrt(String equation){
        register=Math.sqrt(executeMathOperation(equation));
        lastAction = "Sqrt("+equation+")";
        return register;
    }

    public Double calculateLog(String equation){
        register=Math.log10(executeMathOperation(equation));
        lastAction = "Log10("+equation+")";
        return register;
    }

    public Double calculateLn(String equation){
        register=Math.log(executeMathOperation(equation));
        lastAction = "Ln("+equation+")";
        return register;
    }

    public String getLastAction(){
           return lastAction;
    }

    public void clearRegisters(){
        numberA = NaN;
        numberB = NaN;
        symbol = "";
        register = 0.0;
    }

}

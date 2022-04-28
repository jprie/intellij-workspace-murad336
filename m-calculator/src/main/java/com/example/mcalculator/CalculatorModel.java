package com.example.mcalculator;

import java.util.function.DoubleBinaryOperator;

public class CalculatorModel {

    // Die Grundrechnungsarten die ich zur Verfügung habe
    private static final DoubleBinaryOperator add = (op1, op2) -> op1+op2;
    private static final DoubleBinaryOperator sub = (op1, op2) -> op1-op2;
    private static final DoubleBinaryOperator mult = (op1, op2) -> op1*op2;
    private static final DoubleBinaryOperator div = (op1, op2) -> op1/op2;
    private static final DoubleBinaryOperator mod = (op1, op2) -> op1%op2;

    private double operand1;
    private double operand2;

    private DoubleBinaryOperator operator;

    private double result;

    public void setOperatorAsString(String operatorString) throws Exception {

        operator = switch(operatorString) {
          case "+" -> add;
          case "-" -> sub;
          case "*" -> mult;
          case "/" -> div;
          case "mod" -> mod;
          default -> throw new Exception("Unknown operator");
        };
    }

    public void calculateResult() {

        result = operator.applyAsDouble(operand1, operand2);
    }

    public DoubleBinaryOperator getOperator() {
        return operator;
    }

    public double getOperand1() {
        return operand1;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void clear() {
        operand1 = 0.0;
        operand2 = 0.0;
        operator = null;
        result = 0.0;
    }
}

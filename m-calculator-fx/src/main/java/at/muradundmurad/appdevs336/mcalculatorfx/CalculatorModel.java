package at.muradundmurad.appdevs336.mcalculatorfx;

import java.util.function.DoubleBinaryOperator;

public class CalculatorModel {

    private static final DoubleBinaryOperator addOperator = Double::sum;
    private static final DoubleBinaryOperator subOperator = (op1, op2) -> op1 - op2;
    private static final DoubleBinaryOperator multOperator = (op1, op2) -> op1 * op2;
    private static final DoubleBinaryOperator divOperator = (op1, op2) -> op1 / op2;

    private double op1;
    private double op2;
    private DoubleBinaryOperator operator;
    private double result;

    public CalculatorModel() {
    }

    public void calculateResult() {
        if (operator == divOperator && op2 ==0) throw new ArithmeticException("Div / 0");
        result = operator.applyAsDouble(op1, op2);
    }

    public double getOp1() {
        return op1;
    }

    public void setOp1(double op1) {
        this.op1 = op1;
    }

    public double getOp2() {
        return op2;
    }

    public void setOp2(double op2) {
        this.op2 = op2;
    }

    public DoubleBinaryOperator getOperator() {
        return operator;
    }

    public void setOperator(DoubleBinaryOperator operator) {
        this.operator = operator;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setOperatorString(String operatorPressed) throws Exception {

        operator = switch(operatorPressed) {
            case "+" -> addOperator;
            case "-" -> subOperator;
            case "*" -> multOperator;
            case "/" -> divOperator;
            default -> throw new Exception("Unknown operator");
        };
    }

    public void clear() {

        op1 = 0.0;
        op2 = 0.0;
        operator = null;
        result = 0.0;
    }
}

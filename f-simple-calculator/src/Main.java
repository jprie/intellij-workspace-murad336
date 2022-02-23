public class Main {

    public static void main(String[] args) throws Exception {

        PlusOperation plusOperation = new PlusOperation();
        double sum = plusOperation.execute(2.3, 5.6);

        CalculatorOperation calculatorOperationPlus = plusOperation;
        double sum2 = calculatorOperationPlus.execute(3.4, 7.2);

        // Anonyme Klasse
        // Definiert ein Klasse
        // Implementiert ein Interface
        // Und es instantiiert die Klasse
        CalculatorOperation minusOperation = new CalculatorOperation() {
            @Override
            public double execute(double op1, double op2) {
                return op1 - op2;
            }
        };




        // Lambda-Variante sind beschränkt auf FunctionalInterfaces
        CalculatorOperation multiplyOperation = (double op1, double op2) -> { return op1 * op2; };


        multiplyOperation.execute(2.3, 5.6);
        multiplyOperation.execute(2.3, 5.6);
        multiplyOperation.execute(2.3, 5.6);
        multiplyOperation.execute(2.3, 5.6);
        multiplyOperation.execute(2.3, 5.6);

        CalculatorOperation[] calculatorOperations = {plusOperation, minusOperation, multiplyOperation};

        double a = 2.3;
        double b = 4.5;
        for (CalculatorOperation op : calculatorOperations) {

            System.out.println(op.execute(a, b));
        }


        // Annahme: wir bekommen über die UI einen Operator als String

        // Scanner blablabla
        String operatorString = "+";

        try {
            CalculatorOperation op = getCalculatorOperationFromString(operatorString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static CalculatorOperation getCalculatorOperationFromString(String operatorString) throws Exception {
        CalculatorOperation op = null;
        switch (operatorString) {
            case "+":
                op = (op1, op2) -> op1+op2;
                break;
            case "-":
                op = (op1, op2) -> op1-op2;
                break;
            case "*":
                op = (op1, op2) -> op1*op2;
                break;
            case "/":
                op = (op1, op2) -> op1/op2;
                break;
            default:
                throw new Exception("Unknown operator");
        }

        return op;
    }
}

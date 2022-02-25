import java.util.function.BinaryOperator;

public class Main {

    public static void main(String[] args) throws Exception {

        // 1. Variante: Definition und Instanzierung getrennt
        PlusOperation plusOperation = new PlusOperation();
        double result = plusOperation.execute(2.3, 4.5);

        // 2. Variante: anonyme Klasse
        CalculatorOperation minusOperation = new CalculatorOperation() {
            @Override
            public double execute(double op1, double op2) {
                return op1 - op2;
            }
        };

        // 3. Variante: Lambda Expression
        // Definiert nurmehr die Beziehung zwischen Input und Output
        CalculatorOperation multiplyOperation = (double op1, double op2) -> op1 * op2;

        // 3a. Variante: Mehr-zeilige Lambda expression
        CalculatorOperation divideOperation = (double op1, double op2) -> {

            if (op2 == 0) {
                throw new ArithmeticException("/ by 0");
            }
            return op1 / op2;
        };

        // 4. Variante: Methoden-Referenzen
        CalculatorOperation powOperation = Main::pow;

        // Verwende Referenz auf vorhandene Methode der Math-Klasse
        CalculatorOperation maxOperation = Math::max;

        // Verwendung eines vorhandenen FunctionalInterface aus der Java API
        BinaryOperator<Double> moduloOperation = (Double op1, Double op2) -> op1 % op2;

        // apply ist die zu implementierende Methode im FunctionalInterface BinaryOperator
        Double moduloResult = moduloOperation.apply(2.4, 6.7);
    }

    private static double pow(double op1, double op2) {

        return Math.pow(op1, op2);
    }
}

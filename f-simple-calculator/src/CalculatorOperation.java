@FunctionalInterface
public interface CalculatorOperation {

    // +, -, *, /
    double execute(double op1, double op2);

    // Führt wenn einkommentiert zu Fehler
//    void anyMethod();
}

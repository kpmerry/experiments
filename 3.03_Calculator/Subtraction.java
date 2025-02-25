public class Subtraction implements Operation {
    String symbol = "-";

    @Override
    public double calculate(double a, double b) {
        return a - b;
    }
}

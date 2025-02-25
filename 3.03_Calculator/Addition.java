public class Addition implements Operation {
    String symbol = "+";

    @Override
    public double calculate(double a, double b) {
        return a + b;
    }

}

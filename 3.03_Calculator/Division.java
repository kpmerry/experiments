public class Division implements Operation {
    String symbol = "/";

    @Override
    public double calculate(double a, double b) {
        return a / b;
    }

    public String getSymbol() {
        return symbol;
    }
}

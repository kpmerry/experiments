public class Addition implements Operation {
    protected String symbol = "+";

    @Override
    public double calculate(double a, double b) {
        return a + b;
    }

    public String getSymbol() {
        return symbol;
    }

}

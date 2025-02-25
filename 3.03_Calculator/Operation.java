public interface Operation {
    public abstract double calculate(double a, double b);

    public static double power(double a, double b) {
        return Math.pow(a, b);
    }

    public static double squareRoot(double a) {
        return Math.sqrt(a);
    }
}

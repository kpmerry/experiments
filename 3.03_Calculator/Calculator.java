import java.util.HashMap;
import java.util.Scanner;

public class Calculator {
    protected Scanner in;
    protected double ans; // Store each most-recent answer
    HashMap<String, Operation> supportedOpps;

    public Calculator() {
        in = new Scanner(System.in);
        supportedOpps = new HashMap<>();
        Addition a = new Addition();
        supportedOpps.put(a.getSymbol(), a);
        Subtraction b = new Subtraction();
        supportedOpps.put(b.getSymbol(), b);
        Division c = new Division();
        supportedOpps.put(c.getSymbol(), c);
        Multiplication d = new Multiplication();
        supportedOpps.put(d.getSymbol(), d);
    }

    public void startCalculator() {
        System.out.println("-- Calculator Starting --");
        runCalculator();
    }

    public void runCalculator() {
        System.out.print("Enter a calculation : ");
        String calc = in.nextLine();
        String[] calcElements = calc.split(" ");
        Operation opp = supportedOpps.get(calcElements[1]);
        ans = opp.calculate(Double.parseDouble(calcElements[0]), Double.parseDouble(calcElements[2]));
        System.out.println(ans);
    }
}

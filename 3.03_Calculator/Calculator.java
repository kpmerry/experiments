import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    protected Scanner in;
    protected double ans; // Store each most-recent answer
    ArrayList<Operation> supportedOpps;

    public Calculator() {
        in = new Scanner(System.in);
        supportedOpps = new ArrayList<>();
        supportedOpps.add(new Addition());
        supportedOpps.add(new Subtraction());
        supportedOpps.add(new Division());
        supportedOpps.add(new Multiplication());
    }

    public void startCalculator() {
        System.out.println("-- Calculator Starting --");
        runCalculator();
    }

    public void runCalculator() {
        System.out.print("Enter a calculation : ");
    }
}

import java.util.Scanner;

public class Calculator {
    protected Scanner in;
    protected double ans; // Store each most-recent answer

    public Calculator() {
        in = new Scanner(System.in);
    }

    public void startCalculator() {
        System.out.println("-- Calculator Starting --");
        runCalculator();
    }

    public void runCalculator() {
        System.out.print("Enter a calculation : ");
    }
}

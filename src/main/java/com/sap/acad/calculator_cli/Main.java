package com.sap.acad.calculator_cli;

import com.sap.acad.calculator.Calculator;

import java.util.Scanner;

public class Main {
    final static Calculator calculator = new Calculator();

    public static void main(String[] args) {
        Scanner CLIScanner = new Scanner(System.in);
        printHeader();
        while (CLIScanner.hasNextLine()) {
            System.out.print("Enter expression:");
            String expression = CLIScanner.nextLine();
            if (userWantsToQuit(expression))
                break;
            try {
                System.out.println(expression + " = " + calculateExpression(expression));
            } catch (UnsupportedOperationException unsupportedException) {
                System.out.println("This operation is not supported");
            }

        }
        System.out.println("Thank you for using the calculator!");

    }

    public static double calculateExpression(String expression) {
        return calculator.calculate(expression);
    }

    private static void printHeader() {
        System.out.println("=========================");
        System.out.println("Calculator");
        System.out.println("Enter 'exit' to exit");
        System.out.println("=========================");
    }

    public static boolean userWantsToQuit(String expression) {
        return expression.trim().toLowerCase().equals("exit");
    }

}

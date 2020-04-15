import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner CLIScanner = new Scanner(System.in);
        printHeader();
        while(true){
            System.out.print("Enter expression:");
            String expression = CLIScanner.nextLine();
            if(userWantsToQuit(expression))
                break;
            System.out.println(expression + " = " + calculator.calculate(expression));
        }
        System.out.println("Thank you for using the calculator!");

    }

    private static void printHeader(){
        System.out.println("=========================");
        System.out.println("Calculator");
        System.out.println("Enter 'exit' to exit");
        System.out.println("=========================");
    }

    private static boolean userWantsToQuit(String expression){
        return expression.equals("exit");
    }

}

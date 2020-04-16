import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final Calculator calculator = new Calculator();
        Scanner CLIScanner = new Scanner(System.in);
        printHeader();
        while(true){
            System.out.print("Enter expression:");
            String expression = CLIScanner.nextLine();

            if(userWantsToQuit(expression))
                break;

            try{
                System.out.println(expression + " = " + calculator.calculate(expression));
            }catch (UnsupportedOperationException unsupportedException){
                System.out.println("This operation is not supported");
            }

        }
        System.out.println("Thank you for using the calculator!");

    }


    private static void printHeader(){
        System.out.println("=========================");
        System.out.println("Calculator");
        System.out.println("Enter 'exit' to exit");
        System.out.println("=========================");
    }

    public static boolean userWantsToQuit(String expression){
        return expression.trim().toLowerCase().equals("exit");
    }

}

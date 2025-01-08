import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    // Basic operations
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return a / b;
    }

    public static double modulus(double a, double b) {
        return a % b;
    }

    public static double power(double a, double b) {
        return Math.pow(a, b);
    }

    // Handling operations with API interaction
    public static double advancedOperation(String operation, double a, double b) {
        try {
            switch (operation.toLowerCase().trim()) {
                case "add":
                case "+":
                    return add(a, b);
                case "subtract":
                case "-":
                    return subtract(a, b);
                case "multiply":
                case "*":
                    return multiply(a, b);
                case "divide":
                case "/":
                    return divide(a, b);
                case "modulus":
                case "%":
                    return modulus(a, b);
                case "power":
                case "^":
                    return power(a, b);
                default:
                    throw new IllegalArgumentException("Unsupported operation.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return Double.NaN;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the desired operation (e.g., add, subtract, multiply, divide, modulus, exponentiation) or its symbol (e.g., +, -, *, /, %, ^)");
        String operation = scanner.nextLine();

        double num1 = 0;
        double num2 = 0;

        try {
            System.out.println("Enter first number: ");
            num1 = scanner.nextDouble();

            System.out.println("Enter second number: ");
            num2 = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric values.");
            return;
        }

        double result = advancedOperation(operation, num1, num2);
        if (!Double.isNaN(result)) {
            System.out.println("Result: " + result);
        }
    }
}

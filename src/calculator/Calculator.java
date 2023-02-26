package calculator;

import java.util.function.BinaryOperator;

public class Calculator {

	/*Basic implementation*/
	public double add(double num1, double num2) {
        return num1 + num2;
    }
    
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }
    
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }
    
    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num1 / num2;
    }
    
    /*Switch implementation*/
    public double calculate(double num1, double num2, String operator) {
        double result;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }

        return result;
    }
    
    /*Functional implementation using BinaryOperator - although the if statement wouldn't be considered functional
     * it is an easier approach than including optionals.of() 
     * https://docs.oracle.com/javase/8/docs/api/java/util/function/BinaryOperator.html
     * */
    private static BinaryOperator<Double> add = (num1, num2) -> num1 + num2;
    private static BinaryOperator<Double> subtract = (num1, num2) -> num1 - num2;
    private static BinaryOperator<Double> multiply = (num1, num2) -> num1 * num2;
    private static BinaryOperator<Double> divide = (num1, num2) -> {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num1 / num2;
    };
    
    public double fCalculate(double num1, double num2, BinaryOperator<Double> operator) {
        return operator.apply(num1, num2);
    }
    
	public static void main(String[] args) {
		/*Basic*/
		System.out.println("Basic implementation: ");
		Calculator calculator = new Calculator();

		double result = calculator.add(2.5, 3.7);
		System.out.println("2.5 + 3.7 = " + result);

		result = calculator.subtract(5.4, 2.1);
		System.out.println("5.4 - 2.1 = " + result);

		result = calculator.multiply(4.2, 1.5);
		System.out.println("4.2 * 1.5 = " + result);

		result = calculator.divide(10.0, 2.0);
		System.out.println("10.0 / 2.0 = " + result);
		
		/*Switch*/
		System.out.println("\nSwitch implementation: ");
		
		result = calculator.calculate(2.5, 3.7, "+");
		System.out.println("2.5 + 3.7 = " + result);
		/*Alternative way - declare values as doubles and format the print line
		double num1 = 2.5;
        double num2 = 3.7;
        String operator = "+";
        double result = calculate(num1, num2, operator);
        System.out.printf("%.1f %s %.1f = %.1f%n", num1, operator, num2, result);
        */
		
		result = calculator.calculate(5.4, 2.1, "-");
		System.out.println("5.4 - 2.1 = " + result);

		result = calculator.calculate(4.2, 1.5, "*");
		System.out.println("4.2 * 1.5 = " + result);

		result = calculator.calculate(10.0, 2.0, "/");
		System.out.println("10.0 / 2.0 = " + result);
		
		/*Functional*/
		System.out.println("\nFunctional implementation: ");
		
		result = calculator.fCalculate(2.5, 3.7, add);
		System.out.println("2.5 + 3.7 = " + result);
		/*Alternative way - declare values as doubles and format the print line
		double num1 = 2.5;
        double num2 = 3.7;
        double result = calculate(num1, num2, add);
        System.out.printf("%.1f + %.1f = %.1f%n", num1, num2, result);
        */
		
		result = calculator.fCalculate(5.4, 2.1, subtract);
		System.out.println("5.4 - 2.1 = " + result);

		result = calculator.fCalculate(4.2, 1.5, multiply);
		System.out.println("4.2 * 1.5 = " + result);

		result = calculator.fCalculate(10.0, 2.0, divide);
		System.out.println("10.0 / 2.0 = " + result);
		
	}

}

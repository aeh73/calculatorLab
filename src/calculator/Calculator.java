package calculator;

public class Calculator {

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
    
	public static void main(String[] args) {
		Calculator calculator = new Calculator();

		double result = calculator.add(2.5, 3.7);
		System.out.println("2.5 + 3.7 = " + result);

		result = calculator.subtract(5.4, 2.1);
		System.out.println("5.4 - 2.1 = " + result);

		result = calculator.multiply(4.2, 1.5);
		System.out.println("4.2 * 1.5 = " + result);

		result = calculator.divide(10.0, 2.0);
		System.out.println("10.0 / 2.0 = " + result);

	}

}

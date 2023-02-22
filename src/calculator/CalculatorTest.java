package calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/* This test class contains five test methods, one for each of the add, subtract, multiply, and divide methods, as well as an additional test method testDivideByZero to test the case when the            	divide method is called with a second parameter of zero.
 * 
 * Each test method creates a Calculator object, calls the corresponding method with some inputs, and then uses the assertEquals method from the JUnit library to check that the result matches 	the expected value, within a tolerance of 0.001.
 * 
 * The testDivideByZero method uses the expected attribute of the @Test annotation to specify that it expects the divide method to throw an ArithmeticException when called with a second parameter of zero.
 * */
public class CalculatorTest {

	@Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(3.5, 3.7);
        assertEquals(7.2, result, 0.001);  
    }
	
	@Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        double result = calculator.subtract(5.4, 2.1);
        assertEquals(3.3, result, 0.001);
    }
	
	@Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        double result = calculator.multiply(4.2, 1.5);
        assertEquals(6.3, result, 0.001);
    }
	
	@Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        double result = calculator.divide(10.0, 2.0);
        assertEquals(5.0, result, 0.001);
    }
	
	@Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        Calculator calculator = new Calculator();
        calculator.divide(5.0, 0.0);
    }
}

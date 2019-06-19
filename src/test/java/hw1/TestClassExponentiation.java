package hw1;

import hw1.base.TestClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestClassExponentiation extends TestClass {
    @Test(dataProvider = "doubleOperands")
    public void testPow(double firstNum, double secondNum) {
        assertEquals(calculator.pow(firstNum, secondNum), Math.pow(firstNum, Math.floor(secondNum)),
                "The result of exponentiation " + firstNum + " raised to the " + secondNum + " power is unexpected ");
    }

    @Test(dataProvider = "doubleValues")
    public void testSqrt(double num) {
        // TODO Why is this if here? Is it required?
        if (num > 0) {
            assertEquals(calculator.sqrt(num), Math.sqrt(num),
                    "The result of a square root of " + num + " is unexpected ");
        }
    }
    @Test(dataProvider = "doubleValues")
    public void testSqrtFromValueLessZero(double num) {
        // TODO Why is this if here? Is it required?
        if (num < 0) {
            assertThrows(NumberFormatException.class, () -> calculator.sqrt(num));
        }
    }
}
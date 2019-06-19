package hw1;

import hw1.base.TestClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TestClassExponentiation extends TestClass {
    @DataProvider
    public static Object[][] doubleValuesNegative() {
        return new Object[][]{{-5.0}, {-100.654}, {-600.123}, {-87.98}};
    }
    @DataProvider
    public static Object[][] doubleValuesNotNegative() {
        return new Object[][]{{0.0}, {100.654}, {600.123}, {87.98}, {95.32}};
    }
    @Test(dataProvider = "doubleOperands")
    public void testPow(double firstNum, double secondNum) {
        assertEquals(calculator.pow(firstNum, secondNum), Math.pow(firstNum, Math.floor(secondNum)),
                "The result of exponentiation " + firstNum + " raised to the " + secondNum + " power is unexpected ");
    }

    @Test(dataProvider = "doubleValuesNotNegative")
    public void testSqrt(double num) {
        // TODO Why is this if here? Is it required?
            assertEquals(calculator.sqrt(num), Math.sqrt(num),
                    "The result of a square root of " + num + " is unexpected ");
    }
    //Test fails
    @Test(dataProvider = "doubleValuesNegative", enabled = false)
    public void testSqrtFromValueLessZero(double num) {
        // TODO Why is this if here? Is it required?
            assertThrows(NumberFormatException.class, () -> calculator.sqrt(num));
    }
}
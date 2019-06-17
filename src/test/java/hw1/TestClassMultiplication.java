package hw1;

import hw1.base.TestClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestClassMultiplication extends TestClass {
    @Test(dataProvider = "integerOperands")
    public void testIntegerMultiplication(int firstNum, int secondNum) {
        assertEquals(calculator.mult(firstNum, secondNum), firstNum * secondNum,
                "The result of multiplication " + firstNum + " multiplied by " + secondNum + "is unexpected ");
    }

    @Test(dataProvider = "longOperands")
    public void testLongMultiplication(long firstNum, long secondNum) {
        assertEquals(calculator.mult(firstNum, secondNum), firstNum * secondNum,
                "The result of multiplication " + firstNum + " multiplied by " + secondNum + "is unexpected ");
    }

    @Test(dataProvider = "doubleOperands")
    public void testDoubleMultiplication(double firstNum, double secondNum) {
        assertEquals(calculator.mult(firstNum, secondNum), firstNum * secondNum,
                "The result of multiplication " + firstNum + " multiplied by " + secondNum + "is unexpected ");
    }
}

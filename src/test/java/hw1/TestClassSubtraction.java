package hw1;

import hw1.base.TestClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestClassSubtraction extends TestClass {
    @Test(dataProvider = "integerOperands")
    public void testIntegerSubtraction(int firstNum, int secondNum) {
        assertEquals(calculator.sub(firstNum, secondNum), firstNum - secondNum,
                "The result of subtraction " + firstNum + " minus " + secondNum + " is unexpected ");
    }

    @Test(dataProvider = "longOperands")
    public void testLongSubtraction(long firstNum, long secondNum) {
        assertEquals(calculator.sub(firstNum, secondNum), firstNum - secondNum,
                "The result of subtraction " + firstNum + " minus " + secondNum + " is unexpected ");
    }

    @Test(dataProvider = "doubleOperands")
    public void testDoubleSubtraction(double firstNum, double secondNum) {
        assertEquals(calculator.sub(firstNum, secondNum), firstNum - secondNum,
                "The result of subtraction " + firstNum + " minus " + secondNum + " is unexpected ");
    }
}

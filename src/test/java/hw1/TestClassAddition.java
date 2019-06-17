package hw1;

import hw1.base.TestClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestClassAddition extends TestClass {
    @Test(dataProvider = "integerOperands")
    public void testIntegerAddition(int firstNum, int secondNum) {
        assertEquals(calculator.sum(firstNum, secondNum), firstNum + secondNum,
                "The result of addition " + firstNum + " add " + secondNum + " is unexpected ");
    }

    @Test(dataProvider = "longOperands")
    public void testLongAddition(long firstNum, long secondNum) {
        assertEquals(calculator.sum(firstNum, secondNum), firstNum + secondNum,
                "The result of addition " + firstNum + " add " + secondNum + " is unexpected ");
    }

    @Test(dataProvider = "doubleOperands")
    public void testDoubleAddition(double firstNum, double secondNum) {
        assertEquals(calculator.sum(firstNum, secondNum), firstNum + secondNum,
                "The result of addition " + firstNum + " add " + secondNum + " is unexpected ");
    }

}

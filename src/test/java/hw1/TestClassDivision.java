package hw1;

import hw1.base.TestClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestClassDivision extends TestClass {

    @Test(dataProvider = "integerOperands")
    public void testIntegerDivision(int firstNum, int secondNum) {
        // TODO The division to 0 should be separate test
        if (secondNum != 0) {
            assertEquals(calculator.div(firstNum, secondNum), firstNum / secondNum,
                    "The result of division " + firstNum + " by " + secondNum + "is unexpected ");
        }
    }

    @Test(dataProvider = "longOperands")
    public void testLongDivision(long firstNum, long secondNum) {
        // TODO The division to 0 should be separate test
        if (secondNum != 0L) {
            assertEquals(calculator.div(firstNum, secondNum), firstNum / secondNum,
                    "The result of division " + firstNum + " by " + secondNum + "is unexpected ");
        }
    }

    @Test(dataProvider = "doubleOperands")
    public void testDoubleDivision(double firstNum, double secondNum) {
        assertEquals(calculator.div(firstNum, secondNum), firstNum / secondNum,
                "The result of division " + firstNum + " by " + secondNum + "is unexpected ");
    }

    @Test(dataProvider = "integerOperands")
    void testIntegerDivisionToZero(int firstNum, int secondNum){
        if (secondNum == 0) {
            assertThrows(NumberFormatException.class, () -> calculator.div(firstNum, secondNum));
        }
    }
    @Test(dataProvider = "longOperands")
    void testLongDivisionToZero(long firstNum, long secondNum){
        if (secondNum == 0L) {
            assertThrows(NumberFormatException.class, () -> calculator.div(firstNum, secondNum));
        }
    }
}

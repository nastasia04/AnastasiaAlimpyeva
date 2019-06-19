package hw1;

import hw1.base.TestClass;
// TODO Unused imports
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TestClassDivision extends TestClass {

    @DataProvider
    public static Object[][] integerOperandsWithZero() {
        return new Object[][]{{65, 0}, {-500, 0}, {0, 0}, {95, 0}};
    }
    @DataProvider
    public static Object[][] longOperandsWithZero() {
        return new Object[][]{{0L, 0L}, {-2147483648L, 0L}, {1009877544L,0L}, {95L, 0L}};
    }

    @Test(dataProvider = "integerOperands")
    public void testIntegerDivision(int firstNum, int secondNum) {
        // TODO Why is this if here? Is it required?
            assertEquals(calculator.div(firstNum, secondNum), firstNum / secondNum,
                    "The result of division " + firstNum + " by " + secondNum + "is unexpected ");
    }

    @Test(dataProvider = "longOperands")
    public void testLongDivision(long firstNum, long secondNum) {
        // TODO Why is this if here? Is it required?
            assertEquals(calculator.div(firstNum, secondNum), firstNum / secondNum,
                    "The result of division " + firstNum + " by " + secondNum + "is unexpected ");
    }

    @Test(dataProvider = "doubleOperands")
    public void testDoubleDivision(double firstNum, double secondNum) {
        assertEquals(calculator.div(firstNum, secondNum), firstNum / secondNum,
                "The result of division " + firstNum + " by " + secondNum + "is unexpected ");
    }

    @Test(dataProvider = "integerOperandsWithZero")
    void testIntegerDivisionToZero(int firstNum, int secondNum){
        // TODO Why is this if here? Is it required?
            assertThrows(NumberFormatException.class, () -> calculator.div(firstNum, secondNum));
    }
    @Test(dataProvider = "longOperandsWithZero")
    void testLongDivisionToZero(long firstNum, long secondNum){
        // TODO Why is this if here? Is it required?
            assertThrows(NumberFormatException.class, () -> calculator.div(firstNum, secondNum));
    }
}
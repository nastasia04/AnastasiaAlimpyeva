package hw1;

import hw1.base.TestClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestClassPositiveAndNegative extends TestClass {

    @Test(dataProvider = "longValues")
    public void testPositiveLong(long num) {
        assertEquals(calculator.isPositive(num), num > 0L,
                "The result of function \"isPositive\" of " + num + "is unexpected ");
    }

    @Test(dataProvider = "longValues")
    public void testNegativeLong(long num) {
        assertEquals(calculator.isNegative(num), num < 0L,
                "The result of function \"isNegative\" of " + num + "is unexpected ");
    }
}

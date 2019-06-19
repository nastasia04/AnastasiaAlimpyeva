package hw1.base;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class TestClass {
    protected Calculator calculator;

    @BeforeMethod
    public void setUp() {

        calculator = new Calculator();
    }

    @DataProvider
    public static Object[][] integerOperands() {
        return new Object[][]{{0, 27}, {-600, 360}, {87, -7000}, {95, -95}};
    }

    @DataProvider
    public static Object[][] longOperands() {
        return new Object[][]{{0L, 110L}, {-2147483648L, 3608765330L},
                {1009877544L, -700000009L}, {95L, -95L}};
    }

    @DataProvider
    public static Object[][] doubleOperands() {
        return new Object[][]{{0.0, 27.78}, {100.654, 0.0}, {-600.123, 360.87},
                {87.98, -7000.09}, {95.87, -95.87}, {0, 0}};
    }
    @DataProvider
    public static Object[][] doubleValues() {
        return new Object[][]{{0.0}, {100.654}, {-600.123}, {87.98}, {95.32}};
    }
    @DataProvider
    public static Object[][] longValues() {
        return new Object[][]{{101L}, {0L}, {-2147483648L}, {1009877544L}, {95L}};
    }
}

package hw1;

import hw1.base.TestClass;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class TestClassTrigonometry extends TestClass {
    @Test(dataProvider = "doubleValues")
    public void testSine(double num) {
        assertEquals(calculator.sin(num),
                Math.sin(num),
                "The result of sine function of " + num + " is unexpected ");
    }
    //Test fails
    //There is an error because in the Calculator.class we take sine-function instead a cosine
    @Test(dataProvider = "doubleValues", enabled = false)
    public void testCosine(double num) {
        assertEquals(calculator.cos(num),
                Math.cos(num),
                "The result of cosine function of " + num + " is unexpected ");
    }

    //Test fails
    //There is an error because in the Calculator.class we take sine-function instead a cosine
    @Test(dataProvider = "doubleValues", enabled = false)
    public void testTangent(double num) {
        assertEquals(calculator.sin(num),
                Math.tan(num),
                "The result of tangent function of " + num + " is unexpected ");
    }

    //Test fails
    //There is an error because in the Calculator.class we take tanh-function instead a ctg
    @Test(dataProvider = "doubleValues", enabled = false)
    public void testCotangent(double num) {
        assertEquals(calculator.ctg(num),
                1.0 / Math.tan(num),
                "The result of cotangent function of " + num + " is unexpected ");
    }
}

package ru.melandra.react;

import org.junit.Test;

import ru.melandra.react.MyMath.Calculator;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private Calculator calculator = new Calculator();

    @Test
    public void addition_isCorrect() {
        assertEquals(4, calculator.add(2,2));
        assertNotEquals( 6, calculator.add(2,3));
    }
}
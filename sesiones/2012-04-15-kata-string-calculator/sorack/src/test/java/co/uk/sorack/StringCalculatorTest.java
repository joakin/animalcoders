package co.uk.sorack;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void shouldReturnZeroWithEmptyString() {
        assertEquals(0, StringCalculator.add(""));
    }
    
    @Test
    public void shouldReturnTheSameNumberWithOneNumber() {
        assertEquals(1, StringCalculator.add("1"));
    }
    
    @Test
    public void shouldAddTwoNumbers() {
        assertEquals(4, StringCalculator.add("2,2"));
    }
    
    @Test
    public void shouldAddMoreThanTwoNumbers() {
        assertEquals(5, StringCalculator.add("3,1,1"));
    }
    
    @Test
    public void shouldAllowNewLineAsDelimiter() {
        assertEquals(6, StringCalculator.add("3\n3"));
    }
    
    @Test
    public void shouldAllowCustomDelimiters() {
        assertEquals(7, StringCalculator.add("//;\n4;3"));
    }
    
    @Test
    public void shouldNotAllowNegativeNumbers() {
        try {
            StringCalculator.add("1,2,-3,4,-5");
            fail("exceptionExpected");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("-3"));
            assertTrue(e.getMessage().contains("-5"));
        }
    }
}

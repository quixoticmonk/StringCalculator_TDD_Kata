package io.oblivion;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

public class StringCalculatorTest {

    @Test
    public void emptyStringReturnsZero() {
        assertThat(StringCalculator.add(""), is(equalTo(0)));
    }

    @Test
    public void singleNumberReturnsTheValue() {
        assertThat(StringCalculator.add("1"), is(equalTo(1)));
    }

    @Test
    public void twoNumbersCommaDelimitedReturnsTheSum() {
        assertThat(StringCalculator.add("1,2"), is(equalTo(3)));
    }


    @Test
    public void threeNumbersCommaDelimitedReturnsTheSum() {
        assertThat(StringCalculator.add("1,2,3"), is(equalTo(6)));
    }

    @Test
    public void multipleNumbersCommaDelimitedReturnsTheSum() {
        assertThat(StringCalculator.add("1,2,3,23,12"), is(equalTo(1 + 2 + 3 + 23 + 12)));
    }

    @Test
    public void multipleNumbersAnyDelimitedReturnsTheSum() {
        assertThat(StringCalculator.add("1,2\n3,23\t12"), is(equalTo(1 + 2 + 3 + 23 + 12)));
    }

    @Test(expected = RuntimeException.class)
    public void negativeNumbersThrowException() {
        StringCalculator.add("1,-2,3");
    }

    @Test()
    public void negativeNumbersThrowExceptionWithMessage() {
        RuntimeException exception = null;
        try {
            StringCalculator.add("1,-2,3");
        }
        catch (RuntimeException e){
            exception = e;
        }
        assertNotNull(exception);
        assertThat(exception.getMessage(),is(equalTo("Negatives not allowed: [-2]")));
    }

    @Test
    public void numbersAbove1000ShouldbeIgnored() {
        assertThat(StringCalculator.add("1,2\n1000,23\t12"), is(equalTo(1 + 2 + 23 + 12)));
    }


}



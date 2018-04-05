package functions;

import main.logarithm.BasicLogarithm;
import main.logarithm.IBasicLog;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static java.lang.Math.log;
import static org.junit.Assert.assertTrue;
import static utils.Constants.EPS_TESTS_BASIC_LOG;

public class BasicLogarithmTest {
    private IBasicLog base;

    @Before
    public void setUp() {
        base = new BasicLogarithm();
    }

    // should not exist, returns NaN
    @Test
    public void testXLessThanZero() {
        assertEquals(log(-2.0), base.ln(-2.0), EPS_TESTS_BASIC_LOG);
        assertEquals(log(-3.0), base.ln(-3.0), EPS_TESTS_BASIC_LOG);
    }

    @Test
    public void testNearZero() {
        assertEquals(log(-0.1), base.ln(-0.1), EPS_TESTS_BASIC_LOG);
        assertEquals(log(0), base.ln(0.0), EPS_TESTS_BASIC_LOG);
        assertEquals(log(0.6), base.ln(0.6), EPS_TESTS_BASIC_LOG * 2);
    }

    // changes from fn < 0 to fn > 0
    @Test
    public void testXIsOne() {
        assertTrue(base.ln(1.001) > 0);
        assertEquals(0, base.ln(1.0), EPS_TESTS_BASIC_LOG);
        assertTrue(base.ln(0.999) < 0);
    }


    //@Ignore
    @Test
    public void testAtExp() {
        assertEquals(log(Math.E), base.ln(Math.E), EPS_TESTS_BASIC_LOG); // x = exp
        assertTrue(base.ln(Math.E - 0.001) < 1); // x < exp
        assertTrue(base.ln(Math.E + 0.001) > 1); // x > exp
    }

    // if (x > 1) fn (x) > 0
    @Test
    public void testMoreThanZero() {
        assertEquals(log(1.1), base.ln(1.1), EPS_TESTS_BASIC_LOG);
        assertTrue(log(1.1) > 0);
        assertEquals(log(5), base.ln(5.0), EPS_TESTS_BASIC_LOG);
        assertTrue(base.ln(5.0) > 0);
    }
}

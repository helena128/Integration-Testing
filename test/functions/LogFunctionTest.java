package functions;

import main.logarithm.ILogFunction;
import main.logarithm.LogarithmicFunction;
import org.junit.Before;
import org.junit.Test;
import stub.BasicLogarithmStub;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static java.lang.Math.log;

public class LogFunctionTest {
    private static final Double EPS = 1e-3;
    private ILogFunction fn;

    @Before
    public void setUp() {
        fn = new LogarithmicFunction(new BasicLogarithmStub());
    }

    // TODO: add tests for [0..1]

    /**
     * Test functions below zero
     */
    @Test
    public void testFunctionsBelowZero() {
        for (double i = -0.1; i > -3.0; i -= 0.1) {
            assertTrue(fn.lb(i).isNaN());
            assertTrue(fn.lb(i).isNaN());
            assertTrue(fn.log_3(i).isNaN());
            assertTrue(fn.log_5(i).isNaN());
            assertTrue(fn.log_10(i).isNaN());
        }
    }

    @Test
    public void testLnGreaterAndEqualToZero() {
        for (double i = 0.0; i < 4.0; i += 0.1) {
            assertEquals(log(i), fn.ln(i), EPS);
        }
    }

    @Test
    public void testLb() {
        assertEquals(fn.lb(2.0), 1, EPS);
        assertEquals(fn.lb(4.0), 2, EPS);
        assertEquals(fn.lb(16.0), 4, EPS);

        assertEquals(log(0) / log(2), fn.lb(0.0), EPS);
        assertEquals(log(0.1) / log(2), fn.lb(0.1), EPS);
        assertEquals(log(-0.1) / log(2), fn.lb(-0.1), EPS);
    }

    @Test
    public void testLog_3() {
        assertEquals(fn.log_3(3.0), 1, EPS);
        assertEquals(fn.log_3(9.0), 2, EPS);
        assertEquals(fn.log_3(81.0), 4, EPS);

        assertEquals(log(0) / log(3), fn.log_3(0.0), EPS);
        assertEquals(log(0.1) / log(3), fn.log_3(0.1), EPS);
        assertEquals(log(-0.1) / log(3), fn.log_3(-0.1), EPS);
    }

    @Test
    public void testLog_5() {
        assertEquals(fn.log_5(5.0), 1, EPS);
        assertEquals(fn.log_5(25.0), 2, EPS);
        assertEquals(fn.log_5(125.0), 3, EPS);

        assertEquals(log(0) / log(5), fn.log_5(0.0), EPS);
        assertEquals(log(0.1) / log(5), fn.log_5(0.1), EPS);
        assertEquals(log(-0.1) / log(5), fn.log_5(-0.1), EPS);
    }

    @Test
    public void testLog_10() {
        for (int i = 1; i < 10000; i ++) {
            assertEquals(log(i * 10), fn.log_5(i * 10.0), EPS);
            i *= 100;
        }

        assertEquals(log(0) / log(2), fn.lb(0.0), EPS);
        assertEquals(log(0.1) / log(2), fn.lb(0.1), EPS);
        assertEquals(log(-0.1) / log(2), fn.lb(-0.1), EPS);
    }
}

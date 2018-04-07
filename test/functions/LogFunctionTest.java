package functions;

import main.logarithm.ILogFunction;
import main.logarithm.LogarithmicFunction;
import org.junit.Before;
import org.junit.Test;
import stub.BasicLogarithmStub;
import stub.LogarithmFunctionStub;
import utils.Constants;

import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static java.lang.Math.log;

public class LogFunctionTest {
    private ILogFunction fn;
    private ILogFunction stub;

    @Before
    public void setUp() {
        fn = new LogarithmicFunction(new BasicLogarithmStub());
        stub = new LogarithmFunctionStub();
    }

    /**
     * Test functions below zero
     */
    @Test
    public void testFunctionsBelowZero() {
        for (double i = -0.1; i > -3.0; i -= 0.1) {
            assertTrue(fn.ln(i).isNaN());
            assertTrue(fn.lb(i).isNaN());
            assertTrue(fn.log_3(i).isNaN());
            assertTrue(fn.log_5(i).isNaN());
            assertTrue(fn.log_10(i).isNaN());
        }
    }

    @Test
    public void testLnGreaterAndEqualToZero() {
        for (double i = 0.0; i < 4.0; i += 0.1) {
            assertEquals(log(i), fn.ln(i), Constants.EPS_FN_LOG);
        }
    }

    @Test
    public void testLb() {
        assertEquals(1, fn.lb(2.0), Constants.EPS_FN_LOG);
        assertEquals(2, fn.lb(4.0), Constants.EPS_FN_LOG);
        assertEquals(4, fn.lb(16.0), Constants.EPS_FN_LOG);

        assertEquals(log(0) / log(2), fn.lb(0.0), Constants.EPS_FN_LOG);
        assertEquals(log(0.1) / log(2), fn.lb(0.1), Constants.EPS_FN_LOG);
        assertEquals(log(-0.1) / log(2), fn.lb(-0.1), Constants.EPS_FN_LOG);
    }

    @Test
    public void testLog_3() {
        assertEquals(1, fn.log_3(3.0),  Constants.EPS_FN_LOG);
        assertEquals(2, fn.log_3(9.0), Constants.EPS_FN_LOG);
        assertEquals(4, fn.log_3(81.0), Constants.EPS_FN_LOG);

        assertEquals(log(0) / log(3), fn.log_3(0.0), Constants.EPS_FN_LOG);
        assertEquals(log(0.1) / log(3), fn.log_3(0.1), Constants.EPS_FN_LOG);
        assertEquals(log(-0.1) / log(3), fn.log_3(-0.1), Constants.EPS_FN_LOG);
    }

    @Test
    public void testLog_5() {
        assertEquals(1, fn.log_5(5.0), Constants.EPS_FN_LOG);
        assertEquals(2, fn.log_5(25.0), Constants.EPS_FN_LOG);
        assertEquals(3, fn.log_5(125.0), Constants.EPS_FN_LOG);

        assertEquals(log(0) / log(5), fn.log_5(0.0), Constants.EPS_FN_LOG);
        assertEquals(log(0.1) / log(5), fn.log_5(0.1), Constants.EPS_FN_LOG);
        assertEquals(log(-0.1) / log(5), fn.log_5(-0.1), Constants.EPS_FN_LOG);
    }

    @Test
    public void testLog_10() {
        assertEquals(log(0) / log(10), fn.log_10(0.0), Constants.EPS_FN_LOG);
        assertEquals(log(0.1) / log(10), fn.log_10(0.1), Constants.EPS_FN_LOG);
        assertEquals(log(-0.1) / log(10), fn.log_10(-0.1), Constants.EPS_FN_LOG);

        assertEquals(1, fn.log_10(10.0), Constants.EPS_FN_LOG);
        assertEquals(2, fn.log_10(100.0), Constants.EPS_FN_LOG);
        assertEquals(5, fn.log_10(100000.0), Constants.EPS_FN_LOG);
    }

    @Test
    public void testFromZeroToOne() {
        for (double x = 0.1; x < 1.1; x += 0.1) {
            assertEquals(stub.lb(x), fn.lb(x), Constants.EPS_FN_LOG);
            assertEquals(stub.log_3(x), fn.log_3(x), Constants.EPS_FN_LOG);
            assertEquals(stub.log_5(x), fn.log_5(x), Constants.EPS_FN_LOG);
            assertEquals(stub.log_10(x), fn.log_10(x), Constants.EPS_FN_LOG);
        }
    }
}

package functions;

import main.IExpression;
import main.logarithm.LogExpression;
import org.junit.Before;
import org.junit.Test;

import stub.LogExpressionStub;
import stub.LogarithmFunctionStub;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class LogarithmExpressionTest {
    private IExpression logExpr;
    private IExpression stub;

    private static final Double EPS = 1e-2;

    @Before
    public void setUp() {
        logExpr = new LogExpression(new LogarithmFunctionStub());
        stub = new LogExpressionStub();
    }

    /**
     * Test points where does not exist
     */
    @Test
    public void testWhereDoesNotExist() {
        assertTrue(logExpr.calculate(-1.0).isNaN());
        assertTrue(logExpr.calculate(-2.0).isNaN());
    }

    // check [0 +inf]
    @Test
    public void testNearZero() {
        assertTrue(logExpr.calculate(-2.0).isNaN());
        assertTrue(logExpr.calculate(-0.001).isNaN());
        assertFalse(logExpr.calculate(0.001).isNaN());
        assertFalse(logExpr.calculate(5.0).isNaN());
    }

    @Test
    public void testNearOne() {
        assertTrue(logExpr.calculate(0.9) > 0);
        assertEquals(0, logExpr.calculate(1.0), EPS);
        assertTrue(logExpr.calculate(1.1) < 0);
    }


    /**
     * Above zero
     */
    @Test
    public void testLessThanOne() {
        for (double i = 0.01; i < 0.7; i += 0.1) {
            assertTrue(logExpr.calculate(i) > 0);
            //System.out.println(logExpr.calculate(i));
        }
    }

    /**
     * Below zero
     */
    @Test
    public void testMoreThanOne() {
        for (int i = 2; i < 10; i++) {
            assertTrue(logExpr.calculate(1.0 * i) < 0);
        }
    }

    @Test
    public void testWithStub() {
        for (double x = -0.1; x < 2; x += 0.1) {
            assertEquals(stub.calculate(x), logExpr.calculate(x), EPS);
        }
    }
}

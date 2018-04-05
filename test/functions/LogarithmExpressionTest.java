package functions;

import main.IExpression;
import main.logarithm.LogExpression;
import org.junit.Before;
import org.junit.Test;

import stub.LogarithmFunctionStub;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class LogarithmExpressionTest {
    private IExpression logExpr;

    private static final Double EPS = 1e-3;

    @Before
    public void setUp() {
        logExpr = new LogExpression(new LogarithmFunctionStub());
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
        //assertEquals(0, logExpr.calculate(1.0), EPS); // TODO: WTF??
        assertTrue(logExpr.calculate(1.1) < 0);
    }


    /**
     * Above zero
     */
    @Test
    public void testLessThanOne() {
        for (double i = 0.01; i < 0.7; i += 0.1) {
            //assertTrue(logExpr.calculate(i) > 0); // TODO: wtf???
            System.out.println(logExpr.calculate(i));
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
}

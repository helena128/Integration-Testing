package functions;

import main.IExpression;
import main.trigeometry.TrigeometricExpression;
import org.junit.Before;
import org.junit.Test;

import stub.TrigeometricFunctionStub;
import utils.Constants;

import static java.lang.Math.PI;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrigExpressionTest {
    private IExpression ex;

    @Before
    public void setup() {
        ex = new TrigeometricExpression(new TrigeometricFunctionStub());
    }

    /**
     * Test points where function doesn't exist
     */
    @Test
    public void testPointsWhereUndefined() {
        for (int i = -2; i < 5; i++) {
            assertTrue(ex.calculate(PI * i / 2).isNaN());
        }
    }

    /**
     * Test ascending
     * [-0.5 PI .. -PI / 8]
     */
    @Test
    public void testAscending() {
        double prev = ex.calculate((-0.4 + 0.01) * PI);
        for (double i = -0.4 + 0.02; i < -1 / 8; i += 0.01) {
            assertTrue(ex.calculate(i * PI) > prev);
            prev = ex.calculate(i * PI);
        }
    }

    /**
     * Test descending
     * (-Pi / 8..0) and (0 .. 0.5 Pi)
     */
    @Test
    public void testDecending() {
        // [-Pi/8..0]
        double prev = ex.calculate((- 1 / 8 + 0.01) * PI);
        for (double i = -1 / 8 + 0.002; i < -0.001; i += 0.001) {
            assertTrue(ex.calculate(i * PI) < prev);
            prev = ex.calculate(i * PI);
        }

        // [0.. 0,5 PI]
        prev = ex.calculate(0.01 * PI);
        for (double i = 0.02; i < 0.5; i += 0.01) {
            assertTrue(ex.calculate(i * PI) < prev);
            prev = ex.calculate(i * PI);
        }
    }

    /**
     * Testing critical points
     */
    @Test
    public void testCriticalPoints() {
        // test ascending before -Pk / 8
        assertTrue(ex.calculate(-PI / 8) > ex.calculate(-PI / 8 - 0.001));
        // descending after -PK / 8
        //assertTrue(ex.calculate(-PI / 8) > ex.calculate(-PI / 8 + 1e-25));
        //System.out.println(ex.calculate(-PI / 8 + Constants.EPS_TESTS) + " " + ex.calculate(-PI / 8 + 0.002 + Constants.EPS_TESTS));
        // TODO: fix this
    }
}

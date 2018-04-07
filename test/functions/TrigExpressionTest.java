package functions;

import main.IExpression;
import main.trigeometry.TrigeometricExpression;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import stub.TrigeometricExpressionStub;
import stub.TrigeometricFunctionStub;
import utils.Constants;

import static java.lang.Math.PI;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrigExpressionTest {
    private IExpression ex;
    private IExpression stub;

    @Before
    public void setup() {
        ex = new TrigeometricExpression(new TrigeometricFunctionStub());
        stub = new TrigeometricExpressionStub();
    }

    /**
     * Test points where function doesn't exist
     */
    @Test
    public void testPointsWhereUndefined() {
        assertTrue(ex.calculate(0.0).isNaN());
        assertFalse(ex.calculate(0.01).isNaN());
        assertFalse(ex.calculate(-0.01).isNaN());
        //System.out.println(ex.calculate(0.0));
    }

    @Test
    public void testPeriod() {
        assertEquals(ex.calculate(PI), stub.calculate(3 * PI), Constants.EPS_TESTS_BASIC_LOG);
        assertEquals(ex.calculate(PI), stub.calculate(5 * PI), Constants.EPS_TESTS_BASIC_LOG);
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
        assertTrue(ex.calculate(- PI / 8 + 0.02) < prev);


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
        // test ascending before -Pk / 4
        assertTrue(ex.calculate(-PI / 4) > ex.calculate(-PI / 4 - 0.001));
        // descending after -PK / 4
        assertTrue(ex.calculate(-PI / 4) < ex.calculate(-PI / 4 + 0.001));
    }

    /*@Ignore
    @Test
    public void testComparingWithStub() {
        for (double x = -3.0; x < -1.0; x += 0.1) {
            assertEquals(stub.calculate(x), ex.calculate(x), Constants.EPS_TESTS_BASIC_LOG);
        }
    }*/
}

package functions;

import main.trigeometry.IBasicTrig;
import main.trigeometry.TrigeometricBase;
import org.junit.Before;
import org.junit.Test;
import utils.Constants;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BasicTrigTest {
    private static final Double EPS = 0.3;
    private IBasicTrig base;

    @Before
    public void setUp() {
        base = new TrigeometricBase();
    }

    /**
     * Test points where cos(x) intersects the Ox
     */
    @Test
    public void testMoreThanZero() {
        // fn(x) > 0 if x is [-0.5 * Pi .. 0.5 * Pi]
        for (double i = -0.4; i < 0.4; i += 0.1) {
            assertTrue(base.cos(i * PI) > 0);
        }
        assertTrue(base.cos(-0.6 * PI) < 0);
        assertTrue(base.cos(0.6 * PI) < 0);

        assertTrue(base.cos(-PI / 4 + 2 * PI) > 0.0);
        assertTrue(base.cos(-0.7 * PI + 4 * PI) < 0.0);
    }

    @Test
    public void testLessThanZero() {
        // [0.5 * Pi .. 1.5 * PI]
        // -3 * PI / 4 + 2 Pi k
        assertTrue(base.cos(-3 * PI / 4) < 0);
        assertTrue(base.cos(-3 * PI / 4 + 2 * PI) < 0);
        assertTrue(base.cos(-3 * PI / 4 + 4 * PI) < 0);

        // Pi + 2 * Pi k
        assertEquals(base.cos(PI), -1, Constants.EPS_TESTS_BASIC_TRIG);
        assertEquals(base.cos(-PI), -1, Constants.EPS_TESTS_BASIC_TRIG);
        assertTrue(base.cos(PI + 2 * PI) < 0);
        assertTrue(base.cos(-PI + 6 * PI) < 0);

        // -0.75 * Pi
        assertTrue(base.cos(-0.75 * PI) < 0);
        assertTrue(base.cos(-0.75 * PI + 2 * PI) < 0);
        assertTrue(base.cos(-0.75 * PI + 18 * PI) < 0);
        //System.out.println(base.cos(-0.75 * PI + 18 * PI));
    }

    @Test
    public void testCriticalPoints() {
        // - 0.5 Pi
        assertTrue(base.cos(-PI / 2 - 0.1) - Constants.EPS_TESTS_BASIC_TRIG < 0);
        assertEquals( 0.0, base.cos(-PI / 2), Constants.EPS_TESTS_BASIC_TRIG);
        assertTrue(base.cos(- PI / 2 + 0.1) + Constants.EPS_TESTS_BASIC_TRIG > 0);

        // 0.5 Pi
        assertTrue(base.cos(PI / 2 - 0.1) > 0);
        assertEquals( 0.0, base.cos(PI / 2), Constants.EPS_TESTS_BASIC_TRIG);
        assertTrue(base.cos(PI / 2 + 0.1) < 0);
    }

    @Test
    public void compareWithOriginal() {
        for (double x = -1; x < 3; x += 0.1) {
            assertEquals(cos(x * PI), base.cos(x * PI), Constants.EPS_TESTS_BASIC_TRIG);
        }
    }

}

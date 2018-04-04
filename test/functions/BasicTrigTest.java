package functions;

import main.trigeometry.IBasicTrig;
import main.trigeometry.TrigeometricBase;
import org.junit.Before;
import org.junit.Test;

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
        // TODO: in loop (?)
        // [-0.5 * Pi .. 0.5 * Pi]
        assertTrue(base.cos(0.0) > 0.0);
        assertTrue(base.cos(-PI / 4) > 0.0);
        assertTrue(base.cos(PI / 4) > 0.0);
    }

    @Test
    public void testLessThanZero() {
        // [0.5 * Pi .. 1.5 * PI]
        // -3 * PI / 4 + 2 Pi k
        assertTrue(base.cos(-3 * PI / 4) < 0);
        assertTrue(base.cos(-3 * PI / 4 + 2 * PI) < 0);
        assertTrue(base.cos(-3 * PI / 4 + 4 * PI) < 0);

        // Pi + 2 * Pi k
        assertTrue(base.cos(PI) < 0);
        assertTrue(base.cos(-PI) < 0);
        assertTrue(base.cos(PI + 2 * PI) < 0);
        assertTrue(base.cos(-PI + 6 * PI) < 0);

        // -0.75 * Pi
        assertTrue(base.cos(-0.75 * PI) < 0);
        assertTrue(base.cos(-0.75 * PI + 2 * PI) < 0);
        assertTrue(base.cos(-0.75 * PI + 18 * PI) < 0);
    }

    @Test
    public void testCriticalPoints() {
        // - 0.5 Pi
        assertTrue(base.cos(-PI / 2 - 0.01) < 0);
        assertEquals( 0.0, base.cos(-PI / 2), EPS);
        assertTrue(base.cos(- PI / 2 + 0.1) + EPS > 0);

        // 0.5 Pi
        assertTrue(base.cos(PI / 2 - 0.01 - EPS) > 0);
        assertEquals( 0.0, base.cos(PI / 2), EPS);
        assertTrue(base.cos(PI / 2 + 0.01) + EPS > 0);
    }

}

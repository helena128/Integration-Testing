package functions;

import main.trigeometry.ITrigFunction;
import main.trigeometry.TrigeometricFunction;
import org.junit.Before;
import org.junit.Test;

import stub.TrigeometricBaseStub;
import utils.Constants;

import static java.lang.Math.PI;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrigFunctionTest {
    private static final Double EPS = 0.02;
    private ITrigFunction fn;

    @Before
    public void setup() {
        fn = new TrigeometricFunction(new TrigeometricBaseStub());
    }

    @Test
    public void testCos() {
        assertTrue(fn.cos(-PI / 2 - 0.1) < 0);
        assertEquals( 0.0, fn.cos(-PI / 2), EPS);
        assertTrue(fn.cos(-PI / 2 + 0.1) > 0);

        assertTrue(fn.cos(PI / 2 - 0.1) > 0);
        assertEquals(0.0, fn.cos(PI / 2), EPS);
        assertTrue(fn.cos(PI / 2 + 0.1) < 0);

        assertEquals(1.0, fn.cos(0.0), EPS);
        assertEquals(-1.0, fn.cos(-PI), EPS);

        assertTrue(fn.cos(PI / 4) > 0);
        assertTrue(fn.cos(-PI / 4) > 0);
        assertTrue(fn.cos(-3 * PI / 4) < 0);
        assertTrue(fn.cos(3 * PI / 4) < 0);
    }

    @Test
    public void testTg() {
        // points where doesn't exist - Pi + 2 Pi k
        assertTrue(fn.tg(PI).isNaN());
        assertFalse(fn.tg(PI - 0.1).isNaN());
        assertFalse(fn.tg(PI + 0.1).isNaN());

        assertTrue(fn.tg(PI + 2 * PI).isNaN());

        // test some 0.0 points
        assertTrue(fn.tg(0.01) > 0);
        assertEquals(0, fn.tg(0.0), EPS);
        assertTrue(fn.tg(-0.01) < 0);

        for (double x = -0.9; x < 0.9; x += 0.1) {
            assertEquals(Math.tan(x * PI), fn.tg(x * PI), EPS);
        }
    }

    @Test
    public void testSec() {
        // points where doesn't exist
        assertFalse(fn.sec(PI - 0.01).isNaN());
        assertFalse(fn.sec(PI + 0.01).isNaN());
        assertTrue(fn.sec(PI).isNaN());

        // check ascending
        double prev = fn.sec(0 * PI);
        for (double i = 0.1; i < 0.5; i += 0.1) {
            assertTrue(fn.sec(i * PI) > prev);
            prev = fn.sec(i * PI);
        }

        prev = fn.sec(0.6 * PI);
        for (double i = 0.7; i < 1; i += 0.1) {
            assertTrue(fn.sec(i * PI) > prev);
            prev = fn.sec(i * PI);
        }

        // test descending
        prev = fn.sec(-0.9 * PI);
        for (double i = -0.8; i < -0.6; i += 0.1) {
            assertTrue(fn.sec(i * PI) < prev);
            //System.out.println(fn.sec(i * PI));
            prev = fn.sec(i * PI);
        }

        prev = fn.sec(-0.4 * PI);
        for (double i = -0.3; i < 0; i += 0.1) {
            assertTrue(fn.sec(i * PI) < prev);
            prev = fn.sec(i * PI);
        }
    }
}

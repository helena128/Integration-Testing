package functions;

import main.trigeometry.ITrigFunction;
import main.trigeometry.TrigeometricFunction;
import org.junit.Before;
import org.junit.Test;

import stub.TrigeometricBaseStub;

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
        // TODO: add more tests for nearby points
        assertEquals( 0.0, fn.cos(-PI / 2), EPS);
        assertEquals(0.0, fn.cos(PI / 2), EPS);
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
        for (int i = -2; i < 5; i++) {
            assertTrue(fn.tg(PI + i * 2 * PI).isNaN());
        }

        // test some 0.0 points
        //assertEquals(Math.tan(0.0), fn.tg(0.0), EPS); // TODO: fix custom cos

    }

    @Test
    public void testSec() {
        // points where doesn't exist - Pi + 2 * Pi * k
        for (int i = -2; i < 5; i++) {
            //assertFalse(fn.sec(PI + 2 * PI * i + 0.01).isNaN());
            assertTrue(fn.sec(PI + 2 * PI * i).isNaN());
            //assertFalse(fn.sec(PI + 2 * PI * i + 0.01).isNaN());
        }

        // TODO: add more tests
    }
}

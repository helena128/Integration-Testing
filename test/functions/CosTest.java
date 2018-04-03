package functions;

import org.junit.Before;
import org.junit.Test;
import main.trigeometry.TrigeometricBase;

import static org.junit.Assert.assertEquals;
import static java.lang.Math.cos;
import static java.lang.Math.toRadians;

public class CosTest {
    private TrigeometricBase trigeometricBase;
    private static final Double EPS = 0.02;

    @Before
    public void setUp() {
        trigeometricBase = new TrigeometricBase();
    }

    @Test
    public void test() {
        assertEquals(cos(0), trigeometricBase.cos(0.0), EPS);
        //assertEquals(cos(PI), trigeometricBase.cos(PI), EPS); // TODO: wtf?
        assertEquals(cos(toRadians(45)), trigeometricBase.cos(toRadians(45)), EPS);
    }
}

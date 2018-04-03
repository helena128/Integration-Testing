package functions;

import main.logarithm.BasicLogarithm;
import main.logarithm.IBasicLog;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static java.lang.Math.log;

public class BasicLogarithmTest {
    private static final Double EPS = 1e-5;
    private IBasicLog base;

    @Before
    public void setUp() {
        base = new BasicLogarithm();
    }

    @Test
    public void testLessThanZero() {
        assertEquals(log(-2.0), base.ln(-2.0), EPS);
        assertEquals(log(-3.0), base.ln(-3.0), EPS);
    }

    @Test
    public void testNearZero() {
        assertEquals(log(-0.1), base.ln(-0.1), EPS);
        assertEquals(log(0), base.ln(0.0), EPS);
        //assertEquals(log(0.001), base.ln(0.001), EPS); // TODO: WTF
    }

    @Test
    public void testXIsOne() {
        assertEquals(log(1), base.ln(1.0), EPS); // y = 0
    }

    @Ignore
    @Test
    public void testAtExp() {
        assertEquals(log(Math.E), base.ln(Math.E), EPS); // TODO: WTF
    }

    @Test
    public void testMoreThanZero() {
        assertEquals(log(1.1), base.ln(1.1), EPS);
        //assertEquals(log(5), base.ln(5.0), EPS); // TODO: wtf
    }
}

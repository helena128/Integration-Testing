package functions;

import logarithm.BasicLogarithm;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static java.lang.Math.log;

public class LnTester {
    private static final Double EPS = 0.001;

    private BasicLogarithm basicLogarithm;

    @Before
    public void setUp() {
        basicLogarithm = new BasicLogarithm();
    }

    @Test
    public void testCases() {
        assertEquals(log(2), basicLogarithm.ln(2.0), EPS);
        assertEquals(log(Double.POSITIVE_INFINITY), basicLogarithm.ln(Double.POSITIVE_INFINITY), 0.2);
        try {
            assertEquals(log(Double.NEGATIVE_INFINITY), basicLogarithm.ln(Double.NEGATIVE_INFINITY), 0.2);
        } catch (IllegalArgumentException ex) { /* do nothing */ }
        assertEquals(log(0.0), basicLogarithm.ln(0.0), EPS);
    }
}

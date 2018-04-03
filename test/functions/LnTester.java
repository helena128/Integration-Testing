package functions;

import main.logarithm.BasicLogarithm;
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
    public void testLn() {
        assertEquals(log(-2), basicLogarithm.ln(-2.0), EPS); // negative testcase
        assertEquals(log(-0.01), basicLogarithm.ln(-0.1), EPS); // negative testcase
        assertEquals(log(0.0), basicLogarithm.ln(0.0), EPS);

        //assertEquals(log(0.01), basicLogarithm.ln(0.01), EPS); // TODO: wtf ???
        //assertEquals(log(0.5), basicLogarithm.ln(0.5), 0.02); // TODO: wtf ???
        assertEquals(log(1), basicLogarithm.ln(1.0), EPS);
        //assertEquals(log(Math.E), basicLogarithm.ln(Math.E), EPS); // TODO: wtf ???
        assertEquals(log(2), basicLogarithm.ln(2.0), EPS);
        //assertEquals(log(5), basicLogarithm.ln(5.0), EPS * 100); // TODO: wtf ???
    }

    @Test
    public void testLb() {

    }
}

package main.trigeometry;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class TrigeometricFunction {
    private static final double EPS = 1e-6;

    private TrigeometricBase base;

    public TrigeometricFunction() {
        this.base = new TrigeometricBase();
    }

    /**
     * Caculating cos of x based on the fact that  1 + tg^2 = 1 / cos^2
     * @param x - argument, in radians
     * @return - result of the tg method
     */
    public Double tg(Double x) {
        double res = 1 / pow(base.cos(x), 2) - 1;
        return res < EPS ? Double.NaN : res;
    }

    /**
     * Calculate sec of x using equation cos(x) = 1 / sec(x)
     * @param x
     * @return
     */
    public Double sec(Double x) {
        return (base.cos(x) < EPS) ? Double.NaN : (1 / base.cos(x));
    }
}

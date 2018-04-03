package main.trigeometry;

import static java.lang.Math.pow;

public class TrigeometricFunction implements ITrigFunction {
    private static final double EPS = 1e-6;

    private IBasicTrig base;

    public TrigeometricFunction() {
        this.base = new TrigeometricBase();
    }

    public TrigeometricFunction(IBasicTrig base) {
        this.base = base;
    }

    @Override
    public Double cos(Double x) {
        return base.cos(x);
    }

    /**
     * Caculating cos of x based on the fact that  1 + tg^2 = 1 / cos^2
     * @param x - argument, in radians
     * @return - result of the tg method
     */
    @Override
    public Double tg(Double x) {
        double res = 1 / pow(base.cos(x), 2) - 1;
        return res < EPS ? Double.NaN : res;
    }

    /**
     * Calculate sec of x using equation cos(x) = 1 / sec(x)
     * @param x
     * @return
     */
    @Override
    public Double sec(Double x) {
        return (base.cos(x) < EPS) ? Double.NaN : (1 / base.cos(x));
    }
}

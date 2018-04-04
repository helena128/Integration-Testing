package stub;

import main.trigeometry.ITrigFunction;

import static java.lang.Math.pow;

public class TrigeometricFunctionStub implements ITrigFunction {
    private static final Double EPS = 1e-5;

    @Override
    public Double cos(Double x) {
        return Math.cos(x);
    }

    /**
     * Caculating cos of x based on the fact that  1 + tg^2 = 1 / cos^2
     * @param x - argument, in radians
     * @return - result of the tg method
     */
    @Override
    public Double tg(Double x) {
        double res = 1 / pow(cos(x), 2) - 1;
        return res < EPS ? Double.NaN : res;
    }

    /**
     * Calculate sec of x using equation cos(x) = 1 / sec(x)
     * @param x
     * @return
     */
    @Override
    public Double sec(Double x) {
        return (cos(x) < EPS) ? Double.NaN : (1 / cos(x));
    }
}

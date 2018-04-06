package stub;

import main.trigeometry.ITrigExpression;
import static java.lang.Math.cos;
import static java.lang.Math.pow;

public class TrigeometricExpressionStub implements ITrigExpression {
    @Override
    public Double calculate(Double x) {
        return (Math.pow(Math.pow(((sec(x) * cos(x)) - tg(x)), 3), 3) / tg(x));
    }

    private static Double sec(Double x) {
        return 1 / cos(x);
    }

    private static Double tg(Double x) {
        double res = 1 / pow(cos(x), 2) - 1;
        return res < 1e-5 ? Double.NaN : res;
    }
}

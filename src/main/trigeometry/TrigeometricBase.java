package main.trigeometry;

import static java.lang.Math.pow;

public class TrigeometricBase {
    private static final Double EPS = 10e-5;
    private static final int MAX_ITERATIONS = 10000;


    public Double cos(Double x) {
        Double sum = 0.0, tmp = 10.0;

        for (int i = 0; tmp > EPS && i < MAX_ITERATIONS; i++) {
            tmp = pow(-1, i) * pow(x, 2 * i) / factorial(2 * i);
            sum += tmp;
        }

        return sum;
    }

    private int factorial(int x) {
        int res = 1;

        if (x <= 0) return res;

        for (int i = x; i > 0; i--) {
            res *= i;
        }
        return res;
    }
}

package logarithm;

public class BasicLogarithm {
    private static final int MAX_ITERATIONS = 5000;
    private Double eps;

    public BasicLogarithm() {
        this.eps = 0.000001;
    }

    public BasicLogarithm(Double eps) {
        this.eps = eps;
    }

    public Double ln(Double x) {
        double sum = 0.0, tmp = 10.0;

        if (x < 0) {
            throw new IllegalArgumentException("X must be >= 0!");
        }

        if (x == 0) {
            return Double.NEGATIVE_INFINITY;
        }

        if (x == Double.POSITIVE_INFINITY) {
            return x;
        }

        if (x <= 2) {
            x -= 1;

            for ( int i = 1; tmp > eps && i < MAX_ITERATIONS; i += 2 ) {
                tmp = (Math.pow(x, i)/(double) i - Math.pow(x, i + 1)/(double)(i + 1));
                sum += tmp;
            }
        } else {
            x = (x / (x - 1));

            for ( int i = 1; tmp < eps && i < MAX_ITERATIONS; i ++ ) {
                tmp = 1.0 / (i * Math.pow(x, i));
                sum += tmp;
            }
        }
        return sum;

    }
}

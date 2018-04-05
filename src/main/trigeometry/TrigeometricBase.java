package main.trigeometry;

import java.math.BigDecimal;
import static java.lang.Math.pow;
import static java.lang.Math.PI;

public class TrigeometricBase implements IBasicTrig {
    private static final Double EPS = 10e-5;
    private static final int MAX_ITERATIONS = 1000;

    @Override
    public Double cos(Double x) {
        Double sum = 0.0, tmp = 10.0;

        while (x > 2 * PI) {
            x -= 2 * PI;
            if (x >= 0 && x < 2 * PI) break;
        }

        while (x < 0) {
            x += 2 * PI;
            if (x >= 0 && x < 2 * PI) break;
        }

        for (int i = 0; Math.abs(tmp) > EPS && i < 15; i++) {
            tmp = pow(-1, i) * pow(x, 2 * i) / factorial(2 * i);
            //System.out.println("fact= " + factorial(2 * i) + " 2i = "+2*i);
            sum += tmp;
        }

        return sum;
    }

    private double factorial(int x) {
        BigDecimal res = BigDecimal.ONE;

        if (x <= 0) return res.doubleValue();

        for (int i = x; i > 0; i--) {
            res = res.multiply(BigDecimal.valueOf(i));
            //System.out.println(res);
        }
        return res.doubleValue();
    }

    public Double sin(Double x) {
        Double sum = 0.0, tmp = 10.0;

        for (int i = 0; Math.abs(tmp) > EPS && i < 15; i++) {
            tmp = pow(-1, i) * pow(x, 2 * i + 1) / factorial(2 * i + 1);
            //System.out.println("fact= " + factorial(2 * i) + " 2i = "+2*i);
            sum += tmp;
        }

        return sum;
    }
}
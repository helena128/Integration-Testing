package stub;

import main.logarithm.IBasicLog;

public class BasicLogarithmStub implements IBasicLog {
    public Double ln(Double x) {
        return x < 0 ? Double.NaN : Math.log(x);
    }

    /**
     *
     * @param x in radians
     * @return
     */
    private Double handleStub(Double x) {
        if (x < 0) return Double.NaN;
        if (x == 0) return Double.NEGATIVE_INFINITY; // 0
        if (x < 1) return 50.6619 * x - 7.1636; // 0 to 1
        if (x == 1) return 0.0; // 1
        if (Math.abs(x - Math.E) < 1e-6) return 1.0; // e
        return 0.005 * x + 2.8089; // 1 to inf
    }
}

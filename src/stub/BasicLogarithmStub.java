package stub;

import main.logarithm.IBasicLog;

public class BasicLogarithmStub implements IBasicLog {
    public Double ln(Double x) {
        return x < 0 ? Double.NaN : Math.log(x);
    }
}

package stub;

import main.logarithm.ILogFunction;

import static java.lang.Math.log;

public class LogarithmFunctionStub implements ILogFunction {

    @Override
    public Double ln(Double x) {
        return log(x);
    }

    @Override
    public Double lb(Double x) {
        return log(x) / log(2);
    }

    @Override
    public Double log_3(Double x) {
        return log(x) / log(3);
    }

    @Override
    public Double log_5(Double x) {
        return log(x) / log(5);
    }

    @Override
    public Double log_10(Double x) {
        return log(x) / log(10);
    }
}

package main.logarithm;

public class LogarithmicFunction implements ILogFunction {
    private IBasicLog base;

    public LogarithmicFunction() {
        base = new BasicLogarithm();
    }

    public LogarithmicFunction(IBasicLog base) {
        this.base = base;
    }

    @Override
    public Double ln(Double x) {
        return base.ln(x);
    }

    @Override
    public Double lb(Double x) {
        return calculate(x, 2.0);
    }

    @Override
    public Double log_3(Double x) {
        return calculate(x, 3.0);
    }

    @Override
    public Double log_5(Double x) {
        return calculate(x, 5.0);
    }

    @Override
    public Double log_10(Double x) {
        return calculate(x, 10.0);
    }

    private Double calculate(Double x, Double logBase) {
        return base.ln(x) / base.ln(logBase);
    }

}
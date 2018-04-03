package main.logarithm;

public class LogarithmicFunction {
    private BasicLogarithm basicLogarithm;
    private boolean isStub;

    public LogarithmicFunction() {
        basicLogarithm = new BasicLogarithm();
        isStub = false;
    }

    public Double calculate(Double x, Double base) {
        double res = basicLogarithm.ln(x) / basicLogarithm.ln(base);
        return res;
    }

    public Double calculate(Double x) {
        double res = basicLogarithm.ln(x);
        return res;
    }

}
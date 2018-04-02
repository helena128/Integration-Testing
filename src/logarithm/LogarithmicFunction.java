package logarithm;

public class LogarithmicFunction {
    private BasicLogarithm basicLogarithm;

    public LogarithmicFunction() {
        basicLogarithm = new BasicLogarithm();
    }

    public Double calculate(Double x, Double base) {
        return basicLogarithm.ln(x) / basicLogarithm.ln(base);
    }

    public Double calculate(Double x) {
        return basicLogarithm.ln(x);
    }
}
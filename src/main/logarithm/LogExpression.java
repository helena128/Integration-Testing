package main.logarithm;

import static java.lang.Math.pow;

public class LogExpression implements ILogExpression {
    private ILogFunction fun;

    public LogExpression(ILogFunction fun) {
        this.fun = fun;
    }

    public LogExpression() {
        this.fun = new LogarithmicFunction();
    }

    @Override
    public Double calculate(Double x) {
        if (x == 1.0) return 0.0;
        return  (((Math.pow((log_5(x) * log_2(x)), 2) / (log_2(x) - ln(x))) + ln(x)) * (log_3(x) -
                ((log_2(x) / log_10(x)) + log_5(x))));
    }

    private Double log_5(Double x) {
        return fun.log_5(x);
    }

    private Double log_2(Double x) {
        return fun.lb(x);
    }

    private Double ln(Double x) {
        return fun.ln(x);
    }

    private Double log_3(Double x) {
        return fun.log_3(x);
    }

    private Double log_10(Double x) {
        return fun.log_10(x);
    }
}

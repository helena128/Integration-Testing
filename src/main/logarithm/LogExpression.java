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
        return  (((((fun.log_5(x) * pow(fun.lb(x), 2))) /
                (fun.lb(x) - fun.ln(x))) + fun.ln(x)) * (fun.log_3(x) -
                ((fun.lb(x) / fun.log_10(x)) + fun.log_5(x))));
    }
}

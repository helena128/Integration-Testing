package stub;

import main.logarithm.ILogExpression;

import static java.lang.Math.log;

public class LogExpressionStub implements ILogExpression {

    @Override
    public Double calculate(Double x) {
        return (((Math.pow((log_5(x) * log_2(x)), 2) / (log_2(x) - ln(x))) + ln(x)) * (log_3(x) -
                ((log_2(x) / log_10(x)) + log_5(x))));
    }

    private Double log_5(Double x) {
        return log(x) / log(5);
    }

    private Double log_2(Double x) {
        return log(x) / log(2);
    }

    private Double ln(Double x) {
         return log(x);
    }

    private Double log_3(Double x) {
        return log(x) / log(3);
    }

    private Double log_10(Double x) {
        return log(x) / log(10);
    }
}

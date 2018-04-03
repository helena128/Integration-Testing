package stub;

import main.logarithm.ILogExpression;

import static java.lang.Math.log;

public class LogExpressionStub implements ILogExpression {

    @Override
    public Double calculate(Double x) {
        return (((((log(x) / log(5) * log(x) / log(2)) * log(x) / log(2))
                / (log(x) / log(2) - log(x))) + log(x)) * (log(x) / log(3) -
                (((log(x) / log(2)) / (log(x) / log(10))) + log(x) / log(5))));
    }
}

package utils;

import main.IExpression;
import main.logarithm.LogExpression;
import main.trigeometry.TrigeometricExpression;

public class SystemSolver {

    private IExpression log, trig;

    public SystemSolver(IExpression log, IExpression trig) {
        this.log = log;
        this.trig = trig;
    }

    public SystemSolver() {
        this.log = new LogExpression();
        this.trig = new TrigeometricExpression();
    }

    public Double solve(Double x) {
        return (x > 0) ? log.calculate(x) : trig.calculate(x);
    }
}

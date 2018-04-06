package main.trigeometry;

public class TrigeometricExpression implements ITrigExpression {
    private ITrigFunction fn;

    public TrigeometricExpression(ITrigFunction fn) {
        this.fn = fn;
    }

    public TrigeometricExpression() {
        fn = new TrigeometricFunction();
    }

    @Override
    public Double calculate(Double x) {
        if (fn.tg(x) == 0) return Double.NaN;
        return  (Math.pow(Math.pow(((fn.sec(x) * fn.cos(x)) - fn.tg(x)), 3), 3) / fn.tg(x));
        //return Math.pow(Math.pow(fn.sec(x) * fn.cos(x) - fn.tg(x), 3), 3) / fn.tg(x);
    }
}

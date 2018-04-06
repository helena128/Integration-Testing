import functions.*;
import main.logarithm.BasicLogarithm;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BasicLogarithmTest.class,
        BasicTrigTest.class,
        LogarithmExpressionTest.class,
        LogFunctionTest.class,
        TrigExpressionTest.class,
        TrigFunctionTest.class
})
public class CutomTestSuite {
}

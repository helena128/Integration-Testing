import main.IExpression;
import main.logarithm.*;
import main.trigeometry.*;
import utils.CustomLogger;
import utils.SystemSolver;

import java.util.Scanner;

public class Application {

    private final static String FILE_EXT = "_log.csv";
    private static Scanner sc;

    private IBasicLog baseLog;
    private ILogFunction logFunction;
    private IExpression logExpr;
    private IBasicTrig basicTrig;
    private ITrigFunction trigFunction;
    private IExpression trigExpr;
    private SystemSolver systemSolver;

    public static void main(String... args) {
        sc = new Scanner(System.in);
        Application app = new Application();
        app.exec();
    }

    private Application() {
        baseLog = new BasicLogarithm();
        logFunction = new LogarithmicFunction();
        logExpr = new LogExpression();
        basicTrig = new TrigeometricBase();
        trigFunction = new TrigeometricFunction();
        trigExpr = new TrigeometricExpression();
        systemSolver = new SystemSolver();
    }

    private void exec() {
        while (true) {
            printFunctions(); // show options
            workWithFunction();
        }
    }

    private void printFunctions() {
        System.out.println("\nEnter number of the function: ");
        System.out.println("1. Ln(x)");
        System.out.println("2. Lb(x)");
        System.out.println("3. Log_3(x)");
        System.out.println("4. Log_5(x)");
        System.out.println("5. Log_10(x)");
        System.out.println("6. Logarithmic_expression(x)");

        System.out.println("7. Cos(x)");
        System.out.println("8. Tg(x)");
        System.out.println("9. Sec(x)");
        System.out.println("10. Trigeometric_expression(x)");

        System.out.println("11. Final_system(x)");
    }

    private Double calculate(int fn, Double x) {
        switch (fn) {
            case 1:     return baseLog.ln(x);
            case 2:     return logFunction.lb(x);
            case 3:     return logFunction.log_3(x);
            case 4:     return logFunction.log_5(x);
            case 5:     return logFunction.log_10(x);
            case 6:     return logExpr.calculate(x);

            case 7:     return basicTrig.cos(x);
            case 8:     return trigFunction.tg(x);
            case 9:     return trigFunction.sec(x);
            case 10:    return trigExpr.calculate(x);

            case 11:    return systemSolver.solve(x);

            default:    return null;
        }
    }

    private void workWithFunction() {
        CustomLogger logger = new CustomLogger();
        Integer fn = detectFunction();
        if (fn == null) {
            handleWrongInput();
        } else {
            double[] borders = defineBordersAndStep();
            if (borders == null) {
                handleWrongInput();
            } else {
                // calculate function and write its results to csv file
                double min = borders[0], max = borders[1], step = borders[2];
                Double y;
                for (double x = min; x <= max; x += step) {
                    y = calculate(fn, x);
                    if (y != null) {
                        logger.log(fn.toString() + FILE_EXT, x, y); // TODO: uncomment
                        System.out.println("x = " + x + "\ty = " + y);
                    }
                }
            }
        }
    }

    // get min, max and step
    private double[] defineBordersAndStep() {
        double[] res = new double[3];
        try {
            System.out.println("\nEnter min:");
            res[0] = Double.parseDouble(sc.nextLine().replaceAll("\\s+", ""));
            System.out.println("\nEnter max:");
            res[1] = Double.parseDouble(sc.nextLine().replaceAll("\\s+", ""));
            System.out.println("\nEnter step:");
            res[2] = Double.parseDouble(sc.nextLine().replaceAll("\\s+", ""));
        } catch (NumberFormatException | NullPointerException exc) {
            return null;
        }
        return res;
    }

    private Integer detectFunction() {
        int option;
        try {
            option = Integer.parseInt(sc.nextLine().replaceAll("\\s+", "")); // replace spaces
        } catch (NumberFormatException | NullPointerException ex) { // handle incorrect string input
            return null;
        }

        // handle incorrect value input
        if (option < 1 || option > 11) {
            return null;
        }

        return option;
    }

    private void handleWrongInput() {
        System.out.println("Your input is wrong. Try one more time!");
    }

}

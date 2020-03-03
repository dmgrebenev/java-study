/*
Даны вещественные числа a, b, c (a ≠ 0). Решить уравнение ax^4 + bx^2 + c = 0.
 */

package Theme1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Task1_25 {
    public static void main(String[] args) throws Exception {
        InputParameters1_25 coefficients = new InputParameters1_25();
        double discriminant = discriminant(coefficients.a(), coefficients.b(), coefficients.c());
        searchDecision(coefficients, discriminant);
    }

    private static double discriminant(double a, double b, double c){
        return b * b - 4 * a * c;
    }

    private static void searchDecision(InputParameters1_25 coefficients, double discriminant){
        if (discriminant < 0) { returnNoDecision(); }
        else { decision(coefficients, discriminant); }
    }

    private static void returnNoDecision(){
        System.out.println("Уравнение не имеет решения");
    }

    private static void decision(InputParameters1_25 coefficients, double discriminant) {
        Double x1 = findX1(coefficients, discriminant);
        x1 = Math.sqrt(x1);
        Double x2 = null;
        if (discriminant > 0){
            x2 = findX2(coefficients, discriminant);
            x2 = Math.sqrt(x2); }

        resultBuilder(x1, x2);
    }

    private static double findX1(InputParameters1_25 coefficients, double discriminant){
        return ((-coefficients.b() + Math.sqrt(discriminant)) / ( 2 * coefficients.a()));
    }

    private static double findX2(InputParameters1_25 coefficients, double discriminant){
        return ((-coefficients.b() - Math.sqrt(discriminant)) / ( 2 * coefficients.a()));
    }

    private static void resultBuilder(Double x1, Double x2){
        String message = null;
        DecimalFormat df = new DecimalFormat("###.###");
        if (x1 == 0) {
            message = "X1 = 0";
            if (x2 != null && x2 > 0) {message = message + "\nX2 = " + df.format(x2)+ "\nX3 = " + df.format(-x2); }
        }
        else if (x1 > 0) {
            message = "X1 = " + df.format(x1) + "\nX2 = " + df.format(-x1);
            if (x2 != null && x2 == 0) {message = message + "\nX3 = 0";}
            else if (x2 != null && x2 > 0) {message = message + "\nX3 = " + df.format(x2)  + "\nX4 = " + df.format(-x2);}
        }

        if (message != null) {System.out.println(message);}
        else {returnNoDecision();}
    }

}

final class InputParameters1_25 {
    private final double a;
    private final double b;
    private final double c;

    public InputParameters1_25() throws Exception {
        System.out.println("Введите коэффициенты для уравнения ax^4+bx^2+c=0 (a!=0)");
        this.a = setParameter("a");
        if (a == 0) { throw new Exception("Коэффициент 'a' не может быть навным нулю");}
        this.b = setParameter("b");
        this.c = setParameter("c");
    }

    public double a() {
        return a;
    }

    public double b() {
        return b;
    }

    public double c() { return c; }

    private double setParameter(String parameter) {
        System.out.println("Введите коэффициент " + parameter);
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}

/*
Даны вещественные числа a, b, c (a ≠ 0). Решить уравнение ax^4 + bx^2 + c = 0.
 */

package Theme1;

import java.util.Scanner;

public class Task1_25 {
    public static void main(String[] args) throws Exception {
        InputParameters1_25 coefficients = new InputParameters1_25();
        double discriminant = discriminant(coefficients.a(), coefficients.b(), coefficients.c());

        if (discriminant < 0){returnNoDecision();}
        else if (discriminant == 0){returnDecision(coefficients);}
        else {returnTwoDecision(coefficients, discriminant);}
    }

    private static double discriminant(double a, double b, double c) throws Exception{
        return b * b - 4 * a * c;
    }

    private static void returnNoDecision(){
        System.out.println("Уравнение не имеет решения");
    }

    private static void returnDecision(InputParameters1_25 coefficients) {
        double x = Math.sqrt(findX1(coefficients, 0));
        System.out.println("X1 = " + x + "X2 = " + (-x));
    }

    private static void returnTwoDecision(InputParameters1_25 coefficients, double discriminant) {
        double x1 = Math.sqrt(findX1(coefficients, discriminant));
        double x2 = Math.sqrt(findX2(coefficients, discriminant));

        System.out.println("X1 = " + x1 + " " + "X2 = " + " " + (-x1) + " " + "X3 = " + x2 + " " + "X4 = " + (-x2));
    }

    private static double findX1(InputParameters1_25 coefficients, double discriminant){
        return ((-coefficients.b() + Math.sqrt(discriminant)) / ( 2 * coefficients.a()));
    }

    private static double findX2(InputParameters1_25 coefficients, double discriminant){
        return ((-coefficients.b() - Math.sqrt(discriminant)) / ( 2 * coefficients.a()));
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

/*
Даны вещественные числа a, b, c (a ≠ 0). Решить уравнение ax^4 + bx^2 + c = 0.
 */

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Task1_25 {
    public static void main(String[] args) {
        InputParameters1_25 coefficients = new InputParameters1_25();

    }
}

final class InputParameters1_25 {
    private final int a;
    private final int b;
    private final int c;

    public InputParameters1_25() {
        System.out.println("Введите коэффициенты для уравнения ax^4 + bx^2 + c = 0");
        this.a = setParameter("a");
        this.b = setParameter("b");
        this.c = setParameter("c");
    }

    public int a() {
        return a;
    }

    public int b() {
        return b;
    }

    public int c() {
        return c;
    }

    private int setParameter(String parameter) {
        System.out.println("Введите коэффициент " + parameter);
        Scanner input = new Scanner(System.in);
        int inputParameter = input.nextInt();
        return inputParameter;
    }
}

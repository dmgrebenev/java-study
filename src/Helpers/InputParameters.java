package Helpers;

import java.util.Scanner;

public class InputParameters {
    int countRow;
    int countColumn;
    int a;
    int b;
    int c;

    public int countRow() { return countRow; }

    public int countColumn() { return countColumn; }

    public int a() { return a; }

    public int b() { return b; }

    public int c() { return c; }

    public InputParameters(String task) throws Exception {
        switch (task) {
            case "1_25":
                setParametersTask1_25();
                break;
            case "2_18":
                setParametersTask2_18();
                break;
            case "2_38":
                setParametersTask2_38();
                break;
            default:
                setParametersNat();
        }
    }

    private void setParametersTask1_25() throws Exception {
        this.a = setParameter("a");
        checkError((a == 0), "Коэффициент 'a' не может быть навным нулю");
        this.b = setParameter("b");
        this.c = setParameter("c");
    }

    private void setParametersNat() throws Exception {
        this.a = setParameter("натуральное число");
        checkError((a < 1), "Введенное число должно быть натуральным");
    }

    private void setParametersTask2_18() throws Exception {
        this.a = setParameter("натуральное число больше 1");
        checkError((a < 2), "Введенное число должно быть больше 1");
    }

    private void setParametersTask2_38() throws Exception {
        this.countRow = setParameter("количество cтрок");
        checkError((countRow < 1), "Количество cтрок должно быть целым положительным числом");
        this.countColumn = setParameter("Количество столбцов");
        checkError((countRow < 1), "Количество столбцов должно быть целым положительным числом");
    }

    private static int setParameter(String parameter) throws Exception {
        System.out.println("Введите " + parameter);
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private static void checkError(Boolean condition, String message) throws Exception {
        if (condition) {
            throw new Exception(message);
        }
    }

}

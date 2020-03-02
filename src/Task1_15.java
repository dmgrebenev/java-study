/*
Вводить с клавиатуры последовательность вещественных чисел до 0 (сам 0 не входит в
последовательность). Найти длину самой длинной неубывающей подпоследователь-
ности подряд идущих чисел.
 */

import java.util.Scanner;

public class Task1_15 {
    public static void main(String[] args) {
        System.out.println("Введите последовательность вещественных чисел");
        Scanner input = new Scanner(System.in);
        Integer value = null;
        int i = 1;
        int counter = 0;
        Integer tmp = null;
        while (value == null || !value.equals(0)) {
            if (tmp != null && value >= tmp) {
                i++;
            }
            else {
                if (i > 1 && i > counter) {counter = i;}
                i = 1;
            }
            tmp = value;
            value = input.nextInt();
        }
        System.out.println(counter);
    }

}

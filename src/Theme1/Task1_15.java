/*
Вводить с клавиатуры последовательность вещественных чисел до 0 (сам 0 не входит в
последовательность). Найти длину самой длинной неубывающей подпоследователь-
ности подряд идущих чисел.
 */
package Theme1;

import java.util.Scanner;

public class Task1_15 {
    public static void main(String[] args) {
        System.out.println("Введите последовательность вещественных чисел");
        Scanner input = new Scanner(System.in);

        Integer value = null;
        Integer previousValue = null;
        int currentCounter = 1;
        int totalCounter = 1;

        while (value == null || !value.equals(0)) {
            if (previousValue != null) {
                currentCounter = (value >= previousValue) ? currentCounter + 1 :  1;
                if (totalCounter < currentCounter) {totalCounter++;}
            }
            previousValue = value;
            value = input.nextInt();
        }
        System.out.println(totalCounter);
    }
}

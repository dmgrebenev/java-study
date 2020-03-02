/*
1.38 Гребенев Д.С.

Дано натуральное число N.
Вывести все различные обыкновенные несократимые дроби,
принадлежащие интервалу от 0 до 1, знаменатели которых не превосходят N. 1
 */

package Theme1;
import java.util.*;

public class Task1_38 {
    public static void main(String[] args) {
        System.out.println("Введите натуральное число");

        Scanner input = new Scanner(System.in);
        int number;
        number = input.nextInt();

//       i1 знаменатель, i2 числитель
        for (int i1 = 1; i1 <= number; i1++) {
            for (int i2 = 1; i2 < i1; i2++) {
                if (nod(i1, i2) == 1) {
                    System.out.println(i2 + "/" + i1);
                }
            }
        }
    }

//      находиим наименьший общий делитель
    private static int nod(int x, int y) {
        int tmp = x % y;
        x = y;
        y = tmp;
        if (tmp > 0) {
            return nod(x, y);
        } else {
            return x;
        }
    }
}

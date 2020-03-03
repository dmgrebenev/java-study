/*
1.18 Гребенев Д.С.

Дано натуральное число N. Найти число, получаемое из N выбрасыванием всех нечетных цифр.
 */

package Theme1;
import Helpers.InputParameters;
public class Task1_18_1 {
    public static void main(String[] args) throws Exception {
        int number = (new InputParameters("")).a();

        String invert_result = "";
        int remainder;
        do {
            remainder = number % 10;
            if (remainder % 2 == 0) {
                invert_result += remainder;
            }
        } while ((number /= 10) != 0);

        System.out.println("Если выбросим все нечетные цифры то получим число:");
        int result = Integer.parseInt(invert_result);
        do {
            System.out.printf("" +(result % 10)+ "");
        } while ((result /= 10) != 0);
    }
}

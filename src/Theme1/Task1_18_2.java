/*
1.18 Гребенев Д.С.

Дано натуральное число N. Найти число, получаемое из N выбрасыванием всех нечетных цифр.
 */

package Theme1;
import Helpers.InputParameters;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task1_18_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = (new InputParameters("")).a();

        int mantis = 0;
        int newNum = 0;
        int count = 1;
        while (num != 0) {

            mantis = num % 10;
            num = (num - mantis) / 10;
            //count *= 10;
            if (mantis % 2 == 0){
                newNum = newNum + (mantis * count);
                count *= 10;

            }
        }
        System.out.println(newNum);
    }
}

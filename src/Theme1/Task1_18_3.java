/*
1.18 Гребенев Д.С.

Дано натуральное число N. Найти число, получаемое из N выбрасыванием всех нечетных цифр.
 */

package Theme1;
import java.util.*;
public class Task1_18_3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        System.out.println("Введите число");
        number = input.nextInt();

        int[] arr = new int[10];
        int cnt = digits(arr, number);
        System.out.println("Если убрать все нечетные цифры то получим:");
        for(int i = 0; i < cnt; ++i)
            if (arr[i]%2==0) {System.out.printf("%d", arr[i]);}
    }

    public static int digits(int[] arr, int num){
        int n = 0;
        do {
            arr[n] = num % 10;
            if(arr[n] < 0)
                arr[n] = -arr[n];
            ++n;
        } while((num /= 10) != 0);

        int t, i = 0, m = n / 2;
        for(; i < m; ++i){
            t = arr[n - 1 - i];
            arr[n - 1 - i] = arr[i];
            arr[i] = t;
        }
        return n;
    }
}

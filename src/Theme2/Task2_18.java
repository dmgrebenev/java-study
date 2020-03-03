/* Гребенев Д.С.
Дано натуральное число 𝑛 ≥ 2.
Заполнить массив 𝑥 и массив 𝑦 размера 𝑛 случайными целыми числами из диапазона [0; 2𝑛] так,
чтобы в каждом массиве не было повторов. Рассматривая массивы как конечные множества целых чисел,
построить массив, равный 𝑥𝛥𝑦 (симметрическая разность)
*/

package Theme2;

import Helpers.InputParameters;

public class Task2_18 {
    public static void main(String[] args) throws Exception {
        int number = (new InputParameters("2_18")).a();
        int[] array1 = createArray(number);
        int[] array2 = createArray(number);
        System.out.println(showArray("Первый массив:", array1));
        System.out.println(showArray("Второй массив:", array2));

        int[] resultArray = combineArray(array1, array2);
        System.out.println(showArray("Итоговый массив:", resultArray));

    }

    private static int[] createArray(int number) {
        int[] array = new int[number];
        for (int i = 0; i < array.length; i++) {
            while (true) {
                int value = (int) (Math.random() * 2 * number);
                if (checkArray(array, value)) {
                    array[i] = value;
                    break;
                }
            }
        }
        return array;
    }

    private static boolean checkArray(int[] arr, int value) {
        boolean result = true;
        for (int arr_value : arr) {
            if (arr_value == value) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static int[] combineArray(int[] array1, int[] array2) {
        int[] intermediateArray = new int[array1.length * 2];
        for (int i = 0; i < intermediateArray.length; i++) { intermediateArray[i] = -1; }
        addElementsToArray(array1, array2, intermediateArray);
        addElementsToArray(array2, array1, intermediateArray);

        int i = 0;
        for (int value : intermediateArray) {
            if (value != -1) {
                i++;
            }
        }

        int[] resultArray = new int[i];
        i = 0;
        for (int value : intermediateArray) {
            if (value != -1) {
                resultArray[i] = value;
                i++;
            }
        }
        return resultArray;
    }

    private static void addElementsToArray(int[]array1, int[]array2, int[]intermediateArray) {
        int i = 0;
        for (int value : intermediateArray) {
            if (value == -1) {break;}
            i++;
        }
        for (int valueArray1 : array1) {
            for (int iArray2 = 0; iArray2 < array2.length; iArray2++) {
                if (valueArray1 == array2[iArray2]) {
                    break;
                }
                if (iArray2 + 1 == array2.length) {
                    intermediateArray[i] = valueArray1;
                    i++;
                }
            }
        }
    }

    private static String showArray(String message, int[] showingArray) {
        System.out.println(message);
        String arrayAsString = "";
        for (int value : showingArray) {
            arrayAsString = arrayAsString + " " + value;
        }
        return arrayAsString;
    }
}

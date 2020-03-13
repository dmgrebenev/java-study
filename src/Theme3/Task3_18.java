/*  Гребенев Д.С.
Во входном файле расположены данные о студентах, в каждой строке фамилия, имя, одна или несколько оценок (от 2 до 5).
Вывести в выходной файл список студентов и их средних оценок в порядке убывания.
 */

package Theme3;


import Helpers.InputParameters;

import java.io.*;
import java.util.*;

public class Task3_18 {
    public static void main(String[] args) throws Exception {
        InputParameters input = new InputParameters("3_18");



        String[] arrayOfLine = new String[10];
        try {
            FileReader fr = new FileReader(input.file);
            Scanner scan = new Scanner(fr);
            int i = 0;
            // чтение из файла
            while (scan.hasNextLine()) {
                arrayOfLine[i] = scan.nextLine();
                i++;
            }
            scan.close();
        } catch (FileNotFoundException e) { System.err.println(e); }

        for (String value : arrayOfLine) {
            System.out.println(value);
        }
    }

//  Подсчет количества строк в файле
    private static int lineCounter(File file) {
        int i = 0;

        return i;
    }

}

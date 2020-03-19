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

        int countLine = lineCounter(input.file);
        String[] arrayOfLine = allLineToArray(input.file, countLine);
        String[][] newMatrixOfLine = createIntermediateMatrix(new String[countLine][2], arrayOfLine);
        sortMatrix(newMatrixOfLine);

        returnFile(newMatrixOfLine, input.file);
    }

    //  Подсчет количества строк в файле
    private static int lineCounter(File file) {
        int i = 0;
        try {
            FileReader fr = new FileReader(file);
            Scanner scan = new Scanner(fr);
            while (scan.hasNextLine()) {
                i++;
                scan.nextLine();
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return i;
    }

    // перевод файла в массив строк (построчно)
    private static String[] allLineToArray(File file, int countLine) {
        String[] arrayOfLine = new String[countLine];
        try {
            FileReader fr = new FileReader(file);
            Scanner scan = new Scanner(fr);
            int i = 0;
            // чтение из файла
            while (scan.hasNextLine()) {
                arrayOfLine[i] = scan.nextLine();
                i++;
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return arrayOfLine;
    }

    // возврат файла
    private static void returnFile(String[][] matrix, File file) {
        FileWriter fw = null;

        try {
            File newFile = new File(file + ".new");
            newFile.delete();
            fw = new FileWriter(file + ".new", true);
        } catch (IOException e) {
            System.err.println("ошибка открытия потока " + e);
            System.exit(1);
        }

        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        for (int i = 0; i < matrix.length; i++) {
            pw.printf(matrix[i][0] + matrix[i][1] + "\n");
        }
        pw.close();
    }

    // Построение матрицы с ФИО, средней оценкой
    private static String[][] createIntermediateMatrix(String[][] newMatrixOfLine, String[] arrayOfLine) {
        for (int i = 0; i < arrayOfLine.length; i++) {
            String[] words = arrayOfLine[i].split(" ");
            double sum = 0.0;
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                try {
                    sum += Double.parseDouble(words[j]);
                    count++;
                } catch (NumberFormatException e) {
                    if (newMatrixOfLine[i][0] == null) {
                        newMatrixOfLine[i][0] = words[j] + " ";
                    } else {
                        newMatrixOfLine[i][0] += words[j] + " ";
                    }
                }
            }
            newMatrixOfLine[i][1] = String.valueOf((sum / count));
        }
        return newMatrixOfLine;
    }

    // Сортировка по убыванию средних оценок
    private static String[][] sortMatrix(String[][] matrix) {
        String[] b;
        for (int i = 0; i < matrix.length; i++) {
            for (int k = i + 1; k < matrix.length; k++) {
                if (Double.parseDouble(matrix[i][1]) < Double.parseDouble(matrix[k][1])) {
                    b = matrix[i];
                    matrix[i] = matrix[k];
                    matrix[k] = b;
                }
            }

        }

        return matrix;
    }
}

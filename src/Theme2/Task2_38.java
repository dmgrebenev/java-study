/* Гребенев Д.С.
Дана прямоугольная целочисленная матрица размера m строк и n столбцов.
Последовательность элементов матрицы, расположенных по чётным строкам слева направо,
по нечётным строкам справа налево, (строки рассматриваем последовательно сверху вниз) назовем «змейкой».
Сдвинуть циклически элементы змейки на одну позицию к концу
 */
package Theme2;
import java.util.Scanner;
import Helpers.InputParameters;

public class Task2_38 {
    public static void main(String[] args) throws Exception {
        InputParameters matrixSize = new InputParameters("2_38");
        int[][] matrix = createMatrix(matrixSize.countRow(), matrixSize.countColumn());
        makingMatrices(matrix);
    }

    private static int[][] createMatrix(int countRow, int countColumn) {
        int[][] matrix = new int[countRow][countColumn];

        for (int i = 0; i < countRow; i++) {
            for (int j = 0; j < countColumn; j++) {
                if (i % 2 == 0) {
                    matrix[i][j] = j + 1;
                } else {
                    matrix[i][j] = countColumn - j;
                }
            }
        }

        return matrix;
    }

    private static void makingMatrices(int[][] matrix){
        String command = null;
        while (command == null || !command.equals("exit")) {
            if (command != null) {matrix = shiftMatrix(matrix, command);}
            showMatrixInTerminal(matrix);
            command = setCommand();
        }
    }

    private static void showMatrixInTerminal(int[][] matrix) {
        for (int[] row : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(row[j] + "\t");
            }
            System.out.println();
        }
    }

    private static int[][] shiftMatrix(int[][] matrix, String command) {
        switch (command) { // TODO Можно добавить разные команды пока только 'shift'
            case ("shift"):
                matrix = rigthShift(matrix);
                break;
        }
        return matrix;
    }

    private static int[][] rigthShift(int[][] matrix){
        int cache = 0;
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                int tmp = row[i];
                row[i] = cache;
                cache = tmp;
            }
        }
        return matrix;
    }

    private static String setCommand() {
        System.out.println("Для сдвига матрицы введите 'shift', для выхода 'exit'");
        Scanner input = new Scanner(System.in);
        String command = input.nextLine();
        if (!command.equals("shift") && !command.equals("exit")) {
            System.out.println("Неизвестная команда");
            command = setCommand();
        }
        return command;
    }

}


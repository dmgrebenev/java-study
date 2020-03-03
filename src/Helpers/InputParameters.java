package Helpers;

import java.util.Scanner;

public class InputParameters {
    int countRow;
    int countColumn;
    public int countRow(){ return countRow; }
    public int countColumn(){ return countColumn; }

    public InputParameters(String task) throws Exception {
        switch (task) {
            case "2_38": {setParametersTask2_38();}
        }
    }

    private void setParametersTask2_38() throws Exception {
        this.countRow = setParameter("количество cтрок");
        checkError( (countRow < 1), "Количество cтрок должно быть целым положительным числом");
        this.countColumn = setParameter("Количество столбцов");
        checkError( (countRow < 1), "Количество столбцов должно быть целым положительным числом");
    }

    private static int setParameter(String parameter) throws Exception {
        System.out.println("Введите " + parameter);
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private static void checkError(Boolean condition, String message) throws Exception{
        if (condition) {throw new Exception(message);}
    }

}

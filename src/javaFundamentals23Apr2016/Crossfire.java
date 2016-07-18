package javaFundamentals23Apr2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Created by MapuH on 09-Jul-2016
 *
 * Description, solution and test can be found at:
 * https://judge.softuni.bg/Contests/183/Java-Fundamentals-Exam-23-April-2016
 */
public class Crossfire {

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            String matrixLine = "";
            for (int col = 0; col < matrix.get(row).size(); col++) {
                matrixLine += matrix.get(row).get(col) + " ";
            }
            System.out.println(matrixLine.trim());
        }
    }

    private static void filterMatrix(ArrayList<ArrayList<Integer>> matrix) {
        Integer[] removeArray = new Integer[] {-1};
        for (int row = 0; row < matrix.size(); row++) {
            matrix.get(row).removeAll(Arrays.asList(removeArray));
        }
        matrix.removeAll(Arrays.asList(new ArrayList<Integer>()));
    }

    private static boolean isInMatrix(int targetRow, int targetCol, ArrayList<ArrayList<Integer>> matrix) {
        return targetRow >= 0 && targetRow < matrix.size() && targetCol >= 0 && targetCol < matrix.get(targetRow).size();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int x = input.nextInt();
        int y = input.nextInt();
        input.nextLine();

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < x; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < y; j++) {
                matrix.get(i).add(count);
                count++;
            }
        }

        String line = input.nextLine();
        while (!line.equals("Nuke it from orbit")) {
            String[] lineArgs = line.trim().split("\\s");
            int row = Integer.parseInt(lineArgs[0]);
            int col = Integer.parseInt(lineArgs[1]);
            int radius = Integer.parseInt(lineArgs[2]);

            for (int targetRow = row - radius; targetRow <= row + radius; targetRow++) {
                if (isInMatrix(targetRow, col, matrix)) {
                    matrix.get(targetRow).set(col, -1);
                }
            }

            for (int targetCol = col - radius; targetCol <= col + radius; targetCol++) {
                if (isInMatrix(row, targetCol, matrix)) {
                    matrix.get(row).set(targetCol, -1);
                }
            }

            filterMatrix(matrix);
            line = input.nextLine();
        }

        printMatrix(matrix);
    }
}

package javaFundamentals15Nov2015;

import java.util.*;

/*
 * Created by MapuH on 22-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-11-15/Problem03-Rubik's-Matrix.zip
 */
public class RubiksMatrix {

    private static void moveRow(int[][] matrix, int row, int moves, String direction) {
        for (int i = 0; i < moves % matrix[0].length; i++) {
            if (direction.equals("right")) {
                int[] newRow = new int[matrix[row].length];
                for (int j = 1; j < matrix[row].length; j++) {
                    newRow[j] = matrix[row][j - 1];
                }
                newRow[0] = matrix[row][matrix[row].length - 1];
                matrix[row] = newRow;

            } else {
                int[] newRow = new int[matrix[row].length];
                for (int j = 0; j < matrix[row].length-1; j++) {
                    newRow[j] = matrix[row][j + 1];
                }
                newRow[newRow.length-1] = matrix[row][0];
                matrix[row] = newRow;
            }

        }

    }

    private static void moveCol(int[][] matrix, int col, int moves, String direction) {
        for (int i = 0; i < moves % matrix.length; i++) {
            if (direction.equals("down")) {
                int[] newCol = new int[matrix.length];
                for (int j = 1; j < matrix.length; j++) {
                    newCol[j] = matrix[j-1][col];
                }
                newCol[0] = matrix[matrix.length-1][col];
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][col] = newCol[j];
                }

            } else {
                int[] newCol = new int[matrix.length];
                for (int j = 0; j < matrix.length-1; j++) {
                    newCol[j] = matrix[j+1][col];
                }
                newCol[newCol.length-1] = matrix[0][col];
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][col] = newCol[j];
                }
            }

        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int r = input.nextInt();
        int c = input.nextInt();
        int n = input.nextInt();
        input.nextLine();

        int[][] matrix = new int[r][c];
        int number = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = number;
                number++;
            }
        }

        for (int i = 0; i < n; i++) {
            String[] commandArgs = input.nextLine().split("\\s+");
            int row, col;
            int moves = Integer.parseInt(commandArgs[2]);
            if (commandArgs[1].equals("left") || commandArgs[1].equals("right")) {
                row = Integer.parseInt(commandArgs[0]);
                moveRow(matrix, row, moves, commandArgs[1]);
            } else {
                col = Integer.parseInt(commandArgs[0]);
                moveCol(matrix, col, moves, commandArgs[1]);
            }

        }

        number = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] != number) {
                    for (int k = 0; k < r; k++) {
                        for (int l = 0; l < c; l++) {
                            if (matrix[k][l] == number) {
                                System.out.printf("Swap (%d, %d) with (%d, %d)\n", i, j, k, l);
                                int temp = matrix[k][l];
                                matrix[k][l] = matrix[i][j];
                                matrix[i][j] = temp;
                            }
                        }
                    }
                } else {
                    System.out.println("No swap required");
                }
                number++;
            }

        }


    }
}

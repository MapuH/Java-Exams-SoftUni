package javaBasics07Jan2015;

import java.util.*;

/*
 * Created by MapuH on 13-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-01-07/Problem03-Firethe-Arrows.zip
 *
 * NOTE: Used SoftUni's solution!
 */
public class FireTheArrows {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        char[][] matrix = new char[n][];

        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            matrix[i] = line.toCharArray();
        }

        boolean hasMoved = true;
        while (hasMoved) {
            hasMoved = false;
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    int currentRow = row, currentCol = col;
                    char symbol = matrix[currentRow][currentCol];
                    if (symbol != 'o') {
                        int dirRow = 0, dirCol = 0, nextRow = 0, nextCol = 0;

                        switch (symbol) {
                            case '^':
                                dirRow = -1;
                                break;
                            case '>':
                                dirCol = 1;
                                break;
                            case '<':
                                dirCol = -1;
                                break;
                            case 'v':
                                dirRow = 1;
                                break;
                            default:
                                break;
                        }

                        nextRow = currentRow + dirRow;
                        nextCol = currentCol + dirCol;
                        if (nextCol >= 0 && nextCol < matrix[currentRow].length
                                && nextRow >= 0 && nextRow < matrix.length
                                && matrix[nextRow][nextCol] == 'o') {

                            matrix[nextRow][nextCol] = symbol;
                            matrix[currentRow][currentCol] = 'o';
                            hasMoved = true;
                        }
                    }
                }
            }
        }

        // Print the output matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}
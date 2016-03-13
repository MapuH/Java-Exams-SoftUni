package javaBasics11May2015;

import java.util.*;

/*
 * Created by MapuH on 13-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-05-11/Problem3-Labyrinth-Dash.zip
 */
public class LabyrinthDash {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int rows = Integer.parseInt(input.nextLine());

        char[][] labyrinth = new char[rows][];
        for (int i = 0; i < rows; i++) {
            labyrinth[i] = input.nextLine().toCharArray();
        }

        char[] moves = input.nextLine().toCharArray();

        int count = 0;
        int lives = 3;
        int currentRow = 0, currentCol = 0;
        int newRow = 0, newCol = 0;

        for (char direction : moves) {
            switch (direction) {
                case 'v':
                    newRow++;
                    break;
                case '^':
                    newRow--;
                    break;
                case '<':
                    newCol--;
                    break;
                case '>':
                    newCol++;
                    break;
                default:
                    break;
            }

            if (newRow < 0 || newRow > rows-1 || newCol < 0
                    || newCol > labyrinth[newRow].length-1 || labyrinth[newRow][newCol] == ' ') {
                System.out.println("Fell off a cliff! Game Over!");
                count++;
                break;
            } else if (labyrinth[newRow][newCol] == '@' || labyrinth[newRow][newCol] == '#'
                        || labyrinth[newRow][newCol] == '*') {
                lives--;
                count++;
                System.out.println("Ouch! That hurt! Lives left: " + lives);
                if (lives == 0) {
                    System.out.println("No lives left! Game Over!");
                    break;
                }

            } else if (labyrinth[newRow][newCol] == '_' || labyrinth[newRow][newCol] == '|') {
                System.out.println("Bumped a wall.");
                newRow = currentRow;
                newCol = currentCol;
                continue;

            } else if (labyrinth[newRow][newCol] == '$') {
                lives++;
                count++;
                System.out.println("Awesome! Lives left: " + lives);
                labyrinth[newRow][newCol] = '.';

            } else {
                count++;
                System.out.println("Made a move!");
            }

            currentRow = newRow;
            currentCol = newCol;
        }

        System.out.println("Total moves made: " + count);
    }
}

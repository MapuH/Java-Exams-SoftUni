package javaBasics07Jan2015;

import java.util.*;

/*
 * Created by MapuH on 13-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-01-07/Problem02-Terrorists-Win!.zip
 */
public class TerroristsWin {

    // Detonates the left most bomb in the string
    private static String detonate(String line) {
        int bombStart = line.indexOf('|');
        int bombEnd = line.indexOf('|', bombStart+1);
        String bomb = line.substring(bombStart+1, bombEnd);

        int bombPower = 0;
        for (int i = 0; i < bomb.length(); i++) {
            bombPower += (int) bomb.charAt(i);
        }
        bombPower = bombPower % 10;
        StringBuilder replacement = new StringBuilder();

        if (bombPower > line.substring(0, bombStart).length()) {
            // This will execute if the bomb is in the beginning of the string
            for (int i = 0; i < bombPower + (bomb.length()+2) + line.substring(0, bombStart).length(); i++) {
                replacement.append('.');
            }
            return replacement.toString() + line.substring(bombEnd + bombPower + 1);

        } else if (bombPower > line.substring(bombEnd + 1).length()) {
            // This will execute if bomb is in the end of the string
            for (int i = 0; i < bombPower + (bomb.length()+2) + line.substring(bombEnd+1).length(); i++) {
                replacement.append('.');
            }
            return line.substring(0, bombStart - bombPower) + replacement;

        } else {
            // This will execute if bomb is in the middle of the string
            for (int i = 0; i < bombPower*2 + bomb.length() + 2; i++) {
                replacement.append('.');
            }
            return line.substring(0, bombStart - bombPower) + replacement.toString()
                    + line.substring(bombEnd + bombPower + 1);
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String line  = input.nextLine();

        while (line.contains("|")) {
            line = detonate(line);
        }

        System.out.println(line);

    }
}

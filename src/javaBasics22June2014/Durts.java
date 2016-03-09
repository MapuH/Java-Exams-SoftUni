package javaBasics22June2014;

import java.util.*;

/*
 * Created by MapuH on 09-Mar-2016
 *
 * Description, solution and tests can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-06-22/Problem02-Durts.zip
 */

public class Durts {

    private static boolean hitsTarget(int cx, int cy, int r, int x, int y) {
        boolean rectangleX = !(x > cx + r || x < cx - r || y > cy + r * 0.5 || y < cy - r * 0.5);
        boolean rectangleY = !(y > cy + r || y < cy - r || x > cx + r * 0.5 || x < cx - r * 0.5);

        return rectangleX || rectangleY;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int centerX = input.nextInt();
        int centerY = input.nextInt();
        int size = input.nextInt();
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            int coordX = input.nextInt();
            int coordY = input.nextInt();

            if (hitsTarget(centerX, centerY, size, coordX, coordY)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }


    }
}

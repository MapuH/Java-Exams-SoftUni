package javaBasics26May2014;

import java.util.*;

/**
 * Created by MapuH on 07-Mar-2016
 *
 * Description, solution and tests can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-05-26/Problem02-Pythagorean-Numbers.zip
 */
public class PythagoreanNumbers {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = input.nextInt();
        }

        boolean foundCombo = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {

                    int a = numbers[i];
                    int b = numbers[j];
                    int c = numbers[k];

                    if (a <= b && a*a + b*b == c*c) {
                        System.out.printf("%1$d*%1$d + %2$d*%2$d = %3$d*%3$d\n", a, b, c);
                        foundCombo = true;
                    }

                }

            }

        }

        if (!foundCombo) {
            System.out.println("No");
        }
    }
}

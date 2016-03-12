package javaBasics21Sep2014Evening;

import java.util.*;

/*
 * Created by MapuH on 12-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-09-21-2Evening/Problem01-Mirror-Numbers.zip
 */
public class MirrorNumbers {

    private static int reverseNumber(int number) {
        String strNum = new StringBuffer(Integer.toString(number)).reverse().toString();
        return Integer.parseInt(strNum);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = input.nextInt();
        }

        boolean foundMirror = false;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int a = numbers[i];
                int b = numbers[j];

                if (a != b && a == reverseNumber(b)) {
                    System.out.printf("%d<!>%d\n", a, b);
                    foundMirror = true;
                }
            }
        }

        if (!foundMirror) {
            System.out.println("No");
        }

    }
}

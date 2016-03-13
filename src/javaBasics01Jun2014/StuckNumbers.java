package javaBasics01Jun2014;

import java.util.*;

/**
 * Created by marin on 2/27/16.
 *
 * Problem description can be found at
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-06-01/Problem01-Stuck-Numbers.zip
 *
 * NOTE: Used the published solution!
 */
public class StuckNumbers {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }

        // Find and print all stuck numbers {a, b, c, d}
        int count = 0;
        for (int num1 = 0; num1 < nums.length; num1++) {
            for (int num2 = 0; num2 < nums.length; num2++) {
                for (int num3 = 0; num3 < nums.length; num3++) {
                    for (int num4 = 0; num4 < nums.length; num4++) {
                        int a = nums[num1];
                        int b = nums[num2];
                        int c = nums[num3];
                        int d = nums[num4];
                        if (a != b && a != c & a != d &&
                                b != c && b != d && c != d) {
                            String first = "" + a + b;
                            String second = "" + c + d;
                            if (first.equals(second)) {
                                System.out.printf("%d|%d==%d|%d\n",
                                        a, b, c, d);
                                count++;
                            }
                        }
                    }
                }
            }
        }

        if (count == 0) {
            System.out.println("No");
        }

    }

}

package javaBasics03Sep2014;

import java.util.*;

/**
 * Created by MapuH on 06-Mar-2016
 *
 * Description, solution and tests can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-09-03/Problem02-Adding-Angles.zip
 */
public class AddingAngles {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] angles = new int[n];
        for (int i = 0; i < n; i++) {
            angles[i] = input.nextInt();
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    int angle1 = angles[i];
                    int angle2 = angles[j];
                    int angle3 = angles[k];

                    if ((angle1 + angle2 + angle3) % 360 == 0) {
                        System.out.printf("%d + %d + %d = %d degrees\n", angle1, angle2, angle3, angle1+angle2+angle3);
                        count++;
                    }
                }

            }

        }

        if (count == 0) {
            System.out.println("No");
        }
    }
}

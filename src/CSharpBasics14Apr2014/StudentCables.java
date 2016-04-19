package CSharpBasics14Apr2014;

import java.util.Scanner;

/*
 * Created by MapuH on 31-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/csharp-basics/Exams/2014-04-14-2Evening/Problem02-Student-Cables.zip
 */
public class StudentCables {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int jointCable = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int length = Integer.parseInt(input.nextLine());
            String measure = input.nextLine().trim();

            if (measure.equals("meters")) {
                length *= 100;
            }

            if (length >= 20) {
                jointCable += length;
                count ++;
            }
        }

        jointCable = jointCable - (count - 1) * 3;

        System.out.println(jointCable / 504);
        System.out.println(jointCable % 504);
    }
}

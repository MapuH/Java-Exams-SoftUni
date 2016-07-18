package javaFundamentals23Apr2016;

import java.util.Scanner;

/*
 * Created by MapuH on 03-Jul-2016
 *
 * Description, solution and test can be found at:
 * https://judge.softuni.bg/Contests/183/Java-Fundamentals-Exam-23-April-2016
 */
public class MelrahShake {

    private static int findMatches(String mainString, String subString) {
        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1 && mainString.length() > 0 && subString.length() > 0) {
            lastIndex = mainString.indexOf(subString, lastIndex);

            if (lastIndex != -1) {
                count++;
                lastIndex += subString.length();
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String pattern = input.nextLine();

        while (true) {
            if (findMatches(line, pattern) <= 1 || pattern.length() < 1) {
                System.out.println("No shake.");
                break;
            }

            line = line.substring(0, line.indexOf(pattern)) + line.substring(line.indexOf(pattern) + pattern.length(),
                    line.length());
            line = line.substring(0, line.lastIndexOf(pattern)) + line.substring(line.lastIndexOf(pattern)
                    + pattern.length(), line.length());

            int charPos = pattern.length()/2;
            pattern = pattern.substring(0, charPos) + pattern.substring(charPos+1, pattern.length());

            System.out.println("Shaked it.");
        }

        System.out.println(line);
    }
}

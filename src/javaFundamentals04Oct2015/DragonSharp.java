package javaFundamentals04Oct2015;

import java.util.*;

/*
 * Created by MapuH on 14-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-10-04/Problem01-Dragon-Sharp.zip
 */
public class DragonSharp {

    private static String findCondition(String line) {
        int start = line.indexOf('(');
        int end = line.indexOf(')');

        return line.substring(start+1, end);
    }

    private static boolean checkCondition(String condition) {
        if (condition.contains("==")) {
            String[] arguments =  condition.split("==");
            return Integer.parseInt(arguments[0]) == Integer.parseInt(arguments[1]);

        } else if (condition.contains(">")) {
            String[] arguments =  condition.split(">");
            return Integer.parseInt(arguments[0]) > Integer.parseInt(arguments[1]);

        } else if (condition.contains("<")) {
            String[] arguments =  condition.split("<");
            return Integer.parseInt(arguments[0]) < Integer.parseInt(arguments[1]);

        } else {
            String[] arguments =  condition.split("!=");
            return Integer.parseInt(arguments[0]) != Integer.parseInt(arguments[1]);
        }
    }

    private static String findString(String line) {
        int start = line.indexOf(" out ");

        return line.substring(start+5, line.length()-1);
    }

    private static boolean hasError(String line, String string) {
        boolean semicolonTest = line.charAt(line.length()-1) != ';';
        boolean stringTest = (string.charAt(0) != '"' || string.charAt(string.length()-1) != '"');

        return semicolonTest ||stringTest;
    }

    private static int numberOfLoops(String line) {
        if (line.contains("loop")) {
            int start = line.indexOf("loop ");
            int end = line.indexOf(" out");
            return Integer.parseInt(line.substring(start+5, end));
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        String output = "";
        boolean prevCondition = false;

        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            String string = findString(line);
            int loops = numberOfLoops(line);

            if (hasError(line, string)) {
                output = "Compile time error @ line " + (i + 1);
                break;
            }

            if (line.startsWith("if")) {
                String condition = findCondition(line);

                if (checkCondition(condition)) {
                    for (int j = 0; j < loops; j++) {
                        output += string.substring(1, string.length()-1) + "\n";
                    }
                    prevCondition = true;
                } else {
                    prevCondition = false;
                }

            } else {
                if (!prevCondition) {
                    for (int j = 0; j < loops; j++) {
                        output += string.substring(1, string.length()-1) + "\n";
                    }
                }
            }
        }

        System.out.print(output);
    }
}

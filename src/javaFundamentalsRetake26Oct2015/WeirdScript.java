package javaFundamentalsRetake26Oct2015;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Created by MapuH on 19-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-10-26/Problem02-Weird-Script.zip
 */
public class WeirdScript {

    private static String findKeyLetters(int key) {
        String letter;
        int value = key % 52;
        if (value == 0) {
            letter = String.valueOf((char) 90);
        } else if (value < 27) {
            letter = String.valueOf((char) (value + 96));
        } else {
            letter = String.valueOf((char) (value + 38));
        }
        return letter + letter;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int key = Integer.parseInt(input.nextLine());
        String keyStr = findKeyLetters(key);
        String text = "";
        String line = input.nextLine().trim();

        while (!line.equals("End")) {
            text += line;
            line = input.nextLine().trim();
        }

        Pattern pattern = Pattern.compile(keyStr + ".*?" + keyStr);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String output = matcher.group(0).replaceAll(keyStr, "");
            if (!output.equals("")) {
                System.out.println(output);
            }
        }

    }
}

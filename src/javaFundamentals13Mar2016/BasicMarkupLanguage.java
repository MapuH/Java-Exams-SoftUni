package javaFundamentals13Mar2016;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Created by MapuH on 30-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://judge.softuni.bg/Contests/Practice/DownloadResource/1199
 */
public class BasicMarkupLanguage {

    private static String inverse(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isUpperCase(text.charAt(i))) {
                chars[i] = Character.toLowerCase(ch);
            } else {
                chars[i] = Character.toUpperCase(ch);
            }
        }
        return new String(chars);
    }

    private static String reverse(String text) {

        return new StringBuilder(text).reverse().toString();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String line = input.nextLine().trim();
        Pattern pattern = Pattern.compile("^<\\s*?(inverse|reverse|repeat|stop)\\s*?(?:value\\s*?=\\s*?\"([^\"]+)\")?\\s*?(?:content\\s*?=\\s*?\"([^\"]+)\")?\\s*?/>$");
        int count = 1;

        while (true) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String command = matcher.group(1);
                int value = 0;
                if (matcher.group(2) != null) {
                    value = Integer.parseInt(matcher.group(2));
                }
                String content = matcher.group(3);

                if (command.equals("stop")) {
                    break;
                }

                switch (command) {
                    case "inverse":
                        System.out.printf("%d. %s\n", count, inverse(content));
                        count++;
                        break;
                    case "reverse":
                        System.out.printf("%d. %s\n", count, reverse(content));
                        count++;
                        break;
                    case "repeat":
                        for (int i = 0; i < value; i++) {
                            System.out.printf("%d. %s\n", count, content);
                            count++;
                        }
                        break;
                    default:
                        break;
                }
            }

            line = input.nextLine().trim();
        }

    }
}

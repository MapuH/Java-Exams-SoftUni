package javaFundamentals13Mar2016;

import java.util.*;

/*
 * Created by MapuH on 28-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://judge.softuni.bg/Contests/Practice/DownloadResource/1197
 */
public class ArrangeIntegers {

    private static final String[] DIGITS = {"zero", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine"};

    private static String strToNum(String strNumber) {
        for (int i = 0; i < DIGITS.length; i++) {
            if (strNumber.equals(DIGITS[i])) {
                return Integer.toString(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] numbers = input.nextLine().split(", ");
        List<String> sorted = new ArrayList<>();

        for (String number : numbers) {
            if (number.length() > 1) {
                String strNum = "";
                for (char ch : number.toCharArray()) {
                    strNum += DIGITS[Integer.parseInt(String.valueOf(ch))] + "-";
                }
                strNum = strNum.substring(0, strNum.length()-1);
                sorted.add(strNum);

            } else {
                sorted.add(DIGITS[Integer.parseInt(number)]);
            }
        }

        Collections.sort(sorted);
        String output = "";

        for (String strNum : sorted) {
            if (strNum.contains("-")) {
                String number = "";
                String[] strArgs = strNum.split("-");
                for (String num : strArgs) {
                    number += strToNum(num);
                }
                output += number + ", ";

            } else {
                output += strToNum(strNum) + ", ";
            }
        }

        System.out.println(output.substring(0, output.length()-2));
    }

}

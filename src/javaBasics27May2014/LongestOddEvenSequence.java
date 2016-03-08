package javaBasics27May2014;

import java.util.*;

/**
 * Created by MapuH on 08-Mar-2016
 *
 * Description, solution and tests can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-05-27/Problem03-Longest-Odd-Evet-Oequence.zip
 */
public class LongestOddEvenSequence {

    private static boolean isOdd(int x) {
        return x % 2 != 0 || x == 0;
    }

    private static boolean isEven(int x) {
        return x % 2 == 0 || x == 0;
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] strNums = input.nextLine().trim().split("[( )]+");
        List<Integer> numbers = new ArrayList<>();

        for (String num: strNums) {
            if (!num.equals("")) {
                numbers.add(Integer.parseInt(num));
            }
        }

        int longestSequence = 1;
        int currentSequence = 1;
        for (int i = 1; i < numbers.size(); i++) {

            if ((isOdd(numbers.get(i)) && isEven(numbers.get(i-1)))
                    || (isEven(numbers.get(i)) && isOdd(numbers.get(i-1)))) {
                currentSequence ++;

                if (i == numbers.size() -1 && currentSequence > longestSequence) {
                    longestSequence = currentSequence;
                }

            } else {
                if (currentSequence > longestSequence) {
                    longestSequence = currentSequence;
                }
                currentSequence = 1;
            }

            // replace zeros, so we know if we counted them as odd or even
            if (numbers.get(i) == 0) {
                if (isOdd(numbers.get(i-1))) {
                    numbers.set(i, 2);
                } else {
                    numbers.set(i, 1);
                }
            }
        }

        System.out.println(longestSequence);
    }
}

package javaBasics08Feb2015;

import java.util.*;

/**
 * Created by marin on 3/5/16.
 *
 * Problem description, solutions and tests can be found at
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-02-08/Problem02-Letters-Changs-Cumbers.zip
 */
public class LettersChangeNumbers {

    private static final Map<Character, Integer> ALPHABET;
    static {
        int j = 1;
        Map<Character, Integer> map = new HashMap<>();
        for (char i = 'a'; i <= 'z' ; i++) {
            map.put(i, j);
            j++;
        }
        ALPHABET = Collections.unmodifiableMap(map);
    }

    private static double solveString(String str) {
        char letterBefore = str.charAt(0);
        char letterAfter = str.charAt(str.length()-1);
        int number = Integer.parseInt(str.substring(1, str.length()-1));
        double result = 0.0;

        if (Character.isUpperCase(letterBefore)) {
            result += (double) number / ALPHABET.get(Character.toLowerCase(letterBefore));
        } else {
            result += (double) number * ALPHABET.get(letterBefore);
        }

        if(Character.isUpperCase(letterAfter)) {
            result -= ALPHABET.get(Character.toLowerCase(letterAfter));
        } else {
            result += ALPHABET.get(letterAfter);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] strs = input.nextLine().split("\\s+");
        double total = 0.0;

        for (String str : strs) {
            total += solveString(str);
        }

        System.out.printf("%.2f", total);
    }
}

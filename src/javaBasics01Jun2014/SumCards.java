package javaBasics01Jun2014;

import java.util.*;

/**
 * Created by marin on 2/27/16.
 *
 * Problem description, solutions and tests can be found at
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-06-01/Problem02-Sum-Cards.zip
 */
public class SumCards {

    private static final Map<String, Integer> CARD_VALUES;
    static {
        Map<String, Integer> map = new HashMap<>();
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("10", 10);
        map.put("J", 12);
        map.put("Q", 13);
        map.put("K", 14);
        map.put("A", 15);

        CARD_VALUES = Collections.unmodifiableMap(map);
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] cards = input.nextLine().split(" ");

        int[] values = new int[cards.length];
        for (int i = 0; i < cards.length ; i++) {
            values[i] = CARD_VALUES.get(cards[i].substring(0, cards[i].length()-1));
        }

        int sum = 0;
        boolean sequence = false;

        for (int i = 0; i < values.length; i++) {

            if (i == values.length-1 && sequence) {
                sum += values[i]*2;
            } else if (i == values.length-1 && !sequence) {
                sum += values[i];
            } else {

                if (values[i] == values[i + 1]) {
                    sequence = true;
                    sum += values[i] * 2;
                } else if (sequence && values[i] != values[i + 1]) {
                    sum += values[i] * 2;
                    sequence = false;
                } else {
                    sum += values[i];
                }
            }

        }

        System.out.println(sum);


    }
}

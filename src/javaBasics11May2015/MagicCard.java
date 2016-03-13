package javaBasics11May2015;

import java.util.*;

/*
 * Created by MapuH on 13-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-05-11/Problem2-Magic-Card.zip
 */
public class MagicCard {

    private static final Map<String, Integer> CARD_VALUES;
    static {
        Map<String, Integer> cardMap = new HashMap<>();
        cardMap.put("2", 20);
        cardMap.put("3", 30);
        cardMap.put("4", 40);
        cardMap.put("5", 50);
        cardMap.put("6", 60);
        cardMap.put("7", 70);
        cardMap.put("8", 80);
        cardMap.put("9", 90);
        cardMap.put("10", 100);
        cardMap.put("J", 120);
        cardMap.put("Q", 130);
        cardMap.put("K", 140);
        cardMap.put("A", 150);
        CARD_VALUES = Collections.unmodifiableMap(cardMap);
    }

    private static String getSuit(String card) {
        return card.substring(card.length()-1);
    }

    private static String getFace(String card) {
        return card.substring(0, card.length()-1);
    }

    private static int getValue(String card, String magicCard) {
        if (getSuit(card).equals(getSuit(magicCard))) {
            return CARD_VALUES.get(getFace(card)) * 2;

        } else if (getFace(card).equals(getFace(magicCard))) {
            return CARD_VALUES.get(getFace(card)) * 3;

        } else {
            return CARD_VALUES.get(getFace(card));
        }

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] cards = input.nextLine().split("\\s+");
        String position = input.nextLine().trim();
        String magicCard = input.nextLine().trim();

        int sum = 0;
        if (position.equals("odd")) {
            for (int i = 1; i < cards.length; i+=2) {
                sum += getValue(cards[i], magicCard);
            }
        } else {
            for (int i = 0; i < cards.length; i+=2) {
                sum += getValue(cards[i], magicCard);
            }
        }

        System.out.println(sum);
    }
}

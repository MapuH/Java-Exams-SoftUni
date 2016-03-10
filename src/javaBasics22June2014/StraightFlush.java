package javaBasics22June2014;

import java.util.*;

/*
 * Created by MapuH on 10-Mar-2016
 *
 * Description, solution and tests can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-06-22/Problem04-Straight-Flush.zip
 *
 * NOTE: Used SoftUni's solution for this one!
 */

public class StraightFlush {

    public static String getNextCard(String cardFace) {
        String[] cardFaces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (int i = 1; i < cardFaces.length ; i++) {
            if (cardFaces[i-1].equals(cardFace)) {
                return cardFaces[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] cards = input.nextLine().trim().split("\\W+");
        Set<String> hand = new HashSet<>(Arrays.asList(cards));

        boolean foundStraightFlush = false;
        for (String card : cards) {
            String cardValue = card.substring(0, card.length()-1);
            String suit = card.substring(card.length()-1);

            List<String> straightFlush = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                straightFlush.add(cardValue + suit);
                cardValue = getNextCard(cardValue);
            }

            if (hand.containsAll(straightFlush)) {
                System.out.println(straightFlush);
                foundStraightFlush = true;
            }
        }

        if (!foundStraightFlush) {
            System.out.println("No Straight Flushes");
        }

    }
}

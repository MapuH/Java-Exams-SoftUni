package javaBasics21Sep2014Morning;

import java.util.*;

/*
 * Created by MapuH on 11-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-09-21-1Morning/Problem03-Weird-Strings.zip
 */
public class WeirdStrings {

    private static final Map<Character, Integer> LETTER_WEIGHTS;
    static {
        Map<Character, Integer> letterMap = new HashMap<>();
        int weight = 1;
        for (char i = 'a'; i <= 'z'; i++) {
            letterMap.put(i, weight);
            weight++;
        }
        LETTER_WEIGHTS = Collections.unmodifiableMap(letterMap);
    }

    private static int getWordWeight(String word) {
        int weight = 0;
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            weight += LETTER_WEIGHTS.get(word.charAt(i));
        }

        return weight;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String filtered = input.nextLine().trim().replaceAll("[\\s\\\\/()|]+", "");
        String[] words = filtered.split("[^a-zA-Z]+");

        int biggestSum = 0;
        String output = "";
        for (int i = 1; i < words.length; i++) {
            int currentSum = getWordWeight(words[i-1]) + getWordWeight(words[i]);
            if (currentSum >= biggestSum) {
                biggestSum = currentSum;
                output = String.format("%s\n%s", words[i-1], words[i]);
            }
        }

        System.out.println(output);

    }
}

package javaBasics22June2014;

import java.util.*;

/*
 * Created by MapuH on 09-Mar-2016
 *
 * Description, solution and tests can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-06-22/Problem01-Cognate-Words.zip
 */

public class CognateWords {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] words = input.nextLine().trim().split("(\\d|\\W)+");
        Map<String, String> cognateWords = new HashMap<>();
        boolean foundMatch = false;

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                for (int k = 0; k < words.length; k++) {

                    String a = words[i];
                    String b = words[j];
                    String c = words[k];

                    if ((a+b).equals(c) && i != j) {
                        cognateWords.put(c, a + "|" + b);
                        foundMatch = true;
                    }

                }
            }
        }

        if (foundMatch) {
            for (Map.Entry<String, String> entry : cognateWords.entrySet()) {
                System.out.printf("%s=%s\n", entry.getValue(), entry.getKey());
            }
        } else {
            System.out.println("No");
        }
    }
}

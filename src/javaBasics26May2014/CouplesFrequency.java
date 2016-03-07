package javaBasics26May2014;

import java.util.*;

/**
 * Created by MapuH on 07-Mar-2016
 *
 * Description, solution and tests can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-05-26/Problem04-Couples-Frequency.zip
 */
public class CouplesFrequency {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] strNums = input.nextLine().trim().split("\\s+");
        Map<String, Integer> frequencyMap = new LinkedHashMap<>();

        for (int i = 0; i < strNums.length-1; i++) {
            String couple = strNums[i] + " " + strNums[i+1];
            if (!frequencyMap.containsKey(couple)) {
                frequencyMap.put(couple, 1);
            } else {
                frequencyMap.put(couple, frequencyMap.get(couple) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            double frequency = (double) entry.getValue() / (strNums.length-1);
            System.out.printf("%s -> %.2f%%\n", entry.getKey(), frequency*100);
        }

    }
}

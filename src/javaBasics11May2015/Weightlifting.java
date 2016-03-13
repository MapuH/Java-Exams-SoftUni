package javaBasics11May2015;

import java.util.*;

/*
 * Created by MapuH on 13-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-05-11/Problem4-Weightlifting.zip
 */
public class Weightlifting {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        Map<String, Map<String, Long>> playerMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] lineArgs = input.nextLine().trim().split("\\s+");
            String player = lineArgs[0];
            String exercise = lineArgs[1];
            long weight = Long.parseLong(lineArgs[2]);

            if (!playerMap.containsKey(player)) {
                Map<String, Long> exerciseMap = new TreeMap<>();
                exerciseMap.put(exercise, weight);
                playerMap.put(player, exerciseMap);

            } else {
                Map<String, Long> exerciseMap = playerMap.get(player);
                if (!exerciseMap.containsKey(exercise)) {
                    exerciseMap.put(exercise, weight);
                } else {
                    exerciseMap.put(exercise, exerciseMap.get(exercise) + weight);
                }

                playerMap.put(player, exerciseMap);
            }
        }

        for (Map.Entry<String, Map<String, Long>> playerEntry : playerMap.entrySet()) {
            String output = playerEntry.getKey() + " : ";

            for (Map.Entry<String, Long> exerciseEntry : playerEntry.getValue().entrySet()) {
                output += String.format("%s - %d kg, ", exerciseEntry.getKey(), exerciseEntry.getValue());
            }

            System.out.println(output.substring(0, output.length()-2));
        }

    }
}

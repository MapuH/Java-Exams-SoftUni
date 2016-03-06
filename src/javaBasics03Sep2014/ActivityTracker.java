package javaBasics03Sep2014;

import java.util.*;

/**
 * Created by MapuH on 06-Mar-2016
 *
 * Description, solution and tests can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-09-03/Problem04-Activity-Tracker.zip
 */
public class ActivityTracker {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();

        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = input.nextLine().trim();
        }

        Map<Integer, Map<String, Integer>> monthMap = new TreeMap<>();

        for (String line : lines) {
            String[] lineArgs = line.split("\\s+");
            int month = Integer.parseInt(lineArgs[0].substring(3,5));
            String user = lineArgs[1];
            int distance = Integer.parseInt(lineArgs[2]);

            if (!monthMap.containsKey(month)) {
                Map<String, Integer> nameMap = new TreeMap<>();
                nameMap.put(user, distance);
                monthMap.put(month, nameMap);

            } else {
                Map<String, Integer> nameMap = monthMap.get(month);
                if (!nameMap.containsKey(user)) {
                    nameMap.put(user, distance);
                } else {
                    nameMap.put(user, nameMap.get(user) + distance);
                }

                monthMap.put(month, nameMap);
            }

        }

        for (Map.Entry<Integer, Map<String, Integer>> entry : monthMap.entrySet()) {
            String output = String.format("%d: ", entry.getKey());

            for(Map.Entry<String, Integer> nameEntry : entry.getValue().entrySet()) {
                output += String.format("%s(%d), ", nameEntry.getKey(), nameEntry.getValue());
            }

            System.out.println(output.substring(0, output.length()-2));
        }


    }
}

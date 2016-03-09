package javaBasics22June2014;

import java.util.*;

/*
 * Created by MapuH on 09-Mar-2016
 *
 * Description, solution and tests can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-06-22/Problem03-Exam-Score.zip
 */

public class ExamScore {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        for (int i = 0; i < 3; i++) {
            line = input.nextLine();
        }

        Map<Integer, Set<String>> scoreMap = new TreeMap<>();
        Map<String, Double> gradeMap = new HashMap<>();


        while (!line.contains("---")) {

            String[] lineArgs = line.trim().split("\\|");
            // first element in lineArgs is "", so we start from index 1 instead of 0
            String name = lineArgs[1].trim();
            int score = Integer.parseInt(lineArgs[2].trim());
            double grade = Double.parseDouble(lineArgs[3].trim());
            gradeMap.put(name, grade);

            if (!scoreMap.containsKey(score)) {
                Set<String> names = new TreeSet<>();
                names.add(name);
                scoreMap.put(score, names);

            } else {
                Set<String> names = scoreMap.get(score);
                names.add(name);
                scoreMap.put(score, names);
            }

            line = input.nextLine();
        }

        for (Map.Entry<Integer, Set<String>> entry : scoreMap.entrySet()) {
            double total = 0.0;
            for (String name : entry.getValue()) {
                total += gradeMap.get(name);
            }
            double average = total / entry.getValue().size();

            System.out.printf("%d -> %s; avg=%.2f\n", entry.getKey(), entry.getValue(), average);
        }


    }
}

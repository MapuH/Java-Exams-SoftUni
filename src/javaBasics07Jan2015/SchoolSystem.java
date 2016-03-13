package javaBasics07Jan2015;

import java.util.*;

/*
 * Created by MapuH on 13-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-01-07/Problem04-School-System.zip
 */
public class SchoolSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = input.nextLine().trim();
        }

        Map<String, Map<String, List<Double>>> studentMap = new TreeMap<>();

        for (String line : lines) {
            String[] lineArgs = line.split("\\s+");
            String name = lineArgs[0] + " " + lineArgs[1];
            String subject = lineArgs[2];
            double grade = Double.parseDouble(lineArgs[3]);

            if (!studentMap.containsKey(name)) {
                List<Double> grades = new ArrayList<>();
                grades.add(grade);

                Map<String, List<Double>> gradeMap = new TreeMap<>();
                gradeMap.put(subject, grades);

                studentMap.put(name, gradeMap);

            } else {
                Map<String, List<Double>> gradeMap = studentMap.get(name);
                if (!gradeMap.containsKey(subject)) {
                    List<Double> grades = new ArrayList<>();
                    grades.add(grade);
                    gradeMap.put(subject, grades);
                } else {
                    List<Double> grades = gradeMap.get(subject);
                    grades.add(grade);
                    gradeMap.put(subject, grades);
                }

                studentMap.put(name, gradeMap);
            }

        }

        for (Map.Entry<String, Map<String, List<Double>>> studentEntry : studentMap.entrySet()) {
            String output = studentEntry.getKey() + ": [";

            for (Map.Entry<String, List<Double>> gradeEntry : studentEntry.getValue().entrySet()) {
                double average = 0.0;
                for (double grade : gradeEntry.getValue()) {
                    average += grade;
                }
                average = average / gradeEntry.getValue().size();

                output += String.format("%s - %.2f, ", gradeEntry.getKey(), average);
            }

            System.out.println(output.substring(0, output.length()-2) + "]");
        }

    }
}

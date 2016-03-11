package javaBasics21Sep2014Morning;

import java.util.*;

/*
 * Created by MapuH on 11-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-09-21-1Morning/Problem04-Nuts.zip
 */
public class Nuts {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = input.nextLine().trim();
        }

        Map<String, Map<String, Integer>> companyMap = new TreeMap<>();

        for (String line : lines) {
            String[] lineArgs = line.split("\\s+");
            String company = lineArgs[0];
            String nuts = lineArgs[1];
            int amount = Integer.parseInt(lineArgs[2].replace("kg", ""));

            if (!companyMap.containsKey(company)) {
                Map<String, Integer> nutMap = new LinkedHashMap<>();
                nutMap.put(nuts, amount);
                companyMap.put(company, nutMap);

            } else {
                Map<String, Integer> nutMap = companyMap.get(company);
                if (!nutMap.containsKey(nuts)) {
                    nutMap.put(nuts, amount);
                } else {
                    nutMap.put(nuts, nutMap.get(nuts) + amount);
                }

                companyMap.put(company, nutMap);
            }

        }

        for (Map.Entry<String, Map<String, Integer>> companyEntry : companyMap.entrySet()) {
            String output = companyEntry.getKey() + ": ";

            for (Map.Entry<String, Integer> nutEntry : companyEntry.getValue().entrySet()) {
                output += String.format("%s-%dkg, ", nutEntry.getKey(), nutEntry.getValue());
            }

            System.out.println(output.substring(0, output.length()-2));
        }

    }
}

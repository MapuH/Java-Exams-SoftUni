package javaBasics21Sep2014Evening;

import java.util.*;

/*
 * Created by MapuH on 12-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-09-21-2Evening/Problem04-Office-Stuff.zip
 */
public class OfficeStuff {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String[] lines = new String[n];

        for (int i = 0; i < n; i++) {
            lines[i] = input.nextLine().trim().replaceAll("[|-]", "");
        }

        Map<String, Map<String, Integer>> companyMap = new TreeMap<>();

        for (String line : lines) {
            String[] lineArgs = line.split("\\s+");
            String company = lineArgs[0];
            int amount = Integer.parseInt(lineArgs[1]);
            String product = lineArgs[2];

            if (!companyMap.containsKey(company)) {
                Map<String, Integer> productMap = new LinkedHashMap<>();
                productMap.put(product, amount);
                companyMap.put(company, productMap);

            } else {
                Map<String, Integer> productMap = companyMap.get(company);
                if (!productMap.containsKey(product)) {
                    productMap.put(product, amount);
                } else {
                    productMap.put(product, productMap.get(product) + amount);
                }

                companyMap.put(company, productMap);
            }
        }

        for (Map.Entry<String, Map<String, Integer>> companyEntry : companyMap.entrySet()) {
            String output = companyEntry.getKey() + ": ";

            for (Map.Entry<String, Integer> productEntry : companyEntry.getValue().entrySet()) {
                output += String.format("%s-%d, ", productEntry.getKey(), productEntry.getValue());
            }

            System.out.println(output.substring(0, output.length()-2));
        }

    }
}

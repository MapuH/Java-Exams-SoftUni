package javaBasics27May2014;

import java.util.*;

/**
 * Created by MapuH on 08-Mar-2016
 *
 * Description, solution and tests can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-05-27/Problem04-Orders.zip
 */
public class Orders {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine().trim());

        Map<String, Map<String, Integer>> productMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] lineArgs = input.nextLine().split("\\s+");
            String name = lineArgs[0];
            int amount = Integer.parseInt(lineArgs[1]);
            String product = lineArgs[2];

            if (!productMap.containsKey(product)) {
                Map<String, Integer> nameMap = new TreeMap<>();
                nameMap.put(name, amount);
                productMap.put(product, nameMap);

            } else {
                Map<String, Integer> nameMap = productMap.get(product);

                if (!nameMap.containsKey(name)) {
                    nameMap.put(name, amount);
                } else {
                    nameMap.put(name, nameMap.get(name) + amount);
                }

                productMap.put(product, nameMap);
            }
        }

        for (Map.Entry<String, Map<String, Integer>> entry : productMap.entrySet()) {

            String output = entry.getKey() + ": ";

            for(Map.Entry<String, Integer> nameEntry : entry.getValue().entrySet()) {
                output += String.format("%s %d, ", nameEntry.getKey(), nameEntry.getValue());
            }

            System.out.println(output.substring(0, output.length()-2));
        }


    }
}

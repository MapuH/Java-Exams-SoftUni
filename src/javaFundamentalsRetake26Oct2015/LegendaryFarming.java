package javaFundamentalsRetake26Oct2015;

import java.util.*;

/*
 * Created by MapuH on 20-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-10-26/Problem04-Legendary-Farming.zip
 */
public class LegendaryFarming {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        Map<String, Integer> junk = new TreeMap<>();

        String line = input.nextLine().trim();

        main:
        while (true) {
            String[] lineArgs = line.toLowerCase().split("\\s+");
            for (int i = 1; i < lineArgs.length; i+=2) {
                String material = lineArgs[i];
                int quantity = Integer.parseInt(lineArgs[i-1]);
                if (keyMaterials.containsKey(material)) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                    if (keyMaterials.get(material) >= 250) {
                        switch (material) {
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                break;
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                break;
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                break;
                            default: break;
                        }
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        break main;
                    }
                } else {
                    if (junk.containsKey(material)) {
                        junk.put(material, junk.get(material) + quantity);
                    } else {
                        junk.put(material, quantity);
                    }
                }
            }

            line = input.nextLine().trim();
        }

        List<Integer> vals = new ArrayList<>(keyMaterials.values());
        Collections.sort(vals, Collections.reverseOrder());
        Set<Integer> values = new LinkedHashSet<>(vals);

        for (int value : values) {
            for (Map.Entry<String, Integer> entry : keyMaterials.entrySet()) {
                if (entry.getValue() == value) {
                    System.out.println(entry.getKey() + ": " + value);
                }
            }
        }

        for (Map.Entry<String, Integer> junkEntry : junk.entrySet()) {
            System.out.println(junkEntry.getKey() + ": " + junkEntry.getValue());
        }


    }
}

package javaFundamentals04Oct2015;

import java.util.*;

/*
 * Created by MapuH on 15-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-10-04/Problem04-Dragon-Army.zip
 */
public class DragonArmy {

    private static final int DAMAGE = 45;
    private static final int HEALTH = 250;
    private static final int ARMOR = 10;

    private static int getStat(String arg, int defaultValue) {
        if (arg.equals("null")) {
            return defaultValue;
        } else {
            return Integer.parseInt(arg);
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        Map<String, Map<String, List<Integer>>> dragonTypeMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] lineArgs = input.nextLine().trim().split("\\s+");
            String type = lineArgs[0];
            String name = lineArgs[1];
            int damage = getStat(lineArgs[2], DAMAGE);
            int health = getStat(lineArgs[3], HEALTH);
            int armor = getStat(lineArgs[4], ARMOR);

            List<Integer> stats = new ArrayList<>(3);
            stats.add(damage);
            stats.add(health);
            stats.add(armor);

            if (!dragonTypeMap.containsKey(type)) {
                Map<String, List<Integer>> dragonNameMap = new TreeMap<>();
                dragonNameMap.put(name, stats);
                dragonTypeMap.put(type, dragonNameMap);

            } else {
                Map<String, List<Integer>> dragonNameMap = dragonTypeMap.get(type);
                dragonNameMap.put(name, stats);
                dragonTypeMap.put(type, dragonNameMap);
            }

        }

        for (Map.Entry<String, Map<String, List<Integer>>> typeEntry : dragonTypeMap.entrySet()) {

            Collection<List<Integer>> totalStats = typeEntry.getValue().values();
            int totalDamage = 0, totalHealth = 0, totalArmor = 0;
            for (List<Integer> list : totalStats) {
                totalDamage += list.get(0);
                totalHealth += list.get(1);
                totalArmor += list.get(2);
            }

            int numberOfDragons = totalStats.size();
            double avgDamage = (double) totalDamage / numberOfDragons;
            double avgHealth = (double) totalHealth / numberOfDragons;
            double avgArmor = (double) totalArmor / numberOfDragons;

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", typeEntry.getKey(), avgDamage, avgHealth, avgArmor);

            for (Map.Entry<String, List<Integer>> nameEntry : typeEntry.getValue().entrySet()) {
                int damage = nameEntry.getValue().get(0);
                int health = nameEntry.getValue().get(1);
                int armor = nameEntry.getValue().get(2);

                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n",
                        nameEntry.getKey(), damage, health, armor);
            }


        }

    }
}

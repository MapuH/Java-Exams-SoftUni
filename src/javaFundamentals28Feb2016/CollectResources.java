package javaFundamentals28Feb2016;

import java.util.*;

/*
 * Created by MapuH on 24-Mar-2016
 *
 * Description can be found at:
 * https://judge.softuni.bg/Contests/Practice/DownloadResource/1178
 */
public class CollectResources {

    public static void main(String[] args) {

        List<String> validResources = new ArrayList<>(4);
        validResources.add("stone");
        validResources.add("gold");
        validResources.add("wood");
        validResources.add("food");

        Scanner input = new Scanner(System.in);
        String[] resourcesArr = input.nextLine().trim().split(" ");
        int n = Integer.parseInt(input.nextLine());

        List<Integer> collectibleQuantities = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String[] lineArgs = input.nextLine().split(" ");
            int start = Integer.parseInt(lineArgs[0]);
            int step = Integer.parseInt(lineArgs[1]);
            int quantityTotal = 0;
            List<String> resources = new ArrayList<>(Arrays.asList(resourcesArr));
            int lastIndex = -1;

            path:
            while (true) {
                if (lastIndex > -1) {
                    start = (lastIndex + step) % resources.size();
                }

                for (int j = start; j < resources.size(); j += step) {

                    if (resources.get(j).equals("collected")) {
                        break path;
                    }

                    String resource;
                    int quantity;
                    if (resources.get(j).contains("_")) {
                        String[] resArgs = resources.get(j).split("_");
                        resource = resArgs[0];
                        quantity = Integer.parseInt(resArgs[1]);
                    } else {
                        resource = resources.get(j);
                        quantity = 1;
                    }

                    if (validResources.contains(resource)) {
                        quantityTotal += quantity;
                        resources.set(j, "collected");
                    }

                    lastIndex = j;
                }
            }

            collectibleQuantities.add(quantityTotal);
        }

        Collections.sort(collectibleQuantities);
        System.out.println(collectibleQuantities.get(collectibleQuantities.size()-1));
    }
}

package CSharpBasics14Apr2014;

import java.util.*;

/*
 * Created by MapuH on 19-Apr-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/csharp-basics/Exams/2014-04-14-2Evening/Problem04-Magic-Car-Numbers.zip
 */
public class MagicCarNumbers {

    private static final Map<Character, Integer> WEIGHTS_MAP;
    static {
        Map<Character, Integer> weights = new HashMap<>();
        weights.put('A', 10);
        weights.put('B', 20);
        weights.put('C', 30);
        weights.put('E', 50);
        weights.put('H', 80);
        weights.put('K', 110);
        weights.put('M', 130);
        weights.put('P', 160);
        weights.put('T', 200);
        weights.put('X', 240);
        WEIGHTS_MAP = Collections.unmodifiableMap(weights);
    }

    private static int getWeight(String licensePlate) {
        int weight = 40;
        for (char ch : licensePlate.substring(2).toCharArray()) {
            if (WEIGHTS_MAP.containsKey(ch)) {
                weight += WEIGHTS_MAP.get(ch);
            } else {
                weight += Character.getNumericValue(ch);
            }
        }

        return weight;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int magic = input.nextInt();
        Set<String> validPlates = new HashSet<>();

        for (char x : WEIGHTS_MAP.keySet()) {
            for (char y : WEIGHTS_MAP.keySet()) {
                for (int i = 0; i < 10; i++) {

                    String plate = String.format("CA%d%d%d%d%c%c", i, i, i, i, x, y);
                    if (getWeight(plate) == magic) {
                        validPlates.add(plate);
                    }

                    for (int j = 0; j < 10; j++) {
                        plate = String.format("CA%d%d%d%d%c%c", i, i, i, j, x, y);
                        if (getWeight(plate) == magic) {
                            validPlates.add(plate);
                        }

                        plate = String.format("CA%d%d%d%d%c%c", i, j, j, j, x, y);
                        if (getWeight(plate) == magic) {
                            validPlates.add(plate);
                        }

                        plate = String.format("CA%d%d%d%d%c%c", i, i, j, j, x, y);
                        if (getWeight(plate) == magic) {
                            validPlates.add(plate);
                        }

                        plate = String.format("CA%d%d%d%d%c%c", i, j, i, j, x, y);
                        if (getWeight(plate) == magic) {
                            validPlates.add(plate);
                        }

                        plate = String.format("CA%d%d%d%d%c%c", i, j, j, i, x, y);
                        if (getWeight(plate) == magic) {
                            validPlates.add(plate);
                        }

                    }
                    
                }
            }
        }


        System.out.println(validPlates.size());
    }
}

package javaBasics08Feb2015;

import java.util.*;

/**
 * Created by marin on 3/5/16.
 *
 * Problem description, solutions and tests can be found at
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-02-08/Problem01-Gandalf's-Stash.zip
 */
public class GandalfsStash {

    private static final Map<String, Integer> FOODS;
    static {
        Map<String, Integer> map = new HashMap<>();
        map.put("cram", 2);
        map.put("lembas", 3);
        map.put("apple", 1);
        map.put("melon", 1);
        map.put("honeycake", 5);
        map.put("mushrooms", -10);
        FOODS = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int mood = input.nextInt();
        input.nextLine();
        String[] foodArr = input.nextLine().toLowerCase().split("[\\W_*]+");

        for (String food : foodArr) {
            if (FOODS.containsKey(food)) {
                mood += FOODS.get(food);
            } else {
                mood--;
            }
        }

        System.out.println(mood);

        if (mood < -5) {
            System.out.println("Angry");
        } else if (mood < 0) {
            System.out.println("Sad");
        } else if (mood <= 15) {
            System.out.println("Happy");
        } else System.out.println("Special JavaScript mood");

    }
}

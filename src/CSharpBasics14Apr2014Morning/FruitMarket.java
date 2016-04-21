package CSharpBasics14Apr2014Morning;

import java.util.*;

/*
 * Created by MapuH on 21-Apr-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/csharp-basics/Exams/2014-04-14-1Morning/Problem01-Fruit-Market.zip
 */
public class FruitMarket {

    public static void main(String[] args) {

        Map<String, Double> fruits = new HashMap<>();
        fruits.put("banana", 1.8);
        fruits.put("orange", 1.6);
        fruits.put("apple", 0.86);

        Map<String, Double> vegetables = new HashMap<>();
        vegetables.put("cucumber", 2.75);
        vegetables.put("tomato", 3.2);

        Scanner input = new Scanner(System.in);
        String day = input.nextLine().trim();
        double total = 0.0;

        for (int i = 0; i < 3; i++) {
            double quantity = Double.parseDouble(input.nextLine().trim());
            String product = input.nextLine().trim();

            switch (day) {
                case "Tuesday":
                    if (fruits.containsKey(product)) {
                        total += quantity * fruits.get(product) * 0.8;
                    } else {
                        total += quantity * vegetables.get(product);
                    }
                    break;
                case "Wednesday":
                    if (vegetables.containsKey(product)) {
                        total += quantity * vegetables.get(product) * 0.9;
                    } else {
                        total += quantity * fruits.get(product);
                    }
                    break;
                case "Thursday":
                    if (fruits.containsKey(product)) {
                        if (product.equals("banana")) {
                            total += quantity * fruits.get(product) * 0.7;
                        } else {
                            total += quantity * fruits.get(product);
                        }
                    } else {
                        total += quantity * vegetables.get(product);
                    }
                    break;
                case "Friday":
                    if (fruits.containsKey(product)) {
                        total += quantity * fruits.get(product) * 0.9;
                    } else {
                        total += quantity * vegetables.get(product) * 0.9;
                    }
                    break;
                case "Sunday":
                    if (fruits.containsKey(product)) {
                        total += quantity * fruits.get(product) * 0.95;
                    } else {
                        total += quantity * vegetables.get(product) * 0.95;
                    }
                    break;
                default:
                    if (fruits.containsKey(product)) {
                        total += quantity * fruits.get(product);
                    } else {
                        total += quantity * vegetables.get(product);
                    }
                    break;
            }
        }

        System.out.printf("%.2f", total);
    }
}

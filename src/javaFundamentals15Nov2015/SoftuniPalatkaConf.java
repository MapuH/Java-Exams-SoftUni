package javaFundamentals15Nov2015;

import java.util.*;

/*
 * Created by MapuH on 22-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-11-15/Problem01-Softuni-Palatki-Ponf.zip
 */
public class SoftuniPalatkaConf {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int people = Integer.parseInt(input.nextLine());
        int n = Integer.parseInt(input.nextLine());

        int beds = 0;
        int meals = 0;

        for (int i = 0; i < n; i++) {
            String[] lineArgs = input.nextLine().split("\\s+");
            int quantity = Integer.parseInt(lineArgs[1]);
            String type = lineArgs[2];

            if (type.equals("normal") || type.equals("double")) {
                beds += 2 * quantity;
            } else if (type.equals("firstClass") || type.equals("triple")) {
                beds += 3 * quantity;
            } else if (type.equals("single")) {
                beds += quantity;
            } else if (type.equals("musaka")) {
                meals += 2 * quantity;
            }

        }

        if (beds >= people) {
            System.out.println("Everyone is happy and sleeping well. Beds left: " + (beds - people));
        } else {
            System.out.println("Some people are freezing cold. Beds needed: " + (people - beds));
        }

        if (meals >= people) {
            System.out.println("Nobody left hungry. Meals left: " + (meals - people));
        } else {
            System.out.println("People are starving. Meals needed: " + (people - meals));
        }
    }
}

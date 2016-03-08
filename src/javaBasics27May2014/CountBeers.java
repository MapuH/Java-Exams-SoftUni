package javaBasics27May2014;

import java.util.*;

/**
 * Created by MapuH on 08-Mar-2016
 *
 * Description, solution and tests can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-05-27/Problem01-Count-Beers.zip
 */
public class CountBeers {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String line = input.nextLine().trim();
        int beers = 0;

        while (!line.equals("End")) {
            String[] lineArgs = line.split("\\s+");
            if (lineArgs[1].equals("stacks")) {
                beers += Integer.parseInt(lineArgs[0]) * 20;
            } else {
                beers += Integer.parseInt(lineArgs[0]);
            }

            line = input.nextLine().trim();
        }

        System.out.printf("%d stacks + %d beers", beers/20, beers % 20);

    }
}

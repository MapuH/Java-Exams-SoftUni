package javaBasics03Sep2014;

import java.util.*;

/**
 * Created by MapuH on 06-Mar-2016
 *
 * Description, solution and tests can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-09-03/Problem01-Dozen-Eggs.zip
 */
public class DozenEggs {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int totalEggs = 0;

        for (int i = 0; i < 7; i++) {
            String line = input.nextLine();
            String[] eggArgs = line.trim().split("\\s+");
            if (eggArgs[1].equals("eggs")) {
                totalEggs += Integer.parseInt(eggArgs[0]);
            } else {
                totalEggs += Integer.parseInt(eggArgs[0]) * 12;
            }
        }

        int dozens = totalEggs / 12;
        int eggs = totalEggs % 12;

        System.out.printf("%d dozens + %d eggs", dozens, eggs);

    }
}

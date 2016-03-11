package javaBasics21Sep2014Morning;

import java.util.*;

/*
 * Created by MapuH on 11-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-09-21-1Morning/Problem02-Magic-Sum.zip
 */
public class MagicSum {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int divider = Integer.parseInt(input.nextLine());

        String line = input.nextLine();
        List<Integer> numbers = new ArrayList<>();
        while (!line.equals("End")) {
            numbers.add(Integer.parseInt(line));
            line = input.nextLine();
        }

        int biggestSum = Integer.MIN_VALUE;
        String output = null;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                for (int k = j + 1; k < numbers.size(); k++) {
                    int a = numbers.get(i);
                    int b = numbers.get(j);
                    int c = numbers.get(k);

                    int currentSum = a + b + c;
                    if (currentSum % divider == 0 && currentSum > biggestSum) {
                        biggestSum = currentSum;
                        output = String.format("(%d + %d + %d) %% %d = 0", a, b, c, divider);
                    }
                }
            }
        }

        if (output != null) {
            System.out.println(output);
        } else {
            System.out.println("No");
        }

    }
}

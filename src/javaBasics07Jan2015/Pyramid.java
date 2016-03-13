package javaBasics07Jan2015;

import java.util.*;

/*
 * Created by MapuH on 13-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-01-07/Problem01-Pyramid.zip
 */
public class Pyramid {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = input.nextLine().trim();
        }

        List<Integer> sequence = new ArrayList<>();

        int comparator = Integer.parseInt(lines[0]);
        sequence.add(comparator);

        for (int i = 1; i < lines.length; i++) {
            String[] strNums = lines[i].split("\\s+");
            List<Integer> numbers = new ArrayList<>();
            for (String strNum : strNums) {
                numbers.add(Integer.parseInt(strNum));
            }
            Collections.sort(numbers);

            boolean foundBigger = false;
            for (int number : numbers) {
                if (number > comparator) {
                    sequence.add(number);
                    comparator = number;
                    foundBigger = true;
                    break;
                }
            }

            if (!foundBigger) {
                comparator++;
            }
        }

        System.out.println(sequence.toString().replaceAll("[\\[\\]]", ""));
    }
}

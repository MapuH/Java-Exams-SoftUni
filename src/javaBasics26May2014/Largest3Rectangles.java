package javaBasics26May2014;

import java.util.*;

/**
 * Created by MapuH on 07-Mar-2016
 *
 * Description, solution and tests can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-05-26/Problem03-Largest3Rectangles.zip
 */
public class Largest3Rectangles {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] strNums = input.nextLine().trim().split("\\D+");

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < strNums.length; i++) {
            if (!strNums[i].equals("")) {
                numbers.add(Integer.parseInt(strNums[i]));
            }
        }

        List<Integer> areas = new ArrayList<>();
        for (int i = 0; i < numbers.size() - 1; i+=2) {
            areas.add(numbers.get(i) * numbers.get(i+1));
        }

        int biggestAreaSum = 0;
        for (int i = 0; i < areas.size()-2; i++) {
            int areaSum = areas.get(i) + areas.get(i+1) + areas.get(i+2);
            if (areaSum > biggestAreaSum) {
                biggestAreaSum = areaSum;
            }
        }

        System.out.println(biggestAreaSum);

    }
}

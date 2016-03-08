package javaBasics27May2014;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by MapuH on 08-Mar-2016
 *
 * Description, solution and tests can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-05-27/Problem02-Three-Largest-Numbers.zip
 */
public class ThreeLargestNumbers {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        List<BigDecimal> numbers = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            numbers.add(input.nextBigDecimal());
        }

        Collections.sort(numbers);
        Collections.reverse(numbers);

        if (numbers.size() >= 3) {
            for (int i = 0; i < 3; i++) {
                System.out.println(numbers.get(i).toPlainString());
            }
        } else {
            for (BigDecimal number : numbers) {
                System.out.println(number.toPlainString());
            }
        }
    }
}

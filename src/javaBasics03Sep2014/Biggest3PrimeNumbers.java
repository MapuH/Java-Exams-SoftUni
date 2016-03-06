package javaBasics03Sep2014;

import java.util.*;

/**
 * Created by MapuH on 06-Mar-2016
 *
 * Description, solution and tests can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-09-03/Problem03-Biggest3Prime-Numbers.zip
 */
public class Biggest3PrimeNumbers {

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        if (number > 2 && number % 2 == 0) {
            return false;
        }

        int i;
        for (i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] strNums = input.nextLine().trim().split("[^-0-9]+");

        SortedSet<Integer> primes = new TreeSet<>(Collections.reverseOrder());
        for (String num : strNums) {
            if (!num.equals("")) {
                int number = Integer.parseInt(num);
                if (isPrime(number)) {
                    primes.add(number);
                }
            }
        }

        if (primes.size() < 3) {
            System.out.println("No");
        } else {
            List<Integer> temp = new ArrayList<>(primes);
            System.out.println(temp.get(0) + temp.get(1) + temp.get(2));
        }

    }
}

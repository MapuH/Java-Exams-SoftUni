package CSharpBasics14Apr2014Morning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

/*
 * Created by MapuH on 21-Apr-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/csharp-basics/Exams/2014-04-14-1Morning/Problem02-Biggest-Triple.zip
 */
public class BiggestTripple {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String line = input.nextLine().trim();
        String[] strNums = line.split("\\s+");
        List<Integer> numbers = new ArrayList<>();

        for (String num : strNums) {
            numbers.add(Integer.parseInt(num));
        }

        int biggest = -3000;
        String output = "";

        if (numbers.size() >= 3) {

            for (int i = 0; i < numbers.size(); i += 3) {
                if (i >= numbers.size()-2) {
                    break;
                }

                int sum = numbers.get(i) + numbers.get(i+1) + numbers.get(i+2);
                if (sum > biggest) {
                    biggest = sum;
                    output = String.format("%d %d %d", numbers.get(i), numbers.get(i+1), numbers.get(i+2));
                }
            }

            int remainder = numbers.size() % 3;
            if (remainder == 1) {
                if (numbers.get(numbers.size()-1) > biggest) {
                    biggest = numbers.get(numbers.size()-1);
                    output = String.format("%d", biggest);
                }
            } else if (remainder == 2) {
                int sum = numbers.get(numbers.size()-2) + numbers.get(numbers.size()-1);
                if (sum > biggest) {
                    output = String.format("%d %d", numbers.get(numbers.size()-2), numbers.get(numbers.size()-1));
                }
            }
        } else {
            output = line;
        }

        System.out.println(output);
    }
}

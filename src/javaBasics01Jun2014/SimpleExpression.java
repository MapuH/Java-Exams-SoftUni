package javaBasics01Jun2014;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.*;

/**
 * Created by marin on 2/28/16.
 *
 * You are given an arithmetic expression,
 * consisting of positive numbers and '+' and '-' between them.
 * Write a program to calculate the value of the expression.
 * The input comes from the console.
 * It consists of a single line holding the arithmetic expression.
 * It consists of positive numbers and '+' and '-' between them.
 * Anywhere around the numbers spaces could appear.
 */
public class SimpleExpression {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String line = input.nextLine().replaceAll(" ", "");

        BigDecimal value = new BigDecimal(0);

        Pattern pattern = Pattern.compile("-?\\d+\\.?\\d*");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            BigDecimal num = new BigDecimal(matcher.group(0));
            value = value.add(num);
        }

        System.out.println(value.toPlainString());

    }
}

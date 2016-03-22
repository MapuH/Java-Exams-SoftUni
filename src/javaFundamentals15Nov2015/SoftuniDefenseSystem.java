package javaFundamentals15Nov2015;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Created by MapuH on 22-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-11-15/Problem02-Softuni-Defensi-Dystem.zip
 */

/*
 * Much simpler solution by SoftUni:
 *
 *      Pattern pattern = Pattern.compile("([A-Z][a-z]+).*?([A-Z][a-z]*[A-Z]).*?(\\d+)L");
        while (!line.equals("OK KoftiShans")) {
            Matcher match = pattern.matcher(line);
            while (match.find()) {
                String guest = match.group(1);
                String alcohol = match.group(2).toLowerCase();
                int quantity = Integer.parseInt(match.group(3));
 */

public class SoftuniDefenseSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int liters = 0;

        Pattern pattern = Pattern.compile("[A-Z][a-z]+.*?[A-Z][a-z]*[A-Z].*?[0-9]+L");
        List<String> matches = new ArrayList<>();

        String line = input.nextLine();
        while (!line.equals("OK KoftiShans")) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                matches.add(matcher.group(0));
            }

            line = input.nextLine();
        }

        for (String match : matches) {
            int quantity = 0;
            pattern = Pattern.compile("[0-9]+L");
            Matcher matcher = pattern.matcher(match);
            if (matcher.find()) {
                String inLiters = matcher.group(0);
                quantity = Integer.parseInt(inLiters.substring(0, inLiters.length()-1));
            }
            liters += quantity;

            String name = "";
            pattern = Pattern.compile("[A-Z][a-z]+");
            matcher = pattern.matcher(match);
            if (matcher.find()) {
                name = matcher.group(0);
            }

            String booze = "";
            pattern = Pattern.compile("[A-Z][a-z]*[A-Z]");
            matcher = pattern.matcher(match.replace(name, ""));
            if (matcher.find()) {
                booze = matcher.group(0).toLowerCase();
            }


            System.out.printf("%s brought %d liters of %s!\n", name, quantity, booze);
        }

        System.out.printf("%.3f softuni liters", liters/1000.0);

    }
}

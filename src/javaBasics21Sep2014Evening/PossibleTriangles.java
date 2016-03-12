package javaBasics21Sep2014Evening;

import java.util.*;

/*
 * Created by MapuH on 12-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-09-21-2Evening/Problem02-Possible-Triangles.zip
 */
public class PossibleTriangles {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String line = input.nextLine().trim();
        boolean foundTriangle = false;

        while (!line.equals("End")) {
            List<Double> sides = new ArrayList<>();
            String[] lineArgs = line.split("\\s+");

            for (String str : lineArgs) {
                sides.add(Double.parseDouble(str));
            }
            Collections.sort(sides);

            if (sides.size() > 2 && sides.get(0) + sides.get(1) > sides.get(2)) {
                System.out.printf("%.2f+%.2f>%.2f\n", sides.get(0), sides.get(1), sides.get(2));
                foundTriangle = true;
            }

            line = input.nextLine();
        }

        if (!foundTriangle) {
            System.out.println("No");
        }
    }
}

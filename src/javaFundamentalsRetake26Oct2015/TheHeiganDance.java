package javaFundamentalsRetake26Oct2015;

import java.util.*;

/*
 * Created by MapuH on 20-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-10-26/Problem03-The-Heigae-Hance.zip
 *
 * NOTE: Not finished yet!
 */
public class TheHeiganDance {

    private final int CLOUD_DAMAGE = 3500;
    private final int ERUPTION_DAMAGE = 6000;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double damage = Double.parseDouble(input.nextLine());

        int playerHealth = 18500;
        double heiganHealth = 3000000.0;
        int[] position = {7, 7};

        String line = input.nextLine().trim();
        while (true) {
            String[] lineArgs = line.split("\\s+");
            String spell = lineArgs[0];
            int row = Integer.parseInt(lineArgs[1]);
            int col = Integer.parseInt(lineArgs[2]);
        }

    }
}

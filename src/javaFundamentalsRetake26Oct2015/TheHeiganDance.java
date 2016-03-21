package javaFundamentalsRetake26Oct2015;

import java.util.*;

/*
 * Created by MapuH on 20-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-10-26/Problem03-The-Heigae-Hance.zip
 *
 * NOTE: Used SoftUni's solution!
 */
public class TheHeiganDance {

    private static final int CLOUD_DAMAGE = 3500;
    private static final int ERUPTION_DAMAGE = 6000;
    private static final int MIN = 0;
    private static final int MAX = 14;
    private static Map<String, Integer> damagePositions = new HashMap<>();

    private static void getDamageArea(int row, int col) {
        damagePositions = new HashMap<>();
        damagePositions.put("minRow", row - 1);
        damagePositions.put("maxRow", row + 1);
        damagePositions.put("minCol", col - 1);
        damagePositions.put("maxCol", col + 1);
    }

    private static boolean isPlayerInDamageZone(int[] playerPosition) {
        boolean isInHitRow = playerPosition[0] >= damagePositions.get("minRow") &&
                playerPosition[0] <= damagePositions.get("maxRow");
        boolean isInHitCol = playerPosition[1] >= damagePositions.get("minCol") &&
                playerPosition[1] <= damagePositions.get("maxCol");

        return isInHitRow && isInHitCol;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double damage = Double.parseDouble(input.nextLine());
        int playerHealth = 18500;
        double heiganHealth = 3000000.0;
        boolean playerDead =  false;
        boolean heiganDead = false;
        int[] position = {7, 7};
        boolean plagueCloud = false;
        String killedBy = "";

        String line = input.nextLine().trim();
        while (true) {
            String[] lineArgs = line.split("\\s+");
            String spell = lineArgs[0];
            int row = Integer.parseInt(lineArgs[1]);
            int col = Integer.parseInt(lineArgs[2]);

            heiganHealth -= damage;
            heiganDead = heiganHealth <= 0;

            if (plagueCloud) {
                playerHealth -= CLOUD_DAMAGE;
                plagueCloud = false;
                killedBy = "Plague Cloud";
                playerDead = playerHealth <= 0;
            }

            if (heiganDead || playerDead) {
                break;
            }

            getDamageArea(row, col);
            if (isPlayerInDamageZone(position)) {
                if (position[0] > MIN && position[0] == damagePositions.get("minRow")) {
                    position[0] --;
                } else if (position[0] < MAX && position[0] == damagePositions.get("maxRow")) {
                    position[0] ++;
                } else if (position[1] > MIN && position[1] == damagePositions.get("minCol")) {
                    position[1]--;
                } else if (position[1] < MAX && position[1] == damagePositions.get("maxCol")) {
                    position[1]++;
                }
            }

            if (isPlayerInDamageZone(position)) {
                if (spell.equals("Cloud")) {
                    playerHealth -= CLOUD_DAMAGE;
                    plagueCloud = true;
                    killedBy = "Plague Cloud";
                } else {
                    playerHealth -= ERUPTION_DAMAGE;
                    killedBy = "Eruption";
                }
            }

            playerDead = playerHealth <= 0;
            if (playerDead) {
                break;
            }

            line = input.nextLine().trim();
        }

        if (heiganDead) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f\n", heiganHealth);
        }

        if (playerDead) {
            System.out.println("Player: Killed by " + killedBy);
        } else  {
            System.out.println("Player: " + playerHealth);
        }

        System.out.printf("Final position: %d, %d", position[0], position[1]);

    }
}

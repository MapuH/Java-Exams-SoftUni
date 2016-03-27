package javaFundamentals28Feb2016;

import java.util.*;

/*
 * Created by MapuH on 27-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://judge.softuni.bg/Contests/Practice/DownloadResource/1179
 */
public class ParkingSystem {

    private static boolean isRowFull(boolean[] row) {
        for (int i = 1; i < row.length ; i++) {
            if (row[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int r = input.nextInt();
        int c = input.nextInt();
        input.nextLine();

        boolean[][] parkingLot = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                parkingLot[i][j] = true;
            }

        }

        String line = input.nextLine().trim();
        while (!line.equals("stop")) {
            String[] lineArgs = line.split(" ");
            int entry = Integer.parseInt(lineArgs[0]);
            int x = Integer.parseInt(lineArgs[1]);
            int y = Integer.parseInt(lineArgs[2]);

            if (isRowFull(parkingLot[x])) {
                System.out.printf("Row %d full\n", x);

            } else {
                int distance = 1 + Math.abs(x - entry);

                if (parkingLot[x][y]) {
                    distance += y;
                    parkingLot[x][y] = false;
                } else {
                    int closestLeft = -1;
                    int closestRight = -1;

                    for (int i = y; i < c; i++) {
                        if (parkingLot[x][i]) {
                            closestRight = i;
                            break;
                        }
                    }

                    for (int i = y; i > 0; i--) {
                        if (parkingLot[x][i]) {
                            closestLeft = i;
                            break;
                        }
                    }

                    if (closestLeft == -1) {
                        distance += closestRight;
                        parkingLot[x][closestRight] = false;
                    } else if (closestRight == -1) {
                        distance += closestLeft;
                        parkingLot[x][closestLeft] = false;
                    } else {
                        if (y - closestLeft <= closestRight - y) {
                            distance += closestLeft;
                            parkingLot[x][closestLeft]= false;
                        } else {
                            distance += closestRight;
                            parkingLot[x][closestRight] = false;
                        }
                    }

                }

                System.out.println(distance);
            }

            line = input.nextLine().trim();
        }
    }
}

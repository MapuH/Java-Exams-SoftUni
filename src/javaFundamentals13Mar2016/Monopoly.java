package javaFundamentals13Mar2016;

import java.util.*;

/*
 * Created by MapuH on 28-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://judge.softuni.bg/Contests/Practice/DownloadResource/1197
 */
public class Monopoly {

    public static void main(String[] args) {

        int turns = 0;
        int money = 50;
        int hotels = 0;

        Scanner input = new Scanner(System.in);
        int r = input.nextInt();
        int c = input.nextInt();
        input.nextLine();

        for (int i = 0; i < r; i++) {
            char[] row = input.nextLine().trim().toCharArray();

            if (i % 2 == 0) {
                for (int j = 0; j < row.length; j++) {
                    switch (row[j]) {
                        case 'H':
                            hotels++;
                            System.out.printf("Bought a hotel for %d. Total hotels: %d.\n", money, hotels);
                            money = 0;
                            money += hotels * 10;
                            turns++;
                            break;
                        case 'J':
                            System.out.printf("Gone to jail at turn %d.\n", turns);
                            money += (hotels * 10) * 3;
                            turns += 3;
                            break;
                        case 'S':
                            int expense;
                            if ((i + 1) * (j + 1) > money) {
                                expense = money;
                            } else {
                                expense = (i + 1) * (j + 1);
                            }
                            System.out.printf("Spent %d money at the shop.\n", expense);
                            money -= expense;
                            money += hotels * 10;
                            turns++;
                            break;
                        default:
                            money += hotels * 10;
                            turns++;
                            break;
                    }
                }

            } else {
                for (int j = row.length-1; j >= 0 ; j--) {
                    switch (row[j]) {
                        case 'H':
                            hotels++;
                            System.out.printf("Bought a hotel for %d. Total hotels: %d.\n", money, hotels);
                            money = 0;
                            money += hotels * 10;
                            turns++;
                            break;
                        case 'J':
                            System.out.printf("Gone to jail at turn %d.\n", turns);
                            money += (hotels * 10) * 3;
                            turns += 3;
                            break;
                        case 'S':
                            int expense;
                            if ((i + 1) * (j + 1) > money) {
                                expense = money;
                            } else {
                                expense = (i + 1) * (j + 1);
                            }
                            System.out.printf("Spent %d money at the shop.\n", expense);
                            money -= expense;
                            money += hotels * 10;
                            turns++;
                            break;
                        default:
                            money += hotels * 10;
                            turns++;
                            break;
                    }
                }
            }
        }

        System.out.println("Turns " + turns);
        System.out.println("Money " + money);
    }
}

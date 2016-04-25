package CSharpBasics14Apr2014Morning;

import java.util.Scanner;

/*
 * Created by MapuH on 24-Apr-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/csharp-basics/Exams/2014-04-14-1Morning/Problem03-Wine-Glass.zip
 */
public class WineGlass {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        // print upper part of the glass
        for (int dots = 0; dots <= n-2; dots += 2) {
            int stars = n - 2 - dots;

            for (int j = 0; j < dots/2; j++) {
                System.out.print('.');
            }

            System.out.print('\\');

            for (int j = 0; j < stars; j++) {
                System.out.print('*');
            }

            System.out.print('/');

            for (int j = 0; j < dots/2; j++) {
                System.out.print('.');
            }

            System.out.print('\n');
        }

        // print lower part of the glass
        if (n < 12) {
            int dots = n/2 - 1;
            for (int i = 0; i < n/2 - 1; i++) {

                for (int j = 0; j < dots; j++) {
                    System.out.print('.');
                }

                System.out.print("||");

                for (int j = 0; j < dots; j++) {
                    System.out.print('.');
                }

                System.out.print('\n');
            }

            for (int i = 0; i < n; i++) {
                System.out.print('-');
            }

            System.out.print('\n');

        } else {
            int dots = n/2 - 1;
            for (int i = 0; i < n/2 - 2; i++) {

                for (int j = 0; j < dots; j++) {
                    System.out.print('.');
                }

                System.out.print("||");

                for (int j = 0; j < dots; j++) {
                    System.out.print('.');
                }

                System.out.print('\n');
            }

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print('-');
                }

                System.out.print('\n');
            }
        }

    }
}

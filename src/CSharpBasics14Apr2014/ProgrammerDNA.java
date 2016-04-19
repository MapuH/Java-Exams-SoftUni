package CSharpBasics14Apr2014;

import java.util.*;

/*
 * Created by MapuH on 19-Apr-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/csharp-basics/Exams/2014-04-14-2Evening/Problem03-Programmer-DNA.zip
 */
public class ProgrammerDNA {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        char letter = input.nextLine().trim().charAt(0);
        int letters = 1;
        boolean goingUp = true;

        for (int i = 0; i < n; i++) {

            int dots = (7 - letters) / 2;
            for (int j = 0; j < dots; j++) {
                System.out.print('.');
            }

            for (int j = 0; j < letters; j++) {
                System.out.print(letter);
                if (letter >= 'G') {
                    letter = 'A';
                } else {
                    letter++;
                }
            }

            for (int j = 0; j < dots; j++) {
                System.out.print('.');
            }

            System.out.print("\n");

            if (goingUp) {
                letters += 2;
                if (letters > 7) {
                    letters = 5;
                    goingUp = false;
                }
            } else {
                letters -= 2;
                if (letters < 1) {
                    letters = 1;
                    goingUp = true;
                }
            }

        }
    }
}

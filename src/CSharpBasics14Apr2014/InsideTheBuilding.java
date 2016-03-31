package CSharpBasics14Apr2014;

import java.util.*;

/*
 * Created by MapuH on 31-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/csharp-basics/Exams/2014-04-14-2Evening/Problem01-Inside-The-Building.zip
 */
public class InsideTheBuilding {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int h = input.nextInt();
        boolean inside = false;

        for (int i = 0; i < 5; i++) {
            int x = input.nextInt();
            int y = input.nextInt();

            boolean horizontal = (x >= 0 && x <= 3*h) && (y >= 0 && y <= h);
            boolean vertical = (x >= h && x <= 2*h) && (y >= 0 && y <= 4*h);
            inside = horizontal || vertical;

            if (inside) {
                System.out.println("inside");
            } else {
                System.out.println("outside");
            }

            inside = false;
        }
    }
}

package CSharpBasics14Apr2014Morning;

import java.util.*;

/*
 * Created by MapuH on 25-Apr-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/csharp-basics/Exams/2014-04-14-1Morning/Problem05-Bit-Shooter.zip
 */
public class BitShooter {

    private static String reverseString(String text) {
        String reversed = "";
        for (int i = text.length()-1; i >= 0 ; i--) {
            reversed += Character.toString(text.charAt(i));
        }

        return reversed;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String bits = reverseString(String.format("%64s", input.nextBigInteger().toString(2)).replace(' ', '0'));

        for (int i = 0; i < 3; i++) {
            int center = input.nextInt();
            int size = input.nextInt();
            int start;
            int end;

            if (center < (size-1)/2) {
                start = 0;
                end = 1 + center + (size-1)/2;
                String replaced = bits.substring(start, end).replace('1', '0');
                bits = replaced + bits.substring(end);
            } else if (center > (63 - (size-1)/2)) {
                start = 63 - (size-1)/2;
                end = 64;
                String replaced = bits.substring(start, end).replace('1', '0');
                bits = bits.substring(0, start) + replaced;
            } else {
                start = center - (size-1)/2;
                end = 1 + center + (size-1)/2;
                String replaced = bits.substring(start, end).replace('1', '0');
                bits = bits.substring(0, start) + replaced + bits.substring(end);
            }
        }

        bits = reverseString(bits);
        int l = 0;
        int r = 0;

        for (char ch : bits.substring(0, 32).toCharArray()) {
            if (ch == '1') {
                l++;
            }
        }

        for (char ch : bits.substring(32).toCharArray()) {
            if (ch == '1') {
                r++;
            }
        }

        System.out.println("left: " + l);
        System.out.println("right: " + r);
    }
}

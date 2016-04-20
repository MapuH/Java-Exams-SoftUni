package CSharpBasics14Apr2014;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Created by MapuH on 20-Apr-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/csharp-basics/Exams/2014-04-14-2Evening/Problem05-Bit-Flipper.zip
 */
public class BitFlipper {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String bits = String.format("%64s", input.nextBigInteger().toString(2)).replace(' ', '0');
        String flipped = "";

        Pattern pattern = Pattern.compile("(000)|(111)");
        Matcher matcher = pattern.matcher(bits);

        int start = 0;

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                int index = bits.indexOf(matcher.group(1), start);
                flipped += bits.substring(start, index) + "111";
                start = index + 3;
            } else {
                int index = bits.indexOf(matcher.group(2), start);
                flipped += bits.substring(start, index) + "000";
                start = index + 3;
            }
        }

        if (start < 64) {
            flipped += bits.substring(start);
        }

        System.out.println(new BigInteger(flipped, 2));
    }
}

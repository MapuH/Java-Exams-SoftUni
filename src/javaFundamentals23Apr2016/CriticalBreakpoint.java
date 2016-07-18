package javaFundamentals23Apr2016;

import java.math.BigInteger;
import java.util.*;

/*
 * Created by MapuH on 10-Jul-2016
 *
 * Description, solution and test can be found at:
 * https://judge.softuni.bg/Contests/183/Java-Fundamentals-Exam-23-April-2016
 */
public class CriticalBreakpoint {

    private static long getCriticalRatio (int x1, int y1, int x2, int y2) {
        return Math.abs(((long)x2 + (long)y2) - ((long)x1 + (long)y1));
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String line = input.nextLine().trim();

        List<List<Integer>> lines = new ArrayList<>();
        int count = 0;

        while (!line.equals("Break it.")) {
            String[] lineArgs = line.split("\\s");
            int x1 = Integer.parseInt(lineArgs[0]);
            int y1 = Integer.parseInt(lineArgs[1]);
            int x2 = Integer.parseInt(lineArgs[2]);
            int y2 = Integer.parseInt(lineArgs[3]);

            List<Integer> currentLine = new ArrayList<>();
            currentLine.add(x1);
            currentLine.add(y1);
            currentLine.add(x2);
            currentLine.add(y2);

            lines.add(currentLine);
            line = input.nextLine().trim();
            count++;
        }

        boolean foundBreakpoint = true;
        long cRatio = getCriticalRatio(lines.get(0).get(0), lines.get(0).get(1), lines.get(0).get(2), lines.get(0).get(3));

        for (int i = 1; i < lines.size(); i++) {
            long currentRatio = getCriticalRatio(lines.get(i).get(0), lines.get(i).get(1), lines.get(i).get(2), lines.get(i).get(3));

            if (cRatio == 0) {
                cRatio = currentRatio;
            }

            if (!(currentRatio == cRatio) && !(currentRatio == 0L)) {
                foundBreakpoint = false;
                break;
            }
        }

        if (foundBreakpoint) {

            for (List<Integer> currentLine : lines) {
                System.out.printf("Line: %s\n", currentLine);
            }

            BigInteger result = new BigInteger(String.format("%s", cRatio));
            result = result.pow(count);
            BigInteger divisor = new BigInteger(Integer.valueOf(count).toString());
            BigInteger breakpoint = result.remainder(divisor);

            System.out.printf("Critical Breakpoint: %s", breakpoint);

        } else {
            System.out.println("Critical breakpoint does not exist.");
        }
    }
}

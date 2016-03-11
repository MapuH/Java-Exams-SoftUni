package javaBasics21Sep2014Morning;

import java.util.*;

/*
 * Created by MapuH on 11-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-09-21-1Morning/Problem01-Timespan.zip
 */
public class Timespan {

    /**
     * Returns the count of seconds in a certain
     * amount of time represented by a String in
     * format h:mm:ss (hours:minutes:seconds)
     *
     * @param time a String in format h:mm:ss
     * @return long count of seconds
     */
    private static long convertToSeconds(String time) {
        String[] timeArgs = time.trim().split(":");
        long hours = Long.parseLong(timeArgs[0]);
        long minutes = Long.parseLong(timeArgs[1]);
        long seconds = Long.parseLong(timeArgs[2]);

        return hours * 3600 + minutes * 60 + seconds;
    }

    private static String simpleTimeFormat(long timeInSeconds) {
        long hours = timeInSeconds / 3600;
        long minutes = (timeInSeconds % 3600) / 60;
        long seconds = (timeInSeconds % 3600) % 60;

        return String.format("%d:%02d:%02d", hours, minutes, seconds);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        long start = convertToSeconds(input.nextLine());
        long end = convertToSeconds(input.nextLine());

        System.out.println(simpleTimeFormat(start - end));

    }
}

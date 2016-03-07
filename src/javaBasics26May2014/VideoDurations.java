package javaBasics26May2014;

import java.util.*;

/**
 * Created by MapuH on 07-Mar-2016
 *
 * Description, solution and tests can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-05-26/Problem01-Video-Durations.zip
 */
public class VideoDurations {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int minutes = 0;

        while (!line.equals("End")) {
            String[] lineArgs = line.trim().split(":");
            minutes = minutes + Integer.parseInt(lineArgs[1]) + Integer.parseInt(lineArgs[0]) * 60;
            line = input.nextLine();
        }

        System.out.printf("%d:%02d", minutes/60, minutes % 60);

    }
}

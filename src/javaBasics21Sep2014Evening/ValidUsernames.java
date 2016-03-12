package javaBasics21Sep2014Evening;

import java.util.*;

/*
 * Created by MapuH on 12-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2014-09-21-2Evening/Problem03-Valid-Usernames.zip
 */
public class ValidUsernames {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] usernames = input.nextLine().trim().split("[/ \\\\()]+");

        List<String> validNames = new ArrayList<>();
        for (String username : usernames) {
            if (username.matches("^[a-zA-Z]{1}[a-zA-Z_0-9]{2,24}$")) {
                validNames.add(username);
            }
        }

        int biggestSum = 0;
        String output = "";
        for (int i = 1; i < validNames.size(); i++) {
            int currentSum = validNames.get(i-1).length() + validNames.get(i).length();
            if (currentSum > biggestSum) {
                biggestSum = currentSum;
                output = String.format("%s\n%s", validNames.get(i-1), validNames.get(i));
            }

        }

        System.out.println(output);
    }
}

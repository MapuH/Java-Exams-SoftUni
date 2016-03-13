package javaBasics11May2015;

import java.util.*;

/*
 * Created by MapuH on 13-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-05-11/Problem1-Enigma.zip
 */
public class Enigma {

    private static String decrypt(String line) {
        String result = "";
        int m = line.replaceAll("[ 0-9]+", "").length() / 2;

        for (int i = 0; i < line.length(); i++) {
            if (Character.toString(line.charAt(i)).matches("[ 0-9]")) {
                result += Character.toString(line.charAt(i));
            } else {
                char decrypted = (char) (line.charAt(i) + m);
                result += Character.toString(decrypted);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            System.out.println(decrypt(line));
        }

    }
}

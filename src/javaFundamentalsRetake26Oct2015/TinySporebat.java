    package javaFundamentalsRetake26Oct2015;

    import java.util.*;

    /*
     * Created by MapuH on 19-Mar-2016
     *
     * Description, solution and test can be found at:
     * https://softuni.bg/downloads/svn/java-basics/Exams/2015-10-26/Problem01-Tiny-Sporebat.zip
     */
    public class TinySporebat {

        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            String line = input.nextLine().trim();

            int health = 5800;
            int glowcaps = 0;
            boolean isDead = false;

            journey:
            while (!line.equals("Sporeggar")) {
                char[] enemies = line.substring(0, line.length()-1).toCharArray();

                for (char enemy : enemies) {
                    if (enemy == 'L') {
                        health += 200;
                    } else {
                        health -= enemy;
                    }
                    if (health <= 0) {
                        isDead = true;
                        break journey;
                    }
                }

                glowcaps += Integer.parseInt(line.substring(line.length()-1));
                line = input.nextLine().trim();
            }

            if (isDead) {
                System.out.println("Died. Glowcaps: " + glowcaps);
            } else {
                System.out.println("Health left: " + health);

                if (glowcaps >= 30) {
                    System.out.println("Bought the sporebat. Glowcaps left: " + glowcaps % 30);
                } else {
                    System.out.printf("Safe in Sporeggar, but another %d Glowcaps needed.\n", 30 - glowcaps);
                }
            }
        }
    }

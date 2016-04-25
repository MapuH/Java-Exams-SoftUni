package CSharpBasics14Apr2014Morning;

import java.util.*;

/*
 * Created by MapuH on 25-Apr-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/csharp-basics/Exams/2014-04-14-1Morning/Problem01-Fruit-Market.zip
 */
public class LongestAlphabeticalWord {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String w = input.nextLine().trim();
        int n = input.nextInt();

        char[][] block = new char[n][n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (index == w.length()) {
                    index = 0;
                }

                block[i][j] = w.charAt(index);
                index++;
            }
        }

        int longest = 0;
        List<String> words = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = block[i][j];
                String word = Character.toString(ch);

                //check right
                for (int k = j+1; k < n; k++) {
                    if (block[i][k] > ch) {
                        word += Character.toString(block[i][k]);
                        ch = block[i][k];
                    } else break;
                }

                if (word.length() >= longest) {
                    longest = word.length();
                    words.add(word);
                }

                //check left
                ch = block[i][j];
                word = Character.toString(ch);
                for (int k = j-1; k >= 0; k--) {
                    if (block[i][k] > ch) {
                        word += Character.toString(block[i][k]);
                        ch = block[i][k];
                    } else break;
                }

                if (word.length() >= longest) {
                    longest = word.length();
                    words.add(word);
                }

                //check down
                ch = block[i][j];
                word = Character.toString(ch);
                for (int k = i+1; k < n; k++) {
                    if (block[k][j] > ch) {
                        word += Character.toString(block[k][j]);
                        ch = block[k][j];
                    } else break;
                }

                if (word.length() >= longest) {
                    longest = word.length();
                    words.add(word);
                }

                // check up
                ch = block[i][j];
                word = Character.toString(ch);
                for (int k = i-1; k >= 0; k--) {
                    if (block[k][j] > ch) {
                        word += Character.toString(block[k][j]);
                        ch = block[k][j];
                    } else break;
                }

                if (word.length() >= longest) {
                    longest = word.length();
                    words.add(word);
                }
            }
        }

        List<String> longestWords = new ArrayList<>();
        for (String word : words) {
            if (word.length() == longest) {
                longestWords.add(word);
            }
        }

        Collections.sort(longestWords);
        System.out.println(longestWords.get(0));
    }
}

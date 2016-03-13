package javaBasics08Feb2015;

import java.util.*;

/**
 * Created by marin on 3/5/16.
 * <p>
 * Problem description, solutions and tests can be found at
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-02-08/Problem03-Lego-Blocks.zip
 */
public class LegoBlocks {

    private static boolean isJoinable(List<List<Integer>> arr1, List<List<Integer>> arr2) {
        boolean canJoin = true;
        int expectedSize = arr1.get(0).size() + arr2.get(0).size();
        for (int i = 1; i < arr1.size(); i++) {
            if (arr1.get(i).size() + arr2.get(i).size() != expectedSize) {
                canJoin = false;
            }
        }

        return canJoin;
    }

    private static List<Integer> joinLines(List<Integer> first, List<Integer> second) {
        List<Integer> joined = new ArrayList<>(first);
        joined.addAll(second);

        return joined;
    }

    private static int numberOfCells(List<List<Integer>> arr1, List<List<Integer>> arr2) {
        int total = 0;
        for (int i = 0; i < arr1.size(); i++) {
            total += arr1.get(i).size() + arr2.get(i).size();
        }

        return total;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();

        List<List<Integer>> array1 = new ArrayList<>(n);
        List<List<Integer>> array2 = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String[] line = input.nextLine().trim().split("\\s+");
            List<Integer> temp = new ArrayList<>();

            for (String number : line) {
                temp.add(Integer.parseInt(number));
            }

            array1.add(temp);
        }

        for (int i = 0; i < n; i++) {
            String[] line = input.nextLine().trim().split("\\s+");
            List<Integer> temp = new ArrayList<>();

            for (String digit : line) {
                temp.add(Integer.parseInt(digit));
            }

            Collections.reverse(temp);
            array2.add(temp);
        }

        if (isJoinable(array1, array2)) {
            for (int i = 0; i < n; i++) {
                System.out.println(joinLines(array1.get(i), array2.get(i)));
            }

        } else {
            System.out.println("The total number of cells is: " + numberOfCells(array1, array2));
        }

    }
}

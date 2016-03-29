package javaFundamentals13Mar2016;

import java.util.*;

/*
 * Created by MapuH on 29-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://judge.softuni.bg/Contests/Practice/DownloadResource/1200
 */
public class ChampionsLeague {

    private static String getWinner(String team1, String team2, String homeResult, String awayResult) {
        String[] home = homeResult.split(":");
        String[] away = awayResult.split(":");
        int goals1 = Integer.parseInt(home[0]) + Integer.parseInt(away[1]);
        int goals2 = Integer.parseInt(home[1]) + Integer.parseInt(away[0]);

        if (goals1 > goals2) {
            return team1;
        } else if (goals2 > goals1) {
            return team2;
        } else {
            if (Integer.parseInt(away[1]) > Integer.parseInt(home[1])) {
                return team1;
            } else {
                return team2;
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String line = input.nextLine().trim();

        Map<String, List<String>> teamsMap = new HashMap<>();
        Map<String, Integer> winsMap = new TreeMap<>();

        while (!line.equals("stop")) {
            String[] lineArgs = line.split(" \\| ");
            String team1 = lineArgs[0];
            String team2 = lineArgs[1];
            String homeResult = lineArgs[2];
            String awayResult = lineArgs[3];

            String winner = getWinner(team1, team2, homeResult, awayResult);

            if (!teamsMap.containsKey(team1)) {
                List<String> opponents = new ArrayList<>();
                opponents.add(team2);
                teamsMap.put(team1, opponents);
                winsMap.put(team1, 0);
            } else {
                List<String> opponents = teamsMap.get(team1);
                opponents.add(team2);
                teamsMap.put(team1, opponents);
            }

            if (!teamsMap.containsKey(team2)) {
                List<String> opponents = new ArrayList<>();
                opponents.add(team1);
                teamsMap.put(team2, opponents);
                winsMap.put(team2, 0);
            } else {
                List<String> opponents = teamsMap.get(team2);
                opponents.add(team1);
                teamsMap.put(team2, opponents);
            }

            for (List<String> opponents : teamsMap.values()) {
                Collections.sort(opponents);
            }

            winsMap.put(winner, winsMap.get(winner) + 1);

            line = input.nextLine().trim();
        }

        List<String> teams = new ArrayList<>();
        winsMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> teams.add(entry.getKey()));

        for (String team : teams) {
            System.out.println(team);
            System.out.println("- Wins: " + winsMap.get(team));
            System.out.println("- Opponents: " + teamsMap.get(team).toString().replaceAll("\\[|]", ""));
        }

    }
}

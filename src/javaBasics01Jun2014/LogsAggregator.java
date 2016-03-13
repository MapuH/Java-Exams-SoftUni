package javaBasics01Jun2014;

import java.util.*;

/**
 * Created by marin on 2/28/16.
 *
 * You are given a sequence of access logs in format <IP> <user> <duration>.
 * Write a program to aggregate the logs data and print for each user
 * the total duration of his sessions and a list of unique IP addresses
 * in format "<user>: <duration> [<IP1>, <IP2>, …]".
 * Order the users alphabetically. Order the IPs alphabetically.
 */
public class LogsAggregator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();

        String[] logs = new String[n];
        for (int i = 0; i < n; i++) {
            logs[i] = input.nextLine();
        }

        SortedMap<String, Integer> durationMap = new TreeMap<>();
        Map<String, SortedSet<String>> ipMap = new HashMap<>();

        for (String log : logs) {
            String[] logParts = log.split(" ");
            if (!durationMap.containsKey(logParts[1])) {
                durationMap.put(logParts[1], Integer.parseInt(logParts[2]));
            } else {
                durationMap.put(logParts[1], durationMap.get(logParts[1]) + Integer.parseInt(logParts[2]));
            }

            if (!ipMap.containsKey(logParts[1])) {
                SortedSet<String> ips = new TreeSet<>();
                ips.add(logParts[0]);
                ipMap.put(logParts[1], ips);
            } else {
                SortedSet<String> ips = ipMap.get(logParts[1]);
                ips.add(logParts[0]);
                ipMap.put(logParts[1], ips);
            }

        }

        for (String name : durationMap.keySet()) {
            System.out.printf("%s: %d %s\n", name, durationMap.get(name), ipMap.get(name));
        }

    }
}

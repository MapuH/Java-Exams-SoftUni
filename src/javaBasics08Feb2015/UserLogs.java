package javaBasics08Feb2015;

import java.util.*;

/**
 * Created by marin on 3/5/16.
 *
 * Problem description, solutions and tests can be found at
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-02-08/Problem04-User-Logs.zip
 */
public class UserLogs {

    private static String findUser(String line) {
        int start = line.indexOf("user=") + 5;
        int end = line.length();

        return line.substring(start, end);
    }

    private static String findIP(String line) {
        line = line.split("\\s+")[0];

        return line.substring(3, line.length());
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Map<String, Map<String, Integer>> nameMap = new TreeMap<>();

        while (!input.hasNext("end")) {
            String line = input.nextLine();
            String user = findUser(line);
            String ip = findIP(line);

            if (!nameMap.containsKey(user)) {
                Map<String, Integer> ipMap = new LinkedHashMap<>();
                ipMap.put(ip, 1);
                nameMap.put(user, ipMap);

            } else {
                Map<String, Integer> ipMap = nameMap.get(user);
                if (!ipMap.containsKey(ip)) {
                    ipMap.put(ip, 1);
                } else {
                    ipMap.put(ip, ipMap.get(ip)+1);
                }

                nameMap.put(user, ipMap);
            }

        }

        for (Map.Entry entry : nameMap.entrySet()) {
            System.out.printf("%s:\n", entry.getKey());
            String ipList = entry.getValue().toString().replaceAll("\\{|\\}", "").replaceAll("=", " => ");
            System.out.println(ipList + ".");
        }

    }
}

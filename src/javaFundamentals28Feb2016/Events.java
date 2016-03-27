package javaFundamentals28Feb2016;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Created by MapuH on 26-Mar-2016
 *
 * Description can be found at:
 * https://judge.softuni.bg/Contests/Practice/DownloadResource/1181
 */
public class Events {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        Map<String, Map<String, List<String>>> eventMap = new HashMap<>();

        Pattern pattern = Pattern.compile("^(#[a-zA-Z]+:)\\s*(@[a-zA-Z]+)\\s*((?:[01]?\\d|2[0-3]):[0-5]\\d)$");
        for (int i = 0; i < n; i++) {
            String line = input.nextLine().trim();
            Matcher match = pattern.matcher(line);
            while (match.find()) {
                String person = match.group(1);
                String location = match.group(2);
                String hour = match.group(3);

                person = person.substring(1, person.length()-1);
                location = location.substring(1);

                if (!eventMap.containsKey(location)) {
                    List<String> times = new ArrayList<>();
                    times.add(hour);
                    Map<String, List<String>> nameMap = new TreeMap<>();
                    nameMap.put(person, times);
                    eventMap.put(location, nameMap);

                } else {
                    Map<String, List<String>> nameMap = eventMap.get(location);
                    if (!nameMap.containsKey(person)) {
                        List<String> times = new ArrayList<>();
                        times.add(hour);
                        nameMap.put(person, times);
                    } else {
                        List<String> times = nameMap.get(person);
                        times.add(hour);
                        Collections.sort(times);
                        nameMap.put(person, times);
                    }

                    eventMap.put(location, nameMap);
                }

            }
        }

        String[] locations = input.nextLine().split(",");
        Arrays.sort(locations);

        for (String location : locations) {
            if (!eventMap.containsKey(location)) {
                continue;
            }

            System.out.println(location + ":");

            int number = 1;
            for (Map.Entry<String, List<String>> nameEntry : eventMap.get(location).entrySet()) {
                String times = nameEntry.getValue().toString();
                System.out.printf("%d. %s -> %s\n", number, nameEntry.getKey(), times.substring(1, times.length()-1));
                number++;
            }
        }

    }
}

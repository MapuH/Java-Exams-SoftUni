package javaFundamentals15Nov2015;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Created by MapuH on 23-Mar-2016
 *
 * Description, solution and test can be found at:
 * https://softuni.bg/downloads/svn/java-basics/Exams/2015-11-15/Problem04-Log-Parser.zip
 */
public class LogParser {

    private static void sortErrList(List<String> errList) {
        Collections.sort(errList);
        errList.sort((s1, s2) -> s1.length() - s2.length());
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String line = input.nextLine();

        Map<String, Map<String, List<String>>> projectMap = new TreeMap<>();
        Map<String, Integer> errNumberMap = new TreeMap<>();

        Pattern pattern = Pattern.compile("\\[\".*?\"]");

        while (!line.equals("END")) {
            List<String> errorArgs = new ArrayList<>(3);
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String arg = matcher.group(0);
                errorArgs.add(arg.substring(2, arg.length()-2));
            }

            String project = errorArgs.get(0);
            String errorType = errorArgs.get(1);
            String errorMsg = errorArgs.get(2);

            if (!projectMap.containsKey(project)) {
                Map<String, List<String>> errorMap = new TreeMap<>();
                List<String> errorList = new ArrayList<>();
                errorList.add(errorMsg);
                errorMap.put(errorType, errorList);
                projectMap.put(project, errorMap);
                errNumberMap.put(project, 1);

            } else {
                Map<String, List<String>> errorMap = projectMap.get(project);
                if (!errorMap.containsKey(errorType)) {
                    List<String> errorList = new ArrayList<>();
                    errorList.add(errorMsg);
                    errorMap.put(errorType, errorList);
                } else {
                    List<String> errorList = errorMap.get(errorType);
                    errorList.add(errorMsg);
                    sortErrList(errorList);
                    errorMap.put(errorType, errorList);
                }

                projectMap.put(project, errorMap);
                errNumberMap.put(project, errNumberMap.get(project) + 1);
            }

            line = input.nextLine();
        }

        List<String> projects = new ArrayList<>();
        errNumberMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry ->projects.add(entry.getKey()));

        for (String project : projects) {
            int totalErrors = errNumberMap.get(project);
            int critical = 0;
            int warnings = 0;
            if (projectMap.get(project).containsKey("Critical")) {
                critical = projectMap.get(project).get("Critical").size();
            }
            if (projectMap.get(project).containsKey("Warning")) {
                warnings = projectMap.get(project).get("Warning").size();
            }

            System.out.println(project+":");
            System.out.println("Total Errors: " + totalErrors);
            System.out.println("Critical: " + critical);
            System.out.println("Warnings: " + warnings);

            System.out.println("Critical Messages:");
            if (critical > 0) {
                for (String msg : projectMap.get(project).get("Critical")) {
                    System.out.println("--->" + msg);
                }
            } else {
                System.out.println("--->None");
            }

            System.out.println("Warning Messages:");
            if (warnings > 0) {
                for (String msg : projectMap.get(project).get("Warning")) {
                    System.out.println("--->" + msg);
                }
            } else {
                System.out.println("--->None");
            }

            System.out.println();
        }

    }
}

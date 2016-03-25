package javaFundamentals28Feb2016;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Created by MapuH on 25-Mar-2016
 *
 * Description can be found at:
 * https://judge.softuni.bg/Contests/Practice/DownloadResource/1180
 */
public class SoftuniNumerals {

    private static final Map<String, String> NUM_VALUES;
    static {
        Map<String, String> numberMap = new HashMap<>();
        numberMap.put("aa", "0");
        numberMap.put("aba", "1");
        numberMap.put("bcc", "2");
        numberMap.put("cc", "3");
        numberMap.put("cdc", "4");
        NUM_VALUES = Collections.unmodifiableMap(numberMap);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String numeral = input.nextLine().trim();
        String base5 = "";

        Pattern pattern = Pattern.compile("aa|aba|bcc|cc|cdc");
        Matcher matcher = pattern.matcher(numeral);
        while (matcher.find()) {
            base5 += NUM_VALUES.get(matcher.group(0));
        }

        BigInteger x = new BigInteger(base5, 5);
        System.out.println(x);
    }
}

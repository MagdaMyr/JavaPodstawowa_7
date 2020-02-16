package pl.sda.javawwa30;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExUtil {

    public static void printRegexResults(String regexStr, String testStr) {
        Pattern regex = Pattern.compile(regexStr);
        Matcher matcher = regex.matcher(testStr);

        while(matcher.find()) {
            if(matcher.group().length() != 0){
                System.out.println(matcher.group().trim());
            }

            System.out.println("Start index: " + matcher.start());
            System.out.println("End index: " + matcher.end());
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
    }

}
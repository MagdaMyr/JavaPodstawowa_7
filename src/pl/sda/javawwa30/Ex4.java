package pl.sda.javawwa30;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex4 {

    public static void main(String[] args) {
        String html = getText("examplewww.txt");

        //RegEx: email
        //RegEx: telefon polski - examples: +48 58 551 22 89,  + 48 602 593 826

        String phoneRegEx = "(\\+ |\\+)\\d{2}( |)(\\d{2} \\d{3} \\d{2} \\d{2}|\\d{3} \\d{3} \\d{3})";
        RegExUtil.printRegexResults(phoneRegEx, html);
        //+ num typu yyy yyy yyy: ((\+ |\+)\d{2}( |))?(\d{2} \d{3} \d{2} \d{2}|\d{3} \d{3} \d{3})
        //(\+| \+ )48( |)?[0-9 ]{5,16} - wykorzystuje znaki od 0 do 9 i ' ' w dowolnej kombinacji od 5 do 16 razy
    }

    public static String getText(String path) {
        String text = "";

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            text = sb.toString();
        }
        catch(IOException ex) {
            System.out.println("Could not load file due to IOException: " + ex);
        }

        return text;
    }

}

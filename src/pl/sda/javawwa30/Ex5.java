package pl.sda.javawwa30;

public class Ex5 {

    public static void main(String[] args) {
        final String txt = "Jan Kowalski, ur. 20.02.1987 r., zam. ul. Jutrzenki 105, 02-716 Warszawa, odwiedził stany: CA i AL, e-mail: janekk87@gmail.com, kom.: (+48) 789-215-618, hobby: kung fu, wieprzowina, Xiaomi";

        final String email = "";
        RegExUtil.printRegexResults(email, txt);

        final String postalCode = "";
        RegExUtil.printRegexResults(postalCode, txt);

        final String hobby = "";
        RegExUtil.printRegexResults(hobby, txt);

        final String states = "";
        RegExUtil.printRegexResults(states, txt);

    }

}

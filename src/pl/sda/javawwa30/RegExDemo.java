package pl.sda.javawwa30;

public class RegExDemo {

    public static void main(String[] args) {
        final String exampleText1 = "Bring your code to the conversations you care about with the GitHub and Slack app. With two of your most important workspaces connected, you’ll get updates about what’s happening on GitHub—without leaving Slack.";

        //dopasowanie 1 do 1
        RegExUtil.printRegexResults("GitHub", exampleText1);

        //slowa o dlugosci od 5 do 7 + dopasowanie 'spacja' z przodu i z tylu
        RegExUtil.printRegexResults(" [A-Za-z]{5,7} ", exampleText1);

        //wszystkie biale znaki
        RegExUtil.printRegexResults("\\s", exampleText1);

        //wszystkie slowa RegExem (lepsze rozwiazanie to po prostu String.split(" ");
        RegExUtil.printRegexResults(" \\w{1,40} ", exampleText1);
    }

}

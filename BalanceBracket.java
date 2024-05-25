import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please bracket :");
        String inputString = scanner.nextLine();

        inputString = inputString.replace(" ", "");

        if ((inputString.length() % 2) == 1) {
            System.out.println("NO");
        } else {
            System.out.println(checkBracket(inputString));
        }



    }



    public static String checkBracket(String input) {
        Pattern pattern = Pattern.compile("[\\[\\]{}()]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        int totalMatch = (int) matcher.results().count();
        if (totalMatch == input.length()) return "YES"; else return "NO";
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input number :");
        String inputString = scanner.nextLine();

        System.out.println("Please input number replacement");
        String replacement = scanner.nextLine();

        String resultHighPalindrome = getHighestPalindrom(inputString, Integer.parseInt(replacement));

        if (resultHighPalindrome.contains("-")) {
            System.out.println("-1");
        } else if (checkPalindrom(resultHighPalindrome)){
            System.out.println(resultHighPalindrome);
        } else {
            System.out.println("-1");
        }

    }

    public static String getHighestPalindrom(String input, int replacement) {
        return getHighestPalindrom(0, input.length() - 1, input, replacement);
    }

    public static String getHighestPalindrom(int indexLow, int indexHigh, String input, int replacement) {

        if(indexLow >= indexHigh) {
            return input;
        }

        char charLow = input.charAt(indexLow);
        char charHigh = input.charAt(indexHigh);

        if (charLow != charHigh) {
            if (!Character.isDigit(charLow) || !Character.isDigit(charHigh)) {
                input = input.concat("-");
            } else if (replacement != 0) {
                int intLow = (int) charLow - 48;
                int intHigh = (int) charHigh - 48;
                String[] arrString = input.split("");
                if (replacement >= 2) {
                    arrString[indexLow] = "9";
                    arrString[indexHigh] = "9";
                    replacement = replacement - 2;
                } else if (intLow > intHigh) {
                    arrString[indexHigh] = String.valueOf(intLow);
                    replacement--;
                } else {
                    arrString[indexLow] = String.valueOf(intHigh);
                    replacement--;
                }
                input = Arrays.toString(arrString);
                input = cleanString(input);
            }
        } else {
            int intLow = (int) charLow - 48;
            if (intLow < 9) {
                if (replacement >= 2) {
                    String[] arrString = input.split("");
                    arrString[indexLow] = "9";
                    arrString[indexHigh] = "9";
                    replacement = replacement - 2;
                    input = Arrays.toString(arrString);
                    input = cleanString(input);
                }
            }
            
        }

        return getHighestPalindrom(indexLow + 1, indexHigh - 1, input, replacement);
    }

    public static boolean checkPalindrom(String input) {
        return checkPalindrom(0, input.length() -1, input);
    }

    public static boolean checkPalindrom(int indexLow, int indexHigh, String input) {
        if (indexLow >= indexHigh) {
            return true;
        }

        // comparing the characters on those pointers
        if (input.charAt(indexLow) != input.charAt(indexHigh)) {
            return false;
        }

        // checking everything again recursively
        return checkPalindrom(indexLow + 1, indexHigh - 1, input);
    }

    public static String cleanString (String input) {
        input = input.replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
        return input;
    }

}
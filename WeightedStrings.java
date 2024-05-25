import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        weightedStrings();

    }

    public static void weightedStrings() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input a string :");
        String sInput = scanner.nextLine();
        System.out.println("Plase input a query");
        String querys = scanner.nextLine();

        //prepare data
        sInput = sInput.replace(" ", "");
        char[] arrCInput = sInput.toCharArray();
        querys = querys.replace("[", "").replace("]", "").replace(" ", "");

        // mapping querys
        String[] arrQuerys = querys.split(",");
        Map<Integer, String> mapResult = new LinkedHashMap<>();

        for (String arrQuery : arrQuerys) {
            mapResult.put(Integer.parseInt(arrQuery), "No");
        }

        List<Integer> listNumber = new ArrayList<>();

        char prevChar = '-';
        int countDuplicateChar = 1;
        //processing data
        for (char cInput : arrCInput) {
            int vChar = (int) cInput - 96;
            if (cInput != prevChar) {
                listNumber.add(vChar);
                countDuplicateChar = 1;
                prevChar = cInput;
            } else {
                countDuplicateChar++;
                listNumber.add(vChar * countDuplicateChar);
            }
        }

        //mapping value to map
        for (Integer numberValue : listNumber) {
            if (mapResult.containsKey(numberValue)) {
                mapResult.put(numberValue, "Yes");
            }
        }

        List<String> listResult = new ArrayList<>(mapResult.values());

        System.out.println(listResult);
    }

    
}
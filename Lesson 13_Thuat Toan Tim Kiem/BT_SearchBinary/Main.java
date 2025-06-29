import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        LinkedList<Character> maxSubstring = new LinkedList<>();
        LinkedList<Character> currentSubstring = new LinkedList<>();

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);

            if (currentSubstring.isEmpty() || currentChar > currentSubstring.getLast()) {
                currentSubstring.add(currentChar);
            } else {
                currentSubstring.clear();
                currentSubstring.add(currentChar);
            }

            if (currentSubstring.size() > maxSubstring.size()) {
                maxSubstring.clear();
                maxSubstring.addAll(currentSubstring);
            }
        }


        StringBuilder resultBuilder = new StringBuilder();
        for (Character c : maxSubstring) {
            resultBuilder.append(c);
        }

        System.out.println(resultBuilder.toString());

        scanner.close();
    }
}
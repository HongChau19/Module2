import java.util.Scanner;

public class NumberToWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên không âm (tối đa 3 chữ số): ");
        int number = scanner.nextInt();

        if (number < 0 || number > 999) {
            System.out.println("out of ability");
        } else {
            System.out.println(convertToWords(number));
        }
        scanner.close();
    }

    public static String convertToWords(int number) {
        if (number == 0) {
            return "zero";
        }

        String words = "";

        // Xử lý hàng trăm
        if (number >= 100) {
            int hundreds = number / 100;
            words += getHundreds(hundreds) + " hundred";
            number %= 100;

            if (number > 0) {
                words += " and ";
            }
        }

        // Xử lý hàng chục và hàng đơn vị
        if (number >= 20) {
            int tens = number / 10;
            int ones = number % 10;
            words += getTens(tens);
            if (ones > 0) {
                words += " " + getOnes(ones);
            }
        } else if (number >= 10) {
            words += getTeens(number);
        } else if (number > 0) {
            words += getOnes(number);
        }

        return words.trim();
    }

    public static String getHundreds(int number) {
        switch (number) {
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return "";
        }
    }

    public static String getTens(int number) {
        switch (number) {
            case 2: return "twenty";
            case 3: return "thirty";
            case 4: return "forty";
            case 5: return "fifty";
            case 6: return "sixty";
            case 7: return "seventy";
            case 8: return "eighty";
            case 9: return "ninety";
            default: return "";
        }
    }

    public static String getTeens(int number) {
        switch (number) {
            case 10: return "ten";
            case 11: return "eleven";
            case 12: return "twelve";
            case 13: return "thirteen";
            case 14: return "fourteen";
            case 15: return "fifteen";
            case 16: return "sixteen";
            case 17: return "seventeen";
            case 18: return "eighteen";
            case 19: return "nineteen";
            default: return "";
        }
    }

    public static String getOnes(int number) {
        switch (number) {
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return "";
        }
    }
}

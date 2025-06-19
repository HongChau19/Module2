public class LongestIncreasingSubstring {

    public static String findLongestIncreasingSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String longestSubstring = "";
        StringBuilder currentSubstring = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentSubstring.length() == 0 || currentChar >= currentSubstring.charAt(currentSubstring.length() - 1)) {
                currentSubstring.append(currentChar);
            } else {
                if (currentSubstring.length() > longestSubstring.length()) {
                    longestSubstring = currentSubstring.toString();
                }
                currentSubstring = new StringBuilder();
                currentSubstring.append(currentChar);
            }
        }

        if (currentSubstring.length() > longestSubstring.length()) {
            longestSubstring = currentSubstring.toString();
        }

        return longestSubstring;
    }
}
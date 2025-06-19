public class IncreasingSubStringChecker {
    public static boolean isIncreasingSubString(String str) {
        if (str == null || str.length() <=1){
            return true;
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) <=str. charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}

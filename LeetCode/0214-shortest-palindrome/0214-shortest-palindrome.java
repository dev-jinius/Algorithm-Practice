import java.lang.StringBuilder;

class Solution {
    public String shortestPalindrome(String s) {
        String reverseStr = new StringBuilder(s).reverse().toString();

        for (int i = 0; i < reverseStr.length(); ++i)
            if (s.startsWith(reverseStr.substring(i)))
                return reverseStr.substring(0, i) + s;

        return reverseStr + s;
    }
}
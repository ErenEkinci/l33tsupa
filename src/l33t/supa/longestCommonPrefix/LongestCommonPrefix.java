package l33t.supa.longestCommonPrefix;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"a","a","b"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        String prefix = commonPrefix(strs[0], strs[1]);

        for (int i = 1; i < strs.length && prefix.length() > 0; i++) {
            prefix = commonPrefix(prefix, strs[i]);
        }

        return prefix;
    }

    private static String commonPrefix(String s1, String s2){
        int i = 0;
        while (i < Math.min(s1.length(), s2.length()) && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return s1.substring(0,i);
    }
}

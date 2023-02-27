package l33t.supa.strings;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    public static void main(String[] args) {
        String str = "3[a2[c]]";
        decodeString(str);
    }
    public static String decodeString(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<String> stackStr = new ArrayDeque<>();


        String[] str = s.split("");

        int i = 0;
        boolean number = false;

        return "";
    }
}

package l33t.supa.lastword;

import java.util.Arrays;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        Arrays.stream(words).iterator().forEachRemaining(System.out::println);
        return words[words.length-1].length();
    }
}

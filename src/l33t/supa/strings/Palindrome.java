package l33t.supa.strings;

public class Palindrome {
    public static void main(String[] args) {
        String s = "panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s){
        s = s.replaceAll("\\s", "");
        s = s.toLowerCase();

        return true;
    }
}

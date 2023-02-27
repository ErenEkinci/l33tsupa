package l33t.supa.romanToInteger;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        String roman = "III";
        System.out.println(roman + " => " + getIntFromRoman(roman));
    }
    public static int getIntFromRoman(String s){
        int prev=1001, cur, sum=0;
        for (int i = 0; i < s.length(); i++) {
            cur = switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };
            sum += cur;
            if(prev < cur){
                sum -= prev*2;
            }
            prev = cur;
        }

        return sum;
    }
}

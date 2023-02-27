package l33t.supa.romanToInteger;

import java.util.*;

public class IntegerToRoman {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        Map<Integer, String[]> romans = new HashMap<>();
        romans.put(0, new String[]{"", "", "", ""});
        romans.put(1, new String[]{"I", "X", "C", "M"});
        romans.put(2, new String[]{"II", "XX", "CC", "MM"});
        romans.put(3, new String[]{"III", "XXX", "CCC", "MMM"});
        romans.put(4,new String[]{"IV", "XL", "CD"});
        romans.put(5,new String[]{"V", "L", "D"});
        romans.put(6,new String[]{"VI", "LX", "DC"});
        romans.put(7,new String[]{"VII", "LXX", "DCC"});
        romans.put(8,new String[]{"VIII", "LXXX", "DCCC"});
        romans.put(9,new String[]{"IX", "XC", "CM"});

        Deque<String> roman = new ArrayDeque<>();
        int c=0;
        while(num > 0){
            roman.addFirst(romans.get(num%10)[c++]);
            num /= 10;
        }

        StringBuilder sb = new StringBuilder();
        while (!roman.isEmpty()){
            sb.append(roman.pollFirst());
        }

        return sb.toString();

    }
}

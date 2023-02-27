package l33t.supa.strings;

import java.util.*;

public class ConvertToTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle2(2147483647));
    }

    public static String convertToTitle2(int columnNumber) {

        char[] baseVals = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        Stack<Character> title = new Stack<>();

        int base = 26;

        while (columnNumber > 0){
            int rem = columnNumber % base;
            if(rem != 0) {
                title.add(baseVals[rem-1]);
                columnNumber = columnNumber / base;
            } else {
                title.add(baseVals[base-1]);
                columnNumber = columnNumber / base;
                columnNumber--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!title.isEmpty())
            sb.append(title.pop());

        return sb.toString();
    }

    public static String convertToTitle(int columnNumber) {
        Map<Integer, Character> baseVals = new HashMap<>(26);
        baseVals.put(1, 'A');baseVals.put(2, 'B');baseVals.put(3, 'C');baseVals.put(4, 'D');baseVals.put(5, 'E');
        baseVals.put(6, 'F');baseVals.put(7, 'G');baseVals.put(8, 'H');baseVals.put(9, 'I');baseVals.put(10, 'J');
        baseVals.put(11, 'K');baseVals.put(12, 'L');baseVals.put(13, 'M');baseVals.put(14, 'N');baseVals.put(15, 'O');
        baseVals.put(16, 'P');baseVals.put(17, 'Q');baseVals.put(18, 'R');baseVals.put(19, 'S');baseVals.put(20, 'T');
        baseVals.put(21, 'U');baseVals.put(22, 'V');baseVals.put(23, 'W');baseVals.put(24, 'X');baseVals.put(25, 'Y');
        baseVals.put(26, 'Z');

        Stack<Character> title = new Stack<>();

        int base = baseVals.size();

        while (columnNumber > 0){
            int rem = columnNumber % base;
            if(rem != 0) {
                title.add(baseVals.get(rem));
                columnNumber = columnNumber / base;
            } else {
                title.add(baseVals.get(base));
                columnNumber = columnNumber / base;
                columnNumber--;
            }
        }

        title.add(baseVals.get(columnNumber));

        StringBuilder sb = new StringBuilder();
        while (!title.isEmpty()){
            sb.append(title.pop());
        }
        return sb.toString();
    }
}

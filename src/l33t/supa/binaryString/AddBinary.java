package l33t.supa.binaryString;

import java.util.Stack;

public class AddBinary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a,b));
    }

    public static String addBinary(String a, String b) {
        int r = 1;

        int l = Math.max(a.length(),b.length())+1;
        char[] result = new char[l];

        boolean carry = false;

        while (a.length()-r >= 0 && b.length()-r >= 0) {
            if(a.charAt(a.length()-r) == '1' && b.charAt(b.length()-r) == '1'){
                if(carry){
                    result[l-r] = '1';
                }else{
                    result[l-r] = '0';
                }
                carry = true;
            } else if(a.charAt(a.length()-r) == '0' && b.charAt(b.length()-r) == '0'){
                if(carry){
                    result[l-r] = '1';
                }else{
                    result[l-r] = '0';
                }
                carry = false;
            } else {
                if(carry){
                    result[l-r] = '0';
                }else{
                    result[l-r] = '1';
                }
            }
            r++;
        }

        while(a.length()-r >= 0){
            if(a.charAt(a.length()-r) == '0'){
                if(carry){
                    result[l-r] = '1';
                }else{
                    result[l-r] = '0';
                }
                carry = false;
            } else {
                if(carry){
                    result[l-r] = '0';
                }else{
                    result[l-r] = '1';
                }
            }
            r++;
        }

        while(b.length()-r >= 0){
            if(b.charAt(b.length()-r) == '0'){
                if(carry){
                    result[l-r] = '1';
                }else{
                    result[l-r] = '0';
                }
                carry = false;
            } else {
                if(carry){
                    result[l-r] = '0';
                }else{
                    result[l-r] = '1';
                }
            }
            r++;
        }

        if(carry){
            result[0] = '1';
            return String.copyValueOf(result);
        }else{
            return String.copyValueOf(result, 1, result.length-1);
        }
    }
}

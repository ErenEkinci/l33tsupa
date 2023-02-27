package l33t.supa.plusOne;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{5555};
        int[] plus = plusOne(digits);
        for (int j : plus) {
            System.out.print(j);
        }
    }

    public static int[] plusOne(int[] digits) {
        int i = digits.length-1;

        while(i > -1 && digits[i] == 9){
            digits[i] = 0;
            i--;
        }

        if(i > -1){
            digits[i] = digits[i]+1;
            return digits;
        }else{
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }
    }
}

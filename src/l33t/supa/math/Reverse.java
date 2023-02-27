package l33t.supa.math;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
        int x = -2147483648;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        boolean neg = false;
        if(x < 0){
            x *= -1;
            if(x<0) return 0;
            neg = true;
        }
        Deque<Short> stack = new ArrayDeque<>();
        while (x > 9) {
            short rem = (short) (x % 10);
            x /= 10;
            stack.addFirst(rem);
        }

        int i = 10;
        while(!stack.isEmpty()){
            short dig = stack.removeFirst();
            if (dig != 0 && i > Integer.MAX_VALUE / dig) return 0;
            x += i * dig;
            i *= 10;
            if (x < 0) return 0;
        }

        return neg ? -x : x;
    }
}

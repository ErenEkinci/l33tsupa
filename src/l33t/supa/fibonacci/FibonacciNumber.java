package l33t.supa.fibonacci;

public class FibonacciNumber {
    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.println(fib(i));
        }
    }

    public static int fib(int n) {
        int pprev = 0;
        int prev = 1;
        if(n == 0 || n == 1) return n;

        int res = 1;
        for (int i = 2; i < n+1; i++) {
            res = pprev + prev;
            pprev = prev;
            prev = res;
        }
        return res;
    }
}

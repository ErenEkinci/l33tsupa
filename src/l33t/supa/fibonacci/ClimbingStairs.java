package l33t.supa.fibonacci;

public class ClimbingStairs {
    public static void main(String[] args) {
        for (int i = 1; i < 15; i++) {
            System.out.println(climbStairs(i));
        }
    }

    public static int climbStairs(int n) {
        int pprev = 1;
        int prev = 2;
        if(n == 1 || n == 2) return n;

        int res = 3;
        for (int i = 3; i < n+1; i++) {
            res = pprev + prev;
            pprev = prev;
            prev = res;
        }
        return res;
    }
}

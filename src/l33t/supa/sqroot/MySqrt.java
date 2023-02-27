package l33t.supa.sqroot;

public class MySqrt {
    public static void main(String[] args) {
        int thrty = 1024*1024*1024;
        int x = thrty -1 + thrty;
        System.out.println(x + "   -   " +mySqrt(x));
        System.out.println(x + "   -   " +Math.pow(x,0.5));
    }

    public static int mySqrt(int x) {
        int start = 0;
        int end = 32*32*32*2;
        int c;
        long sq;

        while (end - start > 1){
            c = (start + end) /2;
            sq = (long) c * c;
            if(sq > x){
                end = c;
            }else if (sq < x){
                start = c;
            }else{
                return c;
            }
        }

        return start*start > x ? start+1 : start;

    }
}

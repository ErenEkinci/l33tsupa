package l33t.supa.arraySearch;

public class Stonks {
    public static void main(String[] args) {
        int[] prices = new int[]{3,4,5,6,4,12,4,6,123,34,6,1,234,5,6,7,23,35,64,23,4,45,65,6,7,8,5,44,5,5,6,11,2,312,54,3,2,34,4,4,444,56};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices){
        int min = prices[0];
        int max = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            if (price < min) {
                min = price;
                max = price;
            } else if (price > max) {
                max = price;
                if (max - min > maxProfit) {
                    maxProfit = max - min;
                }
            }
        }
        return maxProfit;
    }
}

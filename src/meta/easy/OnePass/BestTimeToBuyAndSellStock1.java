package meta.easy.OnePass;

public class BestTimeToBuyAndSellStock1 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int index = 0; index < prices.length; index++) {
            minPrice = Math.min(minPrice, prices[index]);
            maxProfit = Math.max(maxProfit, prices[index] - minPrice);
        }
        return maxProfit;
    }

/*    Time and Space Complexity
    Complexity	Value
    Time	O(n) — one pass through the array
    Space	O(1) — constant space*/
}

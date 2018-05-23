
public class Best_Time_to_Buy_and_Sell_Stock_121 {
    
    //Time: O(n)
    //Space: O(1)
    public int maxProfit(int[] prices) {   
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
            // max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    //Kadane's Algorithm
    //Time: O(n)
    //Space: O(1)
    public int maxProfit2(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(new Best_Time_to_Buy_and_Sell_Stock_121()
                .maxProfit(new int[] { 1, -1, 2 }));
        System.out.println(new Best_Time_to_Buy_and_Sell_Stock_121()
                .maxProfit2(new int[] { 1, -1, 2 }));
        System.out.println(new Best_Time_to_Buy_and_Sell_Stock_121()
                .maxProfit(new int[] { 11, 1, 3, 22 }));

    }

}

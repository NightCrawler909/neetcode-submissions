class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int finalval = 0;

        for(int j = 1; j < prices.length ; j++){
            if(prices[j] > prices[i]){
                int val = prices[j] - prices[i];
                finalval = Math.max(finalval,val);
            }
            else{
                i = j;
            }
        }

        return finalval;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int maxValue = 0;

        for(int j = 1; j < prices.length; j++){   
            if(prices[j] > prices[i]){
                int value = prices[j] - prices[i];
                maxValue = Math.max(value,maxValue);
            }else{
                i = j;
            }

        }

        return maxValue;
    }
}

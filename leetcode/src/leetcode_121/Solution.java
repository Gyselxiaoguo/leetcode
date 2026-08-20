package leetcode_121;


class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        int minBuy=Integer.MAX_VALUE;   //买入价格
        int globalMaxProfit=0; //最大利润
        for(int i=0;i<prices.length;i++){
            int curSell=prices[i];
            minBuy=Math.min(minBuy,curSell);
            int curMaxProfit=curSell-minBuy;
            globalMaxProfit=Math.max(curMaxProfit,globalMaxProfit);
        }
        return globalMaxProfit;
    }
}
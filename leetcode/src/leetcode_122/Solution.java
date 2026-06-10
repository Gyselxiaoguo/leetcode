package leetcode_122;

class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit=0;
        int l=0;
        int r=1;
        while (r<prices.length){
            if(prices[r]>prices[l]){    //今天的股票价格<昨天的股票价格
                totalProfit+=prices[r]-prices[l];
            }
            r++;
            l++;
        }
        return totalProfit;
    }
}
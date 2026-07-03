package leetcode_121;

class Solution {
    /*贪心算法：遍历过程中，局部最优推全局最优*/
    public int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        int maxprofit=0;    //最大利润
        int buy=prices[0];  //买入价格
        int curprofit=0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<buy){  //更新买入的较小值
                buy=prices[i];
            }
            curprofit=prices[i]-buy;
            maxprofit=Math.max(curprofit,maxprofit);
        }
        return maxprofit;
    }
}


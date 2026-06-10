package leetcode_121;

class Solution {
    /*贪心算法：遍历过程中，局部最优推全局最优*/
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int day=1;  //第几天买入
        int buyPrice=prices[0];   //买入价格
        int maxProfit=0;    //最大利润

        while (day<prices.length){
            buyPrice=Math.min(prices[day-1],buyPrice);
            int profit=prices[day]-buyPrice;
            maxProfit=Math.max(maxProfit,profit);
            day++;
        }
        return maxProfit;
    }
}
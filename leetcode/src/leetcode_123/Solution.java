package leetcode_123;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 左数组，右数组，找左右数组相加的最大值
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if(prices==null|| n <=1){ //仅有1个或0个元素
            return 0;
        }

        int[] lMaxProfit=new int[n];    //第一次交易：0 ~ i，最大利润
        int[] rMaxProfit=new int[n];    //第二次交易：i ~ n,最大利润

        int minBuy=prices[0];
        lMaxProfit[0]=0;
        for(int i=1;i<n;i++){   //第一次交易：0 ~ i，lProfit[i] = 从第 0 天到第 i 天，只做 1 次交易能获得的最大利润
            int curProfit=prices[i]-minBuy;
            lMaxProfit[i]=Math.max(lMaxProfit[i-1],curProfit);
            minBuy=Math.min(minBuy,prices[i]);
        }
        System.out.println(Arrays.toString(lMaxProfit));

        int maxSell=prices[n-1];
        rMaxProfit[n-1]=0;
        for(int i=n-2;i>=0;i--){    // rProfit[i] = 从第 i 天到最后一天，只做 1 次交易能获得的最大利润
            int curProfit=maxSell-prices[i];
            rMaxProfit[i]=Math.max(rMaxProfit[i+1],curProfit);
            maxSell=Math.max(maxSell,prices[i]);
        }
        System.out.println(Arrays.toString(rMaxProfit));

        int res=0;
        for(int i=0;i<n;i++){
            res=Math.max(res,lMaxProfit[i]+rMaxProfit[i]);  //买卖两次的最大利润
        }
        return res;
    }

}
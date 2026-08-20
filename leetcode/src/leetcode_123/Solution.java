package leetcode_123;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 左数组，右数组，找左右数组相加的最大值
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 4, 6}));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if(prices==null|| n <=1){ //仅有1个或0个元素
            return 0;
        }

        int[] lMaxProfit=new int[n];
        int[] rMaxProfit=new int[n];

        int lMinBuy=Integer.MAX_VALUE;
        int lGlobalMaxProfit=0;
        for(int i=0;i<n;i++){   //第一次交易：0 ~ i，lProfit[i] = 从第 0 天到第 i 天，只做 1 次交易能获得的最大利润
            int curSell=prices[i];
            lMinBuy=Math.min(lMinBuy,curSell);
            int curProfit=curSell-lMinBuy;
            lGlobalMaxProfit=Math.max(lGlobalMaxProfit,curProfit);
            lMaxProfit[i]=lGlobalMaxProfit;
        }
        System.out.println(Arrays.toString(lMaxProfit));

        int rMaxSell=0;
        int rGlobalMaxProfit=0;
        for(int i=n-1;i>=0;i--){    // rProfit[i] = 从第 i 天到最后一天，只做 1 次交易能获得的最大利润
            int curbuy=prices[i];
            rMaxSell=Math.max(rMaxSell,curbuy);
            int curProfit=rMaxSell-curbuy;
            rGlobalMaxProfit=Math.max(rGlobalMaxProfit,curProfit);
            rMaxProfit[i]=rGlobalMaxProfit;
        }
        System.out.println(Arrays.toString(rMaxProfit));

        int res=0;
        for(int i=0;i<n;i++){
            res=Math.max(res,lMaxProfit[i]+rMaxProfit[i]);  //买卖两次的最大利润
        }
        return res;
    }

}
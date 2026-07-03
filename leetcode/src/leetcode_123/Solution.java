package leetcode_123;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 左数组，右数组，找左右数组相加的最大值
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(prices==null|| n <=1){ //仅有1个或0个元素
            return 0;
        }
        if(IntStream.range(1, n).allMatch(i->prices[i]<=prices[i-1])){ //降序排序
            return 0;
        }

        int[] lProfit=new int[n];
        int[] rProfit=new int[n];

        int buy=prices[0];
        int maxProfit=0;
        int curProfit=0;
        for (int i = 0; i < n; i++) {   //第一次交易：0 ~ i，lProfit[i] = 从第 0 天到第 i 天，只做 1 次交易能获得的最大利润
            buy=Math.min(prices[i],buy);
            curProfit=prices[i]-buy;
            maxProfit=Math.max(maxProfit,curProfit);
            lProfit[i]=maxProfit;
        }
        System.out.println(Arrays.toString(lProfit));

        buy=prices[n-1];
        maxProfit=0;
        for (int i = n-1; i >=0; i--) {  //rProfit[i] = 从第 i 天到最后一天，只做 1 次交易能获得的最大利润
            buy=Math.max(buy,prices[i]);
            curProfit=buy-prices[i];
            maxProfit=Math.max(curProfit,maxProfit);
            rProfit[i]=maxProfit;
        }
        System.out.println(Arrays.toString(rProfit));

        int res=0;
        for (int i = 0; i < n; i++) {
            res=Math.max(res,lProfit[i]+rProfit[i]);    //买卖两次的最大利润
        }
        return res;
    }
}
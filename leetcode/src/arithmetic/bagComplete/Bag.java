package arithmetic.bagComplete;

import java.util.Arrays;

public class Bag {
    public static void main(String[] args) {
        int[] weight=new int[]{1,3,4};  //物品的重量
        int[] value=new int[]{15,20,30};    //物品的价值
        int n=weight.length;    //物品种类数
        int bagCap= Arrays.stream(weight).max().orElse(0);   //背包容量

        int[][] dp=new int[n][bagCap+1];
        for(int j=1;j<=bagCap;j++){
            dp[0][j]=dp[0][j-weight[0]]+value[0];   //初始化第一行
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<=bagCap;j++){
                if(j<weight[i]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
    }
}

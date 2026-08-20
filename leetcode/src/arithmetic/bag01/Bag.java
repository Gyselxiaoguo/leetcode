package arithmetic.bag01;

import java.util.Arrays;

/**
 *  01背包：每件物品只能取1次
 *  方法一：二维数组
 */
/*public class Bag {
    public static void main(String[] args) {
        int[] weight=new int[]{1,3,4};  //物品的重量
        int[] value=new int[]{15,20,30};    //物品的价值


        int n=weight.length;    //物品种类数
        int bagCap=Arrays.stream(weight).max().orElse(0);   //背包容量
        *//**
         *          背包容量0       1       2       3       4
         * 物品1          0       15      15      15      15
         * 物品2          0       15      15      20      35
         * 物品3          0       15      15      20      35
         *//*
        int[][] dp=new int[n][bagCap+1];   // 行为当前新增可选的物品;   列为当前背包容量    dp[i][j]当前的最大价值
        for(int i=0;i<n;i++){   //背包容量为0时，dp[i][j]=0
            dp[i][0]=0;
        }
        for(int i=0;i<=bagCap;i++){  //初始化只放物品1的情况
            if(i>=weight[0]){
                dp[0][i]=value[0];
            }
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
}*/

/**
 * 方法二：一维动态数组
 */
public class Bag {
    public static void main(String[] args) {
        int[] weight=new int[]{1,3,4};  //物品的重量
        int[] value=new int[]{15,20,30};    //物品的价值

        int n=weight.length;    //物品数量
        int bagCap=Arrays.stream(weight).max().orElse(0);   //背包容量
        int[] dp=new int[bagCap+1];
        for(int i=0;i<n;i++){
            for(int j=bagCap;j>=weight[i];j--){
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
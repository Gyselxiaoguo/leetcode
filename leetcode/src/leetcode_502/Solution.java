package leetcode_502;

import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<profits.length;i++){
            list.add(new int[]{capital[i],profits[i]});
        }

        list.sort((a,b)->a[0]-b[0]);//按照capital升序排序
        PriorityQueue<Integer> deap=new PriorityQueue<>((a,b)->b-a);//存放profit，降序排序

        int i=0;
        while(k>0){
            while(i<capital.length&&list.get(i)[0]<=w){//只要capital[i]<=w，都放进deap中
                deap.add(list.get(i)[1]);
                i++;
            }
            if(deap.isEmpty()){
                break;
            }
            w+=deap.poll();//只取第一个,及在当前w下，完成项目可获得的最大利润
            k--;
        }
        return w;
    }
}

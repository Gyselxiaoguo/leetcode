package leetcode_502;

import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<int[]> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{capital[i],profits[i]});
        }
        Collections.sort(list, (o1, o2) ->o1[0]-o2[0]); //按照capital升序排序
        PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->b-a);   //存放profit，降序排序
        //将比w小的capital元素都放入queue中，利润只取queue中的第一个
        int i=0;
        while (k>0){
            while (i<n&&list.get(i)[0]<=w){ //只要capital【i]<=w，都放进queue中
                queue.offer(list.get(i)[1]);
                i++;
            }
            if(queue.isEmpty()){
                break;
            }
            w+=queue.poll();    //只取第一个
            k--;
        }
        return w;
    }
}

/*
public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    //w>=capital[i]&&profits[i]最大
    while (k>0){
        int idx=-1;
        int curMaxProfit=0;
        for (int i = 0; i < capital.length; i++) {
            if(w>=capital[i]&&profits[i]>curMaxProfit){
                idx=i;
                curMaxProfit=profits[i];
            }
        }
        if(idx==-1){    //哪个项目都不能完成
            return w;
        }
        w+=profits[idx];
        capital[idx]=Integer.MAX_VALUE;
        k--;
    }
    return w;
}*/

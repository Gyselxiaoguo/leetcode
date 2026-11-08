package leetcode_502;

import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<capital.length;i++){
            list.add(new int[]{profits[i],capital[i]});
        }

        list.sort((a,b)->a[1]-b[1]);//按照capital升序排序,为了下面的while把所有小于w的放入heap
        PriorityQueue<Integer> heap=new PriorityQueue<>((a,b)->b-a);//存放profit，降序排序

        int i=0;
        while(k>0){
            while(i<capital.length&&list.get(i)[1]<=w){//只要capital[i]<=w，都放进deap中
                heap.add(list.get(i)[0]);
                i++;
            }
            if(!heap.isEmpty()){
                w+=heap.poll();//只取第一个,及在当前w下，完成项目可获得的最大利润
            }

            k--;
        }
        return w;
    }
}

package leetcode_295;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 最终的大根堆元素个数最多比小根堆元素个数多一
 */
class MedianFinder {
    // 大顶堆，存放较小一半数据
    private PriorityQueue<Integer> maxHeap;
    // 小顶堆，存放较大一半数据
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
       maxHeap=new PriorityQueue<>(( o1,  o2)->o2-o1);  //降序排序
        minHeap=new PriorityQueue<>();  //升序排序
    }

    //大根堆元素数量>=小根堆元素数量
    public void addNum(int num) {
        if(maxHeap.isEmpty()||num<=maxHeap.peek()){
            maxHeap.offer(num);
        }else {
            minHeap.offer(num);
        }

        if(maxHeap.size()>minHeap.size()+1){  //大根堆个数>小根堆，大根堆元素移动小根堆
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size()>maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

    }
    
    public double findMedian() {
        if ((maxHeap.size()+minHeap.size())%2==1){
            return maxHeap.peek();
        }else {
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
    }
}
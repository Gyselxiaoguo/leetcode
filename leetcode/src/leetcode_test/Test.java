package leetcode_test;



import java.util.*;
import java.util.stream.IntStream;

public class Test {


    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.offer(8);
        heap.offer(5);
        heap.offer(9);
        heap.offer(3);
        heap.offer(7);

        while (!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }

}






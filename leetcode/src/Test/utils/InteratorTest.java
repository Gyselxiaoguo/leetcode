package Test.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InteratorTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(111);
        list.add(222);
        list.add(333);

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {     //判断当前位置是否有元素，有->true；无->false;
            int value = iterator.next();    //获取当前位置元素，并将迭代器对象移到下一个位置
            System.out.print(value + " ");
        }
    }
}

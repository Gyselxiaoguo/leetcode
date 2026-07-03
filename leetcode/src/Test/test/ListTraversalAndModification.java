package Test.test;

import java.util.*;

public class ListTraversalAndModification {
public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    // // 使用 ListIterator 遍历并修改元素
    ListIterator<Integer> iterator = list.listIterator(); // ⚠️ 使用 listIterator() 方法
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            if (num.equals(2)) {
                // 使用 ListIterator 的 set 方法修改（替换）元素
                iterator.set(4);
                iterator.add(99);  // 在当前位置后面插入 99
            }
            if(num.equals(4)){
                iterator.remove();
            }
        }
    System.out.println(list); // 输出: [1, 4, 3]
    }
}
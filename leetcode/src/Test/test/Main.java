package Test.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 初始化Scanner用于读取标准输入
        Scanner sc = new Scanner(System.in);
        // 读取输入的数字字符串
        String s = sc.next();
        // 计数数组，下标0~9对应数字0~9的出现次数
        int[] count = new int[10];
        
        // 遍历字符串，统计每个数字的出现次数
        for (int i = 0; i < s.length(); i++) {
            // 字符转数字后对应下标计数+1
            count[s.charAt(i) - '0']++;
        }
        
        // 用于高效拼接结果字符串
        StringBuilder res = new StringBuilder();
        
        // 查找最小的非零数字，作为结果的首位
        int firstNonZero = -1;
        for (int i = 1; i <= 9; i++) {
            if (count[i] > 0) {
                firstNonZero = i;
                break;
            }
        }
        
        // 未找到非零数字，说明字符串全为0，直接输出0
        if (firstNonZero == -1) {
            System.out.println(0);
            return;
        }
        
        // 将首位非零数字加入结果，对应计数减1
        res.append(firstNonZero);
        count[firstNonZero]--;
        
        // 从小到大遍历0~9，将剩余数字依次追加到结果末尾
        for (int i = 0; i <= 9; i++) {
            // 每个数字有多少个就拼接多少个
            while (count[i] > 0) {
                res.append(i);
                count[i]--;
            }
        }
        
        // 输出最终的最小数字
        System.out.println(res);
    }
}

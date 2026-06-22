package leetcode_433;

import java.util.*;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if(!bankSet.contains(endGene)){
            return -1;
        }

        Queue<String> queue=new ArrayDeque<>();
        Set<String> visited=new HashSet<>();
        queue.offer(startGene);
        visited.add(startGene);

        int step = 0;
        char[] base=new char[]{'A','C','G','T'};

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                String cur = queue.poll();
                if(cur.equals(endGene)){    // 到达终点
                    return step;
                }

                char[] arr = cur.toCharArray();
                for (int j = 0; j < arr.length; j++) {  // 遍历8个字符位置
                    char old = arr[j];
                    for (char c : base) {   // 替换四种碱基
                        if(c==old){
                            continue;
                        }
                        arr[j]=c;
                        String next=new String(arr);
                        if(bankSet.contains(next)&&!visited.contains(next)){    // 合法且未访问
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                    arr[j]=old; //// 复原当前位置，换下一个
                }

            }
            step++;
        }
        return -1;
    }
}

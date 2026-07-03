package leetcode_127;

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet=new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return 0;
        }

        Queue<String> queue=new ArrayDeque<>();
        Set<String> visited=new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        int step=1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if(cur.equals(endWord)){
                    return step;
                }

                char[] arr = cur.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char old=arr[j];
                    for(char c='a';c<='z';c++){
                        if(c==old){
                            continue;
                        }
                        arr[j]=c;
                        String next = new String(arr);
                        if(wordSet.contains(next)&&!visited.contains(next)){
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                    arr[j]=old;
                }
            }
            step++;
        }
        return 0;
    }
}
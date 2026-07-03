package leetcode_149;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {

        int n = points.length;
        // 边界：只有1个点直接返回1
        if (n <= 1) return n;
        int res=0;
        for (int i = 0; i < n; i++) {
            Map<String,Integer> map=new HashMap<>();    //存放不同斜率的数量
            int same=0; //重合点的个数
            for (int j = i+1; j < n; j++) {
                int x1=points[i][0];
                int y1=points[i][1];
                int x2=points[j][0];
                int y2=points[j][1];
                String key=calc(x1,y1,x2,y2);
                if("same".equals(key)){
                    same++;
                }else {
                    map.put(key,map.getOrDefault(key,0)+1);
                }
            }
            //取出当前map中value的最大值
            Integer curMax = map.values().stream().max(((o1, o2) -> o1-o2)).orElse(0);
            res=Math.max(res,curMax+same);
        }
        return res+1;
    }

    //计算斜率
    private String calc(int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy=Math.abs(y2-y1);
        if(dx==0&&dy==0){   //重合
            return "same";
        }
        int g=gcd(dx,dy);
        String k=dy/g +"/"+ dx/g;
        if(x1>x2&&y1<y2 || x1<x2&&y1>y2){
            return "-"+k;
        }
        return k;
    }
    // 求最大公约数
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
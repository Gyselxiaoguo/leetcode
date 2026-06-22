package leetcode_380;

import java.util.*;

class RandomizedSet {

    Map<String,Integer> map;
    Random random=new Random();
    int[] nums=new int[200010];
    int idx=-1;
    public RandomizedSet() {
        map=new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(""+val)){
            nums[++idx]=val;
            map.put(""+val,idx);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(""+val)){
            Integer loc = map.remove("" + val);
            if(loc!=idx){   //删除的不是数组中最后一个元素，要用最后一个元素与删除的位置补上，idx-1
                map.put(""+nums[idx],loc);
            }
            nums[loc]=nums[idx--];
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        return nums[random.nextInt(idx+1)];
    }
}
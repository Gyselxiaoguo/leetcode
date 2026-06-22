package leetcode_383;

class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count=new int[26];

        //统计magazine中，每个字符出现的次数
        for (int i = 0; i < magazine.length(); i++) {
            int index = magazine.charAt(i) - 'a';
            count[index]++;
        }

        //遍历ransomNote中的每个字符，count数组中相应位置数量-1
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            count[index]--;
            if(count[index]<0){
                return false;
            }
        }
        return true;
    }
}
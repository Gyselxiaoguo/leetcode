package leetcode_151;

class Solution {
    /*
     *  abc def
     * 步骤：
     *  cba fed     //将每个单词进行翻转
     *  def abc     //整体翻转
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder word=new StringBuilder();
        //1.遍历，找到每个单词
        for (int i = 0; i < s.length();) {
            if(s.charAt(i)==' '){
                i++;
                continue;
            }
            int j=i;
            while (j<s.length()&&s.charAt(j)!=' '){ //循环结束后，拿到一个单词
                word.append(s.charAt(j));
                j++;
            }
            i=j;
            //2.将每个单词翻转
            sb.append(word.reverse());  //翻转后的单词放入sb中
            sb.append(' '); //添加空格

            word.setLength(0);  //清空
        }
        //3.整体进行翻转
        return sb.reverse().toString().strip();
    }
}
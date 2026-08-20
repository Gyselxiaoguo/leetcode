package leetcode_151;

class Solution {
    /*
     *  abc def
     * 步骤：
     *  cba fed     //将每个单词进行翻转
     *  def abc     //整体翻转
     */
    public String reverseWords(String s) {
        String[] arr=s.split(" ");  //分割
        StringBuilder sb=new StringBuilder();
        for(String ss:arr){
            if(ss.isEmpty()){
                continue;
            }
            sb.append(new StringBuilder(ss).reverse()); //反转每个单词
            sb.append(" ");
        }
        return sb.reverse().toString().strip(); //整体反转
    }
}

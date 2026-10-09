package leetcode_647;

class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                String sub=s.substring(i,j+1);
                if(isPalindrome(sub)){
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean isPalindrome(String s){
        String newS=new StringBuilder(s).reverse().toString();
        return s.equals(newS);
    }
}
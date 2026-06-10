package leetcode_6;

class Solution {
    public String convert(String s, int numRows) {
        //numRows=1
        if(numRows==1){
            return s;
        }

        StringBuilder[] rows=new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            rows[i] = new StringBuilder();
        }

        int pos=0;
        int down=1;
        //上下往返存储
        for (int i = 0; i < s.length(); i++) {
            rows[pos].append(s.charAt(i));
            pos+=down;
            if(pos==numRows){   //底部越界
                down=-1;
                pos-=2;
            }else if(pos==-1){  //顶部越界
                down=1;
                pos=1;
            }
        }

        StringBuilder res=new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}
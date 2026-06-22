package leetcode_71;


import java.util.Stack;

class Solution {
    /**
     * 处理后使用栈求解
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack=new Stack<>();
        for (String part : parts) {
            if(part.isEmpty()||".".equals(part)){   //空字符串或者‘.'跳过
                continue;
            }
            if("..".equals(part)){  //..弹出
                // 只有栈不为空才能弹出
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }else {
                stack.push(part);
            }
        }
        StringBuilder res= new StringBuilder();
        while (!stack.isEmpty()){
            res.insert(0, "/" + stack.pop());
        }
        // 栈空代表根目录，必须返回 /
        return res.isEmpty() ? "/" : res.toString();
    }
}
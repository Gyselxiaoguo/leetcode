package leetcode_207;

class Solution {
    /*拓扑图*/
    /***
     * point  前驱节点数量
     * 0        xx
     * 1        xx
     * 2        xx
     */

    /***
     * prerequisites的元素是个数组，元素1：后继节点，元素2：前驱节点
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        if(len==0)return true;
        int[] pointer=new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            ++pointer[prerequisite[1]];//记录每个前驱节点的个数
        }
        boolean[] removed=new boolean[len];//标记prerequisites元素是否被移除
        int remove=0;//移除元素数量
        while (remove<len){
            int currRemove=0;//本轮移除元素个数
            for (int i = 0; i < len; i++) {
                if(removed[i])continue;//已经移除，进行下一个元素
                int[] prerequisite=prerequisites[i];
                if(pointer[prerequisite[0]]==0){//该节点没有前驱节点，可删除
                    removed[i]=true;
                    --pointer[prerequisite[1]];//前驱节点个数  -1
                    ++currRemove;
                }
            }
            if(currRemove==0)return false;//进行一轮没有删除一个元素，说明有环
            remove+=currRemove;
        }
        return true;
    }
}
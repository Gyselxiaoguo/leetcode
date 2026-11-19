package Test;

import javax.swing.plaf.basic.BasicDesktopIconUI;
import java.util.*;


/*
* Scanner sc=new Scanner(System.in);
* sc.nextInt()  自动跳过前面所有空白（空格、换行），遇到换行/空格就停,
* sc.nextLine()     读整行，遇到换行符（/n)就停
* sc.next()         读字符串，跳过前面空白,遇到空格、换行、Tab就停
*
* sc.close()    不再使用sc了就关闭
* */
public class ScannerTest {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] num1=new int[n];
        for(int i=0;i<n;i++){
            num1[i]=sc.nextInt();
        }
        ListNode dummy1=new ListNode();
        ListNode cur1=dummy1;
        for(int num:num1){
            cur1.next=new ListNode(num);
            cur1=cur1.next;
        }
        ListNode l1=dummy1.next;

        int m=sc.nextInt();
        int[] num2=new int[m];
        for(int i=0;i<m;i++){
            num2[i]=sc.nextInt();
        }
        ListNode dummy2=new ListNode();
        ListNode cur2=dummy2;
        for(int num:num2){
            cur2.next=new ListNode(num);
            cur2=cur2.next;
        }
        ListNode l2=dummy2.next;

        sc.close();

        ListNode head=addTwoNumbers(l1,l2);
        ListNode cur=head;
        while(cur!=null){
            System.out.printf(cur.val+" ");
            cur=cur.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode();
        ListNode cur=dummy;
        int up=0;
        while(l1!=null||l2!=null){
            int val1=l1==null?0:l1.val;
            int val2=l2==null?0:l2.val;
            int sum=val1+val2+up;
            cur.next=new ListNode(sum%10);
            cur=cur.next;
            up=sum/10;

            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
        }
        if(up==1){
            cur.next=new ListNode(up);
        }
        return dummy.next;
    }
}
class ListNode{
    int val;
    ListNode next;
    public ListNode(){}
    public ListNode(int val){
        this.val=val;
    }
}

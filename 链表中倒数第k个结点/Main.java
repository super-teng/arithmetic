package 链表中倒数第k个结点;

import java.util.Stack;

/*
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 思路：放到一个栈里通过弹栈的方式进行取值
 * 省空间复杂度的思路：使用两个指针，同时指向头结点，第一个指针先移动K-1的位置之后第二个指针在进行移动
 * 等第二个指针到达底部时候第一个指针所指向的位置就是倒数第K个节点了。
 */
public class Main {
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	public ListNode FindKthToTail(ListNode head,int k) {
		if(head == null || k <= 0){
			return null;
		}
		ListNode temp = head;//申请一个指针指向当前链表的第一个节点
		Stack<ListNode> stack = new Stack<ListNode>();//申请一个栈用于存储节点元素之后进行取值用
		while(temp != null){//把链表中元素压入栈中
			stack.push(temp);
			temp = temp.next;
		}
		try{
			ListNode result = null;
			while(k>0){
				result = stack.pop();
				k--;
			}
			return result;
		}catch(Exception e){
			return null;
		}
    }
	public static void main(String[] args){
//		Main m = new Main();
//		ListNode l1 = m.new ListNode(1);
//		ListNode l2 = m.new ListNode(2);
//		ListNode l3 = m.new ListNode(3);
//		ListNode l4 = m.new ListNode(4);
//		ListNode l5 = m.new ListNode(5);
//		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;
//		ListNode result = m.FindKthToTail(l1, 6);
//		if(result !=null){
//			System.out.println(result.val);
//		}else{
//			System.out.println("输入有误");
//		}
	}
}

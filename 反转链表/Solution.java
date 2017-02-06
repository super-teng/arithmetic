package 反转链表;


/*
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * 思路：
 * 1第一种就是存储到栈中去然后通过弹栈的方式进行连接
 * 2设置两个指针，通过不断切换来进行把指向倒置
 */
public class Solution {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode ReverseList(ListNode head) {
//		if(head == null){
//			return null;
//		}else{
//			Stack<ListNode> stack = new Stack<ListNode>();
//			ListNode temp = head;
//			while(temp != null){
//				stack.push(temp);
//				temp = temp.next;
//			}
//			ListNode result = stack.pop(); // 新的头结点
//			ListNode tempResult = result;
//			while(!stack.isEmpty()){
//				tempResult.next = stack.pop();
//				tempResult = tempResult.next;
//			}
//			return result;
//		}
		 ListNode pre = null;
	     ListNode next = null;
	     while (head != null) {
		        next = head.next;
		        head.next = pre;
		        pre = head;
		        head = next;
		 }
		 return pre;
	}
	public static void main(String[] args){
		Solution m = new Solution();
		ListNode l1 = m.new ListNode(1);
		ListNode l2 = m.new ListNode(2);
		ListNode l3 = m.new ListNode(3);
		ListNode l4 = m.new ListNode(4);
		ListNode l5 = m.new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode result = m.ReverseList(l1);
		if(result !=null){
			System.out.println(result.next.next.val);
		}else{
			System.out.println("输入有误");
		}
	}
}

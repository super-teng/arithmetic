package ÃæÊÔËã·¨.Ìæ»»×Ö·û´®ÖÐÔªËØ;

import java.util.ArrayList;

public class Main {
	     class ListNode {
	        int val;
	        ListNode next = null;
	        ListNode(int val) {
	            this.val = val;
	        }
	    }
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> rr = new ArrayList<Integer>();
        while(listNode != null){
            rr.add(listNode.val);
            listNode = listNode.next;
        }
        for(int i=rr.size()-1;i>=0;i--){
            result.add(rr.get(i));
        }
        System.out.println(result.size());
        return result;
    }
	public static void main(String[] args){
		Main m = new Main();
		int[] a = {67,0,24,58};
		ListNode listNode =  m.new ListNode(67);
		ListNode listNode1 = m.new ListNode(0);
		ListNode listNode2 = m.new ListNode(24);
		ListNode listNode3 = m.new ListNode(58);
		listNode.next = listNode1;
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		ArrayList<Integer> list = m.printListFromTailToHead(listNode);
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i)+" ");
		}
	}
}

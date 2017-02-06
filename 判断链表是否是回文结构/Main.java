package 判断链表是否是回文结构;

import java.util.LinkedList;
import java.util.Stack;

public class Main {
	
	public static boolean judge(LinkedList<Integer> list){
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<list.size();i++){
			stack.push(list.get(i));
		}
		for(int i=0;i<list.size();i++){
			if(list.get(i) == stack.pop()){
				continue;
			}else{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(1);
		System.out.println(judge(list));
	}
}

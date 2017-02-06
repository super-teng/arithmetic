package 栈中元素逆转;

import java.util.Stack;

/*
 * 问题：逆转栈中的元素，不开辟新的存储空间
 * 思路：通过递归的方式来进行逆转，递归本身就是开辟一个递归栈
 */
public class Main {
	//对当前元素进行逆置
	public static void reserve(Stack<Integer> stack){
		if(stack==null || stack.isEmpty()){
			return;
		}else{
			//取得栈底元素
			int temp = getAndRemove(stack);
			//继续进行递归调用找到栈底元素
			reserve(stack);
			//等到最后一个元素的时候把这个元素push到栈中去
			stack.push(temp);
		}
	}
	//取出当前栈底元素
	public static int getAndRemove(Stack<Integer> stack){
		int result = stack.pop();
		if(stack.isEmpty()){
			return result;
		}else{
			int temp = getAndRemove(stack);
			stack.push(result);
			return temp;
		}
	}
	public static void main(String[] args){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		reserve(stack);
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+"-");
		}
	}
}

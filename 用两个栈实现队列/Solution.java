package 用两个栈实现队列;

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.add(node);
    }
    public int pop() {
    	if(stack2.empty()){
    		while(!stack1.empty()){
    			stack2.push(stack1.pop());
    		}
    	}
    	if(stack2.empty()){
    		System.out.println("Empty");
    		System.exit(0);
    	}
    	return stack2.pop();
    }
}
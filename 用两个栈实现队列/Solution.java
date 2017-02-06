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
<<<<<<< HEAD
    		System.out.println("Empty");
=======
    		System.out.println("stack2 is Empty");
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
    		System.exit(0);
    	}
    	return stack2.pop();
    }
}
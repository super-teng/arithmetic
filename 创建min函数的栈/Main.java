package 创建min函数的栈;

import java.util.Stack;

/*
 * 题目描述

定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class Main {

    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();
    
    private Integer currentMin = null;
    public void push(int node) {
        if(currentMin != null && currentMin < node){
            stack2.push(currentMin);
        }else{
            stack2.push(node);
            currentMin = node;
        }
        stack.push(node);    
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            stack2.pop();
        }
    }
    
    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }else{
            return -1;
        }
    }
    
    public int min() {
        if(!stack2.isEmpty()){
        	return stack2.peek();
        }else{
            return -1;
        }
    }
}
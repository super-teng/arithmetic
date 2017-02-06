package 栈的压入弹出序列;

import java.util.Stack;

/*
 * 题目描述

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null || pushA.length == 0|| popA.length == 0){
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        for(int i =0;i<pushA.length;i++){
            stack.push(pushA[i]);
            if(stack.peek() == popA[index]){
                stack.pop();
                index++;
            }              
        }
        while(!stack.isEmpty()){
            if(stack.peek() == popA[index]){
                stack.pop();
                index++;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] pushA = {1,2,3,4,5};
    	int[] popA = {4,5,3,2,1};
    	System.out.println(s.IsPopOrder(pushA, popA));
    }
}

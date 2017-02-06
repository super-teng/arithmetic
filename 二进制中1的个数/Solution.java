package 二进制中1的个数;

/*
 * 题目描述

输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution {
	public int  NumberOf1(int n) {
         int count = 0;
    	 while(n != 0){
             count++;
             n = (n-1) & n;
         }
		 return count;
     }
	public static void main(String[] args){
		args = new String[10];
		System.out.println(args.length);
		double d1 =1.32323;
		double d2 =1.32323;
		if(d1 == d2){
			System.out.println("111");
		}
	}
}
package 十进制与二进制互转;

import javax.swing.JOptionPane;

public class Solution {
	public int twoToTen(int number){
		String s = String.valueOf(number);
		int result = 0;
		int length = s.length();
		// 100  1
		for(int i=0;i<s.length();i++){
			if(s.charAt(i) == '1'){
				result += 1 << length-i-1;
			}
		}
		return result;
	}
	public String tenToTwo(int number){
		String result = "";
		int sum;
		for(int i = number;i>=1;i/=2){
			if(i%2 == 0){
				sum = 0;
			}else{
				sum = 1;
			}
			result = sum + result;
		}
		return result;
	}
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.twoToTen(111100));
		System.out.println(s.tenToTwo(10));
	}
}

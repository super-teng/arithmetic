package 字符串;

import java.util.ArrayList;

//在字符串中找出第一个只出现一次的字符串，如输入"abaccdeff"，输出'b'。
public class Test01 {
	
	public static char search(String data){
		char[] values = data.toCharArray();
		ArrayList<Character> l = new ArrayList<Character>();
		char[] temp = new char[values.length];
		int number = 0;
		for(int i=0;i<values.length;i++){
			if(l.contains(values[i])){
				temp[number++] = values[i];
			}else{
				l.add(values[i]);
			}
		}
		for(int i=0;i<temp.length;i++){
			if(temp[i]=='\0'){
				break;
			}else{
				l.remove(new Character(temp[i]));
			}
		}
		return l.get(0);
	}
	
	public static void main(String[] args){
		String s = "abaccdeff";
		char result = Test01.search(s);
		System.out.println(result);
	}
}

package 面试小算法;

import java.util.Scanner;

//通过递归的方式进行回文字符串的判断
public class Test03 {
	private boolean flag;
	
	public void judge(String s) throws InterruptedException{//abccba
		if(s.length()==1){
			flag = true;
		}else if(s.length() ==2){
			if(s.charAt(0)!=s.charAt(1)){
				flag = false;
			}else{
				flag = true;
			}
		}else{
			if(s.charAt(0)==s.charAt(s.length()-1)){
				s = s.substring(1, s.length()-1);
				judge(s);
			}else{
				flag = false;
				return;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			Test03 tt = new Test03();
			tt.judge(sc.next());
			System.out.println(tt.isFlag());
		}
	}

	public boolean isFlag() {
		return flag;
	}
	
}

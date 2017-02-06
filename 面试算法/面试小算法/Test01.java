package 面试小算法;

import java.util.Scanner;

//将一整数逆序放入一个数组当中 要求递归实现
public class Test01 {

	private int[] result;//12345
	public void change(int number,int n){
		if(number>9){
			int temp = number % 10;
			result[result.length-1-n] = temp;
			number = number/10;
			if(n>0){
				change(number,n-1);
			}
		}else{
			result[result.length-1-n] = number;
		}
	}
	
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int number = sc.nextInt();
			Test01 tt = new Test01();
			String temp = String.valueOf(number);
			int[] r = new int[temp.length()];
			tt.setResult(r);
			tt.change(number, temp.length()-1);
			for(int i=0;i<r.length;i++){
				System.out.print(tt.getResult()[i]);
			}
		}
		sc.close();
	}



	public int[] getResult() {
		return result;
	}



	public void setResult(int[] result) {
		this.result = result;
	}
	
}

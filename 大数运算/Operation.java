package 大数运算;

import java.util.Scanner;

public class Operation {
	public int[] big_add(char[] first,char[] second){
		//对两个数组进行逆置 并找出大长度和小长度的
		char[] oFirst = new char[first.length];
		char[] oSecond = new char[second.length];
		int big = oFirst.length>oSecond.length?oFirst.length:oSecond.length;
		int small = oFirst.length>oSecond.length?oSecond.length:oFirst.length;
		int[] result = new int[big+1];
		for(int i=0;i<oFirst.length;i++){
			oFirst[oFirst.length-1-i] = first[i];
		}
		for(int i=0;i<oSecond.length;i++){
			oSecond[oSecond.length-1-i] = second[i];
		}
		//按照小长度对位加法 temp 变量用来判断是否需要进位
		int temp = 0;
		for(int i=0;i<small;i++){
			temp = temp+(int)oFirst[i] - 48+(int)oSecond[i] -48;
			if(temp>9){
				result[i] = temp%10;
				temp = 1;
			}else{
				result[i] = temp;
				temp = 0;
			}
		}
		//对大长度剩余的几位进行与进位temp进行加法
		char[] tt = oFirst.length>oSecond.length?oFirst:oSecond;
		for(int i=small;i<big;i++){
			temp = (int)tt[i]-48+temp;
			if(temp>9){
				result[i] = temp%10;
				temp = 1;
			}else{
				result[i] = temp;
				temp = 0;
			}
		}
		//最终存到返回结果数组result
		result[result.length-1] = temp;
		return result;
	}
	
	public int[] big_multiply(char[] a,char b[]){
		//存储两个相乘元素的逆置结果
		char[] aa = new char[a.length];
		char[] bb = new char[b.length];
		//结果数组 因为两个数的乘积长度不会超过两个数之和加3
		int[] result = new int[a.length+b.length+3];
		//逆置
		for(int i=0;i<aa.length;i++){
			aa[i] = a[a.length-i-1];
		}
		for(int j=0;j<bb.length;j++){
			bb[j] = b[b.length-1-j];
		}
		
		//对位相乘
		for(int i =0;i<aa.length;i++){
			for(int j=0;j<bb.length;j++){
				//符合乘积的错位相乘的原则， 两个数通过取Unicode值之后减去48位整形1
				result[i+j] += ((int)aa[i]-48)*((int)bb[j]-48);
			}
		}
		//进位
		int temp = 0;//进位的表示符 81 162 81 
		for(int i=0;i<result.length;i++){
			int flag = result[i]+temp;
			if(flag>9){
				result[i] = flag%10;
				temp = flag/10;
			}else{
				result[i] = result[i]+temp;
				temp = 0;
			}
		}
		
		return result;
	}
	
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Operation o = new Operation();
		//加法
		System.out.println("大数加法");
		String s1 = sc.next();
		String s2 = sc.next();
		char[] ss1 = s1.toCharArray();
		char[] ss2 = s2.toCharArray();
		int[] result = o.big_add(ss1, ss2);
		int length = 0;
		//判断加法结果最高位是0还是1
		if(result[result.length-1]==0){
			length = result.length-2;
		}else{
			length = result.length-1;
		}
		for(int i=length;i>=0;i--){
			System.out.print(result[i]);
		}
		System.out.println();
		System.out.println("大数乘法");
		String s3 = sc.next();
		String s4 = sc.next();
		char[] ss3 = s3.toCharArray();
		char[] ss4 = s4.toCharArray();
		int[] result02 = o.big_multiply(ss3, ss4);
		//找到最高位
		int maxLength = 0;
		for(int i=result02.length-1;i>=0;i--){
			if(result02[i]!=0){
				maxLength = i;
				break;
			}
		}
		for(int i=maxLength;i>=0;i--){
			System.out.print(result02[i]);
		}
	}
}

package 大数运算;

import java.math.BigInteger;

public class Test {
	public static void main(String[] args){
		BigInteger a = new BigInteger("123456789");
		BigInteger b = new BigInteger("987654321");
		System.out.println("结果为");
		System.out.println("加法:"+a.add(b));
		System.out.println("减法"+a.subtract(b));
		System.out.println("乘法"+a.multiply(b));
		System.out.print("除法");
		BigInteger[] result = a.divideAndRemainder(b);
		System.out.print(result[0]+".");
		System.out.print(result[1]);
		System.out.println();
		System.out.println("--------------------");
		char aa = '1';
		char bb = '2';
		System.out.println(((int)aa-48)*((int)bb-48));
 	}
}

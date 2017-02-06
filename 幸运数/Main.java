package 幸运数;

import java.math.BigInteger;
import java.util.Scanner;


public class Main {
	/*
	 * 第二题幸运数：
	 * 
	 * 时间限制：C/C++语言 1000MS；其他语言 3000MS 内存限制：C/C++语言 65536KB；其他语言 589824KB
	 * 
	 * 题目描述：
	 * 
	 * 4和7是两个幸运数字，我们定义，十进制表示中，每一位只有4和7两个数的正整数都是幸运数字。
	 * 前几个幸运数字是：4,7,44,47,74,77,444,447…
	 * 
	 * 现在输入一个数字k，输出第k个幸运数 输入输出我忘了。 
	 * 样例输入 3 5 100 10000000 样例输出 74 744747
	 * 44774447447477474444447
	 * 
	 * 这题目就是格雷码…
	 */
	
	public static void lucky(BigInteger n){
		if(n.compareTo(BigInteger.ZERO) <= 0 ){
			return ;
		}
		if(n.equals(BigInteger.ONE)){
			System.out.print(4);
			return ;
		}else if(n.equals(new BigInteger("2"))){
			System.out.print(7);
			return ;
		}
		BigInteger pre = (n.subtract(BigInteger.ONE)).divide(new BigInteger("2"));
		BigInteger now = n.subtract(pre.multiply(new BigInteger("2")));
		if(pre.compareTo(BigInteger.ZERO) >0){
			lucky(pre);
		}
		if(now.compareTo(BigInteger.ZERO) > 0){
			lucky(now);
		}
	}
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T--> 0){
			BigInteger n = sc.nextBigInteger();
			lucky(n);
			System.out.println();
		}
		sc.close();
	}
//	 Arrays.sort(array, new Comparator<People>() {
//         public int compare(People p1, People p2) {
//             int result = Integer.compare(p1.height, p2.height);
//             if (result != 0)
//                 return result;
//             else
//                 return Integer.compare(p1.weight, p2.weight);
//         }
//     })
}

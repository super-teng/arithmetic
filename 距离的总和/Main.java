package 距离的总和;
//思路：两个循环嵌套，外循环是较小偶数，内循环是较大偶数，外循环索引从0开始++，内循环从外循环下标+1开始进行
//这样保证了每两个元素都进行了比较，然后循环体中求这个范围中的所有的质数和累加输出
//AC 71%是因为求得的质数没有很好的复用，每次都是重新计算一次两个元素之间的质数个数，时间有限算法不是很优质
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	//求质数的方法
	public static List<Integer> search(int start, int end) {
		List<Integer> numbers = new ArrayList<Integer>();
		int temp = 0;
		boolean flag = true;
		for (int i = start; i < end; i++) {
			flag = true;
			if (i > 3) {
				temp = (int) Math.sqrt(i);
				for (int j = 2; j <= temp; j++) {
					if (i % j == 0) {
						flag = false;
					}
				}
			} else if (i < 2) {
				flag = false;
			} else {
				flag = true;
			}
			if (flag) {
				numbers.add(i);
			}
		}
		return numbers;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int[] array = new int[number];
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
		}
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				// 找质数
				count += search(array[i], array[j]).size();
			}
		}
		System.out.println(count);
		sc.close();
		
		
	}
}


/*
 * 定义两个大于2的偶数之间的距离，为这两个数之间质数的个数。从小到大输入n个大于2的偶数，
 * 输出所有数两两之间距离的总和（应该有n*(n-1)/2个距离，输出总和就好)。
 输入
 第一行是输入偶数的个数，最小为2，最大可能到几万。之后每行为一个偶数，最小是4，
 最大可能是几百万，不重复的升序排列。
 输出
 输入数据两两间距离的总和，这应该是一个不小于0的整数。

 样例输入
 3
 4
 6
 12
 样例输出
 6
 */
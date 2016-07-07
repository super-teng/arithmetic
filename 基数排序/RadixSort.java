package 基数排序;

import java.util.LinkedList;

public class RadixSort {
	// 存储原数组的链表
	private LinkedList<Integer> mainRadix;
	// 存储每个基数范围的链表
	private LinkedList<Integer>[] subQueue;

	@SuppressWarnings("unchecked")
	public RadixSort() {
		// 初始化原始链表
		mainRadix = new LinkedList<Integer>();
		// 初始化每个基数值得链表
		subQueue = new LinkedList[10];
		for (int i = 0; i < 10; i++) {
			subQueue[i] = new LinkedList<Integer>();
		}
	}

	public static void main(String[] args) {
		RadixSort rs = new RadixSort();
		int[] array = { 24, 52, 63, 7674, 74, 25, 14, 256, 63263, 14, 4, 4242,
				52 };
		System.out.println("基数排序前");
		rs.print(array);
		System.out.println("基数排序后");
		rs.sort(array);
		rs.print(array);
	}

	public void sort(int[] array) {
		int maxDigits = 0;
		//获取当前数组中最长的那个数字的长度
		for (int i = 0; i < array.length; i++) {
			// 获取到当前数组中的最长的数字长度 作为高位
			if (maxDigits < String.valueOf(array[i]).length()) {
				maxDigits = String.valueOf(array[i]).length();
			}
			// 把数组赋值到链表中
			mainRadix.add(array[i]);
		}
		// 对每一位进行比较判断存入到子链表中去
		for (int i = 1; i <= maxDigits; i++) {
			// 当原链表中有值时取出分别赋予基数链表
			while (mainRadix.size() > 0) {
				//取出当前链表中的元素
				Integer number = mainRadix.pop();
				//转化成字符串便于调用旗下方法好操作
				String numberTemp = String.valueOf(number);
				//假如当前元素长度判断长度则直接将其塞入到0号链表中去
				if (numberTemp.length() < i) {
					subQueue[0].add(number);
					continue;
				}
				//当前基数链表序号为当前数的长度减序号处的值减一
				//因为数字存入到数组中高位在数组前面 比如 12 1处索引为0索引这么写可以思考一下
				int digit = numberTemp.charAt(numberTemp.length() - i) - '0';
				//向子链表中插入这个元素
				subQueue[digit].add(number);
			}
			
			for (int j = 0; j < 10; j++) {
				// 把每个子基数给写回原链表
				mainRadix.addAll(subQueue[j]);
				//并清空每个子基数链表防止下此判断重复
				subQueue[j].clear();
			}
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = mainRadix.get(i);
		}
	}

	public void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}

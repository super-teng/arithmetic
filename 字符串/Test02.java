package 字符串;

import java.util.ArrayList;
import java.util.List;

//输入一个字符串，输出该字符串中对称的子字符串的最大长度。
public class Test02 {
	/*
	 * 找出一个字符串中最长的回文子串
	 * 
	 * 从字符串中第i个字符开始的所有非空回文子串的个数, 记作为Ci. 此方法的复杂度为
	 * 
	 * O(C1 + C2 + ... + Cn)
	 * 
	 * 当字符串中任意两个非空回文子串的起始位置不同时, C1 = C2 = ... = Cn = 1, 复杂度为O(N);
	 * 
	 * 当字符串所有字符均为同一字符时, Ci = n - i, 此时复杂度为O(N*N);
	 * 
	 * 在多数情况下, 此方法的复杂度远低于O(N*N).
	 */
	public List<String> getLongestPalindrome(String theString) {
		//当前字符串长度
		int strLen = theString.length();
		List<String> results = new ArrayList<String>(strLen);
		//为空不进行判断直接
		if (strLen == 0) {
			return results;
		}
		// 从第i个位置开始的所有回文子串的结束位置.
		int[] endIndice = new int[strLen + 1];
		// endIndice中有效数据的长度.
		int numberOfPalindromes = 1;
		// 最长回文子串的长度. 对于非空串至少可以找到长度为1的回文子串.
		int maxLen = 1;
		results.add(theString.substring(strLen - 1));
		// 计算从第i个位置开始的所有回文子串. 这样的子串分为三种:
		// 1. 在从第i+1个位置开始的回文子串的基础上, 在两端加上相同的字符;
		// 2. 长度为1的回文子串;
		// 3. 空串.
		for (int i = strLen - 2; i >= 0; i--) {
			int j = 0, k = 0;
			while (j < numberOfPalindromes) {
				if (theString.charAt(i) == theString.charAt(endIndice[j])) {
					endIndice[k] = endIndice[j] + 1;
					int newLength = endIndice[k] - i;
					if (newLength >= maxLen) {
						if (newLength > maxLen) {
							maxLen = newLength;
							results.clear();
						}
						results.add(theString.substring(i, endIndice[k]));
					}
					if (endIndice[k] < strLen) {
						k++;
					}
				}
				j++;
			}
			// 加入长度为1的子串
			endIndice[k++] = i + 1;
			if (maxLen == 1) {
				results.add(theString.substring(i, i + 1));
			}
			// 加入空串
			endIndice[k++] = i;
			numberOfPalindromes = k;
		}
		return results;
	}

	public static void main(String[] args) {
		Test02 p = new Test02();
		printList(p.getLongestPalindrome("gabcecbaefd"));
		printList(p.getLongestPalindrome("bbcbaefccfg"));
		printList(p.getLongestPalindrome("aaaaaaaaaaa"));
		printList(p.getLongestPalindrome("abcdefghijk"));
		printList(p.getLongestPalindrome("iwnaifniwgnalifdmidmzvcniqnfdnqufenuquiyyiuafnunweunwuf"));
		printList(p.getLongestPalindrome(""));
	}

	public static void printList(List<? extends Object> list) {
		System.out.println("**************************");
		System.out.println(list.size() + " result(s):");
		for (Object o : list) {
			System.out.println(o);
		}
	}
}

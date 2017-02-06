package 字符串;

//思路：先求出当前字符串中所有的回文字串，在这些字串中找出最长的前缀输出
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	//求出当前数组中所有回文字串
	public static List<String> getString(String s) {
		if (s==null || s.length() == 0) {
			return null;
		}
		//当前字符串长度
		int length = s.length();
		List<String> results = new ArrayList<String>(length);
		// 从第i个位置开始的所有回文子串的结束位置.
		int[] end = new int[length + 1];
		// endIndice中有效数据的长度.
		int index = 1;
		// 最长回文子串的长度. 对于非空串至少可以找到长度为1的回文子串.
		int maxLength = 1;
		// 计算从第i个位置开始的所有回文子串. 这样的子串分为三种:
		// 1. 在从第i+1个位置开始的回文子串的基础上, 在两端加上相同的字符;
		// 2. 长度为1的回文子串;
		// 3. 空串.
		for (int i = length - 2; i >= 0; i--) {
			int j = 0, k = 0;
			while (j < index) {
				if (s.charAt(i) == s.charAt(end[j])) {
					end[k] = end[j] + 1;
					int newLength = end[k] - i;
					if (newLength >= maxLength) {
						if (newLength > maxLength) {
							maxLength = newLength;
							results.clear();
						}
						results.add(s.substring(i, end[k]));
					}
					if (end[k] < length) {
						k++;
					}
				}
				j++;
			}
			end[k++] = i + 1;
			if (maxLength == 1) {
				results.add(s.substring(i, i + 1));
			}
			end[k++] = i;
			index = k;
		}
		return results;
	}
	//打印所有回文集合判断找出当前符合前缀要求的字符串
	public static void print(List<String> list,String s) {
		if(list == null || s == null || s.length() == 0){
			return ;
		}
		String result = String.valueOf(s.charAt(0));
		for (String temp : list) {
			if(s.indexOf(temp) == 0 && temp.length() > result.length()){
				result = temp;
			}
		}
		System.out.println(result.length());
	}
	
	public static void main(String[] args) {
		//输出例子。调试作用
//		print(getString("gabcecbaefd"),"gabcecbaefd");
//		print(getString("bbcbaefccfg"),"bbcbaefccfg");
//		print(getString("aaaaaaaaaaa"),"aaaaaaaaaaa");
//		print(getString("abcdefghijk"),"abcdefghijk");
//		print(getString(null),"");
//		print(getString("aabbaa"),"aabbaa");
//		 Scanner sc = new Scanner(System.in);
//	        while(sc.hasNext()){
//	             String s = sc.next();
//	             print(getString(s),s);
//	        }
//	        sc.close();
		 try {  
			 BufferedReader strin=new BufferedReader(new InputStreamReader(System.in));
	            String s = "";
	            while( (s = strin.readLine()) != null){
	                  print(getString(s),s);
	            }
	      } catch (IOException e) {  
	            e.printStackTrace();  
	      }  
	}
}





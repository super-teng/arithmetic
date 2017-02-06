package 构造队列;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		Long begin = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//总共有多少组数据
		for(int i=0;i<T;i++){
			int n = sc.nextInt();
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(n);
			for(int j = n-1;j>=1;j--){
				list.add(0,j);//插入当前元素
				list.add(0,list.remove(list.size()-1));//把最后元素插入到我们链表的前面去
			}
//			System.out.print(list.get(0));
//			for(int k=1;k<list.size();k++){
//				System.out.print(" "+list.get(k));
//			}
//			System.out.println();
			StringBuffer sb = new StringBuffer();
			for(int result:list){
				sb.append(result+" ");
			}
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb.toString());
		}
		Long end = System.currentTimeMillis();
		System.out.println(end - begin);
		sc.close();
	}
}

package ¶ş²æÊ÷;

import java.util.LinkedList;

public class Test {
	
	public void add(String[] b){
		b[1] = "2";
	}
	
	public static void main(String[] args){
		String[] a = new String[10];
		a[0] = "1";
		Test t = new Test();
		t.add(a);
		System.out.println(a[1]);
	}
}

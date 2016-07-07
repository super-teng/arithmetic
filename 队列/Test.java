package ╤сап;

import java.util.LinkedList;

public class Test {
	public static void main(String[] args) throws InterruptedException{
		LinkedList<String> list = new LinkedList<String>();
		list.addLast("a");
		list.addLast("b");
		list.addLast("c");
		list.addLast("d");
		list.addLast("e");
		list.addLast("f");
		while(list.size()>0){
			System.out.print(list.getFirst()+" ");
			list.remove(0);
		}
	}
}

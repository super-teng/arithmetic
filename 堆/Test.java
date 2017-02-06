package ¶Ñ;

import java.util.LinkedList;

public class Test {
	public static void main(String[] args){
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("a");
		list.addFirst("b");
		list.addFirst("c");
		list.addFirst("d");
		list.addFirst("e");
		list.addFirst("f");
		list.addFirst("g");
		while(list.size() > 0){
			System.out.print(list.getFirst()+" ");
			list.remove(0);
		}
	}
}

package Á´±í;

public class Test {
	public static void main(String[] args){
		MyLinkedList<String> ml = new MyLinkedList<String>();
		ml.add("a");
		ml.add("b");
		ml.add("c");
		ml.add("d");
		ml.add("e");
		for(int i=0;i<ml.length();i++){
			System.out.print(ml.get(i)+" ");
		}
	}
}

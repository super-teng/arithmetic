package Ô¼Éª·ò»·;


public class Test {
	public static class Node {
		public int a;
		public Node(int a){
			this.a = a;
		}
		public int getA() {
			return a;
		}
		public void setA(int a) {
			this.a = a;
		}
	}
	public static void main(String[] args){
		Node a = new Node(1);
		Node b = a;
		b.setA(2);
		System.out.println(a.a);
	}

}	

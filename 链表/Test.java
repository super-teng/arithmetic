package Á´±í;

public class Test {
<<<<<<< HEAD
	
	public int a(){
		try{
			int i = 1/0;
			return 1;
		}catch(Exception e){
			return 3;
		}finally{
			System.out.println("000");
		}
	}
	
	public static void main(String[] args){
		Test t = new Test();
		System.out.println(t.a());
=======
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
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
	}
}

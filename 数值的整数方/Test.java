package 数值的整数方;

public class Test {
	private static int number = 1;
	public void finalize(){
		System.out.println("回收了"+ number++ +"个对象");
	}
	public static void main(String[] args){
		int i = 1;
		while(true){
			Test t = new Test();
			System.out.println("创建了"+ i++ +"个对象");
			
		}
	}
}

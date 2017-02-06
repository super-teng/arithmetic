package Á´±í;

public class Test {
	
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
	}
}

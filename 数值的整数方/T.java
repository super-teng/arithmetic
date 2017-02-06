package 数值的整数方;

public class T {
	
	public int a(){
		try{
			return 1;
		}finally{
			return 2;
		}
	}
	public static void main(String[] args){
		T t = new T();
		System.out.println(t.a());
	}
}

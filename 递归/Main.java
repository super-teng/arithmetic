package µÝ¹é;

public class Main {
	//ÇónµÄ½×³Ë
	public int fact(int n){
		if(n == 1){
			return 1;
		}else{
			return n*fact(n-1);
		}
	}
	//ì³²¨ÄÇÆõ
	public int fibonacci(int n){
		if(n == 0){
			return 0;
		}else if(n == 1){
			return 1;
		}else{
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
	//ººÅµËþÎÊÌâ
	public void hanoi(int n , char x, char y ,char z){
		if(n == 1){
			System.out.println(x+" -->"+z);
		}else{
			hanoi(n-1,x,z,y);
			System.out.println(x+" -->"+z);
			hanoi(n-1,y,x,z);
		}
	}
	//ÓÃforÑ­»·À´Ïû³ýµÝ¹é
	public int fact02(int n){
		int sum = 1;
		for(int i = n;i>0;i--){
			sum *= i;
		}
		return sum;
	}
	public static void main(String[] args){
		Main m = new Main();
		System.out.println(m.fact(10));
		System.out.println(m.fibonacci(5));
		m.hanoi(3, 'X', 'Y', 'Z');
		System.out.println(m.fact02(10));
	}
}

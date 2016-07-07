package 哈希法;

public class Test02 {
	public static void main(String[] args){
		//我写了一个整型变量b 等于 1 ，
		int[] a = new int[1024];
		for(int i=0;i<a.length;i++){
			a[i] = i;
		}
		//用户说我要查 555 这个数值
		for(int i=0;i<a.length;i++){
			if(a[i] == 555){
				System.out.println("找到了！！！它的位置在 "+i);
				break;
			}
		}
	}
}

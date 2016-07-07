package 冒泡算法;

public class Test {
	public static void main(String[] args){
		int[] a = {9,2,6,6,6,0,3,7,8,4};
		
		for(int i=0;i<a.length;i++){	//冒泡算法的核心思路
			for(int j=a.length-1;j>i;j--){
				int temp = a[j];
				if(a[j]<a[j-1]){
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
		
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]);
		}
	}
}

package 希尔排序;

public class Main {
	
	public void sort(int[] array){
		//获取当前的一个增量
		int i = array.length>>1;
		//for(int i=array.length>>1;i>0;i=i>>1){
		while(i>0){
			for(int z = 0;z<i;z++){
				for(int j=z;j<array.length;j+=i){
					int temp = array[j];
					int flag = j;
					while(flag>=i && temp<array[flag-i]){
						int t = array[j];
						array[j] = array[j-i];
						array[j-i] = t;
						flag = flag-i;
					}
				}
			}
			i=i>>1;
		}
		//}
	}
	
	public static void main(String[] args){
		int[] array = {41,532632,62,1,14,52,53,63,63,63,52,414,0,653,3,1,2};
		Test.shell_Sort(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
}

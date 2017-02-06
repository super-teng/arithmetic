package 计数排序;


public class CountSort {
	
	public static void countSort(int[] data,int max){
		int[] count = new int[max+1];
		//进行计数操作
		for(int i=0;i<data.length;i++){
			count[data[i]] += 1;
		}
		int temp = 0;
		for(int i=0;i<count.length;i++){
			while(count[i] != 0){
				data[temp++] = i;
				count[i] --;
			}
		}
	}
	
	public static void main(String[] args){
		int[] data = {52,41,265,1,42,3,6,57,35,35,0};
		countSort(data,265);
		for(int i=0;i<data.length;i++){
			System.out.print(data[i] + " ");
		}
		
	}
}

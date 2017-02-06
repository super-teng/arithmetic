package ≤Â»Î≤È’“;

public class Test02 {
	public void InSort(int[] array){
		for(int i=1;i<array.length;i++){
			int j =i-1;
			int num = array[i];
			while(j>=0 && num<array[j]){
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = num;
		}
	}
	
	
	public static void main(String[] args){
		int[] array = {100,88,56,99,22,0,11,31,24};
		Test02 tt = new Test02();
		tt.InSort(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
}

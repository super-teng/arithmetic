package Ï£¶ûÅÅÐò;

public class ShellSort {
	public void sort(int[] array){
		for(int i=array.length/2;i>0;i>>=1){
			for(int t = 0;t<i;t++){
				for(int j=t;j<array.length;j+=i){
					int temp = array[j];
					int index = j;
					while(index>=i && temp < array[index-i]){
						array[index] = array[index - i];
						index -= i;
					}
					array[index] = temp;
				}
			}
		}
	}
	public static void main(String[] args){
		ShellSort ss = new ShellSort();
		int[] array = {25,13,2,63,41,1,11,42,532,42135,41213,453};
		ss.sort(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
}

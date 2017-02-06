package ²åÈëÅÅĞò.´øÉÚ±ø;

public class Insert {
	
	/**
	 * @param array
	 */
	public void sort(int[] array){
		for(int i=2;i<array.length;i++){
			int index = i;
			array[0] = array[i];//ÉÚ±øÔªËØ
			while(array[index-1] > array[0]){
				array[index] = array[index-1];
				index--;
			}
			if(index != i){
				array[index] = array[0];
			}
		}
	}
	
	public static void main(String[] args){
		Insert insert = new Insert();
		int[] array = {0,1,3,43,42,42,2,51,52,13,25};
		insert.sort(array);
		for(int i=1;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
}

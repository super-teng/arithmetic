package ÕÛ°ë²åÈëÅÅĞò;

public class Main {
	
	public void sort(int[] array){
<<<<<<< HEAD
		// 7 3 2 8 1
		// 2 3 7 8 1
=======
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
		for(int i=1;i<array.length;i++){
			if (array[i] < array[i - 1]) {
				int left = 0;
				int right = i;
<<<<<<< HEAD
//				int middle = 0;
				int t = array[i];
				while(left <= right){
					int middle = (left+right)/2;
=======
				int middle = 0;
				int t = array[i];
				while(left <= right){
					middle = (left+right)/2;
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
					if(array[middle] > t){
						right = middle - 1; 
					}else{
						left = middle+1;
					}
				}
				for(int j = i;j>left;j--){
					array[j] = array[j-1];
				}
				array[left] = t;
			}
		}
	}
	
	public static void main(String[] args){
<<<<<<< HEAD
		int[] a = {2,414,5,53,24,24,653,24,42,431,41,5353,0,0,0,0};
=======
		int[] a = {2,414,5,53,653,24,42,431,41,5353,0};
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
		Main m = new Main();
		m.sort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
}

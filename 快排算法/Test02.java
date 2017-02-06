package ¿ìÅÅËã·¨;

public class Test02 {

	public void quick_sort(int[] target, int left, int right) {
		if (left < right) {
			int i = left;
			int j = right;
			int t = target[left];
			while (i < j) {
				while (i < j && t <= target[j]) {
					j--;
				}
				if (i < j) {
					target[i] = target[j];
					i++;
				}
				while (i < j && t > target[i]) {
					i++;
				}
				if (i < j) {
					target[j] = target[i];
					j--;
				}
			}
			target[i] = t;
			quick_sort(target, left, i - 1);
			quick_sort(target, i + 1, right);
		}
	}
	public static void main(String[] args){
		int[] target = {3,5,1,6,2,7,4,9,8,0};
		Test02 tt = new Test02();
		tt.quick_sort(target, 0, target.length-1);
		for(int i=0;i<target.length;i++){
			System.out.print(target[i]+"  ");
		}
	}
}
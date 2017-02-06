package 冒泡算法;

//双向冒泡排序
public class Test02 {
	public static void main(String[] args) {
		Test02 tt = new Test02();
		int[] array = { 131, 42, 525, 5221, 4, 15, 53, 63, 1, 53 };
		tt.sort(array);
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	// 左右两个指针，第一趟是从左向右排序修改right指针指向，第二趟是从右向左排序修改left指针指向
	// 之后同理，终止条件是left与right不满足left<right跳出循环整个数组有序。
	public void sort(int[] array) {
		int left = 0;
		int right = array.length - 1;
		int temp = 0;
		while (left < right) {
			for (int i = left; i < right; i++) {
				if (array[i] > array[i + 1]) {
					array[i] = array[i] ^ array[i + 1];
					array[i + 1] = array[i] ^ array[i + 1];
					array[i] = array[i] ^ array[i + 1];
					temp = i;
				}
			}
			right = temp;
			for (int i = right; i > left; i--) {
				if (array[i] < array[i - 1]) {
					array[i] = array[i] ^ array[i - 1];
					array[i - 1] = array[i] ^ array[i - 1];
					array[i] = array[i] ^ array[i - 1];
					temp = i;
				}
			}
			left = temp;
		}
	}
}

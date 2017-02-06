package 插入查找;

public class Test {
	public static void InsertSort(int[] array) {
		// 从数组的第二个元素开始循环将数组中的元素插入
		for (int i = 1; i < array.length; i++) {

			// 设置数组中的第2个元素为第一次循环要插入的数据
			int insertNote = array[i];
			int j = i - 1;
			while (j >= 0 && insertNote < array[j]) {
				// 如果要播讲的元素小于第j个元素,就将第j个元素向后移动
				array[j + 1] = array[j];
				j--;
			}
			// 直到要插入的元素不小于第j个元素,将insertNote插入到数组中
			array[j + 1] = insertNote;

		}
	}

	public static void main(String[] args) {
		int[] array = { 8, 9, 7 };
		Test.InsertSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}

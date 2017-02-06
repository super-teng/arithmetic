package 堆排序;

public class HeapSort {
	
	//堆排序的方法
	public static void heapSort(int[] array){
		//对传入的数组进行一个堆结构的初始化
		buildMaxHeap(array);
		//对这个堆进行堆排序，把根元素与最后一个元素进行交换 
		//之后在对除根元素外的所有元素进行堆数据结构的调整
		for(int i = array.length-1;i>=1;i--){
			array[i] = array[i]^array[0];
			array[0] = array[i]^array[0];
			array[i] = array[i]^array[0];
			maxHeap(array,i,0);
		}
		
	}
	
	public static void buildMaxHeap(int[] array){
		//从堆数组中间进行建立
		int half = array.length/2;
		for(int i=half;i>=0;i--){
			//调用建立堆结构的方法对其进行堆结构的建立
			maxHeap(array,array.length,i);
		}
	}
	//构建大根堆
	public static  void maxHeap(int[] array,int heapSize,int index){
		//左右孩子 及最大元素索引
		int left = index*2+1;
		int right = index*2+2;
		int largest = index;
		//如果左孩子大于根节点 并且左孩子小于堆长度 则使最大索引等于左孩子
		if(left<heapSize && array[left]>array[index]){
			largest = left;
		}
		//如果右孩子大于最大索引节点 并且右孩子小于堆长度 则使最大索引等于右孩子
		if(right<heapSize && array[right]>array[largest]){
			largest = right;
		}
		//假如当前根节点不是最大的索引 
		if(index != largest){
			//则让根节点与最大的索引元素进行交换
			array[largest] = array[largest]^array[index];
			array[index] = array[largest]^array[index];
			array[largest] = array[largest]^array[index];
			//然后在对最大索引处 的子树递归进行构建大根堆
			maxHeap(array,heapSize,largest);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {87,65,67,85,26,41,16,73,438,95,73,51,0};
		
		HeapSort.heapSort(array);
		
		for(int i =0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
}

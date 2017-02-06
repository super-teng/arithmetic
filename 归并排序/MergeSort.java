package 归并排序;
//归并排序
public class MergeSort {
										// 0   3
	public static void sort(int[] array,int i,int j){ // 1 2 3 4
		//对其进行排序处理
		if(i<j){
			//对其进行分解处理底层拆分成单个元素的有序表进行两两归并
			int middle = (i+j)/2;
			sort(array,i,middle-1);
			sort(array,middle+1,j);
			merge(array,i,middle,j);
		}
	}

	public static void merge(int[] array,int i,int middle,int j){
		//左有序表的起始索引
		int left = i;
		//右有序表的起始索引
		int right = middle+1;
		//临时存储数组的索引
		int index = i;
		//临时存储数组
		int[] temp = new int[array.length];
		//把两个有序表按照升序排列，如果长度不同则长度有序表元素有剩余
		while(left<=middle && right<=j){
			
			if(array[left]<=array[right]){
				temp[index++] = array[left++];
			}else{
				temp[index++] = array[right++];
			}
		}
		//当左有序表元素有剩余的时候给与赋值
		while(left<=middle){
			temp[index++] = array[left++];
		}
		//当右有序表元素有剩余的时候给与赋值
		while(right<=j){
			temp[index++] = array[right++];
		}
		//把临时的数组元素赋予给真正变化的数组
        while(i<=j)
        {
            array[i]=temp[i++];
        }
	}
	
	public static void main(String[] args){
		int[] array = {13,42,52,25,63,1,2,35,7,9};
		
		System.out.println("归并排序前：");
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		System.out.println("归并排序后：");
		sort(array, 0, array.length-1);		
		
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
}

package 插值查找;

//思路：对有序数组进行查找操作，查找的位置索引为一个关键字预期的分布值
//查找中间点的算法为  
//(待查关键字-当前判断中最小关键字)*(最大索引-最小索引)/(当前判断最大关键字-当前判断最小关键字)
//因为涉及到除法，所以当最大和最小值相同的时候需要进行一下判断，如果当前值正好等于待查元素则直接返回，
//否则当前待查元素不存在

public class Main {
	
	public int search(int[] array,int key){
		if(array == null || array.length == 0 ){
			return -1;
		}
		int low = 0;
		int high = array.length-1;
		int mid = 0;
		while(low <= high && key>= array[low] && key <=array[high]){
			if(low == high){
				if(array[low] == key){
					return low;
				}else{
					return -1;
				}
			}else{
				mid = low + (key-array[low])*(high-low)/(array[high] - array[low]);
				if(key > array[mid]){
					low = mid+1;
				}else if(key < array[mid]){
					high = mid-1;
				}else{
					return mid;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] array = {12,24,36,47,58,79,80};
		Main m = new Main();
		int result = m.search(array, 80);
		System.out.println(result);
	}
	
}

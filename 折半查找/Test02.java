package 折半查找;

public class Test02 {
	
	public static int halfSort(int[] data,int key){
		int left = 0;//左标记
		int right = data.length-1;//右标记
		int result = -1;
		while(left<=right){	//进行中间判断
			int half = (left+right)/2;
			if(data[half] == key){
				result = half;
				break;
			}else if(data[half] < key){
				left = half;
			}else{
				right = half;
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		int[] number = {1,2,3,4,5,6,7,8,9,10};
		int key = 6;
		int result = Test02.halfSort(number, key);
		if(result == -1){
			System.out.println("当前数据不存在");
		}else{
			System.out.println(result);
		}
	}
}

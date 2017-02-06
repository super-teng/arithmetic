package 直接选择排序;

public class Test {
	
	public void select_Sort(int[] array){//4,3,52,63,14,13,0,1,9,88
		//对数组进行轮询查找最小元素
		for(int i=0;i<array.length;i++){
			//临时变量存储当前array[i] 并作为下面比较的判定标示
			int temp = array[i];
			//当前轮询中最小元素的索引
			int index = i;
			//进行比较
			for(int j=i;j<array.length-1;j++){
				//看后一个元素是否小于临时变量 如果小于则让临时变量等于它 
				//并让标示索引等于当前元素的索引
				if(array[j+1]<temp){
					temp = array[j+1];
					index = j+1;
				}
			}
			//交换当前初始元素与当前轮询中的最小元素
			array[index] = array[i];
			array[i] = temp;
		}
	}
	
	public void test(){
		int d = 1;
		synchronized("a"){
			int a = 1;
			int b = 1;
			int c = a+b;
			System.out.println(c);
		}
	}
	public static void main(String[] args){
		//测试数据
		int[] array = {4,3,52,63,14,13,0,1,9,88};
		Test tt = new Test();
		tt.select_Sort(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println("----------------");
		System.out.println(2 | 2);
		System.out.println(2 ^ 2);
	}
}

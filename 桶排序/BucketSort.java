package 桶排序;

public class BucketSort {
	
	public static void main(String[] args){
		
		int[] data = {5,999,6,42,1,1,1,8};
		int[] data1 = {5,999,6,42,1,1,1,8};
		System.out.println("排序前");
		print(data);
		bestBucketsSort(data, 1000);
		System.out.println("最好情况排序后");
		print(data);
		System.out.println("一般情况排序后");
		normalBucketSort(data1,1000);
		print(data1);
	}
	
	//定义一个桶类
	public static class Bucket{
		private int data;//当前桶中的数据
		private Bucket next;//桶中当前数据的下一个
		
		public Bucket(){
			
		}
		public Bucket(int data, Bucket next){
			this.data = data;
			this.next = next;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Bucket getNext() {
			return next;
		}
		public void setNext(Bucket next) {
			this.next = next;
		}
	}
	
	//桶排序最好情况的模拟 让桶的个数M与待排数据量相同
	public static void bestBucketsSort(int[] data,int max){
		//桶的个数范围到当前最大数字的值
		Bucket[] buckets = new Bucket[max];
		for(int i=0;i<max;i++){
			buckets[i] = new Bucket(0,null);
		}
		//为每一个值进行赋值到相应桶中，放到相应的索引位置上
		for(int i=0;i<data.length;i++){
			if(buckets[data[i]].getData() == 0){
				buckets[data[i]].setData(1);
			}else{
				//假如当前有下一个的时候
				Bucket temp = buckets[data[i]];
				//判断什么时候下一个为空，把当前数值给插入进去
				while(temp.getNext()!=null){
					temp = temp.getNext();
				}
				Bucket b = new Bucket();
				b.setData(1);
				temp.setNext(b);
			}
		}
		//用于规划data中索引位置
		int temp = 0;
		for(int i=0;i<buckets.length;i++){
			//假如当前桶有值则把桶中的值加入回去
			if(buckets[i].getData() == 1){
				data[temp++] = i;
				//假如有多个相同元素则继续添加
				while(buckets[i].getNext() != null){
					data[temp++] = buckets[i].getNext().getData();
					buckets[i].setNext(buckets[i].getNext().getNext());
				}
			}
		}
	}
	//桶排序一般情况的模拟
	public static void normalBucketSort(int[]data,int max){
		//创建桶的个数为最大树的十分之一
		Bucket[] buckets = new Bucket[max/10];
		for(int i=0;i<buckets.length;i++){
			buckets[i] = new Bucket(0,null);
		}
		//把当前数据添加进桶的过程
		for(int i=0;i<data.length;i++){
			//假如当前桶没有数据
			if(buckets[data[i]/10].getData() == 0){
				buckets[data[i]/10].setData(data[i]);
			//否则则向后寻找添加进去
			}else{
				Bucket temp = buckets[data[i]/10];
				//假如当前桶的下一个节点有值继续寻找
				while(temp.getNext()!=null){
					temp = temp.getNext();
				}
				//添加进去
				Bucket b = new Bucket(data[i],null);
				temp.setNext(b);
			}
		}
		//数组索引的位置
		int temp = 0;
		//赋值回去的过程
		for(int i=0;i<buckets.length;i++){
			if(buckets[i].getData() != 0){
				data[temp++] = buckets[i].getData();
				//假如当前数组中值不为空的话
				if(buckets[i].getNext()!=null){
					int[] result = bubbleSort(buckets[i].getNext());
					for(int j=0;i<result.length;i++){
						data[temp++] = result[j];
					}
				}
				
			}
		}
	}
	//冒泡排序用来排序同一个桶中的数据
	public static int[] bubbleSort(Bucket b){
		//把当前桶中所有数值存储到一个数组中
		int[] data = new int[1024];
		int index = 0;
		while(b!=null){
			data[index++] = b.getData();
			b = b.getNext();
		}
		//冒泡排序
		for(int i=0;i<index;i++){
			for(int j = index-1;j>i;j--){
				int temp = data[j];
				if(temp < data[j-1]){
					data[j] = data[j-1];
					data[j-1] = temp;
				}
			}
		}
		int[] result = new int[index];
		for(int i=0;i<index;i++){
			result[i] = data[i];
		}
		return result;
	}
	//输出
	public static void print(int[] data){
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
}

package 插入排序;

public class InsertSort {
	
	public static void sort(int[] data){
		for(int i = 1;i<data.length;i++){
			//用做一个中间的变量来替代当前插入的值做操作
			int temp = data[i];
			//用来当做比较标示索引
			int index = i;
			while(index>=1 && temp<data[index-1]){
<<<<<<< HEAD
				//后面的值等于前面一个
				data[index] = data[index-1];
				index--;
			}
			data[index] = temp; 
=======
				//二者进行交换
				data[index] = data[index]^data[index-1];
				data[index-1] = data[index]^data[index-1];
				data[index] = data[index]^data[index-1];
				//再与前面一个元素进行比较
				index--;
			}

>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
		}
	}
	//输出
	public static void print(int[] data){
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+" ");
		}
	}
	public static void main(String[] args){
		int[] data = {24,53,64,7535,7,68746,35,24,0,1,1,2,3};
		InsertSort.sort(data);
		InsertSort.print(data);
	}
}

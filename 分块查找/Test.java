package 分块查找;

//思路：先对当前的数据进行分块处理建立一个索引表，每一块中的数据
//索引表中包含了当前块中的最大值，在查找确定元素的时候先找到确定的块
//之后再对块进行查找的过程
public class Test {
	private static int[] indexTable = new int[3];
	
	public static void initIndexTable(int[] data){
		int length = data.length/indexTable.length;
		int temp = data[0];
		int j = 0;
		for(int i=0;i<data.length-1;i++){
			if(i == length){
				indexTable[j] = temp;
				j++;
				temp = 0;
				length *= 2;
			}
			if(temp < data[i+1]){
				temp = data[i+1];
			}
		}
		indexTable[j] = temp;
		for(int i=0;i<indexTable.length;i++){
			System.out.print(indexTable[i]+" ");
		}
	}
	
	public void search(int[] data,int key){
		for(int i=0;i<indexTable.length;i++){
			
		}
	}
	public static void main(String[] args){
		int[] data = {12,42,53,64,72,1,53,63,2,63,41,63,41,653,777};
		Test.initIndexTable(data);
	}
}

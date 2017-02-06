package 洗牌;

import java.util.Scanner;

public class Main {
	
	public static void washPorker(int[] array){//对某一个牌洗多少次
		int[] temp = new int[array.length];
		int index = array.length-1;
		for(int i=array.length-1;i>=array.length/2;i--){
			temp[index--] = array[i];
			temp[index--] = array[i-array.length/2];
		}
		for(int i=0;i<array.length;i++){
			array[i] = temp[i];
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//当前有多少组数据
		for(int i=0;i<T;i++){ // 输入当前多少组的数据
			int n = sc.nextInt();//总共有多少张牌这是一半的数量
			int k = sc.nextInt();//要洗牌的次数
			int[] array = new int[2*n];//存牌的数组
			for(int j=0;j<n*2;j++){ 
				array[j] = sc.nextInt();
			}
			for(int t=0;t<k;t++){ //洗K次牌
				washPorker(array);
			}
			System.out.print(array[0]);
			for(int z = 1;z<n*2;z++){//输出
				System.out.print(" "+array[z]);
			}
			System.out.println();
		}
		sc.close();
	}
}

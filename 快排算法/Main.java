package 快排算法;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int N = sc.nextInt();// 当前数字的个数
			int maxValue = 10;
			int[] arrayWeight = new int[N + 1];
			int[] arrayValue = new int[N + 1];
			int[][] values = new int[N + 1][maxValue + 1];
			for (int i = 1; i < arrayWeight.length; i++) {
				arrayWeight[i] = sc.nextInt();
				arrayValue[i] = arrayWeight[i];
			}// 每个数字中存放的价值和重量赋值
			for (int i = 0; i <= N; i++)
				values[i][0] = 0;
			for (int i = 0; i <= maxValue; i++)
				values[0][i] = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= maxValue; j++) {
					if (arrayWeight[i] > j) {
						values[i][j] = values[i - 1][j];
					} else {
						values[i][j] = Math.max(values[i - 1][j
								- arrayWeight[i]]
								+ arrayValue[i], values[i - 1][j]);
					}
				}
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= maxValue; j++) {
				}
			}
			int[][] result = new int[values[0].length][values.length];
			for (int i = 0; i < values.length; i++) {
				for (int j = 0; j < values[0].length; j++) {
					result[j][i] = values[i][j];
				}
			}
			boolean flag = false;
			int r= 0;
			for(int i=1;i<result.length;i++){
				for(int j=1;j<result[0].length;j++){
					if(result[i][j] == i){
						flag = true;
						break;
					}
				}
				if(!flag){
					r = i;
					break;
				}else{
					flag = false;
				}
			}
			System.out.println(r);
		}
	}
}

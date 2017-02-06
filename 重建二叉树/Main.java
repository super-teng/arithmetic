package ÖØ½¨¶ş²æÊ÷;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int[] array = new int[31];
			int result = 0;
			array[0] = 1;
			array[1] = 1;
			int left = 0;
			int right = 0;
			for(int i=2;i<31;i++){
				array[i] = array[i-1]+array[i-2];
				if(array[i-1]<=n && array[i]>=n){
					left = array[i-1];
					right = array[i];
				}
			}
			result = n-left > right-n? right-n:n-left;
			System.out.println(result);
		}
	}
}

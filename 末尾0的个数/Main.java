package Ä©Î²0µÄ¸öÊý;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			BigInteger result = new BigInteger("1");
			for(int i = n;i>=1;i--){
				BigInteger temp = new BigInteger(String.valueOf(i));
				result = result.multiply(temp);
			}
			String s = result.toString();
			int count = 0;
			for(int i=s.length()-1;i>0;i--){
				if(s.charAt(i) == '0'){
					count++;
				}else{
					break;
				}
			}
			System.out.println(count);
		}
		sc.close();
	}
}

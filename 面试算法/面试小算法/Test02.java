package 面试小算法;

import java.util.Scanner;


//求高于平均分的学生学号及成绩
public class Test02 {
	public static void main(String[] args){
		int[] sno = new int[100];
		int[] gra = new int[100];
		int index = 0;
		Scanner sc = new Scanner(System.in);
		while(true){
			int number = sc.nextInt();
			if(number!=-1){
				sno[index] = number;
				gra[index] = sc.nextInt();
				index++;
			}else{
				break;
			}
		}
		System.out.println("index===="+index);
		int sum = 0;
		for(int i=0;i<index;i++){
			sum += gra[i];
		}
		for(int i=0;i<index;i++){
			if(gra[i]>(sum/index)){
				System.out.println("学号: "+sno[i]);
				System.out.println("成绩: "+gra[i]);
			}
		}
		System.out.println("平均成绩为: "+sum/index);
	}
}

package 内存管理问题;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int T = sc.nextInt();//操作次数
			int MaxMem = sc.nextInt();//初始化内存大小
			int[] memmary = new int[MaxMem];//内存大小 0为可用 1为不可用
			String[] array = new String[T];//T行操作指令
			for(int i =0;i<array.length;i++){//输入N行操作指令
				array[i] = sc.nextLine();
			}
			Map<Integer,Integer> map = new HashMap<Integer,Integer>();
			int count = 1;
			//具体的T行操作
			for(int i=0;i<array.length;i++){
				if(array[i].contains("new")){
					int number = Integer.parseInt(String.valueOf(array[i].charAt(4)));
					if(number <= MaxMem){
						int con = 0;//计数器
						int index = 0;//内存数组下表
						boolean flag = false;
						for(int j = 0;j<memmary.length;j++){
							if(con == number){
								flag = true;
								break;
							}else{
								if(memmary[index] == 0){
									con++;
									index++;
									memmary[index] = 1;
								}else{
									j = index;
								}
							}
						}
						if(flag){
							System.out.println(count);
							MaxMem -= number;
							map.put(count, number);
							count++;
						}else{
							for(int m = 0;m<memmary.length;m++){
								memmary[m] = 0;
							}
							System.out.println("null");
						}
						
					}else{
						System.out.println("null");
					}
				}
				if(array[i].contains("del")){
					//待完善
					int number = Integer.parseInt(String.valueOf(array[i].charAt(4)));
					if(map.get(number) != null){
						MaxMem += map.get(number);
					}else{
						System.out.println("ILLEGAL_OPERATION");
					}
				}
				if(array[i].contains("def")){
					int[] tt = new int[MaxMem];
					int cc = 0;
					for(int k=0;k<tt.length;k++){
						if(memmary[k] != 0){
							tt[cc++] = 1;
						}
					}
					for(int z=0;z<tt.length;z++){
						memmary[z] = tt[z];
					}
				}
			}
		}
		sc.close();
	}
}

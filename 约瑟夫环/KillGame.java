package 约瑟夫环;

import 约瑟夫环.MyLinkedList.Place;

public class KillGame {
	//引入循环链表
	public MyLinkedList mll = new MyLinkedList();
	//根据人数初始化链表
	public void initList(int number){
		for(int i=0;i<number;i++){
			mll.add("位置"+(i+1));
		}
	}
	
	public static void main(String[] args){
		KillGame kg = new KillGame();
		//初始化了41个人
		kg.initList(41);
		//计数的标志
		int index = 1;
		//报数位置 初始的时候指向头
		Place p = kg.mll.header;
		//开始杀人游戏
		while(kg.mll.size()>2){
			//假如当前报数位置指向了header节点让其自动移到下一位
			if(p == kg.mll.header){
				p = p.getAfter();
			}
			//假如当前计数为报数的第三个人就杀死他
			if(index%3==0){
				System.out.println(p.getPlace()+"已死亡");
				kg.mll.remove(p);
				p = p.getAfter();
				//否则继续向下进行报数
			}else{
				p = p.getAfter();
			}
			//记数号+1
			index++;
		}
		//当前节点为3个时候跳出循环包含两个幸存者和一个header节点
		System.out.println();
		System.out.println("幸存者所在位置"+kg.mll.get(1).getPlace());
		System.out.println("幸存者所在位置"+kg.mll.get(2).getPlace());
		
	}
}

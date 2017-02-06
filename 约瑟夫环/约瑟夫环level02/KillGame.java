package 约瑟夫环.约瑟夫环level02;

import 约瑟夫环.约瑟夫环level02.KillLinkedList.Place;


public class KillGame {
	public static KillLinkedList kll = new KillLinkedList();
	
	//初始化约瑟夫环
	public static void init(int number){
		for(int i=1;i<=number;i++){
			kll.add("位置"+i);
		}
	}
	
	public static void main(String[] args){
		int person = 41;
		//初始化所有的人数
		init(person);
		//指向头节点
		Place temp = kll.getHeader();
		//当前的位置索引
		int index = 1;
		//当前人数大于2的时候执行杀人游戏
		while(kll.size()>2){
			//如果当前标示为头节点的话自动跳到下一个去
			if(temp == kll.getHeader()){
				temp = temp.getAfter();
			}
			if(index %3 ==0){
				System.out.println(temp.getPlace()+"已死亡");
				kll.remove(temp);
			}
			//当前节点指向下一个
			temp = temp.getAfter();
			//当前索引号加一
			index++;
		}
		System.out.println("幸存者是"+kll.get(1).getPlace());
		System.out.println("幸存者是"+kll.get(2).getPlace());
	}
}

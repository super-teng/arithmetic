package 约瑟夫环.约瑟夫环level02;

public class PerfactCircle {
	public static class Node{
		private int value;
		public Node next;
		public Node(int value){
			this.value = value;
		}
		public Node(){
			
		}
	}
	public static void main(String[] args){
		int person = 41;//环人数的总和
		int l = 3;//每间隔多少出去一人
		Node header = new Node(1);//头结点
		Node operator = header;//实际进行操作的节点
		//构建一个单循环链表
		for(int i=2;i<=person;i++){
			//操作节点的下一个依次串线
			operator.next = new Node(i);
			//让当前操作节点一直是最后一个
			operator = operator.next;
		}
		//循环回来最后一个节点等于头结点
		operator.next = header;
		//进行最后幸存一人的判断
		// 16 31
		while(operator != operator.next){
			//每隔L间隔进行移除
			for(int i=1;i<l;i++){
				operator = operator.next;
				//System.out.println("temp = "+temp.value+" operator = "+operator.value);
			}
			System.out.println("位置"+operator.next.value+"移除了");
			operator.next = operator.next.next;
		}
		System.out.println("最后幸存的位置是"+operator.value);
	}
}

package 栈的实现.链式;

public class Main {
	
	public LinkedList top; //全局变量指针
	
	//每个链节点
	public class LinkedList{
		public int data;
		public LinkedList next;
	}
	//初始化第一个指针指向空
	public LinkedList LinkedListInit(){
		top = null;
		return top;
	}
	//判断栈空
	public boolean LinkedListEmpty(){
		if(top == null){
			return true;
		}else{
			return false;
		}
	}
	//入栈
	public void LinkedStackPush(int number){
		//创建相应节点把next赋为之前top节点所指，并把top指向新插入节点
		LinkedList temp = new LinkedList();
		temp.data = number;
		temp.next = top;
		top = temp;
	}
	//出栈
	public int LinkedStackPop(){
		if(top == null){
			return -1;//当前栈空的错误标志
		}else{
			int result = top.data;
			top = top.next;
			return result;
		}
	}
	//取栈顶元素
	public int LinkedStackTop(){
		if(top == null){
			return -1;//当前栈空的错误标志
		}else{
			return top.data;
		}
	}
	//清空当前栈
	@SuppressWarnings("unused")
	public void LinkedListClean(){
		while(top != null){
			LinkedList temp = top;
			temp = null;
			top = top.next;
		}
	}
	//栈元素个数
	public int LinkedListSize(){
		if(top == null){
			return -1;//当前栈空的错误标志
		}else{
			int count = 0;
			LinkedList temp = top;
			while(temp != null){
				count++;
				temp = temp.next;
			}
			return count;
		}
	}
	
	public static void main(String[] args){
		Main m = new Main();
		m.LinkedListInit();//初始化方法
		System.out.println(m.LinkedListEmpty());//判断栈是否为空
		m.LinkedStackPush(10);//添加元素
		m.LinkedStackPush(20);
		System.out.println(m.LinkedListSize());//求长度
		System.out.println(m.LinkedStackPop());//出栈
		System.out.println(m.LinkedListSize());//求长度
		System.out.println(m.LinkedListEmpty());//判断栈是否为空
		System.out.println(m.LinkedStackTop());//求栈顶元素
		m.LinkedListClean();//清空当前栈
		System.out.println(m.LinkedListSize());//求长度
		System.out.println(m.LinkedListEmpty());//判断栈是否为空
	}
}	

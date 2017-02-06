package 队列.链式;

public class Main {
	public class Node {
		public int data;
		public Node next;
	}

	private Node front;// 头指针
	private Node rear;// 尾指针

	private Node linkedList; // 全局操作链表

	// 初始化的方法
	public void init() {
		// 创建一个空链表让front 和rear指向这个头结点,头结点中不存储信息
		linkedList = new Node();
		front = linkedList;
		rear = linkedList;
	}

	// 入队
	public void push(int number) {
		Node n = new Node();
		n.data = number;
		n.next = null;
		// 将当前的末尾结点指向最后新插入的节点位置
		rear.next = n;
		rear = n;
	}

	// 判断当前队列是否为空
	public boolean isEmpty() {
		if (front == rear) {
			return true;
		} else {
			return false;
		}
	}

	// 出队
	public int pop() {
		if (front == rear) {
			return -1; // 当前元素为空还要出栈的错误编号
		} else {
			Node result = front.next;// 即将出队的元素指针
			front.next = result.next;// 将头结点指针指向出队的下一个
			// 判断当前队列是否只有一个元素，如果只有一个的话rear也需要进行修改
			if (front.next == null) {
				rear = front; // 变成了空队列了
			}
			return result.data;
		}
	}
	//求当前队列中元素个数
	public int length(){
		Node temp = front.next;
		int count = 0;
		while(temp!=null){
			count++;
			temp = temp.next;
		}
		return count;
	}
	@SuppressWarnings("unused")
	//将当前队列置空
	public void clean(){
		Node temp = front.next;
		Node temp2 = temp;
		while(temp != null){
			temp = temp.next;
			temp2 = null;//将当前节点置空
		}
		rear = front;
	}
	public static void main(String[] args){
		Main m = new Main();
		m.init();
		m.push(1);
		m.push(2);
		m.push(3);
		System.out.println(m.length());
		m.pop();
		m.pop();
		m.pop();
		System.out.println(m.isEmpty());
		m.push(1);
		m.push(2);
		m.push(3);
		m.clean();
		System.out.println(m.isEmpty());
	}
}

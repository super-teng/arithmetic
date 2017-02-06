package 队列;

public class Main {

	private static final int MaxSize = 100;

	public class Sequeue {
		public int[] data = new int[MaxSize];
		public int front;// 前面的指针
		public int rear;// 后面的指针
	}

	private Sequeue s;// 操作的全局变量队列

	// 初始化方法
	public void init() {
		s = new Sequeue();
		s.front = -1;
		s.rear = -1;// 初始状态下指向-1位置
	}

	// 入队
	public void sequeueIn(int number) {
		// 因为当前操作的是循环队列所以这样取余进行操作
		if ((s.rear + 1) % MaxSize == s.front) {
			System.out.println("当前队列已满");
			return;
		} else {
			s.rear = (s.rear + 1) % MaxSize;
			s.data[s.rear] = number;
		}
	}

	// 出队
	public int sequeueOut() {
		// 为什么要进行+1操作是因为当前队列是一个循环队列，中间保留了一个空元素未进行操作，
		// 默认让front指向了这个指向为空的元素位置
		if (s.rear == s.front) {
			System.out.println("当前队列为空");
			return -1; // 当前队列为空的错误返回标记
		} else {
			s.front = (s.front + 1) % MaxSize;
			return s.data[s.front];
		}
	}

	// 判断队列是否为空
	public boolean sequeueEmpty() {
		if (s.front == s.rear) {
			return true;
		} else {
			return false;
		}
	}

	// 求队列中元素个数
	public int sequeueLength() {
		return (s.rear - s.front + MaxSize) % MaxSize;
	}
	public static void main(String []args){
		Main m = new Main();
		m.init();
		m.sequeueIn(1);
		m.sequeueIn(2);
		m.sequeueIn(3);
		System.out.println(m.sequeueLength());
		m.sequeueOut();
		m.sequeueOut();
		m.sequeueOut();
		System.out.println(m.sequeueEmpty());
	}
}

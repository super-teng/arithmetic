package 十字链表;

public class Main {

	private HeadNode[] headNode; // 存储头节点的数组

	// 顶点
	public class HeadNode {
		public char data; // 根节点中存储的信息
		public NextNode firstIn; // 以该节点为弧头的第一个节点
		public NextNode firstOut;// 以该节点为弧尾的第一个节点

		public HeadNode(char data, NextNode firstIn, NextNode firstOut) {
			this.data = data;
			this.firstIn = firstIn;
			this.firstOut = firstOut;
		}
	}

	// 弧节点
	public class NextNode {
		public int tvex; // 当前弧尾的起始位置
		public int hvex;// 当前弧头的终止位置
		public NextNode hlink;// 当前弧尾所连的下一条弧
		public NextNode tlink; // 当前弧头的下一条弧
		public int info; // 当前弧所携带的信息比如权值

		public NextNode(int hvex, int tvex, NextNode hlink, NextNode tlink,
				int info) {
			this.hvex = hvex;
			this.tvex = tvex;
			this.hlink = hlink;
			this.tlink = tlink;
			this.info = info;
		}

	}

	// 初始化节点数组
	public void initNode(char[] node) {
		if (node == null) {
			return;
		}
		this.headNode = new HeadNode[node.length];
		for (int i = 0; i < node.length; i++) {
			HeadNode temp = new HeadNode(node[i], null, null);
			headNode[i] = temp;
		}
	}

	// 初始化整个十字链表
	public void initEdge(char[][] edgs) {
		if (edgs == null) {
			return;
		}// 健壮性判断
		for (int i = 0; i < edgs.length; i++) {
			// 获取起始和终止结点位置
			int begin = getPosition(edgs[i][0]);
			int end = getPosition(edgs[i][1]);
			// 创建下一节点元素
			NextNode temp = new NextNode(begin, end, null, null, 0);
			// 以该弧的弧头为弧头的下一条弧 ,也就是当前节点前驱的下一条弧
			temp.hlink = headNode[begin].firstIn;
			// 以该弧的弧尾为弧尾的下一条弧，也就是当前节点的下一条弧
			temp.tlink = headNode[end].firstOut;
			// 修改顶点数组中的两属性值
			headNode[begin].firstIn = temp;
			headNode[end].firstOut = temp;
		}

	}

	// 找到当前元素位置的方法
	public int getPosition(char node) {
		int index = -1;
		for (int i = 0; i < headNode.length; i++) {
			if (headNode[i].data == node) {
				index = i;
				break;
			}
		}
		return index;
	}

	public void print() {
		System.out.println("邻接表的情况");
		for (int i = 0; i < headNode.length; i++) {
			NextNode temp = headNode[i].firstIn;
			if(temp == null){
				System.out.println(headNode[i].data+"---->"+"null");
				continue;
			}
			while(temp!= null){
				System.out.print(headNode[i].data+"---->"+headNode[temp.tvex].data+"  ");
				temp = temp.hlink;
			}
			System.out.println();
		}
		System.out.println("逆邻接表的情况");
		for(int i=0;i<headNode.length;i++){
			NextNode temp = headNode[i].firstOut;
			if(temp == null){
				System.out.println(headNode[i].data+"<----"+"null");
				continue;
			}
			while(temp!=null){
				System.out.print(headNode[i].data+"<----"+headNode[temp.hvex].data+" ");
				temp = temp.tlink;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		char[] node = { 'A', 'B', 'C', 'D', };
		char[][] edgs = new char[][] { 
				{ 'A', 'B' }, 
				{ 'A', 'D' },
				{ 'A', 'C' },
				{ 'B', 'C' }, 
				{ 'B', 'D' }, 
				{ 'C', 'D' }, };
		Main m = new Main();
		// 初始化头结点
		m.initNode(node);
		// 初始化弧节点
		m.initEdge(edgs);
		// 输出
		m.print();
	}
}

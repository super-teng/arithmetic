package 二叉树的三叉链表存储;

public class Main {
	// 节点的包装类
	public class Node {
		public int data;
		public Node left;
		public Node right;
		public Node father;

		public Node() {

		}

		public Node(int data, Node left, Node right, Node father) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.father = father;
		}
	}

	// 根节点
	private Node root;

	public void add(Node node) {
		// 健壮性判断
		if (node == null) {
			return;
		}
		// 如果当前为空树当前这个节点就是根节点左右孩子father均为null
		if (root == null) {
			root = node;
		} else {
			// 当前插入节点的父节点初始值为root
			Node father = root;
			// 当前插入节点位置初始值为root
			Node temp = root;
			// 判断当前节点是左孩子还是右孩子
			boolean flag = false;
			while (temp != null) {
				father = temp;
				// 比插入节点大和左孩子比较
				if (temp.data > node.data) {
					flag = false;// 左孩子
					temp = temp.left;
					// 比插入节点小和右孩子比较
				} else if (temp.data < node.data) {
					flag = true;// 右孩子
					temp = temp.right;
				} else {
					// 相等直接返回
					return;
				}
			}
			if (flag) {
				// 当前节点插入右孩子位置
				father.right = node;
				node.father = father;
			} else {
				// 当前节点插入左孩子位置
				father.left = node;
				node.father = father;
			}
		}
	}

	public void print(Node root) {
		if (root != null) {
			//当输出的时候直接使用三位运算符的时候一定要加上一个（）因为输出的时候会把三位运算符的整体性给破坏掉
			System.out.println("当前值为：" + root.data + " 父亲节点为："+ (root.father == null ? null: root.father.data));
			print(root.left);
			print(root.right);
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.add(m.new Node(10, null, null, null));
		m.add(m.new Node(7, null, null, null));
		m.add(m.new Node(13, null, null, null));
		m.add(m.new Node(3, null, null, null));
		m.add(m.new Node(8, null, null, null));
		m.add(m.new Node(11, null, null, null));
		m.add(m.new Node(16, null, null, null));
		m.add(m.new Node(1, null, null, null));
		m.add(m.new Node(9, null, null, null));
		m.print(m.root);
	}

}

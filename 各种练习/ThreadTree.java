package 各种练习;

public class ThreadTree {
	private Node root; // 根节点
	private int size; // 大小
	private Node pre = null; // 线索化的时候保存前驱

	public ThreadTree() {
		this.root = null;
		this.size = 0;
		this.pre = null;
	}

	public ThreadTree(int[] data) {
		this.pre = null;
		this.size = data.length;
		this.root = createTree(data, 1); // 创建二叉树
	}

	/**
	 * 创建二叉树
	 * 
	 */
	public Node createTree(int[] data, int index) {
		if (index > data.length) {
			return null;
		}
		Node node = new Node(data[index - 1]);
		Node left = createTree(data, 2 * index);
		Node right = createTree(data, 2 * index + 1);
		node.setLeft(left);
		node.setRight(right);
		return node;
	}

	/**
	 * 将以root为根节点的二叉树线索化
	 * 
	 */
	public void inThread(Node root) {
		if (root != null) {
			inThread(root.getLeft()); // 线索化左孩子
			if (null == root.getLeft()) // 左孩子为空
			{
				root.setLeftIsThread(true); // 将左孩子设置为线索
				root.setLeft(pre);
			}
			if (pre != null && null == pre.getRight()) // 右孩子为空
			{
				pre.setRightIsThread(true);
				pre.setRight(root);
			}
			pre = root;
			inThread(root.getRight()); // 线索化右孩子
		}
	}

	/**
	 * 中序遍历线索二叉树
	 * 
	 */
	public void inThreadList(Node root) {
		if (root != null) {
			while (root != null && !root.isLeftIsThread()) // 如果左孩子不是线索
			{
				root = root.getLeft();
			}

			do {
				System.out.print(root.getData() + ",");
				if (root.isRightIsThread()) // 如果右孩子是线索
				{
					root = root.getRight();
				} else // 有右孩子
				{
					root = root.getRight();
					while (root != null && !root.isLeftIsThread()) {
						root = root.getLeft();
					}
				}
			} while (root != null);
		}
	}

	/**
	 * 前序遍历递归算法
	 * 
	 */
	public void preList(Node root) {
		if (root != null) {
			System.out.print(root.getData() + ",");
			preList(root.getLeft());
			preList(root.getRight());
		}
	}

	/**
	 * 中序遍历
	 * 
	 */
	public void inList(Node root) {
		if (root != null) {
			inList(root.getLeft());
			System.out.print(root.getData() + ",");
			inList(root.getRight());
		}
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}

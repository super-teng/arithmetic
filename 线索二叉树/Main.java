package 线索二叉树;

/*
 * 在普通的二叉树中有近一半的指针出现了浪费，因为叶子节点的左右指针并没有指向任何的节点
 * 所以我们要考虑把这些节点给利用起来，当没有左孩子的时候我们就让lnode指针指向自己的前驱
 * 当没有右孩子的时候我们就让rnode指向自己的后驱。在初始化每个节点的时候添加两个标记字符
 * 当标记字符为1的时候说明当前的lnode和rnode分别指向自己的前驱和后继
 * 对当前树进行遍历的时候进行线索化
 */
public class Main {

	public class Node {
		public Node lNode;
		public Node rNode;
		public Node father;// 三叉链表
		public int data;
		public int ltag;// 左孩子的标记当没有左孩子的时候标记为1,有的时候标记为0不变
		public int rtag;// 右孩子的标记当没有右孩子的时候标记为1

		public Node(int data, Node lNode, Node rNode) {
			this.data = data;
			this.lNode = lNode;
			this.rNode = rNode;
		}
	}

	private Node root; // 根节点

	private Node pre;// 线索化时候所需的前一节点初始值为root

	// 普通的添加节点的方法
	public void add(Node node) {
		Node current = root;
		Node father = root;
		boolean flag = false;
		if (root == null) {
			root = node;
		} else {
			while (current != null) {
				father = current;
				if (current.data > node.data) {
					current = current.lNode;
					flag = false;
				} else if (current.data < node.data) {
					current = current.rNode;
					flag = true;
				} else {
					return;
				}
			}
			if (!flag) {
				father.lNode = node;
				node.father = father;
			} else {
				father.rNode = node;
				node.father = father;
			}
		}
	}

	// 先序遍历线索化的过程
	public void initDLR(Node node) {
		// 健壮性判断
		if (node == null) {
			return;
		} else {
			Node temp = node;// 操作变量
			// 假如当前节点左指针为空，则让左指针指向前驱,先序的前驱正好是pre节点
			if (temp.lNode == null) {
				temp.lNode = pre;
				temp.ltag = 1;
			}
			// 假如pre节点的右指针为空，则让其右指针指向后继，先序的后继正好是temp节点
			if (pre != null && pre.rtag == 1) {
				pre.rNode = temp;
			}
			// 让当前本次的循环就要把这次的标记修改，如果等到下一次的时候进行修改则会导致最后一个节点没有被修改
			if (temp.rNode == null) {
				temp.rtag = 1;
			}
			pre = temp;
			// 当前存在左孩子的时候在递归处理
			if (temp.ltag != 1) {
				initDLR(temp.lNode);
			}
			if (temp.rtag != 1) {
				initDLR(temp.rNode);
			}
		}
	}

	// 中序线索化二叉树的过程
	public void initLDR(Node node) {
		// 健壮性判断
		if (node == null) {
			return;
		} else {
			// 找到当前分支的最左端节点
			initLDR(node.lNode);
			// 假如左孩子为空
			if (node.lNode == null) {
				node.lNode = pre;
				node.ltag = 1;
			}
			// 假如右孩子为空
			if (pre != null && pre.rtag == 1) {
				pre.rNode = node;
			}
			if (node.rNode == null) {
				node.rtag = 1;
			}
			// 让pre等于node之后去轮询下面的节点
			pre = node;
			initLDR(node.rNode);
		}
	}

	// 后序线索化二叉树的过程
	public void initLRD(Node node) {
		// 健壮性判断
		if (node == null) {
			return;
		} else {
			// 找到当前最开始的节点
			initLRD(node.lNode);
			initLRD(node.rNode);
			// 假如左孩子为空
			if (node.lNode == null) {
				node.lNode = pre;
				node.ltag = 1;
			}
			// 假如pre的右孩子为空
			if (pre != null && pre.rtag == 1) {
				pre.rNode = node;
			}
			if (node.rNode == null) {
				node.rtag = 1;
			}
			// 赋值与当前节点相等
			pre = node;
		}
	}

	// 先序线索化二叉树查找某一节点前驱
	public Node search_DLR_Before(Node node) {
		// 健壮性判断
		if (node == null) {
			return null;
		} else {
			// 如果是根节点的话
			if (node == root) {
				return null;
			} else {
				// 如果有左孩子的话，前驱就是其父节点
				if (node.ltag == 0) {
					return node.father;
					// 当标志为1的时候这个时候left指针所指向就是前驱
				} else {
					return node.lNode;
				}
			}
		}
	}

	// 先序线索化二叉树查找某一节点后驱
	public Node search_DLR_After(Node node) {
		// 健壮性判断
		if (node == null) {
			return null;
		} else {
			// 如果当前有左孩子，左孩子就是当前节点的前驱，因为DLR的规律
			if (node.rtag == 0) {
				return node.lNode;
				// 当没有左孩子的时候这时候left指针指向的是前驱，right指针指向的是后继
			} else {
				return node.rNode;
			}
		}
	}

	// 中序遍历线索化二叉树查找某一节点前驱
	public Node search_LDR_Before(Node node) {
		if (node == null) {
			return null;
		} else {
			// 有左孩子的时候，前驱结点是左子树中的最右端元素 因为是LDR
			if (node.ltag == 0) {
				Node temp = node.lNode; // 临时变量hold住操作变量
				// 找到当前左子树中的最右端元素
				while (temp.rNode != null) {
					temp = temp.rNode;
				}
				return temp;
				// 当没有左孩子的时候，前驱结点直接就是left指针指向的元素
			} else {
				return node.lNode;
			}
		}

	}

	// 中序线索化二叉树找到某一节点的后继
	public Node search_LDR_After(Node node) {
		// 健壮性判断
		if (node == null) {
			return null;
		} else {
			// 如果右孩子存在，当前后继为右子树中最左端元素
			if (node.rtag == 0) {
				Node temp = node.rNode;
				// 找到当前右子树中的最左端元素
				while (temp.lNode != null) {
					temp = temp.lNode;
				}
				return temp;
				// 如果右孩子为空的话，right指针所指元素为后继
			} else {
				return node.rNode;
			}
		}
	}

	// 后序线索化二叉树找到某一节点的前驱
	public Node search_LRD_Before(Node node) {
		// 健壮性判断
		if (node == null) {
			return null;
		} else {
			// 假如当前节点有右孩子的话当前节点的右孩子就是当前节点的前驱因为LRD的原因
			if (node.rtag == 0) {
				return node.rNode;
				// 假如当前节点没有右孩子的话当前节点的left指针指向的就是前驱,此处不管left指针当前是否指向线索
			} else {
				return node.lNode;
			}
		}
	}

	// 后序线索化二叉树找到某一节点的后继
	public Node search_LRD_After(Node node) {
		// 健壮性判断
		if (node == null) {
			return null;
		} else {
			// 如果当前节点是根节点的话，则指向空
			if (node == root) {
				return null;
				// 如果当前节点是双亲节点的右孩子的话，他的后继就是当前节点的双亲节点
			} else if (node == node.father.rNode) {
				return node.father;
				// 如果当前节点是双亲节点的左孩子的话，且此时有右兄弟，则后继就是右子树中第一个遍历到的节点
			} else if (node == node.father.lNode && node.father.rNode != null
					&& node.father.rtag == 0) {
				// 找右子树中第一个遍历到的节点
				Node temp = node.father.rNode;
				while (temp.lNode != null && temp.ltag == 0) {
					temp = temp.lNode;
				}
				while (temp.rNode != null && temp.rtag == 0) {
					temp = temp.rNode;
				}
				return temp;
				// 如果当前节点是双亲节点的左孩子且无右兄弟，则其后继为双亲节点
			} else {
				return node.father;
			}
		}
	}

	// 先序遍历先序线索二叉树
	public void DLR(Node node) {
		Node temp = node;
		while (temp != null) {
			while (temp.ltag == 0) {
				System.out.print(temp.data + " ");
				temp = temp.lNode;
			}
			while (temp != null && temp.rtag == 1) {
				System.out.print(temp.data + " ");
				temp = temp.rNode;
			}
		}
	}

	// 中序遍历中序线索树
	public void LDR(Node node) {
		Node temp = node;
		while (temp != null) {
			while (temp.ltag == 0) {
				temp = temp.lNode;
			}
			System.out.print(temp.data + " ");
			while (temp != null && temp.rtag == 1) {
				temp = temp.rNode;
				// 防止没有后继节点出现空指针异常
				if (temp != null) {
					System.out.print(temp.data + " ");
				}
			}
			if (temp != null) {
				temp = temp.rNode;
			}
		}
	}

	public void print(Node node) {
		if (node != null) {
			if (node.ltag != 1) {
				print(node.lNode);
			} else {
				if (node.lNode != null) {
					System.out.println("前驱:" + node.lNode.data);
				}
			}
			if (node.father != null) {
				System.out.println(" 父节点是:" + node.father.data);
			}
			if (node.rtag != 1) {
				print(node.rNode);
			} else {
				if (node.rNode != null) {
					System.out.println("后驱:" + node.rNode.data);
				}
			}
			System.out.println("值:" + node.data);
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		Node n1 = m.new Node(5, null, null);
		Node n2 = m.new Node(3, null, null);
		Node n3 = m.new Node(7, null, null);
		Node n4 = m.new Node(2, null, null);
		Node n5 = m.new Node(4, null, null);
		Node n6 = m.new Node(6, null, null);
		Node n7 = m.new Node(8, null, null);
		m.add(n1);
		m.add(n2);
		m.add(n3);
		m.add(n4);
		m.add(n5);
		m.add(n6);
		m.add(n7);
		
//		//前序线索化 前序输出
//		m.initDLR(m.root);
//		System.out.println("前序遍历前序线索化树");
//		m.DLR(m.root);
//		System.out.println();
//		System.out.println("前序节点查找前驱和后继");
//		System.out.println("节点: "+n5.data+"前驱: "+m.search_DLR_Before(n5).data+" 后继: "+m.search_DLR_After(n5).data);
		
//		//中序线索化 中序输出
//		m.initLDR(m.root);
//		System.out.println("中序遍历中序线索化树");
//		m.LDR(m.root);
//		System.out.println();
//		System.out.println("中序节点查找前驱和后继");
//		System.out.println("节点: "+n5.data+"前驱: "+m.search_DLR_Before(n5).data+" 后继: "+m.search_DLR_After(n5).data);

		//后序线索化 
		m.initLRD(m.root);
		System.out.println("后序节点查找前驱和后继");
		System.out.println("节点: "+n5.data+"前驱: "+m.search_DLR_Before(n5).data+" 后继: "+m.search_DLR_After(n5).data);
	}
}

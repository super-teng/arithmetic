package 二叉查找树;

import java.util.LinkedList;
import java.util.Stack;

<<<<<<< HEAD
public class Test02 {
	public class Node {
		private int data;
		private Node lNode;
		private Node rNode;

		public Node() {

		}

		public Node(int data, Node lNode, Node rNode) {
=======
import 平衡二叉树.BalenceTree.Node;

public class Test02 {
	public class Node{
		private int data;
		private Node lNode;
		private Node rNode;
		public Node(){
			
		}
		public Node(int data,Node lNode,Node rNode){
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
			this.data = data;
			this.lNode = lNode;
			this.rNode = rNode;
		}
<<<<<<< HEAD

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getlNode() {
			return lNode;
		}

		public void setlNode(Node lNode) {
			this.lNode = lNode;
		}

		public Node getrNode() {
			return rNode;
		}

=======
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getlNode() {
			return lNode;
		}
		public void setlNode(Node lNode) {
			this.lNode = lNode;
		}
		public Node getrNode() {
			return rNode;
		}
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
		public void setrNode(Node rNode) {
			this.rNode = rNode;
		}
	}
<<<<<<< HEAD

	public Node root;

	public void add(int data) {

		Node node = new Node(data, null, null);
		Node current = root;
		Node father = root;

		boolean flag = false;
		if (root == null) {
			root = node;
		} else {
			while (current != null) {
				father = current;
				if (current.getData() > data) {
					current = current.getlNode();
					flag = false;
				} else if (current.getData() < data) {
					current = current.getrNode();
					flag = true;
				} else {
					return;
				}
			}
			if (!flag) {
				father.setlNode(node);
			} else {
=======
	public Node root;
	public void add(int data){
		
		Node node = new Node(data,null,null);
		Node current = root;
		Node father = root;
		
		boolean flag = false;
		if(root == null){
			root = node;
		}else{
			while(current != null){
				father = current;
				if(current.getData() > data){
					current = current.getlNode();
					flag = false;
				}else if(current.getData() < data){
					current = current.getrNode();
					flag = true;
				}else{
					return ;
				}
			}
			if(!flag){
				father.setlNode(node);
			}else{
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
				father.setrNode(node);
			}
		}
	}
<<<<<<< HEAD

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
			} else {
				father.rNode = node;
			}
		}
	}

	public void DLR(Node node) {
		if (node != null) {
			System.out.print(node.getData() + "  ");
=======
	
	public void DLR(Node node){
		if(node != null){
			System.out.print(node.getData()+"  ");
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
			DLR(node.getlNode());
			DLR(node.getrNode());
		}
	}
<<<<<<< HEAD

	public void LDR(Node node) {
		if (node != null) {
			LDR(node.getlNode());
			System.out.print(node.getData() + "  ");
			LDR(node.getrNode());
		}
	}

	public void DLR_2(Node root) {
		if (root != null) {
			Node temp = root;
			Stack<Node> stack = new Stack<Node>();
			while (temp != null || !stack.isEmpty()) {
				if (temp != null) {
					// 输出当前位置的数值
					System.out.print(temp.getData() + " ");
					stack.push(temp);
					temp = temp.getlNode();
				} else {
=======
	public void LDR(Node node){
		if(node != null){
			LDR(node.getlNode());
			System.out.print(node.getData()+"  ");
			LDR(node.getrNode());
		}
	}
	
	public void DLR_2(Node root){
		if(root != null){
			Node temp = root;
			Stack<Node> stack = new Stack<Node>();
			while(temp != null || !stack.isEmpty()){
				if(temp != null){
					//输出当前位置的数值
					System.out.print(temp.getData()+" ");
					stack.push(temp);
					temp = temp.getlNode();
				}else{
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
					temp = stack.pop();
					temp = temp.getrNode();
				}
			}
		}
	}
<<<<<<< HEAD

	public void LRD_2(Node root) {
		if (root != null) {
			Stack<Node> stack = new Stack<Node>();
			Stack<Node> outStack = new Stack<Node>();
			Node temp = root;
			while (temp != null || !stack.isEmpty()) {
				if (temp != null) {
					stack.push(temp);
					outStack.push(temp);
					temp = temp.getrNode();
				} else {
=======
	
	public void LRD_2(Node root){
		if(root != null){
			Stack<Node> stack = new Stack<Node>();
			Stack<Node> outStack = new Stack<Node>();
			Node temp = root;
			while( temp!= null || !stack.isEmpty() ){
				if(temp!=null){
					stack.push(temp);
					outStack.push(temp);
					temp = temp.getrNode();
				}else{
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
					temp = stack.pop();
					temp = temp.getlNode();
				}
			}
<<<<<<< HEAD
			while (!outStack.isEmpty()) {
				System.out.print(outStack.pop().getData() + " ");
			}
		}
	}

	

	public void search_Level(Node root) {
		if (root != null) {
			Node temp = root;
			LinkedList<Node> list = new LinkedList<Node>();
			list.add(temp);
			while (!list.isEmpty()) {
				temp = list.poll();
				System.out.print(temp.getData() + " ");
				if (temp.getlNode() != null) {
					list.add(temp.getlNode());
				}
				if (temp.getrNode() != null) {
=======
			while(!outStack.isEmpty()){
				System.out.print(outStack.pop().getData()+" ");
			}
		}
	}
	
	public int search_deap(Node root){
		if(root == null){
			return 0;
		}else{
			int left = 1;
			int right = 1;
			left += search_deap(root.getlNode());
			right += search_deap(root.getrNode());
			return left>right?left:right;
		}
	}
	public void search_Level(Node root){
		if(root != null){
			Node temp = root;
			LinkedList<Node> list = new LinkedList<Node>();
			list.add(temp);
			while(!list.isEmpty()){
				temp = list.poll();
				System.out.print(temp.getData()+" ");
				if(temp.getlNode()!=null){
					list.add(temp.getlNode());
				}
				if(temp.getrNode()!=null){
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
					list.add(temp.getrNode());
				}
			}
		}
	}
<<<<<<< HEAD

	public int search_deap(Node root) {
		if (root == null) {
			return 0;
		} else {
			int left = 1;
			int right = 1;
			left += search_deap(root.getlNode());
			right += search_deap(root.getrNode());
			return left > right ? left : right;
		}
	}
	
	// 第一个参数是：要打印的是哪一个树 第二个是用来存储数值的数值，第三个是当前路径的长度
	// 技巧在于用的都是同一个数组存储用长度来控制当前的路径长度
	public void print(Node root, int[] path, int size) {
		if (root == null) {
			return;
		} else {
			path[size++] = root.getData();
			// 说明此时它为叶子结点
			if (root.getlNode() == null && root.getrNode() == null) {
				for (int i = 0; i < size; i++) {
					System.out.print(path[i] + " ");
				}
				System.out.println();
			} else {
				print(root.getlNode(), path, size);
				print(root.getrNode(), path, size);
			}
		}
	}

	public int judgeFactor(Node node) {
		if (node == null) {
			return 0;
		} else {
=======
	//第一个参数是：要打印的是哪一个树 第二个是用来存储数值的数值，第三个是当前路径的长度
	//技巧在于用的都是同一个数组存储用长度来控制当前的路径长度
	public void print(Node root,int[] path,int size){
		if(root == null){
			return ;
		}else{
			path[size++] = root.getData();
			//说明此时它为叶子结点
			if(root.getlNode() == null && root.getrNode() == null){
				for(int i=0;i<size;i++){
					System.out.print(path[i]+" ");
				}
				System.out.println();
			}else{
				print(root.getlNode(),path,size);
				print(root.getrNode(),path,size);
			}
		}
	}
	
	public int judgeFactor(Node node){
		if(node == null){
			return 0;
		}else{
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
			int left = judgeChildren(node.getlNode());
			int right = judgeChildren(node.getrNode());
			return left - right;
		}
	}
<<<<<<< HEAD

	public int judgeChildren(Node node) {
		if (node != null) {
=======
	public int judgeChildren(Node node){
		if(node!=null){
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
			int left = 1;
			int right = 1;
			left += judgeChildren(node.getlNode());
			right += judgeChildren(node.getrNode());
<<<<<<< HEAD
			return left > right ? left : right;
		} else {
			return 0;
		}
	}

	// 删除节点的方法
	public void deleteNode(Node node) {
		// 删除元素为空直接返回
		if (node == null || root == null) {
			return;
		}
		// 第一步先去原有树中找是否存在当前元素
		Node temp = root;// 临时操作对象
		Node father = temp;// 当前操作对象的父对象，根节点父对象默认为自己
		boolean flag = false;
		// 找寻当前树中是否有自己元素
		while (temp != null) {
			if (node.data == temp.data) {
				flag = true;
				break;
			} else if (node.data > temp.data) {
				father = temp;
				temp = temp.rNode;
			} else {
				father = temp;
				temp = temp.lNode;
			}
		}
		// 如果没有直接返回
		if (!flag) {
			return;
		}
		// 如果当前元素存在进行判断
		// 分两种情况第一种是当前元素没有左孩子的情况，直接把当前删除元素的父节点指向右孩子
		// 第二种情况是有左孩子，在左孩子中找出一个最大元素给当前删除元素并修改指针指向
		if (temp.lNode == null) {//当前左孩子为空
			if (temp == root) {//假如当前要删除元素为根节点，直接让根节点等于右孩子
				root = root.rNode;
			} else {
				if (father.lNode == temp) {//如果要删除的是当前父节点的左孩子的话，让他左孩子等于当前元素的右孩子
					father.lNode = temp.rNode;
				} else {//如果要删除的是当前父节点的右孩子的话，让他右孩子等于当前元素的右孩子
					father.rNode = temp.rNode;
				}
			}
		} else {
			Node q = temp;// 当前的待删元素
			Node s = temp.lNode;// 当前待删元素左孩子
			while (s.rNode != null) {// 在当前元素右孩子中找最大元素
				q = s; // q指向的是当前最大右孩子中的父节点
				s = s.rNode;
			}
			temp.data = s.data;//把当前待删元素左子树中的最大值赋给我们的待删元素
			if (q != temp) {//假如和temp不等说明当前左子树中不包含右分枝
				q.rNode = s.lNode;//让当前左子树中最大元素节点的父节点的右孩子指向当前左子树中最大元素节点的左孩子
			} else {
				temp.lNode = s.lNode;//假如当前左子树中没有右分枝，直接让当前待删元素的左孩子当于左孩子的左孩子
				//因为此时temp 已经等于了s的值了
			}
		}
	}

	public static void main(String[] args) {
		Test02 tt = new Test02();
		Node node1 = tt.new Node(6, null, null);
		Node node2 = tt.new Node(3, null, null);
		Node node3 = tt.new Node(4, null, null);
		Node node4 = tt.new Node(2, null, null);
		Node node5 = tt.new Node(7, null, null);
		Node node6 = tt.new Node(1, null, null);
		Node node7 = tt.new Node(8, null, null);
		Node node8 = tt.new Node(5, null, null);
		tt.add(node1);
		tt.add(node2);
		tt.add(node3);
		tt.add(node4);
		tt.add(node5);
		tt.add(node6);
		tt.add(node7);
		tt.add(node8);
//		tt.add(6);
//		tt.add(3);
//		tt.add(4);
//		tt.add(2);
//		tt.add(7);
//		tt.add(1);
//		tt.add(8);
//		tt.add(5);
		Node node = tt.new Node(100, null, null);
		tt.deleteNode(node);
=======
			return left>right?left:right;
		}else{
			return 0;
		}
	}
	
	public static void main(String[] args){
		Test02 tt = new Test02();
		tt.add(6);
		tt.add(3);
		tt.add(4);
		tt.add(2);
		tt.add(7);
		tt.add(1);
		tt.add(8);
		tt.add(5);
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
		tt.DLR(tt.root);
		System.out.println();
		tt.LDR(tt.root);
		System.out.println();
		System.out.println("非递归前序遍历");
		tt.DLR_2(tt.root);
		System.out.println();
		System.out.println("非递归后序遍历");
		tt.LRD_2(tt.root);
		System.out.println();
		System.out.println("按层遍历");
		tt.search_Level(tt.root);
		System.out.println();
		System.out.println("当前树最大深度");
		System.out.println(tt.search_deap(tt.root));
		System.out.println("当前所有路径");
		int[] path = new int[100];
		tt.print(tt.root, path, 0);
		System.out.println();
		System.out.println("测试");
		System.out.println(tt.judgeFactor(tt.root.getlNode()));
<<<<<<< HEAD

		// LinkedList<Integer> list = new LinkedList<Integer>();
		// list.add(1);
		// list.add(2);
		// list.add(3);
		// System.out.println(list.poll());
		// System.out.println(list.poll());
		// System.out.println(list.poll());
		// System.out.println(list.poll());
		// System.out.println(list.size());

=======
		
//		LinkedList<Integer> list = new LinkedList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		System.out.println(list.poll());
//		System.out.println(list.poll());
//		System.out.println(list.poll());
//		System.out.println(list.poll());
//		System.out.println(list.size());
		
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
	}
}

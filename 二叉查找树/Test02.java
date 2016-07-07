package 二叉查找树;

import java.util.LinkedList;
import java.util.Stack;

import 平衡二叉树.BalenceTree.Node;

public class Test02 {
	public class Node{
		private int data;
		private Node lNode;
		private Node rNode;
		public Node(){
			
		}
		public Node(int data,Node lNode,Node rNode){
			this.data = data;
			this.lNode = lNode;
			this.rNode = rNode;
		}
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
		public void setrNode(Node rNode) {
			this.rNode = rNode;
		}
	}
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
				father.setrNode(node);
			}
		}
	}
	
	public void DLR(Node node){
		if(node != null){
			System.out.print(node.getData()+"  ");
			DLR(node.getlNode());
			DLR(node.getrNode());
		}
	}
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
					temp = stack.pop();
					temp = temp.getrNode();
				}
			}
		}
	}
	
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
					temp = stack.pop();
					temp = temp.getlNode();
				}
			}
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
					list.add(temp.getrNode());
				}
			}
		}
	}
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
			int left = judgeChildren(node.getlNode());
			int right = judgeChildren(node.getrNode());
			return left - right;
		}
	}
	public int judgeChildren(Node node){
		if(node!=null){
			int left = 1;
			int right = 1;
			left += judgeChildren(node.getlNode());
			right += judgeChildren(node.getrNode());
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
		
//		LinkedList<Integer> list = new LinkedList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		System.out.println(list.poll());
//		System.out.println(list.poll());
//		System.out.println(list.poll());
//		System.out.println(list.poll());
//		System.out.println(list.size());
		
	}
}

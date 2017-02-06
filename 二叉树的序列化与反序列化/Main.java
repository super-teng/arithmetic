package 二叉树的序列化与反序列化;

import java.util.Stack;

public class Main {
	public static class Node{
		public int val;
		public Node left;
		public Node right;
		public Node(int val){
			this.val = val;
		}
	}
	public static String preSerialize(Node root){
		String result = "";
		if(root == null){
			result += "#";
			return result;
		}else{
			Node temp = root;
			Stack<Node> stack = new Stack<Node>();
			while(temp!=null || !stack.isEmpty()){
				//当前节点不为空
				if(temp!=null){
					//序列化当前节点
					result+=temp.val+"!";
					//把当前节点压入栈中
					stack.push(temp);
					//去找当前节点的左孩子去了
					temp = temp.left;
				}else{
					temp = stack.pop().right;
				}
			}
			return result;
		}
	}
	
	public static void preUnSerialize(String node){
		String[] temp = node.split("!");
		
	}
	public static void main(String[] args){
		Node n1 = new Main.Node(1);
		Node n2 = new Main.Node(2);
		Node n3 = new Main.Node(3);
		Node n4 = new Main.Node(4);
		Node n5 = new Main.Node(5);
		n1.left = n2;
		n2.right = n3;
		n2.left = n4;
		n4.left = n5;
		String result = Main.preSerialize(n1);
		System.out.println(result);
	}
}

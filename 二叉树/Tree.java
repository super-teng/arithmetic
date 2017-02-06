package 二叉树;

import java.util.LinkedList;
import java.util.Stack;

public class Tree {
	public Node root;
	public int treePath = 0;//计算树中路径
	public int number = 0; //计算数中节点个数
	//构建一个二叉树 插入
	public void add(String data){
		Node node = new Node(data,null,null);
		Node parent = root;
		Node current = root;
		boolean flag = true;
		//判断根节点是否有值
		if(root == null){
			root = node;
		}else{
			//一直判断当前比较节点是否不为空，为空的话就可以进行插入啦
			while(current !=null){
				parent = current;
				//假如小于根节点
				if(data.compareTo(current.getData())<0){
					current = current.getLeftNode();
					flag = true;
				//假如大于根节点
				}else if(data.compareTo(current.getData())>0){
					current = current.getRightNode();
					flag = false;
				//假如树中有值则不插入
				}else{
					return ;
				}
			}
			if(flag){
				current = node;
				parent.setLeftNode(current);
			}else{
				current = node;
				parent.setRightNode(current);
			}
		}
	}
	//当前树中的节点个数
	public int size(Node root){
		if(root == null){
			return 0;
		}else{
			size(root.getLeftNode());
			size(root.getRightNode());
			return ++number;
		}
	}
	//前序遍历
	public void search_DLR(Node root){
		if(root != null){
			System.out.print(root.getData()+" ");
			search_DLR(root.getLeftNode());
			search_DLR(root.getRightNode());
		}
	}
	//中序遍历
	public void search_LDR(Node root){
		if(root !=null){
			search_LDR(root.getLeftNode());
			System.out.print(root.getData()+" ");
			search_LDR(root.getRightNode());
		}
	}
	//后序遍历
	public void search_LRD(Node root){
		if(root !=null){
			search_LRD(root.getLeftNode());
			search_LRD(root.getRightNode());
			System.out.print(root.getData()+" ");
		}
	}
	//非递归式的中序遍历
	
	public void search_LDRL2(Node root){
		//临时的节点 用于指向当前操作的节点
		Node temp = root;
		//定义一个栈把节点的左孩子一个一个压入进去，直到当前节点为空
		Stack<Node> stack = new Stack<Node>();
		while(temp != null || !stack.isEmpty()){
			//当前节点不为空的时候压栈
			if(temp!=null){
				stack.push(temp);
				temp = temp.getLeftNode();
			}else{
				//当节点为空时栈中有值得时候把栈中元素输出出来
				temp = stack.pop();
				//输出弹出的节点数据 这时弹出的数据一定是最左边孩子的节点
				System.out.print(temp.getData()+" ");
				//之后让当前节点指向最左孩子的右孩子再次进行判断
				temp = temp.getRightNode();
			}
		}
	}
	//非递归后序遍历
	public void search_LRDl2(Node root){
		Node temp = root;
		//实际操作的栈
		Stack<Node> stack = new Stack<Node>();
		//存储输出数据的栈
		Stack<Node> output = new Stack<Node>();
		while(temp!=null || !stack.isEmpty()){
			if(temp!=null){
				output.push(temp);
				stack.push(temp);
				temp = temp.getRightNode();
			}else{
				temp = stack.pop();
				temp = temp.getLeftNode();
			}
		}
		while(output.size()>0){
			System.out.print(output.pop().getData()+" ");
		}
	}
	//按层进行遍历
	/*
	 * 总体思路就是把树种节点存入到linkedlist模拟的队列中去
	 * 把头元素移出的同时把它的左右孩子插入到队列当中去 如果有的话
	 * 这样不断进行这个操作 弹出头结点的同时输出头结点知道队列为空 按层遍历
	 */
	public void search_level(Node root){
		//把数据存到一个队列里面 这里面用链表来模拟队列
		LinkedList<Node> list = new LinkedList<Node>();
		Node node  = root;
		Node result = null;
		//先把根节点插入进去 判断根节点是否有值
		if(node != null){
			list.add(node);
			//弹出根节点值
			result = list.poll();
			//不断判断弹出节点的返回值 如果没有节点了则弹出null 做终止判断
			while(result!=null){
				System.out.print(result.getData()+" ");
				//判断当前队列中第一个元素是否含有左右孩子如果含有则插入到队列中
				if(node.getLeftNode()!=null){
					list.addLast(node.getLeftNode());
				}
				if(node.getRightNode()!=null){
					list.addLast(node.getRightNode());
				}
				//当前队列不为空时 node变量始终指向队列头元素
				if(list.size() != 0){
					node = list.getFirst();
				}
				//弹出头元素并循环判断其是否为空是否含有左右孩子
				result = list.poll();
			}
		}
		else{
			System.out.println("当前为空树");
		}
	}
	//查找当前树的深度 如果根节点为空则深度为0 如果不为空 递归调用左右孩子比较谁大谁大就返回谁
	public int search_depth(Node root){
		if(root == null){
			return 0;
		}else{
			int left = 1;
			int right = 1;
			left += search_depth(root.getLeftNode());
			right += search_depth(root.getRightNode());
			return left>right?left:right;
		}
	}
	//打印所有当前树的所有路径
	//参数为：根节点，存储结点的数组，控制路径长度的整形变量
	//提示 ：整形变量size在这里十分重要
	public void printWay(Node root,String[] path,int size){
		//如果根节点为空直接返回
		if(root == null){
			return ;
		}
		//不为空把根节点存储到数组当中
		path[size++] = root.getData();
		//进行逻辑判断，看当前结点是不是叶子结点 如果是叶子结点 按照长度为 size进行打印当前数组
		if(root.getLeftNode()==null&&root.getRightNode()==null){
			System.out.println("路径"+(++treePath)+"为");
			for(int i=0;i<size;i++){
				System.out.print(path[i]+" ");
			}
			System.out.println();
			//如果不是叶子结点递归进去继续往数组中插值
		}else{
			printWay(root.getLeftNode(),path,size);
			printWay(root.getRightNode(),path,size);
		}
	}
	//获取某一元素的结点 及其左孩子和右孩子
	public Node searchByData(String data){
		Node node = this.root;
		Node result = null;
		if(node.getData().equals(data)){
			result = node;
		}else{
			//判断当前节点与目标节点的大小比值 
			while(node!=null && node.getData().compareTo(data)<0){
				node = node.getRightNode();
			}
			while(node!=null && node.getData().compareTo(data)>0 ){
				node = node.getLeftNode();
			}
			if(node !=null){
				result = node;
			}
		}
		return result;
	}

	public static void main(String[] args){
		//测试代码
		Tree tree = new Tree();
		tree.add("4");
		tree.add("6");
		tree.add("2");
		tree.add("3");
		tree.add("7");
		tree.add("8");
		tree.add("5");
		System.out.println("前序遍历");
		tree.search_DLR(tree.getRoot());
		System.out.println();
		System.out.println("中序遍历");
		tree.search_LDR(tree.getRoot());
		System.out.println();
		System.out.println("后序遍历");
		tree.search_LRD(tree.getRoot());
		System.out.println();
		System.out.println("按层遍历");
		tree.search_level(tree.getRoot());
		System.out.println();
		System.out.println("非递归中序遍历");
		tree.search_LDRL2(tree.getRoot());
		System.out.println();
		System.out.println("非递归后序遍历");
		tree.search_LRDl2(tree.getRoot());
		System.out.println();
		System.out.println("当前树的深度");
		System.out.println(tree.search_depth(tree.getRoot()));
		System.out.println("查找某一元素");
		Node node = tree.searchByData("6");
		if(node!=null){
			System.out.println("当前元素为"+node.getData());
			if(node.getLeftNode()!=null){
			System.out.println("左孩子为+"+node.getLeftNode().getData());
			}
			if(node.getRightNode()!=null){
				System.out.println("右孩子为"+node.getRightNode().getData());
			}
		}else{
			System.out.println("当前元素不存在");
		}
		System.out.println("打印所有路径");
		String[] path = new String[100];
		tree.printWay(tree.getRoot(), path, 0);
		System.out.println("当前节点的个数");
		int size = tree.size(tree.getRoot());
		System.out.println(size);
	}

	public Node getRoot() {
		return root;
	}
	
}

package 平衡二叉树;


public class Main {
	//节点类 包含数据,平衡因子,左孩子和右孩子
	public class Node{
		public int data;
		public Node left;
		public Node right;
		public int bf;//平衡因子
		public Node(int data,Node left, Node right,int bf){
			this.data = data;
			this.left = left;
			this.right = right;
			this.bf = bf;
		}
	}
	//平衡二叉树的根节点
	public Node root;
	
	//插入节点的算法
	/*
	 * 1：找到待插入节点
	 * 2：修改当前最接近插入节点的平衡因子不为0的节点BF
	 * 3：修改当前路径上到插入节点上所有节点的平衡因子
	 * 4：判断是否破坏了平衡二叉树的规律进行重构
	 */
	public void add(Node node){
		//健壮性判断
		if(node == null){
			return ;
		}
		//如果当前为空树直接让根节点为当前插入节点
		if(root == null){
			root = node;
		}else{
			Node current = root;//当前待插入的节点位置
			Node father = root;//当前待插入节点位置的父位置
			Node bdNode = root; //最接近当前插入节点且平衡因子不为空的节点
			boolean flag = false;//判断插入节点是插入在左孩子位置还是右孩子位置
			while(current != null){//找到待插入位置的过程
				if(current.bf != 0){  //记录当前离待插入节点最近的不为0的节点，为后来的判断是否是平衡二叉树做帮助
					bdNode = current;
				}
				father = current;
				if(current.data > node.data){
					current = current.left;
					flag = false;
				}else if(current.data < node.data){
					current = current.right;
					flag = true;
				}else{
					return ;
				}
			}
			//将元素插入进去
			if(!flag){
				father.left = node;
			}else{
				father.right = node;
			}
			Node temp = root;//修改当前bdNode到待插入节点路径上所有节点的平衡因子
			//修改当前bdNode的平衡因子
			if(bdNode.data > node.data){
				temp = bdNode.left;
				bdNode.bf = bdNode.bf + 1;
			}else{
				temp = bdNode.right;
				bdNode.bf = bdNode.bf - 1;
			}
			//修改bdNode到插入节点路径上所有平衡因子的变化
			current = temp; // 用current来进行处理是因为之后的操作要对temp进行判断是否破坏了平衡二叉树的规律
			while(current != node){
				if(current.data > node.data){
					current.bf = 1;
					current = current.left;
				}else{
					current.bf = -1;
					current = current.right;
				}
			}
			Node father02 = root;
			Node t = root;
			while(t.data != bdNode.data){
				father02 = t;
				if(bdNode.data < t.data){
					t = t.left;
					
				}else if(bdNode.data > t.data){
					t = t.right;
					
				}
			}
			
			//判断插入节点之后是否还符合平衡二叉树的规则
			if(bdNode.bf == 2 && temp.bf == 1){  // LL型
				this.LL(bdNode,father02);
			}else if(bdNode.bf == 2 && temp.bf == -1){ // LR型
				this.LR(bdNode,father02);
			}else if(bdNode.bf == -2 && temp.bf == -1){ //RR型
				this.RR(bdNode,father02);
			}else if(bdNode.bf == -2 && temp.bf == 1){  //RL型
				this.RL(bdNode,father02);
			}
		}
	}
	
	
	//LL型   
	/*
	 * node   O             temp    O
	 *       /                     / \
	 * temp O       ====>   node  O   O
	 *     /   
	 *    O
	 */
	public void LL(Node node,Node father){
		Node temp = node.left; //这个节点即将旋转到中间去
		node.left = temp.right;
		temp.right = node;
		node.bf = 0;
		temp.bf = 0;
		if(node == root){
			root = temp;
		}else{
			father.left = temp;
		}
	}
	
	
	//LR型
	/*
	 *   node       O                                 temp2     O
	 *             / \                                         / \
	 *   temp1    O   O         ====== >              temp1   O   O  <- node 
	 *           / \                                         / \   \   
	 *          O   O  <- temp2                             O   O   O
	 *               \
	 *                O
	 */
	
	public void LR(Node node,Node father){
		Node temp1 = node.left;
		Node temp2 = temp1.right;
		node.left = temp2.right; //让node的左指针指向temp2的左孩子
		temp1.right = temp2.left;//让temp1的右指针指向temp2的左孩子
		temp2.left = temp1;//让temp2当做中心节点，左边是temp1
		temp2.right = node;//右边是node节点
		//判断temp2的平衡因子
		switch(temp2.bf){
		case 0 : 
			node.bf = 0; 
			temp1.bf = 0;
			break;
		case 1 : 
			node.bf = 0; 
			temp1.bf = -1; 
			break;
		case -1 : 
			node.bf = 1; 
			temp1.bf = 0;
			break;
		}
		temp2.bf = 0;
		if(node == root){
			root = temp2;
		}else{
			father.left = temp2;
		}
	}
	
	//RR型
	
	/*
	 *  node O                 temp    O
	 *        \                       / \
	 *  temp   O     =======>  node  O   O
	 *          \
	 *           O
	 */
	
	public void RR(Node node,Node father){
		Node temp =  node.right; //即将旋转至中间的节点
		node.right = temp.left;
		temp.left = node;
		temp.bf = 0;
		node.bf = 0;
		if(node == root){
			root = temp;
		}else{
			father.right = temp;
		}
	}
	
	//RL型
	/*
	 *          O    <-  node             temp02 ->    O
	 *         / \                                    / \
	 *        O   O    <-  temp1      ==>   node ->  O   O     <-   temp1
	 *           / \                                / \   \
	 * temp2->  O   O                              O   O   O
	 *         /
	 *        O  
	 */ 
	
	public void RL(Node node,Node father){
		Node temp1 = node.right;
		Node temp2 = temp1.left;
		node.right = temp2.left;
		temp1.left = temp2.right;
	    temp2.right =  temp1;
		temp2.left = node;
		switch(temp2.bf){
		case 0:
			node.bf = 0;
			temp1.bf = 0;
			break;
		case 1:
			node.bf = -1;
			temp1.bf = 0;
			break;
		case -1:
			node.bf = 0;
			temp1.bf = 1;
			break;
		}
		temp2.bf = 0;
		if(node == root){
			root = temp2;
		}else{
			father.right = temp2;
		}
	}
	//前序遍历
	public void DLR(Node node) {
		if (node != null) {
			System.out.print(node.data + "  ");
			DLR(node.left);
			DLR(node.right);
		}
	}
	public static void main(String[] args){
		Main m = new Main();
		Node node1 = m.new Node(5,null,null,0);
		Node node2 = m.new Node(3,null,null,0);
		Node node3 = m.new Node(4,null,null,0);
		Node node4 = m.new Node(9,null,null,0);
		Node node5 = m.new Node(1,null,null,0);
		Node node6 = m.new Node(0,null,null,0);
		Node node7 = m.new Node(8,null,null,0);
		Node node8 = m.new Node(7,null,null,0);
		m.add(node1);
		m.add(node2);
		m.add(node3);
		m.add(node4);
		m.add(node5);
		m.add(node6);
		m.add(node7);
		m.add(node8);
		System.out.println("节点插入顺序为:  ");
		System.out.println("5  3  4  9  1  0  8  7");
		System.out.println("中序遍历结果");
		m.DLR(m.root);
	}
}

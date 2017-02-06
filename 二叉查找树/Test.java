package 二叉查找树;

public class Test {
	
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
	private Node root;
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	//添加的方法
	public void add(int data){
		Node node = new Node(data,null,null);
		if(this.getRoot() == null){
			this.setRoot(node);
		}else{
			Node root = this.getRoot();
			boolean flag = false;
			while(!flag){
				if(this.getRoot().getData() == data){
					return ;
				}
				while(this.getRoot().getData() > data){
					if(this.getRoot().getlNode() == null){
						this.getRoot().setlNode(node);
						flag = true;
						break;
					}else{
						this.setRoot(this.getRoot().getlNode());
					}
				}
				while(this.getRoot().getData() < data){
					if(this.getRoot().getrNode() == null){
						this.getRoot().setrNode(node);
						flag = true;
						break;
					}else{
						this.setRoot(this.getRoot().getrNode());
					}
				}
			}
			this.setRoot(root);
		}
	}
	public void delete(int data){
		
	}
}


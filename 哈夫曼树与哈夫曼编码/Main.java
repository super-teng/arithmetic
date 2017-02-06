package 哈夫曼树与哈夫曼编码;

public class Main {
	// 节点类
	public class Node {
		public int weight; // 权值
		public Node lNode;
		public Node rNode;
		public Node father;
		public String data;

		public Node(String data, int weight, Node lNode, Node rNode, Node father) {
			this.data = data;
			this.weight = weight;
			this.lNode = lNode;
			this.rNode = rNode;
			this.father = father;
		}
	}

	// 编码类
	public class Code {
		public String data; 
		public String coding;
	}

	public Node[] tree;// 最终构建好的哈弗曼树
	public Code[] codes;// 编码总数

	// 创建huffman树 参数是当前叶节点个数,当前数组的最后一个位置节点的权值就是当前哈弗曼树的最小权值
	public void createHuffman(Node[] nodes) {
		// 进行健壮性判断
		if (nodes == null || nodes.length <= 1) {
			return;
		}
		// 初始化这个树的节点
		tree = new Node[nodes.length * 2 - 1];
		int index = 0;
		// 为前N个节点进行初始化，后面的节点初始均为0
		for (int i = 0; i < tree.length; i++) {
			Node n = new Node(null, Integer.MAX_VALUE, null, null, null);
			if (index < nodes.length) {
				n.data = nodes[index].data;
				n.weight = nodes[index++].weight;
			}
			tree[i] = n;
		}
		// 为剩余位置上进行赋值
		for (int i = nodes.length; i < tree.length; i++) {
			// 找出当前最小的两个节点
			Node[] temp = tree; // 临时操作数组，类似于 Node temp = root 那行
			// 冒泡排序
			for (int j = 0; j < temp.length; j++) {
				for (int k = temp.length - 1; k > j; k--) {
					if (temp[k].weight < temp[k - 1].weight) {
						Node t = temp[k];
						temp[k] = temp[k - 1];
						temp[k - 1] = t;
					}
				}
			}
			// 左右孩子指针
			int left = -1;
			int right = -1;
			// 把当前最小的两个节点位置赋予两个变量
			for (int j = 0; j < temp.length; j++) {
				// 说明当前节点没有被操作
				if (temp[j].father == null) {
					if (left == -1) {
						left = j;
					} else if (right == -1) {
						right = j;
						break;
					}
				}
			}
			// 创建父节点为最小两节点之和
			Node father = new Node(null,
					tree[left].weight + tree[right].weight, tree[left],
					tree[right], null);
			// 串联关系
			tree[i] = father;
			tree[left].father = father;
			tree[right].father = father;
		}
	}

	// 构建huffman编码
	public void createHuffmanCoding(Node[] nodes) {
		//健壮性判断
		if(nodes== null || nodes.length ==0){
			return;
		}
		codes = new Code[nodes.length];
		for(int i=0;i<codes.length;i++){
			codes[i] = new Code();
		}
		for(int i=0;i<nodes.length;i++){
			codes[i].data = nodes[i].data;
			String temp = "";
			//在哈夫曼树中找到当前这个元素位置并记录当前的哈夫曼编码的逆序
			for(int j=0;j<tree.length;j++){
				Node t = null;
				if(tree[j].data!=null && tree[j].data.equals(codes[i].data)){
					t = tree[j];
					//假如有父节点
					while(t.father != null){
						//记录0并让指针等于父节点
						if(t.father.lNode == t){
							temp += "0";
							t = t.father;
						}else {
							temp += "1";
							t = t.father;
						}
					}
					break;
				}
			}
			String coding = new String();
			for(int j=temp.length()-1;j>=0;j--){
				coding += temp.charAt(j);
			}
			codes[i].coding = coding;
		}
	}
	
	public void huffman(){
		int sum = 0;
		for(int i=0;i<codes.length;i++){
			String temp = codes[i].data;
			int weight = 0;
			for(int j =0;j<tree.length;j++){
				if(tree[j].data != null &&tree[j].data.equals(temp)){
					weight = tree[j].weight;
					break;
				}
			}
			sum += weight * codes[i].coding.length();
		}
		System.out.println("哈夫曼值:"+sum);
	}
	public static void main(String[] args) {
		Main m = new Main();
		Node[] nodes = { m.new Node("a", 3, null, null, null),
				m.new Node("b", 5, null, null, null),
				m.new Node("c", 6, null, null, null),
				m.new Node("d", 9, null, null, null), };
		m.createHuffman(nodes);
		for (int i = 0; i < m.tree.length; i++) {
			System.out.print(m.tree[i].data+" "+m.tree[i].weight + " ");
		}
		System.out.println();
		m.createHuffmanCoding(nodes);
		for(int i=0;i<m.codes.length;i++){
			System.out.println(m.codes[i].data+" "+m.codes[i].coding);
		}
		m.huffman();
	}
}

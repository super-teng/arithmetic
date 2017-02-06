package 邻接表;

public class Main {
	
	private HeadNode[] headNode; //节点个数
	
	//头结点信息
	public class HeadNode{
		public char node; // 头结点信息
		
		public NextNode next; // 下一结点信息
		
		public HeadNode(char node,NextNode next){
			this.node = node;
			this.next = next;
		}
	}
	//与头结点相连接的下一结点信息
	public class NextNode{
		public int index; //当前节点所在数组中的位置
		
		public NextNode next; // 下一结点信息
		
		public int weight; //当前边的权值信息
		
		public NextNode(int index ,NextNode next ,int weight){
			this.index = index;
			this.next = next;
			this.weight = weight;
		}
	}
	//初始化数组结点
	public void initNode(char[] node){
		if(node == null){
			return ;
		}
		headNode = new HeadNode[node.length];//初始化头结点数组长度与传入node长度相同
		for(int i=0;i<node.length;i++){
			HeadNode head = new HeadNode(node[i],null);
			headNode[i] = head;
		}
	}
	//初始化整个邻接表
	public void initTable(char[][]edgs){
		for(int i=0;i<edgs.length;i++){
			char begin = edgs[i][0];//起始值
			char end = edgs[i][1];//终止值
			int index = 0;//终止值在初始化数组中的索引位置
			//在数组当中找到索引位置
			for(int j=0;j<headNode.length;j++){
				if(headNode[j].node == end){
					index = j;
					break;
				}
			}
			NextNode next = new NextNode(index,null,0);//生成下一个节点的包装类
			//为数组中的头结点进行串线
			for(int j=0;j<headNode.length;j++){
				if(headNode[j].node == begin){
					NextNode temp = headNode[j].next;//操作变量
					//如果头结点的下一节点为空的话就让当前生成的包装类节点赋予给我们的下一节点
					if(temp == null){
						headNode[j].next = next; 
					}else{
						//判断当前头结点下面有没有连接着其他的节点
						while(temp.next!=null){
							temp = temp.next;
						}
						temp.next = next;
					}
				}
			}
		}
	}
	//打印函数
	public void print(HeadNode[] head){
		for(int i=0;i<head.length;i++){
			System.out.print(head[i].node);
			NextNode temp = head[i].next;
			while(temp!= null){
				System.out.print(" --> ");
				System.out.print(temp.index);
				temp = temp.next;
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		char[] node = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[][] edgs = new char[][]{
            {'A', 'B'}, 
            {'B', 'C'}, 
            {'B', 'E'}, 
            {'B', 'F'}, 
            {'C', 'E'}, 
            {'D', 'C'}, 
            {'E', 'B'}, 
            {'E', 'D'}, 
            {'F', 'G'}
        };
        Main m = new Main();
        //初始化数组头结点的过程
        m.initNode(node);
        //初始化邻接表的过程
        m.initTable(edgs);
        //打印结果
        m.print(m.headNode);
	}
	
}

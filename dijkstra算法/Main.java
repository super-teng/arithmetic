package dijkstra算法;

public class Main {
	private static final int MAX = 10000;//表示当前两点不想连
	/*迪杰斯特算法思路：创建一个数组用于保存当前节点是否已经经过判断了
	以一个节点最为起始节点，然后找其他节点与其相连的最小距离权值，
	找出当前与之相连的最小权值之后，把和其相连的最小权值节点标记为true表示已经被判断了。
	之后在修改其余节点与已经判断结点的距离大小值
	*/
	public static void dijkstra(int[][] graph){
		char[] node = {'A','B','C','D','E','F'}; //节点元素内容
		int[] D = new int[node.length]; //存储每个没有遍历的节点与已遍历节点之间的最小距离
		boolean[] isVisited = new boolean[node.length];//判断当前节点是否已经被遍历了
		isVisited[0] = true;//当前从第一个节点开始遍历
		int[] start = new int[node.length];//起始节点数组 初始起始节点都是0号节点
		for(int i = 0;i<node.length;i++){
			D[i] = graph[0][i]; //把与起始节点相连的点权值距离赋予给D数组
		}
		//执行N-1趟，找出当前所有节点
		for(int i=0;i<node.length-1;i++){
			int min = MAX;//最小值
			int index = 0;//最小值的索引
			//找出与已遍历节点相连的最小权值节点
			for(int j=0;j<D.length;j++){
				//如果当前节点没有被遍历过,并且与已遍历节点相连权值小于最小值
				if(!isVisited[j] && D[j] < min){
					min = D[j];
					index = j;
				}
			}
			if(min == 10000){
				continue;
			}
			System.out.println(node[start[index]]+"--->"+node[index]+" "+min); //输出效果
			isVisited[index] = true;//表示当前节点被访问了
			//重新调整D数组，因为此时被访问节点中多了一个
			for(int j = 0;j<D.length;j++){
				//假如当前节点没有访问过且当前与新加入被访问集合中的节点比原最小节点要小则修改赋值
				if( !isVisited[j] && min+graph[index][j] < D[j] ){
					D[j] = min+graph[index][j];
					start[j] = index; //修改当前位置的起始节点
				}
			}
		}
	}
	public static void main(String []args){
		int[][] graph = {{MAX,50,10,MAX,55,MAX},
						 {MAX,MAX,15,MAX,10,MAX},
						 {20,MAX,MAX,15,MAX,MAX},
						 {MAX,20,MAX,MAX,20,MAX},
						 {MAX,MAX,MAX,30,MAX,MAX},
						 {MAX,MAX,MAX,3,MAX,MAX}};
		dijkstra(graph);
	}
}

package krukal算法;

public class Main {
	private static final int MAX = Integer.MAX_VALUE; //表示当前两点不相连

	public static void main(String[] args){
		int[][] graph = new int[][] {
				{ MAX, 10, MAX, MAX, MAX, 11, MAX, MAX, MAX },
				{ 10, MAX, 18, MAX, MAX, MAX, 16, MAX, 12 },
				{ MAX, MAX, MAX, 22, MAX, MAX, MAX, MAX, 8 },
				{ MAX, MAX, 22, MAX, 20, MAX, MAX, 16, 21 },
				{ MAX, MAX, MAX, 20, MAX, 26, MAX, 7, MAX },
				{ 11, MAX, MAX, MAX, 26, MAX, 17, MAX, MAX },
				{ MAX, 16, MAX, MAX, MAX, 17, MAX, 19, MAX },
				{ MAX, MAX, MAX, 16, 7, MAX, 19, MAX, MAX },
				{ MAX, 12, 8, 21, MAX, MAX, MAX, MAX, MAX } };
		kruskal(graph);
	}
	public static void kruskal(int[][] graph){
		int num = graph.length;//找出当前的节点个数
		//表示当前节点是否在同一连通图中，如果数值相同则表示在同一连通图中，
		//初始值时候0，表示当前节点还为进行判断，所以处理的时候要进行一个考虑
		int[] group = new int[num];
		boolean finished = false;//用来做程序是否执行完毕的判断条件
		int sum = 0;//当前最小生成树的权值和
		int start = 0; //当前找到的符合条件的最小权值路径的起始结点索引
		int end = 0;//当前符合条件的最小权值的终止结点索引
		int groupNumber = 1;//当前用于判断结点是否是同一连通图的标记，如果值相同的话说明是在同一连通图当中
		//如果当前程序还可以继续执行的话
		while(!finished){
			/*
			 * 第一步：找出当前权值当中的最小值，并且标记该权值的起始结点和终止结点
			 */
			int min = MAX; // 最小值，初始情况下赋予无穷大
			for(int i=0;i<graph.length;i++){
				for(int j=i;j<graph[i].length;j++){
					//如果当前权值比我们的最小值要小的话进行二次判断，判断当前是否在同一连通图中，
					//如果在同一连通图中我们是不进行选择的
					if(graph[i][j] < min){
						//两个条件满足一个即可，如果起始结点和终止结点位置的组标号不一样则不是同一连通图
						//第二个条件是如果两个都是0说明当前都是没有进行处理过的元素
						if(group[i] != group[j] || (group[i] == 0 && group[j] == 0)){
							min = graph[i][j];//把最小值赋予给它
							start = i;//赋予起始值
							end = j;//赋予终止值
						}
					}
				}
			}
			//如果当前最小值还是MAX的话说明当前节点没有与任何节点想连接，这个图是一个森林，
			//只能构建出一个最小生成树和一个没有边与之想连接的结点
			if(min == MAX){
				continue;
			}
			System.out.println(start+"---->"+end+" 权值: "+min);
			sum += min; //把当前权值加入到最小权值中去
			/*
			 * 第二步开始修改分组group里面的值
			 */
			//如果两个结点都是0的话，我们给他们赋值为1组，并且把组号进行++操作，组号就是连通图的组
			if(group[start] == 0 && group[end] == 0){
				group[start] = groupNumber;
				group[end] = groupNumber;
				groupNumber++;
			}
			//如果两个值都大于0说明当前两个均有组号,则需要让他们两个组号相同
			else if(group[start] > 0 && group[end] > 0 ){
				int temp = group[end];
				for(int i = 0;i<group.length;i++){
					//找到终点的组号，把它修改和起始结点的组号相同，也就是1
					if(group[i] == temp){
                        group[i] = group[start];
                    }
				}
			}
			//如果组号一个大于0一个小于0，说明当前有一个是有组的，而另一个是没有组的
			//那么就让没有组的组号等于有组的组号
			else{
				if(group[start] == 0){
					group[start] = group[end];
				}else{
					group[end] = group[start];
				}
			}
			//判断当前是否所结点是否都遍历到了
			for(int i=0 ; i<group.length;i++){
				//如果有一个结点和初始结点的值不一样说明当前还有遍历完成
				if(group[i] != group[0]){
					finished = false;
					break;
				}else{
					finished = true;
				}
			}
			//如果满足退出条件了则退出
			if(finished){
				break;
			}
		}
		System.out.println("最小权值为: "+sum);
	}
}

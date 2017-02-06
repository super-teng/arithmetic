package prim算法;

/*
 * 思路：把图分成了两个集合，第一个集合是U第二个是V。初始状态U中只有一个节点V0,V中存储着除
 * V0之外的所有节点，在V中找出与U中节点相连接权值最小的节点，并存入到prims数组中，并把该节点
 * 存入我们的U中，最终V中节点全部查询完毕算法结束
 * 为配合实现这一思路，我们需要一个lowcost数组来存储当前的权值，也就是V中节点与U中节点相连接
 * 最小的权值。当lowcost中值为0的时候说明当前这个节点已经被传入到了U集合中则不用再继续进行
 * 判断了
 */
public class Main {

	private int[] lowcost;// 存储U到V中节点最小的权值

	private static final int MAX = Integer.MAX_VALUE; // 当没有权值时赋予的无穷大

	private int[] mst;// 当前的辅助标识节点，标识当前<v,w>中起始节点的索引是什么

	/*
	 * 最小生成 树 prim算法
	 */

	public void prim(int[][] graph,int start) {
		char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };
		this.mst = new int[vertex.length];
		this.lowcost = new int[vertex.length];
		int sum = 0; // 最小生成树的权值数
		// 初始化第一次的lowcost数组记录与start相连的其余节点的权值，不相连赋予max
		//start节点不用变默认是0表示当前节点已经被访问了
		for (int i = 0; i < vertex.length; i++) {
			// 如果当前节点不是start位置节点的话我们就让它的最小权值为当前权值，
			// 因为这是第一次的赋值并不需要考虑U集合中最小权值的部分，因为当前U集合中只有一个值直接赋值即可。
			if (i != start) {
				lowcost[i] = graph[start][i];
			}
		}
		// 轮询的次数，总共轮询N-1次，找出N-1个顶点，因为初始节点给了
		for (int i = 1; i < vertex.length; i++) {
			int temp = 0;// 找出当前V集合中与U集合中节点相连权值最小的元素
			int min = MAX;// 判断标示
			// 找出当前权值最小的节点<V,W>
			for (int j = 0; j < vertex.length; j++) {
				// 假如当前值属于V集合中并且当前权值比当前最小值要小
				if (lowcost[j] != 0 && lowcost[j] < min) {
					min = lowcost[j]; // 记录下最小权值以及最小节点位置
					temp = j;
				}
			}
			System.out.println("结点:"+vertex[mst[temp]]+"--->"+"结点:"+vertex[temp]+" 权值:"+ min +" ");
			sum += min;
			lowcost[temp] = 0;// 将其赋值为0标示当前已经在我们的U集合中
			// 调整整个的lowcost
			for (int j = 0; j < vertex.length; j++) {
				// 假如当前的值属于V集合中，并且当前新添加到U集合中的点为起点，
				// J为终点的值的权值比原来的要小则调整
				if (lowcost[j] != 0 && graph[temp][j] < lowcost[j]) {
					lowcost[j] = graph[temp][j];
					mst[j] = temp;
				}
			}
		}
		System.out.println("最小生成树权值为:"+sum);
	}

	public static void main(String[] args) {
		int[][] graph = new int[][] {
				{ 0, 10, MAX, MAX, MAX, 11, MAX, MAX, MAX },
				{ 10, 0, 18, MAX, MAX, MAX, 16, MAX, 12 },
				{ MAX, MAX, 0, 22, MAX, MAX, MAX, MAX, 8 },
				{ MAX, MAX, 22, 0, 20, MAX, MAX, 16, 21 },
				{ MAX, MAX, MAX, 20, 0, 26, MAX, 7, MAX },
				{ 11, MAX, MAX, MAX, 26, 0, 17, MAX, MAX },
				{ MAX, 16, MAX, MAX, MAX, 17, 0, 19, MAX },
				{ MAX, MAX, MAX, 16, 7, MAX, 19, 0, MAX },
				{ MAX, 12, 8, 21, MAX, MAX, MAX, MAX, 0 } };
		Main m = new Main();
		m.prim(graph,0);
	}
}

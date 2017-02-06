package floyd算法;

public class Main {

	private static final int MAX = 1000;//这里之所以不用MAX_VALUE是因为这样的话在做++操作就会出现超界的情况出现负值

	/*
	 * floyd算法思路：找出当前任意两点之间的最短距离，初始的时候最短距离为当前两点之间相连的距离，
	 * 之后不断在两点之间不断加入其它顶点判断是否比原来的节点长度小，如果小的话就修改距离值
	 */
	public static void floyd(int[][] graph) {
		char[] node = { 'A', 'B', 'C' };
		int[][] D = new int[node.length][node.length];// 里面存储着任意两点之间的最短距离
		// 为D数组进行赋值，初始就是两点直接相连的距离
		for (int i = 0; i < node.length; i++) {
			for (int j = 0; j < node.length; j++) {
				D[i][j] = graph[i][j];
			}
		}
		// 核心算法，用于往两点中间插值，每一次循环插入一个节点，
		for (int k = 0; k < node.length; k++) {
			for (int i = 0; i < node.length; i++) {
				for (int j = 0; j < node.length; j++) {
					//如果经过当前插入节点之后的距离小于之前的距离，那么修改原值
					if(D[i][k] + D[k][j] < D[i][j]){
						D[i][j] = D[i][k] + D[k][j];
					}
				}
			}
		}
		//输出当前两点中最短值
		for(int i=0;i<node.length;i++){
			for(int j=0;j<node.length;j++){
				if(D[i][j] != MAX && i!=j){ //这里防止相同节点输出，因为当前给定图中可能出现环形
					System.out.println(node[i]+"----->"+node[j]+" "+D[i][j]);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] graph = { { MAX, 4, 11 }, { 6, MAX, 2 }, { 3, MAX, MAX } };
		floyd(graph);
	}
}

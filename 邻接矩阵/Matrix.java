package 邻接矩阵;

public class Matrix {
	private char[] node;//邻接矩阵的点
	private int[][] edgs;//邻接矩阵的边的集合
	
	//初始化构建邻接矩阵的方法
	public Matrix(char[] node,char[][]edgs){
		int nLength = node.length;//获取节点的长度
		int eLength = edgs.length;//获取边的长度
		this.node = new char[nLength];//初始化邻接矩阵的点
		for(int i =0;i<nLength;i++){
			this.node[i] = node[i];
		}
		this.edgs = new int[nLength][nLength];//初始化邻接矩阵边的集合
		for(int i =0;i<eLength;i++){	//循环遍历获取所有边的起点以及终点
			int temp01 = position(edgs[i][0]);	//获取边的起点
			int temp02 = position(edgs[i][1]);	//获取边的终点
			this.edgs[temp01][temp02] = 1;
		}
	}
	//查找当前节点所在位置
	public int position(char t){
		int result = 0;
		//判断当前节点在节点数组中所在的位置把位置信息返回回去
		for(int i=0;i<node.length;i++){
			if(t == node[i]){
				result = i;
			}
		}
		return result;
	}
	//输出
	public void print(char[] node,int[][]edgs){
		for(int i=0;i<node.length;i++){
			System.out.print("  ");
			System.out.print(node[i]+"  ");
		}
		System.out.println();
		for(int i=0;i<node.length;i++){
			System.out.print(node[i]+" ");
			for(int j=0;j<node.length;j++){
				System.out.print(edgs[i][j]+"    ");
			}
			System.out.println();
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
            {'F', 'G'}};
        Matrix m = new Matrix(node,edgs);
        m.print(node, m.edgs);
	}
}

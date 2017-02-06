package 替换空格;

import java.util.Scanner;

public class Main {
	static int[] outWay = new int[2]; // 出口位置
	static int time = 0; //访问此处记录
	static int fastTime = Integer.MAX_VALUE;//最大值来保证不会超过上限，此处为最大值
	static boolean[][] res; // 保存最终路径

	// 深度优先搜索
	static void dfs(int[][] a, boolean[][] v, int x, int y, int time) {
		int[][] b = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };//匹配出所有的可能
		if (x == outWay[0] && y == outWay[1]) { // 到达出口，则判断是否最短路径
			v[x][y] = true;
			if ((time + 1) <= fastTime) {
				fastTime = time + 1; //
				res = v;
				printPath(v);//用于输出信息的语句，用于切换
			}
			return;
		}
		if ((a[x][y] == 0 && !v[x][y])) { // 可以走，且没有访问过
			for (int j = 0; j < 4; j++) {
				if (a[x + b[j][0]][y + b[j][1]] != 3) { // 判断边界
					v[x][y] = true;// 标记访问标志
					dfs(a, v, x + b[j][0], y + b[j][1], time++);
					v[x][y] = false; //标记访问标志
				}
			}
		}
	}

	// 打印路径：
	private static void printPath(boolean[][] v) {
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				if (v[i][j] == true) {
					System.out.println((i - 1) + "," + (j - 1));
				}
			}
		}
	}

	// 主方法进行调用
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String string = sc.nextLine();
		String strings[] = string.split(" ");
		int n = strings.length;
		int m = n;
		int a[][] = new int[n + 2][n + 2];
		for (int j = 1; j <= n; j++) {
			a[1][j] = Integer.parseInt(strings[j - 1]);
		}
		for (int i = 2; i <= n; i++) {
			string = sc.nextLine();
			String[] strs = string.split(" ");
			for (int j = 1; j <= n; j++) {
				a[i][j] = Integer.parseInt(strs[j - 1]);
			}
		}

		for (int i = 0; i <= m; i++) { // 构造迷宫外围
			a[n + 1][i] = 3;
			a[0][i] = 3;
		}
		for (int i = 0; i <= n; i++) { // 构造迷宫外围
			a[i][m + 1] = 3;
			a[i][0] = 3;
		}
		outWay[0] = n;// 出口横坐标
		outWay[1] = n;// 出口纵坐标
		boolean[][] v = new boolean[a.length][a.length];
		boolean[][] res = new boolean[a.length][a.length];
		dfs(a, v, 1, 1, time);
		System.out.println(fastTime + 2); //用来切换两道题目，输出最大次数的可以用这个输出
		 printPath(res);//用于输出最佳路径的方法
	}
}

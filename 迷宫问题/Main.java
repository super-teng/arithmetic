package 迷宫问题;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		Maze demo = m.new Maze();
		demo.init();
		demo.findPath();
	}

	class Position {
		public Position() {

		}

		public Position(int row, int col) {
			this.col = col;
			this.row = row;
		}

		public String toString() {
			return "(" + row + " ," + col + ")";
		}

		int row;
		int col;
	}

	class Maze {
		int status = 0;
		int maze[][];
		private int row = 9;
		private int col = 8;
		Stack<Position> stack;
		boolean p[][] = null;

		public Maze() {
			maze = new int[15][15];
			stack = new Stack<Position>();
			p = new boolean[15][15];
		}

		/*
		 * 构造迷宫
		 */
		public void init() {
			Scanner scanner = new Scanner(System.in);
			row = scanner.nextInt();// 行
			col = scanner.nextInt();// 列
			status = scanner.nextInt(); // 能力值
			int temp = 0;
			for (int i = 0; i < row; ++i) {
				for (int j = 0; j < col; ++j) {
					temp = scanner.nextInt();
					maze[i][j] = temp;
					p[i][j] = false;
				}
			}
			scanner.close();
		}

		/*
		 * 回溯迷宫，查看是否有出路
		 */
		public void findPath() {
			// 给原始迷宫的周围家一圈围墙
			int temp[][] = new int[row + 2][col + 2];
			for (int i = 0; i < row + 2; ++i) {
				for (int j = 0; j < col + 2; ++j) {
					temp[0][j] = 0;
					temp[row + 1][j] = 0;
					temp[i][0] = temp[i][col + 1] = 0;
				}
			}
			// 将原始迷宫复制到新的迷宫中
			for (int i = 0; i < row; ++i) {
				for (int j = 0; j < col; ++j) {
					temp[i + 1][j + 1] = maze[i][j];
				}
			}
			// 从左上角开始按照顺时针开始查询

			int i = 1;
			int j = 1;
			p[i][j] = true;
			stack.push(new Position(i, j));
			while (!stack.empty() && (!(i == (1) && (j == col)))) {

				if ((temp[i][j + 1] == 1) && (p[i][j + 1] == false)) {
					p[i][j + 1] = true;
					stack.push(new Position(i, j + 1));
					j++;
				} else if ((temp[i + 1][j] == 1) && (p[i + 1][j] == false)) {
					p[i + 1][j] = true;
					stack.push(new Position(i + 1, j));
					i++;
				} else if ((temp[i][j - 1] == 1) && (p[i][j - 1] == false)) {
					p[i][j - 1] = true;
					stack.push(new Position(i, j - 1));
					j--;
				} else if ((temp[i - 1][j] == 1) && (p[i - 1][j] == false)) {
					p[i - 1][j] = true;
					stack.push(new Position(i - 1, j));
					i--;
				} else {
					stack.pop();
					if (stack.empty()) {
						break;
					}
					i = stack.peek().row;
					j = stack.peek().col;
				}

			}
			Stack<Position> newPos = new Stack<Position>();
			if (stack.empty()) {
				System.out.println("Can not escape!");
			} else {
				while (!stack.empty()) {
					Position pos = new Position();
					pos = stack.pop();
					newPos.push(pos);
				}
			}

			/*
			 * 输出
			 */

			String resault[][] = new String[row + 1][col + 1];
			for (int k = 0; k < row; ++k) {
				for (int t = 0; t < col; ++t) {
					resault[k][t] = (maze[k][t]) + "";
				}
			}
			int[][] aa = new int[newPos.size()][2];
			int count = 0;
			while (!newPos.empty()) {
				Position p1 = newPos.pop();
				aa[count][0] = p1.row - 1;
				aa[count++][1] = p1.col - 1;

				// System.out.print("["+(p1.row-1)+","+(p1.col-1)+"]");
			}
			for (int a = 1; a < aa.length; a++) {
				if (aa[a][0] < aa[a - 1][0]) {
					status -= 3;
				} else if (aa[a][1] != aa[a - 1][1]) {
					status -= 1;
				}
			}
			if (status < 0) {
				System.out.println("Can not escape!");
				return;
			} else {
				for (int a = 0; a < aa.length; a++) {
					System.out.print("[" + aa[a][0] + "," + aa[a][1] + "]");
					if (a != aa.length - 1) {
						System.out.print(",");
					}
				}
				// System.out.println(status);
			}
		}
	}
}
package 背包问题;



public class Solution {
	// 每个物品的重量
	private static int[] weight;
	// 每个物品的价值
	private static int[] value;
	// 存储重量和包的DP渐增数组
	private static int[][] dp;
	// 当前包能承受的最大的重量值
	private static int max;

	public static void main(String[] args) {
		// 对三个值进行初始化
		weight = new int[] { 1, 4, 5, 6, 8 };
		value = new int[] { 3, 4, 5, 1, 4 };
		max = 10;
		// DP数组，当前包的个数，以及当前所存各个重量，加1是因为要考虑到没有包或重量为0的情况
		dp = new int[weight.length + 1][max + 1];
		initDp(dp);
		// 去找当前包最大重量值为max中可以存储多少个背包
		int result = find(weight.length, max);
		System.out.println(result);
	}

	// 除了横纵或坐标为0的情况其余都为-1 以后用做判断
	public static void initDp(int[][] dp) {
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}
	}

	public static int find(int index, int max) {
		// 不是边界值
		if (dp[index][max] < 0) {
			if (weight[index - 1] > max) {
				dp[index][max] = find(index - 1, max);
			} else {
				//判断选择和不选的情况下那个价值高赋给我们的DP数组最后返回
				dp[index][max] = Math.max(
						find(index - 1, max),
						value[index - 1]
								+ find(index - 1, max - weight[index - 1]));
			}
		}
		return dp[index][max];
	}
}

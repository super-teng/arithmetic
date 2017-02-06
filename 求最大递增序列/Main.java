package 求最大递增序列;

public class Main {
	public int[] list(int[] array){
		if(array == null || array.length == 0){
			return null;
		}
		//求出DP数组
		int[] dp = getDp(array);
		//得出存储递增数组的结果数组
		for(int i =0;i<dp.length;i++){
			System.out.print(dp[i]+" ");
		}
		int[] result = getList(array,dp);
		return result;
	}
	//获取到DP数组的值，每一位中存在递增元素的个数。
	public int[] getDp(int[] array){
		int[] dp = new int[array.length];
		for(int i=0;i<array.length;i++){
			dp[i] = 1;
			for(int j=0;j<i;j++){
				if(array[j] < array[i]){
					dp[i] = Math.max(dp[j] + 1,dp[i]); 
				}
			}
		}
		return dp;
	}
	public int[] getList(int[]array,int[]dp){
		int index = 0;
		int length = 0;
		//找出当前DP数组中递增数最大元素。
		for(int i=0;i<dp.length;i++){
			if(dp[i] > length){
				length = dp[i];
				index = i;
			}
		}
		//找出递增的数组存储到结果数组中去
		int[] result = new int[length];
		result[--length] = array[index];
		for(int i = index;i>=0;i--){
			if(array[i] < array[index] && dp[i] == dp[index]-1){
				result[--length] = array[i];
				index = i;
			}
		}
		return result;
	}
	public static void main(String[] args){
		Main m = new Main();
		int[] array = {1,5,3,7,9};
		int[] result = m.list(array);
		System.out.println();
		for(int i=0;i<result.length;i++){
			System.out.print(result[i]+" ");
		}
	}
}

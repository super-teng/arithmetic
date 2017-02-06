package 二叉搜索树的后序遍历序列;

public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
    	if(sequence == null || sequence.length == 0){
            return false;
        }
        int root = sequence[sequence.length-1];
        int i = 0;
        for(;i<sequence.length-1;i++){
            if(sequence[i] >root){
                break;
            }
        }
        for(int j = i;j<sequence.length-1;j++){
            if(sequence[j] < root){
                return false;
            }
        }
        boolean le = true;
        if(i > 0){
        	int[] left = new int[i];
        	for(int m = 0;m<i;m++){
        		left[m] = sequence[m];
        	}
            le = VerifySquenceOfBST(left);
        }
        boolean ri = true;
        if(sequence.length-1-i > 0){
        	int[] right = new int[sequence.length-1-i];
        	int index = i;
        	for(int n = 0;n<sequence.length-1-i;n++){
        		right[n] = sequence[index++];
        	}
            ri = VerifySquenceOfBST(right);
        }
        return le && ri;
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] sequence = {5,7,3,2,1};
    	System.out.println(s.VerifySquenceOfBST(sequence));
    }
}

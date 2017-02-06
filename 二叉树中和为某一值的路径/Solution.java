package 二叉树中和为某一值的路径;

/*
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
import java.util.ArrayList;
 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Solution {
    
    private ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        int[] path = new int[100];
        int size = 0;
        find(root,path,size,target);
        return list;
    }
    public void find(TreeNode root,int[] path,int size,int target){
        if(root == null){
            return ;
        }
        path[size++] = root.val;
        int sum = 0;
        for(int i=0 ; i<size;i++){
            sum += path[i];
        }
        if(root.left == null && root.right == null){
        	if(sum == target){
        		ArrayList<Integer> l = new ArrayList<Integer>();
                for(int i =0;i<size;i++){
                    l.add(path[i]);
                }
                list.add(l);
        	}
            size = 0;
        }else{
            find(root.left,path,size,target);
            find(root.right,path,size,target);
        }
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	TreeNode t = new TreeNode(10);
    	TreeNode t1 = new TreeNode(5);
    	TreeNode t2 = new TreeNode(12);
    	TreeNode t3 = new TreeNode(4);
    	TreeNode t4 = new TreeNode(7);
    	t.left = t1;
    	t.right = t2;
    	t1.left = t3;
    	t1.right = t4;
    	ArrayList<ArrayList<Integer>> list = s.FindPath(t, 22);
    	for(int i = 0;i<list.size();i++){
    		ArrayList<Integer> l = list.get(i);
    		for(int j = 0;j<l.size();j++){
    			System.out.print(l.get(j)+" ");
    		}
    		System.out.println();
    	}
    }
}

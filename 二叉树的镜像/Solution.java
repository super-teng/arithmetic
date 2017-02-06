package 二叉树的镜像;

/*
 * 操作给定的二叉树，将其变换为源二叉树的镜像。 
 */
public class Solution {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}
	}

	public void Mirror(TreeNode root) {
		if(root == null){
			return;
		}
		//交换左右的节点
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		//递归调用本方法判断左右节点
		Mirror(root.left);
		Mirror(root.right);
	}
}

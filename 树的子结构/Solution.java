package 树的子结构;

/*
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
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
	//查找B中节点是否在A中出现
	 public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		 //结果标识
		 boolean result = false;
		 if(root1 != null && root2 != null){
			 //如果两个节点值相同的话就去找其下面的结构是否一致
			 if(root1.val == root2.val){
				 result = judgeSonTree(root1,root2);
			 }
			 //如果没有找到则去root1的左子树中进行查找
			 if(!result){
				 result = HasSubtree(root1.left,root2);
			 }
			 //如果没找到则取我们的右子树进行查找
			 if(!result){
				 result = HasSubtree(root1.right,root2);
			 }
		 }
		 return result;
	 }
	 //用递归思想去找子结构
	 public boolean judgeSonTree(TreeNode root1,TreeNode root2){
		 //假如右子树为空则说明右子树已经判断完毕则右是左的子树
		 if(root2 == null){
			 return true;
		 }
		 //如果右子树没为空左子树为空了则不成立了
		 if(root1 == null){
			 return false;
		 }
		 //如果根节点1的值与根节点2的值不等了则不成立
		 if(root1.val != root2.val){
			 return false;
		 }
		 return judgeSonTree(root1.left,root2.left) && judgeSonTree(root1.right,root2.right);
	 }
	 public static void main(String[] args){
		 Solution s = new Solution();
		 TreeNode t1 = s.new TreeNode(3);
		 TreeNode t2 = s.new TreeNode(2);
		 TreeNode t3 = s.new TreeNode(4);
		 TreeNode t4 = s.new TreeNode(1);
		 t1.left = t2;
		 t1.right = t3;
		 t2.left = t4;
		 TreeNode p1 = s.new TreeNode(2);
		 TreeNode p2 = s.new TreeNode(1);
		 p1.left = p2;
		 System.out.println(s.HasSubtree(t1,p1));
	 }
}

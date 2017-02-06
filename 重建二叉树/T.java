package ÖØ½¨¶þ²æÊ÷;

import java.util.Stack;

public class T {
	class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	public TreeNode re(int[] pre,int [] in){
		return r(pre,0,pre.length,in,0,in.length);
	}
	public TreeNode r(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
		if(preStart > preEnd || inStart >inStart){
			return null;
		}
		TreeNode root = new TreeNode(pre[preStart]);
		for(int i=inStart;i<inEnd;i++){
			if(in[i] == pre[preStart]){
				root.left = r(pre,preStart+1,preStart+i-inStart,in,inStart,i-1);
				root.right = r(pre,preStart+i+1-inStart,preEnd,in,i+1,inEnd);
			}
		}
		return root;
	}
}

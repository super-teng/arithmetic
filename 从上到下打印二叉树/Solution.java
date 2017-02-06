package 从上到下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null ){
            return null;
        }
        queue.offer(root);
        TreeNode temp = root;
        while(!queue.isEmpty()){
           temp = queue.poll();
           list.add(temp.val);
           if(temp.left != null){
               queue.offer(temp.left);
           }
           if(temp.right != null){
               queue.offer(temp.right);
           }
        }
        return list;
    }
}

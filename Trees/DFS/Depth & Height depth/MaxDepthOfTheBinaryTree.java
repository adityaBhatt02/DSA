package Trees.DFS;

import Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


// Same ques referred as Maximum Depth Of Binary Tree == Height of the binary tree
public class MaxDepthOfTheBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return Math.max(leftHeight , rightHeight) + 1;
    }
}



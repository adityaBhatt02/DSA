/*
In this question we need to tell that the given binary tree is balanced or not (Balanced means that for every node its left
and right subtrees are balanced not just for the root)
When a problem says "for every node", checking only the root is never enough.
And for balanced binary tree -> left subtree's depth(height) - right subtree's depth(height)
 */

public class BalancedBinaryTree {
        public boolean isBalanced(TreeNode root) {
            return checkHeight(root) != -1;
        }

        public int checkHeight(TreeNode root) {
            if(root == null) return 0;

            int left = checkHeight(root.left);
            if(left == -1) return -1;

            int right = checkHeight(root.right);
            if(right == -1) return -1;

            if(Math.abs(left - right) > 1) return -1;

            return 1 + Math.max(left, right);
        }
}
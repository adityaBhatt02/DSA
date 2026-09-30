package Trees.DFS;

import Trees.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert(TreeNode root) {
        if(root == null) {
            return;
        }

        invert(root.left);
        invert(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}



// BFS
class InvertBinaryTreeBFS {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            TreeNode temp = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = temp;

            if (currentNode.left != null) queue.offer(currentNode.left);
            if (currentNode.right != null) queue.offer(currentNode.right);
        }

        return root;
    }
}
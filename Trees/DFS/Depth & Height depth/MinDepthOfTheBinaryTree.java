// Minimum depth of binary tree ->
public class minDepth {
    // 1. with bfs(recommended) :
    public int minDepthWithBfs(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }

                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            depth++;
        }
        return depth;
    }

//    2. with dfs(more time complexity)
//    public int minDepthWithDfs(TreeNode root) {
//        if (root == null) return 0;
//
//        int leftDepth = minDepthWithBfs(root.left);
//        int rightDepth = minDepthWithBfs(root.right);
//
//        if (leftDepth == 0) return rightDepth + 1;
//        if (rightDepth == 0) return leftDepth + 1;
//
//        return Math.min(leftDepth, rightDepth) + 1;
//    }
}
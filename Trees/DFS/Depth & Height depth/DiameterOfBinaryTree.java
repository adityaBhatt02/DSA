package Trees.DFS;

import Trees.TreeNode;

// Diameter is longest path b/w any two nodes.
// Measured anywhere in the tree not just from the root(like height)

public class DiameterOfBinaryTree {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);          // This gives number of edges. If you do left + right + 1
        /*
        for eg :       1                                   At 1 -> leftHeight = 2, rightHeight = 1
                      / \                                  leftHeight + rightHeight = 3 edges
                     2   3                                 leftHeight + rightHeight + 1 = 4 nodes
                    /
                   4
         */

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

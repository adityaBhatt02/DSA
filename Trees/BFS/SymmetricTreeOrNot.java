package Trees.BFS;

import Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/* mirror of itself (i.e., symmetric around its center).
mirror(symmetric) ka mtlb hae ke jaise the tree is like  :            [1] , [2,2] , [3 , 4 , 4 , 3] -> so left.left should be equal to right.right and left.right should be equal to right.left
 */
public class SymmetricTreeOrNot {
    public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root.left);
    queue.add(root.right);

    while(!queue.isEmpty()) {
        TreeNode left = queue.poll();
        TreeNode right = queue.poll();

        if(left == null && right == null) {
            continue;
        }
        if(left == null || right == null) {
            return false;
        }
        if(left.val != right.val) {
            return false;
        }

        queue.add(left.left);
        queue.add(right.right);
        queue.add(left.right);
        queue.add(right.left);
    }

    return true;
    }
}

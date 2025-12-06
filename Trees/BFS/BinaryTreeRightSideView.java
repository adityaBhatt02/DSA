package Trees.BFS;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// If there are no right children, then the left children are still considered — because from the right side of the tree, you would still see them!

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelLength = queue.size();

            for(int i = 0 ; i < levelLength ; i++) {
                TreeNode currentNode = queue.poll();

                if(i == levelLength - 1) result.add(currentNode.val);

                if(currentNode.left != null) queue.offer(currentNode.left);
                if(currentNode.right != null) queue.offer(currentNode.right);
            }
        }
        return result;
    }
}

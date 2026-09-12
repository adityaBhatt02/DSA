package Trees.BFS;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root);

        int level = 0;
        while(!deque.isEmpty()) {
            int levelLength = deque.size();
            List<Integer> levelNodes = new ArrayList<>();

            if(level % 2 == 0) {
                for(int i = 0; i < levelLength; i++) {
                    TreeNode currentNode = deque.pollFirst();
                    levelNodes.add(currentNode.val);

                    if(currentNode.left != null) deque.offerLast(currentNode.left);
                    if(currentNode.right != null) deque.offerLast(currentNode.right);
                }
            } else {
                for(int i = 0; i < levelLength; i++) {
                    TreeNode currentNode = deque.pollLast();
                    levelNodes.add(currentNode.val);

                    if(currentNode.right != null) deque.offerFirst(currentNode.right);
                    if(currentNode.left != null) deque.offerFirst(currentNode.left);
                }
            }
            result.add(levelNodes);
            level++;
        }
        return result;
    }
}

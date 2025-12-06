package Trees.BFS;

import Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumOfBinaryTree {
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        int level = 1;
        int answerLevel = 1;
        int maxSum = Integer.MIN_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelLength = queue.size();
            int currentSum = 0;

            for(int i = 0 ; i < levelLength ; i++) {
                TreeNode currentNode = queue.poll();
                currentSum += currentNode.val;

                if(currentNode.left != null) queue.offer(currentNode.left);
                if(currentNode.right != null) queue.offer(currentNode.right);
            }
            if(currentSum > maxSum) {
                maxSum = currentSum;
                answerLevel = level;
            }
            level++;
        }
        return answerLevel;
    }
}

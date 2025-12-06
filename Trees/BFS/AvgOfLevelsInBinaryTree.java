package Trees.BFS;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AvgOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelLength = queue.size();
            double avg = 0;

            for(int i = 0 ; i < levelLength ; i++){
                TreeNode currentNode = queue.poll();
                avg += currentNode.val;
                if(currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            avg /= levelLength;
            result.add(avg);
        }
        return result;

    }
}

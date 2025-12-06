package Trees.BFS;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Input: root = [2,3,5,8,13,21,34]
Output: [2,5,3,8,13,21,34]
Explanation:
The tree has only one odd level.
The nodes at level 1 are 3, 5 respectively, which are reversed and become 5, 3.
 */

public class ReverseOddLevelsOfBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while(!queue.isEmpty()) {
            int levelLength = queue.size();
            List<TreeNode> currentLevel = new ArrayList<>();

            for(int i = 0 ; i < levelLength ; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode);

                if(currentNode.left != null) queue.offer(currentNode.left);
                if(currentNode.right != null) queue.offer(currentNode.right);
            }

            if(level % 2 != 0) {       // if the level is odd then currentLevel waale list mae isliye store kre the nodes then unki values ko reverse krdena bs
                int left = 0 , right = currentLevel.size() - 1;

                while(left < right) {
                    int temp = currentLevel.get(left).val;
                    currentLevel.get(left).val = currentLevel.get(right).val;
                    currentLevel.get(right).val = temp;

                    left++;
                    right--;
                }
            }
            level++;
        }
        return root;
    }
}

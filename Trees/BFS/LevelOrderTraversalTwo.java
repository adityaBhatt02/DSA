package Trees.BFS;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
this is same as normal level order traversal but isme last waale level ke phle then uske upar waale fir root
at last(means ulta show krna hae of normal level order traversal)
 */

public class LevelOrderTraversalTwo {
     public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            if(root == null) return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()) {
                int levelLength = queue.size();
                List<Integer> currentLevel = new ArrayList<>(levelLength);

                for(int i = 0 ; i < levelLength ; i++){
                    TreeNode currentNode = queue.poll();
                    currentLevel.add(currentNode.val);
                    if(currentNode.left != null) {
                        queue.offer(currentNode.left);
                    }
                    if(currentNode.right != null) {
                        queue.offer(currentNode.right);
                    }
                }
                result.add(0 , currentLevel);      // bss jo bhi level pr ho usko 0th index pr daaldena result ke to wo automatically at last aakhri waala first hojaega.
            }
            return result;
        }
}

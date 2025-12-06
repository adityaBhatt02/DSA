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
            int level = 1;

            while(!deque.isEmpty()) {
                int levelLength = deque.size();
                List<Integer> currentLevel = new ArrayList<>();

                /*
                if the level is odd then normally jo krte hae waise kro ke poll from left(Aage se) and
                offer to right(peeche se).
                 */

                if(level % 2 != 0) {
                    for(int i = 0 ; i < levelLength ; i++) {
                        TreeNode currentNode = deque.pollFirst();
                        currentLevel.add(currentNode.val);

                        if(currentNode.left != null) {
                            deque.offerLast(currentNode.left);
                        }
                        if(currentNode.right != null) {
                            deque.offerLast(currentNode.right);
                        }
                    }}
                /*
                if the level is even then poll krna from last and offer krna phle right node to the first
                and then left to the first.
                 */
                else {
                    for(int i = 0 ; i < levelLength ; i++) {
                        TreeNode currentNode = deque.pollLast();
                        currentLevel.add(currentNode.val);

                        if(currentNode.right != null) {
                            deque.offerFirst(currentNode.right);
                        }
                        if(currentNode.left != null) {
                            deque.offerFirst(currentNode.left);
                        }
                    }}
                level++;
                result.add(currentLevel);
            }
            return result;
        }
    }

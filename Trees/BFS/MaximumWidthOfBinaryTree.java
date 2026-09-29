/*
Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).

Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
 */

class Pair {
    TreeNode node;
    long index;

    Pair(TreeNode node, long index) {
        this.node = node;
        this.index = index;
    }
}

public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Queue<Pair> queue = new LinkedList<>();
        long maxWidth = 0;

        queue.offer(new Pair(root, 1));

        while(!queue.isEmpty()) {
            int levelLength = queue.size();
            long firstIndex = 0, lastIndex = 0;

            for(int i = 0; i < levelLength; i++) {
                Pair currentPair = queue.poll();

                TreeNode currentNode = currentPair.node;
                long index = currentPair.index;

                if(currentNode.left != null) queue.offer(new Pair(currentNode.left, 2 * index));
                if(currentNode.right != null) queue.offer(new Pair(currentNode.right, 2 * index + 1));

                if(i == 0) firstIndex = index;
                if(i == levelLength - 1) lastIndex = index;
            }

            maxWidth = Math.max(maxWidth, lastIndex - firstIndex + 1);
        }
        return (int) maxWidth;
    }
}
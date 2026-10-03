/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelLength = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i = 0; i < levelLength; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                for(Node child : currentNode.children) queue.offer(child);
            }
            result.add(currentLevel);
        }

        return result;
    }
}
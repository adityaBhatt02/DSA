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



/*
PROCESS the node first --> then PUSH childrens in reverse order
Why reverse? Because Stack is LIFO, so the first child should come out first.

Example:
       1
    /  |  \
   2   3   4
      / \
     5   6

Preorder: 1 2 3 5 6 4
 */
class PreOrderTraversalWithoutRecursion {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node current = stack.pop();
            result.add(current.val);

            for(int i = current.children.size() - 1; i >= 0; i--) stack.push(current.children.get(i));
        }

        return result;
    }
}
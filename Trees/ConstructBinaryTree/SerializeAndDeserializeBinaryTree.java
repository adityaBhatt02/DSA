/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored
in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another
computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization
algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be
deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Example 1:
Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]

Example 2:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
 */


public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if(sb.length() > 0) sb.append(',');

            if(current == null) {                       // if the current node is null just append in the string as 'N'
                sb.append('N');
            } else {
                sb.append(current.val);
                /*
                we are not checking for null values becz we need to serialize null nodes as well for preserving the structure
                of the tree while we deserialize the tree
                 */
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()) return null;

        String[] parts = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while(!queue.isEmpty() && i < parts.length) {
            TreeNode parent = queue.poll();

            // Left child
            if(i < parts.length && !parts[i].equals("N")) {             // if the token at 'i' is null skip it we dont need to create a node and attach to the parent for null nodes.
                TreeNode left = new TreeNode(Integer.parseInt(parts[i]));
                parent.left = left;
                queue.offer(left);
            }
            i++;

            // Right Child
            if(i < parts.length && !parts[i].equals("N")) {
                TreeNode right = new TreeNode(Integer.parseInt(parts[i]));
                parent.right = right;
                queue.offer(right);
            }
            i++;
        }
        return root;
    }
}
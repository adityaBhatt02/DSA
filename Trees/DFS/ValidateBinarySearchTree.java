/*
BST
 ↓
Inorder traversal
 ↓
Must come in strictly increasing order
 ↓
Keep only the previous node
 ↓
current.val <= prev.val ?
    YES → false
    NO  → continue


Most optimal approach becz we are returning false if we found out that a BST is not valid in b/w also.

Because inorder traversal of a valid BST should be:
small → bigger → bigger → bigger

So every time you visit a node, just check:
current value > previous value
 */

public class ValidateBinarySearchTree {
        private TreeNode prev = null;

        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;

            if (!isValidBST(root.left)) return false;

            if (prev != null && root.val <= prev.val) return false;

            prev = root;

            return isValidBST(root.right);
        }
}

/*
This is also an approach but it takes O(n) space complexity becz we are creating a List that contains all the nodes at last
and then we are looping over it and checking if the sorting is valid or not.
 */
class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);

        for(int i = 0; i < result.size() - 1; i++) if(result.get(i) >= result.get(i + 1)) return false;

        return true;
    }

    private void inOrder(TreeNode root, List<Integer> result) {
        if(root == null) return;

        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }
}
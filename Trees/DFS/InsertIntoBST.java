/*
You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion.
It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion.
You can return any of them.

Example 1:
Input: root = [4,2,7,1,3], val = 5
Output: [4,2,7,1,3,5]

Example 2:
Input: root = [40,20,60,10,30,50,70], val = 25
Output: [40,20,60,10,30,50,70,null,null,25]
 */

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root, val);
    }

    private TreeNode insert(TreeNode root, int val) {
        if(root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }

        if(root.val > val) {
            TreeNode leftNode = insert(root.left, val);
            root.left = leftNode;
            return root;
        }

        if(root.val < val) {
            TreeNode rightNode = insert(root.right, val);
            root.right = rightNode;
            return root;
        }

        return root;
    }
}

/*
                4
               / \
              2   7
             / \
            1   3
val = 8
*/
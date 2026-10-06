package Trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPostorderAndInorderTraversal {
    private int postIndex;
    private Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;

        for(int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);

        return helper(0, inorder.length - 1, inorder, postorder);
    }

    private TreeNode helper(int start, int end, int[] inorder, int[] postorder) {
        if(start > end) return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = inMap.get(rootVal);

        root.right = helper(inIndex + 1, end, inorder, postorder);
        root.left = helper(start, inIndex - 1, inorder, postorder);

        return root;
    }
}

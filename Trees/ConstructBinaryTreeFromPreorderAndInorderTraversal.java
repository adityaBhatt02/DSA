package Trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    int preIndex = 0;
    Map<Integer , Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder , int[] inorder) {
            for (int i = 0; i < inorder.length ; i++) {
                map.put(inorder[i] , i);
        }
            return helper(preorder , 0 , inorder.length - 1);
    }

    public TreeNode helper(int[] preorder , int start , int end) {
        if(start > end) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode();

        int inIndex = map.get(rootVal);

        root.left = helper(preorder , start , inIndex - 1);
        root.right = helper(preorder , inIndex + 1 , end);

        return root;
    }
}

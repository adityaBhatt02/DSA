package Trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPostorderAndInorderTraversal {
    int postIndex;
    Map<Integer , Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] postorder , int[] inorder) {
        postIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length ; i++) {
            map.put(inorder[i] , i);
        }
        return helper(postorder , 0 , inorder.length - 1);
    }

    public TreeNode helper(int[] postorder , int start , int end) {
        if(start > end) return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = map.get(rootVal);

        root.right = helper(postorder , inIndex + 1 , end);
        root.left = helper(postorder , start , inIndex - 1);

        return root;
    }
}

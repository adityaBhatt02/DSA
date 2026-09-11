public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        inOrder(root, result);
        return result;
    }

    private void inOrder(TreeNode root, List<Integer> result) {
        if(root == null) return;

        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }
}
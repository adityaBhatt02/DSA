/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

example 1 : 
Input: p = [1,2,3], q = [1,2,3]
Output: true

example 2:
Input: p = [1,2], q = [1,null,2]
Output: false


For Same Tree, you're not just checking:
same values?
You're checking: same values + same structure

So:
p.left ↔ q.left
p.right ↔ q.right
must always correspond.
So if p's left is null but q's dont its false and vice-versa.
Similarly, if p's right is null but q's dont its false and vice versa.
*/

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(p);
        queue2.offer(q);

        while(!queue1.isEmpty() && !queue2.isEmpty()) {

            TreeNode n1 = queue1.poll();
            TreeNode n2 = queue2.poll();

            if(n1.val != n2.val) return false;

            // Comparing left childern
            if(n1.left != null && n2.left == null) return false;
            if(n1.left == null && n2.left != null) return false;

            // Comparing right childern
            if(n1.right != null && n2.right == null) return false;
            if(n1.right == null && n2.right != null) return false;

            if(n1.left != null) {
                queue1.offer(n1.left);
                queue2.offer(n2.left);
            }
            if(n1.right != null) {
                queue1.offer(n1.right);
                queue2.offer(n2.right);
            }
        }
        return true;
    }
}

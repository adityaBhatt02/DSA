/*
1. maxPathSum() returns the final answer

2. helper() returns information to its parent --> private int helper(TreeNode root)
This return value is not the final answer.

It is saying: "Parent, this is the best path you can use from my subtree."
And the parent needs that information to calculate its own pathSum.

Look at:
        10
       /
      20
     /  \
    15   7
    
At 20, you calculate:  int pathSum = 15 + 20 + 7;
So: pathSum = 42
You update: maxSum = 42;

But now you go back to 10.
10 needs to calculate its own: pathSum = root.val + leftSum + rightSum;

What is leftSum?
It comes from: helper(20)
So helper(20) must return something useful.

It returns: 20 + Math.max(15, 7) = 35

Now 10 can do: 10 + 35
and potentially make an even bigger global answer.
*/

package Trees.DFS;

import Trees.TreeNode;

public class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    public int helper(TreeNode root) {
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        left = Math.max(0 , left);
        right = Math.max(0 , right);

        int pathSum = left + right  + root.val;

        maxSum = Math.max(maxSum , pathSum);

        return Math.max(left , right) + root.val;
    }
}

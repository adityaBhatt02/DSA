package Trees.BFS;

import Trees.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumNumberOfOperationsToSortEachLevel {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int operations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] level = new int[size];

            // Collect values for current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level[i] = node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Add swaps required to sort this level
            operations += minSwaps(level);
        }

        return operations;
    }

    // Function to calculate minimum swaps to sort an array
    private int minSwaps(int[] arr) {
        int n = arr.length;

        // Create value-index pairs
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = arr[i];
            pairs[i][1] = i;
        }

        // Sort by value
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || pairs[i][1] == i) continue;

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = pairs[j][1];
                cycleSize++;
            }

            swaps += cycleSize - 1;
        }

        return swaps;
    }
}

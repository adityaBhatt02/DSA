/*
Suppose:
n = total number of nodes
L = number of levels
k = requested kth largest level sum
W = maximum width of the tree

1. Time complexity
Step 1: BFS

currentNode = queue.poll();
Every node gets removed from the queue exactly once.

For example:
        1
       / \
      2   3
     / \
    4   5

BFS processes:
1 → 2 → 3 → 4 → 5

So the total number of node operations is n.

Therefore: BFS = O(n)
The if checks for left/right are also constant work per node, so they don't change that.


Step 2: PriorityQueue
For every level, you do:
pq.offer(levelSum);

A PriorityQueue insertion costs:
O(log k)

Why k and not n?
Because you're always maintaining the heap at size at most k.

if (pq.size() > k) pq.poll();

And poll() also costs: O(log k)
There are L levels.

So PriorityQueue work is: O(L log k)            // hrr ek level pr either insertion hora ya poll ya dono so at every level 'L'


Step 3: Combine them ->

BFS: O(n)
PriorityQueue: O(L log k)

Therefore: O(n + L log k)
That's the precise complexity.

Since the number of levels can never be greater than the number of nodes:

L <= n
you may sometimes see it described as: O(n log k)

but O(n + L log k) is more precise.


2. Space complexity
There are two important data structures.

** Queue ->
Queue<TreeNode> queue = new LinkedList<>();

The queue stores nodes waiting to be processed.
How many nodes can it hold at once?
At most the maximum width of the tree.
Call that W.

So: Queue = O(W)
For a very wide tree:

             1
        /         \
       2           3
     / | \       / | \
    ...
The queue can contain many nodes from the same level.
So we don't simply say O(n) for the queue's actual peak usage; the precise term is: O(W)


** PriorityQueue ->

You deliberately keep only k elements:

if (pq.size() > k) pq.poll();

Therefore: PriorityQueue = O(k)

Total space
Both can exist at the same time:

Queue          = O(W)
PriorityQueue  = O(k)

Therefore:
O(W + k)


4. Your final interview answer

Time: O(n + L log k) because BFS visits every node once, and for each of the L levels we perform PriorityQueue operations costing O(log k).

Space: O(W + k) where W is the maximum width of the binary tree. The BFS queue can hold up to W nodes and the min-heap stores at most k level sums.

Mental picture
Think of it as two separate jobs:

TREE
 ↓
BFS → touch every node once → O(n)

LEVEL SUMS
 ↓
Min Heap of max size k
 ↓
L insert/remove operations → O(L log k)

So:
TIME  = O(n + L log k)
SPACE = O(W + k)
 */

public class KthLargestSumInABinaryTree {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelLength = queue.size();
            long levelSum = 0;

            for (int i = 0; i < levelLength; i++) {
                TreeNode currentNode = queue.poll();

                levelSum += currentNode.val;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            pq.offer(levelSum);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        if (pq.size() < k) return -1;

        return pq.peek();
    }
}
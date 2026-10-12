/*
State Meaning:

What to do
0 --> Unvisited  (Start DFS on this node)

1 --> Currently being processed; on the current DFS path
(If you encounter this node again through an edge, a directed cycle exists)

2 --> Completely processed; DFS has finished exploring its outgoing neighbours
(Don't run DFS on it again)


state 1 means: if a neighbour is already in state 1, it is on the current recursion path, so you've found a back edge and
therefore a directed cycle.

state 2 means: it doesn't necessarily mean the node was processed in another path. It means DFS has finished processing it.
That could have happened earlier in another branch, or earlier in the current traversal.
 */
import java.util.*;

public class TopologicalSortDFS {
    public static List<Integer> topologicalSort(int V, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < V; i++) adjList.put(i, new ArrayList<>());

        for(int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];

            adjList.get(source).add(destination);
        }

        // 0 = unvisited, 1 = currently being processed on the current dfs path, 2 = completely processed
        int[] state = new int[V];

        Stack<Integer> stack = new Stack<>();

        // There may be different components in the graph
        for(int i = 0; i < V; i++) {
            if(state[i] == 0) {
                // for cyclic directed graph Topological sort order doesnt exist
                if(!dfs(i, adjList, state, stack)) return new ArrayList<>();
            }
        }

        // Pop the stack to get the topological order
        List<Integer> order = new ArrayList<>();
        while(!stack.isEmpty()) order.add(stack.pop());

        return order;
    }


    private static boolean dfs(int currentNode, Map<Integer,List<Integer>> adjList, int[] state, Stack<Integer> stack) {

        // mark node as currently being explored
        state[currentNode] = 1;

        for(int neighbour : adjList.get(currentNode)) {
            // A back edge to current DFS path means a cycle
            if(state[neighbour] == 1) return false;

            // explore an unvisited neighbour
            if(state[neighbour] == 0) {
                if(!dfs(neighbour, adjList, state, stack)) return false;
            }
        }

        // All outgoing neighbours are finished
        state[currentNode] = 2;
        stack.push(currentNode);

        return true;
    }


    public static void main(String[] args) {
        int V = 6;

        int[][] edges = {{1, 3}, {2, 3}, {4, 1}, {4, 0}, {5, 0}, {5, 2}};
        System.out.println(topologicalSort(V, edges));
    }
}


/*
Why do we push after DFS instead of before it?

This is the most important conceptual question.
Suppose we have:
0 → 1 → 2

DFS visits nodes in this order:
0 → 1 → 2

But we push them in the opposite finishing order:
2 → 1 → 0

Why?
Node 2 has no neighbours left to explore, so we push 2 first.
Node 1 can finish only after node 2 finishes, so we push 1 next.
Node 0 finishes last, so we push 0 last.

When we pop the stack, we get:
0 → 1 → 2

Therefore, DFS finishing order is reversed to produce the topological order.



Complexity ->
Time: O(V+E), because each vertex and edge is processed a constant number of times.

Space: O(V+E), for the adjacency list, state array, stack, and recursion stack.
 */
/*
PriorityQueue + Queue = task scheduling with cooldown.

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.

Example 2:

Input: tasks = ["A","C","A","B","D","B"], n = 1
Output: 6
Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.

With a cooling interval of 1, you can repeat a task after just one other task.
*/


class Task implements Comparable<Task>{
    int freq;
    int executionTime;

    public Task(int freq, int executionTime) {
        this.freq = freq;
        this.executionTime = executionTime;
    }

    public int compareTo(Task that) {
        return that.freq - this.freq;
    }
}

class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for(char task : tasks) freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);

        PriorityQueue<Task> pq = new PriorityQueue<>();

        for(int val : freqMap.values()) pq.offer(new Task(val, 0));

        Queue<Task> queue = new LinkedList<>();
        int time = 0;

        while(!pq.isEmpty() || !queue.isEmpty()) {
            time++;

            // check if there is a task in priority queue and process it 
            if(!pq.isEmpty()) {
                Task task = pq.poll();
                task.freq --;

                if(task.freq > 0) {
                    task.executionTime = time + n;
                    queue.offer(task);
                }
            }

            // shift active process to priority queue
            if(!queue.isEmpty() && queue.peek().executionTime == time) pq.offer(queue.poll());
        }

        return time; 
    }
}

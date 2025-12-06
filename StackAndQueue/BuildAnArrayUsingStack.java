package StackAndQueue;

import java.util.ArrayList;
import java.util.List;

/*
You are given an integer array target and an integer n.   {ess ques mae 'n' ke kuch bhi need hae, and target array is strictly increasing}
You have an empty stack with the two following operations:

"Push": pushes an integer to the top of the stack.
"Pop": removes the integer on the top of the stack.
You also have a stream of the integers in the range [1, n].

 */
public class BuildAnArrayUsingStack {
    public List<String> buildArray(int[] target, int n) {
        List<String> op = new ArrayList<>();
        int current = 1;

        for(int num : target) {
            while(current < num) {
                op.add("Push");
                op.add("Pop");
                current++;
            }
            op.add("Push");
            current++;
    }
        return op;
    }
}

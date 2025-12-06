package Maths;

/*
A number is happy when uss number ke hrr element ka square krke sum krte rhe fir uska fir uska then
agr 1 aaya khi kisike sum ka then it will be happy number otherwise not (then infinite loop mae atk jaoge)

so that's why we use floyd warshall technique for this slow and fast(just like in linkedlist cycle detection)
both slow and fast start with n and slow moves one step and fast takes 2 steps if they meet means there
is a cycle(infinite loop) means not a happy number is there.
And if it is a happy number fast will become 1 first then eventually slow so they are same exit the loop
and return.

eg: 4(is unhappy)
4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 ...   (cycle is there)

19(is happy)
19 -> 82 -> 68 -> 100 -> 1 -> 1 ...       (1 will be there now)
 */

public class HappyNumber {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = sumOfSq(slow);
            fast = sumOfSq(sumOfSq(fast));
        } while(slow != fast);

        return slow == 1;
    }

    public int sumOfSq(int n) {
        int sum = 0;
        while(n > 0) {
            int rem = n % 10;
            sum += rem * rem;
            n /= 10;
        }
        return sum;
    }
}

package Array;

// using xor
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;

        int XOR_1 = 0;
        for(int num : nums) XOR_1 ^= num;

        int XOR_2 = 0;
        for(int i = 0; i < n; i++) XOR_2 ^= i;

        return XOR_1 ^ XOR_2;
    }
}


// using n(n+1)/2 approach
public class MissingNumberDiffApproach {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int maxSum = n * (n + 1) / 2;
        int currentSum = 0;

        for (int num : nums) currentSum += num;

        return maxSum - currentSum;
    }
}

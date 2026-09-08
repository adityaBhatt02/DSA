/*
This question is basically ->
Find the maximum sum of exactly k elements where the chosen elements form a contiguous segment on a circular array.
The cards can only be taken from the left end or right end.

For example:
cards = [1, 2, 3, 4, 5, 6, 7], k = 3

Possible choices include:
[1, 2, 3]        → left 3
[7, 6, 5]        → right 3
[1, 2, 7]        → left 2 + right 1
[1, 6, 7]        → left 1 + right 2
 */

public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int lSum = 0, rSum = 0, maxSum = 0;

        for(int i = 0; i < k; i++) {
            lSum += cardPoints[i];
            maxSum = lSum;
        }

        int rIndex = cardPoints.length - 1;
        for(int i = k - 1; i >= 0; i--) {
            lSum = lSum - cardPoints[i];
            rSum = rSum + cardPoints[rIndex];

            maxSum = Math.max(maxSum, lSum + rSum);
            rIndex--;
        }

        return maxSum;
    }
}
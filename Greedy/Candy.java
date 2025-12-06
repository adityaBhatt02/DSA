package Greedy;

/*
so the ques is saying that - there are n candies and an array ratings is given so every child is given a rating
and the ques states that we need to give each child atleast one candy and the child with the higher rating than
its neighbor gets more candy than them. we need to return minimum number of candies required to distribute to each child.

approach is that ke we will make 2 arrays left and right and then compare for left[] and then right[]
{so the checking is like -> for left[] when i = 0 that children will always get one candy , same for i = rating.length - 1 in right[] ......... and in left array if the value
of the element at right is greater than the left one (of the ratings array) then that child will get +1 candy than him ,,,,, but if smaller or equal it will get only bare
minimum which is 1 candy.................and vice versa for the right array in which we loop backwards and then check with the right element.}

then at last take the max values b/w left and right array
at that index "i" then add it in your sum or candy.

eg : Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 */

public class Candy {
     public int candy(int[] ratings) {
            int[] left = new int[ratings.length];
            int[] right = new int[ratings.length];


            // for checking with the left neighbor
            for(int i = 0 ; i < ratings.length ; i++) {
                if(i == 0) {
                    left[0] = 1;
                }else{
                    if(ratings[i] > ratings[i - 1]) {
                        left[i] = left[i-1] + 1;
                    }else if(ratings[i] <= ratings[i - 1]) {
                        left[i] = 1;
                    }}}

         // for checking with the right neighbor
         for(int j = ratings.length - 1 ; j >= 0 ; j--) {
                if(j == ratings.length - 1) {
                    right[j] = 1;
                }else{
                    if(ratings[j] > ratings[j + 1]) {
                        right[j] = right[j + 1] + 1;
                    }else if(ratings[j] <= ratings[j + 1]) {
                        right[j] = 1;
                    }
                }}

            int candies = 0;
            for(int k = 0 ; k < ratings.length ;k++) {
                candies += Math.max(left[k] , right[k]);
            }

            return candies;
        }
    }

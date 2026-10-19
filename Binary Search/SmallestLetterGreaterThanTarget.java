package BinarySearchQuestions;

public class SmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'c' , 'f' ,'j'};
        char target = 'c';
        char ans = nextGreatestLetter(letters , target);
        System.out.println(ans);
    }

 static char nextGreatestLetter(char[] letters, char target) {
    int start = 0;
    int end = letters.length - 1;

    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (letters[mid] > target) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    return letters[start % letters.length];             // letters are wrapped(like if last then return first)    ---> Wrap karna hota hae then modulo lagate hae
     // like (0 % 3 = 0 , 1 % 3 = 1 , 2 % 3 = 2 , 3 % 3 = 0{wrap around})
}}

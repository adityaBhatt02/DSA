public class SortVowelsInAString {

}



/*
This my good approach but not the optimal becz
Time - O(k logk), Space - O(k)
 */
class SortVowelsInAStringII {
    public String sortVowels(String s) {
        /*
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare((int) a, (int) b);
        });

        But you actually don't need the casts because Java can promote char to int automatically:

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a, b);
        });
         */
        // Character's natural ordering is already based on its Unicode value, and for ASCII characters that corresponds to their ASCII values.
        PriorityQueue<Character> pq = new PriorityQueue<>();

        char[] arr = s.toCharArray();
        // loop for collecting all vowels in PriorityQueue and sort them according to their ASCII values
        for(char ch : arr) {
            if(isVowel(ch)) {
                pq.offer(ch);  // sorting takes O(logk) and then you have k vowels so performs this k times so --> O(k logk)
            }
        }

        // loop for swaping the vowel positions according to their ASCII values
        for(int i = 0; i < arr.length; i++) {
            if(isVowel(arr[i])) arr[i] = pq.poll();  // O(log k) becz it does remove + heapify --> heapify basically means removing is O(1) but then java sorts the min heap(tree) again until its valid and it can goes upto height of the tree,so, --> O(logk)
        }

        return new String(arr);
    }

    private boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
        }
        return false;
    }
}
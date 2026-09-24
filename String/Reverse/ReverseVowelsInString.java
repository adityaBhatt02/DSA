public class ReverseVowelsInString {
    public String reverseVowels(String s) {
        if(s.length() == 0) return s;

        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while(left < right) {
            while(left < right && !isVowel(arr[left])) left++;

            while(left < right && !isVowel(arr[right])) right--;

            if(left < right) swap(arr, left, right);

            left++;
            right--;
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

    private void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
package BinarySearchQuestions;

public class CeilingAndFloor {
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18};
        int target = 10;

        int Cans = ceilingOfNumber(arr , target);
        int Fans = floorOfNumber(arr , target);
        System.out.println(Cans);
        System.out.println(Fans);
    }

    // equal to target or smallest number greater than target(if target is like in array return that if not then written the element whose value is just greater than target's value)
    static int ceilingOfNumber(int[] arr , int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
           int mid = start + (end - start)/2;

           if(arr[mid] > target) {
               end = mid - 1;
           } else if(arr[mid] < target) {
               start = mid + 1;
           }else {
               return target;
           }
        }
        return arr[start];
    }


// equal to target or largest number smaller than target.(if the target is 10 and 10 is not in the array then we will return largest number smaller than the target(10))
    static int floorOfNumber(int[] arr , int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return target;
            }
        }
        return arr[end];
    }
}

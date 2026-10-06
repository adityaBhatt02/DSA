public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);               // heaters are not sorted

        int answer = 0;

        for (int house : houses) {
            int index = lowerBound(heaters, house);

            int rightDistance = Integer.MAX_VALUE, leftDistance = Integer.MAX_VALUE;

            if (index < heaters.length) rightDistance = heaters[index] - house;
            if (index > 0) leftDistance = house - heaters[index - 1];


            // Closest heater for this house
            int closestDistance = Math.min(leftDistance, rightDistance);

            // Radius must cover every house
            answer = Math.max(answer, closestDistance);
        }

        return answer;
    }

    // First index where heaters[index] >= target
    private int lowerBound(int[] heaters, int target) {
        int start = 0;
        int end = heaters.length;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (heaters[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
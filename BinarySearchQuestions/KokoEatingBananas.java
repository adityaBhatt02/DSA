package BinarySearchQuestions;

public class KokoEatingBananas {
        public int minEatingSpeed(int[] piles, int h) {
            int minSpeed = 1;

            int maxSpeed = 0;
            for(int pile : piles) {
                maxSpeed = Math.max(maxSpeed , pile);          // max banana in a pile is the maxSpeed.
            }

            while(minSpeed < maxSpeed) {
                int mid = minSpeed + (maxSpeed - minSpeed)/2;

                if(canEatInTime(piles , h , mid)) {
                    maxSpeed = mid;           // if she can eat in time then maxSpeed till mid(potential answer)
                }else {
                    minSpeed = mid + 1;       // if she can not eat in time then she have to increase the speed(so mid+1)
                }
            }
            return minSpeed;
        }

        public boolean canEatInTime(int[] piles , int h , int speed) {
            int hours = 0;

            for (int pile : piles) {
                hours += (int) Math.ceil((double) pile / speed);       // pile/speed se hour niklega for eg: 3/6 is 0.5 then there ceil is 1hr.
            }
            return hours <= h;
        }
}

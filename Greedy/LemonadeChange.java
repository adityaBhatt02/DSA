package Greedy;

/*
At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time
(in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.
You must provide the correct change to each customer so that the net transaction is that the customer pays $5.

eg -  bills = [5,5,5,10,20]
Output: true
Explanation:
From the first 3 customers, we collect three $5 bills in order.
From the fourth customer, we collect a $10 bill and give back a $5.
From the fifth customer, we give a $10 bill and a $5 bill.
Since all customers got correct change, we output true.
 */

public class LemonadeChange {
        public boolean lemonadeChange(int[] bills) {
            int five = 0, ten = 0;
            for (int num : bills) {
                if (num == 5) {
                    five++;
                } else if (num == 10) {
                    if (five == 0) {
                        return false;
                    }
                    five--;
                    ten++;
                } else {
                    if (ten > 0 && five > 0) {   // so we are doing this condition first we are greedy as we need 5 rs notes for later also.
                        five--;
                        ten--;
                    } else if (five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
}

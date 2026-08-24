package Array;

import java.util.TreeSet;

/*
dfa12321afd"
Output: 2
Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
 */
public class SecondLargestDigitInAString {
        public int secondHighest(String s) {
                    TreeSet<Integer> set = new TreeSet<>();
                    s = s.replaceAll("[^0-9]", "");

                    char[] c = s.toCharArray();

                    for (char ch : c) {
                        int num = ch - '0';
                        set.add(num);

                        if (set.size() > 2) set.pollFirst();
                    }

                    if (set.size() < 2) return -1;

                    return set.first();
                }
            }



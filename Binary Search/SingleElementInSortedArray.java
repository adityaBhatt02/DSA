/*
Problem: Every number appears twice except one. Array is sorted.

Example:
[1,1,2,2,3,4,4,5,5]
         ↑
       single

1. The pattern

Before the single: even index → odd index
0,1   2,3   4,5 ...


After the single, pairing shifts: odd index → even index
5,6   7,8 ...


The single element is where this pairing pattern breaks.
---

2. What are we binary-searching?

Not the target value.
We are binary-searching for: The point where the normal pairing pattern breaks.

---

3. Why make `mid` even?
We want to compare a complete pair -> (mid, mid + 1)


So:
if (mid % 2 == 1)
    mid--;

Now `mid` is always even.

---

4. Check the pair

if (nums[mid] == nums[mid + 1])

Pair is correct -> [mid, mid+1] = same

The pairing pattern is still normal.

Therefore the single must be to the right:
start = mid + 2;


Why `+2`?
Because both `mid` and `mid+1` are confirmed pairs and cannot be the answer.

---

Pair is broken

nums[mid] != nums[mid + 1]

The normal pairing pattern has already broken.
Therefore the single is: at mid OR somewhere to the left

So:  end = mid;
Not `mid - 1`, because `mid` itself could be the single.

---

### 5. Why `while (start < end)`?

Our goal is to shrink the range until **one index remains**.

start < end  → multiple candidates
start == end → answer found

So:
while (start < end)

When the loop ends:
return nums[start];

---


---
Sorted + pairs + one single
            ↓
Before single: even → odd pairing
After single: pairing shifts (odd -> even)
            ↓
Find where pairing breaks
            ↓
      Make mid even
            ↓
nums[mid] == nums[mid+1]?
       /              \
     YES               NO
      ↓                 ↓
pair is valid       pair is broken
single → RIGHT      single → LEFT or MID
      ↓                 ↓
start = mid + 2     end = mid


**Core sentence:**
> **“I’m not searching for the single directly; I’m searching for where the pair pattern breaks.”**
 */


public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;

        while(start < end) {
            int mid = start + (end - start)/2;
            if(mid % 2 != 0) mid--;

            if(nums[mid] != nums[mid + 1]) {        // This pair is not correct so single must be at mid or to the left
                end = mid;
            } else {                               // This pair is correct single must be to the right
                start = mid + 2;
            }
        }
        return nums[start];
    }
}
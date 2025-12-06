package Greedy;

import java.util.Arrays;

/*
first array is the greed of a particular child and second array is the size of a particular cookie . So we need to assign the cookies
to the child so that the cookie size is equal to or greater than the children greed . We have to count number of children greed is been
satisfied.
for eg ->  g = {1,3,2,1,4}  s = {1,1,4,3,2}          so total no. of children's that got cookies are -> 3
*/
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int l = 0 , r = 0 , count = 0;

        while(r < s.length && l < g.length) {
            if(g[l] <= s[r]) {
                count++;
                l++;
                r++;
            }else{
                r++;
            }
        }
        return count;
    }
}

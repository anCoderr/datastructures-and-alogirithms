package SolutionsInJAVA;

public class Leetcode278 {
    public int firstBadVersion(int n) {
        int mid, start = 1, end = n;
        while(start < end) {
            mid = start + (end - start)/2;
            if(isBadVersion(mid))
                end = mid;
            else
                start = mid+1;
        }
        return start;
    }
    // In the original leetcode question an API with this name was given
    public boolean isBadVersion(int index) {
        return index%2 == 0;
    }
}

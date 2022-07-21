package SolutionsInJAVA;

public class Leetcode704 {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1, mid;
        while(start <= end) {
            mid = (start+end)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }
}

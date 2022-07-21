package SolutionsInJAVA;

public class Leetcode154 {
    public int findMin(int[] nums) {
        int size = nums.length;
        if(size == 1)
            return nums[0];
        return binarySearch(nums, 0, size-1);
    }
    public int binarySearch(int[] nums, int left, int right) {
        int mid = (left + right + 1)/2;
        if(right - left == 2 || right - left == 1)
            return Math.min(Math.min(nums[left], nums[mid]), nums[right]);
        if(nums[mid] < nums[right])
            return binarySearch(nums, left, mid);
        else if (nums[mid] > nums[right])
            return binarySearch(nums, mid, right);
        else
            return binarySearch(nums, left, right-1);
    }
}

package SolutionsInJAVA;

import java.util.Arrays;

public class Leetcode33 {
    public int search(int[] nums, int target) {
        int i = findMinIndex(nums);
        int ans = binarySearch(nums, 0, i, target);
        if(ans < 0)
            ans = binarySearch(nums, i, nums.length-1, target);
        return ans;
    }
    public int findMinIndex(int[] nums) {
        int size = nums.length, left = 0, right = size-1, mid = 0;
        while(left < right) {
            mid = (left+right+1)/2;
            if(nums[mid-1] > nums[mid])
                return mid;
            if(nums[left] > nums[mid])
                right = mid;
            else
                left = mid;
        }
        return mid;
    }
    public int binarySearch(int[] nums, int s, int e, int target) {
        int start = s, end = e, mid;
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

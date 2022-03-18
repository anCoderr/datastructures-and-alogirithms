package Algorithms.UnnamedAlgorithms;

public class SmallestElementInRotatedSortedArray {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1, mid = 0;
        if(nums[start] <= nums[end]) // Meaning the array is not rotated
            return nums[start];
        while(start < end) {
            mid = (start+end+1)/2;
            // Adding 1 helps us in avoiding cases where relative
            //  length is 2 and plays well with even and odd lengths
            if(nums[mid-1] > nums[mid]) // Smallest element found
                return nums[mid];
            if(nums[start] > nums[mid]) // Smallest element in left half of array
                end = mid-1;
            else // Smallest element in right half of array
                start = mid;
        }
        return Integer.MAX_VALUE;
    }
    public static int findMinIndex(int[] nums) {
        int start = 0, end = nums.length - 1, mid = 0;
        if (nums[start] <= nums[end]) // Array is not rotated
            return nums[start];
        while (start < end) {
            mid = (start + end + 1) / 2;
            if (nums[mid - 1] > nums[mid])
                return mid;
            if (nums[start] > nums[mid])
                end = mid - 1;
            else
                start = mid;
        }
        return -1;
    }
}

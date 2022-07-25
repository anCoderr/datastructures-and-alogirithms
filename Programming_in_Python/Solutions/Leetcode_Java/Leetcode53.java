package SolutionsInJAVA;

public class Leetcode53 {
    public int maxSubArray(int[] nums) {
        int maxTillNow = 0, maxSum = Integer.MIN_VALUE;
        for(int i : nums) {
            maxTillNow = Math.max(i, maxTillNow + i);
            maxSum = Math.max(maxSum, maxTillNow);
        }
        return maxSum;
    }
}

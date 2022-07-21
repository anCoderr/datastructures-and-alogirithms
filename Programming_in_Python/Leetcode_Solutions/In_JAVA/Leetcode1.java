package SolutionsInJAVA;

import java.util.HashMap;

public class Leetcode1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int required = target - nums[i];
            if(hashMap.containsKey(required)) {
                return new int[] {hashMap.get(required), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }
}

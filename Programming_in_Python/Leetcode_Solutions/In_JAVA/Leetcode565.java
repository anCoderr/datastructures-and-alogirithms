package SolutionsInJAVA;

public class Leetcode565 {
    public int arrayNesting(int[] nums) {
        int size = nums.length, max = 0, ctr = 0, start;
        boolean[] visited = new boolean[size];
        for(int i = 0; i<size; i++) {
            if(!visited[i]) {
                ctr = 0;
                start = i;
                do {
                    start = nums[start];
                    ctr++;
                    visited[start] = true;
                } while(start != i);
            }
            max = Math.max(max, ctr);
        }
        return max;
    }
}

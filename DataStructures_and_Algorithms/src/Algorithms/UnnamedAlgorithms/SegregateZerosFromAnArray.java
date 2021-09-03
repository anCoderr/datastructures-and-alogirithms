package Algorithms.UnnamedAlgorithms;

public class SegregateZerosFromAnArray {
    // This is a problem when we want to segregete all 0's from an array to its end.

    // This approach uses simple insert at index if current value if non zero.
    // We replace all empty positions with zeros.
    public void moveZeroesWithInserting(int[] nums) {
        int index = 0;
        for(int i : nums)
            if(i != 0) nums[index++] = i;
        while(index < nums.length)
            nums[index++] = 0;
    }

    // This approach uses a zeroBatchSize to batch all consecutive zeros together.
    // We can keep the data that these zeros had(lets say if they weren't zeros).
    public void moveZeroesWithSnowBallApproach(int[] nums) {
        int zeroBatchSize = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0)
                zeroBatchSize++;
            else if (zeroBatchSize > 0) {
                int t = nums[i];
                nums[i]=0;
                nums[i-zeroBatchSize]=t;
            }
        }
    }
}

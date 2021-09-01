package Algorithms;

import java.util.Arrays;

public class KadanesAlgorithm {
    static class Runner {
        public static void main(String[] args) {
            StringBuilder str = new StringBuilder();
            int[] arr = new int[] {-2,-3,0,0,0,4,-1,-2,1,5,0,0,-3};
            int[] ans = longestContiguousSubarray(arr);
            int start = ans[0], end = ans[1], sum = ans[2];
            System.out.print("Answer(max contiguous subarray sum) : " + sum + " \nOriginal array is : ");
            System.out.println(Arrays.toString(arr).replace(' ', '\u0000'));
            System.out.print("Subarray with largest sum is : [");
            for(int i = start; i<=end; i++)
                str.append(arr[i]).append(',');
            str.deleteCharAt(str.length()-1);
            str.append(']');
            System.out.print(str);

        }
    }

    public static int[] longestContiguousSubarray(int[] arr) {
        int start = 0, end = 0, maxEndingHere = 0, maxSoFar = Integer.MIN_VALUE, index = 0, s = 0;
        for(int i : arr) {
            maxEndingHere += i;
            /* Basically we add 2 consecutive values and then check if
                this addition benefited us as in is the sum of this merge
                greater than the element itself.
            */
            // Using '=' here helps us to avoid leading zeros.
            if(maxEndingHere <= i) {
                maxEndingHere = i;
                s = index;
            }
            // Check is the merged values somehow benefiting our maxSum so far
            if(maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                start = s;
                end = index;
            }
            index++;
        }
        return new int[] {start, end, maxSoFar};
    }
}

package Algorithms;

import java.util.Arrays;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        int[] arr = new int[] {-2,-3,0,0,0,4,-1,-2,1,5,0,0,-3};
//        int[] arr = new int[] {3,2,6,8,4,9,3,1,0,0,1,0,2,4,0,0};
//        int[] arr = new int[] {3,2,6,8,4,9,3,1,0,0,1,0,2,4,};
//        int[] arr = new int[] {-2,-2,-5,-9,-3,-9,-8,-1,0,0,2,-2,-5,-6};
        int[] ans = KadanesAlgo(arr);
        int start = ans[0], end = ans[1], sum = ans[2], size = arr.length;
        System.out.print("Answer(max contiguous subarray sum) : " + sum + " \nOriginal array is : ");
        System.out.println(Arrays.toString(arr).replace(' ', '\u0000'));
        System.out.print("Subarray with largest sum is : [");
        for(int i = start; i<=end; i++)
            str.append(arr[i]).append(',');
        str.deleteCharAt(str.length()-1);
        str.append(']');
        System.out.print(str);

    }
    public static int[] KadanesAlgo(int[] arr) {
        int start = 0, end = 0, sum = 0, maxEndingHere = 0, maxSoFar = Integer.MIN_VALUE, index = 0, s = 0;
        for(int i : arr) {
            maxEndingHere += i;
            if(maxEndingHere <= i) {
                maxEndingHere = i;
                s = index;
            }
            if(maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                start = s;
                end = index;
            }
            index++;
        }
        sum = maxSoFar;
        for(int i = start; i<=end; i++)
            sum += arr[i];
//        System.out.println("Maximum contiguous sum is " + maxSoFar);
//        System.out.println("Starting index " + start);
//        System.out.println("Ending index " + end);
        return new int[] {start, end, sum};
    }
}

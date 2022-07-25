package SolutionsInJAVA;

public class Leetcode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i=m-1, j=n-1, k=nums1.length-1; j >= 0 && k >= 0; ){
            if(i>=0 && nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
    }
}

package SolutionsInJAVA;

public class Leetcode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sizeX = nums1.length, sizeY = nums2.length,start = 0, end = sizeX, partX, partY, Xleft = 0, Xright = 0, Yleft = 0, Yright = 0;
        if(sizeX > sizeY)
            return findMedianSortedArrays(nums2, nums1);
        while(start <= end) {
            partX = (start+end)/2;
            partY = (sizeX+sizeY+1)/2-partX;
            Xleft = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            Xright = partX == sizeX ? Integer.MAX_VALUE : nums1[partX];
            Yleft = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
            Yright = partY == sizeY ? Integer.MAX_VALUE : nums2[partY];
            if(Xleft <= Yright && Yleft <= Xright) {
                break;
            } else if(Xleft > Yright) {
                end = partX-1;
            } else {
                start = partX+1;
            }
        }
        return (sizeX+sizeY)%2 == 0 ? ((double)(Math.max(Xleft, Yleft)+Math.min(Xright, Yright)))/2 : (double)Math.max(Xleft, Yleft);
    }
}
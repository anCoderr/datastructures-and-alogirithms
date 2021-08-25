package Algorithms.SortingAndSearching;

public class ArraySearch {
    public static class Runner {
        public static void main(String[] args) {
            int[] arr = new int[]{0,1,4,8,9,11,15,18,19,20,22,25,26,29,30,31,39,43,47,51};
            System.out.println(linearSearch(arr, 15));
            System.out.println(linearSearch(arr, 17));
            System.out.println(binarySearch(arr, 15));
            System.out.println(binarySearch(arr, 17));
            System.out.println(exponentialSearch(arr, 15));
            System.out.println(exponentialSearch(arr, 17));
            System.out.println(jumpSearch(arr, 15));
            System.out.println(jumpSearch(arr, 17));
            arr = new int[]{0,1,2,3,4,5,6,7,8,9};
            System.out.println(interpolationSearch(arr, 7));
            System.out.println(interpolationSearch(arr, 10));
        }
    }
    public static boolean linearSearch(int[] arr, int target) {
        for(int i : arr)
            if(i == target)
                return true;
        return false;
    }
    public static boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length-1, mid;
        while(left <= right) {
            mid = (left+right)/2;
            if(arr[mid] == target)
                return true;
            else if(target > arr[mid])
                left = mid+1;
            else
                right = mid-1;
        }
        return false;
    }
    public static boolean binarySearch(int[] arr, int target, int start, int end) {
        int left = start, right = end, mid;
        while(left < right) {
            mid = (left+right)/2;
            if(arr[mid] == target)
                return true;
            else if(target > arr[mid])
                left = mid+1;
            else
                right = mid-1;
        }
        return false;
    }
    public static boolean jumpSearch(int[] arr, int target) {
        int size = arr.length, jump = Math.max(size/100, 1), start = 0, end = jump;
        while(end < size)
        {
            end = Math.min((start + jump), size-1);
            if(target <= arr[end]) {
                for (int i = start; i <= end; i++)
                    if (arr[i] == target)
                        return true;
                return false;
            }
            start = end+1;
        }
        return false;
    }
    public static boolean interpolationSearch(int[] arr, int target) {
        int size = arr.length, index, low = 0, high = size-1;
        while(low <= high && target >= arr[low] && target <= arr[high]) {
            if(low == high)
                return arr[low] == target;
            index = low + (int)((double)((high-low)/(arr[high]-arr[low])))/(target - arr[low]);
            if(arr[index] == target)
                return true;
            else if(arr[index] < target)
                low = index + 1;
            else
                high = index - 1;
        }
        return false;
    }
    public static boolean exponentialSearch(int[] arr, int target) {
        int index = 1, size = arr.length;
        if(arr[0] == target)
            return true;
        while(index < size && arr[index] <= target)
            index *= 2;
        return binarySearch(arr, target, index/2, Math.min(index, size-1));
    }
}

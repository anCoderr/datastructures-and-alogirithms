package Algorithms.SortingAndSearching;

public class ArraySearch {
    public static boolean linearSearch(int[] arr, int target) {
        for(int i : arr)
            if(i == target)
                return true;
        return false;
    }
    public static boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length-1, mid;
        while(left < right) {
            mid = (left+right)/2;
            if(arr[mid] == target)
                return true;
            else if(arr[mid] > target)
                left = mid;
            else
                right = mid;
        }
        return false;
    }
    public static boolean binarySearch(int[] arr, int target, int start, int end) {
        int left = start, right = end, mid;
        while(left < right) {
            mid = (left+right)/2;
            if(arr[mid] == target)
                return true;
            else if(arr[mid] > target)
                left = mid-1;
            else
                right = mid+1;
        }
        return false;
    }
    public static boolean jumpSearch(int[] arr, int target) {
        int size = arr.length, jump = size/100, start = 0, end = jump;
        while(end < size)
        {
            end = Math.min((start + jump), size-1);
            if(target <= arr[end])
                for(int i = start; i<=end; i++)
                    if(arr[i] == target)
                        return true;
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

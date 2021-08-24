package Algorithms.SortingAndSearching;

import DataStructures.Heaps.Heap;
import DataStructures.Heaps.MinHeap;

import java.util.Arrays;

public class ArraySort {
    static class Runner {
        public static void main(String[] args) {
            int[] arr = new int[] {7,6,1,2,3,8,9,0,4,5};
//            selectionSort(arr);
//            bubbleSort(arr);
//            insertionSort(arr);
//            heapSort(arr);
            quickSort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
    public static void swapElements(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public static void selectionSort(int[] arr) {
        int size = arr.length, temp, loc = 0;
        for(int i = 0; i<size; i++) {
            temp = Integer.MAX_VALUE;
            for(int j = i; j<size; j++)
                if(temp > arr[j]) {
                    temp = arr[j];
                    loc = j;
                }
            swapElements(arr, i, loc);
        }
    }

    public static void bubbleSort(int[] arr) {
        bubbleSort(arr, arr.length);
    }
    public static void bubbleSort(int[] arr, int size) {
        for(int i = 0; i<size-1; i++)
            if(arr[i] > arr[i+1]) {
                swapElements(arr, i, i + 1);
                bubbleSort(arr, size-1);
            }
    }

    public static void insertionSort(int[] arr) {
        int sortedTill = 0, index = 0, size = arr.length;
        while(sortedTill < size-1) {
            index = sortedTill+1;
            while(index > 0 && arr[index-1] > arr[index]) {
                swapElements(arr, index, index-1);
                index--;
            }
            sortedTill++;
        }
    }

    public static void heapSort(int[] arr) {
        Heap minHeap = new MinHeap();
        for(int i : arr)
            minHeap.add(i);
        for(int i = 0; i<arr.length; i++)
            arr[i] = minHeap.poll();
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }
    public static void quickSort(int[] arr, int left, int right) {
        if(left >= right)
            return;
        int l = left, r = right;
        int pivot = l++;
        while(l <= r) {
            if(arr[l] <= arr[pivot])
                l++;
            else if(arr[r] >= arr[pivot])
                r--;
            else
                swapElements(arr, l++, r--);
        }
        swapElements(arr, pivot, r);
        pivot = r;
        quickSort(arr, left, pivot-1);
        quickSort(arr, pivot+1, right);
    }
}

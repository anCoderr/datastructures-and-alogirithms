from typing import List


def insertion_sort(arr: List[int]):
    n = len(arr)
    for i in range(1,n):
        index = i-1
        while index >= 0 and arr[index+1] < arr[index]:
            arr[index+1], arr[index] = arr[index], arr[index+1]
            index -= 1
    return arr
from typing import List


def selection_sort(arr: List[int]):
    n = len(arr)
    for i in range(n):
        index = 0
        for j in range(n):
            if arr[j] > arr[index]:
                index = j
        arr[n - 1], arr[index] = arr[index], arr[n - 1]
        n -= 1
    return arr
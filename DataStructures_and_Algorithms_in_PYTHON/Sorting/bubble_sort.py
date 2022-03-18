from typing import List


def bubble_sort(arr: List[int]):
    n = len(arr)

    def swap(i):
        arr[i], arr[i + 1] = arr[i + 1], arr[i]

    while n > 0:
        for i in range(n - 1):
            if arr[i] > arr[i + 1]:
                swap(i)
        n -= 1
    return arr
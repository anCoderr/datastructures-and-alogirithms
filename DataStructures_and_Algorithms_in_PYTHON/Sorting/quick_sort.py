from typing import List


def quick_sort(arr: List[int]):
    n = len(arr)

    def partition_around_pivot(lo, hi):
        if lo >= hi:
            return
        l, r, index, pivot = lo, hi, hi, arr[hi]
        while l < r:
            while l < n and arr[l] < pivot:
                l += 1
            while r >= 0 and arr[r] >= pivot:
                r -= 1
            if l < r:
                arr[l], arr[r] = arr[r], arr[l]
        arr[l], arr[index] = arr[index], arr[l]
        partition_around_pivot(lo, l - 1)
        partition_around_pivot(l + 1, hi)

    partition_around_pivot(0, len(arr) - 1)
    return arr
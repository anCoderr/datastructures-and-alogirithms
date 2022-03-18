from typing import List


def merge_sort(arr: List[int]):
    n = len(arr)

    def break_and_conquer(l, r):
        if l == r:
            return
        mid = (l + r) // 2
        break_and_conquer(l, mid)
        break_and_conquer(mid + 1, r)
        res, i, j = [], l, mid + 1
        while i <= mid and j <= r:
            if arr[i] <= arr[j]:
                res.append(arr[i])
                i += 1
            else:
                res.append(arr[j])
                j += 1
        while i <= mid:
            res.append(arr[i])
            i += 1
        while j <= r:
            res.append(arr[j])
            j += 1
        for i in range(l, r + 1):
            arr[i] = res[i - l]

    break_and_conquer(0, n - 1)
    return arr
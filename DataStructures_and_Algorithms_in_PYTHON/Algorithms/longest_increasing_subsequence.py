import bisect
from typing import List


# LIS using simple DP with O(N^2)
def longest_increasing_subsequence_slower(arr: List[int]):
    n = len(arr)
    dp = [1] * n
    for i in range(1, n):
        for j in range(i):
            if arr[i] > arr[j]:
                dp[i] = max(dp[i], dp[j] + 1)
    return max(dp)


# LIS using DP and BS with O(NlogN)
def longest_increasing_subsequence_faster(arr: List[int]):
    dp = []
    for val in arr:
        i = bisect.bisect_left(dp, val)
        if i == len(dp):
            dp.append(val)
        else:
            dp[i] = val
    return len(dp)

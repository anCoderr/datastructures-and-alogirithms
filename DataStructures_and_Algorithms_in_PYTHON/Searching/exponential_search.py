from typing import List
from binary_search import binary_search


def exponential_search(arr: List[int], target: int) -> int:
    n, i = len(arr), 1
    while i < n and arr[i] <= target:
        i = i * 2
    a = binary_search(arr[i // 2: min(i, n - 1) + 1], target)
    return i//2 + a if a != -1 else -1

from typing import List


def linear_search(arr: List[int], target: int) -> int:
    for idx, val in enumerate(arr):
        if val == target:
            return idx
    return -1

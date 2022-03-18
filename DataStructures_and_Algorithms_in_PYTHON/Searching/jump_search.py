from typing import List


def jump_search(arr: List[int], target: int) -> int:
    n, jump = len(arr), int(len(arr) ** 0.5)
    for i in range(0, n, jump):
        if arr[i] <= target <= arr[min(i + jump, n)-1]:
            for j in range(i, min(i + jump, n)):
                if arr[j] == target:
                    return j
            break
    return -1

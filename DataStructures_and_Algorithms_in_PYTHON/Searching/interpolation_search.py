from typing import List


def interpolation_search(arr: List[int], target: int) -> int:
    lo, hi = 0, len(arr)-1
    while lo <= hi and arr[lo] <= target <= arr[hi]:
        pos = lo + ((target-arr[lo])*(hi-lo))//(arr[hi]-arr[lo])
        if arr[pos] == target:
            return pos
        elif target < arr[pos]:
            hi = pos-1
        else:
            lo = pos+1
    return -1

print(interpolation_search([1,2,3,4,5,6,7,8,9,10], 1))
print(interpolation_search([1,2,3,4,5,6,7,8,9,10], 2))
print(interpolation_search([1,2,3,4,5,6,7,8,9,10], 3))
print(interpolation_search([1,2,3,4,5,6,7,8,9,10], 4))
print(interpolation_search([1,2,3,4,5,6,7,8,9,10], 5))
print(interpolation_search([1,2,3,4,5,6,7,8,9,10], 6))
print(interpolation_search([1,2,3,4,5,6,7,8,9,10], 7))
print(interpolation_search([1,2,3,4,5,6,7,8,9,10], 8))
print(interpolation_search([1,2,3,4,5,6,7,8,9,10], 9))
print(interpolation_search([1,2,3,4,5,6,7,8,9,10], 10))

print(interpolation_search([1,2,3,7,8,9,10], -1))
print(interpolation_search([1,2,3,7,8,9,10], -100))
print(interpolation_search([1,2,3,7,8,9,10], -1000))
print(interpolation_search([1,2,3,7,8,9,10], 4))
print(interpolation_search([1,2,3,7,8,9,10], 5))
print(interpolation_search([1,2,3,7,8,9,10], 6))
print(interpolation_search([1,2,3,7,8,9,10], 11))
print(interpolation_search([1,2,3,7,8,9,10], 100))
print(interpolation_search([1,2,3,7,8,9,10], 1000))

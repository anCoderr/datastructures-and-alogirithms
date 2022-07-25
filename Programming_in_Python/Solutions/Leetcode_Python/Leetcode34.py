from bisect import *
from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l = bisect_left(nums, target)
        r = bisect_right(nums, target)-1
        if l >= len(nums) or nums[l] != target:
            return [-1,-1]
        return [l, r]

obj = Solution()
print(obj.searchRange(nums = [5,7,7,8,8,10], target = 8))
print(obj.searchRange(nums = [5,7,7,8,8,10], target = 6))
print(obj.searchRange(nums = [], target = 0))
from typing import List


class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        count = ans = 0
        for i in nums:
            if i == 0: count += 1
            else:
                ans += (count * (count+1))//2
                count = 0
        if count != 0: ans += (count * (count + 1)) // 2
        return ans

obj = Solution()
print(obj.zeroFilledSubarray([1,3,0,0,2,0,0,4]))
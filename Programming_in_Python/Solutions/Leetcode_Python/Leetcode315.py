from typing import List, Optional

class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        n = len(nums)
        nums = [[nums[i], i] for i in range(n)]
        ans = [0]*n
        def merge_utility(l, r):
            if l == r: return
            mid, temp = (l+r)//2, []
            merge_utility(l, mid)
            merge_utility(mid+1, r)
            lo, hi, dx = l, mid+1, 0
            while lo <= mid and hi <= r:
                if nums[lo][0] <= nums[hi][0]:
                    ans[nums[lo][1]] += dx
                    temp.append(nums[lo])
                    lo += 1
                else:
                    dx += 1
                    temp.append(nums[hi])
                    hi += 1
            while lo <= mid:
                ans[nums[lo][1]] += dx
                temp.append(nums[lo])
                lo += 1
            while hi <= r:
                temp.append(nums[hi])
                hi += 1
            for i in range(l, r+1): nums[i] = temp[i-l]
            
        merge_utility(0, n-1)
        return ans

obj = Solution()
print(obj.countSmaller([3,4,2,1,1,2,5,3]))
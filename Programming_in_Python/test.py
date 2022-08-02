from collections import defaultdict
from typing import List


class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        dp = defaultdict(lambda: {})
        a, b = 0, 0
        def recursion(arr):
            nonlocal a, b
            if len(arr) == 2: 
                profit = arr[0] * arr[1] + max(arr[0], arr[1])
            n = len(arr)
            key = '-'.join(map(str, arr))
            if key not in dp[n]:
                a += 1
                max_profit = 0
                for i in range(len(arr)):
                    profit = (arr[i-1] if i-1 >= 0 else 1) * arr[i] * (arr[i+1] if i+1 < n else 1) 
                    profit += recursion(arr[:i] + arr[i+1:])
                    max_profit = max(max_profit, profit)
                dp[n][key] = max_profit                
            else: b += 1
            return dp[n][key]
        ans = recursion(nums)
        print(a, b)
        return ans

obj = Solution()
print(obj.maxCoins([21,2,0,17,1,3,9,12]))
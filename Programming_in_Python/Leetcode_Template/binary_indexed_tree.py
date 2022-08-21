from typing import List

class BinaryIndexedTree:

    @staticmethod
    def get_next_index(index) -> int:
        return index + (index & -index)

    @staticmethod
    def get_parent_index(index) -> int:
        return index - (index & -index)

    def __init__(self, nums):
        self.n = len(nums)
        self.bit = [0] * (self.n+1)
        for i in range(1, self.n + 1):
            self.point_update_query(i, nums[i - 1])

    def point_update_query(self, index, diff):
        while index < len(self.bit):
            self.bit[index] += diff
            index = self.get_next_index(index)

    def range_sum_query_util(self, index):
        index += 1
        ans = 0
        while index > 0:
            ans += self.bit[index]
            index = self.get_parent_index(index)
        return ans

    def range_sum_query(self, left: int, right: int):
        left = self.range_sum_query_util(left-1) if left > 0 else 0
        right = self.range_sum_query_util(right)
        return right - left

    
bit = BinaryIndexedTree([1,2,3,4,5,6,7,8,9,10])
print(bit.range_sum_query_util(9))
print(bit.range_sum_query_util(8))
print(bit.range_sum_query_util(7))
print(bit.range_sum_query_util(6))
print(bit.range_sum_query_util(5))
print(bit.range_sum_query_util(4))
print(bit.range_sum_query_util(3))
print(bit.range_sum_query_util(2))
print(bit.range_sum_query_util(1))
print(bit.range_sum_query_util(0))

print(bit.range_sum_query(3, 9))
print(bit.range_sum_query(5, 6))
print(bit.range_sum_query(0, 6))
print(bit.range_sum_query(3, 3))

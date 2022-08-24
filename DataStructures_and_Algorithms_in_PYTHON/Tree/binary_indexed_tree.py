##########################################################################################
##########################################################################################
##### RESOURCES:
# https://kartikkukreja.wordpress.com/2013/12/02/range-updates-with-bit-fenwick-tree/
# https://cp-algorithms.com/data_structures/fenwick.html#range-operations
# https://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
# https://www.geeksforgeeks.org/binary-indexed-tree-range-update-range-queries/
# https://robert1003.github.io/2020/01/27/fenwick-tree.html
# https://www.youtube.com/watch?v=DPiY9wFxGIw&t=15s


def get_next_index(index) -> int:
    return index + (index & -index)

def get_parent_index(index) -> int:
    return index - (index & -index)


##########################################################################################
##########################################################################################
##### Unified BIT Class: Supports Range/Point Updates + Range/Point Queries
class BIT:
    def __init__(self, nums):
        self.N = len(nums)
        self.bit1 = [0] * (self.N + 1)
        self.bit2 = [0] * (self.N + 1)
        for i in range(self.N):
            self.range_update_query(i, i, nums[i])

    def update_query_util(self, usebit1, index, diff):
        bit = self.bit1 if usebit1 else self.bit2
        index += 1
        while index <= self.N:
            bit[index] += diff
            index += (index & -index)

    def point_update_query(self, index, diff):
        self.range_update_query(index, index, diff)

    def range_update_query(self, left, right, diff):
        self.update_query_util(True, left, diff)
        self.update_query_util(True, right+1, -diff)
        self.update_query_util(False, left, diff * (left-1))
        self.update_query_util(False, right+1, -diff * right)

    def sum_query_util(self, usebit1, index):
        bit = self.bit1 if usebit1 else self.bit2
        index += 1
        sum = 0
        while index > 0:
            sum += bit[index]
            index -= (index & -index)
        return sum

    def point_sum_query(self, index):
        return self.range_sum_query_l_to_r(index, index)

    def range_sum_query_0_to_i(self, index):
        return self.sum_query_util(True, index) * index - self.sum_query_util(False, index)

    def range_sum_query_l_to_r(self, left, right):
        left = self.range_sum_query_0_to_i(left-1) if left > 0 else 0
        right = self.range_sum_query_0_to_i(right)
        return right - left


##########################################################################################
##########################################################################################
##### BIT Class: Supports Point Updates + Range Queries
class BIT_PointUpdates_RangeQueries:
    def __init__(self, nums):
        self.N = len(nums)
        self.bit = [0] * (self.N + 1)
        for i in range(self.N):
            self.point_update_query(i, nums[i])

    def point_update_query(self, index, diff):
        index += 1
        while index <= self.N:
            self.bit[index] += diff
            index += (index & -index)

    def range_sum_query_0_to_i(self, index):
        index += 1
        sum = 0
        while index > 0:
            sum += self.bit[index]
            index -= (index & -index)
        return sum

    def range_sum_query_l_to_r(self, left: int, right: int):
        left = self.range_sum_query_0_to_i(left-1) if left > 0 else 0
        right = self.range_sum_query_0_to_i(right)
        return right - left


##########################################################################################
##########################################################################################
##### BIT Class: Supports Range Updates + Point Queries
class BIT_RangeUpdates_PointQueries:
    def __init__(self, nums):
        self.N = len(nums)
        self.bit = [0] * (self.N + 1)
        for i in range(self.N):
            self.point_update_query(i, nums[i] - (nums[i-1] if i > 0 else 0))

    def point_update_query(self, index, diff):
        index += 1
        while index <= self.N:
            self.bit[index] += diff
            index += (index & -index)

    def range_update_query(self, left, right, diff):
        self.point_update_query(left, diff)
        self.point_update_query(right+1, -diff)

    def point_sum_query(self, index):
        index += 1
        sum = 0
        while index > 0:
            sum += self.bit[index]
            index -= (index & -index)
        return sum


##########################################################################################
##########################################################################################
##### BIT Class: Supports Range Updates + Range Queries
class BIT_RangeUpdates_RangeQueries:
    def __init__(self, nums):
        self.N = len(nums)
        self.bit1 = [0] * (self.N + 1)
        self.bit2 = [0] * (self.N + 1)
        for i in range(self.N):
            self.range_update_query(i, i, nums[i])

    def update_query_util(self, usebit1, index, diff):
        bit = self.bit1 if usebit1 else self.bit2
        index += 1
        while index <= self.N:
            bit[index] += diff
            index += (index & -index)

    def range_update_query(self, left, right, diff):
        self.update_query_util(True, left, diff)
        self.update_query_util(True, right+1, -diff)
        self.update_query_util(False, left, diff * (left-1))
        self.update_query_util(False, right+1, -diff * right)

    def sum_query_util(self, usebit1, index):
        bit = self.bit1 if usebit1 else self.bit2
        index += 1
        sum = 0
        while index > 0:
            sum += bit[index]
            index -= (index & -index)
        return sum

    def range_sum_query_0_to_i(self, index):
        return self.sum_query_util(True, index) * index - self.sum_query_util(False, index)

    def range_sum_query_l_to_r(self, left, right):
        left = self.range_sum_query_0_to_i(left-1) if left > 0 else 0
        right = self.range_sum_query_0_to_i(right)
        return right - left


##########################################################################################
##########################################################################################
##### BIT Implementation Testing.


print('POINT UPDATES AND RANGE QUERIES:')    
bit = BIT_PointUpdates_RangeQueries([5,3,6,0,1,2,3,4,7,9])
print(bit.range_sum_query_0_to_i(9))
print(bit.range_sum_query_0_to_i(1))
print(bit.range_sum_query_l_to_r(3, 9))
print(bit.range_sum_query_l_to_r(0, 6))
print(bit.range_sum_query_l_to_r(2, 2))
bit.point_update_query(2, 4)
bit.point_update_query(5, 3)
bit.point_update_query(8, -5)
print(bit.range_sum_query_0_to_i(8))
print(bit.range_sum_query_0_to_i(2))
print(bit.range_sum_query_l_to_r(5, 6))
print(bit.range_sum_query_l_to_r(0, 6))
print(bit.range_sum_query_l_to_r(2, 2))
print(bit.range_sum_query_l_to_r(5, 5))
print(bit.range_sum_query_l_to_r(8, 8))


print('RANGE UPDATES AND POINT QUERIES:')
bit = BIT_RangeUpdates_PointQueries([5,3,6,0,1,2,3,4,7,9])
print(bit.point_sum_query(9))
print(bit.point_sum_query(6))
print(bit.point_sum_query(3))
bit.range_update_query(2, 5, 9)
print(bit.point_sum_query(8))
print(bit.point_sum_query(5))
print(bit.point_sum_query(2))


print('RANGE UPDATES AND RANGE QUERIES:')
bit = BIT_RangeUpdates_RangeQueries([5,3,6,0,1,2,3,4,7,9])
print(bit.range_sum_query_0_to_i(8))
print(bit.range_sum_query_0_to_i(6))
print(bit.range_sum_query_l_to_r(2,8))
print(bit.range_sum_query_l_to_r(5,6))
print(bit.range_sum_query_l_to_r(5,5))
bit.range_update_query(2, 5, 9)
print(bit.range_sum_query_0_to_i(8))
print(bit.range_sum_query_0_to_i(6))
print(bit.range_sum_query_l_to_r(2,8))
print(bit.range_sum_query_l_to_r(5,6))
print(bit.range_sum_query_l_to_r(5,5))


print('RANGE/POINT UPDATES AND RANGE/POINT QUERIES:')
bit = BIT([1,2,3,4,5,6,7,8,9,10])
print(bit.range_sum_query_l_to_r(2,7))
print(bit.range_sum_query_0_to_i(9))
print(bit.point_sum_query(3))
bit.point_update_query(3, 5)
bit.point_update_query(9,3)
print(bit.range_sum_query_l_to_r(2,7))
print(bit.range_sum_query_0_to_i(9))
print(bit.point_sum_query(3))
bit.range_update_query(0, 3, 7)
bit.range_update_query(7, 7, 11)
print(bit.range_sum_query_l_to_r(2,7))
print(bit.range_sum_query_0_to_i(9))
print(bit.point_sum_query(3))
bit.point_update_query(0, 100)
print(bit.point_sum_query(0))
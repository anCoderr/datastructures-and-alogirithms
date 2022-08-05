import math
from typing import List


class SegmentTreeRangeSum:

    @staticmethod
    def get_mid_index(left, right):
        return left + (right - left) // 2

    @staticmethod
    def get_left_child_index(index):
        return index * 2 + 1

    @staticmethod
    def get_right_child_index(index):
        return index * 2 + 2

    def __init__(self, data):
        self.n = len(data)
        self.segment_tree = self.build_tree(data)

    def build_tree(self, data):
        self.segment_tree = [0] * (2 ** int(math.ceil(math.log2(self.n)) + 1) - 1)
        self.build_tree_utility(0, 0, self.n - 1, data)
        return self.segment_tree

    def build_tree_utility(self, index, left, right, data):
        if left == right:
            self.segment_tree[index] = data[left]
        else:
            mid = self.get_mid_index(left, right)
            left_child_index = self.get_left_child_index(index)
            right_child_index = self.get_right_child_index(index)
            self.build_tree_utility(left_child_index, left, mid, data)
            self.build_tree_utility(right_child_index, mid + 1, right, data)
            self.segment_tree[index] = self.segment_tree[left_child_index] + self.segment_tree[right_child_index]

    def point_update_query(self, a, val):
        self.point_update_query_utility(0, 0, self.n - 1, a, val)

    def point_update_query_utility(self, index, left, right, a, diff):
        if right < a or left > a:
            return
        self.segment_tree[index] += diff
        if left != right:
            mid = self.get_mid_index(left, right)
            left_child_index = self.get_left_child_index(index)
            right_child_index = self.get_right_child_index(index)
            self.point_update_query_utility(left_child_index, left, mid, a, diff)
            self.point_update_query_utility(right_child_index, mid + 1, right, a, diff)

    def range_sum_query(self, a, b):
        return self.range_sum_query_utility(0, a, b, 0, self.n - 1)

    def range_sum_query_utility(self, index, a, b, left, right):
        if right < a or left > b:
            return 0
        if right <= b and left >= a:
            return self.segment_tree[index]
        mid = self.get_mid_index(left, right)
        left_child_index = self.get_left_child_index(index)
        right_child_index = self.get_right_child_index(index)
        sum_left = self.range_sum_query_utility(left_child_index, a, b, left, mid)
        sum_right = self.range_sum_query_utility(right_child_index, a, b, mid + 1, right)
        return sum_left + sum_right

class SegmentTreeRangeMin:

    @staticmethod
    def get_mid_index(left, right):
        return left + (right - left) // 2

    @staticmethod
    def get_left_child_index(index):
        return index * 2 + 1

    @staticmethod
    def get_right_child_index(index):
        return index * 2 + 2

    def __init__(self, data):
        self.n = len(data)
        self.segment_tree = self.build_tree(data)

    def build_tree(self, data):
        self.segment_tree = [0] * (2 ** int(math.ceil(math.log2(self.n)) + 1) - 1)
        self.build_tree_utility(0, 0, self.n - 1, data)
        return self.segment_tree

    def build_tree_utility(self, index, left, right, data):
        if left == right:
            self.segment_tree[index] = data[left]
        else:
            mid = self.get_mid_index(left, right)
            left_child_index = self.get_left_child_index(index)
            right_child_index = self.get_right_child_index(index)
            self.build_tree_utility(left_child_index, left, mid, data)
            self.build_tree_utility(right_child_index, mid + 1, right, data)
            self.segment_tree[index] = min(self.segment_tree[left_child_index], self.segment_tree[right_child_index])

    def point_update_query(self, index, val):
        self.point_update_query_utility(0, 0, self.n - 1, index, val)

    def point_update_query_utility(self, index, left, right, i, val):
        if left > i or right < i:
            return self.segment_tree[index]
        if left == right:
            if left == i:
                self.segment_tree[index] = val
            return self.segment_tree[index]
        mid = self.get_mid_index(left, right)
        left_child_index = self.get_left_child_index(index)
        right_child_index = self.get_right_child_index(index)
        left_min_value = self.point_update_query_utility(left_child_index, left, mid, i, val)
        right_min_value = self.point_update_query_utility(right_child_index, mid + 1, right, i, val)
        self.segment_tree[index] = min(left_min_value, right_min_value)
        return self.segment_tree[index]
        


    def range_min_query(self, a, b):
        return self.range_min_query_utility(0, a, b, 0, self.n - 1)

    def range_min_query_utility(self, index, a, b, left, right):
        if right < a or left > b:
            return float('inf')
        if right <= b and left >= a:
            return self.segment_tree[index]
        mid = self.get_mid_index(left, right)
        left_child_index = self.get_left_child_index(index)
        right_child_index = self.get_right_child_index(index)
        min_left = self.range_min_query_utility(left_child_index, a, b, left, mid)
        min_right = self.range_min_query_utility(right_child_index, a, b, mid + 1, right)
        return min(min_left, min_right)

class SegmentTreeRangeMax:

    @staticmethod
    def get_mid_index(left, right):
        return left + (right - left) // 2

    @staticmethod
    def get_left_child_index(index):
        return index * 2 + 1

    @staticmethod
    def get_right_child_index(index):
        return index * 2 + 2

    def __init__(self, data):
        self.n = len(data)
        self.segment_tree = self.build_tree(data)

    def build_tree(self, data):
        self.segment_tree = [0] * (2 ** int(math.ceil(math.log2(self.n)) + 1) - 1)
        self.build_tree_utility(0, 0, self.n - 1, data)
        return self.segment_tree

    def build_tree_utility(self, index, left, right, data):
        if left == right:
            self.segment_tree[index] = data[left]
        else:
            mid = self.get_mid_index(left, right)
            left_child_index = self.get_left_child_index(index)
            right_child_index = self.get_right_child_index(index)
            self.build_tree_utility(left_child_index, left, mid, data)
            self.build_tree_utility(right_child_index, mid + 1, right, data)
            self.segment_tree[index] = max(self.segment_tree[left_child_index], self.segment_tree[right_child_index])

    def point_update_query(self, index, val):
        self.point_update_query_utility(0, 0, self.n - 1, index, val)

    def point_update_query_utility(self, index, left, right, i, val):
        if left > i or right < i:
            return self.segment_tree[index]
        if left == right:
            if left == i:
                self.segment_tree[index] = val
            return self.segment_tree[index]
        mid = self.get_mid_index(left, right)
        left_child_index = self.get_left_child_index(index)
        right_child_index = self.get_right_child_index(index)
        left_max_value = self.point_update_query_utility(left_child_index, left, mid, i, val)
        right_max_value = self.point_update_query_utility(right_child_index, mid + 1, right, i, val)
        self.segment_tree[index] = max(left_max_value, right_max_value)
        return self.segment_tree[index]
        


    def range_max_query(self, a, b):
        return self.range_max_query_utility(0, a, b, 0, self.n - 1)

    def range_max_query_utility(self, index, a, b, left, right):
        if right < a or left > b:
            return float('-inf')
        if right <= b and left >= a:
            return self.segment_tree[index]
        mid = self.get_mid_index(left, right)
        left_child_index = self.get_left_child_index(index)
        right_child_index = self.get_right_child_index(index)
        max_left = self.range_max_query_utility(left_child_index, a, b, left, mid)
        max_right = self.range_max_query_utility(right_child_index, a, b, mid + 1, right)
        return max(max_left, max_right)


st = SegmentTreeRangeSum([2,4,-3,0,5,9,1,3])
print(st.segment_tree)
print(st.range_sum_query(0,7))
print(st.range_sum_query(1,3))
print(st.range_sum_query(3,6))
st.point_update_query(4, -9)
print(st.range_sum_query(0,7))
print(st.range_sum_query(3,6))
print(st.range_sum_query(6,7))

st = SegmentTreeRangeMin([2,4,-3,0,5,9,1,3])
print(st.segment_tree)
print(st.range_min_query(0,7))
print(st.range_min_query(1,3))
print(st.range_min_query(3,6))
st.point_update_query(4, -9)
print(st.range_min_query(0,7))
print(st.range_min_query(3,6))
print(st.range_min_query(6,7))

st = SegmentTreeRangeMax([2,4,-3,0,5,9,1,3])
print(st.segment_tree)
print(st.range_max_query(0,7))
print(st.range_max_query(1,3))
print(st.range_max_query(3,6))
st.point_update_query(5, 0)
print(st.range_max_query(0,7))
print(st.range_max_query(3,6))
print(st.range_max_query(6,7))
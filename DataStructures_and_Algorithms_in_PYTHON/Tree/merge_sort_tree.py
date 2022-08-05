import math
from typing import List


class SegmentTree:

    @staticmethod
    def get_mid_index(left: int, right: int) -> int:
        return left + (right - left) // 2

    @staticmethod
    def get_left_child_index(index: int) -> int:
        return index * 2 + 1

    @staticmethod
    def get_right_child_index(index: int) -> int:
        return index * 2 + 2

    def __init__(self, data):
        self.n = len(data)
        self.segment_tree = self.build_tree(data)

    def build_tree(self, data: List[int]) -> List[int]:
        self.segment_tree = [[]] * (2 ** int(math.ceil(math.log2(self.n)) + 1) - 1)
        self.build_tree_utility(0, 0, self.n - 1, data)
        return self.segment_tree

    def build_tree_utility(self, index: int, left: int, right: int, data: List[int]):
        if left == right:
            self.segment_tree[index].append(data[left])
        else:
            mid = self.get_mid_index(left, right)
            left_child_index = self.get_left_child_index(index)
            right_child_index = self.get_right_child_index(index)
            self.build_tree_utility(left_child_index, left, mid, data)
            self.build_tree_utility(right_child_index, mid + 1, right, data)
            LEFT = self.segment_tree[left_child_index]
            RIGHT = self.segment_tree[right_child_index]
            

    def update_tree(self, a: int, val: int):
        self.update_tree_utility(0, 0, self.n - 1, a, val)

    def update_tree_utility(self, index: int, left: int, right: int, a: int, diff: int):
        if right < a or left > a:
            return
        self.segment_tree[index] += diff
        if left != right:
            mid = self.get_mid_index(left, right)
            left_child_index = self.get_left_child_index(index)
            right_child_index = self.get_right_child_index(index)
            self.update_tree_utility(left_child_index, left, mid, a, diff)
            self.update_tree_utility(right_child_index, mid + 1, right, a, diff)

    # def sum_query(self, l: int, r: int) -> int:
    #     return self.sum_query_utility(0, l, r, 0, self.n - 1)

    # def sum_query_utility(self, index: int, l: int, r: int, left: int, right: int) -> int:
    #     if right < l or left > r:
    #         return 0
    #     if right <= r and left >= l:
    #         return self.segment_tree[index]
    #     mid = self.get_mid_index(left, right)
    #     left_child_index = self.get_left_child_index(index)
    #     right_child_index = self.get_right_child_index(index)
    #     sum_left = self.sum_query_utility(left_child_index, l, r, left, mid)
    #     sum_right = self.sum_query_utility(right_child_index, l, r, mid + 1, right)
    #     return sum_left + sum_right


st = SegmentTree([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
print(st.sum_query(2,5))
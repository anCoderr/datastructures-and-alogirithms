import math
from typing import List, Union


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

    def build_tree(self, data: List[int]) -> List[int]:
        n = len(data)
        segment_tree = [0] * (2 ** int(math.ceil(math.log2(n)) + 1) - 1)
        self.build_tree_utility(0, 0, n - 1, segment_tree, data)
        return segment_tree

    def build_tree_utility(self, index: int, left: int, right: int, segment_tree: List[int], data: List[int]):
        if left == right:
            segment_tree[index] = data[left]
        else:
            mid = self.get_mid_index(left, right)
            left_child_index = self.get_left_child_index(index)
            right_child_index = self.get_right_child_index(index)
            self.build_tree_utility(left_child_index, left, mid, segment_tree, data)
            self.build_tree_utility(right_child_index, mid + 1, right, segment_tree, data)
            segment_tree[index] = segment_tree[left_child_index] + segment_tree[right_child_index]

    def update_tree(self, a: int, val: int, n: int, segment_tree: List[int]):
        self.update_tree_utility(0, 0, n - 1, a, val, segment_tree)

    def update_tree_utility(self, index: int, left: int, right: int, a: int, diff: int, segment_tree: List[int]):
        if right < a or left > a:
            return
        segment_tree[index] += diff
        if left != right:
            mid = self.get_mid_index(left, right)
            left_child_index = self.get_left_child_index(index)
            right_child_index = self.get_right_child_index(index)
            self.update_tree_utility(left_child_index, left, mid, a, diff, segment_tree)
            self.update_tree_utility(right_child_index, mid + 1, right, a, diff, segment_tree)

    def sum_query(self, a: int, b: int, n: int, segment_tree: List[int]) -> int:
        return self.sum_query_utility(0, a, b, 0, n - 1, segment_tree)

    def sum_query_utility(self, index: int, a: int, b: int, left: int, right: int, segment_tree: List[int]) -> int:
        if right < a or left > b:
            return 0
        if right <= b and left >= a:
            return segment_tree[index]
        mid = self.get_mid_index(left, right)
        left_child_index = self.get_left_child_index(index)
        right_child_index = self.get_right_child_index(index)
        sum_left = self.sum_query_utility(left_child_index, a, b, left, mid, segment_tree)
        sum_right = self.sum_query_utility(right_child_index, a, b, mid + 1, right, segment_tree)
        return sum_left + sum_right

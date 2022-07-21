from typing import List


class BinaryIndexedTree:

    @staticmethod
    def get_next_index(index: int) -> int:
        return index + (index & -index)

    @staticmethod
    def get_parent_index(index: int) -> int:
        return index - (index & -index)

    def update_tree(self, bit_tree: List[int], index: int, diff: int):
        while index < len(bit_tree):
            bit_tree[index] += diff
            index = self.get_next_index(index)

    def build_tree(self, input_list: List[int]) -> List[int]:
        n = len(input_list)
        bit_tree = [0] * (n + 1)
        for i in range(1, n + 1):
            self.update_tree(bit_tree, i, input_list[i - 1])
        return bit_tree

    def get_sum(self, bit_tree: List[int], index: int) -> int:
        index += 1
        ans = 0
        while index > 0:
            ans += bit_tree[index]
            index = self.get_parent_index(index)
        return ans

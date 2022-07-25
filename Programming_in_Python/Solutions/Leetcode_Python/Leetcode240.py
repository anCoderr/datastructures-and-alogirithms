from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        r, max_c, c = len(matrix)-1, len(matrix[0]), 0
        while r >= 0 and c < max_c:
            if matrix[r][c] > target: r -= 1
            elif matrix[r][c] < target: c += 1
            else: return True
        return False

obj = Solution()
print(obj.searchMatrix(matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5))
print(obj.searchMatrix(matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20))
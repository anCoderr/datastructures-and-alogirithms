import bisect
import heapq
import queue
import random
import re
import string
import sys
from bisect import *
from collections import *
from collections import Counter
from functools import lru_cache
from heapq import *
import itertools as itr
from math import *
from time import *
from typing import List, Optional

from list_node import *
from tree_node import *


class NumberContainers:
    def __init__(self):
        self.val_table = [defaultdict(lambda: -1)] * (10 ** 5 + 1)
        self.heap_table = defaultdict(lambda: [])

    def change(self, index: int, number: int) -> None:
        bucket = self.val_table[index // 10 ** 4]
        bucket[index] = number
        heappush(self.heap_table[number], index)

    def find(self, number: int) -> int:
        arr = self.heap_table[number]
        while arr:
            index = arr[0]
            bucket = self.val_table[index // 10 ** 4]
            if bucket[index] == number:
                return index
            heappop(arr)
        return -1


# Your NumberContainers object will be instantiated and called as such:
# obj = NumberContainers()
# obj.change(index,number)
# param_2 = obj.find(number)

# obj = NumberContainers()
# print(obj.find(10))
# print(obj.change(2, 10))
# print(obj.change(1, 10))
# print(obj.change(3, 10))
# print(obj.change(5, 10))
# print(print(obj.find(10)))
# print(print(obj.change(1,20)))
# print(obj.find(10))

obj = NumberContainers()
print(obj.find(10))
print(obj.change(1000000000, 10))
print(obj.find(10))

# solution = Solution()


# ["NumberContainers", "find", "change", "change", "change", "change", "find", "change", "find"]
# [[], [10], [2, 10], [1, 10], [3, 10], [5, 10], [10], [1, 20], [10]]
# ["NumberContainers","find","change","find"]
# [[],[10],[1000000000,10],[10]]


# ["NumberContainers","change","change","find","find","find","change","find","find","change","find","change","change","change","find","find","change","find","change","change","change"]
# [[],[25,50],[56,31],[50],[50],[43],[30,50],[31],[43],[25,20],[50],[56,43],[68,31],[56,31],[20],[43],[25,43],[43],[56,31],[54,43],[63,43]]
# [null,null,null,25,-1,-1,null,56,-1,null,30,null,null,null,25,-1,null,25,null,null,null] # Got
# [null,null,null,25,25,-1,null,56,-1,null,30,null,null,null,25,-1,null,25,null,null,null] # Expected

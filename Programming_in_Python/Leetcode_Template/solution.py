import bisect
from cgitb import small
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
from DataStructures_and_Algorithms_in_PYTHON.Graph.Graph import Graph
from list_node import *
from tree_node import *

# class Solution:
#     def matempimumGroups(self, grades: List[int]) -> int:
#         grades.sort()
#         l, r = 0, len(grades)-1
#         traverse = 0
#         groups = 0
#         prev_sum = 0
#         while l < r:
#             target = l + traverse
#             if target > r:
#                 break
#             s = grades[r]
#             while l < target:
#                 s += grades[l]
#                 l += 1
#             while l < r and s <= prev_sum:
#                 s += grades[l]
#                 l += 1
#             r -= 1
#             prev_sum = s
#             traverse += 1
#             groups += 1
#         return groups

class Solution:
    def closestMeetingNode(self, edges: List[int], node1: int, node2: int) -> int:
        n = len(edges)
        graph = Graph(n)        
        for source, target in enumerate(edges):
            graph.add_directed_edge(source, target)
        dj1 = graph.dijkstras_algorithm(node1)
        dj2 = graph.dijkstras_algorithm(node2)
        print(dj1)
        print(dj2)
        arr = [max(dj1[i],dj2[i]) for i in range(n)]
        print(arr)
        smallest = min(arr)
        if smallest == float('inf'):
            return -1
        for i in range(n):
            if arr[i] == smallest:
                return i
        return -1


obj = Solution()
# print(obj.closestMeetingNode(edges = [2,2,3,-1], node1 = 0, node2 = 1))
# print(obj.closestMeetingNode(edges = [1,2,-1], node1 = 0, node2 = 2))
# print(obj.closestMeetingNode([4,4,8,-1,9,8,4,4,1,1],5,6))
print(obj.closestMeetingNode([5,4,5,4,3,6,-1],0,1))
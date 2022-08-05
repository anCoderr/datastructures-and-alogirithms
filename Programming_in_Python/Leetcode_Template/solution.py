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
from DataStructures_and_Algorithms_in_PYTHON.Graph.graph import Graph
from list_node import *
from tree_node import *

sys.setrecursionlimit(10**6)

# class Solution:
#     def mirrorReflection(self, p: int, q: int) -> int:
#         tan = q / p
#         def utility(upward, p):
#             if p % q == 0:
#                 if upward:
#                     return 2 if (p // q) % 2 == 0 else 1
#                 else:
#                     return 0
#             left = p - (p // q) * q
#             effective = p * tan - left
#             print(not upward, left, effective)
#             return utility(not upward, effective)
#         return utility(True, p)

class Solution:
    def mirrorReflection(self, p: int, q: int) -> int:
        A, B, C = q, -p, 0
        arr = [[1, 0, 0], [0,1,p], [1,0,p], [0,1,0]]
        receptors = [[p,0],[p,p],[0,p]]
        left = p

        def reflection(D, E, F):
            nonlocal A, B, C
            f1, f2 = A*E - B*D, B*D - A*E
            t1, t2 = (A*E*E - A*D*D - 2*B*D*E), (B*E*E - B*D*D + 2*A*D*E)
            l1, l2 = C*D - A*F, C*E - B*F
            A, B, C = t1*f1, t2*f2, l1*t2 + l2*t1
                        
        def check_intersection(D, E, F):
            nonlocal A, B, C
            x = (C*E - B*F) / (A*E - B*D)
            y = (C*D - A*F) / (D*B - A*E)
            if 0 <= x <= p and 0 <= y <= p:
                return (True, x, y)
            return (False, x, y)
        
        def check_if_receptor_reached():
            nonlocal A, B, C
            for index, points in enumerate(receptors):
                x, y = points
                if A*x + B*y == C:
                    return index
            return -1
        
        to_skip = 0
        while check_if_receptor_reached() == -1:
            surfaces = []
            for i in range(left // q):

            for index, consts in enumerate(arr):
                if index == to_skip: continue
                d, e, f = consts
                if check_intersection(d, e, f):
                    to_skip = index
                    reflection(d, e, f)
                    break
        
        return check_if_receptor_reached()

solution = Solution()
print(solution.mirrorReflection(21,8))
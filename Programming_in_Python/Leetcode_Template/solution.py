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
from bisect import *

sys.setrecursionlimit(10**6)

class Solution:
    def minNumberOfHours(self, initialEnergy: int, initialExperience: int, energy: List[int], experience: List[int]) -> int:
        # req_energy = max(0, sum(energy) - initialEnergy + 1)
        # ans = req_energy
        # for e in experience:
        #     if initialExperience > e:
        #         initialExperience += e
        #     else:
        #         origial = initialExperience
        #         req_experience = e + 1
        #         initialExperience = req_experience + e 
        #         ans += req_experience - origial
        # return ans
        hours = max(0,sum(energy) - initialEnergy + 1)
        for i in range(len(energy)):
            if initialExperience <= experience[i]:
                temp2 = experience[i] - initialExperience + 1
                initialExperience += temp2
                hours += temp2
            initialExperience += experience[i]
        return hours


sol = Solution()
print(sol.minNumberOfHours(initialEnergy = 5, initialExperience = 3, energy = [1,4,3,2], experience = [2,6,3,1]))
print(sol.minNumberOfHours(1,1,[1,1,1,1],[1,1,1,50]))
print(sol.minNumberOfHours(initialEnergy = 2, initialExperience = 4, energy = [1], experience = [3]))
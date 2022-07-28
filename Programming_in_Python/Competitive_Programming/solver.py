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

sys.stdin = open('Programming_in_Python\Competitive_Programming\input.txt', 'r')
sys.stdout = open('Programming_in_Python\Competitive_Programming\output.txt', 'w')

t = int(input())
for _ in range(t):
    a = int(input())
    N, M = [int(i) for i in input().split(' ')]
    print(a, N, M)
    

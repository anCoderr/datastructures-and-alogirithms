print('------------------------------------------------------------')
import sys
from collections import deque

sys.stdin = open('C:\AnCodeRR\Leetcode_Solutions\CompetitiveProgrammingPython\input.txt', 'r')

sys.stdin = open('input.txt', 'r')

sys.stdout = open('output.txt', 'w')

while True:
    try:
        line = input()
        print(line)
    except EOFError:
        break

a = 10
b = a // 5
print(a + b)
c = a ** 2
c += b * 3
print(a + b + c)
d = deque()
d.append

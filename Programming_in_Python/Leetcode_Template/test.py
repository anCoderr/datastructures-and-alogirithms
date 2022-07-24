from bisect import bisect_left
from collections import Counter, defaultdict


def solver(A, B):
    tableA = Counter(A)
    chars = set(B)
    count = 0
    n = len(B)
    for c in chars:
        if tableA.get(c, 0) == 0:
            return -1
    mapping = {'a': 0, 'b': 1, 'c': 2, 'd': 3, 'e': 4, 'f': 5, 'g': 6, 'h': 7, 'i': 8, 'j': 9, 'k': 10, 'l': 11, 'm': 12, 'n': 13, 'o': 14, 'p': 15, 'q': 16, 'r': 17, 's': 18, 't': 19, 'u': 20, 'v': 21, 'w': 22, 'x': 23, 'y': 24, 'z': 25}
    index = defaultdict(lambda: [])
    for i, a in enumerate(A):
        index[a].append(i)
    for c, arr in index.items():
        arr.sort()
        print(c, arr)
    i = -1
    for b in B:
        print('STARTED')
        idx = bisect_left(index[b], i)
        print(b, index[b], i)
        print(idx)
        if i == len(index[b]):
            count += 1
            i = -1
        else: i = index[b][idx]
        print(i)
        print('DONE')
    return count * n + i

solver("contests", "son")
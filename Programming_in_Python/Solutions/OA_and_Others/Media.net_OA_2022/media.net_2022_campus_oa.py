from collections import defaultdict

class Node:
    def __init__(self):
        self.child = {0: None, 1: None}
        self.part_of = 0

integer_size = 31

class Trie:
    def __init__(self, trie = None):
        self.root = Node()
        if trie:
            self.copy(self.root, trie.root)

    def insert(self, val, op):
        current = self.root
        for i in range(integer_size, -1, -1):
            bit = (val>>i)&1
            if not current.child.get(bit, None):
                current.child[bit] = Node()
            current = current.child[bit]
            current.part_of += op

    def max_xor(self, val):
        current = self.root
        ans = 0
        for i in range(integer_size, -1, -1):
            bit = (val>>i)&1
            if bit == 1:
                if current.child.get(0, None) and current.child[0].part_of > 0:
                    ans += 1 << i
                    current = current.child[0]
                else:
                    current = current.child[1]
            else:
                if current.child.get(1, None) and current.child[1].part_of > 0:
                    ans += 1 << i
                    current = current.child[1]
                else:
                    current = current.child[0]
        return ans

def solver1(A, B, C, D, E):
    trie = Trie()
    graph = [[] for _ in range(A+1)]
    query = [[] for _ in range(A+1)]
    ans = defaultdict(lambda: {})
    for i in range(1, A):
        graph[B[i-1]].append(i+1)
    for i in range(C):
        query[D[i]].append(E[i])
        ans[D[i]][E[i]] = 0
    def dfs(current):
        trie.insert(current, 1)
        for e in query[current]:
            ans[current][e] = trie.max_xor(e)
        for c in graph[current]:
            dfs(c)
        trie.insert(current, -1)
    dfs(1)
    res = []
    for i in range(C):
        res.append(ans[D[i]][E[i]])
    return res

print(solver1(8, [1,1,2,2,3,3,1], 5, [2,3,5,6,8], [1,1,5,4,10]))
print(solver1(3, [1,1], 2, [2,3], [3,1]))




from random import randint
from heapq import *

# Disjoint Sets using UNION BY RANK and PATH COMPRESSION
class DisjointSets:
    def __init__(self, n):
        self.n = n
        self.parent = [i for i in range(n)]
        self.rank = [0] * n

    def find(self, x):
        if self.parent[x] == x:
            return x
        self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x, y):
        parent_x, parent_y = self.find(x), self.find(y)
        if parent_x == parent_y:
            return
        rank_x, rank_y = self.rank[x], self.rank[y]
        if rank_x < rank_y:
            self.parent[parent_x] = parent_y
        else:
            self.parent[parent_y] = parent_x
            if rank_x == rank_y:
                self.rank[parent_x] += 1

# Custom made graph class.
class Graph:
    def __init__(self, v):
        self.v = v
        self.edge_list = []

    def add_edge(self, source, target, weight=1):
        heappush(self.edge_list, [weight, source, target])

    def kruskals_algorithm(self):
        setMST = n = 0
        ds = DisjointSets(self.v)
        while self.edge_list:
            if n > self.v: break
            edge = heappop(self.edge_list)
            source, target = ds.find(edge[1]), ds.find(edge[2])
            if source == target: continue
            ds.union(source, target)
            setMST += edge[0]
            n += 1
        return setMST

######### BRUTE APPROACH:
def brute_solver_two(n, X, Y, Z):
    graph = Graph(n)
    for i in range(n):
        for j in range(n):
            graph.add_edge(i, j, min(abs(X[i]-X[j]), abs(Y[i]-Y[j]), abs(Z[i]-Z[j])))
    return graph.kruskals_algorithm()

######### OPTIMIZED APPROACH:
def optimized_solver_two(n, X, Y, Z):
    graph = Graph(n)
	# Sorted arrays with element being pair of [value, node_id]
    X_sorted = sorted([(x, i) for i, x in enumerate(X)])
    Y_sorted = sorted([(y, i) for i, y in enumerate(Y)])
    Z_sorted = sorted([(z, i) for i, z in enumerate(Z)])
    for i in range(n):
        if i > 0: # We can take edge b/w current node and node at i-1 index.
            graph.add_edge(X_sorted[i][1], X_sorted[i-1][1], abs(X_sorted[i][0] - X_sorted[i-1][0]))
            graph.add_edge(Y_sorted[i][1], Y_sorted[i-1][1], abs(Y_sorted[i][0] - Y_sorted[i-1][0]))
            graph.add_edge(Z_sorted[i][1], Z_sorted[i-1][1], abs(Z_sorted[i][0] - Z_sorted[i-1][0]))
        if i < n-1: # We can take edge b/w current node and node at i+1 index.
            graph.add_edge(X_sorted[i][1], X_sorted[i+1][1], abs(X_sorted[i][0] - X_sorted[i+1][0]))
            graph.add_edge(Y_sorted[i][1], Y_sorted[i+1][1], abs(Y_sorted[i][0] - Y_sorted[i+1][0]))
            graph.add_edge(Z_sorted[i][1], Z_sorted[i+1][1], abs(Z_sorted[i][0] - Z_sorted[i+1][0]))
    return graph.kruskals_algorithm()


# Testing optimized approach with respect to brute one. 
# The brute one obviously works.
# The optimized one is to bew checked.

n = 6
X = [0,10,4,10000,10011,10027]
Y = [11,4,7,10009,10102,10061]
Z = [21,3,20,10019,10059,10011]
print("Brute:", brute_solver_two(n, X, Y, Z), end=" ")
print("Optimized:", optimized_solver_two(n, X, Y, Z))
print("Brute:", brute_solver_two(3, [1,5,7],[2,9,4],[1,3,9]), end=" ")
print("Optimized:", optimized_solver_two(3, [1,5,7],[2,9,4],[1,3,9]))
print("Brute:", brute_solver_two(3, [1,2,1],[2,9,4],[7,4,9]), end=" ")
print("Optimized:", optimized_solver_two(3, [1,2,1],[2,9,4],[7,4,9]))
n = 8
X = [1,11,3,2,1,7,4,7]
Y = [7,2,3,8,11,2,3,2]
Z = [2,3,1,4,10,8,9,8]
print("Brute:", brute_solver_two(n, X, Y, Z), end=" ")
print("Optimized:", optimized_solver_two(n, X, Y, Z))
n = 10
X = [15, 11, 17, 11, 8, 10, 16, 19, 17, 12]
Y = [15, 18, 18, 19, 14, 14, 15, 14, 16, 11]
Z = [6, 18, 18, 3, 16, 19, 15, 13, 16, 6]
print("Brute:", brute_solver_two(n, X, Y, Z), end=" ")
print("Optimized:", optimized_solver_two(n, X, Y, Z))
# Random Test Case Generator.
for t in range(5):
    n = randint(100,10000)
    X = [randint(-100000,100000) for _ in range(n)]
    Y = [randint(-100000,100000) for _ in range(n)]
    Z = [randint(-100000,100000) for _ in range(n)]
    print("Brute:", brute_solver_two(n, X, Y, Z), end=" ") # Wait for a while as brute method takes time for larger values of n.
    print("Optimized:", optimized_solver_two(n, X, Y, Z))
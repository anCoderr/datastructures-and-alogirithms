from bisect import bisect_left
from collections import Counter, defaultdict
from DataStructures_and_Algorithms_in_PYTHON.DisjointSets.disjoint_sets import DisjointSets
from DataStructures_and_Algorithms_in_PYTHON.Graph.graph import Graph
from DataStructures_and_Algorithms_in_PYTHON.Graph.edge import Edge
from random import *


##### QUESTION 1:

# def brute_solver_one(A, B):
#     tableA, chars = Counter(A), set(B)
#     for c in chars:
#         if tableA.get(c, 0) == 0:
#             return -1
#     la, lb = len(A), len(B)
#     a, b = 0, 0
#     ans = 0
#     while b < lb:
#         if A[a] == B[b]:
#             b += 1
#         a = (a+1)%la
#         ans += 1    
#     return ans-1

# def optimized_solver_one(A, B):
#     tableA, chars = Counter(A), set(B)
#     count = 0
#     n, m = len(A), len(B)
#     for c in chars:
#         if tableA.get(c, 0) == 0:
#             return -1
#     index = defaultdict(lambda: [])
#     for i, a in enumerate(A):
#         index[a].append(i)
#     for c, arr in index.items():
#         arr.sort()
#     i = -1
#     j = 0
#     while j < m:
#         b = B[j]
#         idx = bisect_left(index[b], i)
#         if idx == len(index[b]):
#             count += 1
#             i = -1
#         else: 
#             i = index[b][idx]
#             j += 1
#     return count * n + i

# print("Brute:", brute_solver_one("contests", "son"))
# print("Optimized:", optimized_solver_one("contests", "son"))
# print("Brute:", brute_solver_one("abcdefghijklmnopqrstuvwxyz", "zyxwvutsrqponmlkjihgfedcba"))
# print("Optimized:", optimized_solver_one("abcdefghijklmnopqrstuvwxyz", "zyxwvutsrqponmlkjihgfedcba"))
# print("Brute:", brute_solver_one("zyxwvutsrqponmlkjihgfedcba", "abcdefghijklmnopqrstuvwxyz"))
# print("Optimized:", optimized_solver_one("zyxwvutsrqponmlkjihgfedcba", "abcdefghijklmnopqrstuvwxyz"))
# # n = 10**5 // 26 # Worst Case
# n = 10**6 // 26 # Worst beyond the worst case
# a = "abcdefghijklmnopqrstuvwxyz"*n
# b = "zyxwvutsrqponmlkjihgfedcba"*n
# print("Optimized:", optimized_solver_one(a, b)) # Almost instantaneous
# print("Brute:", brute_solver_one(a, b)) # Noticibly slower

##### OUESTION 2:

def brute_solver_two(n, X, Y, Z):
    graph = Graph(n)
    for i in range(n):
        for j in range(n):
            graph.add_undirected_edge(i, j, min(abs(X[i]-X[j]), abs(Y[i]-Y[j]), abs(Z[i]-Z[j])))
    return graph.kruskals_algorithm()

def optimized_solver_two(n, X, Y, Z):
    graph = Graph(n)
	# Sorted arrays with element being pair of [value, node_id]
    X_sorted = sorted([(x, i) for i, x in enumerate(X)])
    Y_sorted = sorted([(y, i) for i, y in enumerate(Y)])
    Z_sorted = sorted([(z, i) for i, z in enumerate(Z)])
    for i in range(n):
        if i > 0: # We can take edge b/w current node and node at i-1 index.
            graph.add_undirected_edge(X_sorted[i][1], X_sorted[i-1][1], abs(X_sorted[i][0] - X_sorted[i-1][0]))
            graph.add_undirected_edge(Y_sorted[i][1], Y_sorted[i-1][1], abs(Y_sorted[i][0] - Y_sorted[i-1][0]))
            graph.add_undirected_edge(Z_sorted[i][1], Z_sorted[i-1][1], abs(Z_sorted[i][0] - Z_sorted[i-1][0]))
        if i < n-1: # We can take edge b/w current node and node at i+1 index.
            graph.add_undirected_edge(X_sorted[i][1], X_sorted[i+1][1], abs(X_sorted[i][0] - X_sorted[i+1][0]))
            graph.add_undirected_edge(Y_sorted[i][1], Y_sorted[i+1][1], abs(Y_sorted[i][0] - Y_sorted[i+1][0]))
            graph.add_undirected_edge(Z_sorted[i][1], Z_sorted[i+1][1], abs(Z_sorted[i][0] - Z_sorted[i+1][0]))
    return graph.kruskals_algorithm()

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
for t in range(5):
    n = randint(10,1000)
    X = [randint(-100000,100000) for _ in range(n)]
    Y = [randint(-100000,100000) for _ in range(n)]
    Z = [randint(-100000,100000) for _ in range(n)]
    print("Brute:", brute_solver_two(n, X, Y, Z), end=" ")
    print("Optimized:", optimized_solver_two(n, X, Y, Z))

##### OUESTION 3:

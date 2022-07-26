from bisect import bisect_left
from collections import Counter, defaultdict
from DataStructures_and_Algorithms_in_PYTHON.DisjointSets.disjoint_sets import DisjointSets
from DataStructures_and_Algorithms_in_PYTHON.Graph.graph import Graph
from DataStructures_and_Algorithms_in_PYTHON.Graph.edge import Edge
from random import *


# # QUESTION 1:

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



# # OUESTION 2:

def brute_solver_two(n, X, Y, Z):
    graph = Graph(n)
    for i in range(n):
        for j in range(n):
            graph.add_undirected_edge(i, j, min(abs(X[i]-X[j]), abs(Y[i]-Y[j]), abs(Z[i]-Z[j])))
    return graph.kruskals_algorithm()

def optimized_solver_two(n, X, Y, Z):

    n = len(X)
    dj = DisjointSets(n)
    X_sorted = sorted([(x, i) for i, x in enumerate(X)])
    Y_sorted = sorted([(y, i) for i, y in enumerate(Y)])
    Z_sorted = sorted([(z, i) for i, z in enumerate(Z)])
    # print(X_sorted)
    # print(Y_sorted)
    # print(Z_sorted)

    cost = 0

    def binary_search(val, idx, arr):
        l, r = 0, n-1
        while l <= r:
            mid = (l+r)//2
            mid_val, mid_idx = arr[mid]
            if val < mid_val:
                r = mid-1
            elif val > mid_val:
                l = mid+1                
            else:
                d = 1 if mid_idx < idx else -1
                while arr[mid][1] != idx:
                    mid += d
                return mid
        return -1

    def lookup_utility(index, arr):
        left, right = index-1, index+1
        curr_val, curr_idx = arr[index]
        while left >= 0 and dj.find(arr[left][1]) == dj.find(curr_idx):
            left -= 1
        while right < n and dj.find(arr[right][1]) == dj.find(curr_idx):
            right += 1
        left = left if left >= 0 else -1
        right = right if right < n else -1
        # if left >= 0:
        #     dj[arr[left][1]] = dj[curr_idx]
        # if right < n:
        #     dj[arr[right][1]] = dj[curr_idx]
        return (float('inf') if left == -1 else arr[left][0], left, float('inf') if right == -1 else arr[right][0], right)

    for i in range(n):
        x_curr, y_curr, z_curr = X[i], Y[i], Z[i]
        x_mid = binary_search(x_curr, i, X_sorted)
        y_mid = binary_search(y_curr, i, Y_sorted)
        z_mid = binary_search(z_curr, i, Z_sorted)
        x_prev, x_prev_idx, x_after, x_after_idx = lookup_utility(x_mid, X_sorted)
        y_prev, y_prev_idx, y_after, y_after_idx = lookup_utility(y_mid, Y_sorted)
        z_prev, z_prev_idx, z_after, z_after_idx = lookup_utility(z_mid, Z_sorted)
        
        x_prev = abs(x_curr - x_prev)
        x_after = abs(x_curr - x_after)
        y_prev = abs(y_curr - y_prev)
        y_after = abs(y_curr - y_after)
        z_prev = abs(z_curr - z_prev)
        z_after = abs(z_curr - z_after)

        val = min(x_prev, x_after, y_prev, y_after, z_prev, z_after)

        x_prev_idx = X_sorted[x_prev_idx][1]
        x_after_idx = X_sorted[x_after_idx][1]
        y_prev_idx = Y_sorted[y_prev_idx][1]
        y_after_idx = Y_sorted[y_after_idx][1]
        z_prev_idx = Z_sorted[z_prev_idx][1]
        z_after_idx = Z_sorted[z_after_idx][1]
        


        if val == float('inf'):
            continue
\
        if val == x_prev:
            print(x_prev_idx, i)
            dj.union(x_prev_idx, i)
        elif val == x_after:
            print(x_after_idx, i)
            dj.union(x_after_idx, i)
        elif val == y_prev:
            print(y_prev_idx, i)
            dj.union(y_prev_idx, i)
        elif val == y_after:
            print(y_after_idx, i)
            dj.union(y_after_idx, i)
        elif val == z_prev:
            print(z_prev_idx, i)
            dj.union(z_prev_idx, i)
        elif val == z_after:
            print(z_after_idx, i)
            dj.union(z_after_idx, i)
        # print(val)
        cost += val
    return cost

# print("Brute:", brute_solver_two(3, [1,5,7],[2,9,4],[1,3,9]), end=" ")
# print("Optimized:", optimized_solver_two(3, [1,5,7],[2,9,4],[1,3,9]))
# print("Brute:", brute_solver_two(3, [1,2,1],[2,9,4],[7,4,9]), end=" ")
# print("Optimized:", optimized_solver_two(3, [1,2,1],[2,9,4],[7,4,9]))

# for t in range(5):
#     n = randint(10,100)
#     X = [randint(-100000,100000) for _ in range(n)]
#     Y = [randint(-100000,100000) for _ in range(n)]
#     Z = [randint(-100000,100000) for _ in range(n)]
#     print("Brute:", brute_solver_two(n, X, Y, Z), end=" ")
#     print("Optimized:", optimized_solver_two(n, X, Y, Z))


# n = 8
# X = [1,11,3,2,1,7,4,7]
# Y = [7,2,3,8,11,2,3,2]
# Z = [2,3,1,4,10,8,9,8]
# print("Brute:", brute_solver_two(n, X, Y, Z), end=" ")
# print("Optimized:", optimized_solver_two(n, X, Y, Z))

for t in range(1):
    n = 10
    X = [15, 11, 17, 11, 8, 10, 16, 19, 17, 12]
    Y = [15, 18, 18, 19, 14, 14, 15, 14, 16, 11]
    Z = [6, 18, 18, 3, 16, 19, 15, 13, 16, 6]
    print("Brute:", brute_solver_two(n, X, Y, Z), end=" ")
    print("Optimized:", optimized_solver_two(n, X, Y, Z))

# [15, 11, 17, 11, 8, 10, 16, 19, 17, 12]
# [15, 18, 18, 19, 14, 14, 15, 14, 16, 11]
# [6, 18, 18, 3, 16, 19, 15, 13, 16, 6]
# Brute: 1 Optimized: 8
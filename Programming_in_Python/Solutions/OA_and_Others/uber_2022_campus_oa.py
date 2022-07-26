from bisect import bisect_left
from collections import Counter, defaultdict
from DataStructures_and_Algorithms_in_PYTHON.DisjointSets.disjoint_sets import DisjointSets



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

# def brute_solver_two(n, X, Y, Z):

def optimized_solver_two(n, X, Y, Z):
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
                
                # return mid
                # if mid_idx == idx:
                #     return mid
                # if mid_idx < idx:
                    
                # else:
        return -1

    def lookup_utility():


    dj = DisjointSets(n)
    X_sorted = sorted([(x, i) for i, x in enumerate(X)])
    Y_sorted = sorted([(y, i) for i, y in enumerate(Y)])
    Z_sorted = sorted([(z, i) for i, z in enumerate(Z)])
    print(X_sorted)
    print(Y_sorted)
    print(Z_sorted)

    cost = 0

    for i in range(n):
        x_curr, y_curr, z_curr = X[i], Y[i], Z[i]
        x_prev, x_after = binary_search(x_curr, X_sorted)
        y_prev, y_after = binary_search(y_curr, Y_sorted)
        z_prev, z_after = binary_search(z_curr, Z_sorted)
        
        val = min(
            min(abs(x_prev - x_curr), abs(x_curr - x_after)),
            min(abs(y_prev - y_curr), abs(y_curr - y_after)),
            min(abs(z_prev - z_curr), abs(z_curr - z_after))
        )
        print(val)
        cost += val
    
    return cost

print("Optimized:", optimized_solver_two(3, [1,5,7],[2,9,4],[1,3,9]))
print("Optimized:", optimized_solver_two(3, [1,2,1],[2,9,4],[7,4,9]))





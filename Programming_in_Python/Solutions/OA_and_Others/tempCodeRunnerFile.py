# QUESTION 1:

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
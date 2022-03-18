 # Simple Implementation of Disjoint Sets --------------------
 #
 # Time Complexity for Find = O(n) and Union = O(n) for Worst Case
 #
 # Disjoint Sets Naive
    def __init__(self, n):
        self.n = n
        self.parent = [i for i in range(n)]

    def find(self, x):
        if self.parent[x] == x:
            return x
        return self.find(self.parent[x])

    def union(self, x, y):
        parent_x = self.find(x)
        parent_y = self.find(y)
        if parent_x == parent_y:
            return
        self.parent[parent_y] = parent_x

 # Union by Rank Optimization for Disjoint Sets --------------------
 #
 # Time Complexity for Find = O(log(n)) and Union = O(log(n))
 #
 # Rank Optimization is an optimization for the Union function for Disjoint Sets.
 #
 # The idea is to take the union of the sets in such a fashion
 #    that the height of the new tree remains the same and doesnt increase.
 #    In the basic implementation we didn't take that into account and just
 #    assigned 2ed set to the 1st set. For doing that we keep add a rank array
 #    that keeps track of the rank of each set.
 #
 #
 # Disjoint Sets using UNION BY RANK
class DisjointSetsSemiOptimized:
    def __init__(self, n):
        self.n = n
        self.parent = [i for i in range(n)]
        self.rank = [0] * n

    def find(self, x):
        if self.parent[x] == x:
            return x
        return self.find(self.parent[x])

    def union(self, x, y):
        parent_x = self.find(x)
        parent_y = self.find(y)
        if parent_x == parent_y:
            return
        rank_x = self.rank[x]
        rank_y = self.rank[y]
        if rank_x < rank_y:
            self.parent[parent_x] = parent_y
        else:
            self.parent[parent_y] = parent_x
            if rank_x == rank_y:
                self.rank[parent_x] += 1


 # Path Compression Optimization for Disjoint Sets --------------------
 #
 # Time Complexity for Find = O(1) and Union = O(1) on Average (Amortized Time Complexity)
 #
 # Path Compression is an optimization for the Find function for Disjoint Sets.
 #
 # The idea is to take to directly connect the lower nodes directly to their
 #    representative after current find is implemented in simple recursive fashion.
 #    This way we are actually optimizing the find function for later calls of the function.
 #
 #          0                           0
 #         / \     Find for 3          /|\     ==> For future calls for find lets say 6/7
 #        1  2     implemented        1 2 3        we have optimized the graph so that
 #       / \  \  ==============>     / / / \       time complexity is less due to less
 #      3  4  5    3->1->0__Ans     4 5 6  7       comparison operations.
 #     / \       [3 comparisons]
 #    6  7
 #
 #    All the nodes between parent and starting node will later have parent as their
 #    parent directly rather than having other nodes in between so as to improve time
 #    complexity for further calls.
 #
 #
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
        parent_x = self.find(x)
        parent_y = self.find(y)
        if parent_x == parent_y:
            return
        rank_x = self.rank[x]
        rank_y = self.rank[y]
        if rank_x < rank_y:
            self.parent[parent_x] = parent_y
        else:
            self.parent[parent_y] = parent_x
            if rank_x == rank_y:
                self.rank[parent_x] += 1

package DataStructures.DisjointSets;
// Simple Implementation of Disjoint Sets --------------------

// Time Complexity for Find = O(n) and Union = O(n) for Worst Case

// Disjoint Sets Naive
class DisjointSetNaive {
    int[] parent;
    public DisjointSetNaive(int size) {
        parent = new int[size];
        for(int i = 0; i<size; i++)
            parent[i] = i;
    }
    public int find(int x) {
        if(parent[x] == x)
            return x;
        else
            return find(parent[x]);
    }
    public void union(int x, int y) {
        int x_rep = find(x);
        int y_rep = find(y);
        if(x_rep == y_rep) return;
        parent[y_rep] = x_rep;
    }
}

// Union by Rank Optimization for Disjoint Sets --------------------

// Time Complexity for Find = O(log(n)) and Union = O(log(n))

// Rank Optimization is an optimization for the Union function for Disjoint Sets.

/* The idea is to take the union of the sets in such a fashion
    that the height of the new tree remains the same and doesnt increase.
    In the basic implementation we didn't take that into account and just
    assigned 2ed set to the 1st set. For doing that we keep add a rank array
    that keeps track of the rank of each set.
 */

// Disjoint Sets using UNION BY RANK
class DisjointSetUnionByRank {
    int[] parent, rank;
    public DisjointSetUnionByRank(int size) {
        parent = new int[size];
        rank = new int[size];
        for(int i = 0; i<size; i++)
            parent[i] = i;
    }
    public int find(int x) {
        if(parent[x] == x)
            return x;
        else
            return find(parent[x]);
    }
    public void union(int x, int y) {
        int x_rep = find(x);
        int y_rep = find(y);
        if(x_rep == y_rep)
            return;
        if(rank[x_rep] > rank[y_rep])
            parent[y_rep] = x_rep;
        else if(rank[x_rep] < rank[y_rep])
            parent[x_rep] = y_rep;
        else {
            parent[y_rep] = x_rep;
            rank[x_rep]++;
        }
    }
}

// Path Compression Optimization for Disjoint Sets --------------------

// Time Complexity for Find = O(1) and Union = O(1) on Average (Amortized Time Complexity)

// Path Compression is an optimization for the Find function for Disjoint Sets.

/* The idea is to take to directly connect the lower nodes directly to their
    representative after current find is implemented in simple recursive fashion.
    This way we are actually optimizing the find function for later calls of the function.

          0                           0
         / \     Find for 3          /|\     ==> For future calls for find lets say 6/7
        1  2     implemented        1 2 3        we have optimized the graph so that
       / \  \  ==============>     / / / \       time complexity is less due to less
      3  4  5    3->1->0__Ans     4 5 6  7       comparison operations.
     / \       [3 comparisons]
    6  7

    All the nodes between parent and starting node will later have parent as their
    parent directly rather than having other nodes in between so as to improve time
    complexity for further calls.
 */

// Disjoint Sets using UNION BY RANK and PATH COMPRESSION
public class DisjointSets {
    int[] parent, rank;
    public DisjointSets(int size) {
        parent = new int[size];
        rank = new int[size];
        for(int i = 0; i<size; i++)
            parent[i] = i;
    }
    public int find(int x) {
        if(parent[x] == x)
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y) {
        int x_rep = find(x);
        int y_rep = find(y);
        if(x_rep == y_rep)
            return;
        if(rank[x_rep] > rank[y_rep])
            parent[y_rep] = x_rep;
        else if(rank[x_rep] < rank[y_rep])
            parent[x_rep] = y_rep;
        else {
            parent[y_rep] = x_rep;
            rank[x_rep]++;
        }
    }
}
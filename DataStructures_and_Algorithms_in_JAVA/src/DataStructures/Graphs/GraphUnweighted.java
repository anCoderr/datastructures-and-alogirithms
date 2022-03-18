package DataStructures.Graphs;
import DataStructures.DisjointSets.DisjointSets;
import java.util.*;

// Basic implementation of Unweighted Graph ------------------------------

public class GraphUnweighted {

    // Runner Class
    static class Runner {
        public static void main(String[] args) {
            GraphUnweighted undirGraphUnweighted = new GraphUnweighted(6);
            GraphUnweighted dirGraphUnweighted = new GraphUnweighted(6);

            undirGraphUnweighted.addEdgeUndirected(0,1);
            undirGraphUnweighted.addEdgeUndirected(0,2);
            undirGraphUnweighted.addEdgeUndirected(1,3);
            undirGraphUnweighted.addEdgeUndirected(2,5);
            undirGraphUnweighted.addEdgeUndirected(3,4);
            undirGraphUnweighted.addEdgeUndirected(3,5);
            undirGraphUnweighted.addEdgeUndirected(4,5);

            dirGraphUnweighted.addEdgeDirected(0,1);
            dirGraphUnweighted.addEdgeDirected(0,2);
            dirGraphUnweighted.addEdgeDirected(2,5);
            dirGraphUnweighted.addEdgeDirected(3,1);
            dirGraphUnweighted.addEdgeDirected(3,4);
            dirGraphUnweighted.addEdgeDirected(5,3);
            dirGraphUnweighted.addEdgeDirected(5,4);

            System.out.println("BFS Search Started");
            System.out.println(undirGraphUnweighted.BFS_search(0, 5));
            System.out.println("DFS Recursion Search Started");
            System.out.println(undirGraphUnweighted.DFS_recursion_search(0, 5, new boolean[6]));
            System.out.println("DFS Stack Search Started");
            System.out.println(undirGraphUnweighted.DFS_stack_search(0, 5));
            System.out.println("BFS Traversal Started");
            undirGraphUnweighted.BFS_traversal(0);
            System.out.println("DFS Recursion Traversal Started");
            undirGraphUnweighted.DFS_recursion_traversal(0, new boolean[6]);
            System.out.println("DFS Stack Traversal Started");
            undirGraphUnweighted.DFS_stack_traversal(0);
            System.out.println("DFS Recursion Cycle Detection Started");
            System.out.println(undirGraphUnweighted.DetectCycle_DFS_Recursion_Undirected(new boolean[6], -1, 0));
            System.out.println("DFS Stack Cycle Detection Started");
            System.out.println(undirGraphUnweighted.DetectCycle_DFS_Stack_Undirected(0));
            System.out.println("BFS Cycle Detection Started");
            System.out.println(undirGraphUnweighted.DetectCycle_BFS_Undirected());
            System.out.println("Disjoint Set Cycle Detection Started");
            System.out.println(undirGraphUnweighted.DetectCycle_DisjointSets_Undirected());
            System.out.println("Topological Sorting Started");
            dirGraphUnweighted.topologicalSorting();
            System.out.println("Weighted Graphs Algorithms Begin");
        }
    }

    private final int v;
    private final ArrayList<Integer>[] adj;
    private final ArrayList<int[]> edgeList;

    public GraphUnweighted(int v) {
        this.v = v;
        adj = new ArrayList[v];
        edgeList = new ArrayList<>();
        for (int i=0; i<v; ++i)
            adj[i] = new ArrayList<>();
    }

    public void addEdgeDirected(int v, int u) {
        adj[v].add(u);
        edgeList.add(new int[] {u, v});
    }
    public void addEdgeUndirected(int v, int u) {
        adj[v].add(u);
        adj[u].add(v);
        edgeList.add(new int[] {u, v});
    }
    public boolean deleteEdgeDirected(int v, int u) {
        if(adj[v].remove((Integer)u)){
            return edgeList.removeIf(edge -> edge[0] == v && edge[1] == u);
        }
        return false;
    }
    public boolean deleteEdgeUndirected(int v, int u) {
        if(adj[v].remove((Integer)u) && adj[u].remove((Integer)v)){
            return edgeList.removeIf(edge -> edge[0] == u && edge[1] == v) && edgeList.removeIf(edge -> edge[0] == v && edge[1] == u);
        }
        return false;
    }

    public void printEdgeList() {
        System.out.println("Printing EdgeList");
        for(int[] arr : edgeList) {
            System.out.println(arr[0] + "->" + arr[1]);
        }
    }

    public void BFS_traversal(int s) {
        boolean[] visited = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        int curr;
        while(queue.size() != 0) {
            curr = queue.poll();
            System.out.println(curr+" ");
            for(int i : adj[curr]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public boolean BFS_search(int s, int t) {
        boolean[] visited = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        int curr;
        while(queue.size() != 0) {
            curr = queue.poll();
            if(curr == t)
                return true;
            for(int i : adj[curr]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return false;
    }

    public boolean DFS_recursion_search(int s, int t, boolean[] visited) {
        if(visited[s])
            return false;
        if(s == t)
            return true;
        visited[s] = true;
        for(int i : adj[s]) {
            if(DFS_recursion_search(i, t, visited))
                return true;
        }
        return false;
    }

    public boolean DFS_stack_search(int s, int t) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];
        stack.push(s);
        int current;
        while(!stack.isEmpty()) {
            current = stack.pop();
            if(current == t)
                return true;
            visited[current] = true;
            for(int i : adj[current]) {
                if(i == t)
                    return true;
                else if(!visited[i])
                    stack.push(i);
            }
        }
        return false;
    }

    public void DFS_recursion_traversal(int start, boolean[] visited) {
        if(visited[start])
            return;
        System.out.println(start);
        visited[start] = true;
        for(int i : adj[start])
            DFS_recursion_traversal(i, visited);
    }

    public void DFS_stack_traversal(int start) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        int curr;
        while(!stack.isEmpty()) {
            curr = stack.pop();
            visited[curr] = true;
            System.out.println(curr);
            for(int i : adj[curr]) {
                if(!visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }

    public boolean DetectCycle_DFS_Recursion_Undirected(boolean[] visited, int parent, int current) {
        if(visited[current])
            return true;
        visited[current] = true;
        for(int i : adj[current]) {
            if(!visited[i]) {
                if(DetectCycle_DFS_Recursion_Undirected(visited, current, i))
                    return true;
            } else if(i != parent)
                return true;
        }
        return false;
    }

    public boolean DetectCycle_DFS_Stack_Undirected(int s) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        int current;
        while(!stack.empty()) {
            current = stack.pop();
            visited[current] = true;
            for(int i : adj[current]) {
                if(!visited[current]) {
                    stack.push(i);
                } else
                    return true;
            }
        }
        return false;
    }

    public boolean DetectCycle_BFS_Undirected() {
        boolean[] visited = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> parent = new LinkedList<>();
        int current, currParent;
        queue.add(0);
        parent.add(-1);
        while(!queue.isEmpty()) {
            current = queue.poll();
            currParent = parent.poll();
            visited[current] = true;
            for(int i : adj[current]) {
                if(!visited[i]) {
                    queue.add(i);
                    parent.add(current);
                } else if(currParent != i)
                    return true;
            }
        }
        return false;
    }

    public boolean DetectCycle_DisjointSets_Undirected() {
        DisjointSets ds = new DisjointSets(v);
        int f, s;
        for(int[] arr : edgeList) {
            f = ds.find(arr[0]);
            s = ds.find(arr[1]);
            if(f == s)
                return true;
            ds.union(f, s);
        }
        return false;
    }

    public void topologicalSorting() {
        int[] schedule = new int[v];
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[v];
        int current, index = 0;
        for(List<Integer> list : adj)
            for(int i : list)
                indegree[i]++;
        for(int i = 0; i<v; i++)
            if(indegree[i] == 0)
                queue.add(i);
        while(!queue.isEmpty()) {
            current = queue.poll();
            for(Integer i : adj[current]) {
                indegree[i]--;
                if(indegree[i] == 0)
                    queue.add(i);
            }
            schedule[index] = current;
            index++;
        }
        for(int i : schedule) {
            System.out.print(i + " -> ");
        }
        System.out.print("DONE!!\n");
    }
}
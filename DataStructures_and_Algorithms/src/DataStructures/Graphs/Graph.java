package DataStructures.Graphs;

import DataStructures.DisjointSets.DisjointSets;

import java.util.*;

class Graph {
    // Runner class
    static class Runner {
        public static void main(String[] args) {
            Graph undirGraphUnweighted = new Graph(6);
            Graph dirGraphUnweighted = new Graph(6);
            Graph dirGraphWeighted = new Graph(6);
            Graph undirGraphWeighted = new Graph(6);

            int v = 6;

            undirGraphUnweighted.addUndirectedEdge(0,1,1);
            undirGraphUnweighted.addUndirectedEdge(0,2,1);
            undirGraphUnweighted.addUndirectedEdge(1,3,1);
            undirGraphUnweighted.addUndirectedEdge(2,5,1);
            undirGraphUnweighted.addUndirectedEdge(3,4,1);
            undirGraphUnweighted.addUndirectedEdge(3,5,1);
            undirGraphUnweighted.addUndirectedEdge(4,5,1);

            undirGraphWeighted.addUndirectedEdge(0, 1, 4);
            undirGraphWeighted.addUndirectedEdge(0, 2, 2);
            undirGraphWeighted.addUndirectedEdge(1, 3, 6);
            undirGraphWeighted.addUndirectedEdge(2, 5, 2);
            undirGraphWeighted.addUndirectedEdge(3, 4, 3);
            undirGraphWeighted.addUndirectedEdge(3, 5, 4);
            undirGraphWeighted.addUndirectedEdge(4, 5, 1);

            dirGraphUnweighted.addDirectedEdge(0,1,1);
            dirGraphUnweighted.addDirectedEdge(0,2,1);
            dirGraphUnweighted.addDirectedEdge(2,5,1);
            dirGraphUnweighted.addDirectedEdge(3,1,1);
            dirGraphUnweighted.addDirectedEdge(3,4,1);
            dirGraphUnweighted.addDirectedEdge(5,3,1);
            dirGraphUnweighted.addDirectedEdge(5,4,1);

            dirGraphWeighted.addDirectedEdge(0, 1, 4);
            dirGraphWeighted.addDirectedEdge(0, 2, 2);
            dirGraphWeighted.addDirectedEdge(2, 5, 2);
            dirGraphWeighted.addDirectedEdge(3, 1, 6);
            dirGraphWeighted.addDirectedEdge(3, 4, 3);
            dirGraphWeighted.addDirectedEdge(5, 3, 4);
            dirGraphWeighted.addDirectedEdge(5, 4, 1);


            /* ---------------------------------------- TRAVERSAL ---------------------------------------- */
            /* BFS Traversal on all types of graphs ---------- */
            System.out.println("BFS Traversal");
            System.out.println("Undirected Unweighted DataStructures.Graphs.Graph Traversal");
            undirGraphUnweighted.BFS_traversal(0);
            System.out.println("Undirected Weighted DataStructures.Graphs.Graph Traversal");
            undirGraphWeighted.BFS_traversal(0);
            System.out.println("Directed Weighted DataStructures.Graphs.Graph Traversal");
            dirGraphWeighted.BFS_traversal(0);
            System.out.println("Directed Unweighted DataStructures.Graphs.Graph Traversal");
            dirGraphUnweighted.BFS_traversal(0);

            /* DFS Recursion Traversal on all types of graphs ---------- */
            System.out.println("DFS Recursion Traversal");
            System.out.println("Undirected Unweighted DataStructures.Graphs.Graph Traversal");
            undirGraphUnweighted.DFS_recursion_traversal(0, new boolean[v]);
            System.out.println("Undirected Weighted DataStructures.Graphs.Graph Traversal");
            undirGraphWeighted.DFS_recursion_traversal(0, new boolean[v]);
            System.out.println("Directed Weighted DataStructures.Graphs.Graph Traversal");
            dirGraphWeighted.DFS_recursion_traversal(0, new boolean[v]);
            System.out.println("Directed Unweighted DataStructures.Graphs.Graph Traversal");
            dirGraphUnweighted.DFS_recursion_traversal(0, new boolean[v]);

            /* DFS Stack Traversal on all types of graphs ---------- */
            System.out.println("DFS Stack Traversal");
            System.out.println("Undirected Unweighted DataStructures.Graphs.Graph Traversal");
            undirGraphUnweighted.DFS_stack_traversal(0);
            System.out.println("Undirected Weighted DataStructures.Graphs.Graph Traversal");
            undirGraphWeighted.DFS_stack_traversal(0);
            System.out.println("Directed Weighted DataStructures.Graphs.Graph Traversal");
            dirGraphWeighted.DFS_stack_traversal(0);
            System.out.println("Directed Unweighted DataStructures.Graphs.Graph Traversal");
            dirGraphUnweighted.DFS_stack_traversal(0);

            /* ---------------------------------------- SEARCHING ---------------------------------------- */
            /* BFS Searching on all types of graphs ---------- */
            System.out.println("BFS Searching");
            System.out.println("Undirected Unweighted DataStructures.Graphs.Graph Searching");
            undirGraphUnweighted.BFS_search(0, 4);
            System.out.println("Undirected Weighted DataStructures.Graphs.Graph Searching");
            undirGraphWeighted.BFS_search(0, 4);
            System.out.println("Directed Weighted DataStructures.Graphs.Graph Searching");
            dirGraphWeighted.BFS_search(0, 4);
            System.out.println("Directed Unweighted DataStructures.Graphs.Graph Searching");
            dirGraphUnweighted.BFS_search(0, 4);

            /* DFS Recursion Searching on all types of graphs ---------- */
            System.out.println("DFS Recursion Searching");
            System.out.println("Undirected Unweighted DataStructures.Graphs.Graph Searching");
            undirGraphUnweighted.DFS_recursion_search(0, 4, new boolean[v]);
            System.out.println("Undirected Weighted DataStructures.Graphs.Graph Searching");
            undirGraphWeighted.DFS_recursion_search(0, 4, new boolean[v]);
            System.out.println("Directed Weighted DataStructures.Graphs.Graph Searching");
            dirGraphWeighted.DFS_recursion_search(0, 4, new boolean[v]);
            System.out.println("Directed Unweighted DataStructures.Graphs.Graph Searching");
            dirGraphUnweighted.DFS_recursion_search(0, 4, new boolean[v]);

            /* DFS Stack Searching on all types of graphs ---------- */
            System.out.println("DFS Stack Searching");
            System.out.println("Undirected Unweighted DataStructures.Graphs.Graph Searching");
            undirGraphUnweighted.DFS_stack_search(0, 4);
            System.out.println("Undirected Weighted DataStructures.Graphs.Graph Searching");
            undirGraphWeighted.DFS_stack_search(0, 4);
            System.out.println("Directed Weighted DataStructures.Graphs.Graph Searching");
            dirGraphWeighted.DFS_stack_search(0, 4);
            System.out.println("Directed Unweighted DataStructures.Graphs.Graph Searching");
            dirGraphUnweighted.DFS_stack_search(0, 4);

            /* ---------------------------------------- DELETE EDGE, PRINTING EDGES,  CHECK EDGE EXISTS, FIND WEIGHT OF EDGE ---------------------------------------- */
            /* Deleting DataStructures.Graphs.Edge on all types of graphs ---------- */
            System.out.println("Deleting DataStructures.Graphs.Edge");
            System.out.println("Undirected Unweighted DataStructures.Graphs.Graph Deleting");
            undirGraphUnweighted.printEdgeList();
            undirGraphUnweighted.deleteEdgeUndirected(0,2);
            undirGraphUnweighted.printEdgeList();
            System.out.println("Undirected Weighted DataStructures.Graphs.Graph Deleting");
            undirGraphWeighted.printEdgeList();
            undirGraphWeighted.deleteEdgeUndirected(0, 2);
            undirGraphWeighted.printEdgeList();
            System.out.println("Directed Weighted DataStructures.Graphs.Graph Deleting");
            dirGraphWeighted.printEdgeList();
            dirGraphWeighted.deleteEdgeDirected(0, 2);
            dirGraphWeighted.printEdgeList();
            System.out.println("Directed Unweighted DataStructures.Graphs.Graph Deleting");
            dirGraphUnweighted.printEdgeList();
            dirGraphUnweighted.deleteEdgeDirected(0, 2);
            dirGraphUnweighted.printEdgeList();

            /* Check if DataStructures.Graphs.Edge and its Weight if Exists on all types of graphs ---------- */
            System.out.println("Checking Edges and their Weights");
            System.out.println("Undirected Unweighted DataStructures.Graphs.Graph Deleting");
            System.out.println(undirGraphUnweighted.checkIfEdgeExists(3,4));
            System.out.println(undirGraphUnweighted.checkWeightIfEdgeExists(3,4));
            System.out.println("Undirected Weighted DataStructures.Graphs.Graph Deleting");
            System.out.println(undirGraphWeighted.checkIfEdgeExists(3,4));
            System.out.println(undirGraphWeighted.checkWeightIfEdgeExists(3,4));
            System.out.println("Directed Weighted DataStructures.Graphs.Graph Deleting");
            System.out.println(dirGraphWeighted.checkIfEdgeExists(3,4));
            System.out.println(dirGraphWeighted.checkWeightIfEdgeExists(3,4));
            System.out.println("Directed Unweighted DataStructures.Graphs.Graph Deleting");
            System.out.println(dirGraphUnweighted.checkIfEdgeExists(3,4));
            System.out.println(dirGraphUnweighted.checkWeightIfEdgeExists(3,4));

            /* ---------------------------------------- TOPOLOGICAL SORT ---------------------------------------- */
            /* Find topological sort of all types of graphs ---------- */
            System.out.println("Topological sort for Directed Acyclic Graphs");
            System.out.println("Directed Unweighted DataStructures.Graphs.Graph Topological Sort with DFS");
            dirGraphUnweighted.topologicalSort_DFS();
            System.out.println("Directed Weighted DataStructures.Graphs.Graph Topological Sort with DFS");
            dirGraphWeighted.topologicalSort_DFS();
            System.out.println("Directed Unweighted DataStructures.Graphs.Graph Topological Sort with BFS");
            dirGraphUnweighted.topologicalSorting_BFS();
            System.out.println("Directed Unwighted DataStructures.Graphs.Graph Topological Sort with DFS Stack Kahn's Algorithm");
            dirGraphUnweighted.topologicalSorting_DFS_KhansAlgo();
            System.out.println("Directed Weighted DataStructures.Graphs.Graph Topological Sort with BFS");
            dirGraphWeighted.topologicalSorting_BFS();
            System.out.println("Directed Weighted DataStructures.Graphs.Graph Topological Sort with DFS Stack Kahn's Algorithm");
            dirGraphWeighted.topologicalSorting_DFS_KhansAlgo();

            /* ---------------------------------------- CYCLE DETECTION ---------------------------------------- */
            /* Cycle detection all types of graphs ---------- */
            System.out.println("Cycle Detection for Undirected Graphs");
            undirGraphUnweighted.printEdgeList();
            undirGraphUnweighted.deleteEdgeUndirected(5,4);
            undirGraphUnweighted.deleteEdgeUndirected(5,2);
            undirGraphUnweighted.printEdgeList();

            undirGraphWeighted.printEdgeList();
            undirGraphWeighted.deleteEdgeUndirected(5,4);
            undirGraphWeighted.deleteEdgeUndirected(5,2);
            undirGraphWeighted.printEdgeList();
            System.out.println("Undirected Unweighted DataStructures.Graphs.Graph Cycle Detection with DFS Recursion");
            System.out.println(undirGraphUnweighted.DetectCycle_DFS_Recursion_Undirected());
            System.out.println("Undirected Unweighted DataStructures.Graphs.Graph Cycle Detection with DFS Stack");
            System.out.println(undirGraphUnweighted.DetectCycle_DFS_Stack_Undirected());
            System.out.println("Undirected Unweighted DataStructures.Graphs.Graph Cycle Detection with BFS");
            System.out.println(undirGraphUnweighted.DetectCycle_BFS_Undirected());
            System.out.println("Undirected Unweighted DataStructures.Graphs.Graph Cycle Detection with Disjoint Sets");
            System.out.println(undirGraphUnweighted.DetectCycle_DisjointSets_Undirected());

            System.out.println("Undirected Weighted DataStructures.Graphs.Graph Cycle Detection with DFS Recursion");
            System.out.println(undirGraphWeighted.DetectCycle_DFS_Recursion_Undirected());
            System.out.println("Undirected Weighted DataStructures.Graphs.Graph Cycle Detection with DFS Stack");
            System.out.println(undirGraphWeighted.DetectCycle_DFS_Stack_Undirected());
            System.out.println("Undirected Weighted DataStructures.Graphs.Graph Cycle Detection with BFS");
            System.out.println(undirGraphWeighted.DetectCycle_BFS_Undirected());
            System.out.println("Undirected Unweighted DataStructures.Graphs.Graph Cycle Detection with Disjoint Sets");
            System.out.println(undirGraphWeighted.DetectCycle_DisjointSets_Undirected());

            dirGraphWeighted.printEdgeList();
            dirGraphWeighted.deleteEdgeDirected(5,4);
            dirGraphWeighted.addDirectedEdge(4,5, 1);
            dirGraphWeighted.printEdgeList();

            dirGraphUnweighted.printEdgeList();
            dirGraphUnweighted.deleteEdgeDirected(5,4);
            dirGraphUnweighted.addDirectedEdge(4,5, 1);
            dirGraphUnweighted.printEdgeList();
            System.out.println("Directed Unweighted DataStructures.Graphs.Graph Cycle Detection with DFS Recursion");
            System.out.println(dirGraphUnweighted.DetectCycle_DFS_Recursion_Directed());
            System.out.println("Directed Weighted DataStructures.Graphs.Graph Cycle Detection with DFS Stack");
            System.out.println(dirGraphUnweighted.DetectCycle_DFS_Stack_Directed());
            System.out.println("Directed Unweighted DataStructures.Graphs.Graph Cycle Detection with BFS");
            System.out.println(dirGraphUnweighted.DetectCycle_BFS_Directed());

            System.out.println("Directed Weighted DataStructures.Graphs.Graph Cycle Detection with DFS Recursion");
            System.out.println(dirGraphWeighted.DetectCycle_DFS_Recursion_Directed());
            System.out.println("Directed Weighted DataStructures.Graphs.Graph Cycle Detection with DFS Stack");
            System.out.println(dirGraphWeighted.DetectCycle_DFS_Stack_Directed());
            System.out.println("Directed Weighted DataStructures.Graphs.Graph Cycle Detection with BFS");
            System.out.println(dirGraphWeighted.DetectCycle_BFS_Directed());

            /* ---------------------------------------- MST ALGORITHMS ---------------------------------------- */
            /* MST Algorithm for all types of undirected graphs ---------- */
            System.out.println("MST Algorithms for undirected graphs");
            System.out.println("Undirected Weighted DataStructures.Graphs.Graph Prims Algorithm MST");
            undirGraphWeighted.PrimsAlgo();
            System.out.println("Undirected Unweighted DataStructures.Graphs.Graph Prims Algorithm MST");
            undirGraphUnweighted.PrimsAlgo();
            System.out.println("Undirected Weighted DataStructures.Graphs.Graph Kruskal's Algorithm MST");
            undirGraphWeighted.KruskalAlgo();
            System.out.println("Undirected Unweighted DataStructures.Graphs.Graph Kruskal's Algorithm MST");
            undirGraphUnweighted.KruskalAlgo();

            /* ---------------------------------------- Shortest Path b/w nodes ---------------------------------------- */
            System.out.println("Minimum distances b/w nodes");
            System.out.println("Directed Weighted DataStructures.Graphs.Graph Shortest Distance from a node");
            dirGraphWeighted.shortestPathInDAG(0);
            System.out.println("Directed Weighted DataStructures.Graphs.Graph Dijkstra's Algorithm");
            dirGraphWeighted.dijkstraAlgorithm(0);
            System.out.println("Directed Weighted DataStructures.Graphs.Graph Bellman Ford Algorithm");
            dirGraphWeighted.bellmanFordAlgorithm(0);
            /* ---------------------------------------- Strongly Connected components of graph ---------------------------------------- */
            Graph dirUnweightedStronglyConnectedGraph = new Graph(6);
            dirUnweightedStronglyConnectedGraph.addDirectedEdge(0,1,1);
            dirUnweightedStronglyConnectedGraph.addDirectedEdge(1,2,1);
            dirUnweightedStronglyConnectedGraph.addDirectedEdge(1,5,1);
            dirUnweightedStronglyConnectedGraph.addDirectedEdge(1,3,1);
            dirUnweightedStronglyConnectedGraph.addDirectedEdge(2,0,1);
            dirUnweightedStronglyConnectedGraph.addDirectedEdge(3,4,1);

            Graph dirWeightedStronglyConnectedGraph = new Graph(4);
            dirWeightedStronglyConnectedGraph.addDirectedEdge(0,1,4);
            dirWeightedStronglyConnectedGraph.addDirectedEdge(1,2,3);
            dirWeightedStronglyConnectedGraph.addDirectedEdge(1,3,6);
            dirWeightedStronglyConnectedGraph.addDirectedEdge(3,0,2);

            System.out.println("Strongly connected components of directed graph");
            System.out.println("Directed Unweighted DataStructures.Graphs.Graph Kosaraju Algorithm");
            dirUnweightedStronglyConnectedGraph.kosarajuAlgorithm();
            System.out.println("Directed Weighted DataStructures.Graphs.Graph Kosaraju Algorithm");
            dirWeightedStronglyConnectedGraph.kosarajuAlgorithm();
            System.out.println("Directed Unweighted DataStructures.Graphs.Graph Tarjan's Algorithm");
            dirUnweightedStronglyConnectedGraph.tarjansAlgorithm();
            System.out.println("Directed Weighted DataStructures.Graphs.Graph Tarjan's Algorithm");
            dirWeightedStronglyConnectedGraph.tarjansAlgorithm();

            /* ---------------------------------------- Articulation Points in a DataStructures.Graphs.Graph ---------------------------------------- */
            Graph testGraph = new Graph(6);
            testGraph.addUndirectedEdge(0,1,1);
            testGraph.addUndirectedEdge(0,2,1);
            testGraph.addUndirectedEdge(1,2,1);
            testGraph.addUndirectedEdge(2,3,1);
            testGraph.addUndirectedEdge(4,5,1);
            testGraph.addUndirectedEdge(3,4,1);
            testGraph.addUndirectedEdge(5,2,1);
            System.out.println("DataStructures.Graphs.Graph Articulation Points");
            testGraph.articulationPointFinder();
        }
    }

    public int v;
    public int e;
    public ArrayList<Edge>[] adj;
    public ArrayList<Edge> edgeList;

    public Graph(int v) {
        adj = (ArrayList<Edge>[]) new ArrayList[v];
        edgeList = new ArrayList<>();
        for(int i = 0; i<v; i++)
            adj[i] = new ArrayList<>();
        e = 0;
        this.v = v;
    }

    public void addDirectedEdge(int v, int u, int w) {
        Edge edge = new Edge(v, u, w);
        adj[v].add(edge);
        edgeList.add(edge);
        e++;
    }
    public void addUndirectedEdge(int v, int u, int w) {
        Edge edge = new Edge(v, u, w);
        adj[v].add(edge);
        edgeList.add(edge);
        edge = new Edge(u, v, w);
        adj[u].add(edge);
        edgeList.add(edge);
        e+=2;
    }

    public void deleteEdgeDirected(int v, int u) {
        int index = 0;
        for(Edge edge : adj[v]) {
            if(edge.target == u) {
                adj[v].remove(index);
                break;
            }
            index++;
        }
        index = 0;
        for(Edge edge : edgeList) {
            if(edge.source == v && edge.target == u) {
                edgeList.remove(index);
                e--;
                return;
            }
            index++;
        }
    }
    public void deleteEdgeUndirected(int v, int u) {
        deleteEdgeDirected(v, u);
        deleteEdgeDirected(u, v);
    }

    public boolean checkIfEdgeExists(int s, int t) {
        for(Edge edge : adj[s]) {
            if(edge.target == t)
                return true;
        }
        return false;
    }
    public int checkWeightIfEdgeExists(int s, int t) {
        for(Edge edge : adj[s]) {
            if(edge.target == t)
                return edge.weight;
        }
        return -1;
    }

    public void printEdgeList() {
        System.out.println("Printing EdgeList");
        for(Edge edge : edgeList)
            System.out.println(edge.source + " -> " + edge.target + " [" + edge.weight + "]");
    }
    public void printEdgeList_Once() {
        boolean skip = false;
        System.out.println("Printing EdgeList");
        for(Edge edge : edgeList) {
            if(skip) {
                skip = false;
                continue;
            }
            skip = true;
            System.out.println(edge.source + " -> " + edge.target + " [" + edge.weight + "]");
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
            for(Edge edge : adj[curr]) {
                if(!visited[edge.target]) {
                    visited[edge.target] = true;
                    queue.add(edge.target);
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
            for(Edge edge : adj[curr]) {
                if(!visited[edge.target]) {
                    visited[edge.target] = true;
                    queue.add(edge.target);
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
        for(Edge edge : adj[s]) {
            if(DFS_recursion_search(edge.target, t, visited))
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
            for(Edge edge : adj[current]) {
                if(edge.target == t)
                    return true;
                else if(!visited[edge.target])
                    stack.push(edge.target);
            }
        }
        return false;
    }

    public void DFS_recursion_traversal(int start, boolean[] visited) {
        if(visited[start])
            return;
        System.out.println(start);
        visited[start] = true;
        for(Edge edge : adj[start])
            DFS_recursion_traversal(edge.target, visited);
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
            for(Edge edge : adj[curr]) {
                if(!visited[edge.target]) {
                    stack.push(edge.target);
                    visited[edge.target] = true;
                }
            }
        }
    }

    public boolean DetectCycle_DisjointSets_Undirected() {
        DisjointSets ds = new DisjointSets(v);
        boolean skip = false;
        int f, s;
        for(Edge edge : edgeList) {
            if(skip) {
                skip = false;
                continue;
            }
            skip = true;
            f = ds.find(edge.source);
            s = ds.find(edge.target);
            if(f==s)
                return true;
            ds.union(f, s);
        }
        return false;
    }

    public boolean DetectCycle_DFS_Recursion_Undirected() {
        boolean[] visited = new boolean[v];
        for(int i = 0; i<v; i++)
            if(!visited[i] && DetectCycle_DFS_Recursion_Undirected_Utility(visited, -1, i))
                return true;
        return false;
    }
    public boolean DetectCycle_DFS_Recursion_Undirected_Utility(boolean[] visited, int parent, int current) {
        if(visited[current])
            return true;
        visited[current] = true;
        for(Edge edge : adj[current]) {
            if(!visited[edge.target]) {
                if(DetectCycle_DFS_Recursion_Undirected_Utility(visited, current, edge.target))
                    return true;
            } else if(edge.target != parent)
                return true;
        }
        return false;
    }

    public boolean DetectCycle_DFS_Stack_Undirected() {
        boolean[] visited = new boolean[v];
        for(int i = 0; i<v; i++)
            if(!visited[i] && DetectCycle_DFS_Stack_Undirected_Utility(i, visited))
                return true;
        return false;
    }
    public boolean DetectCycle_DFS_Stack_Undirected_Utility(int s, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> parent = new Stack<>();
        stack.push(s);
        int current, currParent;
        parent.push(-1);
        while(!stack.empty()) {
            current = stack.pop();
            currParent = parent.pop();
            visited[current] = true;
            for(Edge edge : adj[current]) {
                if(!visited[edge.target]) {
                    stack.push(edge.target);
                    parent.push(current);
                } else if(currParent != edge.target)
                    return true;
            }
        }
        return false;
    }

    public boolean DetectCycle_BFS_Undirected() {
        boolean[] visited = new boolean[v];
        for(int i = 0; i<v; i++)
            if(!visited[i] && DetectCycle_BFS_Undirected_Utility(visited))
                return true;
        return false;
    }
    public boolean DetectCycle_BFS_Undirected_Utility(boolean[] visited) {
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> parent = new LinkedList<>();
        int current, currParent;
        queue.add(0);
        parent.add(-1);
        while(!queue.isEmpty()) {
            current = queue.poll();
            currParent = parent.poll();
            visited[current] = true;
            for(Edge edge : adj[current]) {
                if(!visited[edge.target]) {
                    queue.add(edge.target);
                    parent.add(current);
                } else if(currParent != edge.target)
                    return true;
            }
        }
        return false;
    }

    public boolean DetectCycle_DFS_Recursion_Directed() {
        boolean[] visited = new boolean[v];
        for(int i = 0; i<v; i++)
            if(DetectCycle_DFS_Recursion_Directed_Utility(visited, i))
                return true;
        return false;
    }
    public boolean DetectCycle_DFS_Recursion_Directed_Utility(boolean[] visited, int current) {
        if(visited[current])
            return true;
        visited[current] = true;
        for(Edge edge : adj[current]) {
            if(!visited[edge.target])
                if(DetectCycle_DFS_Recursion_Directed_Utility(visited, edge.target))
                    return true;
                else if(visited[edge.target])
                    return true;
        }
        visited[current] = false;
        return false;
    }

    public boolean DetectCycle_DFS_Stack_Directed() {
        Stack<Integer> stack = new Stack<>();
        int[] indegree = new int[v];
        int current, counter = 0;
        for(List<Edge> list : adj)
            for(Edge edge : list)
                indegree[edge.target]++;
        for(int i = 0; i<v; i++)
            if(indegree[i] == 0)
                stack.push(i);
        while(!stack.isEmpty()) {
            current = stack.pop();
            counter++;
            for(Edge edge : adj[current]) {
                indegree[edge.target]--;
                if(indegree[edge.target] == 0)
                    stack.push(edge.target);
            }
        }
        return counter != v;
    }

    public boolean DetectCycle_BFS_Directed() {
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[v];
        int current, counter = 0;
        for(List<Edge> list : adj)
            for(Edge edge : list)
                indegree[edge.target]++;
        for(int i = 0; i<v; i++)
            if(indegree[i] == 0)
                queue.add(i);
        while(!queue.isEmpty()) {
            current = queue.poll();
            counter++;
            for(Edge edge : adj[current]) {
                indegree[edge.target]--;
                if(indegree[edge.target] == 0)
                    queue.add(edge.target);
            }
        }
        return counter != v;
    }


    // KAHN's ALGORITHM
    public int[] topologicalSorting_BFS() {
        int[] order = new int[v];
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[v];
        int current, index = 0;
        for(List<Edge> list : adj)
            for(Edge edge : list)
                indegree[edge.target]++;
        for(int i = 0; i<v; i++)
            if(indegree[i] == 0)
                queue.add(i);
        while(!queue.isEmpty()) {
            current = queue.poll();
            for(Edge edge : adj[current]) {
                indegree[edge.target]--;
                if(indegree[edge.target] == 0)
                    queue.add(edge.target);
            }
            order[index] = current;
            index++;
        }
        for(int i : order)
            System.out.print(i + " -> ");
        System.out.print("DONE!!\n");
        return order;
    }
    public int[] topologicalSorting_DFS_KhansAlgo() {
        Stack<Integer> stack = new Stack<>();
        int[] order = new int[v];
        int[] indegree = new int[v];
        int current, index = 0;
        for(List<Edge> list : adj)
            for(Edge edge : list)
                indegree[edge.target]++;
        for(int i = 0; i<v; i++)
            if(indegree[i] == 0)
                stack.push(i);
        while(!stack.isEmpty()) {
            current = stack.pop();
            for(Edge edge : adj[current]) {
                indegree[edge.target]--;
                if(indegree[edge.target] == 0)
                    stack.push(edge.target);
            }
            order[index] = current;
            index++;
        }
        for(int i : order)
            System.out.print(i + " -> ");
        System.out.print("DONE!!\n");
        return order;
    }

    public int[] topologicalSort_DFS() {
        int[] order = new int[v];
        boolean[] visited = new boolean[v];
        Stack<Integer> topoSort = new Stack<>();
        for(int i = 0; i<v; i++)
            if(!visited[i])
                topologicalSort_DFS_Utility(i, visited, topoSort);
        int i = 0;
        while(!topoSort.isEmpty()) {
            order[i] = topoSort.pop();
            System.out.print(order[i++] + " -> ");
        }
        System.out.print("DONE!!\n");
        return order;
    }
    public void topologicalSort_DFS_Utility(int current, boolean[] visited, Stack<Integer> stack) {
        visited[current] = true;
        for(Edge edge : adj[current])
            if(!visited[edge.target])
                topologicalSort_DFS_Utility(edge.target, visited, stack);
        stack.push(current);
    }

    // Shortest Distance in a DAG :
    // We use topological sort for this approach
    public int[] shortestPathInDAG(int start) {
        int[] pathCounter = new int[v];
        Arrays.fill(pathCounter, 999999);
        int[] order = topologicalSorting_BFS();
        pathCounter[start] = 0;
        for(int i : order)
            for(Edge edge : adj[i])
                pathCounter[edge.target] = Math.min(pathCounter[edge.target], pathCounter[i] + edge.weight);
        for(int i : pathCounter)
            System.out.print(i + " ");
        System.out.println();
        return pathCounter;

    }

    // PRIMS ALGORITHM ----------
    public int PrimsAlgo() {
        int weightSum = 0;
        int[] value = new int[v];
        boolean[] setMST = new boolean[v];
        int[] parent = new int[v];
        Arrays.fill(value, 999999);
        value[0] = 0;
        parent[0] = -1;
        int counter = 0, current;
        while(counter < v) {
            counter++;
            current = selectMinNode(value, setMST);
            setMST[current] = true;
            for(Edge edge : adj[current]) {
                if(!setMST[edge.target] && edge.weight < value[edge.target]) {
                    value[edge.target] = edge.weight;
                    parent[edge.target] = current;
                }
            }
        }
        for(int i = 1; i<v; i++) {
            weightSum += value[i];
            System.out.println(parent[i] + " -> " + i + " [" + checkWeightIfEdgeExists(parent[i], i) + "]");
        }
        return weightSum;
    }
    public int selectMinNode(int[] value, boolean[] finalized) {
        int min = Integer.MAX_VALUE, index = 0;
        for(int i = 0; i<v ; i++) {
            if(!finalized[i] && min > value[i]) {
                index = i;
                min = value[i];
            }
        }
        return index;
    }
    // KRUSKAL's ALGORITHM ----------
    public int KruskalAlgo() {
        int weightedSum = 0, index = 0, f, t;
        ArrayList<Edge> sortedEdgeList = new ArrayList<>();
        Graph mst = new Graph(v);
        for(Edge e : this.edgeList)
            sortedEdgeList.add(new Edge(e));
        DisjointSets ds = new DisjointSets(v);
        sortedEdgeList.sort(new GraphComparatorBasedOnWeight());
        for(Edge edge : sortedEdgeList) {
            if(index == v)
                break;
            f = ds.find(edge.source);
            t = ds.find(edge.target);
            if(f == t)
                continue;
            index++;
            ds.union(f, t);
            mst.addUndirectedEdge(edge.source, edge.target, edge.weight);
            weightedSum += edge.weight;
        }
        mst.printEdgeList_Once();
        return weightedSum;
    }
    // DIJKSTRA's ALGORITHM ----------
    public int[] dijkstraAlgorithm(int start) {
        boolean[] finalized = new boolean[v];
        int[] distance = new int[v];
        Arrays.fill(distance, 999999);
        distance[start] = 0;
        int current, counter = 0;
        while(counter <  v) {
            counter++;
            current = selectMinNode(distance, finalized);
            finalized[current] = true;
            for(Edge edge : adj[current])
                distance[edge.target] = Math.min(distance[edge.target], distance[current]+edge.weight);
        }
        for(int i : distance)
            System.out.print(i + " ");
        System.out.println();
        return distance;
    }
    // BELLMAN FORD ALGORITHM ----------
    public int[] bellmanFordAlgorithm(int start) {
        int[] distance = new int[v];
        Arrays.fill(distance, 999999);
        distance[start] = 0;
        for(int i = 0; i<v-1; i++)
            for(Edge edge : edgeList)
                distance[edge.target] = Math.min(distance[edge.target], distance[edge.source] + edge.weight);
        // Handling -ve weight cycles.
        for(Edge edge : edgeList)
            if(distance[edge.target] > distance[edge.source] + edge.weight)
                System.out.println("Negative Weight Cycle Detected");
        for(int i : distance)
            System.out.print(i + " ");
        System.out.println();
        return distance;
    }
    // KOSARAJU's ALGORITHM
    public ArrayList<List<Integer>> kosarajuAlgorithm() {
        ArrayList<Integer> finishTime = new ArrayList<>();
        ArrayList<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[v];
        for(int i = 0; i<v; i++)
            if(!visited[i])
                finishTimeOrder(i, visited, finishTime);
        Graph transposeGraph = getTransposeOfGraph();
        Arrays.fill(visited, false);
        Collections.reverse(finishTime);
        for(int current : finishTime) {
            if(!visited[current]) {
                ArrayList<Integer> list = new ArrayList<>();
                kosarajuAlgorithmUtility(list, transposeGraph, current, visited);
                ans.add(list);
            }
        }
        for(List<Integer> list : ans) {
            for (int i : list)
                System.out.print(i + " ");
            System.out.println();
        }
        return ans;
    }
    public void kosarajuAlgorithmUtility(List<Integer> list, Graph transposeGraph, int current, boolean[] visited) {
        visited[current] = true;
        list.add(current);
        for(Edge edge : transposeGraph.adj[current])
            if(!visited[edge.target])
                kosarajuAlgorithmUtility(list, transposeGraph, edge.target, visited);
    }
    public Graph getTransposeOfGraph() {
        Graph reverseGraph = new Graph(v);
        for(Edge edge : edgeList)
            reverseGraph.addDirectedEdge(edge.target, edge.source, edge.weight);
        return reverseGraph;
    }
    public void finishTimeOrder(int current, boolean[] visited, ArrayList<Integer> finishTime) {
        for(Edge edge : adj[current])
            if(!visited[edge.target]) {
                visited[edge.target] = true;
                finishTimeOrder(edge.target, visited, finishTime);
            }
        finishTime.add(current);
    }
    // Finding strongly connected algorithms in a directed graph
    public ArrayList<List<Integer>> tarjansAlgorithm() {
        boolean[] visited = new boolean[v];
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int[] discoveryTimes = new int[v];
        int[] lowTimes = new int[v];
        boolean[] presentInStack = new boolean[v];
        Integer time = 1;
        for(int i = 0; i<v; i++)
            if(!visited[i])
                tarjansAlgorithmUtility(-1, ans, time, i, discoveryTimes, lowTimes, stack, visited, presentInStack);
        for(List<Integer> list: ans) {
            for(int i : list)
                System.out.print(i + " ");
            System.out.println();
        }
        return ans;
    }
    public void tarjansAlgorithmUtility(int parent, ArrayList<List<Integer>> ans, Integer time, int current, int[] discoveryTimes, int[] lowTimes, Stack<Integer> stack, boolean[] visited, boolean[] presentInStack) {
        discoveryTimes[current] = time;
        lowTimes[current] = time;
        stack.push(current);
        presentInStack[current] = true;
        visited[current] = true;
        time++;
        for(Edge edge : adj[current]) {
            if(edge.target == parent)
                continue;
            if(!visited[edge.target]) {
                tarjansAlgorithmUtility(current, ans, time, edge.target, discoveryTimes, lowTimes, stack, visited, presentInStack);
                lowTimes[current] = Math.min(lowTimes[current], lowTimes[edge.target]);
            } else if(presentInStack[edge.target])
                lowTimes[current] = Math.min(lowTimes[current], discoveryTimes[edge.target]);
        }
        if(lowTimes[current] == discoveryTimes[current]) {
            ArrayList<Integer> list = new ArrayList<>();
            while(stack.peek() != current) {
                presentInStack[stack.peek()] = false;
                list.add(stack.pop());
            }
            presentInStack[stack.peek()] = false;
            list.add(stack.pop());
            ans.add(list);
        }
    }
    public ArrayList<Integer> articulationPointFinder() {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<int[]> bridges = new ArrayList<>();
        Integer time = 1;
        int[] discoveryTimes = new int[v];
        int[] lowTimes = new int[v];
        int[] children = new int[v];
        boolean[] visited = new boolean[v];
        for(int i = 0; i<v; i++)
            if(!visited[i])
                articulationPointFinderUtility(list, bridges, -1, children, time, 0, visited, discoveryTimes, lowTimes);
        if(children[0] > 1)
            list.add(0);
        if(list.size() == 0)
            System.out.print("No Articulation Points Found.");
        else
            for(int i : list)
                System.out.print(i + " ");
        System.out.println();
        return list;
    }
    public void articulationPointFinderUtility(ArrayList<Integer> list, ArrayList<int[]> bridges, int parent, int[] children, Integer time, int current, boolean[] visited, int[] discoveryTimes, int[] lowTimes) {
        discoveryTimes[current] = time;
        lowTimes[current] = time;
        visited[current] = true;
        time++;
        for(Edge edge : adj[current]) {
            if(edge.target == parent)
                continue;
            if(!visited[edge.target]) {
                articulationPointFinderUtility(list ,bridges, current, children, time, edge.target, visited, discoveryTimes, lowTimes);
                lowTimes[current] = Math.min(lowTimes[current], lowTimes[edge.target]);
                children[current]++;
            } else
                lowTimes[current] = Math.min(lowTimes[current], discoveryTimes[edge.target]);
            if(lowTimes[edge.target] >= discoveryTimes[current] && parent != -1) {
                list.add(current);
                if(lowTimes[edge.target] > discoveryTimes[current])
                    bridges.add(new int[]{current, edge.target});
                break;
            }
        }
    }
    public int discoveryTimes( int current, int time, int[] discoveryTimes, boolean[] visited, int[] children) {
        discoveryTimes[current] = time;
        visited[current] = true;
        int counter = 0;
        for(Edge edge : adj[current])
            if(!visited[edge.target]) {
                counter++;
//                children[current]++;
                time = discoveryTimes(edge.target, time+1, discoveryTimes, visited, children);
            }
        children[current] = counter;
        return time;
    }
    public int lowValues(int current, boolean[] visited, int[] lowTimes, int[] discoveryTimes, int parent, ArrayList<Integer> list, ArrayList<int[]> bridges) {
        visited[current] = true;
        lowTimes[current] = discoveryTimes[current];
        for(Edge edge : adj[current]) {
            if(edge.target == parent)
                continue;
            if(visited[edge.target])
                lowTimes[current] = Math.min(lowTimes[current], discoveryTimes[edge.target]);
            else
                lowTimes[current] = Math.min(lowTimes[current], lowValues(edge.target, visited, lowTimes, discoveryTimes, current, list, bridges));
            if(lowTimes[edge.target] >= discoveryTimes[current] && parent != -1) {
                list.add(current);
                if(lowTimes[edge.target] > discoveryTimes[current])
                    bridges.add(new int[]{current, edge.target});
                break;
            }
        }
        return lowTimes[current];
    }
}
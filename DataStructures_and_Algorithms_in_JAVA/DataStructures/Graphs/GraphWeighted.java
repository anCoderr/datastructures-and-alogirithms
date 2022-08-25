package DataStructures.Graphs;

import DataStructures.DisjointSets.DisjointSets;
import java.util.ArrayList;
import java.util.Arrays;


class GraphWeighted {

    // Runner Class
    static class Runner {
        public static void main(String[] args) {
            GraphWeighted dirGraphWeighted = new GraphWeighted(6);
            GraphWeighted undirGraphWeighted = new GraphWeighted(6);

            undirGraphWeighted.addUndirected(0, 1, 4);
            undirGraphWeighted.addUndirected(0, 2, 2);
            undirGraphWeighted.addUndirected(1, 3, 6);
            undirGraphWeighted.addUndirected(2, 5, 2);
            undirGraphWeighted.addUndirected(3, 5, 4);
            undirGraphWeighted.addUndirected(4, 3, 3);
            undirGraphWeighted.addUndirected(5, 4, 1);

            dirGraphWeighted.addUndirected(0, 1, 4);
            dirGraphWeighted.addUndirected(0, 2, 2);
            dirGraphWeighted.addUndirected(1, 3, 6);
            dirGraphWeighted.addUndirected(2, 5, 2);
            dirGraphWeighted.addUndirected(3, 4, 3);
            dirGraphWeighted.addUndirected(3, 5, 4);
            dirGraphWeighted.addUndirected(4, 5, 1);

            System.out.println("Prims Algo Started");
            System.out.println(undirGraphWeighted.PrimsAlgo());
            System.out.println("Kruskal's Algorithm Started");
            System.out.println(undirGraphWeighted.KruskalsAlgo());
        }
    }

    public int v;
    public ArrayList<Edge>[] adj;
    public ArrayList<Edge> edgeList;

    public GraphWeighted(int v) {
        adj = new ArrayList[v];
        edgeList = new ArrayList<>();
        for(int i = 0; i<v; i++) {
            adj[i] = new ArrayList<>();
        }
        this.v = v;
    }

    public void addDirected(int v, int u, int w) {
        Edge e = new Edge(v, u, w);
        adj[v].add(e);
        edgeList.add(e);
    }
    public void addUndirected(int v, int u, int w) {
        Edge e = new Edge(v, u, w);
        adj[v].add(e);
        edgeList.add(e);
        e = new Edge(u, v, w);
        adj[u].add(e);
        edgeList.add(e);
    }
    public boolean checkIfEdgeExists(int s, int t) {
        for(Edge e : adj[s]) {
            if(e.target == t)
                return true;
        }
        return false;
    }
    public int checkWeightIfEdgeExists(int s, int t) {
        for(Edge e : adj[s]) {
            if(e.target == t)
                return e.weight;
        }
        return -1;
    }

    public void printEdgeList() {
        System.out.println("Printing EdgeList");
        for(Edge e : edgeList)
            System.out.println(e.source + "->" + e.target + " [" + e.weight + "]");
    }

    public boolean DetectCycle_DisjointSets() {
        DisjointSets ds = new DisjointSets(v);
        int f, s;
        for(Edge e : edgeList) {
            f = ds.find(e.source);
            s = ds.find(e.target);
            if(f==s)
                return true;
            ds.union(f, s);
        }
        return false;
    }

    // Implementation Of Prims Algorithm ----------

    public int PrimsAlgo() {
        int weightSum = 0;
        int[] value = new int[v];
        boolean[] setMST = new boolean[v];
        int[] parent = new int[v];
        Arrays.fill(value, Integer.MAX_VALUE);
        value[0] = 0;
        parent[0] = -1;
        for(int i = 0; i<v-1; i++) {
            int current = selectMinNode(value, setMST, v);
            setMST[current] = true;
            for(int j = 0; j<v; j++) {
                if(checkIfEdgeExists(current, j) && !setMST[j] && checkWeightIfEdgeExists(current, j) < value[j]) {
                    value[j] = checkWeightIfEdgeExists(current, j);
                    parent[j] = current;
                }
            }
        }
        for(int i : value)
            weightSum += i;
        for(int i = 1; i<v; i++)
            System.out.println(parent[i] + " -> " + i);
        return weightSum;
    }
    public int selectMinNode(int[] value, boolean[] setMST, int size) {
        int min = 999999, index = 0;
        for(int i = 0; i<size ; i++) {
            if(min > value[i] && !setMST[i]) {
                index = i;
                min = value[i];
            }
        }
        return index;
    }
    // Implementation Of Kruskal's Algorithm ----------
    public int KruskalsAlgo() {
        int weightedSum = 0, index = 0, f, t;
        ArrayList<Edge> sortedEdgeList = new ArrayList<>();
        GraphWeighted mst = new GraphWeighted(v);
        for(Edge e : this.edgeList)
            sortedEdgeList.add(new Edge(e));
        DisjointSets ds = new DisjointSets(v);
        sortedEdgeList.sort(new GraphComparatorBasedOnWeight());
        for(Edge e : sortedEdgeList) {
            if(index == v)
                break;
            f = ds.find(e.source);
            t = ds.find(e.target);
            if(f == t) {
                continue;
            }
            index++;
            ds.union(f, t);
            mst.addUndirected(e.source, e.target, e.weight);
            weightedSum += e.weight;
        }
        for(Edge e : mst.edgeList) {
            System.out.println(e.source + " -> " + e.target + " [" + e.weight + "]");
        }
        return weightedSum;
    }
}

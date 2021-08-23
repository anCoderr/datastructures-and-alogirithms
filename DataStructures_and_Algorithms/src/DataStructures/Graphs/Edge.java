package DataStructures.Graphs;

public class Edge {
    public int source, target, weight;
    public Edge(int source, int target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }
    public Edge(Edge e) {
        this.source = e.source;
        this.target = e.target;
        this.weight = e.weight;
    }
}
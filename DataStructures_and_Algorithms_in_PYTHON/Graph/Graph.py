from Edge import Edge
from collections import deque
from DataStructures_and_Algorithms_in_PYTHON.DisjointSets.disjoint_sets import DisjointSets


class Graph():
    def __init__(self, v):
        self.v = v
        self.adj = [[] for _ in range(v)]
        self.edge_list = []

    def add_directed_edge(self, source, target, weight=1):
        e1 = Edge(source, target, weight)
        self.adj[source].append(e1)
        self.edge_list.append(e1)

    def add_undirected_edge(self, source, target, weight=1):
        e1 = Edge(source, target, weight)
        e2 = Edge(target, source, weight)
        self.adj[source].append(e1)
        self.adj[target].append(e2)
        self.edge_list.append(e1)
        self.edge_list.append(e2)

    def print_edge_list(self):
        for i in range(self.v):
            arr = [f'{edge.target}[{edge.weight}] ' for edge in self.adj[i]]
            print(f'{i}: ' + ''.join(arr))

    def detect_cycle_disjoint_sets_undirected(self):
        ds = DisjointSets(self.v)
        skip = False
        for edge in self.edge_list:
            if skip:
                skip = False
                continue
            skip = True
            f = ds.find(edge.source)
            s = ds.find(edge.target)
            if f == s:
                return True
            ds.union(f, s)

        return False

    def topological_sorting_BFS(self):
        order = []
        queue = deque()
        indegree = [0] * self.v
        for arr in self.adj:
            for edge in arr:
                indegree[edge.target] += 1
        for i in range(self.v):
            if indegree[i] == 0:
                queue.append(i)
        while queue:
            current = queue.popleft()
            for edge in self.adj[current]:
                indegree[edge.target] -= 1
                if indegree[edge.target] == 0:
                    queue.append(edge.target)
            order.append(current)
        if len(order) != self.v:
            print('The given graph is not a Directed Acyclic Graph (DAG)')
        else:
            for i in order:
                print(i, end='->')
            print('Done!')
        return order


graph = Graph(6)
graph.add_directed_edge(3, 0)
graph.add_directed_edge(4, 0)
graph.add_directed_edge(5, 1)
graph.add_directed_edge(0, 1)
graph.add_directed_edge(5, 2)
graph.add_directed_edge(1, 2)
graph.add_directed_edge(0, 2)
graph.print_edge_list()
# print(graph.topological_sorting_BFS())

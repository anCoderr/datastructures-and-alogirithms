from typing import List
from heapq import *
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

    def select_mid_weight_node(self, values: List[int], finalized: List[bool]):
        min_weight = float('inf')
        node = 0
        for j in range(self.v):
            if not finalized[j] and min_weight > values[j]:
                min_weight = values[j]
                node = j
        return node

    def prims_algorithm(self):
        node_weights = [float('inf')] * self.v
        setMST = [False] * self.v
        parent = [-1] * self.v
        node_weights[0] = 0
        for _ in range(self.v):
            current = self.select_mid_weight_node(node_weights, setMST)
            setMST[current] = True
            for edge in self.adj[current]:
                if not setMST[edge.target] and edge.weight < node_weights[edge.target]:
                    node_weights[edge.target] = edge.weight
                    parent[edge.target] = current
        for i in range(1, self.v):
            print(f'{parent[i]} -> {i}')
        return sum(node_weights)

    def prims_algorithm_optimized(self):
        node_heap = [(0, 0, -1)]
        mst_cost = 0
        setMST = [False] * self.v
        parent = [-1] * self.v
        edge_used = 0
        while edge_used < self.v:
            curr_weight, curr_node, curr_parent = heappop(node_heap)
            if setMST[curr_node]:
                continue
            setMST[curr_node] = True
            mst_cost += curr_weight
            parent[curr_node] = curr_parent
            edge_used += 1
            for edge in self.adj[curr_node]:
                if not setMST[edge.target]:
                    heappush(node_heap, (edge.weight, edge.target, curr_node))
        for i in range(1, self.v):
            print(f'{parent[i]} -> {i}')
        return mst_cost

    def kruskals_algorithm(self):
        sorted_edge_list = sorted(self.edge_list, key=lambda edge: edge.weight)
        # Since undirected edges exist in pairs sorted edge list contains same adjacent values
        sorted_edge_list = sorted_edge_list[::2]
        setMST = []
        ds = DisjointSets(self.v)
        for edge in sorted_edge_list:
            if len(setMST) >= self.v - 1:
                break
            source = ds.find(edge.source)
            target = ds.find(edge.target)
            if source == target:
                continue
            ds.union(source, target)
            setMST.append(edge)
        edge_weight = 0
        for mst_edge in setMST:
            print(f'{mst_edge.source} --[{mst_edge.weight}]--> {mst_edge.target}')
            edge_weight += mst_edge.weight
        return edge_weight

    def dijkstras_algorithm(self, start: int):
        node_weights = [float('inf')] * self.v
        finalized = [False] * self.v
        node_weights[start] = 0
        for _ in range(self.v):
            current = self.select_mid_weight_node(node_weights, finalized)
            finalized[current] = True
            for edge in self.adj[current]:
                node_weights[edge.target] = min(node_weights[edge.target], node_weights[current] + edge.weight)
        return node_weights

    def bellman_fords_algorithm(self, start: int):
        node_weights = [float('inf')] * self.v
        node_weights[start] = 0
        for _ in range(self.v - 1):
            for edge in self.edge_list:
                node_weights[edge.target] = min(node_weights[edge.target], node_weights[edge.source] + edge.weight)
        for edge in self.edge_list:
            # If Shortest Path still decreases then we have a -ve edge weight cycle.
            if node_weights[edge.target] > node_weights[edge.source] + edge.weight:
                print('Negative Edge Weight Cycle Detected!')
                break
        return node_weights

    def discovery_times(self):
        discovery_times = [float('inf')] * self.v
        self.discovery_times_utility(0, 1, discovery_times, [False] * self.v, [0] * self.v)
        return discovery_times

    def discovery_times_utility(self, current: int, time: int, discovery_times: List[int], visited: List[bool],
                                children: List[int]):
        discovery_times[current] = time
        visited[current] = True
        count = 0
        for edge in self.adj[current]:
            if not visited[edge.target]:
                count += 1
                children[current] += 1
                time = self.discovery_times_utility(edge.target, time + 1, discovery_times, visited, children)
        children[current] = count
        return time

    def low_values(self):
        low_times = [float('inf')] * self.v
        discovery_times = self.discovery_times()
        self.low_values_utility(0, [False] * self.v, low_times, discovery_times, -1)
        return low_times

    def low_values_utility(self, current: int, visited: List[bool], low_times: List[int], discovery_times: List[int],
                           parent: int):
        visited[current] = True
        low_times[current] = discovery_times[current]
        for edge in self.adj[current]:
            if edge.target == parent:
                continue
            if visited[edge.target]:
                low_times[current] = min(low_times[current], discovery_times[edge.target])
            else:
                low_times[current] = min(low_times[current],
                                         self.low_values_utility(edge.target, visited, low_times, discovery_times,
                                                                 current))
        return low_times[current]

    def bridge_check(self):
        low_times = self.low_values()
        discovery_times = self.discovery_times()
        bridges = []
        for edge in self.edge_list:
            if discovery_times[edge.source] < low_times[edge.target]:
                bridges.append((edge.source, edge.target))
        return bridges


# directed_graph_unweighted = Graph(6)
# directed_graph_unweighted.add_directed_edge(3, 0)
# directed_graph_unweighted.add_directed_edge(4, 0)
# directed_graph_unweighted.add_directed_edge(5, 1)
# directed_graph_unweighted.add_directed_edge(0, 1)
# directed_graph_unweighted.add_directed_edge(5, 2)
# directed_graph_unweighted.add_directed_edge(1, 2)
# directed_graph_unweighted.add_directed_edge(0, 2)
# directed_graph_unweighted.print_edge_list()
# print(directed_graph_unweighted.topological_sorting_BFS())

undirected_graph_weighted = Graph(6)
undirected_graph_weighted.add_undirected_edge(0, 1, 4)
undirected_graph_weighted.add_undirected_edge(0, 2, 6)
undirected_graph_weighted.add_undirected_edge(1, 4, 4)
undirected_graph_weighted.add_undirected_edge(1, 3, 3)
undirected_graph_weighted.add_undirected_edge(2, 1, 6)
undirected_graph_weighted.add_undirected_edge(2, 3, 1)
undirected_graph_weighted.add_undirected_edge(3, 4, 2)
undirected_graph_weighted.add_undirected_edge(3, 5, 3)
undirected_graph_weighted.add_undirected_edge(4, 5, 7)
print(undirected_graph_weighted.prims_algorithm())
print(undirected_graph_weighted.prims_algorithm_optimized())
print(undirected_graph_weighted.kruskals_algorithm())
# print(undirected_graph_weighted.dijkstras_algorithm(0))
# print(undirected_graph_weighted.bellman_fords_algorithm(0))

# directed_graph_weighted = Graph(6)
# directed_graph_weighted.add_directed_edge(0, 1, 4)
# directed_graph_weighted.add_directed_edge(0, 2, 6)
# directed_graph_weighted.add_directed_edge(1, 4, 4)
# directed_graph_weighted.add_directed_edge(1, 3, 3)
# directed_graph_weighted.add_directed_edge(2, 1, 6)
# directed_graph_weighted.add_directed_edge(3, 2, 1)
# directed_graph_weighted.add_directed_edge(3, 4, 2)
# directed_graph_weighted.add_directed_edge(5, 3, 3)
# directed_graph_weighted.add_directed_edge(4, 5, 7)
# print(directed_graph_weighted.dijkstras_algorithm(0))
# print(directed_graph_weighted.bellman_fords_algorithm(0))

# undirected_graph_unweighted = Graph(5)
# undirected_graph_unweighted.add_undirected_edge(0, 1)
# undirected_graph_unweighted.add_undirected_edge(0, 2)
# undirected_graph_unweighted.add_undirected_edge(0, 3)
# undirected_graph_unweighted.add_undirected_edge(1, 2)
# undirected_graph_unweighted.add_undirected_edge(3, 4)
# print(undirected_graph_unweighted.discovery_times())
# print(undirected_graph_unweighted.low_values())
# print(undirected_graph_unweighted.bridge_check())
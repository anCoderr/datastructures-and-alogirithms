class Edge:

    def __init__(self, source, target, weight=1):
        self.source = source
        self.target = target
        self.weight = weight


def create_edge_from_edge(edge: Edge):
    return Edge(edge.source, edge.target, edge.weight)

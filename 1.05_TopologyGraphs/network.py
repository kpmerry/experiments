import networkx as nx
import matplotlib.pyplot as plt

EDGES = [
    (1, 4),
    (4, 9),
    (9, 11),
    (11, 14),
    (14, 18),
    (18, 20),
    (20, 21),
    (21, 28),
    (28, 1),
    (1, 9),
    (1, 18),
    (4, 20),
    (9, 14),
    (9, 18),
    (9, 28),
    (11, 28),
    (11, 20),
    (11, 28),
    (14, 28),
    (14, 1),
    (18, 28),
    (18, 4),
    (20, 28),
    (20, 4),
    (21, 1),
    (21, 9),
    (28, 14),
    (28, 4),
]
NODES = [1, 4, 9, 11, 14, 18, 20, 21, 28]
NEW_EDGES = [
    (20, 11),
    (20, 18),
    (18, 11),
    (18, 21),
    (4, 1),
    (11, 9),
    (1, 21),
    (14, 11),
    (21, 20),
]


def find_path(G, s, t):
    """Find shortest path from vertex s to vertex t."""
    try:
        return nx.shortest_path(G, source=s, target=t)
    except nx.NetworkXNoPath:
        return None


def draw_graph(G):
    """Draw the graph and save it as a high-resolution image."""
    pos = nx.spring_layout(G, seed=42)
    plt.figure(figsize=(8, 6))
    nx.draw(
        G,
        pos,
        with_labels=True,
        node_color="lightblue",
        edge_color="gray",
        node_size=2000,
        font_size=12,
    )
    plt.savefig("mygraph_4.png", dpi=300)
    plt.show()


def create_digraph():
    """Create a directed graph with predefined nodes and edges."""
    G = nx.DiGraph()
    G.add_nodes_from(NODES)
    G.add_edges_from(EDGES)
    return G


def longest_path(G, NODES):
    """Find the longest shortest path in the graph."""
    max_len = 0
    max_path = []
    a, b = None, None

    for x in NODES:
        for y in NODES:
            if x == y:
                continue
            try:
                path = find_path(G, x, y)
                if path and len(path) > max_len:
                    max_len = len(path)
                    max_path = path
                    a, b = x, y
            except nx.NetworkXNoPath:
                continue

    return max_path, a, b


def main():
    """Main function to run graph operations."""
    G = create_digraph()

    longest = longest_path(G, NODES)
    print(f"Longest shortest path: {longest}")

    start, end = 18, 21
    print(f"Initial {start}-{end} path:", find_path(G, start, end))

    def add_edges(edges):
        for edge in edges:
            e1, e2 = edge  # Define search nodes.
            G.add_edge(e1, e2)
            print(f"Edge ({e1}, {e2}) added.")

    add_edges(NEW_EDGES)

    print(f"New {start}-{end} path:", find_path(G, start, end))

    longest = longest_path(G, NODES)
    print(f"Longest shortest path: {longest}")


if __name__ == "__main__":
    main()

public class DetectCycle {
    private Map<Integer, List<Integer>> adj = new HashMap<>();
    private boolean directed;

    public Graph(boolean directed) {
        this.directed = directed;
    }

    public void addEdge(int src, int dest) {
        adj.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
        if (!directed) {
            adj.computeIfAbsent(dest, k -> new ArrayList<>()).add(src);
        }
    }
    // Detect cycle using DFS for directed graph
    public boolean hasCycleDirected() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();

        for (int node : adj.keySet()) {
            if (dfsCycle(node, visited, recStack)) {
                return true; // cycle detected
            }
        }
        return false;
    }

    private boolean dfsCycle(int node, Set<Integer> visited, Set<Integer> recStack) {
        if (recStack.contains(node)) return true;  // back edge -> cycle
        if (visited.contains(node)) return false;  // already processed

        visited.add(node);
        recStack.add(node);

        for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
            if (dfsCycle(neighbor, visited, recStack)) return true;
        }

        recStack.remove(node);
        return false;
    }
}

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
}

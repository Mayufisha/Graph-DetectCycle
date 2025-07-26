public class DetectCycleTest {
    public static void main(String[] args) {
        System.out.println(" Directed Graph Test ");
        DetectCycle directedGraph = new DetectCycle(true);
        directedGraph.addEdge(0, 1);
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(2, 3);
        directedGraph.addEdge(3, 1); // cycle

        System.out.println("Cycle detected (should be true): " + directedGraph.hasCycleDirected());

        System.out.println("\n Directed Acyclic Graph (DAG) Test ");
        DetectCycle dag = new DetectCycle(true);
        dag.addEdge(0, 1);
        dag.addEdge(1, 2);
        dag.addEdge(2, 3);

        System.out.println("Cycle detected (should be false): " + dag.hasCycleDirected());
    }
}

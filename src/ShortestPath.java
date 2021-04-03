public interface ShortestPath {
    int INF = Integer.MAX_VALUE;

    int[] ShortestPath(int[][] G, int s);
    int getEdgeCount(int[][] G);
    void printDistance(int[] D, int s);
}

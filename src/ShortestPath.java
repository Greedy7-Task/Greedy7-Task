public interface ShortestPath {
    int INF = Integer.MAX_VALUE;

    int[] find_ShortestPath(int[][] G, int s);
    int[] init(int v, int s);
    void printDistance(int[] D, int s);
}

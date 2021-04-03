import java.util.Arrays;

public class Dijkstra implements ShortestPath {
    @Override
    public int[] ShortestPath(int[][] G, int s) {
        int vertex = G.length;
        int edge = getEdgeCount(G);
        int[] D = new int[vertex];
        Arrays.fill(D, INF);
        D[s] = 0;


        return D;
    }

    public int getEdgeCount(int[][] G) {
        int edge = 0;
        for (int i = 0; i < G.length; i++)
            if (G[0][i] != 0)
                edge++;
        return edge;
    }

    public void printDistance(int[] D, int s) {
        System.out.printf("정점 %d부터의 거리", s);
        System.out.println();
        for (int i : D)
            if (i != s) {
                System.out.printf("%d번 점: %d", i, D[i]);
                System.out.println();
            }
    }
}

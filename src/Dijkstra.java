import java.util.Arrays;

public class Dijkstra implements ShortestPath {
    @Override
    public int[] find_ShortestPath(int[][] G, int s) {
        int vertex = G.length;
        int edge = getEdgeCount(G);
        int[] D = init(vertex, s);


        return D;
    }

    public int[] init(int v, int s) {
        int[] distance_array = new int[v];
        Arrays.fill(distance_array, INF);
        distance_array[s] = 0;
        return distance_array;
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

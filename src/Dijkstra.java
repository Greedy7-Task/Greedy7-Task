import java.util.Arrays;

public class Dijkstra implements ShortestPath {
    @Override
    public int[] find_ShortestPath(int[][] G, int s) {
        int vertex = G.length;
        int[] D = init(vertex, s);
        int[] P = init(vertex, s);
        P[s] = s;
        boolean[] visited = new boolean[vertex];

        while (true) {
            int min = INF;
            int min_Index = -1;

            for (int a = 0; a < vertex; a++)
                if (!visited[a] && min > D[a] && D[a] != INF) {
                    min_Index = a;
                    min = D[a];
                }
            if (min_Index == -1)
                break;
            visited[min_Index] = true;

            for (int i = 0; i < vertex; i++) {
                if (G[min_Index][i] == INF)
                    continue;
                if (visited[i])
                    continue;
                int temp_distance = D[min_Index] + G[i][min_Index];
                if (temp_distance < D[i]) {
                    D[i] = temp_distance;
                    P[i] = min_Index;
                }
            }
        }
        return D;
    }

    public int[] init(int v, int s) {
        int[] distance_array = new int[v];
        Arrays.fill(distance_array, INF);
        distance_array[s] = 0;
        return distance_array;
    }

    public void printDistance(int[] D, int s) {
        System.out.printf("정점 %d 부터의 거리", s);
        System.out.println();
        for (int i = 0; i < D.length; i++)
            if (i != s) {
                System.out.printf("%d번 점: %d", i, D[i]);
                System.out.println();
            }
    }
}
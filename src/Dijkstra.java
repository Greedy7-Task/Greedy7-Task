import java.util.Arrays;
import java.util.stream.IntStream;

public class Dijkstra implements ShortestPath {
    @Override
    public int[] find_ShortestPath(int[][] G, int s) {
        int vertex = G.length;
        int[] D = init(vertex, s);
        boolean[] visited = new boolean[vertex];

        // IntStream.of(D).anyMatch(x -> x == INF)
        while (true) {
            int min = INF;
            int min_Index = -1;

            for (int a = 0; a < vertex; a++)
                if (!visited[a] && min > D[a]) {  // 방문하지 않았고, 거리가 무한이 아니고, 전보다 가까이 있으면
                    min_Index = a;
                    min = D[a];
                }
            if (min_Index == -1)
                break;
            visited[min_Index] = true;

            // 4. 최단거리 갱신
            for (int i = 0; i < vertex; i++) {
                if (!visited[i] && INF > D[i]) {

                }
            }

            for (int j = 0; j < vertex; j++)
                if (!visited[j] && G[min_Index][j] != 0 && D[min_Index] + G[min_Index][j] < D[j]) {
                    D[j] = D[min_Index] + G[min_Index][j];
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

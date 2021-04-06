import java.util.Arrays;
import java.util.stream.IntStream;

public class Dijkstra implements ShortestPath {
    @Override
    public int[] find_ShortestPath(int[][] G, int s) {
        int vertex = G.length;
        int[] D = init(vertex, s);
        boolean[] visited = new boolean[vertex];
        int[] parent = new int[vertex];

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


            for (int next = 0; next < vertex; next++)
            {


                if (!visited[next] || INF == D[next])
                    continue;
                // 이미 방문했거나 연결되지 않은 정점 스킵

                //새로 조사한 정점의 최단 거리 계산
                int w = D[min_Index] + D[next]; //새로 조사한 정점까지의 거리 = V_min까지의 거리+ 가중치
                //만약 기존 최단 거리가 새로 조사한 최단거리보다 크면 갱신

                if (w < D[min_Index])
                {
                    D[next] = w;
                    parent[next] = min_Index; //출발 정점으로부터의 최단거리 = 새로 나온 거리

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

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra implements ShortestPath {
    private int n;
    int s = 0;
    private int a;

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

    @Override
    public void convert(int[][] G) {
        this.n = n;
        int[] D = new int [n+1];//배열 d에는 거리의 최소값 저장
        boolean[] visited = new boolean[n+1]; //방문한 점(인접한 점과 거리가 최소인 점)


        //방문하지 않은 점(거리가 확정되지 않은 점) 찾아서 최소값 D[v]에 거리 확정하기
        for(int a = 0; a < n+1; a++) {
            int min_Index = -1;//최소 가중치가 저장된 배열 D의 인덱스 값(유효하지 않은 인덱스 저장 X)
            int min = Integer.MAX_VALUE;//확정되지 않은 점의 가중치는 무한대로 초기화한다.

            for (int i = 0; i < n + 1; i++) {
                if (!visited[i] && min > D[i]){
                    min_Index = i;
                    min = D[i];

            }
        }

        }

    }

}

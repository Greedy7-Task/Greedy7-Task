import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("정점의 개수를 입력하세요: ");
        int n = scan.nextInt();
        int[][] G = new int[n][n];  // n = 점의 개수, m = 간선의 개수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int element = 0;
                if (i == j)
                    G[i][j] = element;
                else {
                    int random = (int) (Math.random() * 4);
                    if (random == 0)
                        element = Integer.MAX_VALUE;
                    else
                        element = (int) (Math.random() * 9) + 1;
                    G[i][j] = element;
                    G[j][i] = element;
                }
            }
        }
        System.out.printf("시작 정점 번호(0~%d): ", n - 1);
        int start = scan.nextInt();

        Dijkstra dijkstra = new Dijkstra();
        int[] answer = dijkstra.find_ShortestPath(G, start);
        dijkstra.printDistance(answer, start);
    }
}

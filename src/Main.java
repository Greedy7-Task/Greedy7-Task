import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("정점의 개수를 입력하세요: ");
        int n = scan.nextInt();
        System.out.printf("시작 정점 번호(0~%d): ", n - 1);
        int start = scan.nextInt();

        int startTime = (int) System.currentTimeMillis();
        int[][] G = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int element = 0;
                if (i == j) {
                    G[i][j] = element;
                } else {
                    int random = (int) (Math.random() * 3);
                    if (random == 0) {
                        element = Integer.MAX_VALUE;
                    } else {
                        element = (int) (Math.random() * 49) + 1;
                    }
                    G[i][j] = element;
                    G[j][i] = element;
                }
            }

        Dijkstra dijkstra = new Dijkstra();
        int[] answer = dijkstra.find_ShortestPath(G, start);
        dijkstra.printDistance(answer, start);

        int endTime = (int) System.currentTimeMillis();
        int processTime = endTime - startTime;
        System.out.printf("수행 시간: %d sec, %d ms",processTime/1000, processTime % 1000);
    }
}

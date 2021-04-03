import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("정점의 개수를 입력하세요: ");
        int n = scan.nextInt();
        int[][] G = new int[n][n];  // n = 점의 개수, m = 선분의 개수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int element = 0;
                if (i == j)
                    G[i][j] = element;
                else {
                    element = (int) (Math.random() * 9) + 1;
                    G[i][j] = element;
                    G[j][i] = element;
                }
            }
        }


    }
}

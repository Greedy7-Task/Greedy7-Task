package mst;
//import mst.Graph;
import java.util.Scanner;
import java.lang.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] G = new int[n][n]; // n = 점의 개수, m = 선분의 개수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                G[i][j] = (int) (Math.random() * 10);
                System.out.print(G[i][j]+" ");

            }
            System.out.println();

        }


    }
}

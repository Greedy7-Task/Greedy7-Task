# Greedy7-Task


다익스트라 알고리즘의 특징 

1. 출발점이 주어진다.
2. 출발점으로부터 최단 거리가 확정되지 않은 점들 중에서 가장 가까운 점을 추가한 후에 최단 거리를 확정한다.

위의 내용을 간단한 그림으로 표현하면 아래와 같은 그림이다.

![](https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODAxMjNfMTA5%2FMDAxNTE2NzAxNDI5NjI5.VD9gYdLpyA4ZB0w9VKFR0k-neSOgDqSlYIGQxh1PdVYg.Ez2Eyg8E-ejPRlNGrX47syinhhS4xAD4xJJ_PNUEuVIg.JPEG.h111922%2F%25B0%25E6%25B7%25CE%25B1%25D7%25B8%25B2.JPG&type=sc960_832)

start점에서 시작하고 나머지 a,b,fin 사이의 거리는  무한대로 초기화 하여 점 간의 거리를 확정하지 않은 상태에서 최솟값을 찾아 나가는 알고리즘이다.




다음은 코드에 대한 상세 설명으로 이는 각 부분을 맡은 사람이 작성하였다.
책 p.108에 나와 있는 의사코드를 바탕으로 팀원들 끼리의 과업을 분배하였다.






1번 설명







```java
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
```


위의 코드는 거리가 확정되지 않은 점들의 거리를 무한대로 초기화하는 점이다. min_Index는 현재점이 출발점이면 유효하지 않으므로 -1이라고 한다. 
만약 a라는 점을 방문하지 않았고 해당 점과 출발점 사이의 거리가 무한대보다 작다면 min_Index는 a로 하고, 점 a와 출발점 사이의 거리(최솟값)를 배열 D에 갱신한다.

min_Index는 처음에만 -1이어야하기 때문에 min_Index가 -1인경우 while문을 탈출한다.
그리고 거리가 확정된 점들은 방문한 점이 된다. 이제 현재 점에서 방문하지 않은 점 즉, 거리가 확정되지 않은 점들에 대해서 거리를 확정하는 코드를 보자.








4번 설명









이론 상 다익스트라 알고리즘의 시간 복잡도를 알아보자.
최소 거리를 가지는 점을 찾는데 1차원 배열 D에서 최솟값을 찾는 것이므로 O(n)시간이 걸리고, 최소거리를 갖는 점에 연결되는 점의 수는 최대 n-1개이므로, 배열 D를 개인하는데 걸리는 시간은 O(n)dldek.
따라서 해당 알고리즘의 이론 상 시간 복잡도는 (n-1)*{O(n)+O(n)} = O(n^2)이다.

이론과 팀이 짠 코드의 시간 복잡도를 비교하기 위해서 실제 시간 복잡도를 그래프로 나타내 보았다. 다음은 실제 팀7이 구현한 알고리즘의 시간복잡도를 나타낸 그래프 이다.
![](그래프 주소)
위의 그래프는 점근적으로 O(n^2)과 일치한다. //일치 안하면 뺌





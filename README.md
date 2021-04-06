# Greedy7-Task


## 다익스트라 알고리즘의 특징 

1. 출발점이 주어진다.
2. 출발점으로부터 최단 거리가 확정되지 않은 점들 중에서 가장 가까운 점을 추가한 후에 최단 거리를 확정한다.

위의 내용을 간단한 그림으로 표현하면 아래와 같은 그림이다.

![](https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODAxMjNfMTA5%2FMDAxNTE2NzAxNDI5NjI5.VD9gYdLpyA4ZB0w9VKFR0k-neSOgDqSlYIGQxh1PdVYg.Ez2Eyg8E-ejPRlNGrX47syinhhS4xAD4xJJ_PNUEuVIg.JPEG.h111922%2F%25B0%25E6%25B7%25CE%25B1%25D7%25B8%25B2.JPG&type=sc960_832)

start점에서 시작하고 나머지 a,b,fin 사이의 거리는  무한대로 초기화 하여 점 간의 거리를 확정하지 않은 상태에서 최솟값을 찾아 최단경로를 확정하는 알고리즘이다.


## 코드 설명

다음은 코드에 대한 상세 설명으로 이는 각 부분을 맡은 사람이 작성하였다.
책 p.108에 나와 있는 의사코드를 바탕으로 팀원들 끼리의 과업을 분배하였다.

---

### ShortestPath.java (최종민 구현)

```java
public interface ShortestPath {
    int INF = Integer.MAX_VALUE;

    int[] find_ShortestPath(int[][] G, int s);
    int[] init(int v, int s);
    void printDistance(int[] D, int s);
}
```

`INF`는 `Integer.MAX_VALUE`를 넣어 무한대를 나타내는 상수를 선언하였다.
그리고 최단 경로를 찾는 메소드 `find_ShortestPath(int[][] G, int s)`, 배열 `D`를 초기화하는 `init(int v, int s)`과 시작점으로부터의 거리를 저장한 `D`의 값을 출력해주는 메소드들의 원형이다.

### Main.java (최종민 구현)

이 파일의 `Main` 클래스에 `public static void main(String[] args)` 메소드에 관한 설명이다.
```java
	Scanner scan = new Scanner(System.in);
        System.out.print("정점의 개수를 입력하세요: ");
        int n = scan.nextInt();
        System.out.printf("시작 정점 번호(0~%d): ", n - 1);
	int start = scan.nextInt();
```

`Scanner` 클래스를 이용해 점의 개수를 변수 `n`에 입력받는다.
또한 이를 이용해 변수 `start`에 출발점이될 점의 인덱스를 입력받는다.

```java
	int[][] G = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int element = 0;
                if (i == j) {
                    G[i][j] = element;
                } else {
                    int random = (int) (Math.random() * 4);
                    if (random == 0) {
                        element = Integer.MAX_VALUE;
                    } else {
                        element = (int) (Math.random() * 9) + 1;
                    }
                    G[i][j] = element;
                    G[j][i] = element;
                }
            }
```

그래프 `G`를 인접행렬로 나타내기 위해 `n` by `n` 2차원 배열을 선언한다.
그래프 `G`는 무방향 그래프이므로, 대칭행렬로 나타내주기 위해 `G[i][j]`와 `G[j][i]`에 같은값인 난수를 발생해 넣어준다.
그리고 직접 연결되어 있는 정점을 제외하고는 모두 무한대로 나타내기 위해 변수 `random`에 0부터 4까지의 난수가 발생되도록 했다.
`random`이 0일 때만 `Integer.MAX_VALUE`를 넣어 무한대를 표현하고, 따라서 1/5 확률로 직접 두 점이 연결되어 있지 않게 된다.
`random`이 0이 아닐때, 1부터 10의 난수를 넣어 직접 연결된 두 점의 사이의 거리를 표현했다.

```java
        Dijkstra dijkstra = new Dijkstra();
        int[] answer = dijkstra.find_ShortestPath(G, start);
        dijkstra.printDistance(answer, start);
```

`Dijkstra.java` 파일에 정의되어 있는 `Dijkstra` 클래스의 `dijkstra.find_ShortestPath(G, start)` 메소드를 호출한다.

```java
        int startTime = (int) System.currentTimeMillis();
		
	...
		
	int endTime = (int) System.currentTimeMillis();
        int processTime = endTime - startTime;
        System.out.printf("수행 시간: %d sec, %d ms",processTime/1000, processTime % 1000);
```

알고리즘 성능 분석을 위해 이 프로그램이 실행되는데 걸리는 시간을 측정하고자 한다.
`(int) System.currentTimeMillis()`는 현재 시간을 측정하는 메소드다.
따라서 `Dijkstra` 알고리즘을 수행하기 전과 후에 각각 `startTime`, `endTime`이라는 변수에 저장해, 두 변수의 차를 이용하여 프로그램이 수행하는데 걸리는 시간 `processTime`을 계산한다.
계산한 `processTime`을 `System.out.printf()` 메소드를 이용해 출력한다.

## Dijkstra.java

#### 1번 설명 (최종민 구현)

```java
	public int[] find_ShortestPath(int[][] G, int s) {
	int vertex = G.length;
        int[] D = init(vertex, s);
      
	...
```

`find_ShortestPath()` 메소드는 그래프를 나타내는 2차원 배열 `G`와 시작점의 인덱스인 `s`를 매개변수로 받아온다.
`G`의 열의 개수가 점의 수와 같으므로(행으로 연산해도 같은 값을 얻을 수 있다), `G.length` 메소드를 호출해 점의 개수를 나타내는 변수 `vertex`에 저장한다.
`D`는 시작점을 기준으로 각 점들까지의 최단 거리를 저장하는 1차원 배열이다.
`init()` 메소드를 호출해 `init()`에서 만들어진 배열의 주소를 `D`가 가리키게 한다.


#### 2번,3번 설명(이채원 구현)

```java

	 boolean[] visited = new boolean[vertex];
	 
while (true) {
            int min = INF;
            int min_Index = -1;

            for (int a = 0; a < vertex; a++)
                if (!visited[a] && min > D[a]) {  
                    min_Index = a;
                    min = D[a];
                }
            if (min_Index == -1)
                break;
            visited[min_Index] = true;
```

`visited`는 방문한 점을 `true`로 표시하는 `boolean` 타입의 1차원 배열이다. `while`문은 출발점 `s`로부터 최단 거리가 확정되지 않은 점이있으면 아래의 `for`문을 반복하는 것이다. 
`min`은 최단 거리로 모든 점들간의 거리를 `INF`로 초기화한다. `min_Index`는 현재점이 출발점이면 유효하지 않으므로 `-1`로 초기화한다.
만약 a라는 점을 방문하지 않았고 해당 점과 출발점 사이의 거리가 무한대보다 작다면 `min_Index`는 `a`로 확정하고, 점 a와 출발점 사이의 거리(최솟값)를 1차원 배열`D`에 갱신한다.
`min_Index`는 처음에만 `-1`이어야하기 때문에 `min_Index`가 `-1`인경우 `while`문을 탈출한다. 거리가 확정된 점들은 방문한 점이 된다.




### 4번 설명(김민지)




 
#### `init()`과 `printDistance()` (최종민 구현)

```java
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
```

위의 `init()` 메소드가 정의되어 있는 부분과 `Main.java` 파일의 `main` 메소드에서 수행 시간을 출력하는 `printDistance()` 메소드가 정의되어 있는 부분이다.
`init()`은 점의 개수 `v`와 시작점의 인덱스 `s`를 매개변수로 받아온다.
`D`가 무한대로 초기화 되어야 하므로, 무한대를 나타내는 상수인 `INF`를 `distance_array`의 모든 원소에 저장한다.
그리고 시작점인 `distance_array[s]`에는 0으로 초기화한다.
그리고 `distance_array`를 리턴한다.

`printDistance()`는 시작점인 `s`번째 인덱스를 제외하고 모든 점들과의 거리를 출력하는 메소드이다.
따라서 `if`문을 사용해 `i`가 `s`가 아닐 때만 거리를 출력하도록 설계했다.

---









## 성능 검사

### 시간 복잡도(이채원)
다익스트라 알고리즘의 시간 복잡도를 알아보자.
최소 거리를 가지는 점을 찾는데 1차원 배열 D에서 최솟값을 찾는 것이므로 O(n)시간이 걸리고, 최소거리를 갖는 점에 연결되는 점의 수는 최대 n-1개이므로, 배열 D를 개인하는데 걸리는 시간은 O(n).
따라서 해당 알고리즘의 시간 복잡도는 (n-1)*{O(n)+O(n)} = O(n^2)이다.

위의 시간복잡도와 팀이 짠 코드의 시간 복잡도를 비교하기 위해서 실제 시간 복잡도를 그래프로 나타내 보았다. 다음은 실제 팀7이 구현한 알고리즘의 시간복잡도를 나타낸 그래프 이다. 

![](https://postfiles.pstatic.net/MjAyMTA0MDZfMjMy/MDAxNjE3NzEzMzAxODQz.E_xlE5ygjEN_46RNBRxrFNBAmsbrmBFqBTpxAZbdjfAg.NFXTRsCZem3Tm4ARtfn46YbFRlyxSrP1cXq0MBx5H1og.PNG.codnjs060/image.png?type=w773)

위의 그래프는 O(n^2)의 형태로 표현된다.




출처 

그림 - 네이버 블로그 <https://blog.naver.com/h111922/221191766325>

책- 알기쉬운 알고리즘, 생능 출판사, 양성봉 



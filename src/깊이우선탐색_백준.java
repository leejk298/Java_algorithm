import java.util.*;

/*
5 5 1
1 4
1 2
2 3
2 4
3 4
 */

public class 깊이우선탐색_백준 {
    static int N, M, S, num;    // 크기, 시작점, 탐색 순서
    static List<Integer>[] A;   // 인접리스트
    static boolean[] visited;   // 방문배열
    static int[] order; // 탐색 순서배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 정점
        M = sc.nextInt();   // 엣지
        S = sc.nextInt();   // 시작점
        num = 1;    // 탐색 순서

        // 초기화
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N + 1];

        for(int i = 1; i <= N; i++) // 정점 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            int s = sc.nextInt();   // 시작
            int e = sc.nextInt();   // 끝

            A[s].add(e);    // 무방향
            A[e].add(s);
        }

        for(int i = 1; i <= N; i++) // 정점 개수만큼
            Collections.sort(A[i]); // 오름차순 정렬
    }

    public static void DFS(int v) { // DFS

        visited[v] = true;  // 방문여부 갱신
        order[v] = num++;   // 탐색 순서 저장

        for(int i = 0; i < A[v].size(); i++) {  // 인접리스트 순회
            int next = A[v].get(i); // 다음 정점

            if(!visited[next])  // 방문하지 않았으면
                DFS(next);  // DFS
        }
    }

    public static void printOrder() {   // 탐색 순서 출력

        for(int i = 1; i <= N; i++) // 정점 개수만큼
            System.out.println(order[i]);   // 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        DFS(S); // DFS

        printOrder();   // 탐색 순서 출력
    }
}
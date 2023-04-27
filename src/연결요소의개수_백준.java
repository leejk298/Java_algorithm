import java.util.*;

/*
6 5
1 2
2 5
5 1
3 4
4 6
 */

public class 연결요소의개수_백준 {
    static int N, M;    // 크기
    static List<Integer>[] A;   // 인접리스트
    static boolean[] visited;   // 방문배열

    public static void init() { // 초기화
        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 노드
        M = sc.nextInt();   // 엣지

        // 초기화
        A = new List[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++) // 노드 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            int S = sc.nextInt();   // 시작
            int E = sc.nextInt();   // 끝

            A[S].add(E);    // 무방향
            A[E].add(S);
        }
    }

    public static void DFS(int v) { // DFS
        visited[v] = true;  // 방문여부 갱신

        for(int i : A[v])   // 인접리스트를 순회하면서
            if(!visited[i]) // 방문하지 않았으면
                DFS(i);     // DFS
    }

    public static void main(String[] args) {

        init(); // 초기화

        int count = 0;  // 연결요소 개수
        for(int i = 1; i <= N; i++) {   // 노드 개수만큼
            if(!visited[i]) {   // 방문하지 않았으면
                DFS(i);     // DFS
                count++;    // 개수 카운트
            }
        }

        System.out.println(count);  // 결과 출력
    }
}

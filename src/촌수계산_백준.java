import java.util.*;

/*
9
7 3
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6
 */

public class 촌수계산_백준 {
    static int N, M, S, E, D;   // 크기
    static List<Integer>[] A;   // 인접리스트
    static boolean[] visited;   // 방문배열

    public static void init() { // 초기화
        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 노드
        S = sc.nextInt();   // 시작
        E = sc.nextInt();   // 끝
        M = sc.nextInt();   // 엣지
        D = -1; // 촌수

        // 초기화
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for(int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            A[start].add(end);  // 무방향
            A[end].add(start);
        }
    }

    public static void DFS(int S, int depth) {  // DFS
        visited[S] = true;  // 방문여부 갱신

        if(S == E) {    // 종착지 찾으면
            D = depth;  // 촌수 계산

            return; // 함수 종료
        }

        for(int i = 0; i < A[S].size(); i++) {  // 인접리스트 개수만큼
            int next = A[S].get(i); // 다음 노드

            if(!visited[next])  // 방문하지 않았으면
                DFS(next, depth + 1);   // DFS
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        DFS(S, 0);  // DFS

        System.out.println(D);  // 촌수 출력
    }
}

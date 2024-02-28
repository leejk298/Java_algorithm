import java.util.*;

/*
7
6
1 2
2 3
1 5
5 2
5 6
4 7
 */

public class 바이러스_백준 {
    static int N, M;    // 크기
    static List<Integer>[] A;   // 인접리스트
    static boolean[] visited;   // 방문배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 노드
        M = sc.nextInt();   // 엣지

        // 초기화
        visited = new boolean[N + 1];
        A = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) // 인접리스트 구현
            A[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            int S = sc.nextInt();   // 시작
            int E = sc.nextInt();   // 끝

            A[S].add(E);    // 무방향
            A[E].add(S);
        }
    }

    public static void DFS(int v) { // DFS

        visited[v] = true;  // 방문여부 갱신

        for(int i : A[v])   // 인접리스트 순회하면서
            if(!visited[i]) // 방문하지 않았으면
                DFS(i);      // DFS
    }

    public static int countVirus() {   // 바이러스 개수

        int count = 0;  // 개수

        for(int i = 2; i <= N; i++) // 2부터
            if(visited[i])  // 방문하였으면
                count++;     // 개수 카운트

        return count;   // 개수 리턴
    }

    public static void main(String[] args) {

        init(); // 초기화

        DFS(1); // DFS, 1번노드

        System.out.println(countVirus());   // 바이러스 개수 출력
    }
}

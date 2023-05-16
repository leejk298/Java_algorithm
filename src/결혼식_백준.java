import java.util.*;

/*
6
5
1 2
1 3
3 4
2 3
4 5
 */

public class 결혼식_백준 {
    static int N, M;    // 크기
    static List<Integer>[] A;   // 인접리스트
    static boolean[] visited;   // 방문배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 노드
        M = sc.nextInt();   // 엣지

        // 초기화
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for(int i = 0; i < M; i++) {
            int s = sc.nextInt();   // 시작
            int e = sc.nextInt();   // 끝

            A[s].add(e);    // 무방향
            A[e].add(s);
        }
    }

    public static void DFS(int v, int depth) {  // DFS

        visited[v] = true;  // 방문여부 갱신

        if(depth == 2)  // 친구의 친구까지
            return;

        for(int i = 0; i < A[v].size(); i++) {  // 인접리스트 개수만큼
            int next = A[v].get(i); // 다음 노드
            DFS(next, depth + 1);   // DFS
        }
    }

    public static void printIsInvite() {    // 초대가능한 친구

        int count = 0;  // 개수

        for(int i = 2; i <= N; i++) // 2번부터
            if(visited[i])  // 방문했으면
                count++;    // 개수 카운트

        System.out.println(count);  // 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        DFS(1, 0);  // DFS, 1번 노드

        printIsInvite();    // 출력
    }
}

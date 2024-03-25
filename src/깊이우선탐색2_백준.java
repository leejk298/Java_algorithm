import java.util.*;
import java.io.*;

/*
5 5 1
1 4
1 2
2 3
2 4
3 4
 */

public class 깊이우선탐색2_백준 {
    static int N, M, S, num;    // 크기, 시작점, 탐색 순서
    static List<Integer>[] A;   // 인접리스트
    static int[] order;         // 탐색 순서배열
    static boolean[] visited;   // 방문배열

    public static void init() throws IOException { // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 엣지 개수
        S = Integer.parseInt(st.nextToken());   // 시작점
        num = 1;    // 탐색 순서, 1번 노드부터 시작하므로

        A = new ArrayList[N + 1];   // 인접리스트 초기화
        order = new int[N + 1];     // 탐색 순서배열
        visited = new boolean[N + 1];   // 방문배열

        for (int i = 1; i <= N; i++)    // 정점 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for (int i = 0; i < M; i++) {    // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int s = Integer.parseInt(st.nextToken());   // 시작점
            int e = Integer.parseInt(st.nextToken());   // 도착점

            A[s].add(e);    // 양방향
            A[e].add(s);
        }

        for (int i = 1; i <= N; i++) // 정점 개수만큼
            Collections.sort(A[i], Collections.reverseOrder()); // 내림차순 정렬, 노드 번호가 높은 순으로 탐색
    }

    public static void DFS(int v) { // DFS

        if (visited[v])  // 베이스케이스: 이미 방문했으면
            return;      // 리턴

        // 재귀케이스: 방문하지 않았으면
        visited[v] = true;  // 방문여부 갱신
        order[v] = num++;   // 탐색 순서 저장

        for (int next : A[v])   // 인접리스트 순회
            if (!visited[next]) // 다음 노드가 방문하지 않았으면
                DFS(next);  // 재귀콜, 다음 노드로 DFS
    }

    public static void printOrder() {   // 출력

        for (int i = 1; i <= N; i++) // 정점 개수만큼
            System.out.println(order[i]);   // 탐색 순서 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        DFS(S); // DFS

        printOrder();   // 탐색 순서 출력
    }
}
